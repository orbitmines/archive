

---

TODO
- [ ] Compiler optimizations: https://rustwasm.github.io/docs/book/game-of-life/code-size.html
- [ ] NPM publishing: https://rustwasm.github.io/docs/book/game-of-life/publishing-to-npm.html#publishing
- [ ] https://million.dev/docs/install ; react performance 

---

### Prerequisites
- Install [`wasm-pack`](https://rustwasm.github.io/wasm-pack/installer/)
    ```shell
    curl https://rustwasm.github.io/wasm-pack/installer/init.sh -sSf | sh
    ```

Build
--target web \
```shell
wasm-pack build \
  `# NPM Scope @orbitmines/*` \
  --scope orbitmines \
  ./crates/explorer-wasm/ \
  --release \
  -- \
  `# https://github.com/rustwasm/wee_alloc` \
  --features "wee_alloc"
```
