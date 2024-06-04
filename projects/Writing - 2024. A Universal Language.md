*Let's try for < [[2024-06-30]]*

Unprocessed
- [ ] (SEMF) Discord messages / livestream transcript
- [ ] Some of the notebooks from 2023

---

`.initial`


`.self`: What is our current position? (can dynamically change) - "Moving an abstraction layer lower - what's inside?"
	`this = .self`: Equivalency Ray = Context Ray? BETTER NAMES

`.terminal`


`.is_extreme`
- Extremes as superposed pattern matcher.

-> This needs a better pattern for the different abstraction layers. (for everything)
`.equivalent`, `.is_equivalent`
- Equivalence at continuation is parallel composition
- 
`compose`, `.is_composed`

`.traverse`
- Can implement the ignorances through those traversal layers on branches which dont go left/right but only one direction?
- split off branching initial remainin o. the temrinal the ret marching along
- Can just move the terminal which holds the pointer to the boundary
- Ignorance/equivalence along arbitrary rays. = Equivalence
- Undecided terminal for traversal / or break off structure to explore both.
- Hard to say it's terminating. Need an orbit for that, and access to your own modular structure to say that. Otherwise it's "open loop traversal". Which is fine, just no abstract realization. Simple example is references to references. Or keep going in orbits when you can shut off the traversal.

`.rewrite`, `.replace`, `.collapse`
- start with one, find match, then match entire structure and revert if not. ; one way. Detach and reattach.
- Local modular structure: left/right collapse simultaneously to get a modular rewrite in ; then check locally to break the recursion.

`.add`, `.superpose`, `.and`
- validity; checks as superposed maybe


---

Causal = ordering = sorting = indexing = assymmetry = variance ; grouped usefully

---

add = and ... different perspective?
`.add` on vertices -> equiv initial from one side, terminal from other side.
## Modelling Unknowns
- [ ]  
	  - Unknowns not yet verified with proposed consequences for either option?   
	  - Expectations/claims based on incompleteness of some intermediary step.  
	  - Also without expectation but simply an unsolved unknown.
- Other way around: determining that something outside the context is looking inside the context
- What do you do when the information you want is not available?

Ideas like:
- [ ] Effectively random, like effective field equations, some idea from ignorance in the sense that: "might as well be truely random".  - unable to understand structure..
- [ ] Non-abstract realizations: Potentially important: distinguishability doesn't need to be abstractly realized, it could just be in the temporal mechanisms of the system: Not reanosable to suggest that certain things should be known in certain cases?
- [ ] Basically also this thing of, some type of assumption/proof - not need to check some thing ; you can use it without


---

process
Only difference is the assymetry of is_orbit and the consequences of that if self/initial/terminal all are is_orbit that of another  

 Perspective switching
 -  "Applying the same thing in a different context"  
 -  Somewhat related to Functors?  

- [ ] ignorant referencing ray ; all these as ; 

Hence the difference between add/sub and a normal boolean. Is context. What add/sub is applied to; i.e. what effects it has.  

`.terminal`
	# TODo: __anext__ in python case might need addition async def setup? - How is that interpreted as operators for awaitable?  
	  # Todo: slightly different perspectives in cases of map/render etc..., where certain aliases of these are expected not to have alternative behaviors based on binary/ternary calls to this... ; Basically; some of these aliases are probably more appropriate as separate perspectives.  
	  # TODO: compile/map/cast/ ... probably fit in that separate category. Wrap to any object if translation exists (in python case inspect?). - Realize is probably similarly on another level of abstraction.  
	  # TODO: FILTER/WHERE/IF/... for instance - branch different effect  
  
`.reverse`
		# @see "Reversibility after ignoring some difference": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility  
		# @see "More accurately phrased as the assumption of Reversibility: with the potential of being violated.": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20Assumptions%20%26%20Assumption%20Violation
`.is_extreme`
		- reference to boundary 
`.as_[]` Switch of perspective should automatically map any other functionality, say `.traverse` .. 
- Switch perspective is switching names of functions
- It is ordered from one perspective, unordered from another.
`.and` compose terminal/initial
	- Only thing needed for addition, is equivalencing initial/terminal. - Equivalencing continuations.  
	- and/addition becomes sa.e concept
`.terminal / ..`
	- Move `.self` to `.terminal`
	- Terminal expectation ; could also be arbitrary structure again.
`.traverse / .all / .map / .any`
- initial/terminal, basically, which direction and then whether to skip the thing you're currently at. (direction by a ray abstract-level higher.)
- .traverse is move self to .terminal
- the "teleport over thing" could just be the calculus of slow destroying the green ray on a side of the direction you want it to move to, hence moving it from vertex to initial to following the thing
- becomes ignorant of `.all`, pick something, or allow in parallel from this perspective.
- places another ray at another level of description, pointing that way (for .initial.traverse or .self etc.. .traverse)
- `.all` / `.any` pending/.../lazy to generate things from those pointers.
- `.all` if looking for boundary, `.any` if looking for vertex.
- `.all / .any` Difference in list of things parallel composed, or first ewuivalencinf them, then compose. Basically: compose on INITIAL vs - use .all func after separating from .any -. First calling equivalence on INITIAL (equivalence all in chain - separate in pairs, then equivalence - could be parallel) . Or basically this means sollidiving the selection. Then take that as a vertrx and compose with another  
Continuity
- vertex->vertex from initial/terminal means no access in between.
Traversing `.self` 
- Like [[Jonathan Gorard]] mentioned inability to parallize obstruction to causality - in the sense of cant traverse the .self ray fast enough to parallize like the superposition of a larger structure, hence it breaks on the further away things on .self
	- Trade-off between branching spatial extent
- Traversing `.self` without time-step would be a projective plane? ; So this could be relatively be constructed in certain settings.
	- a recursive definition of a projective plane but then (partially?) accessible as a calculus?
`.is_orbit`
	- TODO: Normal way of talking about a boolean, or probably any concept, is that this is always with .orbit on it. And without .orbit it's probably a weird case. We assume modularity of booleans.  
	- .orbit by default, recursive?
`.compose`
	 - # @see "Continuations as Equivalence (can often be done in parallel - not generally)": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Constructing%20Continuations%20%2D%20Continuations%20as%20Equivalence  
`.is_equivalent = a.self.traverse.is_orbit(b.self.traverse))` Basically: does there exist a single connection between the two?
- Then homotopy equivalent, when a particular perspective allows to collapse some ray to a single point/empty.
	- similar to copying again, move from one vertex which branches into two, is similar to having a ray which holds the initial on either side. Basically just removing the left one, this being the mechanism to collapse the entire graph to a point. Where in the case of cohomoloy, something stops this from happening. Additional structure at each of the points perhbaps? ANother layer of descriptionwhich says there's something in between.
	- Homotopy equivalence merely as some direction/reversibility constraint on some direction, ignoring additional structure (or incorporating it into the equiv) at the vertices. (Could be loosened where certain vertex-equivalences are also part of the homotopy)
	- ; follows from matching rewrite structure&merge ; If some underlying level of description doesn't match the relations at the other level of description we're using for equivalencies / hence homotopies. Then don't permit the invariance/variance and force no difference. Hence any equivalencr necessarily implies possible homotopies. Whether those spaces can actually be differentiated between to create infinite continuous differences between those points ss enumeration of possible homotopies isn't necessarily that obvious in the embedded space ; the underlying level of description  
	- [ ] Can collapse a loop to a single point in the case of homotopy equivalence. The only thing that would prevent you from doing so is some notion, on the level of another intersecting hypergraph at the vertices, that there should be something in between
	- [ ] collapse tonpoint, then point could have dinstinguishability that there's something there, or not, or by interactioon in a certain wau
- "Hyperdistance Oracles in hypergraphs" seems obvious from the perspective of Ray? ; it's just traversing `.self` from some perspective instead of other things.
- equivalence is an inconsistency from some perspective (and the other way round)
`.none` Many ways of phrasing this ; "it's explored/.../branched but dies", ..., "looked at, then ignored".
- none: initial direct to terminal, no vertex in between. & reference none for "select none"
- Like that you can also conceptualize multiple steps of none, initial -> initial -> initial -> terminal

`composition - equivalence - >` ; up the arity, probably makes less sense?

- noticing of runtime inconsistencies from some perspective ; adjustable
- detach all connections into single one, what's this interpretation , move some connections to ignorant ref only,
- Multiplier edge, ring addition
- Only branch in the direction your going, not on top/below just create rhat pocket ref like that


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


- Could use closensss as the initial/twrminal question and addition dimensionalities as the expansion of the additional rays. Could also create some automatic way of folding the ray structures onto a high dimensional tensor which preserves its steucture relative to the functioms applied to them theough gpu. Would have to check whether this is better than writing code in the way things like cuda/hip/ write the gpu kernels for gpgpu

Local .orbit instead of composing at .terminal? ; pulling further-away stuff into this ; locally

- [ ] Expanding superpositions to there permutations (a simple rewrite rule?) - For the general case? (/combinatorics)
- [ ] Using them for fractal expansion - shoving structure in between.

##### Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences
*better name*

- While executing in certain context?
- [ ] Non-commital ignorance, lazy functions ; Carrying of an initial/terminal from a reference without traversing the direction
	- [ ] Similarly: unresolved pointers, cut off/short, pending, waiting for ..
	- [ ] 'Unintended'/'Unrealized' effects realized? / Resources one didn't know one is consuming etc... (unknowns)  


@see "What if this wasn't the case?" https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=%22What%20if%20this%20wasn%27t%20the%20case%3F%22

Leaves the following questions:  
- [ ] How to define currently trying some directionality: waiting for some function, perhaps some partial state acquirable? ; parallel, one at the completion step, the other in between still waiting

empty on .self, vs .self ref vs ref, ; selection of two boundaries.


## Exploration and Discovery
reverse engineering, debugging, checking for consistency, validation, fidelity

- [ ] Consistency as some verifications built in some temporal histories as tests or something: Dismissing as chaned..
	- [ ] The abstract idea of persistence is quite straight-forward:  non-trivially limits access to the previous 'steps'. ; initial


Fuzzing / discovery
Could just randomly start generating possible combinations of logical gates (or any methods on Ray), which if the runtime has an explanation for (or in the debug mode just to listen), you can hook into that and create an implementation. In the case of python made something along the lines of an interpreter which gives you one, asks to write one in python...


Partially, locally, ... (same as on orbits)

(other ideas, examples: Post-Silicon Validation, ... ?)

- [ ] Brute-forcing if no better alternative has yet been found? ; try to explore combinatorial exploding spaces.
- [ ] Solving ambiguity with additional context ; tolerance of ambiguity
	- [ ] In reference to the idea of not having access to the details of what some point is, then gaining them, there is an ambiguity on where exactly one mentions the structure. Ambiguity arises from this ignorance of structure.
	- [ ] You want to allow for ambiguity, and ways of resolving it.
	- [ ] Then combating it would be: Want to collapse it, snap the modular structure. To converge to some structure (which could still be used as a modular space), but is now realized as not one within that context.
	- [ ] Relate to [[Project - Indexing existing Abstract Models (2024-2025?)]] ; closeness/how quick does it fit your structure
- [ ] Making a non theorem a theorem holding all properties and symmetries except its initial violation. It's not necessarily: "But that's not inside the definition of what this thing is supposed to be" - it's merely, well apparently I can do this, so your abstraction/description/implementation/... is clearly ignorant of something (obviously).
- [ ] Deletion of information

- [ ] Unknowns & inconsistencies driving curiosity?   ; same with items, finding hints of possible quests to pursue

*Unusual exploration, sporadic, probing*
- TODO: How about treating something like something which the context says it's not? (Could apply this sort of thing in some fidelity/consistency checking mechanism as a way of fuzzing the fidelity mechanism)
	- Trying again: doesn't change?
- practical guesses

Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question. ; What can we say about the information when we are missing or thinking corruption of it? - ; compression

Compression
 curvature and noncompressability ; tweet ([[Jonathan Gorard]])

- [ ] Compressing/minimizing ambiguity  (important: whilst ignoring as little as possible. - can loosen this in certain cases. In other cases there's nothing you want to ignore (except for the way of getting there perhaps))

- [ ] Against forgetting/violation/inconsistencies
	- [ ] Forgetting but remembering one has forgotten - structure, but acknowledgement, structure is missing.
	- [ ] It's crossing some directionality and finding one cannot return back? (That would imply next time step or something - any inconsistency possibly 
	- [ ] differently structurally forgetting
	- [ ] Testing/Simulating: Does a certain property still hold; what if not and deemed violated?  
	- [ ] How could failures be detected? How can failures be prevented? 
	- [ ] Redundancy: redundancy defined as aiding the resolving of unresolved values? (if compression is the goal: least redundant, if the goal is adaptability; sparsity)
	  - [ ] Run multiple simultaneous processes which are supposed to do the same thing - compare  
	- [ ] Self-imposed limitations to see if that can be sufficient  
		- [ ] "What if I were to treat this as forgotten, what would happen?"  
		- [ ]  - fidelity: If I don't check, I assume it will be consistent, if I do check, I assume the checking will be consistent. ; What to do when certain types of consistency fail?  
		- [ ] If ones particular assumption falls it can be caught up by another: If some abstract form of time isn't necessary then one can revert to theories that allow perfect symmetries of relations which are not described by computation. ...etc. How would one invalidate the whole thing?  - safety mechanism for tests - or at least, that would be assumed
	  - [ ] Try limitation on hardcoded relationships between things: Visual representations, symmetries of them etc..  
	  - [ ] Testing/Simulating with fewer resources, see how that impacts behavior; temporal/visual/... (Modeling resources?)
	  - [ ] Not having access to inner perceived structure (transduction/..)/equivalency rules  
- [ ] Keep pulsing certain directionalitiws for changes in sone "does it continue", agift behavior based on such changes
- [ ] Proved in some finite space as opposed to general one.  
- [ ] Dangers of simulating ignorances (removing certain inhibitions; (same for safety constraints in some sense..))
- [ ] 'Monkey testing':/.../fuzzing Random changing values/random forgetting: Simulating, what would happen?

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

### Some existing ideas: 

- [Causal Invariance](https://www.wolframphysics.org/technical-introduction/the-updating-process-for-string-substitution-systems/the-phenomenon-of-causal-invariance/)
	- [Wolfram Physics I: Basic Formalism, Causal Invariance and Special Relativity (2020)](https://www.youtube.com/watch?v=BV3a0PzNNqE) ; *Jonathan Gorard*
	- [Causal invariance versus confluence]() ; *Jonathan Gorard, Mark Jeffery*
		- [Lorentz invariance](https://en.wikipedia.org/wiki/Lorentz_covariance), [Poincaré invariance](https://en.wikipedia.org/wiki/Poincar%C3%A9_group) (special relativity), [Conformal invariance](https://en.wikipedia.org/wiki/Conformal_symmetry), [Diffeomorphism Invariance](https://en.wikipedia.org/wiki/Diffeomorphism), [General Covariance](https://en.wikipedia.org/wiki/General_covariance) (general relativity)
		- Causal history as identifier (Interesting way of merging the idea of Confluence/Causal Invariance) - This would in the case of Rays just be generalized to any referencing on the `.self` Ray - or a selective part of it to differentiate between structure at the node, history etc... (currently already automatically the case for the `is_equivalent` function)
	- Causal is more abstractly just some order / sorting. Where order and sorting can be abstracted away as merely some expected property to hold irrespective of input after those transformations.
		- Or basically for Causal Invariance: Irrespective of some order in which something is applied, I can after those things which are applied say: "I can transform all those results in some way where they would be expected to be this thing."
		- Or: After some variant application of functions, I apply some transformation which accepts all those superposed possible branches, which will all result in some invariant property (boolean check to whether I deem them as the same, or after some ordering function and some check whether I deem them as the same, ... etc.)
		- Or: Variance is handled in such a way that after some function application we are left with something we deem invariant with respect to possible inputs.
	- As long as you can recall/.../remember something, in the case of some eventual consistency, you're often going to be causally invariant in some respect (ignoring some difference).


## Rendering engine
visualization
- Small ring outline in continuation + vertex?
- Intersection on screen been non-intersection in the structure, way of rendering it.
- Ray growth over some grid as the 3d rendering engine
- Ring in the middle rotsting, then expand, transparent background. grow into orbitmines logo then blank sheet, waiting for use
	- grow from there structure onto the screen, superopositions, grow, collapse, grow..., nice animation for startup.


Header
- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail

- [ ] Track program, rotation, ..., interface movements. Possibly replay at some accuracy. (Some directionality seen as temporal as to interface inputs.) ; causal histories.
	- [ ] possible: log the things one might want to undo to, instead of logging the thing something currently is after applying something  

[[Project - Research towards Designs (2024)]]
- Different OS & browsers - intercompile

differentiable engine, pullback structure to some other, then ...
 - but also just references, connections not shown, a mistake visual interfaces make

[Whatever this interface will look like, it necessitates conveniently being able to change **anything** about how it looks, ..., how it operates *from the interface itself*. This introduces a hard problem on the side of the implementer: How do you possibly account for that? Or perhaps: Why is that a problem in the first case?](http://localhost:3000/archive/2024-02-orbitmines-as-a-game-project/#:~:text=Whatever%20this%20interface,the%20first%20case%3F)


###### [There must be some sense of stability in the interface. Though many interesting things will probably be more visually unstable.](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=There%20must%20be%20some%20sense%20of%20stability%20in%20the%20interface.%20Though%20many%20interesting%20things%20will%20probably%20be%20more%20visually%20unstable.)
- [ ] Non-jumpy - stability ; Important to not have jumpy interface things like obsidian, which are so sensitive to where the mouse or selection is?

###### [You need to be able to deal in *questions* of different levels of abstraction, description, ..., scales, when each layer introduces arbitrary complexity. This is not simple scale invariance.](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=You%20need%20to%20be%20able%20to%20deal%20in%20*questions*%20of%20different%20levels%20of%20abstraction%2C%20description%2C%20...%2C%20scales%2C%20when%20each%20layer%20introduces%20arbitrary%20complexity.%20This%20is%20not%20simple%20scale%20invariance.)
- [ ] No understanding yet, find something close to it first from that perspective, bridge from there. 
- [ ] No understanding of functions, start modelling at runtime ; things like supercompilation etc...
link to [[Project - Indexing existing Abstract Models (2024-2025?)]] # differentiable

*Use the graphical rendering as the language/data embedded.Just put hte ray interface on top of that.*
- Both sides, drop the initial/terminal, grow to either side initial if initial, terminal if terminal. Then stitch the two together.    
- Resolve parallel threads doing this by just the same merge operation?
- simple loop where initial terminal setached from base, remains simple loop on where it goes, shrink to point, repeat, could be possible
- moving along just moved a single ray, both structures intersect move throygh rach other from some other perspective ; Then whether it's ignored/branched, or doesn't interfere with each other.
- Drop the self-loop from on-orbit check ; peek by going there, then one more step, and dropping .self and moving back to terminal


## Web, .. downloadable variant
Stored any way, just deal with it.
- [ ] Provide easy portability away from the current setup "Provide me with this and I'll recompile it into what you want"

- default to OrbitMines func, otherwise blank (seperate directory in ray or something)

- Simple web setup for localstorage

## Future inquiries

- [Whatever function it is that platforms and interfaces serve, they will probably converge to being more of a theme applied on a particular type of structure. Only as a supply of resources (access to certain kinds of information/compute) will they persist. They will not persist as separable interfaces.](http://localhost:3000/archive/2024-02-orbitmines-as-a-game-project/#:~:text=Whatever%20function%20it,as%20separable%20interfaces.)
	- link to twitter post too.
- [Whatever sets up this open world generation must rely on existing structure, information. You can set up something more random, sure. But the only possibility of some feedback on this generation must be some generalization of existing knowledge. Whatever (entropically relevant) information, structure, ..., items have been found.](http://localhost:3000/archive/2024-02-orbitmines-as-a-game-project/#:~:text=Whatever%20sets%20up,have%20been%20found.)
	- [This means open world generation must support arbitrary information which will **not** be available in the design of this game/interface.](http://localhost:3000/archive/2024-02-orbitmines-as-a-game-project/#:~:text=This%20means%20open%20world%20generation%20must%20support%20arbitrary%20information%20which%20will%20**not**%20be%20available%20in%20the%20design%20of%20this%20game/interface.)
- Storage/Structure/orbits as compute
	- How to phrase storage as compute? It's using some compute to persist some structure, though we might not know how to use it for anything else than storage, this is essentially the case. All equated as the same resource? Persistence/Compute/Effort/resources  
	- Structure vs combinators from certain perspectives that sort of thing?..., energy, conservation
	- at the end simple example of efficiency/closeness/differentiability  


---
###### Examples: Delayed till working implementation
- Chyp
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


