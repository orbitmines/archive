*Let's try for [[2024-12-31]] ; - Yearly excerpt of thoughts*

Unprocessed
- [ ] Some of the notebooks from 2023, Streams 2023
- [ ] Rendering Engine ->, work backward.

---

Basically; some of these aliases are probably more appropriate as separate perspectives.  

parallel just means composing boundaries of either terminals, or initials.

`.initial`


`.self`: What is our current position? (can dynamically change) - "Moving an abstraction layer lower - what's inside?"
	`this = .self`: Equivalency Ray = Context Ray? BETTER NAMES

`.terminal`
- .initial/.terminal could be seen as a part of .self, but you can only say that if you can make it separable. (So .self ignores it, hence it's different.)
- compile/render/map/cast/.realize/ ... probably fit in that separate category/level of abstraction
	- expected not to have alternative behaviors based on binary/ternary calls

`.is_extreme`
- Extremes as superposed pattern matcher.

-> This needs a better pattern for the different abstraction layers. (for everything)
`.equivalent`, `.is_equivalent`
- Equivalence at continuation is parallel composition
- 
`compose`, `.is_composed`

`.all`
- Prepare on the boundary, then shove it through. - lazy func
- `.all` if looking for boundary (extreme), `.any` if looking for vertex. 

`.traverse`
- places another ray at another level of description points to initial/self/terminal, then starts traversing
	- the "teleport over thing" could just be the calculus of slow destroying the green ray on a side of the direction you want it to move to, hence moving it from vertex to initial to following the thing
- Latch the initial, latch the .self, latch the .terminal, and we determine movement.
- Can implement the ignorances through
- those traversal layers on branches which dont go left/right but only one direction?
- split off branching initial remainin o. the temrinal the ret marching along
- Can just move the terminal which holds the pointer to the boundary
- Ignorance/equivalence along arbitrary rays. = Equivalence
- Undecided terminal for traversal / or break off structure to explore both.
- Hard to say it's terminating. Need an orbit for that, and access to your own modular structure to say that. Otherwise it's "open loop traversal". Which is fine, just no abstract realization. Simple example is references to references. Or keep going in orbits when you can shut off the traversal.


`.traverse / .all / .map / .any

`.memoized`
 - .memoized is always orbit consistency in anything we traverse

`.rewrite`, `.replace`, `.collapse`
- start with one, find match, then match entire structure and revert if not. ; one way. Detach and reattach.
- Local modular structure: left/right collapse simultaneously to get a modular rewrite in ; then check locally to break the recursion.
- Switch perspective is switching names of functions
`.reverse`
		# @see "Reversibility after ignoring some difference": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility  
		# @see "More accurately phrased as the assumption of Reversibility: with the potential of being violated.": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20Assumptions%20%26%20Assumption%20Violation

`.none` Many ways of phrasing this ; "it's explored/.../branched but dies", ..., "looked at, then ignored".
- none: initial direct to terminal, no vertex in between. & reference none for "select none"
- caollpse the loop with an extreme, setting both initial/terminal to none for that step, forcing? "collapsing infinite with extreme idea??"
`.orbit`
- .orbit by default (turn off by splitting the boundary in two. Could do this locally with a wall)
- Normal way of thinking about a boolean is .orbitm we assume modularity of booleans
- Note that an orbit means reversibility (if no other context changes, and if we ignore the cursor)
- This is what breaks our recursion. An equivalency we don't have access to.- It halts the program. (["And there we have it ..."](@see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=And%20there%20we%20have%20it%2C%20an%20infinity%2C%20loop%2C%20...%2C%20orbit%20if%20we%20ignore%20the%20difference.))
- This tries for "global coherence" - which just means a self-loop where no change is assumed in surrounding context (obviously inconsistent, but that doesn't matter).
- This self-loop breaks the recursion because it self-referentially answers the question of: "The only thing you'll ever find here is that same structure you already had, without having to traverse that structure."
- Here the collapse thing both sides?
- "it is expensive work to edge towards global coherence." ? To ensure consistency in some way
- 


`.add`, `.and`, `.assign`, `.superpose` : Compose an `initial & terminal` (.add is compose boundaries)
- and=and difference perspective (.add` on vertices -> equiv initial from one side, terminal from other side.)
- validity; checks as superposed maybe
- single equivalence?
`.set`, ` = `
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

`.perspective`
 -  "Applying the same thing in a different context"

`.equivalent`, `.compose` ; up the arity, probably makes less sense?
- `.is_equivalent = a.self.traverse.is_orbit(b.self.traverse))` Basically: does there exist a single connection between the two?
- equivalence is an inconsistency from some perspective (and the other way round)
- Collapsing to a point (with(/out) a additional filters, ..., ignorances) (where/if)
	- Homotopy equivalence: When superposed perspectives can be collapsed to a single point.
	- Cohomology, ..., not collapsable if something stops this from happening.

---

- It is ordered from one perspective, unordered from another.
- Causal = ordering = sorting = indexing = assymmetry = variance ; grouped usefully
- empty on .self, vs .self ref vs ref, ; selection of two boundaries.
- Only difference is the assymetry of is_orbit and the consequences of that if self/initial/terminal all are is_orbit that of another  
- Hence the difference between add/sub and a normal boolean. Is context. What add/sub is applied to; i.e. what effects it has.  
- "Measure of how hard something is to do in parallel (or in some other structure generally)" - differentiability of [[Project - Indexing existing Abstract Models (2024-2025?)]]
- Compiles to a sequence of traversal checks?, and setting ops?, and arbitrary many of them make up a program.  

##### "Superpose in more detail"
back & into.self

- `qubit / linear superposition / complex numbers` is a binary superposition, ..., orbit, which is differentiable in between steps (basically, if something else from outside the context can reach in between, it would find something there. ; Based on that precision). So `qubits, orbits, higher-arity structures, ignorance along rays`, same thing?.
	- ref on self-reference?
	- "Can abstractly only satisfy a loop through another loop? While pattern matching?"
	- Some way to conceptualize a qubit as pattern matched on any other thing ; similar to the "push structure inside thing."
	- ; So that would be like finding the higher-arity structure there, and selecting it like the vertex on vertex, having it branch off.
	- ; So similarly, it's infinity groupoids which break the recursion of the stack. So the `.is_orbit`s.
	- Usual superposition is where every entry of an arbitrarty direction only references itself on the `.self`. Hence a tensored variant like this in linear time, if you can traverse that in one step.
	- At every branch cotains the one added thing necessary for spliting the vranch for conservation, but that destroys the embedding if that wnats to be prrserved, ?
	- DIfference between a bit and a qubit is that in the case of a qubit we assume differentiability between. But for a bit also we assume modularity of the two options. Or different boundaries, What about on the frame/middle, what about ...
	- Wave function collapse, snapping of connection to the frame. Binary superposition to binary value ; but then for supoerposed 2d- grid ?? - need to understand this better. Or switching from boundary ref to ref on value & modular collapse?

direction at the point**: What does it mean for a point yo become its own direction? ; function becoming data becoming toplogies becoming ..

Local .orbit instead of composing at .terminal? ; pulling further-away stuff into this ; locally

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
- Chyp
- Physics also / superposition ; Using them for fractal expansion - shoving structure in between
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

postponed (from 2023):
Some concepts from 2023:
```ts
/**  
 * Orbits: Equivalence at Continuations * Equivalence: Variance made Invariant (Ignored Variance) * Inconsistencies: Variance * * * Equivalence ; Pattern matching, Assumption, Variance made Invariant (Ignored/Deemed Irrelevant/../Dropping/pruning/deleting Variance), Symmetry, Invariance, Consistency, Equality, Equivalence, Superposition, Well-defined/Ignored Ambiguity, Duplication, Parallel, Persistence, Coherence, Same, Similar, Complete, Memory, Inertia, Intuition, Fidelity, Reproducibility, Stability, Isomorphism, Reversibility, Deterministic (Identifiably mechanistic/Predictable/High-fidelity - Decreasing Perceived Randomness/Arbitrariness - Perhaps eliminating/Reducing superpositions/../ambiguity), Holonomic system, Constant, Fixed Point, Halting, Orbits, Copy, Redundancy, Caching, (Ignored implementation details), Translation, Compiling/Supercompilation/.../Meta-Compilation - differently ignorant on certain scales, Undirected, (multi-/arbitrarily complex structured-/)Computational,Non-distinguishability, Analogy, Distill, Confluence, Termination, Predictability (High fidelity), Lossless, Compression, Attention - Ignorance of something, Ignorance, Survivability, Cast, Interpretability, Fidelity Checking, Dimension, Continuation, Generalize, Universal, Sorting * * Inconsistency ; Variance, Assumption Violation, Hacking/Vulnerability, Divergence, Anomaly, Separability, Forgetting ((Realized) temporal non-trivial inability to resolve references), Refuting, Deleting, Evolution, Unintended/Accidental/Irrelevant Variance, Non-consistency, Non-modelled effects, Unknowns, Uncertainty, Asymmetry, Inequality, Sequence, Time/Temporary, Incoherence, Difference, Incomplete, Non-deterministic (if assumption violated), Non-holonomic system, Gravity, Curvature [ref; Inability to categorize with some small set of variables - Jonathan Gorard's tweet], Change, Selection, Ill-defined, Ambiguous, Confusion, Undefined, Sparsity?, Transformation, Describing, Separability, Directed, Movement, Propagation, Distinguishability, Inhibition, Pointer, Encapsulation, Transduction, Lacking access, Furthering, Obsoleting, Enhancing, Fallibility, View, Traversal * * Structure, Configuration, Selection, Symbol, Token, Connection, Communication, Possibilities, Enumeration, Spatially/Space, Time, Arbitrary Naming / Labelling, Functions, Morphisms, Rewrite Rule, Rays, Dynamics, Movement, Processes, Systems, Generative, Generators, Superposition, Encoding, Property, Value, Path, Hierarchy, Tree, Program, History, Causality, Version-Control, Instance, Object, Phrasings, States, Constructions, Worlds, Universe, Background, (Non-/)Context, Frame, Reference, Overlap, Merge, Cardinality, Node, Strategy, Tactic, Sheaf, Foliation, Slice, Type, Static/Dynamic, Knowledge, Squared, Defaults, Extreme, Abstraction, Simulation, Emulation, Projection, Heuristics, Inhibition, Regulation, Conjecture, Redundancy, Density, Property, Relation, What-if, Phase, Definition, Encompass, (Positional) Encodings, "Different levels of description", Levels, Scales, Complexity, Data, Runtime, Vibration, Arbitrary, Random, Limited/Limit/Limitations, Constraints, Resources, Pressure, Priority, Interpreted, Interacted, Observed, Initial, Terminal, Result, Conclusion, Fluidity, Output (Realized change by the system), Layer * Distance, Locality, Closeness, Approximation, "Practical Equivalencing/.../Ignoring", (Computational) Effort, Complexity, Relevance, Non-trivival superposition (e.g. any equivalence), Impreciseness, Less Actionability, Trivial/Non-trivial, Conditionally (Circular), Guarded, Partial, Skipping, Teleporting, Encryption, Disambiguation * * TODO ; Composability is Non-locality?  
 * TODO ; Encoding is usually Ignorant of its use  
 *  
 * ; These are just the same sort of thing from different perspectives, you need additional context for separation of concepts/.../duals - And separation is likely somewhat arbitrary and inconsistent - but that doesn't prevent them from being useful. */
```

Python def
```py
# def free(self): raise NotImplementedError
# TODO: Destroy the current thing, connect .initial & .terminal ? (can do just direct connection, preserves 'could have been something here') - then something like [self.initial, self, self.terminal].pop().
# TODO: Leave behind --] [-- or connect them basically..
# TODO: Could lazily try to find references., garbage collectors and other concepts like it.
# TODO: Maybe want a way to destroy from one end, so that if other references try to look, they won't find additional structure.
# TODo: __anext__ in python case might need addition async def setup? - How is that interpreted as operators for awaitable?

def reverse(self) -> Ray:
  return Ray(initial=self.terminal, self=self.self, terminal=self.initial)
def as_string(self) -> str: raise NotImplementedError
def as_int(self) -> int: raise NotImplementedError
def as_list(self) -> list: raise NotImplementedError
def as_tuple(self) -> tuple: raise NotImplementedError
def as_iterable(self) -> Iterable[Ray]: return self
def as_async_iterable(self) -> AsyncIterable[Ray]: return self

# @staticmethod
# def ring() -> Ray: return Ray.none.orbit TODO, modulus by default ;


# def __iadd__(a, b: Arbitrary) -> Ray: return a.assign(a.add(b))
# def __isub__(a, b: Arbitrary) -> Ray: return a.assign(a.sub(b))
# def __imul__(a, b: Arbitrary) -> Ray: return a.assign(a.mul(b))
# def __ipow__(a, b: Arbitrary) -> Ray: return a.assign(a.pow(b))
# def __itruediv__(a, b: Arbitrary) -> Ray: return a.assign(a.div(b))
# def __imatmul__(a, b: Arbitrary) -> Ray: return a.assign(a.matmul(b))
# def __ibor__(a, b: Arbitrary) -> Ray: return a.assign(a.bor(b))



aliases
# .none @alias('alloc', 'new', 'create', 'initialize')
# .some @alias('self_reference')
# .reference @alias('pointer', 'cursor')
# .free @alias(destroy = clear = delete = pop = prune)
# .compose @alias(continues_with, merge)
# .last @alias( end = result = back = output = max)
# .orbit @alias(modular, modulus, circle, repeats, period, infinitely)
# .__eq__ @alias(is_orbit)
# .__and__ @alias(_and)
# .__or__ @alias(_or)
# .__add__ @alias(add)
# .__sub__ @alias(sub)
# .__pow__ @alias(pow)
# .__trudiv__ @alias(div)
# .__xor__ @alias(xor)
# .__matmul__ @alias(matmul)
# .__mod__ @alias(mod)
# .__ge__ @alias(greater_than_or_equal_to)
# .__lt__ @alias(less_than)
# .__str__ @alias(as_string)
# .push_front @alias(__rshift__)
# .push_back @alias(__lshift__)
# .first @alias(beginning, front, min)
# .__aiter__ @alias(as_async_iterator)
# .__iter__ @alias(as_iterator)
# .boolean @alias(bit, two)
# .reverse @alias(neg = __neg__ = __invert__ = opposite = _not = converse = negative = swap)
# .self @alias(element = dereference = selected = selection = cursor = auto) # TODO: branch?
# .terminal @alias(next = __call__ = __next__ = __anext__ = forward = step = apply = run = successor \
    = map = render = compile = realize = generate)
# .initial @alias(previous = backward = decompile = predecessor)
# .__set__ @alias(assign)
# times @alias('resize', 'size', 'structure', 'length', 'duplicate', 'copy', 'clone', 'times', 'mul', '__mul__'), generalized: size/shape/..
# equiv/compose ;  # @alias('includes', 'contains') ; (slightly different variants?)

reverse
# TODO ; Could also be implemented as copy - hence the __call__ on Ray() - this is the case for any sort of constructor/type.

size/add/pow... (basically copies/merges, different perspectives/context)
  # size = length = no params different behavior
  # resize = structure  mul = __mul__ = times
  # duplicate = copy = clone = size.from_perspective_of


#
# Python runtime converters  #
@staticmethod
def integer(val: int) -> Ray: raise NotImplementedError
@staticmethod
def iterator(val: Iterator[Any]) -> Ray: raise NotImplementedError
@staticmethod
def iterable(val: Iterable[Any]) -> Ray: raise NotImplementedError
@staticmethod
def string(val: str) -> Ray: raise NotImplementedError
@staticmethod
def false(): return Ray.boolean(False)
@staticmethod
def true(): return Ray.boolean(True)
@staticmethod
def obj(val: object) -> Ray: raise NotImplementedError
@staticmethod
def arbitrary(val: Arbitrary) -> Ray:
  if isinstance(val, bool): return Ray.boolean(val)
  if isinstance(val, int): return Ray.integer(val)
  if isinstance(val, str): return Ray.string(val)
  if isinstance(val, object): return Ray.obj(val)
  # TODO ... - Could do all through object/iterable in the case of python ...

  raise NotImplementedError

  #

#  TODO: Are these "GLOBAL" varibles from the perspective of the ignorant setup - or more accuarrately something which it could be made aware of.
# TODO: WHILE = WITH = SCOPE = CONTEXT = GLOBAL = //... (= DEBUG/LISTENER/OBSERVER/WRAPPER / MONAD)
enter / exit


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

Arbitrary = Union[int, Ray]

def as_javascript() -> str: raise NotImplementedError
def runtimes() -> Ray: raise NotImplementedError
def compiler() -> Ray: raise NotImplementedError


def radd(self) -> Ray: return -self.add.perspective
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