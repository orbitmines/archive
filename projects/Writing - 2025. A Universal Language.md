*Let's try for [[2025-12-31]] ; - Yearly excerpt of thoughts*

# Towards a Universal Language
**
###### Introduction

~~What does it take to build a universal language? That is the main question which is explored here. A language which can span graphs, programming languages, ..., sciences. A language which you never have to leave.~~

### 

###### 

###

###


---

# UNPROCESSED
*Tread carefully, confusion abound*


---

- What does a mapping look like?
	- Taking an example of `is_surjective` for one step in a mapping. Where a generalization would be compositions of surjective mappings.

- Take as an example vertex mapping of domain to codomain as an example perspective. Then "Image" would be a perspective which only sees the codomain (as a set, and unordered, deduplicated - How to represent this?) Which is ignorant of the mapping perspective. Superpose these two on top of each other?

- Isomorphism under ignored directions how? - First need a better notion of the structure of a ray

- Local rewriting

---

- "On Structure and Interaction"


*Thoughts going over 2022-2023 notebook (reprocessing)*
- [ ] Current setup of Rays solves structure only. Need some slight alteration to include causal history (one-way referenced structure) & traversal/rewrite intentions (**superposed** extremes).
	- [ ] How to think about non-realized functions usefully. Say coordinates to some non-realized geometrical space. (Similarly: locations of information and their retrieval)
	- [ ] Type information + selection combination
	- [ ] Canonicalization/deduplication (Ignores a single ray, what if more)
	- [ ] Memorization vs rerunning
	- [ ] Better notion of functions (non-terminating; orbits) & variables (; replacing structures with others matching either in that structure (;rewrite) or variable replacement (; replace on inaccessible abstraction level ; ex. no nice mappings))
		- Function as direction on "an unknown (optionally of some type/structure)"
		- Functions as unrealized directions on any point
	- [ ] **Ordered/Unordered**: It is ordered from one perspective, unordered from another.
		- [ ] Causal = ordering = sorting = indexing = assymmetry = variance ; grouped usefully
	- [ ] **Modularity, Loops, Cycles**: **Important property which needs better phrasing - and current setup can't capture this nicely: In order to point out acycle, you are required to have some way of breaking that symmetry ; so any cycle has some notion of ordered/.../labelled. Similarly any asymmetry can be made cyclic by ignoring the order.**
		- [ ] "Can abstractly only satisfy a loop/modular structure through another loop? While pattern matching?"
		- [ ] Permutation selection of modular structures, to iterate over each possible selection
		- [ ] .orbit: modularity by default? (turn off by splitting the boundary in two. Could do this locally with a wall)
- ("Description which generates the thing I'm interested in" Generalized to keeping track of "equivalent (and smaller) programs")
###### Function Repository
- Breaking recursion: Local self-references, constants, orbits & Self-referential operators
	- Note that whenever you have a self-reference through operators. Either we break the recursion there through some implementation. Or we simply decide to stop orbiting. And say it could be any of these things, it could be any of some superposition of things.
	- Initial + negative => terminal, terminal + negative => initial, initial/terminal => negative
###### After Restructure
- [ ] Factory (Version Control, Causal histories, ..., Compression): Setup to constantly grow whatever in-memory graph/equivalences are found, get to this place so we can start iterating on discovery functions. (Good notion of causal histories & orbits needs to be there)
	- [ ] Notion of queues, resources (storage, capabilities), ..., priorities
	- [ ] Causal history = coherence conditions ; ex: some input-output relation where some binary value switches, coherence in mapping 0 -> 0, 1->1, but change in selection.
	- [ ] "Measure of how hard something is to do in parallel (or in some other structure generally)" - differentiability of [[Project - Indexing existing Abstract Models (2024-2025?)]]
	- [ ] Apply the same version control system on the version control system itself. 
	- [ ] Which I believe was something along the lines of seeing where certain changes had happened in dependencies/how that would break symmetries, notify that they have changed, and provide entry into what is not defined.
- Exploration: Brute-force enumeration, unkowns drive curiosity, treating something as something it's not (what-if simulation), fuzzing, random changes, 
- [ ] Provide easy portability away from the current setup "Provide me with this and I'll recompile it into what you want"\

###### Examples
- Subtraction is more complicated than performing addition, for subtraction you need to know a length, unless you just cut something off without knowing how long it is.
- Two zero points cross paths at endpoints, what is the interpretation
- 2d grid expansion as an example base rewrite rule, "expand loop"
- Geometry: 0 (dividing at the boundary) already assumes some notion of distance?
- Boolean: Normal way of thinking about a boolean is .orbit we assume modularity of booleans
- Numbers, Integers, base-n, fractions, floating point
	- .add integers: single equivalence (initial from one side, terminal from other side.) 
- Single point, all perspectives. Ref on initial, entire initial ref as the .self, what about "entire" under some maximum travel speed/steps (or some variant of that idea)
- Initial/terminal, what does a generalized variant of more than those two look like?
- Program language syntax
- Nested arrays as structure on the initials, different than a 2d grid. + How does this work with unrealized array functions, or realized ones? Like .at(index).

###### Energy/Resources
- The larger the integer/fraction, the larger the number of digits in a fractal, the more structure you need to describe it ; (at least if you're not expressing it as a more simple program, but have to construct the actual number)
- Coherence is expensive? - Takes a lot of structure
- Names in language as a way of indexing hard-to-find things

###### Statements?
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction - Overlapping multiple levels of description
- Better way of thinking about needing some none-one-way to describe a one-way connection
- Dynamics, Physics
	- ordered to talk about usefully (assymetry), higher-arity cases more in line with ignoring/invariances of that order. Where an invariance is something like a branching ray as a cursor along every entry of some other ray. 
	- Local changes move larger structures.
	- Shoving causal history in some direction?  ; determining traversal of branched structure??
	- Particles are seemingly temporally stable orbits/modular structures?  
- Mathematics
	- You could probably phrase mathematics as have access to the `.self` equivalency Ray, and assuming one can traverse that structure arbitrarily, and ignoring how one has access to that. And this becomes problematic for mathematics if there is some way to traverse from `.self`, back to the current ray we're referencing. Which would be the moment you'd call it an inconsistency. But that as an argument, only holds up if you can indeed traverse arbitrarily. But it is likely exactly this property which allows for homoiconic foundations of mathematics 
	- Traversing `.self` without time-step would be a projective plane? Recursive definition of a projective plan but then (partially?) accessible as a calculus?
- Any symmetry must be breakable - any symmetry has some ignored assymetrical property ; Does not have to be the case from the perspective of the symmetry.

---

- There are many ways of phrasing ; "it's explored/.../branched but dies", ..., "looked at, then ignored". (`none`)
- collapse the loop/infinity with an extreme 
	- or-> Two branching pointers sent in opposite direction which annihilate when they cross each-other.
- differentiable between two points to arbitrary precision, how is it constructed?
- qubits, linear superpositions, complex (higher-arity) numbers?
- Equivalence in some perspective: Does there exist a connection between the two.
	- Homotopy equivalence: When superposed perspectives can be collapsed to a single point.

`.add`, `.and`, `.assign`, `.superpose` : Compose an `initial & terminal` (.add is compose boundaries)

---

Spatial separation is what allows for parallel/simultaneous rewrites under some maximum travel speed (for causality) 

---

unordered is parallel? how about set? or how about all of them but in any ofder? How about parallel, in a loop? And then parallel in a loop, excluding current one? Or excluding ones in a path (any order)

---

descriptions, definitions, lazy functions, unresolved pointers, non-committal ignorance, awaiting function execution, questions, ..., conjectures. Or: We can point to things to which we don't yet have any (or a definitive) answer. Take for instance an extreme of saying: "Whatever this direction is, you need to follow it completely":

- Traversal: Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences

- Superposing Languages: Simultaneously having 'different levels of abstraction', superposing operators, 'multiple abstraction implementations', ..., simulation
- Compression: Any story about compression, becomes a story of rediscovery
- A Reprogrammable (Visual) Interface: Open inputs, outputs, compute substrate, ..., interfaces
- But what we can say is this: Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question.. whose rediscoverability is not entirely obvious. 

