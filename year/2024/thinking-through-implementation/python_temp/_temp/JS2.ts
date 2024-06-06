
    /**
     * Constructs a class method accepting arbitrary structure.
     *
     * a.compose(b).compose(c) = [a, b, c].compose = abc.compose = [[a1, a2], b, c].compose = [[a1, a2], b, [c1, c2]].compose = [[a1, [[[a2]]], [[[[]]], []]], b, [[[]], [], [c]]].compose = ...
     */
    as_method = <TResult>(ref: Ray.Any): Method<Ray, TResult> => ((...any: Recursive<Ray.Any>): TResult => {
      if (any === undefined || any.length === 0)
        return this.step(ref);

      // TODO: This can be much better...
      const first = (recursive?: Recursive<T>): T | undefined => {
        if (recursive === undefined) return;
        // if (_.isObject(recursive)) return recursive as unknown as Ray;

        for (let r of recursive) {
          if (r === undefined) continue;
          if (_.isObject(r)) return r as unknown as T;

          // if (r instanceof Ray)
          //   throw new PreventsImplementationBug();

          // @ts-ignore
          const _first = first(r);
          if (_first)
            return _first;
        }
      }

      const _first = first(any);

      if (_first === undefined)
        return this.step(ref);

      const pointer = (new Ray({
        // @ts-ignore
        initial: () => ref,
        // @ts-ignore
        terminal: () => _first
      })) as unknown as T;

      return this.step(pointer);

      // TODO: ANY CASE
      // if (any.length === 1) {
      // }
    })

  }


}
