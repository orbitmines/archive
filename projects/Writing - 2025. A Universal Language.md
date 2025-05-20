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

- A language where the possibility of multiple branches/possibilities is native.




**TODO**
- Types
- Functions
	- Programs
- Graphs
	- graph rewriting functions
- Runtime/Traversal
	- Cache results in between for some runtime library. 
		- Invalidate before some query, caching on some other base layer
- Version Control
- History/causal graph and other mapping like a branchial graph
	- Can have a history, but no current value 
- Theorem Proving System


---

Normal programs have a control flow and location as opposed to a graph rewrite applying everywhere. Some generealization of these sorts of options  
  
Current rays don't have the notion of joining more than 2 vertices. .next is .[switch to hyperedge structure].all(). They do join more than two, but not necessarily in the same way.  
The wall graph is for instance a little different: each step can't go to itself in the edge (unless there's a selfloop probably), but can go to the others. So structurally the edge is different from each perspective. Isomorphism would have to check for all the different edge perspectives.  
  
How to select a substructure of an edge as a path  
  
Selected structure for .next vs selected structure for .isomorphic  
  
Casaul graph is the what effected what  
Casaul graph of the casaul graph ...  
- Casaul graph needs a notion of what structure changed, could be that it didn't touch the graph but only the value. Do you want to have it still be a causal link created there if the graph for example isn't effected  
  
More general way to think about types of steucture at a point  
  
Local going back in time to meet some other query


---


- Copying means what now? with the automatic splits (related to caching?)





---
###### After Restructure
- Function discovery
- Compression/Geodesics
- Intermediate partial equality how?
- [ ] Factory (Compression, ...): Setup to constantly grow whatever in-memory graph/equivalences are found, get to this place so we can start iterating on discovery functions. 
	- [ ] Notion of queues, resources (storage, capabilities), ..., priorities
	- [ ] "Measure of how hard something is to do in parallel (or in some other structure generally)" - differentiability of [[Project - Indexing existing Abstract Models (2024-2025?)]]
	- [ ] Apply the same version control system on the version control system itself. 
- Exploration: Brute-force enumeration, unkowns drive curiosity, treating something as something it's not (what-if simulation), fuzzing, random changes, 
- [ ] "Compile to" infrastructure

###### Examples
- Subtraction is more complicated than performing addition, for subtraction you need to know a length, unless you just cut something off without knowing how long it is.
- 2d grid expansion as an example base rewrite rule, "expand loop"
- Boolean: Normal way of thinking about a boolean is .orbit we assume modularity of booleans
- Numbers, Integers, base-n, fractions, floating point
	- .add integers: single equivalence (initial from one side, terminal from other side.) 
	- Number returns a type of number which is a cursor on a graph. (The graph being the numberline) For example .next on a decimal number is an infinitesimal node after the current one. But we can still use operations like >/</..
- Single point, all perspectives. Ref on initial, entire initial ref as the .self, what about "entire" under some maximum travel speed/steps (or some variant of that idea)
- Program language syntax
- Nested arrays as structure on the initials, different than a 2d grid. + How does this work with unrealized array functions, or realized ones? Like .at(index).
- differentiable between two points to arbitrary precision, how is it constructed?
- If the starting Ray is a vertex, which is excluded, it acts like an initial.
- Mapping infinity to a number is a loop, and a loop in the reverse direction for -infinity?
- Note that things like `.every` start traversing from the selected node(s) location(s). Or in case of a graph it starts at what?
- Function self-reference: Initial + negative => terminal, terminal + negative => initial, initial/terminal => negative
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

  


// is_empty_reference = async () => await this.is_reference() && await this.self.is_none()  
// is_extreme = async () => await this.is_none() && await this.is_boundary() 
// is_wall = async () => await this.is_none() && !await this.is_initial() && !await this.is_terminal()  // 
  

  

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


constructor(object: any = {}) {  
  Object.keys(object).forEach(key => (this as any)[key] = object[key]);  
}

```

- cycles_are_boundaries ?

```ts
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
```

```ts
  

// export type AnyOf<T> = T | T[] | (() => T | T[])  
// export type Any = undefined | AnyOf<Ray> | AnyOf<State>  





// TODO: Functions that alter structure like .flatten/.flat_map, what else?  
// TODO: .map which maps both structure and values
 // TODO: sort using reduce. Sort is "bring to some canonicalized form"


  for_each = async (callback: (x: Ray) => MaybeAsync<unknown>) =>  
    await callback(this.all()) // TODO; Might not be it 

// TODO: Needs to check for terminals
 // TODO: Make sure this works for branching possibilities (no duplicate inserted values)  
// TODO: Make sure this works for different levels of description say ABCDEF/[ABC][DEF] then push between C-D.  
join = (value: any) =>  
  this.filter(x => x.is_last().not()).push_after(value)
  

  /**  
   * Deselect all nodes. (Akin to having reference to an array/set/...).   */  deselect = this.property(this, 'deselect')  
  /**  
   * A ray going both forward and backward.
   */  bidirectional = this.property(this, 'bidirectional')  

 
  
  get boundary(): Ray { return this.all().filter(x => x.on_boundary()) }  
  on_boundary = (): Ray => this.is_first().or(this.is_last())  
  
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



  nodes = this.select<Node>(this.this(), 'nodes', Node)

  
  /**
   * TODO: This doesnt work, and should you want terminals reachable from this selection??
   */
  get last() { return this.filter(x => x.is_last()) }

  // Todo: any terminals
  is_last = () => this.has_next().not()
  is_first = () => this.has_previous().not()

}
```

```ts


export class Node extends Selection<Node> {


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

```

```ts

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