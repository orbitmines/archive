mod utils;
use std::fmt;

use wasm_bindgen::prelude::*;

use js_sys::{Array, Date};
use wasm_bindgen::prelude::*;
use web_sys::{Document, Element, HtmlElement, window, console};

// When the `wee_alloc` feature is enabled, use `wee_alloc` as the global
// allocator.
#[cfg(feature = "wee_alloc")]
#[global_allocator]
static ALLOC: wee_alloc::WeeAlloc = wee_alloc::WeeAlloc::INIT;

/// [wasm_bindgen(start)](https://rustwasm.github.io/wasm-bindgen/reference/attributes/on-rust-exports/start.html)
#[wasm_bindgen(start)]
pub fn main_from_wasm() -> Result<(), JsValue> {
  let window = window().expect("should have a window in this context");
  let document = window.document().expect("window should have a document");

  let array = Array::new();
  array.push(&"Hello".into());
  array.push(&1.into());

  Ok(())
}

#[wasm_bindgen]
extern "C" {
  fn alert(s: &str);
}

// A macro to provide `println!(..)`-style syntax for `console.log` logging.
macro_rules! log {
    ( $( $t:tt )* ) => (console::log_1(&format!( $( $t )* ).into()))
}

#[wasm_bindgen]
#[repr(u8)]
#[derive(Clone, Copy, PartialEq, Eq)]
pub enum Cell {
  Dead = 0,
  Alive = 1,
}

#[wasm_bindgen]
pub struct Universe {
  width: u32,
  height: u32,
  cells: Vec<Cell>,
}

impl fmt::Display for Universe {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
    for line in self.cells.as_slice().chunks(self.width as usize) {
      for &cell in line {
        let symbol = if cell == Cell::Dead { '◻' } else { '◼' };
        write!(f, "{}", symbol)?;
      }
      write!(f, "\n")?;
    }

    Ok(())
  }
}

#[wasm_bindgen]
impl Universe {
  pub fn new() -> Universe {
    utils::set_panic_hook();

    let width = 64;
    let height = 64;

    let cells = (0..width * height).map(|x| {
      if x % 2 == 0 || x % 7 == 0 {
        Cell::Alive
      } else {
        Cell::Dead
      }
    }).collect();

    Universe {
      width,
      height,
      cells,
    }
  }

  pub fn render(&self) -> String {
    self.to_string()
  }

  pub fn tick(&mut self) {
    let mut next = self.cells.clone();

    for row in 0..self.height {
      for col in 0..self.width {
        let idx = self.get_index(row, col);
        let cell = self.cells[idx];
        let live_neighbors = self.live_neighbor_count(row, col);

        let next_cell = match (cell, live_neighbors) {
          // Rule 1: Any live cell with fewer than two live neighbours
          // dies, as if caused by underpopulation.
          (Cell::Alive, x) if x < 2 => Cell::Dead,
          // Rule 2: Any live cell with two or three live neighbours
          // lives on to the next generation.
          (Cell::Alive, 2) | (Cell::Alive, 3) => Cell::Alive,
          // Rule 3: Any live cell with more than three live
          // neighbours dies, as if by overpopulation.
          (Cell::Alive, x) if x > 3 => Cell::Dead,
          // Rule 4: Any dead cell with exactly three live neighbours
          // becomes a live cell, as if by reproduction.
          (Cell::Dead, 3) => Cell::Alive,
          // All other cells remain in the same state.
          (otherwise, _) => otherwise,
        };

        next[idx] = next_cell;
      }
    }

    self.cells = next;
  }

  pub fn get_index(&self, row: u32, column: u32) -> usize {
    (row * self.width + column) as usize
  }
  pub fn live_neighbor_count(&self, row: u32, column: u32) -> u8 {
    let mut count = 0;
    for delta_row in [self.height - 1, 0, 1].iter().cloned() {
      for delta_col in [self.width - 1, 0, 1].iter().cloned() {
        if delta_row == 0 && delta_col == 0 {
          continue;
        }

        let neighbor_row = (row + delta_row) % self.height;
        let neighbor_column = (column + delta_col) % self.width;
        let idx = self.get_index(neighbor_row, neighbor_column);
        count += self.cells[idx] as u8;
      }
    }

    count
  }
}

#[wasm_bindgen]
pub fn greet(name: &str) {
  alert(&format!("Hello {}!", name));
}
