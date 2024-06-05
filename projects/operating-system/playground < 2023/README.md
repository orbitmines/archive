

- [ ] https://os.phil-opp.com/
  - [x] [A Freestanding Rust Binary](https://os.phil-opp.com/freestanding-rust-binary/)
- [ ] https://github.com/rust-osdev
- [ ] https://doc.rust-lang.org/1.16.0/book/no-stdlib.html


```
.cargo/config.toml
[target.'cfg(target_os = "linux")']
rustflags = ["-C", "link-arg=-nostartfiles"]

[target.'cfg(target_os = "windows")']
rustflags = ["-C", "link-args=/ENTRY:_start /SUBSYSTEM:console"]

[target.'cfg(target_os = "macos")']
rustflags = ["-C", "link-args=-e __start -static -nostartfiles"]
```
