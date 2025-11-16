*Let's try for [[2025-12-31]] ; - Yearly excerpt of thoughts*

Subtitle
- An exposition of contemporary (programming) languages, the requirements for a universal programming language and an attempt in that direction.
- What infrastructure are contemporary mathematics and other (programming) languages missing? 
- Existing abstract models of computation, mathematics, ... (programming) languages : What are their commonalities and what infrastructure are they all missing?
- What does it take to build a universal language? 

-

# Towards a Universal Language
**

###### Introduction

---

# UNPROCESSED
*Tread carefully, confusion abound*


---
---

A programming language centered around several key thoughts, namely:

Summarized:
- One should be able to mix and combine programming languages. (Once knowledge of types of structure, syntax and control-flow at any abstraction layer exists.) - Of which control-flow is the hardest, which we can separate in the even harder "actual control flow" (for some "perceived actual execution layer") and some abstraction we suppose is the control flow.

- Whereas usual graphs, we concern ourselves with vertices and edges, this is a rephrasing to a [Does the state of a ray have a more intuitive name?]. Which encompasses both what it means to be vertex and edge.

- (The initial implementation with thing like keywords, should be changeable from some base.)


**TODO**
- Types, Grammars, Pattern-matching
	- Implement Backus-Naur Form, implement WASM, implement regex.
	- Conditional Types/Dependent types
- Functions
	- Programs
- Control-flow & programs
- Graphs
	- graph rewriting functions
- Runtime/Traversal

- Version Control
	- General notion of merges cross the "OS", if highly customized, more chance of having to merge stuff. What stuff can be partially merged, what stuff cancels the "whole" update? 
- History/causal graph and other mapping like a branchial graph
	- Can have a history, but no current value 
- Theorem Proving System
- Analyses and injection of existing binaries/programming languages.
- `ray` CLI
- IntelliJ & VS Code extension (Can we use a popup window/context on the side to have interactive graphs?)

---


- Copying means what now? with the automatic splits (related to caching?)

- Again we ask ourselves, what's the actual purpose of generics (or polymorphism in the functional programming in sense) ; It's the ability to partially fill variables. Take for instance ...
---

All other type definitions change the overlapping graphs defined on .vertex. Not the structure of the type.

---

Version control: New version of a function is proved to not be equivalent in some way, is it necessary to notify the user of that? Which non-equivalences dont matter, many would not.

---
##### Rendering Engine

Engine/Project name: ??
The Ether 

First startup:
Greetings! 
[Player name]
Second startup:
Greetings, [Player name]

Rendering Engine

Typeface
Character encodings:
- ASCII
- UTF-8
Language preference & default (automatic translation overlapped with specific translations - for words or sentence references)
Colors
Shapes
Images


Implemented in:
- html
- threejs
-

Playername is similar to settings like Utf-8 in that it is some library one associates with themselves. 
-> Can be set to some field which using a string, but string with different characters, say only letters and spaces.


Things like the welcome screen are alterable, what happens when there's an update to the original? Any branches off the original screen should have some way of "plug any updates here automatically" " but this is changed/overridden"

Initial setup uses some html renderer until the language can express the requirements for a renderer in itself 

---

###### Editor

2 ^ 32, should render as superscript 32, and backspace on ^ should remove the cursor from superscript to normal size.

Up, valculate character at x level, go to there, monospace would be the same x coordinate

Drag and drop something like a typeface into the program, get an object to do things on, like .set default typeface

Whenever you change the interface like that, confirm in 30s or it goes back.


Natively LLM lock from query to target where target is some fixed name from a map of keys. Technically these could be arbitrary structure again, how to put that in the language model? How to select from all possible contextually set values. Also add memory in the sense of particular keystrokes resolve to some value. (Like ide templates) And historically found maps also influence the mapping

Show the LLM query as code, which executes some underlying code. So things like if <>

Hold something like ALT + click to spring new window at location when starting to type.

Alternative to using dots . to call functions, use spaces like a terminal command git clone arg arg -arg. 

Directory is similarly just some command matching to some structure as /*/ (looped). You want things like select directory location, then apply function there like .open or other manipulation once it's selected as an object.

Directory string type is ([A-Z]:)?/(dir name)/? looped, and then we define operations like .open() you on type Directory. 

"on startup" enter, enters a new file ; file more generally as context, which is hooked to startup, after all the other startup scripts. Then some way to open the startup script which serially shows all the contexts as if they were a single file/context - since there is an order to them.

"directory string" enter, then genereally any . method that follows is using rhe most recent variable declaration. But the result of .open wouldn't be a declaration (unluss explicitly typed) - others this would change the most recent for

No "" or ' for strings, use tab or enter to exit it as a token. Use ctrl enter/tab for \t en \n. If accepting function doesn't allow for a space in the current position, space too exits the token. 

Mouse hover next to it should allow you to exit the context too (in case of people forgetting the tab for instance) visually a terminal button shows up?

Ray functionality is at RAY.<> =, 

~= Additional assignment, nonoverriding


---
###### Worlds

Some other primitive instantiation like function, but imbued with a minimap/item (artifact)/world -like property. With possible internal dynamics, yet still usuable like a function (to some other structure (type)). 

- Similar to function a world like that can be influenced by surrounding context (say the rest of the project/language/file. Or even exotic things like abnormal deviations from execution semantics.

  

Indexed similar to function by a name, but also a symbol/image/structure.

  

The the location the "item/spell/world" is applied to similarly has to acknowledge/allow acess to it, whether read, or some other "write"/interact access the function is supposed to alter it. 

  

("The location" here, automatically also links to a separate UI interface which is a way of selecting that kind of location. Or in the code sense it would remain with text.)

  

That way you can have arbitrary functions on one side, being passed to some location, which in turn needs to accept/allow certain kinds of interaction.


icon/structure/minimap; are different rendering perspectives


What about returning a program as a next step? Say you'd have some projectile, which is a function applied to a location, returning a program which applies it to the next location. Keep doing that until? 

Function is applied to location (or type x)
Item is applied to location (or player or type x)

**Item and functions have a user/player attached to them.**

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
- Multiplayer

###### Examples
- 2d finite vs infinite grid, x-y axis, equal in length, every next value is not in all the other axis (stable 2d growth at each step) .dimensionality() == 2 (AND) .dimensionality change at every point is constant. 2d grid of overlapping graphs for X/Y vs a normal single graph with dimensionality 2. (every x goes to an x, every y goes to a y)
- Object as a type is a list of KV pairs, so type is a loop of KV pairs, where that loop is on the context equivalency ray. keys are unique
- Movement with float values.
- mapping a string expressing regex to a similar pattern what the regex means.
	- Look ahead/behind: Is just matched but unnamed. And anything before lookahead is grouped into an indexed group; $1.
- varargs as pattern match: What function parameters really are, is some pattern matched on a structure, and names attached to different parts of that pattern. Take for instance, varargs: [a, b, ...z]. .OR on zero-length terminal to a vertex.
- Subtraction is more complicated than performing addition, for subtraction you need to know a length, unless you just cut something off without knowing how long it is.
- 2d grid expansion as an example base rewrite rule, "expand loop"
- Boolean: Normal way of thinking about a boolean is .orbit we assume modularity of booleans
- Numbers, Integers, base-n, fractions, floating point
	- .add integers: single equivalence (initial from one side, terminal from other side.) 
	- Number returns a type of number which is a cursor on a graph. (The graph being the numberline) For example .next on a decimal number is an infinitesimal node after the current one. But we can still use operations like >/</..
	- Negative numbers
		- - ; a +reverse before applying  
		- -number structured how? Just the same number but on a different position in the numberline?  
		- What would a .minus()/.neg look like? How is it different from reverse
	- Real numbers; something like a loop on another level than the usual structure is a simpler way to have it, assuming we somehow assume that the loop os realized. Otherwise what would the structure look like?
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




export const is_number = (value: any): value is number =>
  typeof value == 'number' || (is_object_like(value) && base_tag(value) == '[object Number]');

export const is_iterable = <T = any>(value: any): value is Iterable<T> =>
  Symbol.iterator in Object(value) && is_function(value[Symbol.iterator]);
export const is_async_iterable = <T = any>(value: any): value is AsyncIterable<T> =>
  Symbol.asyncIterator in Object(value) && is_function(value[Symbol.asyncIterator]);




```

