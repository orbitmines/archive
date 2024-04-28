import {BufferSource} from "stream/web";
import IBackend from "../../../_forgotten/IBackend";
import {AsyncArbitraryValue} from "../../../_forgotten/INode";

export default class WasmBackend implements IBackend<
  BufferSource
> {

  compute = async (instruction: BufferSource): AsyncArbitraryValue => {
    const memory = new WebAssembly.Memory({ initial: 10, maximum: 100 });
    memory.buffer.

    // TODO: Rewrite to accept MutableNode and start with instantiateStreaming
    const { instance, module } = await WebAssembly.instantiate(instruction, {
      // env: memory
    }); // TODO What is this importobject for?

    instance.exports

    // TODO; introduce mutable value? Gotta stop it from halting when we want to
  };

  // TODO: Inhibitory Model; validation
  validate = WebAssembly.validate;

}