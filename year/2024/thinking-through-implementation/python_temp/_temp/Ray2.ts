import _ from "lodash";
import {NotImplementedError, PreventsImplementationBug} from "./errors/errors";
import {InterfaceOptions} from "./OrbitMinesExplorer";
import JS from "./JS";

export class Ray {

  static equivalent = Ray.Function.Impl((initial, terminal) => {

    /**
     * The simplest case, is where both sides are only aware of themselves (on .vertex). The only thing we need to do is turn an Orbit, to an Orbit which repeats every 2 steps, the intermediate step being the other thing.
     *
     * Or in textual terms something like:
     *  - A single Orbit:  `(A.self = A) | (B.self = B)`  (i.e. A.is_none && B.is_none)
     *  -             To:  `(A.self = B) | (B.self = A)`
     *
     * Basically turns `A` into a reference to `B`, and `B` into a reference to `A`.
     */
    const ignorant_equivalence = (): Ray.Any => {
      return initial.___ignorantly_equivalent(terminal);
    }

    // 2x Ray.None -> Turn into 2 empty references, referencing each-other.
    if (
      initial.dereference.is_none() && terminal.dereference.is_none()
      && !(initial.type === RayType.VERTEX && terminal.type === RayType.VERTEX)
    ) {
      // throw new PreventsImplementationBug(`${initial.type} / ${terminal.type}`)
      return ignorant_equivalence();
    }

    // Two structures, which have `ref.self = Ray.None` -> Turn into two structures which are on a line in between them.
    if (initial.dereference.is_none()) {
      const vertex = Ray.vertex().o({ js: '___as_vertex' }).as_reference().o({ js: '___as_vertex.#' });
      vertex.self.self = initial.self.as_arbitrary();
      initial.self.self = vertex.self.as_arbitrary();

      // initial.equivalent(terminal);
      // return terminal;
    }
    if (terminal.dereference.is_none()) {
      const vertex = Ray.vertex().o({ js: '___as_vertex' }).as_reference().o({ js: '___as_vertex.#' });
      vertex.self.self = terminal.self.as_arbitrary();
      terminal.self.self = vertex.self.as_arbitrary();

      // initial.equivalent(terminal.___as_vertex());
      // return terminal;
    }

    if (initial.is_boundary() && initial.dereference.is_boundary()) {
      throw new NotImplementedError();
      initial.as_terminal();
      //.follow(Ray.directions.previous).compose(terminal.dereference);
      // return terminal;
    }

    if (
      initial.dereference.type !== RayType.VERTEX
      || terminal.dereference.type !== RayType.VERTEX
      || initial.dereference.self === initial.self
      || terminal.dereference.self === terminal.self
    ) {
      throw new PreventsImplementationBug(`[${initial.type}]`)
    }

    if (Ray.directions.next(initial).type !== RayType.TERMINAL || Ray.directions.previous(terminal).type !== RayType.INITIAL) {
      throw new NotImplementedError();
      initial.dereference.push_back(terminal.dereference); // TODO: NON-PUSH-BACK VARIANT? (Just local splits?)
      return terminal;
      // throw new PreventsImplementationBug(`
      //   [${initial.type}](${initial.follow_direction().any.js})
      //   / [${initial.dereference.type}] {${[...initial.dereference.traverse()].map(ref => ref.self.follow_direction().any.js)}}
      //   -> ${terminal.type} (${terminal.follow_direction().any.js})
      //   / [${terminal.dereference.type}]`)
    }

    // if (terminal.self.any.js === 'D')
    //   throw new PreventsImplementationBug();

    initial.dereference.compose(terminal.dereference);

    return terminal;

    // initial.dereference.compose()
    // return terminal;
  });
  equivalent = Ray.equivalent.as_method(this);


    /**
     * .next
     */
      next = (step: Ray.FunctionImpl = Ray.directions.next): Ray.Any => {
        if (step(this).self.self.is_none())
          return Ray.None();

        let current = true;
        for (let ray of this.traverse(step)) {
          if (current) {
            current = false;
            continue;
          }
          return ray;
        }
        // return [...this.traverse(step)][1] ?? Ray.None(); // TODO BAD
        return Ray.None();
      }
      // @alias('end', 'result', 'back')
      last = (step: Ray.FunctionImpl = Ray.directions.next): Ray.Any => {
        const next = this.next(step);
        return next.is_some() ? next.last(step) : this;
      }


  static *traverse(options = {
    initial: Ray.Any.None,
    step: Ray.Any.directions.next,
    // branch: {
    //   // @alias('pruning', 'mapping', 'filtering')
    //   prune: (branches: Ray.Any): Ray.Any => branches,
    //   // @alias('next', 'selection', 'tactic', 'strategy')
    //   next: (branches: Ray.Any): Ray.Any => branches.first(),
    // }
  }): Generator<Ray.Any> {

    /**
     * An arbitrary Ray of (accessible) (possible) next steps to perform in traversal.
     */
    // @alias('cursor(s)', 'branch(es)', 'selection(s)')
    let branches: Ray.Any = Ray.step_function(options.step).as_ray(options.initial()); // TODO; This can be used to copy?
    let branch = branches;

    while (true) {
    //   /**
    //    * Branch *Pruning, Mapping, ..., Filtering*
    //    */
    //     branches = options.branch.prune(branches); // TODO: Could hold history
    //
    //   /**
    //    * Branch *Selection, Tactic, ..., Strategy*
    //    */
    //
    //     /**
    //      * An arbitrary Ray of (requested) next steps to perform in parallel/.../superposition (with respect to all the other branches).
    //      */
    //     const branches_to_traverse: Ray.Any = options.branch.next(branches);
    //
    //     /**
    //      * Make copies of our traversal for each selected branch
    //      */
    //     // TODO
    //
    //     /**
    //      * Split off traversal to each branch, selecting their respective .
    //      */
    //
    //   let branch: Ray.Any = branches_to_traverse; //TODO

      branch.self = branch.next().as_arbitrary();

      yield branch;

      if (branch.self.is_terminal())
        break;

      // After step, if IS_TERMINAL, nothing. assume halting (!!!at prune step ?)

      // const terminal = branch.follow();

      // branch.self = terminal;

      /**
       * if (branches.length === 0) {
       *           remove(pointers); // pointer,
       *         } else {
       *           ref.self = branches[0].as_arbitrary();
       *
       *           if (branches.length !== 1) {
       *             pointers.push(...branches.slice(1).map(b => Ray.Any.vertex(b.as_arbitrary())));
       *           }
       *         }
       */
    }

  }

}

//     default = (fn: () => any): any => self.match({
//         Some: (a) => a,
//         None: () => fn()
//     })
//
