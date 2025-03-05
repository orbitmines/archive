*Let's try for [[2025-12-31]] ; - Yearly excerpt of thoughts*

# Towards a Universal Language
**
###### Introduction

---

# UNPROCESSED
*Tread carefully, confusion abound*


---

Summarized:
- "Whenever you have one of something, what if you had more of that thing"
- "The halting of any part of any program is unknown. It is therefore a rephrasing of the problem of (1) how many resources you dedicate to which problem and (2) how you deal with intermediate results."
- Structure is innate, something more general than, yet similar to graphs


- filter/map/... as expressions/program on state?
- Partial equality confirmed up to,

- Differences between function looking for variable(s) or not
- From "location" to "data entry"
- ("Description which generates the thing I'm interested in" Generalized to keeping track of "equivalent (and smaller) programs")
- Better way of thinking about one-way referenced structure
- (Local) rewriting, Traversal (with superposed extremes as encoded directions?)
- [ ] Better notion of functions (non-terminating; orbits) & variables (; replacing structures with others matching either in that structure (;rewrite) or variable replacement (; replace on inaccessible abstrzaction level ; ex. no nice mappings))
	- Function as direction on "an unknown (optionally of some type/structure)"
	- Function as initial instantiated from some vertex
	- Functions as unrealized directions on any point
	- Composed functions in single step would be?
		- multiple initial in sequence suprrposed by composed vatiant?
	- Intermediate results pending change
		- descriptions, definitions, lazy functions, unresolved pointers, non-committal ignorance, awaiting function execution, questions, ..., conjectures. Or: We can point to things to which we don't yet have any (or a definitive) answer.


```ts
/**
 * Local rewriting ; local rules
 *
 *
 *
 *
 * Think more loosely about the ray's structure:
 * - Point to a function/program on some structure
 *  - How to think about this as a single function with intermediate steps.
 *      How is that different from applying same function in that direction?: Described on another level of description?
 *  - Requires "looking for" type information. Ex. Function looking for parameter
 *  - Requires: Point to entire graph without specifying where.
 *  - Requires: Point to everything in a graph collapsed to a point.
 *
 *
 *
 *  What about: Some structure, but superposed on others. Value A on all these B positions.
 *
 * - Control flow as partial pattern-matched on branching structure.
 *   - How to use outputs of results into new functions, then pattern-match on the combination of those functions with branches on results.
 *
 * - Merging, pattern-matching, copying, isomorphism, deleting
 *
 * - How does execution happen?
 *   - What about the expansion case which needs both add structure and replace a reference?
 *
 * Rethink in terms of central program which manages history, values, and control flow.
 *  - Not just thinking about structure.
 *
 *
 * Functions/Unrealized structure on location: Potential "Context"/Structure
 *    =
 * Additional structure on location
 *
 */
```


- Isomorphism under ignored directions how? - First need a better notion of the structure of a ray

- Each usage refers to many users, same structure for multiple selectors ; could also be separated from usual list of intersections like history.
	- Like ; Structure at points ehich is not relevant to crrtain kinds of probing: Say a numerical value on a node which does not influence the structure around the node.

- `.collapse` means order invariant I matching of result

- Given larger context something which uniquely indexes substructure (from some other location)

---

- [ ] How to think about non-realized functions usefully. Say coordinates to some non-realized geometrical space. (Similarly: locations of information and their retrieval)
- [ ] Type information + selection combination
- [ ] Canonicalization/deduplication

###### Function Repository
- Note that whenever you have a self-reference through operators. Either we break the recursion there through some implementation. Or we simply decide to stop orbiting. And say it could be any of these things, it could be any of some superposition of things.
- Initial + negative => terminal, terminal + negative => initial, initial/terminal => negative
###### After Restructure
- [ ] Factory (Version Control, Causal histories, ..., Compression): Setup to constantly grow whatever in-memory graph/equivalences are found, get to this place so we can start iterating on discovery functions. (Good notion of causal histories & orbits needs to be there)
	- [ ] Notion of queues, resources (storage, capabilities), ..., priorities
	- [ ] "Measure of how hard something is to do in parallel (or in some other structure generally)" - differentiability of [[Project - Indexing existing Abstract Models (2024-2025?)]]
	- [ ] Apply the same version control system on the version control system itself. 
- Exploration: Brute-force enumeration, unkowns drive curiosity, treating something as something it's not (what-if simulation), fuzzing, random changes, 
- [ ] Provide easy portability away from the current setup "Provide me with this and I'll recompile it into what you want"\

###### Examples
- Subtraction is more complicated than performing addition, for subtraction you need to know a length, unless you just cut something off without knowing how long it is.
- 2d grid expansion as an example base rewrite rule, "expand loop"
- Boolean: Normal way of thinking about a boolean is .orbit we assume modularity of booleans
- Numbers, Integers, base-n, fractions, floating point
	- .add integers: single equivalence (initial from one side, terminal from other side.) 
- Single point, all perspectives. Ref on initial, entire initial ref as the .self, what about "entire" under some maximum travel speed/steps (or some variant of that idea)
- Program language syntax
- Nested arrays as structure on the initials, different than a 2d grid. + How does this work with unrealized array functions, or realized ones? Like .at(index).
- differentiable between two points to arbitrary precision, how is it constructed?

###### Energy/Resources
- The larger the integer/fraction, the larger the number of digits in a fractal, the more structure you need to describe it ; (at least if you're not expressing it as a more simple program, but have to construct the actual number)
- Coherence is expensive? - Takes a lot of structure
- Names in language as a way of indexing hard-to-find things
- [ ] Memorization vs rerunning

###### Statements?
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction - Overlapping multiple levels of description
- Any symmetry must be breakable - any symmetry has some ignored assymetrical property ; Does not have to be the case from the perspective of the symmetry.

---

- collapse the loop/infinity with an extreme 
	- or-> Two branching pointers sent in opposite direction which annihilate when they cross each-other.


---

- Traversal: Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences
- Superposing Languages: Simultaneously having 'different levels of abstraction', superposing operators, 'multiple abstraction implementations', ..., simulation
- A Reprogrammable (Visual) Interface: Open inputs, outputs, compute substrate, ..., interfaces
- But what we can say is this: Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question.. whose rediscoverability is not entirely obvious. 

---

self reference in equiv ray means its not none  

selfref equiv ray how does it work for init/terminal  
  
equiv ray collapse.self  
  
equiv ray at intersection - then what does initial mean?  
  
different perspectives one object how?

Separated space vs "additional structure directions":

---

```ts
  
// () => Ray[]  
  
export type Ray = {  
  [TProperty in keyof Instance]: Ray;  
} & {  
  __object__: any;  
  __instance__: Instance;  
  readonly [n: number]: any;  
  (...args: any[]): any;  
  new (...args: any[]): any;  
} & Iterable<Ray> & AsyncIterable<Ray>  
  
  
class Instance {  
  
  // Usually inaccessible, yet additional structure  
  __object__: any  
  // Each Ray with a separate causal history  
  // Can have a history, but no current value  // TODO: Memorization through causal history  
  history: Ray  
  // Superposed type??  
  type: Ray  
  // What else is at this point ;  
  equivalences: Ray  
  // Unrealized functions which could be applied to this Ray  
  // How is this different from additional structure on .self? This as unrealized, .self as realized?  // TODO: Should this contain .initial & .terminal as functions? Or should this be  
  // TODO: Separated into another class  
  functions: Ray   
  // Iterate over possible representations: Matching is_equivalent/is_isomorphic  
  representations: Ray  
  
  
  
  static __new__ = (...args: any[]): Ray => new Instance(...args).__proxy__  
  
  __call__ = (...args: any[]): any => {  
    if (is_function(this.__object__)) return this.__object__(...args)  
  }  
  
  // A copy traverses the entire structure  
  // TODO: Send left/right copy simultaneously, and cancel each-other out  
  __copy__ = (...args: any[]): any => {  
    return Instance.__new__(...args)  
  }  
  
  __set__ = (property: string | symbol, value: any): boolean => {  
    if (property in this)  
      return (this as any)[property] = value;  
  
    return true;  
  }  
  __get__ = (property: string | symbol): any => {  
    if (property === "__instance__") return this;  
    if (property === Symbol.iterator || property === Symbol.asyncIterator || property === "__object__") return (this as any)[property]  

    if (property === 'initial' || property === 'terminal') return Instance.__new__()  
  
    return Instance.__new__({ __object__: (this as any)[property] });  
  }  
  __has__ = (property: string | symbol): boolean => {  
    return false;  
  }  
  __delete__ = (property: string | symbol): any => {  
    return false;  
  }  
  

  async *[Symbol.asyncIterator](): AsyncIterator<Ray> {  
  }
  
  orbit = () => this.last().compose(this.first())  
 
  
  // static unknown: Ray = new Ray(Symbol("unknown"))  
  // static none: Ray = new Ray(Symbol("none"))  

  variable = () => {  
    // TODO: Implement simple getter/setter structure  
  }  

  // toString = (): string => {  
  //   return "";  // }  
  get __proxy__(): Ray { return new Proxy(class {}, {  
    apply: (_: any, thisArg: any, argArray: any[]): any => this.__call__(...argArray),  
    set: (_: any, property: string | symbol, newValue: any, receiver: any): boolean => this.__set__(property, newValue),  
    get: (_: any, property: string | symbol, receiver: any): any => this.__get__(property),  
    has: (_: any, property: string | symbol): boolean => this.__has__(property),  
    construct: (_: any, argArray: any[], newTarget: Function): object => this.__copy__(...argArray),  
    deleteProperty: (_: any, property: string | symbol): boolean => this.__delete__(property)  
  }) }  
}  
  
```

```ts

class Ray implements Iterable<Ray> {


  get length(): number {
    if (!this.is_boundary()) return 1;

    return [...this].length // TODO: Handle cycles differently?
  }

  *[Symbol.iterator](): Iterator<Ray> {
    // if (!this.is_boundary()) return this;

    // TODO: Abstract away to use Rays instead
    // TODO: Cycle detection & merger

    // TODO: Might switch to index=0 being on VERTEX and adding left/right to iterable
    const queue: Ray[] = [this]
    while (queue.length !== 0) {
      const selected = queue.shift()

      switch (selected.type) {
        case Type.REFERENCE: {
          yield selected.self;
          break;
        }
        case Type.VERTEX: {
          yield selected.self
          break;
        }
        case Type.INITIAL: {
          // console.log('INITIAL', [...selected.terminal].length)
          for (let next of selected.terminal) {
            // console.log('VALUE', next.is_reference())

            switch (next.type) {
              case Type.REFERENCE:
                break;
              case Type.VERTEX:
                // console.log('VERTEX')
                yield next

                // TODO Better way for __terminal__; differentiate between setting Ray.ref & not
                queue.push(Ray.initial({ __terminal__: () => next.terminal }))
                break;
              case Type.INITIAL:
                // TODO: Could be self-loop
                queue.push(next)
                break;
              case Type.TERMINAL:
                queue.push(next)
                break;

            }
          }

          break;
        }
        case Type.TERMINAL: {
          for (let terminal of selected.self) {
            switch (terminal.type) {
              case Type.REFERENCE:
                break;
              case Type.VERTEX:
                // TODO Collapse branch
                break;
              case Type.INITIAL:
                queue.push(terminal)
                break;
              case Type.TERMINAL:
                queue.push(terminal) // TODO: Could be a self-loop
                break;

            }
          }
          break;
        }
      }

    }

  }

}
export default Ray;

//   indexOf(searchElement: T, fromIndex?: number): number {
//     return 0;
//   }
//
//   join(separator?: string): string {
//     return "";
//   }
//
//   pop(): T | undefined {
//     return undefined;
//   }
//
//   reduce(callbackfn: (previousValue: T, currentValue: T, currentIndex: number, array: T[]) => T): T;
//   reduce(callbackfn: (previousValue: T, currentValue: T, currentIndex: number, array: T[]) => T, initialValue: T): T;
//   reduce<U>(callbackfn: (previousValue: U, currentValue: T, currentIndex: number, array: T[]) => U, initialValue: U): U;
//   reduce(callbackfn, initialValue?): any {
//   }
//
//   reduceRight(callbackfn: (previousValue: T, currentValue: T, currentIndex: number, array: T[]) => T): T;
//   reduceRight(callbackfn: (previousValue: T, currentValue: T, currentIndex: number, array: T[]) => T, initialValue: T): T;
//   reduceRight<U>(callbackfn: (previousValue: U, currentValue: T, currentIndex: number, array: T[]) => U, initialValue: U): U;
//   reduceRight(callbackfn, initialValue?): any {
//   }
//
//   reverse(): T[] {
//     return [];
//   }
//
//   shift(): T | undefined {
//     return undefined;
//   }
//
//   sort(compareFn?: (a: T, b: T) => number): this {
//     return undefined;
//   }
//
//   splice(start: number, deleteCount?: number): T[];
//   splice(start: number, deleteCount: number, ...items: T[]): T[];
//   splice(start: number, deleteCount?: number, ...items: T[]): T[] {
//     return [];
//   }
//
//   unshift(...items: T[]): number {
//     return 0;
//   }
// }


```

// Separate function builder and functionality

```ts
  
class Ray implements Iterable<Ray> {  

  
  is_isomorphic = (b: Ray): boolean => {  
  
  }  
  equals = (b: Ray): boolean => {  
    // for (let A of this.self.all()) {  
    //   for (let B of b.self.all()) {    //     if (!A.isomorphic(B)) return false;    //   }    // }    // return true;  }  
  
  * [Symbol.iterator](): Generator<Ray> {  
  
    switch (this.type) {  
      case Type.REFERENCE:  
        break;  
      case Type.VERTEX:  
        yield this;  
        for (let terminal of this.terminal) { yield *terminal; }  
  
        break;  
      case Type.INITIAL:  
        yield *this.terminal;  
  
        break;  
      case Type.TERMINAL:  
        for (let self of this.self) {  
          switch (self.type) {  
            case Type.REFERENCE:  
              break;  
            case Type.VERTEX:  
              break;  
            case Type.INITIAL:  
              break;  
            case Type.TERMINAL:  
              break;  
  
          }  
        }  
  
        break;  
    }  
  }  
  
  // equivalent

  copy = (): Ray => {  
  
  }  
 
  static object = (x: object): Ray => {  
  
  }  
  static function = (x: (...args: any[]) => any): Ray => {  
  
  }  
  static reversible_function = (initial: (...args: any[]) => any, terminal: (...args: any[]) => any): Ray => {  
  
  }  
  static number = (number: number, options = { base: 10 }): Ray => {  
  
  }  

```


```ts
class Ray implements Iterable<Ray> {  

  
  * [Symbol.iterator](): Generator<Ray> {  
  
    // console.log(this.type)  
    // TODO: Forloops bundled  
    // TODO: On boundary, you'd want to loop simultaneously through all  
    switch (this.type) {  
      case Type.REFERENCE:  
        yield Ray.ref(this.self);  
        break;  
      case Type.VERTEX:  
        // TODO __filter__  
        // TODO __map__  
        yield Ray.ref(this);  
  
        let generators = [...this.terminal.collapse()].map(x => x[Symbol.iterator]());  
  
        while (generators.length !== 0) {  
          let next: Ray = undefined;  
  
          generators = generators.filter(generator => {  
            const { value, done } = generator.next();  
  
            next = next === undefined ? value : next.add(value)  
  
            return !done;  
          })  
  
          if (next) yield next;  
        }  
  
        // for (let terminal of this.terminal.collapse()) { yield *terminal; }  
  
        break;  
      case Type.INITIAL:  
        for (let terminal of this.terminal.collapse()) { yield *terminal; }  
  
        break;  
      case Type.TERMINAL:  
        for (let self of this.self.collapse()) {  
          switch (self.type) {  
            case Type.REFERENCE:  
              break;  
            case Type.VERTEX:  
              // TODO, could also just be ignored?  
              break;  
            case Type.INITIAL:  
            case Type.TERMINAL:  
              // if (this === self) break; TODO & terminal  
              yield *self;  
              break;  
  
          }  
        }  
  
        break;  
    }  
  }  
  
  add = (b: Ray): Ray => {  
    // if (this.is_reference()) this.as_vertex();  
    //    // switch (b.type) {    //   case Type.REFERENCE:    //   case Type.VERTEX:    //     b.as_vertex();    //     this.compose(b);    //     return b;    //   case Type.INITIAL:    //   case Type.TERMINAL:    //    //     break;    //    // }  }  
  
  compose = (b: Ray): Ray => {  
    // TODO Could abstract this product (to proxy?)  
    if (this.is_boundary()) {  
      for (let vertex of this) { vertex.compose(b) }  
      return this;  
    }  
    if (b.is_boundary()) {  
      for (let vertex of b) { this.compose(vertex) }  
      return this;  
    }  
  
    if (this.type === Type.REFERENCE || b.type === Type.REFERENCE) {  
      throw new Error('What to do in case of references?');  
    }  
  
    if (this.terminal.is_empty_reference()) {  
      this.terminal = b;  
    } else {  
      if (this.terminal.is_reference()) this.terminal.as_vertex();  
  
      // this.terminal.last.compose(Ray.vertex({ self: b }))  
    }  
  
    if (b.initial.is_empty_reference()) {  
      b.initial = this;  
    } else {  
      if (b.initial.is_reference()) b.initial.as_vertex();  
  
      // Ray.vertex({ self: this }).compose(b.initial.first)  
    }  
  
    return this;  
  }  
  
  as_vertex = (): Ray => {  
    if (this.is_initial()) this.initial = new Ray();  
    if (this.is_terminal()) this.terminal = new Ray();  
    return this;  
  }  
  
  static none = () => new Ray({ __none__: true })  
  
  static ref = (x: Ray | Ray[] | (() => Ray)): Ray => new Ray({ __self__: () => x instanceof Array ? Ray.iterable(x) : x instanceof Ray ? x : x() })  

}  

```