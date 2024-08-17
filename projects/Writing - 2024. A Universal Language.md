*Let's try for [[2024-12-31]] ; - Yearly excerpt of thoughts*

"Capturing: What is the essence of differences and similarities"

*Thoughts going over 2022-2023 notebook (reprocessing)*
- [ ] Current setup of Rays solves structure only. Need some slight alteration to include causal history (one-way referenced structure) & traversal/rewrite intentions (**superposed** extremes).
	- [ ] "Draw a line between anything and say 'what if they're the same'"
	- [ ] How to think about non-realized functions usefully. Say coordinates to some non-realized geometrical space. (Similarly: locations of information and their retrieval)
	- [ ] Type information + selection combination
	- [ ] Canonicalization/deduplication (Ignores a single ray, what if more)
	- [ ] Memorization vs rerunning
	- [ ] Better notion of functions (non-terminating; orbits) & variables (; replacing structures with others matching either in that structure (;rewrite) or variable replacement (; replace on inaccessible abstraction level ; ex. no nice mappings)) 
	- [x] Notion of inaccessible additional complexity (say some javascript object which is not accessible but we can still use/return)
	- [ ] How about inaccessible structures, like some mapping we don't have access to (say: input&output only, nothing in between)
	- [ ] Way of dealing with orbits, realization of them, and switch to a variant which is aware of the orbit??? (ref on boundary now?)
	- [ ] .terminal = .initial (self-referential ray like this)
	- [ ] **Ordered/Unordered**: It is ordered from one perspective, unordered from another.
		- [ ] Causal = ordering = sorting = indexing = assymmetry = variance ; grouped usefully
	- [ ] **Modularity, Loops, Cycles**: **Important property which needs better phrasing - and current setup can't capture this nicely: In order to point out acycle, you are required to have some way of breaking that symmetry ; so any cycle has some notion of ordered/.../labelled. Similarly any asymmetry can be made cyclic by ignoring the order.**
		- [ ] "Can abstractly only satisfy a loop/modular structure through another loop? While pattern matching?"
		- [ ] Similarly, always a "superposed type" ; as structure??
		- [ ] Permutation selection of modular structures, to iterate over each possible selection
		- [ ] .orbit: modularity by default? (turn off by splitting the boundary in two. Could do this locally with a wall)
	- [ ] 
	- [ ] Way of interpreting possible representations (as equivalences, but then for a particular purpose);
	- [ ] Propagate next time step: each ray with a separate causal history
	- [ ] What if the `.initial` is many, instead of relying on a single one which branches to many. So how Chyp's edge's work: many sources, to many targets. Could also use like `.self` that `.initial` & `.terminal` are necessarily an equivalency frame, where it's not obvious that there's a connection back. So there's a difference in `.self` & `.initial/.terminal` - remove this difference?
- [ ] Factory (Version Control, Causal histories, ..., Compression): Setup to constantly grow whatever in-memory graph/equivalences are found, get to this place so we can start iterating on discovery functions. (Good notion of causal histories & orbits needs to be there)
	- [ ] Notion of queues, resources (storage, capabilities), ..., priorities
	- [ ] Build up store of equivalences & patterns in some structure.
	- [ ] Notion of some intermediate state matching a selection
	- [ ] Causal history = coherence conditions ; ex: some input-output relation where some binary value switches, coherence in mapping 0 -> 0, 1->1, but change in selection.
	- [ ] "Measure of how hard something is to do in parallel (or in some other structure generally)" - differentiability of [[Project - Indexing existing Abstract Models (2024-2025?)]]

---

vertex = graph which defines edges  
edge = initial/terminals defined on vertex  
-.- = ??? defines two sides of an edge and a way to reference it, .self not sccounted for  
hyperedge: follow entire initial/terminal, skip the .self (-.-)  

vertex; graph of edges in/out  
edge; graph of vertices it's made out of  
  
Vertex references another vertex  
edge references another edge

Vertex - follow graph, match for Initials (Outgoing Edges) & Terminals (Incoming Edges)
Hyperedge - follow graph, match for Vertices (graphs of initials/terminals)

Vertex in a normal graph is like a hyperedge?

In hypergraphs, the vertices and edges are separated, in the case of reprogrammability, this becomes less obvious; When vertices mention vertices instead of edges, and edges mention other edges instead of vertices, determining whether something is an edge or vertex becomes contextual/.../dynamic.  

What about dynamically changing rewrite rules, are those explored by anyone? ; some form of reprogrammability as foundational

---


Unprocessed
- [ ] Streams 2023
- [ ] Screenshots
- [x] [[Symposium on Compositional Structures (SYCO)]] notes
	- Universal as in context independence. Then rewriting is harder.  
	- inability to do the tensor operation is what defines irreversibility?  
	- Programming with edge relationship looked interesting  
	- Ignorance of the functor is absolute equality
	- Yeah you make the symmetries an asymmytry by having it described on another level of descripton as how the traversal is done.  
	- Structure on the edge, as a way of asking for types, basically pu tstuff as typingfinding on the terminal/initial  
- [ ] Rendering Engine ->, work backward

---

parallel just means composing boundaries of either terminals, or initials.

`.self`: What is our current position? (can dynamically change) - "Moving an abstraction layer lower - what's inside?"

`.initial/.terminal`
- .initial/.terminal could be seen as a part of .self, but you can only say that if you can make it separable. (So .self ignores it, hence it's different.)
- If no terminal - .self or .terminal

`.is_extreme`
- Extremes as superposed pattern matcher.

`.equivalent`, `.is_equivalent`
- Equivalence at continuation is parallel composition

`compose`, `.is_composed`

`.all`
- Prepare on the boundary, then shove it through. - lazy func
- `.all` if looking for boundary (extreme), `.any` if looking for vertex. 

`.traverse / .all / .map / .any
- places another ray at another level of description points to initial/self/terminal, then starts traversing
- Latch the initial, latch the .self, latch the .terminal, and we determine movement.
- those traversal layers on branches which dont go left/right but only one direction?
- Ignorance/equivalence along arbitrary rays. = Equivalence

`.memoized`
 - .memoized is always orbit consistency in anything we traverse

`.rewrite`, `.replace`, `.collapse`
- start with one, find match, then match entire structure and revert if not. ; one way. Detach and reattach.
- Local modular structure: left/right collapse simultaneously to get a modular rewrite in ; then check locally to break the recursion.
- Switch perspective is switching names of functions
`.reverse`
		# @see "Reversibility after ignoring some difference": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility  
		# @see "More accurately phrased as the assumption of Reversibility: with the potential of being violated.": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20Assumptions%20%26%20Assumption%20Violation

`.none` 
There are many ways of phrasing ; "it's explored/.../branched but dies", ..., "looked at, then ignored".
- none: initial direct to terminal, no vertex in between. & reference none for "select none"
- caollpse the loop with an extreme, setting both initial/terminal to none for that step, forcing? "collapsing infinite with extreme idea??"

`.orbit`
- Note that an orbit means reversibility (if no other context changes, and if we ignore the cursor)
- This is what breaks our recursion. An equivalency we don't have access to.- It halts the program. (["And there we have it ..."](@see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=And%20there%20we%20have%20it%2C%20an%20infinity%2C%20loop%2C%20...%2C%20orbit%20if%20we%20ignore%20the%20difference.))
- *this or superposition, what's the difference?*: This self-loop breaks the recursion because it self-referentially answers the question of: "The only thing you'll ever find here is that same structure you already had, without having to traverse that structure."


- Coherence
	- This tries for "global coherence" - which just means a self-loop where no change is assumed in surrounding context (obviously inconsistent, but that doesn't matter).
	- "it is expensive work to edge towards global coherence." ? To ensure consistency in some way
- Collapsing to a point (from both sides)

- Boolean
	- Normal way of thinking about a boolean is .orbitm we assume modularity of booleans
	- Hence the difference between add/sub and a normal boolean. Is context. What add/sub is applied to; i.e. what effects it has.  

`.add`, `.and`, `.assign`, `.superpose` : Compose an `initial & terminal` (.add is compose boundaries)
- .add integers: single equivalence; ` on vertices -> equiv initial from one side, terminal from other side.)

`.set`, ` = `, `assign` (add to (compose with) `.self`)
- Close to `.and`
- Assign in the sense of adding to existing equivalences: i.e. offering a specific implementation for a certain thing, vs the destroy of them and replacing it with something specific: i.e. removing all existing assigns and setting a single one.

`.reference`
- reference as orbit/constant/repeats maybe

`.copy`
- Problems with copy
	- A problem with a copy, is that in or to be generalizable, it needs to alter all references to the thing it's copying to itself - this cannot be done with certainty.
	- "A copy is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=If%20I%20have%20one%20thing%20and%20I%20make%20a%20perfect%20copy
		- "Also ref to things like 'no cloning theorem'? Or ref to 'absolute equality'"
	- Performing a copy (realizing it) can be conceptualized as traversing the entire structure. - and splitting off a copy through the traversing rays (can thus be parallel traversal as well)

`.equivalent`, `.compose` ; up the arity, probably makes less sense?
- `.is_equivalent = a.self.traverse.is_orbit(b.self.traverse))` Basically: does there exist a single connection between the two?
- equivalence is an inconsistency from some perspective (and the other way round)
- Collapsing to a point (with(/out) a additional filters, ..., ignorances) (where/if)
	- Homotopy equivalence: When superposed perspectives can be collapsed to a single point.
	- Cohomology, ..., not collapsable if something stops this from happening.

##### "Superpose in more detail"
- `qubit / linear superposition / complex numbers` is a binary superposition, ..., orbit, which is differentiable in between steps (basically, if something else from outside the context can reach in between, it would find something there. ; Based on that precision). So `qubits, orbits, higher-arity structures, ignorance along rays`, same thing?.
	- Usual superposition is where every entry of an arbitrarty direction only references itself on the `.self`. Hence a tensored variant like this in linear time, if you can traverse that in one step.
	- DIfference between a bit and a qubit is that in the case of a qubit we assume differentiability between?
	- [[PENDING (2027?+) ; Physics (& Hardware)]] - Wave function collapse ; how does that look like for a simple structure, and a more complicated one? Snapping to specific value or?

- Reprogrammability
	- What does it mean for a point yo become its own direction? 
	- Data becoming function, geometry etc..


---

#### Universal Version Control
- [ ] Arbitrary (partial, ..., incomplete) history of arbitrary functions, rewrites, ..., data types (generalized to some arbitrary Ray).
	- [ ] This then includes the automatic inclusion of existing data structures
		- [ ] Automatically includes DPO(I), ..., Git histories.
	- [ ] Allow for the realization that any arbitrary part of the rays are destroyed (this could include local connectivity).
- [ ] Can have a history, but no current value. No structure, ..., type, permutation information on, ..., between vertices except for that of something we identify as history.
- [ ] Arbitrary initial setup not necessarily optimal version. And through time find more optimal one's given a particular situation. (Hence just apply the same version control system on the version control system itself.)
	- [ ] Thus requires the automatic shifting between possible ways of representing histories.
	- [ ] This thus includes a way of mapping perceived geodesics.
- [ ] Unrolling of loops, ..., orbits, and setup argument for what kind of information one needs to differentiate between iterations of that loop, and possibly what certain initial places were.
- [ ] Which I believe was something along the lines of seeing where certain changes had happened in dependencies/how that would break symmetries, notify that they have changed and need human attentioin overarching features of some programming language (across some versions), and provide entry into what is not defined. (this a ref to the robert project)

- [ ] How to separate one's personal work, how to combine them, merge them, view them from the outside.

## Rendering engine
- [ ] Provide easy portability away from the current setup "Provide me with this and I'll recompile it into what you want"

Visualization changes
- Small ring outline in continuation + vertex?
- Intersection on screen been non-intersection in the structure, way of rendering it. (Overlapped on the screen vs overlapped in the representation)

Intro
- Ring in the middle rotsting, then expand, transparent background. grow into orbitmines logo then blank sheet, waiting for use
	- grow from there structure onto the screen, superopositions, grow, collapse, grow..., nice animation for startup.
- Ray growth over some grid as the 3d rendering engine
- ring expanding then collapsing to a point. OM logo in the middle? ; small key to explode to outside
- Rotate the whole thing / orbit local pull everything in
- 

Header
- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail

### Initial interface setup
[[Project - Research towards Designs (2024)]]

[Whatever this interface will look like, it necessitates conveniently being able to change **anything** about how it looks, ..., how it operates *from the interface itself*.](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project/#:~:text=Whatever%20this%20interface,the%20first%20case%3F)

- [ ] Track program, rotation, ..., interface movements. Possibly replay at some accuracy. (Some directionality seen as temporal as to interface inputs.) ; causal histories.
	- [ ] possible: log the things one might want to undo to, instead of logging the thing something currently is after applying something  
- [ ] Test on different OS & browsers
- [ ] Non-jumpy - stability ; Important to not have jumpy interface things like obsidian, which are so sensitive to where the mouse or selection is?
	- [ ] [There must be some sense of stability in the interface. Though many interesting things will probably be more visually unstable.](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=There%20must%20be%20some%20sense%20of%20stability%20in%20the%20interface.%20Though%20many%20interesting%20things%20will%20probably%20be%20more%20visually%20unstable.)
- [ ] orbit matching whole thing or not, hence prine number maybe
- [ ] going around the loop constantly ignoring dropping the one connection, unrolling the line on the loop, if both are a loop, could keep going / oscillate, or things like larger extent compare, or same frame cancel out when intersect  

 [You need to be able to deal in *questions* of different levels of abstraction, description, ..., scales, when each layer introduces arbitrary complexity. This is not simple scale invariance.](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=You%20need%20to%20be%20able%20to%20deal%20in%20*questions*%20of%20different%20levels%20of%20abstraction%2C%20description%2C%20...%2C%20scales%2C%20when%20each%20layer%20introduces%20arbitrary%20complexity.%20This%20is%20not%20simple%20scale%20invariance).


*Use the graphical rendering as the language/data embedded.Just put hte ray interface on top of that.*
- Both sides, drop the initial/terminal, grow to either side initial if initial, terminal if terminal. Then stitch the two together.    
- Resolve parallel threads doing this by just the same merge operation?
- simple loop where initial terminal setached from base, remains simple loop on where it goes, shrink to point, repeat, could be possible
- moving along just moved a single ray, both structures intersect move throygh rach other from some other perspective ; Then whether it's ignored/branched, or doesn't interfere with each other.
- Drop the self-loop from on-orbit check ; peek by going there, then one more step, and dropping .self and moving back to terminal


## Web (WebGL/threejs), .. downloadable variant (Electron initially)
- Simple web setup for localstorage

---
###### Examples: Delayed till working implementation
- [ ] Expanding superpositions to there permutations (a simple rewrite rule?) - For the general case? (/combinatorics).
- Folding ray on high-dimensional tensor. Or some GPU operators.
- Tensor
	- TODO: match, switch, enum (like key=value), dict, keyvalue, pair, ....  
	- TODO: zip, tensor (are these the same as match/switch?)
- xor/xnor is close to   # TODO: Could be 'is_equivalent' too? or is_orbit  ?
- similar to next/anext into python await operator?
- Encoding: Usually ignorant of its use
- Superposed different inconsistent/logical systems
- What can be done in parallel ; preference for it. So move to stacking in multiple layers parallel composed for execution. Need a practical example ffor this.
- Link back to the other stuff from the notebook as well:
	- "Binary": just list a few possible ways of constructing it.
		- binary reverse op is also conceivable as initial/self/terminal over two possible values
		- orbiting ray around it / bouncing off the edges ; generalize
		- ...
		- Perspective of 0/1,
	- Tripple superposition
	- modular numbers
	- p-adic numbers
	- sierpinski etc.. a xor b = a+b ; boundary is addition of boundary/self-loop?
	- ....
- Separate example of homoiconicity, move along/switch position through two local changes, or something more interesting ; take entire structure, and place at some selection.

- Could link the practical ignorance/intelligence to partially reversible ignorant compression - or just ignore these for now  
- pond example


---

Process:
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction

postponed (from 2023):
 * TODO ; Composability is Non-locality?  


```py
# def free(self): raise NotImplementedError
# TODO: Destroy the current thing, connect .initial & .terminal ? (can do just direct connection, preserves 'could have been something here') - then something like [self.initial, self, self.terminal].pop().
# TODO: Leave behind --] [-- or connect them basically..
# TODO: Could lazily try to find references., garbage collectors and other concepts like it.
# TODO: Maybe want a way to destroy from one end, so that if other references try to look, they won't find additional structure.
# TODo: __anext__ in python case might need addition async def setup? - How is that interpreted as operators for awaitable?


@staticmethod
# - TODO: readonly setup, where only traversal ops are allowed. Of course these are writing in some sense, but those writings aren't directly accessible from this perspective
def readonly() -> Ray: raise NotImplementedError
# TODO: Runtime with its read/writeonly, basically (non-/)availability of write operations. Where read operations are already also write operations from another perspective, just not the one accessible here.

# TODO, writeonly would be?

# Any arbitrary direction, where reversing the direction relies on some arbitrary memory mechanism
def memoized(self) -> Ray:
# = cached
# TODO: Better ideas what local caching looks like, (i.e. put it in some local structure to cache, this can be delayed till some useful implementation is ready)
# res = self.next
# res.initial = self    # return res    raise NotImplementedError

def push_back(a, b: Arbitrary) -> Ray: return a.last().compose(b)
# TODO: lshift/rshift respects the .size of the ray. So it's push_back & pop front, or in certain interpretations, we might keep and not pop...

def from_perspective_of(a, b):
  raise NotImplementedError
def perspective(self) -> Ray: raise NotImplementedError

# def filter / search

kwargs / args  # TODO: Named args in the sense, similar to class definition, in the sense that they equivalences on the existing functions. Again this thing of assign.



# EXTREMES
# Traverse as extreme>?

# .next/.has_next/.last
# .previous/.has_previous/.first
# .boundary/.has_boundary/.extremes

#
# - Like with 'copy' and all concepts: Note that we're only after reversibility after ignoring some difference.  #  # @see "Reversibility is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility
# TODO: Make use of extremes (.last/.first as extreme
def orbit(a, b: Arbitrary) -> Ray:
  # - TODO: If we're only doing one end: This already assumes they are connected on the other end.
  # - TODO: should be a connection here, with is_composed ; or "reference.is_equivalent" so that you can drop one of the sides, or both.
  b.last().compose(a.first())
  a.first().compose(b.last())

  return a

# TODO: Other layer of abstraction waiting for .next step function - will hook into anything that finishes, and allows already composing stuff after .last .
def last(self) -> Ray: raise NotImplementedError


def has_next(self) -> Ray: return self.next().is_some

# COPYING
# Copy by adding a one-way reference to the same thing or duplicating the structure (slower often)
# def size/copy
#
```


```ts
import _ from "lodash";  
  
export type Function<T = any> = (...args: any[]) => T;  
export type Dictionary<T = any> = { [key: string | symbol]: T }  
  
// TODO Copy from lodash - remove as a dependency.  
export const is_boolean = (_object: any): _object is boolean => _.isBoolean(_object);  
export const is_number = (_object: any): _object is number => _.isNumber(_object);  
export const is_object = (_object: any): _object is object => _.isObject(_object);  
export const is_iterable = <T = any>(_object: any): _object is Iterable<T> => Symbol.iterator in Object(_object) && is_function(_object[Symbol.iterator]);  
export const is_async_iterable = <T = any>(_object: any): _object is AsyncIterable<T> => Symbol.asyncIterator in Object(_object) && is_function(_object[Symbol.asyncIterator]);  
export const is_array = <T = any>(_object: any): _object is T[] => _.isArray(_object);  
export const is_async = (_object: any) => _.has(_object, 'then') && is_function(_.get(_object, 'then')); // TODO, Just an ugly check  
export const is_error = (_object: any): _object is Error => _.isError(_object);  
export const is_function = (_object: any): _object is ((...args: any[]) => any) => _.isFunction(_object);  
  


import _ from "lodash";  
import {Dictionary, Function, is_boolean, is_function, is_iterable, is_number, is_object} from "./ray";  
  
export type Recursive<T> = (T | Recursive<T | T[]>)[];  
  
class Ray {  
  
  is_none = (self = this.proxy.self) => !('self' in self.self)  

  reverse = (self = this.proxy.self) => new self({ initial: self.terminal, self, terminal: self.initial })  

  
  static none = new Ray()  
  static initial = Ray.none; static self = Ray.none; static terminal = Ray.none;  
  
  static undefined = Ray.none; static null = Ray.none;  
  static boolean = (ray: boolean) => Ray.none; static true = Ray.none; static false = Ray.none;  
  static object = (ray: object) => Ray.none  
  static iterable = <T>(ray: Iterable<T>) => Ray.none  
  static iterator = <T>(ray: Iterator<T>) => Ray.none  
  static async_iterable = <T>(ray: AsyncIterable<T>) => Ray.none  
  static async_iterator = <T>(ray: AsyncIterator<T>) => Ray.none  
  static number = (ray: number) => Ray.none  
  static function = (ray: Function) => {  
    if (!is_function(ray)) return Ray.none  
  
    // const ray = Ray.__new__();  
    // ray.terminal = () => {    //   // const input = ray.terminal.terminal;    //   // const output = fn(input)    //   // input.terminal = output;    //   // return output;    //   throw new Error()    // };    // return ray    return Ray.none  
  }  
  
  static any = (ray: any) => {  
    if (ray === undefined) return Ray.undefined;  
    else if (ray === null) return Ray.null;  
    else if (ray instanceof Ray || ray.prototype === Ray.prototype) return new ray() // This is a copy  
    else if (is_function(ray)) return Ray.function(ray)  
    else if (is_boolean(ray)) return Ray.boolean(ray)  
    else if (is_number(ray)) return Ray.number(ray)  
    else if (is_iterable(ray)) return Ray.iterable(ray)  
    else if (is_object(ray)) return Ray.object(ray)  
    else throw new Error("Not implemented")  
  }  
}  
 
// This {1 -> self/self.self , & 2 -> a, b} could be generalized (is_none, is_orbit, ..)  
// Ray.is_none = (self: Self) => self.is_orbit(self.self)  
// Ray.is_orbit = (self: Self, other: Self) => self === other  
// // TODO: These likely change or merge, generalize ; perspective switch. ;  
// //   They are "is_" -> Does there exist a connection between their `.self`'s ; or basically is there an orbit (so bi-directional), and one-way would be?  
// //   composed: a.traverse().is_orbit(b.traverse()) // Basically: does there exist a single connection between the two?  
// //   equivalent: a.self().traverse().is_orbit(b.self().traverse())  
// // #    - in the case of 'is_equivalence' we directly have access to their difference but are explicitly ignoring them - in the context in which this functionality is called.  
// // #    - in the case of 'is_orbit', we might need to do more complicated things to acknowledge their differences - we don't have direct access to them.  
  
// // TODO: .is_equivalent & is_orbit are 0, 1, n perspective?  
  
  
// // TODO { self }, for .reference.as_initial, if it's just .as_initial, we need to break it apart  
// /* */ Ray.as_initial = (self: Ray) => Ray.initial({ self })  
// /* */ Ray.as_vertex = (self: Ray) => Ray.vertex({ self })  
// /* */ Ray.as_terminal = (self: Ray) => Ray.terminal({ self })  
// /* */ Ray.as_reference = (self: Ray) => Ray.reference({ self })  
  
// Ray.all = TODO: .all is a move to .initial (as a reference).  
// Ray.cast = <T>(self: Ray): T => { throw new NotImplementedError() }
```


`.unordered`
	- Ref to initial/terminal enumeration / extremes somehow?

`.initial/.terminal = .is_none or this.initial = this.self`
- The difference being interpretation


```ts
const xor = (a: boolean, b: boolean) => (a && !b) || (a! && b)  
const nor = (a: boolean, b: boolean) => !(a || b)  
  
let join_iterators = function*<T>(...iterators: Iterable<T>[]) {  
  for (let iterator of iterators) yield* iterator;  
};  
  
class Ray<T = any> {  
  initial: Iterable<Ray<T>> | undefined  
  self: T  
  terminal: Iterable<Ray<T>> | undefined  
  
  compose = (b: Ray<T>): Ray<T> => {  
    this.terminal = b.initial = join_iterators(this.terminal, b.initial);  
    return this;  
  }  

  is_reference = () => this.is_initial() && this.is_terminal();  
  is_boundary = () => xor(this.is_initial(), this.is_terminal())  
  is_vertex = () => nor(this.is_initial(), this.is_terminal())  
  is_extreme = () => this.is_none() && this.is_boundary()  
  is_wall = () => this.is_none() && !this.is_initial() && !this.is_terminal()  
  
}
```
