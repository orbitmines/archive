*Let's try for [[2024-05-31]]*

Introduction
- The problem is not .. it's missing tools to think across fields. 
- Most definitions and/or names of things assume some perspective. Make it hard to generalize.

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
	- 

- A lot of this started with the idea: "You cannot have interaction without something like gravity." ; I think? Probably a question similar to this.

- Local changes..

visualization
- Small ring outline in continuation + vertex?
- Intersection on screen been non-intersection in the structure, way of rendering it.

process
Only difference is the assymetry of is_orbit and the consequences of that if self/initial/terminal all are is_orbit that of another  


Reverse direction as teo points. Need a good intuition for this. Basically one of tep values selected and the switching of direction to the other way. Perhaps similarly a tep step modular structure of which you can see the intial/terminals being swapped. Is_equiv if can tell the difference and ignore, is_orbit if cannot  

`.as_[]` Switch of perspective should automatically map any other functionality, say `.traverse` .. 
- Switch perspective is switching names of functions
- It is ordered from one perspective, unordered from another.
`.and` compose terminal/initial
`.terminal / ..`
	- Move `.self` to `.terminal`
`.traverse / .all / .map / .any`
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
- "Hyperdistance Oracles in hypergraphs" seems obvious from the perspective of Ray? ; it's just traversing `.self` from some perspective instead of other things.
- equivalence is an inconsistency from some perspective (and the other way round)
`.none` Many ways of phrasing this ; "it's explored/.../branched but dies", ..., "looked at, then ignored".

`composition - equivalence - >` ; up the arity, probably makes less sense?

- `qubit / complex numbers` is a binary superposition, ..., orbit, which is differentiable in between steps (basically, if something else from outside the context can reach in between, it would find something there. ; Based on that precision). So `qubits, orbits, higher-arity structures, ignorance along rays`, same thing?.
	- ; So that would be like finding the higher-arity structure there, and selecting it like the vertex on vertex, having it branch off.
	- ; So similarly, it's infinity groupoids which break the recursion of the stack. So the `.is_orbit`s.
	- Usual superposition is where every entry of an arbitrarty direction only references itself on the `.self`. Hence a tensored variant like this in linear time, if you can traverse that in one step.

Local .orbit instead of composing at .terminal? ; pulling further-away stuff into this ; locally

##### Dynamics
- Something like: Constantly all the rays as functions are executing (in orbits), then if something causes something else's behavior to change, you get the inconsistencies.
- Wrong dynamics from a particular perspective, often probably still keep traversing.

---

- Could use closensss as the initial/twrminal question and addition dimensionalities as the expansion of the additional rays. Could also create some automatic way of folding the ray structures onto a high dimensional tensor which preserves its steucture relative to the functioms applied to them theough gpu. Would have to check whether this is better than writing code in the way things like cuda/hip/ write the gpu kernels for gpgpu

How to phrase storage as compute? It's using some compute to persist some structure, though we might not know how to use it for anything else than storage, this is essentially the case. All equated as the same resource? Persistence/Compute/Effort/resources  

Actual superposition or branching was in the case of overlap?

---

- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail

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

#### Equivalences
- Global changes from local equivalences
- Can just move the terminal which holds the pointer to the boundary
- Is equivalent ; Can A & B be found on the a line/ray/graph? - Or a particular one

-  A traversal = copy = compile = .... (compute?)
- Homotopy equivalence merely as some direction/reversibility constraint on some direction, ignoring additional structure (or incorporating it into the equiv) at the vertices. (Could be loosened where certain vertex-equivalences are also part of the homotopy)

- Induced ignorance/equivalence along arbitrary rays. = Equivalence

- Context is defines what something looks like from a particular perspective: Or: "What it is"

### Traversing
-  Dereferencing is likely in many cases quickly subject to infinite stepping (similar to INITIAL -> INITIAL, TERMINAL -> TERMINAL, VERTEX -> VERTEX. (Could be that this means that there's no continuation, a self-reference defined here, or it's some mechanism of halting.)
	- Simple example of infinitely finding terminals, or a reference to 'nothing - infinitely'.
	- If both are references, allow deref of both in parallel? - for later probably
- Rewriting as placing the direction encoded as `.type` of initial/vertex headed to terminal. Where terminal is undecided (from the perspective of `.terminal`, can recursively be the case for any of these.) - So .initial is VERTEX, .self is TERMINAL, which means this .terminal returns ... (Basically abstraction layer fitting the structure - See [[2024-03-28]] note.)

With some possible physics connections here as well:
- Then energy conservation (if it holds up), could be using anything to the initial sides (casual histories/or some structure/.../topology) and shove them in the traversing direction untill there's nothing there. And hence we stop branching and in some ways collapsing in the sense of the teminal side then doing that similarly to the initial side.
- Could like this be much more non-trivial based on the structure being pushed in exploring the branches ; i.e. like that similarly determining which and how the branches are explored.
- FItting another layer of abstraction on the structure which determines the following direction (or generally this could be phrased as inferred from context) .terminal here is possibly undefined. ONly needs presence, no recursion checks. Concurrency issues then in many cases resolved, through always being associated with a particular direction. (See note)

![[PXL_20240328_160945724.jpg]]


#### Meh, need a good introduction, this isnt it
I suspect that a large number of problems arise from a rather simple conceptual mistake. We build languages, ..., interfaces as tools for understanding certain complexities.

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