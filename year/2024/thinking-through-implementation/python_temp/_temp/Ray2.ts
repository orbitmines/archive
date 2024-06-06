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


  get reverse(): Ray.Any {
    const copy = this;//TODO.copy();

    // TODO: Do we do this lazy by default? Just using refs??? - Or abstract this elsewhere to decide what to do
    const swap = copy.initial;
    copy.initial = copy.terminal.as_arbitrary();
    copy.terminal = swap.as_arbitrary();
    // TODO: This doesn't actually work

    return copy;
  }

  *___next({
    step = Ray.directions.next,
  } = {}): Generator<Ray.Any> {
    for (let current of Ray.traverse({
      initial: this.as_arbitrary(),
      step
    })) {

      // TODO: You can do this non-locally with a pass over the history. This way it's local, but we''ll have to find a good example of why this might not go that well. (As this would match to any empty vertices, and maybe more)

      // TODO: Could also check for none..
      const previous = current.previous();

      if (previous.is_vertex() && !Ray.is_orbit(previous.self, current)) {
        yield previous;
      }
    }
  }
  *___map<T>(map: (vertex: Ray.Any) => T, {
    step = Ray.directions.next,
  } = {}): Generator<T> {
    for (let vertex of this.___next({step})) {
      yield map(vertex);
    }
  }

  static step_function = (
    step: Ray.FunctionImpl
  ): Ray.Function => {
    const step_from_boundary = (from: Ray.Any, to: Ray.Any): Ray.Any => {
      switch (to.type) {
        /**
         * Dereferencing is likely in many cases quickly subject to infinite stepping (similar to INITIAL -> INITIAL, TERMINAL -> TERMINAL, VERTEX -> VERTEX. (Could be that this means that there's no continuation, a self-reference defined here, or it's some mechanism of halting.)
         *
         * - TODO: Simple example of infinitely finding terminals, or a reference to 'nothing - infinitely'.
         * - TODO: If both are references, allow deref of both?
         */
        case RayType.REFERENCE: {
          throw new NotImplementedError();
        }

        /**
         * A possible continuation
         * INITIAL/TERMINAL -> possible previous  - TERMINAL.self.initial   (pass to step)
         * TERMINAL/INITIAL -> possible next      - INITIAL.self.terminal   (pass to step)
         */
        case RayType.TERMINAL: {
          return Ray.follow_direction[RayType.TERMINAL](to);
        }
        case RayType.INITIAL: {
          return Ray.follow_direction[RayType.INITIAL](to);
        }

        /**
         * This is the most interesting case: Many possible continuations (from the perspective of a boundary (INITIAL/TERMINAL)).
         *
         * NOTE:
         * - There are many ways of actually implementing this. This is one which ensures the checks needed to traverse arbitrary continuations is always local (with the trade-off that you can't disambiguate between structure on edges vs structure on vertices by default). Though this can be imposed with something else. (TODO)
         *
         * @see = TODO
         */
        case RayType.VERTEX: {
          // TODO: Could check if self.self is Orbit.

          /**
           * Simplest check, ensure we're coming from some place which splits into many branches
           * @see = TODO
           */
          if (Ray.is_orbit(from.self, to.self.self)) {
            // TODO: Branch to previous.next
            // this.next_pointer(Ray.directions.previous), this.next_pointer(Ray.directions.next)

            throw new NotImplementedError();
          }

          /**
           * This is the one which disallows structure on edges, and assumes a vertex it finds, necessarily as additional vertices we're looking for. (But we don't need to keep track of where we are like this ; TODO: Implement variant which checks back over branch.previous() to allow for this)
           * @see = TODO
           */
          if (
            to.dereference.is_boundary() // Whether there's a continuation defined on the vertex.
            && Ray.is_orbit(to.self, to.self.self.self)
          ) {
            // default pointer
            // const default_pointer = (): Ray.Any[] => {
            //           return pointer.terminal.is_none() ? [] : [pointer];
            //         }
            // TODO: Split of options.step(terminal) & new Ray({
            //                     initial: terminal.as_arbitrary(),
            //                     vertex: pointer.as_arbitrary(),
            //                     terminal: () => terminal.dereference
            //                   })
            throw new NotImplementedError();
          }

          return step(to);
        }
      }
    }

    return Ray.Function.WithMemory(
      to_step => {
        const to = to_step.dereference;

        throw new NotImplementedError();
        /**
         * Cannot determine what to do without context of where we are.
         */
        if (to.is_none()) {
          return Ray.None();
        }

        const from_step = to_step.previous(); // TODO ONLY NEEDS ONE-STEP MEMORY ; Or could be implemented as two values as each step, or???

        const from = from_step.dereference;

        switch (from.type) {
          case RayType.REFERENCE: {
            throw new NotImplementedError();//  previous.dereference,
          }
          case RayType.INITIAL:
          case RayType.TERMINAL: {
            return step_from_boundary(from, to);
          }
          case RayType.VERTEX: {
            return step(to);
          }
        }
      }
    );
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
