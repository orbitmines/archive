*Let's try for [[2024-12-31]] ; - Yearly excerpt of thoughts*

# Towards a Universal Language
**
###### Introduction
What does it take to build a universal language? That is the main question which is explored here. A language which can span graphs, programming languages, ..., sciences. A language which you never have to leave.

### 

###

###


- "Capturing: What is the essence of differences and similarities" ; Not just that something is equivalent, but how/why
- Have some nice translations for these concepts: (hyper-/)'Vertex', (hyper-/)'Edge', (hyper-/)'Graph', (hyper-/)'Rule', (hyper-/)'Tactic', (hyper-/)..., (hyper-/)'Rewrite'
- "On Structure and Interaction"
- Implement a simple getter /setter structure in the initial/terminals? as reversible memoized 


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

Interpreting; Functions (and coordinate spaces), variables, speeds, acceleration

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


`.traverse / .all / .map / .any
- those traversal layers on branches which dont go left/right but only one direction?
- Ignorance/equivalence along arbitrary rays. = Equivalence
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
- This is what breaks our recursion. An equivalency we don't have access to.- It halts the program. (["And there we have it ..."](@see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=And%20there%20we%20have%20it%2C%20an%20infinity%2C%20loop%2C%20...%2C%20orbit%20if%20we%20ignore%20the%20difference.))
- *this or superposition, what's the difference?*: This self-loop breaks the recursion because it self-referentially answers the question of: "The only thing you'll ever find here is that same structure you already had, without having to traverse that structure."


- Coherence
	- This tries for "global coherence" - which just means a self-loop where no change is assumed in surrounding context (obviously inconsistent, but that doesn't matter).
	- "it is expensive work to edge towards global coherence." ? To ensure consistency in some way

- Boolean
	- Normal way of thinking about a boolean is .orbitm we assume modularity of booleans
	- Hence the difference between add/sub and a normal boolean. Is context. What add/sub is applied to; i.e. what effects it has.  

`.add`, `.and`, `.assign`, `.superpose` : Compose an `initial & terminal` (.add is compose boundaries)
- .add integers: single equivalence; ` on vertices -> equiv initial from one side, terminal from other side.)

`.set`, ` = `, `assign` (add to (compose with) `.self`)
- Close to `.and`

`.copy`
- Say some modular structure: send traversing left & right simultaneously, and cancel each other out
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
- similar to next/anext into python await operator?
- Encoding: Usually ignorant of its use
- Superposed different inconsistent/logical systems
- What can be done in parallel ; preference for it. So move to stacking in multiple layers parallel composed for execution. Need a practical example ffor this.
- Simple 2d-grid, work out possible ways of representing it  

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

- Subtraction is more complicated than performing addition, for subtraction you need to know a length, unless you just cut something off without knowing how long it is.

- In compression tasks, is in the case of real numbers, the length of a fraction considered as a resource? - More precision, the larger the structure
- The larger the integer, the larger the number of digits in a fractal, the more structure tou need to describe it ; (at least if you're not expressing it as a more simple program, but have to construct the actual number) ; some loose analogy here to energy as a concept?  

---

Process:
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction - Overlapping multiple levels of description
- Forced orbit around a point as default data structure, necessarily circular orbit
- Want to allow for conflicting perspectives, of which aspects can still be invariant

postponed (from 2023):
 * TODO ; Composability is Non-locality?  

read/write-only?


```py
# TODO: lshift/rshift respects the .size of the ray. So it's push_back & pop front, or in certain interpretations, we might keep and not pop...



```


`.unordered`
	- Ref to initial/terminal enumeration / extremes somehow?

# UNPROCESSED
*Tread carefully, confusion abound*

---

Acceleration stopped by barrier, intuit ?

Spatial separation is what allows for parallel/simultaneous rewrites under some maximum travel speed (for causality) 

---

Not traversal, but collapse of local connectivity to determine "next" steps. ; until current pointer holds something we're looking for. Always with intermediate results, which can be acted on separately: "what if this was the result" even when it's still pending?

---
  
Any symmetry must be breakable - any symmetry has some ignored assymetrical property

unordered is parallel? how about set? or how about all of them but in any ofder? How about parallel, in a loop? And then parallel in a loop, excluding current one? Or excluding ones in a path (any order)


---

<Section head="Introduction">    
<Arc head="Arc: Where to start...">  
  
  <BR/>  <div style={{width: '100%'}}><HorizontalLine/></div>  
  <BR/>  
  I suspect that a large numbers of problems arise from a rather simple conceptual mistake. And perhaps calling it a mistake - is itself a mistake. For we are always forced to first find practical tools, before we can find better ones. But therein lies to me the possibility of that mistake: <Reference is="reference" index={referenceCounter()} reference={{link: "https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=Once%20something%20seemingly%20convenient%20is%20found%2C%20it%20is%20seriously%20hard%20to%20explore%20and%20steer%20away%20from%20that.", title: "\"Once something seemingly convenient is found, it is seriously hard to explore and steer away from that\""}} simple inline />.  
  
  <BR/>  
  
  Perhaps you could consider this as my attempt to provide proper infrastructure for that exploration. Perhaps not just exploration, perhaps better communication.  
  
  <BR/>  
  
  Though, in my ignorance, only recently did I become properly aware of the scope of this project <Reference is="footnote" index={referenceCounter()} reference={{title: 'This feels pretty much in the ballpark of Wolfram’s automata / Lafont’s Interaction Nets / Pearl’s causal graphs / 16th century Lingua Universalis / Hesse’s Glass bead game. So, in that vein, you have tagged a good amount of people working in this niche there.', link: 'https://twitter.com/prathyvsh/status/1760679779819540592/',  
  authors: [{name: '@prathyvsh'}], date: '2024-02-22', organizations: [ORGANIZATIONS.twitter] }} />. And so, even though I still need to learn more about his history at some point, allow me to take on <Reference is="reference" simple inline index={referenceCounter()} reference={{title: 'Leibniz', link: 'https://en.wikipedia.org/wiki/Gottfried_Wilhelm_Leibniz'}} />' naming: A Universal Language.  
</Arc>  
<BR/>  
<Arc head="Arc: Core Ideas">  
  <Section head="A few steps back" sub="">  
    Let's first take a few steps back; this will be necessary. First, you must throw out any kind of assumptions you're bringing to the table. Just like we'll do now for Rays: Anything we'd like to make, should be phraseable in our universal language. It wouldn't be much of one if that wasn't the case.  
  
    <BR/>  
  
    That however, doesn't necessarily make it easy to phrase the things we would like to phrase. But let's start somewhere anyway:  
  
    <Block>  
  
    </Block>  
    Not much of a somewhere. But the basic premise becomes this: I don't know what things around me look like. Let's start by looking around me in some direction:  
  
    <Block>  
  
    </Block>  
    I don't yet know what this is or means, I just know I moved in some direction. You'll start to see the pattern of what we're doing here: I need to start traversing to find things around me - otherwise I can't know about them.  
  
    <BR/>  
  
    Alright now let's try to move backwards.  
  
    <Block>  
  
    </Block>  
    You'll see that there's no recollection of what we just did. In order to say even something as simple as that, we need some notion of memory. We need some way remember what we just did. Let's try it again with a notion of memory of where we've already been:  
  
    <Block>  
  
    </Block>  
    And a simple move back:  
  
    <Block>  
  
    </Block>  
    <TODO>...</TODO>  
  
    <BR/>  
    <span style={{textAlign: 'left', minWidth: '100%'}}>Essentially what any of this comes down to. Is things are entirely inferred from surrounding context. Yet your abstractions can be ignorant of how you're using them. Whether something is a <span  
        className="bp5-text-muted">function, number, geometry, topology, ..., structure</span> becomes quite hard to say when you consider its surrounding context [REPHRASE]. More usefully what we're doing here, is saying: "Can you see a difference? And can you ignore it?"</span>  
  </Section>  <Section head="What is a Ray?">  
    Simply put, a Ray consists of two parts. One part [....]  
  </Section>  
  <Section head="References" sub="Direction, arrows, ..., one-way connections">  
    {/* TODO: This needs to be different, not good*/}  
  
    Similar to <Reference is="reference" simple inline index={referenceCounter()} reference={{title: 'asymmetries/symmetries', link: 'https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=What%20I%27m%20basically%20saying%20here%2C%20is%20that%20in%20order%20to%20point%20out%20some%20symmetry%2C%20invariance%2C%20...%2C%20equivalence%2C%20I%20need%20access%20to%20some%20asymmetry%2C%20variance%2C%20...%2C%20inconsistency.'}} />. The only way to show you a one-way connection, is to have access to some way in which it is not one-way. What do I mean by that? - Quite simply put it is this: If you can't remember that you forgot something, you wouldn't notice. [REPHRASE]  
  
    <BR/>  
  
    Or in terms of our Rays: If I didn't have access to this [SOMETHING]  
    <Block>  
  
    </Block>  
    I wouldn't be able to point it out, so it would just be this:  
  
    <Block>  
  
    </Block>  
  
    {/* TODO Link to reversibility here>>>. */}  
  </Section>  
  <Section head="Superpositions">  
  
  </Section>  <Section head="Traversal" sub="Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences">  
    <TODO>This needs some restructure, good ordering here</TODO>  
  
    <TODO>?</TODO>  
    ...TODO... This way, you can just draw a single line (or even arbitrary structure), and say: "What if I wanted to regard that as the same? What would happen?". The answer to those are far from obvious.  
  </Section>  
  <Section head="">  
  </Section>  <Section head="Breaking Recursion" sub="Local self-references, constants, orbits & Self-referential operators">  
    Note that whenever you have a self-reference through operators. Either we break the recursion there through some implementation. Or we simply decide to stop orbiting. And say it could be any of these things, it could be any of some superposition of things.  
  
    <BR/>  
  
    {/*A simple example could be the difference INITIAL + NEGACTIVE VS TERMINAL + NEGATIVE VS INITIAL/TERMINAL*/}  
  </Section>  
  {/* TODO Elena; "Formalism rosetta stone?" */}  
  <Section head="Superposing Languages" sub="Simultaneously having 'different levels of abstraction', superposing operators, 'multiple abstraction implementations', ..., simulation">  
    Almost always with any abstraction, you'll see the following simple pattern: (1) First one of something, (2) then more of things like it, (3) then some recursive construction of that thing. And noticing that is far from obvious.  
  
  </Section>  
  <Section head="Switching Perspectives">  
  
    But this introduces a rather hard problem, namely that: <Reference is="reference" inline simple index={referenceCounter()} reference={{title: '"Any scale, ..., any language will in some respect introduce this arbitrary complexity."', link: 'https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project/#:~:text=Any%20scale%2C%20...%2C%20any%20language%20will%20in%20some%20respect%20introduce%20this%20arbitrary%20complexity.%20The%20only%20way%20to%20properly%20deal%20with%20that%20is%20the%20possibility%20of%20exploration.%20You%20cannot%20have%20this%20without%20an%20open%20world%20generation%20aspect.', organizations: [ORGANIZATIONS.orbitmines_research]}} />.  
  </Section>  
  <Section head="Naming & Grouping superposed Languages">  
    <TODO>Move elsewhere?</TODO>  
  
    A lot of this comes from the realization. That most differences come from the context in which they're applied. But this presents a problem of how one often uses languages: Specific names for specific perspectives. And that makes useful generalization quite hard. [REPHRASE]  
  
    <BR/>  
  
    Essentially the problem becomes. When do you decide that a particular kind of perspective, or switch in perspective should have a different name associated with it. Essentially what we're asking, is: Why is it so important to name this differently? Would it be harder to find if one didn't do that? [REPHRASE]  
  
    <TODO></TODO>  
  </Section>  <Section head="Modelling Unknowns">  
    <span style={{textAlign: 'left', minWidth: '100%'}}>Part of any task then, becomes this: <Reference  
        is="reference" inline simple index={referenceCounter()} reference={{title: '"You will have to deal with being able to move in certain data structures for which there might not (yet) be a nice translation to something you can understand."', link: 'https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project/#:~:text=You%20will%20have%20to%20deal%20with%20being%20able%20to%20move%20in%20certain%20data%20structures%20for%20which%20there%20might%20not%20(yet)%20be%20a%20nice%20translation%20to%20something%20you%20can%20understand.', organizations: [ORGANIZATIONS.orbitmines_research]}} />. This should somewhere be quite intuitive: You can use tools without knowing how to make those tools. Essentially wanting to understand unknowns, might as well be called reverse engineering: How is it done? What aspects of it can be <span  
        className="bp5-text-muted">replicated, decomposed, ..., understood</span>?</span>  
  
    <BR/>  
    <span style={{textAlign: 'left', minWidth: '100%'}}>This lands us in the world of <span  
        className="bp5-text-muted">descriptions, definitions, lazy functions, unresolved pointers, non-committal ignorance, awaiting function execution, questions, ..., conjectures</span>. Or: We can point to things to which we don't yet have any (or a definitive) answer. Take for instance an extreme of saying: "Whatever this direction is, you need to follow it completely":</span>  
  
    <Block>  
    </Block>  
    This is essentially what it means to point to something you don't yet understand: I point in some direction without having to define what that something is.  
  
    <BR/>  
  
    This allows us to phrase what it means to have unintended, ..., unrealized effects: Essentially phrasing resources you didn't know you were consuming:  
  
    <Block>  
  
    </Block>  
    <BR/>  
    This begs the question: How do you phrase an expectation for something which isn't yet known?  
  
    <Block>  
  
    </Block>  
    What do you do when the information you want is not available?  
  
    <Block>  
  
    </Block>  
    How do you determine that something from outside available context is looking inside?  
  
    <Block>  
  
    </Block>  
    What about effects which aren't abstractly realized, yet still have an effect on the outcome? [REPHRASE ; No causal links on one language, but the superposed one knows about them - how else could I point it out?]  
  
  </Section>  
  <Section head="Compression" sub="Generalization of (perceived, ..., partial) geodesics">  
    <span style={{textAlign: 'left', minWidth: '100%'}}>Now that we can superpose languages, and state with better clarity what having access to certain <span  
        className="bp5-text-muted">operators, ..., structure</span> even means. We now fall into the world of compression. As this allows for a generalization of 'shorter paths' given our capabilities.</span>  
  
    <BR/>  
    <span style={{textAlign: 'left', minWidth: '100%'}}>Note that with compression, we're always necessarily partially ignorant <Reference is="footnote" index={referenceCounter()} reference={{title: '"The only way to actually do that, is to introduce some inconsistency along some direction"', link: 'https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=The%20only%20way%20to%20actually%20do%20that%2C%20is%20to%20introduce%20some%20inconsistency%20along%20some%20direction', organizations: [ORGANIZATIONS.orbitmines_research]}} /> of context and relying on some invariance <Reference is="footnote" index={referenceCounter()} reference={{title: '"Which would rely on strategies like easy re-discoverability for things forgotten"', link: 'https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Which%20would%20rely%20on%20strategies%20like%20easy%20re%2Ddiscoverability%20for%20things%20forgotten', organizations: [ORGANIZATIONS.orbitmines_research]}} />. Thus, any story about compression, becomes a story of rediscovery. Bringing with it an incredibly complicated world: You will have to deal with <span  
        className="bp5-text-muted">redundancy, ambiguity, forgetting, assumption violation, ..., inconsistencies</span>. Where changes in <span  
        className="bp5-text-muted">resources, ..., capabilities</span> will always play a role in <span  
        className="bp5-text-muted">how, ..., when</span> one can compress. Or even better: This will <b>always</b> play a role in any (partial) translation. It's just often ignored as a problem.</span>  
  
    <BR/>  
    But let's first do a dive into the implementation details, before we start attacking these problems.  
  </Section>  
</Arc>  
<Arc head="Arc: Full Implementation">  
  <Section head="Ray.py" sub="Python Implementation">  
  
  </Section>  <Section head="Ray.py - Ray.ts" sub="Crosscompilation of Python and TypeScript Implementation">  
  </Section></Arc>  
<Arc head="Arc: Examples">  
  <Section head="Example: Dynamics" sub="Some preliminary intuitions for physics">  
    Some of these physics-related intuitions will have to be confirmed elsewhere. This is currently not my priority for understanding. I'll defer to Jonathan Gorard's <Reference is="footnote" index={referenceCounter()} reference={{title: "\"The boundary of a boundary is always empty.\"\n" +  
        "A huge amount of (classical) physics, including much of general relativity and electromagnetism, can be deduced directly from this simple mathematical fact.\n" +  
        "Yet, on the surface, it doesn't seem to have much to do with physics.", link: 'https://twitter.com/getjonwithit/status/1784599157015007391',  
    authors: [{name: 'Jonathan Gorard'}], date: '2024-04-28', organizations: [ORGANIZATIONS.twitter] }} /> <Reference is="footnote" index={referenceCounter()} reference={{title: "There are many nice ways to think about light, but a fun one is that it's the propagation of a set of coordinate constraints.\n" +  
        "Suppose that you took each point in spacetime and associated it with a little circle. Each of these little circles is called a \"fiber\".", link: 'https://twitter.com/getjonwithit/status/1784028804887064891',  
    authors: [{name: 'Jonathan Gorard'}], date: '2024-04-27', organizations: [ORGANIZATIONS.twitter] }} /> (and other's) work for that for now.  
  
    <BR/>  
  
    But for program dynamics we can ignore those connections for now, as they are probably quite similar.  
  
    <BR/>  
    <div style={{width: '100%'}}><HorizontalLine/></div>  
    <BR/>  
  
    <TODO>Ordered to talk about usefully (assymetry), higher-arity cases more in line with ignoring/invariances of that order. Where an invariance is something like a branching ray as a cursor along every entry of some other ray. ( "Also, interesting to note might be that Von Neumann and Birkhoff attempted to ground quantum mechanics using order theory (their attempt was not very successful at that)." @pr)</TODO>  
    <TODO>Local changes move larger structures.</TODO>  
    <TODO>Cannot have interaction without an idea similar to gravity?</TODO>  
    <TODO>Shoving causal history in some direction?</TODO>  
    <TODO>Something like: Constantly all the rays as functions are executing (in orbits), then if something causes something else's behavior to change, you get the inconsistencies.</TODO>  
    <TODO>Particles are seemingly temporally stable orbits/modular structures?</TODO>  
    <TODO>"Wrong dynamics" from a particular perspective, often probably still keep traversing - they still work. It's just that from the perspective you wanted, they don't.</TODO>  
    <TODO>Reprogrammability & inconsistencies as foundational?</TODO>  
    <TODO>Invariances at start hence a modular structure might be a necessity physically</TODO>  
  
  </Section>  <Section head="Example: Mathematics" sub="Some preliminary intuitions for mathematics">  
    You could probably phrase mathematics as have access to the `.self` equivalency Ray, and assuming one can traverse that structure arbitrarily, and ignoring how one has access to that. Basically: I'm saying all these things:  
  
    <Block>  
  
    </Block>  
    are the same. But I'm ignoring how I know about that.  
  
    <Block>  
  
    </Block>  
    Or in other words: I'm assuming their consistency - and that assumption has consequences, as alluded to here: <Reference is="reference" index={referenceCounter()} reference={{link: "https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies/#:~:text=One%20might%20as%20well%20%2D%20more%20practically%20%2D%20say%20that%20some%20consistency%2C%20...%2C%20well%2Ddefined%20property%20could%20be%20more%20vaguely%20restated%20as", title: "\"One might as well - more practically - say that some consistency, ..., well-defined property could be more vaguely restated as...\""}} simple inline />  
  
    <BR/>  
    And this becomes problematic for mathematics if there is some way to traverse from `.self`, back to the current ray we're referencing. [NEEDS REPHRASING]  
  
    <Block>  
  
    </Block>  
    <BR/>  
    Which would be the moment you'd call it an inconsistency. But that as an argument, only holds up if you can indeed traverse arbitrarily. But it is likely exactly this property which allows for homoiconic foundations of mathematics <Reference is="footnote" index={referenceCounter()} reference={{title: "This made me think again about a question which has bugged me for a long time: what would a truly homoiconic foundation for mathematics look like? Proof theory gives one the syntax of math. Model theory gives one its semantics (i.e. the \"substrate\" on which proofs act)", link: 'https://twitter.com/_FadiShawki/status/1664387058721325056',  
    authors: [{name: 'Jonathan Gorard'}, {name: 'Fadi Shawki'}], date: '2023-06-01', organizations: [ORGANIZATIONS.twitter] }} />. [NEEDS EXAMPLE]  
  
    <Block>  
  
    </Block>  
    Similarly. Concepts like - absolute equality -, follow a similar pattern <Reference is="footnote" index={referenceCounter()} reference={{link: "https://www.youtube.com/live/YAwWctUq3zw?si=eieXuSLc49nmBKDp&t=6013", title: "Community Livestream | Information Continuum", date: '2024-03-14', authors: [{name: 'Fadi Shawki'}, {name: 'Carlos Zapata Carratalá'}, {name: 'Álvaro Moreno Vallori'}, {name: 'Alejandro Sospedra Orellano'}], organizations: [ORGANIZATIONS.youtube, ORGANIZATIONS.semf]}} />. Namely in the sense that it is an admission of a difference and the ignorance of it.  
  
    <Block>  
  
    </Block>  
  
    <TODO>      I suspect that all these moduli-type questions become computable problems. And it should become obvious that all these moduli-type questions are only answerable if you already have access to some other moduli space.  
    </TODO>  
    <TODO>      And you can probably setup ways where you can switch between discrete/infinitary stuctures at will. - Of course this doesn't mean it's easily tractable. But more that these problems become computable searchspaces.  
    </TODO>  
    <TODO>Traversing `.self` without time-step would be a projective plane? Recursive definition of a projective plan but then (partially?) accessible as a calculus?</TODO>  
  
  </Section></Arc>  
  
<Arc head="Arc: Rendering Engine">  
  <Section head={<span>A Reprogrammable <span  
      className="bp5-text-muted">(Visual)</span> Interface</span>} sub="Open inputs, outputs, compute substrate, ..., interfaces">  
    <span style={{textAlign: 'left', minWidth: '100%'}}>Now we finally get to the points which are the most interesting ones to me. All this allows us to phrase a setting, where we have open <span  
        className="bp5-text-muted">inputs, outputs, compute substrate, ..., interfaces</span>.</span>  
  
    <BR/>  
    Where inputs and outputs are an extreme:  
  
    <Block>  
  
    </Block>  
    A substrate being a superposed language:  
  
    <Block>  
  
    </Block>  
    Intermediate steps being the program:  
  
    <Block>  
  
    </Block>  
    And the interfaces we have on it, being additional levers of control, or reading out intermediate steps (which our system could be ignorant of).  
  
    <Block>  
  
    </Block>  </Section>  <Section sub="">  
  </Section></Arc>  
<Arc head="Arc: Universal Version Control">  
  <Section sub="Concurrency, Dependency management, Causal Histories, ..., Theorem proving">  
    <span style={{textAlign: 'left', minWidth: '100%'}}><span  
        className="bp5-text-muted">Version control, causal histories, theorem proving, ..., a (programming) language</span> are all rather similar. Always we consider some sort of <span  
        className="bp5-text-muted">persisting, surviving, ..., crafted</span> items whose rediscoverability is not entirely obvious. In the case of version control, or reversibility, the gnawing question becomes: "What if I didn't know about something?"</span>  
  
    <Block>  
    </Block>  
    nor could rely on these things I currently know about.  
  
    <Block>  
  
    </Block>  
    could I rediscover this other thing I'm interested in?"  
  
    <Block>  
  
    </Block>  
    Essentially, version control comes hand-in-hand with compression. It becomes a story of redundancy, ..., recoverability. And we always consider both, simultaneously.  
  </Section>  
</Arc>  
<Arc head="Arc: Exploration and Discovery">  
  <span style={{textAlign: 'left', minWidth: '100%'}}>In exploration, one necessarily has to confront the problem of forgetting. Which becomes a tale of finding out how failures can be <span  
      className="bp5-text-muted">detected, ..., prevented</span>. How do you fight errors when rediscoverability is not obvious?</span>  
  
  <BR/>  
  <span style={{textAlign: 'left', minWidth: '100%'}}>The interesting thing about discovery, is that it's not easy to say <span  
      className="bp5-text-muted">whether, ..., why</span> a particular strategy is a good one for exploration. But what we can say is this: Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question.</span>  
  
  <BR/>  
  <TODO>Ref with examples?</TODO>  
  
  You could try practical guesses.  
  
  <Block>  
  
  </Block>  
  Brute-forcing enumeration:  
  
  <Block>  
  
  </Block>  
  You could have your unknowns drive your curiosity. [EXTREMES?]  
  
  <Block>  
  
  </Block>  
  Treating something as something it's not - essentially by simulating a "what if" scenario:  
  
  <Block>  
  
  </Block>  
  Quite funky constructions can be used it, but we're always considering some form of error correction. [REPHRASE]  
  
  <Section head="Fidelity" sub="Consistency checking, reverse engineering, debugging, ..., validation">  
    Fidelity, becomes a story of trust <Reference is="footnote" index={referenceCounter()} reference={{title: "A useful extreme to point out here is 'trust'. If verification of uncertainty results into uncertainty, then trust is the point at which we simply cut off the infinite regression and say: \"Let's just trust this output\".", link: "https://orbitmines.com/papers/on-intelligibility#:~:text=A%20useful%20extreme%20to%20point%20out%20here%20is%20%27trust%27", authors: [{name: 'Fadi Shawki'}], date: '2022-12-31', organizations: [ORGANIZATIONS.orbitmines_research]}}/>. If I assume some consistency,  
  
    <Block>  
  
    </Block>  
    <span style={{textAlign: 'left', minWidth: '100%'}}>I won't spend the resources to check whether that's actually the case: WIll something fail? That question is what fidelity means. If I have some way of checking that fidelity, that could be conceptualized as some <span  
        className="bp5-text-muted">error correcting, ..., safety mechanism</span>. Not doing so, in some <span  
        className="bp5-text-muted">simulation, ..., emulation</span>,</span>  
  
    <Block>  
    </Block>  
    Could have unexpected consequences:  
  
    <Block>  
  
    </Block>  
    <TODO>Fuzzing, random changes/forgetting</TODO>  
  </Section>  <Section head="(Self-)imposed Limitations" sub="Constraints, ..., resources">  
    <TODO>Limitation as things which seem like they can't be changed (from some perspective)</TODO>  
  </Section>  <Section head="Discovery" sub="Unusual, probing, ..., sporadic exploration">  
  
  </Section>  
  <TODO>Link to energy?</TODO>  
</Arc>  
<Arc head="Wrapping up">  
  <Section head="Future inquiries">  
    {/*I suspect that we've always lacked a proper tool to think across fields. E*/}  
    There's much left to do where this infrastructure is concerned. More specifically, I see the following steps on my horizon:  
  
    <BR/>  
  
    <span style={{textAlign: 'left', minWidth: '100%'}}>- Expanding the <Reference is="reference" index={referenceCounter()} reference={{link: "https://github.com/orbitmines/library", title: "OrbitMines Library"}} simple inline /> project. Providing steps towards <span  
        className="bp5-text-muted">language, ..., platform</span> interoperability <Reference is="footnote" index={referenceCounter()} reference={{title: "Whatever function it is that platforms and interfaces serve, they will probably converge to being more of a theme applied on a particular type of structure. Only as a supply of resources (access to certain kinds of information/compute) will they persist. They will not persist as separable interfaces.", link: "https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project/#:~:text=Whatever%20sets%20up,have%20been%20found.", organizations: [ORGANIZATIONS.orbitmines_research]}}/> <Reference is="footnote" index={referenceCounter()} reference={{title: "This would have to include higher-order version control, keeping track of causal histories. And constantly reprogramming the renderer on the fly. Before a thing like this becomes even remotely practical.\n\nBut all these intermediate things are all practical tools for a smaller audience anyway.", link: 'https://x.com/_FadiShawki/status/1790005202084335947', authors: [{name: 'Fadi Shawki'}], date: '2024-05-13', organizations: [ORGANIZATIONS.twitter]}} />.</span>  
  
    <BR/>  
    - Additional steps towards gamified learning: <Reference is="reference" index={referenceCounter()} reference={{link: "https://github.com/orbitmines/archive/blob/main/projects/Project%20-%20Research%20towards%20Designs%20(2024).md", title: "Research Towards Designs (2024)", organizations: [ORGANIZATIONS.github, ORGANIZATIONS.orbitmines_research]}} simple inline />.  
  
    <BR/>  
  
    - The setting up of <Reference is="reference" index={referenceCounter()} reference={{link: "https://github.com/orbitmines/archive/blob/main/projects/Project%20-%20Computer%20Networking%2C%20Security%2C%20Encryption%20%20%26%20Communication%20(2025%3F).md", title: "Universal Networking Infrastructure (2025)", organizations: [ORGANIZATIONS.github, ORGANIZATIONS.orbitmines_research]}} simple inline />.  
  
    <BR/>  
  
    And plenty of other explorations. Though now that this initial theoretical step is behind me, my hope is that my projects will start picking up in pace.  
  
    <BR/>  
    <div style={{width: '100%'}}><HorizontalLine/></div>  
    <BR/>  
    And to wrap up this "Wrapping up" arc, let me quickly repeat a few things already alluded to in my 2023 thought excerpts <Reference is="footnote" index={referenceCounter()} reference={{...ON_ORBITS.reference}}/>: <Reference is="reference" simple inline index={referenceCounter()} reference={{title: '"On self-publishing and referencing"', link: 'https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20self%2Dpublishing%20and%20referencing'}} /> & <Reference is="reference" simple inline index={referenceCounter()} reference={{title: '"On language and my bending of it"', link: 'https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20language%20and%20my%20bending%20of%20it'}} />. Which by default should carry over to everything I write down. Though repeating it might be necessary.  
  
    <BR/>  
  
    In any case, even though I did not understand the scope of what I was making: We edge ever closer to the project I have been anticipating for several years now: <Reference is="reference" index={referenceCounter()} reference={{link: _2024_02_ORBITMINES_AS_A_GAME_PROJECT.reference.link, title: "OrbitMines: A Game Project"}} simple inline />. This is merely one of the first few steps of many more to come.  
  </Section>  
</Arc>