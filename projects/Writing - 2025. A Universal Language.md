*Let's try for [[2025-12-31]] ; - Yearly excerpt of thoughts*

# Towards a Universal Language
**
###### Introduction

---

# UNPROCESSED
*Tread carefully, confusion abound*


---

- "Whenever you have one of something, what if you had more of that thing"  
- Reference (in)variant, or "most recent - direction on the direction" to some other direction (say time). "Most recent (.last)" / "Entire direction (.all)". This way get an unordered reference?
- Differences between function looking for variable(s) or not
- From "location" to "data entry"
- ("Description which generates the thing I'm interested in" Generalized to keeping track of "equivalent (and smaller) programs")
- Better way of thinking about one-way referenced structure
- (Local) rewriting, Traversal (with superposed extremes as encoded directions?)
- [ ] Better notion of functions (non-terminating; orbits) & variables (; replacing structures with others matching either in that structure (;rewrite) or variable replacement (; replace on inaccessible abstrzaction level ; ex. no nice mappings))
	- Function as direction on "an unknown (optionally of some type/structure)"
	- Functions as unrealized directions on any point
	- Intermediate results pending change
		- descriptions, definitions, lazy functions, unresolved pointers, non-committal ignorance, awaiting function execution, questions, ..., conjectures. Or: We can point to things to which we don't yet have any (or a definitive) answer.

- Isomorphism under ignored directions how? - First need a better notion of the structure of a ray

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
.all in both directions  
. reverse baked in how  
  
equiv ray at intersection - then what does initial mean?  
  
result of iterator one or many  
  
different perspectives one object how?

intermediate results & search pointers how?

`.distance` as a mapping retaining the structure of something like `.last`? More generally this abstracted away as?

Initial/terminal as pointer direction on reference? Or too hacky

Separated space vs "additional structure directions":



*Better notion of how the equivalence ray should work*.
- Equiv ray circular by default?
- Program defined at terminal what terminal should be

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

export type Function = string | symbol | number;

export type Pointer = {
  [key: string | symbol | number]: Pointer
  (...args: any[]): Location;
}

abstract class Location implements AsyncIterable<Function> {
  abstract __step__: (fn: Function) => Location
  abstract __set__: (value: Location) => void
  abstract [Symbol.asyncIterator](): AsyncIterator<Function>

  is_none = async (): Promise<boolean> => {
    for await (const fn of this) { return false; }
    return true;
  }

  static of = (any: any): Pointer => {
    throw new Error('Not implemented');
  }

  get pointer(): Pointer {
    return new Proxy(class {}, {
      apply: (_: any, thisArg: any, argArray: any[]): any =>
        this,
      set: (_: any, property: string | symbol, newValue: any, receiver: any): boolean => {
        this.__step__(fn(property)).__set__(Location.of(newValue)());
        return true;
      },
      get: (_: any, property: string | symbol, receiver: any): any =>
        this.__step__(fn(property)).pointer,
      // has: (_: any, property: string | symbol): boolean => true,
      // construct: (_: any, argArray: any[], newTarget: any): object =>
      //   new Pointer(this.location),
      // deleteProperty: (_: any, property: string | symbol): boolean => this.__delete__(property)
    });
  }
}


```

```ts

export type Pointer = {
  [key: string | symbol]: Pointer
}

abstract class Node {
  abstract get self(): any
  abstract is_none(): boolean
  is_some = (): boolean => !this.is_none()
}

class Ray implements Iterable<Ray> {


  get length(): number {
    if (!this.is_boundary()) return 1;

    return [...this].length // TODO: Handle cycles differently?
  }

  at = (index: number): Ray | undefined => {
    // TODO: Iterator results which turn ref/or initial/terminal for multiple results
    // TODO: Not ref, but reposition index to that one; so initial/terminal need to be set on what gets returned
    let i = 0;
    for (let current of this) {
      if (i === index) return Ray.ref(current);
      i++;
    }
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

// class TempImpl<T> implements Array<T> {
//   [n: number]: T;
//
//   readonly [Symbol.unscopables]: { [K in keyof any[]]?: boolean };
//   length: number;
//
//   [Symbol.iterator](): IterableIterator<T> {
//     return undefined;
//   }
//
//
//   concat(...items: ConcatArray<T>[]): T[];
//   concat(...items: (ConcatArray<T> | T)[]): T[];
//   concat(...items: (ConcatArray<T> | T)[]): T[] {
//     return [];
//   }
//
//   copyWithin(target: number, start: number, end?: number): this {
//     return undefined;
//   }
//
//   entries(): IterableIterator<[number, T]> {
//     return undefined;
//   }
//
//   every<S extends T>(predicate: (value: T, index: number, array: T[]) => value is S, thisArg?: any): this is S[];
//   every(predicate: (value: T, index: number, array: T[]) => unknown, thisArg?: any): boolean;
//   every(predicate, thisArg?: any): any {
//   }
//
//   fill(value: T, start?: number, end?: number): this {
//     return undefined;
//   }
//
//   find<S extends T>(predicate: (value: T, index: number, obj: T[]) => value is S, thisArg?: any): S | undefined;
//   find(predicate: (value: T, index: number, obj: T[]) => unknown, thisArg?: any): T | undefined;
//   find(predicate, thisArg?: any): any {
//   }
//
//   findIndex(predicate: (value: T, index: number, obj: T[]) => unknown, thisArg?: any): number {
//     return 0;
//   }
//
//   findLast<S extends T>(predicate: (value: T, index: number, array: T[]) => value is S, thisArg?: any): S | undefined;
//   findLast(predicate: (value: T, index: number, array: T[]) => unknown, thisArg?: any): T | undefined;
//   findLast(predicate, thisArg?: any): any {
//   }
//
//   findLastIndex(predicate: (value: T, index: number, array: T[]) => unknown, thisArg?: any): number {
//     return 0;
//   }
//
//   flat<A, D = 1 extends number>(depth?: D): FlatArray<A, D>[] {
//     return [];
//   }
//
//   flatMap<U, This = undefined>(callback: (this: This, value: T, index: number, array: T[]) => (ReadonlyArray<U> | U), thisArg?: This): U[] {
//     return [];
//   }
//
//   forEach(callbackfn: (value: T, index: number, array: T[]) => void, thisArg?: any): void {
//   }
//
//   includes(searchElement: T, fromIndex?: number): boolean {
//     return false;
//   }
//
//   indexOf(searchElement: T, fromIndex?: number): number {
//     return 0;
//   }
//
//   join(separator?: string): string {
//     return "";
//   }
//
//   keys(): IterableIterator<number> {
//     return undefined;
//   }
//
//   lastIndexOf(searchElement: T, fromIndex?: number): number {
//     return 0;
//   }
//
//   map<U>(callbackfn: (value: T, index: number, array: T[]) => U, thisArg?: any): U[] {
//     return [];
//   }
//
//   pop(): T | undefined {
//     return undefined;
//   }
//
//   push(...items: T[]): number {
//     return 0;
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
//   slice(start?: number, end?: number): T[] {
//     return [];
//   }
//
//   some(predicate: (value: T, index: number, array: T[]) => unknown, thisArg?: any): boolean {
//     return false;
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
//   toReversed(): T[] {
//     return [];
//   }
//
//   toSorted(compareFn?: (a: T, b: T) => number): T[] {
//     return [];
//   }
//
//   toSpliced(start: number, deleteCount: number, ...items: T[]): T[];
//   toSpliced(start: number, deleteCount?: number): T[];
//   toSpliced(start: number, deleteCount?: number, ...items: T[]): T[] {
//     return [];
//   }
//
//   unshift(...items: T[]): number {
//     return 0;
//   }
//
//   values(): IterableIterator<T> {
//     return undefined;
//   }
//
//   with(index: number, value: T): T[] {
//     return [];
//   }
// }

// Separate function builder and functionality

const xor = (a: boolean, b: boolean) => (a && !b) || (!a && b)

```

```ts
  
  
export enum Type {  
  REFERENCE, //TODO: Reference could be vertex?  
  VERTEX,  
  INITIAL,  
  TERMINAL,  
  // INITIAL_EXTREME,  
  // TERMINAL_EXTREME,  // WALL // TODO: Could be renamed empty?  
}  
  
// Separate class?  
// class Reference extends Ray {  
//   private __reverse__: boolean = false  
// }  
  
class Ray implements Iterable<Ray> {  
  
  public __object__?: any  
    
  private __initial__: () => Ray = () => Ray.none(); get initial(): Ray { return this.__initial__() }; set initial(x: Ray | Ray[] | (() => Ray)) { this.__initial__ = () => x instanceof Array ? Ray.iterable(x) : Ray.ref(x instanceof Ray ? x : x()); }  
  private __self__: () => Ray = () => Ray.none(); get self(): Ray { return this.__self__() }; set self(x: Ray | Ray[] | (() => Ray)) { this.__self__ = () => x instanceof Array ? Ray.iterable(x) : Ray.ref(x instanceof Ray ? x : x()); }  
  private __terminal__: () => Ray = () => Ray.none(); get terminal(): Ray { return this.__terminal__() }; set terminal(x: Ray | Ray[] | (() => Ray)) { this.__terminal__ = () => x instanceof Array ? Ray.iterable(x) : Ray.ref(x instanceof Ray ? x : x()); }  
  
  constructor(object: any = {}) {  
    Object.keys(object).forEach(key => (this as any)[key] = object[key]);  
  }  
  
  is_initial = () => this.initial.is_none()  
  is_terminal = () => this.terminal.is_none()  
  is_reference = () => this.is_initial() && this.is_terminal()  
  is_boundary = () => xor(this.is_initial(), this.is_terminal())  
  is_vertex = () => !this.is_initial() && !this.is_terminal()  
  is_extreme = () => this.is_none() && this.is_boundary()  
  is_wall = () => this.is_none() && !this.is_initial() && !this.is_terminal()  
  
  private __none__?: boolean // TODO Better solutions for this  
  is_none = (): boolean => this.__none__ || this.length.max === 0;  
  is_some = () => !this.is_none()  
  
  get type(): Type {  
    if (this.is_reference()) return Type.REFERENCE;  
    if (this.is_initial()) return Type.INITIAL;  
    if (this.is_terminal()) return Type.TERMINAL;  
    if (this.is_vertex()) return Type.VERTEX;  
    // if (this.is_wall()) return Type.WALL;  
    throw new Error('Should not happen')  
  }  
  
  get reverse(): Ray {  
    // Set on pointer-level  
  }  
  
  get length(): Ray { return this.distance(this.last) }  
  get max(): number {}  
  get min(): number {}  
  
  * all(): Generator<Ray> {  
    // const initial = this.reverse[Symbol.iterator]();  
    // const terminal = this.next[Symbol.iterator]();    //    // while (true) {    //   const a = initial.next()    //   const b = terminal.next()    //    //   if (!a.done) yield a.value;    //   if (!b.done) yield b.value;    //    //   if (a.done && b.done) break;    // }    yield *this.reverse.next; yield *this  
  }  
  
  // TODO: Detect and exclude cycles  
  get first(): Ray { return this.reverse.last }  
  get last(): Ray {  
    // TODO: Returns terminal boundaries  
  }  
  get boundary(): Ray {  
    // TODO : Merge first & last  
    // TODO: What would be the situation where you want the boundary to include initial/terminal cycles?  
  }  
  
  get next(): Ray { return this.at(1); }  
  get current(): Ray { return this.at(0); }  
  get previous(): Ray { return this.at(-1); }  
  
  has_next = (): boolean => this.next.is_none()  
  has_previous = (): boolean => this.previous.is_none()  
  
  at = (index: number): Ray => {  
    // if (index === Number.NEGATIVE_INFINITY) return this.first;  
    // if (index === Number.POSITIVE_INFINITY) return this.last;  }  
  
  distance = (b: Ray): Ray => {  
    // TODO Should this return distance in the direction the ray is pointing in? yes?  
    // let distance = 0;  
    // for (const a of this) {    //   if (a.equals(b)) return distance;    //   distance++;    // }  
  }  
  
  contains = (b: Ray): boolean => {  
  
  }  
  
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
  
  push_front = (b: Ray): Ray => b.compose(this.first)  
  push_back = (b: Ray): Ray => this.last.compose(b)  
  
  compose = (b: Ray): Ray => {  
    // this.terminal.compose(b.initial)  
  }  
  // equivalent  
  
  for_each = (predicate: (x: Ray) => any) => {  
  
  }  
  some = (predicate: (x: Ray) => boolean): boolean => {}  
  every = (predicate: (x: Ray) => boolean): boolean => {}  
  // TODO: Map might want to retain/replace additional structure too, how?  
  map = <T>(predicate: (x: Ray) => T): Ray => {}  
  // TODO: Filter as additional layer passing through a sub-slice of the original structure?  
  // TODO: Or: retain the same structure, but filter out additional structure on the excluded values?  
  filter = (predicate: (x: Ray) => boolean): Ray => {}  
  
  copy = (): Ray => {  
  
  }  
  
  static none = () => new Ray({ __none__: true })  
  
  static ref = (x: Ray | Ray[] | (() => Ray)): Ray => new Ray({ __self__: () => x instanceof Array ? Ray.iterable(x) : x instanceof Ray ? x : x() })  
  static initial = (object: any = {}) => new Ray({ self: new Ray(), terminal: new Ray(), ...object })  
  static vertex = (object: any = {}) => new Ray({ initial: new Ray(), self: new Ray(), terminal: new Ray(), ...object })  
  static terminal = (object: any = {}) => new Ray({ initial: new Ray(), self: new Ray(), ...object })  
  
  static object = (x: object): Ray => {  
  
  }  
  static function = (x: (...args: any[]) => any): Ray => {  
  
  }  
  static reversible_function = (initial: (...args: any[]) => any, terminal: (...args: any[]) => any): Ray => {  
  
  }  
  static number = (number: number, options = { base: 10 }): Ray => {  
  
  }  
  // TODO: .iterable conversion should be automatic, and additional functionality of string & other objects  
  // TODO: Could be added automatically.  
  static string = (string: string) => Ray.iterable(string)  
  static boolean = (boolean: boolean) => Ray.number(boolean ? 1 : 0, { base: 2 })  
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
export default Ray;  
  
// Separate function builder and functionality  
  
const xor = (a: boolean, b: boolean) => (a && !b) || (!a && b)

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
  
class Ray implements Iterable<Ray> {  
  
  public __object__?: any  
  
  // TODO public visitors: Ray  

  
  is_initial = () => this.initial.is_none()  
  is_terminal = () => this.terminal.is_none()  
  is_reference = () => this.is_initial() && this.is_terminal()  
  is_empty_reference = () => this.is_reference() && this.self.is_none()  
  is_boundary = () => xor(this.is_initial(), this.is_terminal())  
  is_vertex = () => !this.is_initial() && !this.is_terminal()  
  is_extreme = () => this.is_none() && this.is_boundary()  
  is_wall = () => this.is_none() && !this.is_initial() && !this.is_terminal()  
  
  private __none__?: boolean // TODO Better solutions for this  
  is_none = (): boolean => this.__none__ || this.length === 0;  
  is_some = () => !this.is_none()  
  
  get type(): Type {  
    if (this.is_reference()) return Type.REFERENCE;  
    if (this.is_initial()) return Type.INITIAL;  
    if (this.is_terminal()) return Type.TERMINAL;  
    if (this.is_vertex()) return Type.VERTEX;  
    // if (this.is_wall()) return Type.WALL;  
    throw new Error('Should not happen')  
  }  
  
  get length(): number { return [...this].length }  
  
  get next(): Ray { return this.at(1); }  
  get current(): Ray { return this.at(0); }  
  get previous(): Ray { return this.at(-1); }  
  
  has_next = (): boolean => this.next.is_none()  
  has_previous = (): boolean => this.previous.is_none()  
  
  at = (index: number): Ray => {  
    let i = 0;  
    for (let current of this) {  
      if (i === index) return current;  
      i++;  
    }  
  }  
  
  * collapse(): Generator<Ray> {  
    yield *this;  
    // TODO yield entire (backwards and forwards, or backwards&forwards on each step)?  
  }  
  
  traverse = ({  
    traverser  
              }: { collapsed?: boolean, traverser?: Ray } = {}) => {  
    // Traverser: Ray where .self is bound to the .last value of another ray which is the traversal history.  
    if (traverser.includes(this))  
      return;  
    // TODO collapsed, one step in each direction, generalized to different step func?  
  }  
  
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
  static initial = (object: any = {}) => new Ray({ self: Ray.none(), terminal: Ray.none(), ...object })  
  static vertex = (object: any = {}) => new Ray({ initial: Ray.none(), self: Ray.none(), terminal: Ray.none(), ...object })  
  static terminal = (object: any = {}) => new Ray({ initial: Ray.none(), self: Ray.none(), ...object })  
  
  static last = (x: Ray) => {  
    return new Ray({ self: () => x.last })  
  }  
  
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
export default Ray;  
  
// Separate function builder and functionality  
  
const xor = (a: boolean, b: boolean) => (a && !b) || (!a && b)  
  
// TODO Copy from lodash - remove as a dependency.  
import _ from "lodash";  
export const is_string = (_object: any): _object is string => _.isString(_object)  
export const is_boolean = (_object: any): _object is boolean => _.isBoolean(_object);  
export const is_number = (_object: any): _object is number => _.isNumber(_object);  
export const is_object = (_object: any): _object is object => _.isObject(_object);  
export const is_iterable = <T = any>(_object: any): _object is Iterable<T> => Symbol.iterator in Object(_object) && is_function(_object[Symbol.iterator]);  
export const is_async_iterable = <T = any>(_object: any): _object is AsyncIterable<T> => Symbol.asyncIterator in Object(_object) && is_function(_object[Symbol.asyncIterator]);  
export const is_array = <T = any>(_object: any): _object is T[] => _.isArray(_object);  
export const is_async = (_object: any) => _.has(_object, 'then') && is_function(_.get(_object, 'then')); // TODO, Just an ugly check  
export const is_error = (_object: any): _object is Error => _.isError(_object);  
export const is_function = (_object: any): _object is ((...args: any[]) => any) => _.isFunction(_object);

```