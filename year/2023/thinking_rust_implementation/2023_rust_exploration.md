- [x] [Overview: The Rust Programming Language](https://doc.rust-lang.org/book/)
- [ ] WASM
  - [x] [Introduction: Rust & WASM](https://rustwasm.github.io/docs/book/)
  - [x] [wasm-bindgen](https://rustwasm.github.io/wasm-bindgen/)
  - [x] [wasm-pack](https://rustwasm.github.io/docs/wasm-pack/introduction.html)
  - [ ] [wasm-pack tools](https://rustwasm.github.io/docs/book/reference/tools.html)
  - [ ]
- [ ] [Rust by example](https://doc.rust-lang.org/stable/rust-by-example/)
- [ ] [Rustonomicon / Unsafe Rust](https://doc.rust-lang.org/nomicon/intro.html)
- [ ] [Unstable Rust / Nightly / Unstable/experimental features](https://doc.rust-lang.org/nightly/unstable-book/index.html)
- [x] [Rust Async](https://rust-lang.github.io/async-book/)
- [ ] [Rust Reference](https://doc.rust-lang.org/reference/index.html)
- [ ] [std](https://doc.rust-lang.org/std/index.html)
- [ ] [Rust editions](https://doc.rust-lang.org/edition-guide/index.html)
- [ ] [Cargo / package management system](https://doc.rust-lang.org/cargo/index.html)
- [ ] [Rustdoc / documentation](https://doc.rust-lang.org/rustdoc/index.html)
  - Generate Markdown docs & open in browser: `cargo doc --open` (; use for paper as well?)
- [ ] [Rustc / compiler](https://doc.rust-lang.org/rustc/index.html)
- [ ] [Compiler error index](https://doc.rust-lang.org/error-index.html)
- [ ] [Writing tests](https://doc.rust-lang.org/book/ch11-01-writing-tests.html)
- [ ] [In-depth Macros](https://veykril.github.io/tlborm/)
- [ ] https://surma.dev/things/rust-to-webassembly/index.html

---

---
Rust:

`unit` / `unit-like struct` : empty value : `()` | `struct Something;` ; empty tuple

`#[derive(Debug)]` & `dbg!(..)`

`Having a method that takes ownership of the instance by using just self as the first parameter is rare; this technique is usually used when the method transforms self into something else and you want to prevent the caller from using the original instance after the transformation.` --> This could be used when talking about a Node, changing itself.

Similar to rust, addressing superpositions like: `use std::{cmp::Ordering::{A, B}, io::{A, B}::{C}};`

`#[global_allocator]` can be used to reroute memory allocation (perhaps sit in between this?): https://doc.rust-lang.org/std/alloc/index.html

[UTF-8 in rust](https://doc.rust-lang.org/book/ch08-02-strings.html)

Using `enum` for arbitrary values.

use rust refs? or go outside language specific

`Cargo is designed so you can extend it with new subcommands without having to modify Cargo. If a binary in your $PATH is named cargo-something, you can run it as if it was a Cargo subcommand by running cargo something` --> Handy for package management commands.

Property description vs resolved property vs resolved property & recollection of what property was resolved.

Use async/await / futures. (; possible wasm translation)

---