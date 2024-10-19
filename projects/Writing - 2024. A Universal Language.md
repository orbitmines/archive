*Let's try for [[2024-12-31]] ; - Yearly excerpt of thoughts*

# Towards a Universal Language
**
###### Introduction
What does it take to build a universal language? That is the main question which is explored here. A language which can span graphs, programming languages, ..., sciences. ~~A language which you never have to leave.~~

### 

###### 

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
	- [x] What if the `.initial` is many, instead of relying on a single one which branches to many. So how Chyp's edge's work: many sources, to many targets. Could also use like `.self` that `.initial` & `.terminal` are necessarily an equivalency frame, where it's not obvious that there's a connection back. So there's a difference in `.self` & `.initial/.terminal` - remove this difference?
- [ ] Factory (Version Control, Causal histories, ..., Compression): Setup to constantly grow whatever in-memory graph/equivalences are found, get to this place so we can start iterating on discovery functions. (Good notion of causal histories & orbits needs to be there)
	- [ ] Notion of queues, resources (storage, capabilities), ..., priorities
	- [ ] Build up store of equivalences & patterns in some structure.
	- [ ] Notion of some intermediate state matching a selection
	- [ ] Causal history = coherence conditions ; ex: some input-output relation where some binary value switches, coherence in mapping 0 -> 0, 1->1, but change in selection.
	- [ ] "Measure of how hard something is to do in parallel (or in some other structure generally)" - differentiability of [[Project - Indexing existing Abstract Models (2024-2025?)]]

---

Interpreting; Functions (and coordinate spaces), variables, speeds, acceleration

- [ ] How to determine what is selected, ..., referenced?
	- Graph as a point / edge
- [ ] How to think about time, histories, ..., causal structure?
- [ ] How to have multiple perspectives simultaneously?

---


Unprocessed
- [ ] Streams 2023
- [ ] Screenshots
- [x] [[Symposium on Compositional Structures (SYCO)]] notes
	- Universal as in context independence. Then rewriting is harder.  
	- Ignorance of the functor is absolute equality

---

`.initial/.terminal`
- .initial/.terminal could be seen as a part of .self, but you can only say that if you can make it separable. (So .self ignores it, hence it's different.)

`.rewrite`, `.replace`, `.collapse`
- start with one, find match, then match entire structure and revert if not. ; one way. Detach and reattach.
- Switch perspective is switching names of functions

`.none` 
There are many ways of phrasing ; "it's explored/.../branched but dies", ..., "looked at, then ignored".
- collapse the loop/infinity with an extreme


- Boolean: Normal way of thinking about a boolean is .orbitm we assume modularity of booleans

`.add`, `.and`, `.assign`, `.superpose` : Compose an `initial & terminal` (.add is compose boundaries)
- .add integers: single equivalence; ` on vertices -> equiv initial from one side, terminal from other side.)
- Close to `and`: `.set`, ` = `, `assign` (add to (compose with) `.self`)


`.copy`
- Say some modular structure: send traversing left & right simultaneously, and cancel each other out
- Copy as traversing entire structure

`.equivalent`, `.compose` ; up the arity, probably makes less sense?
- Basically: does there exist a single connection between the two?
- Homotopy equivalence: When superposed perspectives can be collapsed to a single point.

`qubit / linear superposition / complex numbers` is a binary superposition, ..., orbit, which is differentiable in between steps (basically, if something else from outside the context can reach in between, it would find something there. ; Based on that precision).

- Reprogrammability
	- What does it mean for a point yo become its own direction? 
	- Data becoming function, geometry etc..


---

- [ ] Can have a history, but no current value. No structure, ..., type, permutation information on, ..., between vertices except for that of something we identify as history.
- [ ] Apply the same version control system on the version control system itself. (Generalized to keeping track of "equivalent (and smaller) programs")
- [ ] Which I believe was something along the lines of seeing where certain changes had happened in dependencies/how that would break symmetries, notify that they have changed, and provide entry into what is not defined.
- [ ] Provide easy portability away from the current setup "Provide me with this and I'll recompile it into what you want"

---

Examples
- Subtraction is more complicated than performing addition, for subtraction you need to know a length, unless you just cut something off without knowing how long it is.

Energy/Resources
- In compression tasks, is in the case of real numbers, the length of a fraction considered as a resource? - More precision, the larger the structure
- The larger the integer, the larger the number of digits in a fractal, the more structure tou need to describe it ; (at least if you're not expressing it as a more simple program, but have to construct the actual number) ; some loose analogy here to energy as a concept?  
- Coherence is expensive?
---

Process:
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction - Overlapping multiple levels of description
- Want to allow for conflicting perspectives, of which aspects can still be invariant


`.unordered`
	- Ref to initial/terminal enumeration / extremes somehow?

# UNPROCESSED
*Tread carefully, confusion abound*

---

Acceleration stopped by barrier, intuit ?

Spatial separation is what allows for parallel/simultaneous rewrites under some maximum travel speed (for causality) 

---
  
Any symmetry must be breakable - any symmetry has some ignored assymetrical property ; Does not have to be the case from the perspective of the symmetry.

unordered is parallel? how about set? or how about all of them but in any ofder? How about parallel, in a loop? And then parallel in a loop, excluding current one? Or excluding ones in a path (any order)


---

<Section head="Introduction">    
<Arc head="Arc: Core Ideas">  
  <Section head="A few steps back" sub="">  
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