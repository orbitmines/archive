import Node from "./Node";
import ArbitraryValue, {ArbitraryEdge} from "./ArbitraryValue";
import {CID} from "multiformats";
import {IPFS} from "ipfs-core-types";

export default class Store extends Node<IPFS> {
  /**
   * TODO: Links should have Tsize?: https://github.com/ipld/js-dag-pb/issues/5
   *
   *
   * @protected
   */

  get ipfs(): IPFS { return this._value };

  parse_reference = (reference: string): CID => CID.parse(reference);

  get = async (reference: CID): Promise<ArbitraryValue> => {
    const { value } = await this.ipfs.dag.get(reference, {

    }); // TODO, WE CAN OPTIMIZE TO MAKE USE OF IPLD PATHS WITHIN OBJECT STRUCTURES

    return value;
  };

  put = async (value: Node): Promise<CID> => {
    return this.ipfs.dag.put(value.resolve_bindings(), {
      version: 1,
      pin: true,
      // hashAlg: 'sha256',
      // InterpreterCodec: 'dag-cbor',
      onlyHash: false,
      // signal: to abort
      // timeout: to abort (ms)
    });
  }

}