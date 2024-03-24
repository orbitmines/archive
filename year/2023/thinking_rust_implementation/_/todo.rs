
const WASM: &[u8] = include_bytes!("add.wasm");

async fn run_async() -> Result<(), JsValue> {
    console_log!("instantiating a new wasm module directly");

    let result = JsFuture::from(WebAssembly::instantiate_buffer(WASM, &Object::new())).await?;
    let instance: WebAssembly::Instance = Reflect::get(&result, &"instance".into())?.dyn_into()?;

    let exports = instance.exports();

    let add = Reflect::get(exports.as_ref(), &"add".into())?
        .dyn_into::<Function>()
        .expect("add export wasn't a function");

    let three = add.call2(&JsValue::undefined(), &1.into(), &2.into())?;
    console_log!("1 + 2 = {:?}", three);

    let memory = Reflect::get(exports.as_ref(), &"memory".into())?
        .dyn_into::<WebAssembly::Memory>()
        .expect("memory export wasn't a `WebAssembly.Memory`");

    console_log!("{:?}", memory.buffer().as_string());
    console_log!("created module has {} pages of memory", memory.grow(0));
    console_log!("giving the module 4 more pages of memory");
    memory.grow(4);
    console_log!("now the module has {} pages of memory", memory.grow(0));

    Ok(())
}

#[wasm_bindgen(start)]
pub fn run() {
    spawn_local(async {
        run_async().await.unwrap_throw();
    });
}


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
