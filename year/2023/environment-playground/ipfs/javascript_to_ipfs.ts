import {CID} from "multiformats/cid";
import {IPFS} from "ipfs-core-types";
import {ArbitraryValue} from "../../FunctionalEquivalence";
import _ from "lodash";

export default class Javascript_to_ipfs {

  transform = async (value: any, seen = new WeakMap<any, CID>()): Promise<CID> => {
    value = await value; // Get rid of possible promise.

    if (value === undefined) // ?
      value = null;

    if (value instanceof CID)
      return value;

    if (seen.has(value)) {
      return seen.get(value) as CID;
    }

    let cid: CID;
    if (_.isFunction(value)) {
      // TODO: Better resolvable javascript functions
      cid = await this.transform("/javascript/function/" + value.name, seen);
    } else if (_.isArray(value)) {
      cid = await this.cid(await Promise.all(
        value.map(element => this.transform(element, seen))
      ));
    } else if (_.isObject(value)) {
      let object =
        // Sort by key name to always ensure the entries are always in the same order for an object (; order isn't ensured)
        _.sortBy(
          _.filter(
            _.entries(value),
            ([key, value]) => !key.startsWith('__') // TODO: This should only be temporary for React shenanigans
          ),
          ([key, value]) => key);

      cid = await this.transform(object);
    } else {
      cid = await this.cid(value);
    }

    // TODO WEAKMAP Not working for stings & others
    try {
      seen.set(value, cid);
    } catch {}

    return cid;
  }
}