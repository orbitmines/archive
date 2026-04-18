// #![no_std]

extern crate alloc;

mod utils;
mod explorer;

use alloc::boxed::Box;
use wasm_bindgen::prelude::*;
use orbitmines_explorer::spec::{ArbitraryFunction, ArbitraryNode, Explorer, SuperPosition};
use js_sys::{Function, Object, Reflect, WebAssembly};
use wasm_bindgen::prelude::*;
use wasm_bindgen::JsCast;
use wasm_bindgen_futures::{spawn_local, JsFuture};

use crate::utils::set_panic_hook;

// When the `wee_alloc` feature is enabled, use `wee_alloc` as the global
// allocator.
#[cfg(feature = "wee_alloc")]
#[global_allocator]
static ALLOC: wee_alloc::WeeAlloc = wee_alloc::WeeAlloc::INIT;

#[wasm_bindgen]
extern "C" {
  fn alert(s: &str);
}

macro_rules! console_log {
    // Note that this is using the `log` function imported above during
    // `bare_bones`
    ($($t:tt)*) => (log(&format_args!($($t)*).to_string()))
}

// pub struct WasmExplorer {
// }
// impl Explorer for WasmExplorer {
//   fn _self(&self) -> Box<ArbitraryNode> {
//     todo!()
//   }
//
//   /// "Instantiation executes the module body itself, given definitions for all its imports. It initializes globals, memories and tables and invokes the module’s start function if defined. It returns the instances of the module’s exports." [https://webassembly.github.io/spec/core/intro/overview.html#:~:text=into%20two%20phases%3A-,Instantiation,-.%20A%20module%20instance]
//   /// As a call to a Function: one cannot necessarily guarantee non-local effects. Similarly, according to the WASM spec, at instantiation references to exports (; eg, possible interaction points) are created and possible 'start function' is called [ref]. One doesn't necessarily have ('direct') access to any of these possibly observable computations.
//   ///
//   fn interpret(&self, node: Box<ArbitraryNode>) -> Box<SuperPosition<ArbitraryFunction>> {
//     todo!()
//   }
// }

// Called by our JS entry point to run the example.
// #[wasm_bindgen]
// pub fn run() -> Result<(), JsValue> {
//   let test = A::new();
//   test._self();
//
//   set_panic_hook();
//
//     // Use `web_sys`'s global `window` function to get a handle on the global
//     // window object.
//     let window = web_sys::window().expect("no global `window` exists");
//     let document = window.document().expect("should have a document on window");
//     let body = document.body().expect("document should have a body");
//
//     // Manufacture the element we're gonna append
//     let val = document.create_element("p")?;
//     val.set_text_content(Some("Hello from Rust!"));
//
//     body.append_child(&val)?;
//
//   Ok(())
// }

//  From here we could bootstrap into JavaScript and execute arbitrary JavaScript, but for now, let's keep it at WASM.
