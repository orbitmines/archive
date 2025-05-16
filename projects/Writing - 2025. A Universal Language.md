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

- Differences between function looking for variable(s) or not
- ("Description which generates the thing I'm interested in" Generalized to keeping track of "equivalent (and smaller) programs") -> difference between program A generates number Y.
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
	- [ ] How to think about non-realized functions usefully. Say coordinates to some non-realized geometrical space. (Similarly: locations of information and their retrieval)
	- [ ] Compose for function initials?  

```ts
/**
 * Think more loosely about the ray's structure:
 * - Point to a function/program on some structure
 *  - How to think about this as a single function with intermediate steps.
 *      How is that different from applying same function in that direction?: Described on another level of description?
 *  - Requires "looking for" type information. Ex. Function looking for parameter
 *
 *
 *
 * - Control flow as partial pattern-matched on branching structure.
 *   - How to use outputs of results into new functions, then pattern-match on the combination of those functions with branches on results.
 *
 * - Merging, pattern-matching, copying, isomorphism, deleting
 *
 * - How does execution happen?
 *   - What about the expansion case which needs both add structure and replace a reference?
 *
 *
 * Functions/Unrealized structure on location: Potential "Context"/Structure
 *    =
 * Additional structure on location
 */
```


- Isomorphism under ignored directions how? - First need a better notion of the structure of a ray

- Many previous/next pairs for a single node means? Different structures are the refs all different nodes, or one node with all those steuctures?

---

- [ ] Type information
- [ ] Canonicalization/deduplication


- History/causal graph

###### Theorem Proving System
- Proven that there's no terminal, .last returns empty, more elaborate theorem proving system
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
- The larger the integer, the more structure you need to describe it ; (at least if you're not expressing it as a more simple program, but have to construct the actual number)
- Coherence is expensive? - Takes a lot of structure
- Names in language as a way of indexing hard-to-find things
- [ ] Memorization vs rerunning

###### Statements?
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction - Overlapping multiple levels of description
- Any symmetry must be breakable - any symmetry has some ignored assymetrical property ; Does not have to be the case from the perspective of the symmetry.
- collapse the loop/infinity with an extreme 
---

- Traversal: Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences
- Superposing Languages: Simultaneously having 'different levels of abstraction', superposing operators, 'multiple abstraction implementations', ..., simulation
- A Reprogrammable (Visual) Interface: Open inputs, outputs, compute substrate, ..., interfaces
- But what we can say is this: Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question.. whose rediscoverability is not entirely obvious. 

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
  functions: Ray   
  // Iterate over possible representations: Matching is_equivalent/is_isomorphic  
  representations: Ray  
  

  
  // A copy traverses the entire structure  
  // TODO: Send left/right copy simultaneously, and cancel each-other out  

  
  orbit = () => this.last().compose(this.first())  
 

  variable = () => {  
    // TODO: Implement simple getter/setter structure  
  }  
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
  
  // TODO: How does .map effect .self/.terminal/.initial  
  public __map__
  
  // If the starting Ray is a vertex, which is excluded, it acts like an initial.  
  public __filter__
  
  // TODO: Functions that alter structure like .flatten/.flat_map, what else?  
  
  // get initial(): Ray { return this.__reverse__ ? this.state.terminal : this.state.initial }; set initial(x: Any) { this.__reverse__ ? this.state.terminal = x : this.state.initial = x; }  
  // get self(): Ray { return this.state.self }; set self(x: Any) { this.state.self = x; }  // get terminal(): Ray { return this.__reverse__ ? this.state.initial : this.state.terminal }; set terminal(x: Any) { this.__reverse__ ? this.state.initial = x : this.state.terminal = x; }  
  // is_initial = async () => this.initial.is_none()  
  
// is_terminal = async () => this.terminal.is_none()  
// is_reference = async () => await this.is_initial() && await this.is_terminal()  
// is_empty_reference = async () => await this.is_reference() && await this.self.is_none()  
// is_boundary = async () => xor(await this.is_initial(), await this.is_terminal())  
// is_vertex = async () => !await this.is_initial() && !await this.is_terminal()
// is_extreme = async () => await this.is_none() && await this.is_boundary() 
// is_wall = async () => await this.is_none() && !await this.is_initial() && !await this.is_terminal()  // 
  

// type = async (): Promise<Type> => {  //   if (await this.is_reference()) return Type.REFERENCE;  //   if (await this.is_initial()) return Type.INITIAL;  //   if (await this.is_terminal()) return Type.TERMINAL;  //   if (await this.is_vertex()) return Type.VERTEX;  //   // if (this.is_wall()) return Type.WALL;  //   throw new Error('Should not happen')  // }  


  

  get initial_boundary(): Ray { return this.reverse.terminal_boundary }  
  get terminal_boundary(): Ray { return this.last.map(x => Ray.terminal({ initial: x })) }  

  
  
  static ref = (self: Any): Ray => new Ray(new State({ self }))  
  
  static initial = (object: any = {}) => new Ray(new State({ self: State.none(), terminal: State.none(), ...object }))  
  static vertex = (object: any = {}) => new Ray(new State({ initial: State.none(), self: State.none(), terminal: State.none(), ...object }))  
  static terminal = (object: any = {}) => new Ray(new State({ initial: State.none(), self: State.none(), ...object }))  

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
  
    
}  
export default State;  
  



constructor(object: any = {}) {  
  Object.keys(object).forEach(key => (this as any)[key] = object[key]);  
}

```

- Mapping infinity to a number is a loop, and a loop in the reverse direction for -infinity?

- cycles_are_boundaries ?
```ts
/**  
 * Connect the front and back of the structure. * TODO: Should preserve the .first and .last. (POSSIBLE_CONTINUATION should)  
 */  
orbit = () => this.push_back(this.first)
```

```ts

TODO FUNCTION BUILDER
// TODO: Better construction of this sort of thing with the function builder -> What is implemented and cross-implement.
xor = (x: boolean) => { return (this.and(x.not())).or(this.not().and(x)) }  
nor = (x: boolean) => this.or(x).not()  
nand = (x: boolean) => this.and(x).not()


export interface IState {  
  is_initial: () => Ray  
  is_terminal: () => Ray  
  is_reference: () => Ray  
  is_boundary: () => Ray  
  is_vertex: () => Ray  
  is_extreme: () => Ray  
}  
  
export class State {  
  // value: any  
  initial: Ray  
  // TODO: Certain structures like history/types/.. which are ignored from certain selections, but included elsewhere?: Separated space vs "additional structure directions":  
  self: Ray  
  terminal: Ray  
  
  // export type AnyOf<T> = T | T[] | (() => T | T[])  
  // export type Any = undefined | AnyOf<Ray> | AnyOf<State>  
  // TODO: What does self-reference mean here.  
  is_terminal = () => this.terminal.is_empty()  
}

  
// TODO: What would be graph rewriting functions, include those  
// TODO: What about loops which are only repeated an x number of times. (which are quite common), are there some other variants of this? (.slice/.splice would for example make use of a single .orbit use in selecting a range/start index)  
// TODO: .map which maps both structure and values  
export class Ray {  
  
  
  // TODO: Cache results in between for some runtime library.  
  
  
  for_each = async (callback: (x: Ray) => MaybeAsync<unknown>) =>  
    await callback(this.all()) // TODO; Might not be it  

  
  // TODO: sort using reduce.  

// TODO: Needs to check for terminals
 // TODO: Make sure this works for branching possibilities (no duplicate inserted values)  
// TODO: Make sure this works for different levels of description say ABCDEF/[ABC][DEF] then push between C-D.  
join = (value: any) =>  
  this.filter(x => x.is_last().not()).push_after(value)
  

  /**  
   * Opposite of filter.   */  exclude = this.property<(x: Ray) => MaybeAsync<Ray | boolean>>(this, 'exclude')  
   

 
  /**  
   * Deselect all nodes. (Akin to having reference to an array/set/...).   */  deselect = this.property(this, 'deselect')  

  /**  
   * A ray going both forward and backward.   */  bidirectional = this.property(this, 'bidirectional')  

  
  
  
  /**  
   * Whether anything is selected   */  is_some = (): Ray => this.is_none().not()  
  is_none = this.property(this, 'is_none')  
  
  /**  
   *   * Note: If there are multiple things selected, the ones without a 'next' node are discarded. With a terminal loop,   * one can keep terminal boundaries in the selection.   */ 

 
  
  get boundary(): Ray { return this.all().filter(x => x.on_boundary()) }  
  on_boundary = (): Ray => this.is_first().or(this.is_last())  
  
 
  
  // TODO  
  // private __eq_number__ = async (x: number | Ray, eq: (left: number, right: number) => boolean): Promise<boolean> => {  
  //   const left = await this.to_number(); const right = is_number(x) ? x : await x.to_number();  //   if (left === undefined) return false;  //   if (right === undefined) return true;  //   return eq(left, right);  // }

  async * [Symbol.asyncIterator](): AsyncGenerator<Ray> {  
  
  }  
  
  
  

  
  // static array = <T>(x: T[]): Ray => {  
  //   throw new Error('Not implemented');  // }  // static object = (x: object): Ray => {  //   throw new Error('Not implemented');  // }  // // static function = (x: (...args: unknown[]) => unknown): Ray => {}  // static map = <K, V>(x: Map<K, V>): Ray => {  //   throw new Error('Not implemented');  // }}
  
```


```ts

// export const is = (property: Property.Type): boolean => !!value(property)  
// export const modular_is = (property: Property.Type): any => {  
//   let value = false;  
//   while (property !== undefined) {  
//     if (property.value) value = !value;  
//  
//     property = (property.__self__.__parent__ as any).value[property.__name__] as Property.Type  
//   }  
//   return value;  
// }  
// export const value = (property: Property.Type): any => {  
//   while (property !== undefined) {  
//     if (property.value) return property.value;  
//  
//     property = (property.__self__.__parent__ as any).value[property.__name__] as Property.Type  
//   }  
//   return undefined;  
// }
```

```
export class FunctionBuilder {

}


// TODO: TRAVERSAL
//      - Program strategy: which branches to take first.
//        + Program stepping.
//      - Cycle detection & merger
//      - Intermediate results while others are still pending.
//      - Support yielding initial/terminals as well. (intermediates which are still looking)
//      -
export class Traverser {

  // TODO: Nothing selected but underlying structure. .first snaps to first (looped initial possible).
  // TODO: Can include disconnected pieces. Also should include a disconnected piece without an initial. and so no qualifier to .first.

  // TODO: What does .all().is_last() mean?
  // TODO: Separate Ray and "Ray Part"? .next in Ray vs .next in "Ray Part"

  // TODO: .next should be for each possible entry of terminal values. filter(x => x.is_last()) should also be for each possible selection, not the selection as a whole
  // TODO: What to do if there are non-uniques in here, or is it always .unique ?
  // states: AsyncIterable<State>
  // TODO: Remember that we're at a terminal? Not that .next again returns the first element
  // TODO: Filter should be applied to state.
  // state: Ray


}

export class Function {

}

export class Graph {

  // TODO: PRESERVING ALL STRUCTURES AND HISTORIES
  //       How? Preserving both the original structure, and the rewritten graph.
  //       -> Ambiguous rewrites etc..
  //       -> Partial, without necessarily checking the entire graph.
  //            (what happens when a second rewrite is given, which a pending first rewrite might still cancel):
  //            (possible) Additional ambiguity of order of rewrite. What if invariant and doesn't matter?
  //
  // TODO: Split the graph at the differences?. Add/remove
  //       OR better: Give the ray from which we want to access this, which contains the remove/non-removed history.
  //
  // TODO: Requires knowledge of what operation can effect what.



  // TODO: Rewrite with checking structure at nodes, or ignored. (Basically only looking at between structure)
  // rewrite: (lhs: Graph, rhs: Graph)
  // dpo, spo, cartesion product, tensor product, union, disjoint union etc...
  // compose matching domain/codomain

  // TODO: History of rewrites as ray

  // TODO: You want to be able to select X number of sub-graphs of a larger graph. Those subgraphs being selected how? Like: all the matches.
  // TODO: Already the case?: -> Select needs to be more intelligent: both initials/terminals as vertex selected. "Entire subgraphs"
}

export enum RemoveStrategy {
  /**
   * Preserves structure around the removed selection.
   * This is akin to removing elements from an array.
   */
  PRESERVE_STRUCTURE = "PRESERVE_STRUCTURE",
  /**
   * Removes all connectivity around the selection.
   * This is akin to removing a vertex and all incoming/outgoing edges.
   *
   *   // TODO, Should only sever connections which are NOT in the selection. ?
   */
  SEVER_CONNECTIVITY = "SEVER_CONNECTIVITY"
}

export enum PushStrategy {
  /**
   * Push a value as a possible continuation. (Ignores the next node)
   */
  POSSIBLE_CONTINUATION = "POSSIBLE_CONTINUATION",
  /**
   * Push a value between the current and next node.
   */
  AFTER_CURRENT = "AFTER_CURRENT",
}

export class ConversionError extends Error {}


// TODO: We might expect these functions to execute on the node instead of the ray ?
//       

  // TODO index_of vs path used to get there. -1, 1, 1, -1 etc.. (or more general version of path)

  // TODO: .every on a node's location. Should it start traversing from there, yes?

Theorem proving.
// TODO: What about an infinitely generating structure which we through some other finite method proof holds for this predicate?

  // TODO: Map on terminals/initials and structure in general

export abstract class Selection<TNode extends Selection<TNode>> extends Query<TNode> {
Node

  this = () => this as any as T


  nodes = this.select<Node>(this.this(), 'nodes', Node)

  pop_front = () =>
    this.first.remove()
  pop_back = () =>
    this.last.remove()



  


  
  is_nonempty = () => this.is_empty().not()
  is_empty = () => this.reduce(async (acc, current, cancel) => { cancel(); return false; }, true)

  min = () => this.reduce(async (acc, current, cancel) => {
    if (acc.equals(-Infinity)) return cancel(); // Stop reducing if already reached -infinity.
    return await acc.lt(current).to_boolean() ? acc : current; // TODO: Move these conditionals into a property?
  }, undefined)

  // TODO: Way to get index from the ray. With a default .distance function applied somewhere?
  // TODO: Allow for intermediate result. -> Halting problem
  // TODO: Checks for uniqueness, only once per location: TODO: What would a reduce look like that doesn't do this (could be useful for intermediate results)
  // TODO: The order in which things appear can vary based on what strategy is used in the traverser. Can be influenceced by using things like .all
  reduce = this.property<[(accumulator: Node, current: Node, cancel: () => void) => void | any, initial_value: any]>(this.this(), 'reduce').cast(Node)
  reduce_right = (callback: (accumulator: Node, current: Node, cancel: () => void) => void | any, initial_value: any) => this.reverse().reduce(callback, initial_value)

  /**
   * Applies successive transformation and returns the result.
   *
   * TODO: Could figure out what can be done in parallel and what can't.
   */
  apply = this.property<IQuery[]>(this.this(), 'apply')
  /**
   * Reverse direction starting from the selection
   */
  reverse = this.property<void>(this.this(), 'reverse')
  /**
   * Select all nodes at a specific index/range.
   * TODO Make sure negative index works
   * TODO (index: number | IRange): IRange | Ray => is_number(index) ? Range.Eq(index) : index
   */
  at = this.property<number | IRange>(this.this(), 'at').cast(Ray)
  /**
   * Maps the original structure to one where you find the distances at the Nodes.
   *
   * Note: This can include infinitely generating index options.
   */
    // TODO Map_reduce here.
  distance = this.property<void>(this.this(), 'distance')
  /**
   * Ignores duplicates after visiting the first one.
   */
  unique = this.property<void>(this.this(), 'unique')

  /**
   * Change the values of all selected nodes.
   */
  set = this.property<any>(this.this(), 'set')
  /**
   * Remove the selection from the underlying ray.
   * TODO: Default RemoveStrategy.PRESERVE_STRUCTURE
   */
  remove = this.property<void | RemoveStrategy>(this.this(), 'remove')

  __push__ = this.property<[any[], PushStrategy]>(this.this(), '__push__')
  /**
   * Push a value after the selection.
   * Note: In the case of an array, this will push "the structure of an array" after the selection. NOT a list of possibilities.
   */
  push = (...x: any[]) => this.__push__(x, PushStrategy.POSSIBLE_CONTINUATION)

  /**
   * Push a value between the current and next node.
   */
  push_after = (...x: any[]) => this.__push__(x, PushStrategy.AFTER_CURRENT)
  /**
   * Push a value between the previous and current node
   */
  push_before = (...x: any[]) => this.reverse().push_after(...x)

  /**
   * Push a value to the end of the ray.
   */
  push_back = (...x: any[]) => this.last.push(...x)
  /**
   * Push a value to the beginning of the ray.
   * TODO: In the case of an array, push_front(A, B, C) will push [A, B, C] in front of [D, E, F] making [A, B, C, D, E, F].
   */
  push_front = (...x: any[]) => new Node(...x).push_back(this.first)


  /**
   * Select all nodes in this structure
   */
  all = this.property<void>(this.this(), 'all').cast(Ray)


  // TODO: Should return Ray?. Many possibilities here.
  get next() { return this.at(1) }
  get previous() { return this.at(-1) }

  /**
   * The terminal boundaries reachable from this selection.
   * Note: if you want ALL terminals, you should use .all().last
   * TODO: This doesnt work, and should you want terminals reachable from this selection??
   */
  get last() { return this.filter(x => x.is_last()) }
  get first() { return this.reverse().last }

}

// TODO: Separate methods on a value and on a structure.
export class Value {

}

export class Node extends Selection<Node> {

  constructor(...args: any[]) {
    super()
    if (args.length !== 0) this.__parent__ = new Node().from(() => Node.converter(args));
  }

  // TODO: There exists a Node which is "nothing selected of some structure": If nothing is selected. .equals is the same as .identical. Because [1, 2, 3] = [1, 2, 3]
  // TODO: Intermediate partial equality how?
  /**
   * Equal in value (ignores structure).
   */
  equals = this.property<any>(this, 'equals')
  /**
   * Structurally equal (ignores value).
   */
  isomorphic = this.property<any>(this, 'isomorphic')
  /**
   * Two rays are identical if there's no possible distinction between the "values and structure".
   *
   * TODO: Slight rephrasing of this
   * Note: two different instantiations of the same array, say: new Ray(1, 2, 3) and new Ray(1, 2, 3) are in fact
   *       identical. From the perspective of JavaScript, you would say: No, they are two different entities, so they
   *       cannot be identical. But we're not considering JavaScripts perspective here. We're assuming only knowledge
   *       from the rays themselves. And they CANNOT see a difference between the two. You need additional structure on
   *       either ray to make that distinction. (This, for example, could be a label to the JavaScript object ID, which
   *       is what allows us to make that distinction in JavaScript.)
   */
  identical = (x: any) => this.equals(x).and(this.isomorphic(x))

  gt = this.property<number>(this, 'or')
  gte = this.property<number>(this, 'gte')
  lt = this.property<number>(this, 'lt')
  lte = this.property<number>(this, 'lte')

  not = this.property(this, 'not')
  or = this.property<boolean>(this, 'or')
  and = this.property<boolean>(this, 'and')
  xor = this.property<boolean>(this, 'xor')
  nor = this.property<boolean>(this, 'nor')
  nand = this.property<boolean>(this, 'nand')

  has_next = () => this.next.is_some()
  has_previous = () => this.previous.is_some()

  // Todo: any terminals
  is_last = () => this.has_next().not()
  is_first = () => this.has_previous().not()

  // TODO: Throw if not number
  to_number = (): MaybeAsync<undefined | number> => {
    throw new Error('Not implemented');
    // throw new ConversionError('Not a number')
  }
  to_boolean = (): MaybeAsync<undefined | boolean> => {
    throw new Error('Not implemented');
  }
  to_array = <R>(predicate: (x: Ray) => MaybeAsync<R>): MaybeAsync<R[]> => {
    throw new Error('Not implemented');
  }
  // to_function = (): MaybeAsync<(...args: unknown[]) => unknown> => {
  //   throw new Error('Not implemented');  // }
  to_object = (): MaybeAsync<object> => {
    throw new Error('Not implemented');
  }
  cast = <T>(constructor: new () => T): MaybeAsync<T> => {
    throw new Error('Not implemented');
  }
  to_string = (): MaybeAsync<string> => {
    throw new Error('Not implemented');
  }

  /**
   * Sometimes it's necessary to do an async call to construct a Node. By using this you can hide the promise.
   */
  from = (getter: () => MaybeAsync<Node>): this => {
    if (this.__parent__ !== undefined) throw new Error('Can only use .from on an uninitialized Node.');
    (this.from as any).value = getter
    return this;
  }

  /**
   * Converts any JavaScript value to a ray.
   */
  static converter: (x: any) => Node = x => {
    // if (x instanceof Array) {
    //   if (x.length === 0) return new Ray()
    //   if (x.length === 1) x = x[0]
    // }
    //
    // if (x instanceof Ray) return x;

    throw new Error('Not implemented')
  }
}
export class Ray extends Selection<Ray> {

  // selection = this.select<Ray>(this.this(), 'selection', Ray)

}
```

```

/**
 * Copied from https://github.com/lodash/lodash/blob/main/dist/lodash.js
 */
export const is_string = (value: any): value is string =>
  typeof value == 'string' || (!is_array(value) && is_object_like(value) && base_tag(value) == '[object String]');
export const is_boolean = (value: any): value is boolean =>
  value === true || value === false || (is_object_like(value) && base_tag(value) == '[object Boolean]');
export const is_number = (value: any): value is number =>
  typeof value == 'number' || (is_object_like(value) && base_tag(value) == '[object Number]');
export const is_object = (value: any): value is object =>
  value != null && (typeof value == 'object' || typeof value == 'function');
export const is_object_like = (value: any) =>
  value != null && typeof value == 'object';
export const is_iterable = <T = any>(value: any): value is Iterable<T> =>
  Symbol.iterator in Object(value) && is_function(value[Symbol.iterator]);
export const is_async_iterable = <T = any>(value: any): value is AsyncIterable<T> =>
  Symbol.asyncIterator in Object(value) && is_function(value[Symbol.asyncIterator]);
export const is_array = Array.isArray
export const is_function = (value: any): value is ((...args: any[]) => any) => {
  if (!is_object(value)) return false;

  let tag = base_tag(value);
  return tag == '[object Function]' || tag == '[object GeneratorFunction]' || tag == '[object AsyncFunction]' || tag == '[object Proxy]';
}
export const base_tag = (value: any) => {
  if (value == null) return value === undefined ? '[object Undefined]' : '[object Null]';

  return (Symbol.toStringTag && Symbol.toStringTag in Object(value)) ? raw_tag(value) : to_string(value);
}
export const raw_tag = (value: any) => {
  let isOwn = Object.prototype.hasOwnProperty.call(value, Symbol.toStringTag),
    tag = value[Symbol.toStringTag];

  let unmasked;
  try {
    value[Symbol.toStringTag] = undefined;
    unmasked = true;
  } catch (e) {}

  let result = to_string(value);
  if (unmasked) {
    if (isOwn) {
      value[Symbol.toStringTag] = tag;
    } else {
      delete value[Symbol.toStringTag];
    }
  }
  return result;
}
export const to_string = (value: any): String => Object.prototype.toString.call(value);
```