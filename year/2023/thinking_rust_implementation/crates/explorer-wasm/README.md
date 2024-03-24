
## 🔋 Batteries Included

* [`wasm-bindgen`](https://github.com/rustwasm/wasm-bindgen) for communicating
  between WebAssembly and JavaScript.
* [`console_error_panic_hook`](https://github.com/rustwasm/console_error_panic_hook)
  for logging panic messages to the developer console.
* [`wee_alloc`](https://github.com/rustwasm/wee_alloc), an allocator optimized
  for small code size.

```shell

```

```shell
cargo +nightly build \
  `# [Optimize libstd with build-std](https://github.com/johnthagen/min-sized-rust#optimize-libstd-with-build-std)` \
  -Z "build-std=std,panic_abort" \
  --target "wasm32-unknown-unknown" \
  `# https://github.com/rustwasm/wee_alloc` \
  --features "wee_alloc" \
  --release
```