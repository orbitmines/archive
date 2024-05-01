*Let's try for [[2024-05-31]]*

In-place dynamic window:
- writing on one side, interactive on the other, or centered, so a moving box - gotta make sure interop is good.

Header
- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail

Unprocessed
- [ ] (SEMF) Discord messages / livestream transcript
- [ ] Some of the notebooks from 2023

Introduction
Admittedly, this starts with a simple concession: that this is a generalization of many ideas whose details I don't fully understand. Though crucially, this is not important for my purposes here.

A list which undoubtedly falls short, would contain: . A more complete set of ideas and partial history of me becoming aware of them can be found in [my archive](https://github.com/orbitmines/archive/blob/main/projects/Project%20-%20Indexing%20existing%20Abstract%20Models%20(2024-2025%3F).md).

I suspect that a large numbers of problems arise from a rather simple conceptual mistake. And perhaps calling it a mistake - is itself a mistake. For we are always forced to first find practical tools, before we can find better ones. But therein lies to me the possibility of that mistake: ["Once something seemingly convenient is found, it is seriously hard to explore and steer away from that."](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=Once%20something%20seemingly%20convenient%20is%20found%2C%20it%20is%20seriously%20hard%20to%20explore%20and%20steer%20away%20from%20that.). 



Consider this my attempt to provide infrastructure for that exploration.


###### ["You will have to deal with being able to move in certain data structures for which there might not (yet) be a nice translation to something you can understand."](http://localhost:3000/archive/2024-02-orbitmines-as-a-game-project/#:~:text=You%20will%20have%20to%20deal%20with%20being%20able%20to%20move%20in%20certain%20data%20structures%20for%20which%20there%20might%20not%20(yet)%20be%20a%20nice%20translation%20to%20something%20you%20can%20understand.)
- [ ] Modelling unknown systems - possibly to in the future match em - or directly something possibly not understood
	- [ ] Will have to kick in by having some way of realizing that externality - much more intuitive to phrase it this way, and see how it can be broken  
	- [ ] Conjecture, 
	  - Unknowns not yet verified with proposed consequences for either option?   
	  - Expectations/claims based on incompleteness of some intermediary step.  
	  - Also without expectation but simply an unsolved unknown.
- Other way around: determining that something outside the context is looking inside the context

Ideas like:
- [ ] Effectively random, like effective field equations, some idea from ignorance in the sense that: "might as well be truely random".  - unable to understand structure..
- [ ] Non-abstract realizations: Potentially important: distinguishability doesn't need to be abstractly realized, it could just be in the temporal mechanisms of the system: Not reanosable to suggest that certain things should be known in certain cases?
- [ ] Basically also this thing of, some type of assumption/proof - not need to check some thing ; you can use it without


---

- The problem is not .. it's missing tools to think across fields. 
	- Most definitions and/or names of things assume some perspective. Make it hard to generalize.
	- Similar to things like references: In
	- It doesn't matter that you want a particular way to deal with your conflict free stuff, the solution is not only to isolate an environment, but just to be able to deal or handle when it arises. ; better way of phrasing this? single sentence?
	- It's not just about being able to work with unique data, but also about what you do when that's not available ; restate some things from [[Project - OrbitMines as a Game (2025-2026?)]]
	- 
- "Can just draw a line (or any structure really) and say I want to regard that as the same, not obvious what would happen if you do that, but you can."

- Reference to existing ideas. This is the generalization of many ideas, it would be ...
	- first few things after the introduction, but this for now
	- Which others to name/ref.
	- https://www.youtube.com/watch?v=p2vadd_6550&list=PLtbvsohNkWeUItHqZ9LAn4Qnz8hT6JMhY
		- Covariant computation & [[Jonathan Gorard]]'s mentioning of graphs
	- The [[Bob Coecke]] & [[Stephen Wolfram]] conversation, Bob Coecke's work
	- [[Chyp (Cospans of HYPergraphs)]] & [[Aleks Kissinger]]
		- ```// Accompanied by a simple implementation of <Reference is="reference" simple inline index={referenceCounter()} reference={{title: 'Aleks Kissinger\'s Chyp (Cospans of HYPergraphs)', link: 'https://github.com/akissinger/chyp', authors: [{name: 'Aleks Kissinger'}]}} />
	- [[Alexander Grothendieck]]
	- Lingua Universalis
	- Infrageometry
	- Hook into [[Project - Indexing existing Abstract Models (2024-2025?)]] future inquiries

- A lot of this started with the idea: "You cannot have interaction without something like gravity." ; I think? Probably a question similar to this.

- Local changes..

visualization
- Small ring outline in continuation + vertex?
- Intersection on screen been non-intersection in the structure, way of rendering it.

process
Only difference is the assymetry of is_orbit and the consequences of that if self/initial/terminal all are is_orbit that of another  


Reverse direction as teo points. Need a good intuition for this. Basically one of tep values selected and the switching of direction to the other way. Perhaps similarly a tep step modular structure of which you can see the intial/terminals being swapped. Is_equiv if can tell the difference and ignore, is_orbit if cannot  

- [ ] ignorant referencing ray ; all these as ; 

`.as_[]` Switch of perspective should automatically map any other functionality, say `.traverse` .. 
- Switch perspective is switching names of functions
- It is ordered from one perspective, unordered from another.
`.and` compose terminal/initial
	- Only thing needed for addition, is equivalencing initial/terminal. - Equivalencing continuations.  
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
Continuity
- vertex->vertex from initial/terminal means no access in between.
Traversing `.self` 
- Like [[Jonathan Gorard]] mentioned inability to parallize obstruction to causality - in the sense of cant traverse the .self ray fast enough to parallize like the superposition of a larger structure, hence it breaks on the further away things on .self
	- Trade-off between branching spatial extent
- Traversing `.self` without time-step would be a projective plane? ; So this could be relatively be constructed in certain settings.
	- a recursive definition of a projective plane but then (partially?) accessible as a calculus?
`.is_equivalent = a.self.traverse.is_orbit(b.self.traverse))` Basically: does there exist a single connection between the two?
- Then homotopy equivalent, when a particular perspective allows to collapse some ray to a single point/empty.
	- similar to copying again, move from one vertex which branches into two, is similar to having a ray which holds the initial on either side. Basically just removing the left one, this being the mechanism to collapse the entire graph to a point. Where in the case of cohomoloy, something stops this from happening. Additional structure at each of the points perhbaps? ANother layer of descriptionwhich says there's something in between.
	- Homotopy equivalence merely as some direction/reversibility constraint on some direction, ignoring additional structure (or incorporating it into the equiv) at the vertices. (Could be loosened where certain vertex-equivalences are also part of the homotopy)
	- ; follows from matching rewrite structure&merge ; If some underlying level of description doesn't match the relations at the other level of description we're using for equivalencies / hence homotopies. Then don't permit the invariance/variance and force no difference. Hence any equivalencr necessarily implies possible homotopies. Whether those spaces can actually be differentiated between to create infinite continuous differences between those points ss enumeration of possible homotopies isn't necessarily that obvious in the embedded space ; the underlying level of description  
- "Hyperdistance Oracles in hypergraphs" seems obvious from the perspective of Ray? ; it's just traversing `.self` from some perspective instead of other things.
- equivalence is an inconsistency from some perspective (and the other way round)
`.none` Many ways of phrasing this ; "it's explored/.../branched but dies", ..., "looked at, then ignored".
- none: initial direct to terminal, no vertex in between. & reference none for "select none"
- Like that you can also conceptualize multiple steps of none, initial -> initial -> initial -> terminal

`composition - equivalence - >` ; up the arity, probably makes less sense?

- noticing of runtime inconsistencies from some perspective ; adjustable
##### "Binary"
just list a few possible ways of constructing it.
- binary reverse op is also conceivable as initial/self/terminal over two possible values
- orbiting ray around it / bouncing off the edges
- ...

- [ ] ; ideas from the notebooks
Encoding/symbols..
- Perspective of 0/1,
- What is we interpret 0/1 as our frame, then it becomes something else.
	- Then it becomes hey: "I keep being at this same place from this perpspective, hence the assumption: constantly a boolean/binary value, -> creaton of some loop through homology?"
- Hence, from this point, one might say the binary sequence are two high-dimensional points (lcoally connected).
- "Some line as saying: anything on it is the frame and deemed the same, all deemed as ignored, all deemed as the identity"

##### "Superpose in more detail"

- `qubit / linear superposition / complex numbers` is a binary superposition, ..., orbit, which is differentiable in between steps (basically, if something else from outside the context can reach in between, it would find something there. ; Based on that precision). So `qubits, orbits, higher-arity structures, ignorance along rays`, same thing?.
	- "Can abstractly only satisfy a loop through another loop? While pattern matching?"
	- Some way to conceptualize a qubit as pattern matched on any other thing ; similar to the "push structure inside thing."
	- ; So that would be like finding the higher-arity structure there, and selecting it like the vertex on vertex, having it branch off.
	- ; So similarly, it's infinity groupoids which break the recursion of the stack. So the `.is_orbit`s.
	- Usual superposition is where every entry of an arbitrarty direction only references itself on the `.self`. Hence a tensored variant like this in linear time, if you can traverse that in one step.
	- At every branch cotains the one added thing necessary for spliting the vranch for conservation, but that destroys the embedding if that wnats to be prrserved, ?
	- DIfference between a bit and a qubit is that in the case of a qubit we assume differentiability between. But for a bit also we assume modularity of the two options. Or different boundaries, What about on the frame/middle, what about ...

direction at the point**: What does it mean for a point yo become its own direction? ; function becoming data becoming toplogies becoming ..

Tripple superposition, two continuated (two perm), binary superposition  

- Could use closensss as the initial/twrminal question and addition dimensionalities as the expansion of the additional rays. Could also create some automatic way of folding the ray structures onto a high dimensional tensor which preserves its steucture relative to the functioms applied to them theough gpu. Would have to check whether this is better than writing code in the way things like cuda/hip/ write the gpu kernels for gpgpu

Local .orbit instead of composing at .terminal? ; pulling further-away stuff into this ; locally

- [ ] Expanding superpositions to there permutations (a simple rewrite rule?) - For the general case? (/combinatorics)
- [ ] Using them for fractal expansion - shoving structure in between.


##### Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences
*better name*

- [ ] Non-commital ignorance, lazy functions ; Carrying of an initial/terminal from a reference without traversing the direction
	- [ ] Similarly: unresolved pointers, cut off/short, pending, waiting for ..
	- [ ] 'Unintended'/'Unrealized' effects realized? / Resources one didn't know one is consuming etc... (unknowns)  


The concept is never really direct execution, and if it is, that's often more like ignorance. Basically, arbitrary lazyness. Like this we basically rephrase "output" or "halting" as "what if we assume it halts here". Inaccessible, ..., Ignorant ones turn into the inability to ask that question.  

@see "What if this wasn't the case?" https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=%22What%20if%20this%20wasn%27t%20the%20case%3F%22

In the case of Rays, whether something is a vertex/initial/terminal is only inferred from surrounding context. And these checks only need to happen locally in order to decide how to traverse arbitrary structure (as in - I only need to check the presence of something next to me, not traverse the whole direction recursively in order to decide what to do).

Leaves the following questions:  
- [ ] How to define currently trying some directionality: waiting for some function, perhaps some partial state acquirable? ; parallel, one at the completion step, the other in between still waiting
##### Fuzzing / discovery
Partially, locally, ... (same as on orbits)

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
Allows for a generalization of geodesic (partially)
- One could simply see it as additional resources, capabilities, function, however one wants to define it. It generally can (and should) alter possible compression for anything that follows.

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

##### Different levels of abstraction simultaneously, ..., simulation


##### Self-referential operators & multiple abstract implementations
- Note that whenever you have a self-reference through operators, that requires an implementation to break this self-reference. For example ray functionality only requires initial + negative, or terminal + negative, or initial + terminal, to make all the other three.

##### On Naming, ..., Grouping
This is basically: When to decide that perspective switches should have a different name associated with them, when they can probably be thrown in a bag with other stuff: I.e. Why is it so significantly different it should be separate?
 - ex: TODO: Do I want to keep the is_equiv/is_composed pattern? Or simplify to one of the two?
##### Mathematics, Physics, ..., Dynamics

Yellow is how you could define zero. Or a selection pointer on pink. ; Basically you can define the boundary as a zero point. ; "split point between opposites" ; "distinguishability begins here for modular structure" ; ... "selection"
![[Pasted image 20240501193810.png]]

Mathematics as ignoring `.self` ? or something close to it.

Defer to [[Jonathan Gorard]]'s work, for more physics details there. As for example this: ["The boundary of a boundary is always empty."](https://twitter.com/getjonwithit/status/1784599157015007391)

- Some of my intuitions of physics
- Something like: Constantly all the rays as functions are executing (in orbits), then if something causes something else's behavior to change, you get the inconsistencies.
- Wrong dynamics from a particular perspective, often probably still keep traversing.

"Even wrong profram dynamics still work"

With some physics connections here as well:
- Then energy conservation (if it holds up), could be using anything to the initial sides (casual histories/or some structure/.../topology) and shove them in the traversing direction until there's nothing there. And hence we stop branching and in some ways collapsing in the sense of the teminal side then doing that similarly to the initial side.
- Could like this be much more non-trivial based on the structure being pushed in exploring the branches ; i.e. like that similarly determining which and how the branches are explored.
- Fitting another layer of abstraction on the structure which determines the following direction (or generally this could be phrased as inferred from context) .terminal here is possibly undefined. ONly needs presence, no recursion checks. Concurrency issues then in many cases resolved, through always being associated with a particular direction. (See note)

Hermission/herminisity /time reversal; i.e. ray swap ; look up hermission?

Blackhole as boundary?

---

How to phrase storage as compute? It's using some compute to persist some structure, though we might not know how to use it for anything else than storage, this is essentially the case. All equated as the same resource? Persistence/Compute/Effort/resources  

---

How about phrasing that nothing there as traversal branching into a small local black hole. So more structure more of these small black holes, could you phrase energy release as these local realizations of some 'nothing' as the things that have actually built up additional energy you otherwise wouldn't see?

Perhaps like this: Equality is admission of a difference and the ignorance of it. ; like them semf livestream again

Ah the rewrite, similar to the structure itself, require the presence answer to three things beside it
3 for the checks (duplication & traversal)
+3 for the orbit checks?
and 3 for 

Can implement the ignorances through those traversal layers on branches which dont go left/right but only one direction?

it';s the freference thing, evidently you can reference things without a direction connection, the point is not to ignore that idea, but to try to find a way to phrqase that that's possible to setup

---

Invariances at star hence a modular structure might be a necessity physically, forcing necessarily a finite accessible structure possible allowing it to grow?

split off branching initial remainin o. the temrinal the ret marching along

---

At every branch comtains the one added thing necessary for spliiting the vranch for conservation, but that destroys the embedding if that wnats to be prrserved

---

- ? Better variant of : *Compose as Equivalence as Compose*
	- Equivalence at continuation is parallel composition

#### No memory
The basic premise is this, there might be arbitrarily complex structure around me, but I need to start traversing to find out what it looks like. So the screen being a form of memory, and me 

#### Version control
persisting structures otherwise forgotten whose rediscoverability is not entirely obvious. 
 "What if I did not know about something, nor could rely on these particular discoveries, how would and could I rediscover this something?"

#### Equivalences
- Global changes from local equivalences
- Can just move the terminal which holds the pointer to the boundary
- Is equivalent ; Can A & B be found on the a line/ray/graph? - Or a particular one

-  A traversal = copy = compile = .... (compute?)

- Induced ignorance/equivalence along arbitrary rays. = Equivalence

- Context is defines what something looks like from a particular perspective: Or: "What it is"

### Traversing
-  Dereferencing is likely in many cases quickly subject to infinite stepping (similar to INITIAL -> INITIAL, TERMINAL -> TERMINAL, VERTEX -> VERTEX. (Could be that this means that there's no continuation, a self-reference defined here, or it's some mechanism of halting.)
	- Simple example of infinitely finding terminals, or a reference to 'nothing - infinitely'.
	- If both are references, allow deref of both in parallel? - for later probably
- Rewriting as placing the direction encoded as `.type` of initial/vertex headed to terminal. Where terminal is undecided (from the perspective of `.terminal`, can recursively be the case for any of these.) - So .initial is VERTEX, .self is TERMINAL, which means this .terminal returns ... (Basically abstraction layer fitting the structure - See [[2024-03-28]] note.)


---

# A Universal Language
This thing is, in essence, a language to understand inconsistencies. A conceptual framework to make sense of ambiguity: A story of how destructively confusing languages can be. Though to me, most importantly, it is here as infrastructure. Infrastructure for the design and implementation of a <Reference is="reference" index={referenceCounter()} reference={{link: _2024_02_ORBITMINES_AS_A_GAME_PROJECT.reference.link, title: "different category of (programming) interfaces"}} simple inline />.  
  
<BR/>  
  
<span style={{textAlign: 'left', minWidth: '100%'}}>A simple way of phrasing this, is that the concept of a <span  
    className="bp5-text-muted"><span  
    className="bp5-text-disabled">(hyper-/)</span>'Vertex', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Edge', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Graph', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Rule', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Tactic', <span  
    className="bp5-text-disabled">(hyper-/)</span>..., <span  
    className="bp5-text-disabled">(hyper-/)</span>'Rewrite'</span> are merged into one thing: a Ray. It handles <span  
    className="bp5-text-muted">surrounding context, ignorances, equivalences, ..., differentiation</span> (And if it cannot, then it offers a way of implementing it for all of the above).</span>  
  
<BR/>  
  
<span style={{textAlign: 'left', minWidth: '100%'}}>Though quite importantly, even if those previous words are complete nonsense to you: Either this, or projects following from this, will aid in your understanding. This is the start of a story which will provide infrastructure for communication between all <span className="bp5-text-muted">sciences, (programming) languages, compilers, interfaces, ..., videogames</span>.</span>  
  
<BR/>  
  
Let me show you how.