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

- Whereas usual graphs, we concern ourselves with vertices and edges, this is a rephrasing to a [Does the state of a ray have a more intuitive name?]. Which encompasses both what it means to be vertex and edge.


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

- Traversal: Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences
- Superposing Languages: Simultaneously having 'different levels of abstraction', superposing operators, 'multiple abstraction implementations', ..., simulation
- A Reprogrammable (Visual) Interface: Open inputs, outputs, compute substrate, ..., interfaces
- But what we can say is this: Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question.. whose rediscoverability is not entirely obvious. 

---

self reference in equiv ray means its not none  

- collapse the loop/infinity with an extreme 

Separated space vs "additional structure directions":

---

```ts
  
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
  
  
  orbit = () => this.last().compose(this.first())  
 

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

  *[Symbol.iterator](): Iterator<Ray> {
    // if (!this.is_boundary()) return this;

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
//
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
//   sort(compareFn?: (a: T, b: T) => number): this {
//     return undefined;
//   }
// }


```


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



```ts
  
  
export enum Type {  
  REFERENCE = "REFERENCE", //TODO: Reference could be vertex?  
  VERTEX = "VERTEX",  
  INITIAL = "INITIAL",  
  TERMINAL = "TERMINAL",  
  // INITIAL_EXTREME,  
  // TERMINAL_EXTREME,  // WALL // TODO: Could be renamed empty?  
}  
  
export type AnyOf<T> = T | T[] | (() => T | T[])  
export type Any = undefined | AnyOf<Ray> | AnyOf<State>  


  
// TODO: Could be merged back into Ray  
export class Program {  
  
  tasks: ((value?: unknown) => void)[] = []  
  
  constructor() {  
  }  
  
  next = () => {  
    if (this.i >= this.max || this.tasks.length === 0) {  
      this.done()  
      return;  
    }  
  
    this.tasks.pop()()  
  
    this.i++;  
  }  
  done: (value?: unknown) => void; // TODO: Could reject pending promises on done, is that necessary or can we just leave them be? Or is there some other way in javascript to dispense of them  
  
  i: number = 0;  
  max: number = 0;  
  step = async (entrypoint: () => Promise<any>, i: number) => {  
    this.i = 0; this.max = i;  
  
    const done = new Promise(resolve => this.done = resolve);  
  
    entrypoint()  
    this.next()  
  
    await done;  
  }  
  
  wait = (object?: {  
  
  }) => {  
    const task = new Promise((resolve, reject) => {  
      this.tasks.push(resolve)  
    })  
  
    this.next()  
  
    // await this.exec(async () => {})  
    return task;  
  }  
  
}  
  
export class AlteredIterable<T, R = T> implements AsyncIterable<R> {  
  
  public x: AsyncIterable<T>  
  constructor(x: Iterable<T> | AsyncIterable<T>, public program: Program = new Program()) {  
    async function * to_async_iterable<T>(iterable: Iterable<T>): AsyncGenerator<T> {  
        for (let x of iterable) { yield x }  
    }  
    this.x = is_async_iterable(x) ? x : to_async_iterable(x)  
  }  
  
  private __map__?: (x: T) => R  
  map = <R2>(map: (x: R) => R2): AlteredIterable<R, R2> => {  
    const iterable = new AlteredIterable<R, R2>(this[Symbol.asyncIterator](), this.program);  
    iterable.__map__ = map;  
    return iterable;  
  }  
  
  private __filter__?: (x: R) => boolean  
  filter = (predicate: (x: R) => boolean): AlteredIterable<R> => {  
    const iterable = new AlteredIterable<R>(this[Symbol.asyncIterator](), this.program);  
    iterable.__filter__ = predicate;  
    return iterable;  
  }  
  
  async * [Symbol.asyncIterator](): AsyncGenerator<R> {  
    const iterator = this.x[Symbol.asyncIterator]();  
  
    while (true) {  
      await this.program.wait()  
  
      let { done, value } = await iterator.next();  
      if (done) break;  
  
      value = this.__map__ ? this.__map__(value) : value  
  
      if (this.__filter__ && !this.__filter__(value)) continue;  
  
      yield value;  
    }  
  }  
  
}  
  
class Ray implements AsyncIterable<Ray> {  

  public __state__: () => State; get state(): State { return this.__state__() }; set state(x: Any) {  
    // this.__state__ = ((x: Any): (() => State) => {  
    //   if (x === undefined) return State.none;    //   if (is_function(x)) return () => {    //     let value = x();    //     if (value instanceof Array) return // TODO  
    //     return value instanceof State ? value : value.state  
    //   };    //   let value = x instanceof Array ? Ray.iterable(x) : Ray.ref(x);    //   return () => value;    // })(x)  }  
    
  constructor(x: Any = undefined, object: any = {}) {  
    this.state = x;  
    Object.keys(object).forEach(key => (this as any)[key] = object[key]);  
  }  
  
  // TODO: How does .map effect .self/.terminal/.initial  
  public __map__
  
  // If the starting Ray is a vertex, which is excluded, it acts like an initial.  
  // TODO: Selection after filter change reapply, TODO: For all changes
  public __filter__
  
  // TODO: Functions that alter structure like .flatten/.flat_map, what else?  
  // TODO: join/pop/shift/sort/max/min or similar alterations  
  
  // get initial(): Ray { return this.__reverse__ ? this.state.terminal : this.state.initial }; set initial(x: Any) { this.__reverse__ ? this.state.terminal = x : this.state.initial = x; }  
  // get self(): Ray { return this.state.self }; set self(x: Any) { this.state.self = x; }  // get terminal(): Ray { return this.__reverse__ ? this.state.initial : this.state.terminal }; set terminal(x: Any) { this.__reverse__ ? this.state.initial = x : this.state.terminal = x; }  
  // is_initial = async () => this.initial.is_none()  // is_terminal = async () => this.terminal.is_none()  // is_reference = async () => await this.is_initial() && await this.is_terminal()  // is_empty_reference = async () => await this.is_reference() && await this.self.is_none()  // is_boundary = async () => xor(await this.is_initial(), await this.is_terminal())  // is_vertex = async () => !await this.is_initial() && !await this.is_terminal()  // is_extreme = async () => await this.is_none() && await this.is_boundary()  // is_wall = async () => await this.is_none() && !await this.is_initial() && !await this.is_terminal()  //  // is_none = async () => this.state.__none__ || this.max_length === 0;  // is_some = async () => !await this.is_none();  
  // type = async (): Promise<Type> => {  //   if (await this.is_reference()) return Type.REFERENCE;  //   if (await this.is_initial()) return Type.INITIAL;  //   if (await this.is_terminal()) return Type.TERMINAL;  //   if (await this.is_vertex()) return Type.VERTEX;  //   // if (this.is_wall()) return Type.WALL;  //   throw new Error('Should not happen')  // }  
  // TODO: At each step, the intermediate iterator result which gets returned, might be expanded on later, when deemed it has changed, when would you want to know about that change mid-iteration?  
  // TODO: What about traversing and mapping the entire structure including terminal/initial structure?  
  async * traverse({  
    strategy,  
    history,  
  }: { strategy?: (x: Ray) => Iterable<Ray | Ray[]>, history?: Ray } = {}) {  
    const { __filter__, __map__ } = this;  
  
    function * found(unfiltered: Iterable<Ray>) {  
      // TODO history.contains() ; Only needs a 'have I been here flag'  
  
      let x = new AlteredIterable(unfiltered)  
      // TODO: This doesnt work, filter.map.filter is different  
      __filter__.forEach(filter => x = x.filter(filter))  
      __map__.forEach(map => x = x.map(map))  
  
  
    }  
    throw new Error('Not implemented')  

	// TODO: Not just a simple for await loop, can go depth first depending on program strategy.

    // TODO: History in case of .bidirectional after a .filter is?  
  
    // TODO: Traversal should support yielding initial/terminals as well  
  
    // TODO: Program.step here with metadata  
  
    // TODO Instantly yield intermediate results by returning an iterable of which the next values are still pending.  
    // TODO: Returned iterable result can also be infinitely generating  
  
  
    // TODO: Map maps .self values of each vertex.  
    // TODO: Map replaces either original structure or within the altered (filtered/mapped) structure?  
  
    // TODO: Allow for additional operations on .traverse/.last like .push_back, where we have pending for non-found values of .last yet  
  }  
  
  // Compose for function initials?  
  compose = (b: Ray): Ray => {  
    throw new Error('Not implemented')  
  }  




  
  // get boundary(): Ray {
  //     .map(x => x.is_first() ? Ray.initial({ terminal: x }) : Ray.terminal({ initial: x }))  // }
  // TODO" Ray.terminal should automatically be linked to the provided 'initial' (should respect reverse)  

  get initial_boundary(): Ray { return this.reverse.terminal_boundary }  
  get terminal_boundary(): Ray { return this.last.map(x => Ray.terminal({ initial: x })) }  
    
  // if (this.is_boundary()) return this.map(x => x.compose(b))  
    // if (b.is_boundary()) return b.map(x => this.compose(x)) //TODO should return x. 
  push
  
  in_orbit = (): boolean => {   
    throw new Error('Not implemented')  
  }  
  
  static ref = (self: Any): Ray => new Ray(new State({ self }))  
  
  static initial = (object: any = {}) => new Ray(new State({ self: State.none(), terminal: State.none(), ...object }))  
  static vertex = (object: any = {}) => new Ray(new State({ initial: State.none(), self: State.none(), terminal: State.none(), ...object }))  
  static terminal = (object: any = {}) => new Ray(new State({ initial: State.none(), self: State.none(), ...object }))  
    
  // TODO: .iterable conversion should be automatic, and additional functionality of string & other objects  
  // TODO: Could be added automatically.  
  static string = (string: string) => Ray.iterable(string)  
  static iterable = <T>(x: Iterable<T>) => this.iterator(x[Symbol.iterator]());  
  static iterator = <T>(x: Iterator<T>) => {  
    const next = (previous?: Ray): Ray => {  
      const { done, value } = x.next();  
  
      const current = done ? Ray.terminal({ initial: previous }) : Ray.vertex({ __object__: value, initial: previous });  
      previous.terminal = current  
  
      if (done) return current  
  
      current.terminal = () => next(current)  
  
      return current  
    }  
  
    const iterator = Ray.initial({ terminal: () => next(iterator) });  
  
    return iterator;  
  }  
}  
  
class State {  
  
  public __object__?: any  
  
  // TODO public visitors: State  
  
  private __initial__: Ray = new Ray(); get initial(): Ray { return this.__initial__ }; set initial(x: Any) { this.__initial__ = new Ray(x); }  
  private __self__: Ray = new Ray(); get self(): Ray { return this.__self__ }; set self(x: Any) { this.__self__ = new Ray(x); }  
  private __terminal__: Ray = new Ray(); get terminal(): Ray { return this.__terminal__ }; set terminal(x: Any) { this.__terminal__ = new Ray(x); }  
  
  constructor(object: any = {}) {  
    Object.keys(object).forEach(key => (this as any)[key] = object[key]);  
  }  
    
  public __none__?: boolean // TODO Better solutions for this  
  
  
  static none = () => new State({ __none__: true })  
  
}  
export default State;  
  
const xor = (a: boolean, b: boolean) => (a && !b) || (!a && b)  



constructor(object: any = {}) {  
  Object.keys(object).forEach(key => (this as any)[key] = object[key]);  
}

```


**Changes applied to what structure**
  // TODO: Alterations on original structure or on altered or on copy ..  
  // TODO: map where each change in sequence effects the next one, vs map where we expect the initial structure to be the same  TODO COUNTS FOR EVERY CHANGE. Might trigger changes which alter multiple layers of the altered Ray. -> Selection might not be reachable, or differently, or distance is altered, etc..
  // TODO: Indexes relative to what? The original structure probably, or the applied filter? Or which filter?  

filter to change initial structure, get the initial structure/



// TODO: next when none is selected should return the first entries? (Including looped initials?; optionally?)


```ts

/**  
 * Deem initial and terminal cycles as part of the boundary: * - Each entry within a cycle is deemed a possible boundary value. * - A boundary cycle is deemed one if there is no initial/terminal out of the cycle. (Say, no initial side to an initial cycle) * TODO: What if there are two cycles, and one has an initial and the other does not?  
 */  
cycles_are_boundaries: () => TCursor

cycles_are_boundaries = Property.boolean(this, 'cycles_are_boundaries')


 || (Property.is(this.cycles_are_boundaries) && false)   // TODO: Detect cycles for cycles_are_boundaries

```

```ts

/**  
 * A list of additional locations our Ray is at. * * TODO: What if selection has non-unique locations? -> Should operations be duplicated, or does this sort of functionality have to be enabled/disabled?  
 */  
selection: TCursor

private __selection__: Ray; get selection(): Ray { return this.__selection__ ??= new Ray() }; set selection(value: Ray) { this.__selection__ = value }
```

```ts
TODO Replaced with .all

for_each = async (callback: (x: Ray) => MaybeAsync<unknown>) => {  
  // for await (let x of this) { await callback(x) }
```

```ts
splice: (start: number, deleteCount?: number, ...xs: any[]) => TCursor

// TODO https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice#:~:text=Zero%2Dbased%20index%20at%20which%20to%20start%20changing%20the%20array%2C%20converted%20to%20an%20integer.
splice = (start: number, deleteCount?: number, ...xs: any[]) => {  
  const cursor = this.at(start);  
  if (deleteCount) cursor.at(Range.Between(0, deleteCount)).remove();  
  xs.forEach(x => cursor.push_back(x));  
  return this;  
}


```


```ts

collect = <R>(predicate: (x: Ray) => MaybeAsync<R>): IRay<R> => {  
  
}

/**  
 * Map all continued functions on this ray to a specific type. 
 */
collect: <R>(predicate: (x: TNode) => MaybeAsync<R>) => IRay<R>
```