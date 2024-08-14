---
Mailing List:
  - https://www.jiscmail.ac.uk/cgi-bin/webadmin?A0=QUANTUM-COMPUTING
---
The project will lend itself to start thinking about physics/hardware at some point. Which will be relevant for all other projects. 

This is necessarily a much harder problem than all other software-related problems. Though the software infrastructure will serve as a substrate for making these physics problems much more tractable. 

*:orbitmines: :github: [Archive equivalent](https://github.com/orbitmines/archive/blob/main/projects/PENDING%20(2027%3F%2B)%20%3B%20Physics%20(%26%20Hardware).md)*
*:orbitmines: :discord: [Discord equivalent](https://discord.com/channels/1055502602365845534/1238126981233512478)*


---

- [ ] Sean Caroll answer 'priority questions' from his Patreon supporters in his AMAs, perhaps once some quantum idea gets stuck reach out to him.
- [ ] Process these ideas:

Physics

---

Read
- [ ] https://www.reddit.com/r/archlinux/comments/6la6n5/trying_to_understand_drm_dri_mesa_radeon_gallium/
- [ ] https://github.com/fail0verflow/radeon-tools/tree/master/f32
	- [ ] [[fail0verflow]]
- [ ] https://github.com/AMDESE/amd_ucode_info
- [ ] https://www.mov-axbx.com/wopr/wopr_concept.html
- [ ] https://github.com/hughperkins/VeriGPU
- [ ] https://en.wikipedia.org/wiki/Weak_interaction
- [ ] https://www.feynmanlectures.caltech.edu/I_toc.html
- [ ] https://en.wikipedia.org/wiki/Alfv%C3%A9n_wave
- [ ] https://en.wikipedia.org/wiki/History_of_Maxwell's_equations
- [ ] https://www.santafe.edu/news-center/news/new-work-extends-the-thermodynamic-theory-of-computation
- [ ] https://www.unitree.com/
- [ ]  Post-Silicon Validation ?
- [ ] https://en.wikipedia.org/wiki/White_hole
- [ ] https://en.wikipedia.org/wiki/Torsion_field_(pseudoscience)
- [ ] https://discordapp.com/channels/844566471501414463/1111689941848694924/1248949135239942316
- [ ] https://books.google.nl/books/about/Introduction_to_Elementary_Particles.html?id=dGIOEAAAQBAJ&printsec=frontcover&source=kp_read_button&hl=en&newbks=1&newbks_redir=0&gboemv=1&ovdme=1&redir_esc=y#v=onepage&q&f=false
- [ ] https://github.com/philipturner/bootstrapping-code-archive

Discovery data
- [ ] Higgs boson discovery data & others, where/are these things indexed?

---
# UNPROCESSED
*Tread carefully, confusion abound*

---

	- chiups have these things calls efuses, you can burn them to disable/enable (cant be unburned) ; hardware changes.

---

- AMD rant from George - some important stuff
	- Rockchip? RK3588
	- HSA to sidestep userend
	- rocminfo dump firmware info
		- rocm-smi
	- Opencl program/kernel nonsentical?
		- tenstorents distinction better?
	- admit kernels, not prewrite
	- tvm exposes some things they shouldnt: whether to allow cudnn style things - help short term, not long term, no kernel vfusions, searches, arch portable
	- Jim Keller: You dont want to skill waverscale (cerebras); you dont actually want to dioit it is chiplet and a substrate, problem is good yeilds.
	- chyplet style? grid-communciation problem; data communication
%% 	- AMD firmware in RDNA? %%

- https://discord.com/channels/1068976834382925865/1068976834928193609/1221543200213176340
	- AMD docs: https://gitlab.freedesktop.org/tomstdenis/umr
		- 

dwave?


- https://coral.ai/
- tenstorrent ? Found them before in a search
- ...

warp-level primitives?

- the linux amd-gfx mailing list (https://www.overclock.net/threads/official-amd-radeon-rx-7900-xtx-xt-owners-club.1802706)


---

[[2024-06-07]] [SEMF Discord](https://discordapp.com/channels/844566471501414463/1111689941848694924/1248632910475689994)
Does there exist a dual black hole in the universe which doesn't merge, but remain at each-other's boundary? If not is anyone looking for it? (Oppositely rotating or something) 

If you could construct a thing like this, it's probably a way in which you can reprogram at the universe's scale is my thinking

Or perhaps this is already the case :thinking: How would you even go about figuring out whether the number of black holes in the universe is an even number?

---

[[2024-03-15]] [SEMF Discord](https://discordapp.com/channels/844566471501414463/1111689941848694924/1218215772460154920)
Wait, anyone more familiar with particles know if you can phrase them as: "some local structure trying to escape some 'point' but being unable to escape some 'local gravitational structure' thereby being sucked back to the point. And having this keep repeating until something else breaks this sort of loop?" - If that's the case, do you know some approachable literature on this?

How I'm thinking about it makes it somewhat hard to separate what counts as places to escape to and what it even means to be at that 'point'. But more that if it doesn't escape - ie keeps itself at some more (relatively) local 'point' (by which I mean keeps traveling/trafersing some larger topological structure); it is deemed as a particle. 

I'm picturing a particle consisting of many of these sorts of structures trying to escape in every direction of the "local topological structure"

I heard something that Von Neumann and someone else tried to put quantum physics in lattice theory terms and failed?

Anyway, how I think about it is as follows: I have two "ordered/structures - unordered makes no sense to me". Each of those structures is the following: an arbitrarily branching cone in one direction, and a cone in the opposite direction.

Then comes the part that's still a bit fuzzy to me: Propagation is preferred in one of those structures, but it is copied across the other structure arbitrarily, as a way of "ignoring its order", this being the way you get higher-arity structures, and the concept of "unordered".

The difference between lattice theory-related things probably being the ignoring order part by some duplicating traversing structures.

But as you can see it's still quite ill-defined 🤣

(Von Neumann & Birkhoff evidently) though I've only read like a page or two on both of their histories

I'm trying to use language which fails me a bit. Both cause the ideas aren't clear enough and the language isn't equipped for it. 

Similarly it's not easy to make this distinction. There's by default (unless ignored) no embedding, everything is inferred from context which makes a minor local change be able to change quite larger (something you would deem as toplogical) structures. But this whole particle/embedding/topology terminology is part of my problem cause it's probably actively harmful in trying to frame it in this particular way.

I want more ways of phrasing: If I thought of it as a point as @_Z said, it's quite nice and useful to think about it that way. But that perspective will always influence my questions I'm asking about it

---

Traversing `.self` 
- Like [[Jonathan Gorard]] mentioned inability to parallize obstruction to causality - in the sense of cant traverse the .self ray fast enough to parallize like the superposition of a larger structure, hence it breaks on the further away things on .self
	- Trade-off between branching spatial extent

---

Hermission/herminisity /time reversal; i.e. ray swap ; look up hermission?

Blackhole as boundary?
How about phrasing that nothing there as traversal branching into a small local black hole. So more structure more of these small black holes, could you phrase energy release as these local realizations of some 'nothing' as the things that have actually built up additional energy you otherwise wouldn't see?

---

- "Hyperdistance Oracles in hypergraphs" seems obvious from the perspective of Ray? ; it's just traversing `.self` from some perspective instead of other things.

---
- [ ] Effectively random, like effective field equations, some idea from ignorance in the sense that: "might as well be truely random".  - unable to understand structure..

---

- [ ] Possible as an example: Rabin-Scoot theorem Jonathan tweeted which I first found (while browsing rust docs???) - Apply the inconsistency argument here, does it still make sense??

---

Read: [General Intelligence Requires Rethinking Exploration (2022)](2211.07819.pdf) Aleatoric uncertainty / Epistemic uncertainty / Irreducible uncertainty ; explore these? ; or perhaps both are already captured in the vagueness of the 'conceptual uncertainty' idea.

---

- https://en.wikipedia.org/wiki/NP-completeness / other complexity theory related ideas, computation universality, Halting problem, Rice's theorem, Godels incompleteness theorems

I suspect there to be some deep (a)symmetries between the certain conceptualizations of 'zero' and 'one'. ... For the conceptualization of zero requires some non-zero directionality. (; To have the ability to describe invariance, one needs some variance.)  

---

The difference in interpretation of 'inconsistency' in mathematical terms, and it's more usual definition of abstract change/directionality/asymmetry?
- [ ] Is this merely, within one system, there's a single inconsistency, which makes the whole thing ergodic, or is there something else?
	- [ ] It is precisely inconsistent systems which allow for ergodic exploration? - Then extact to another system to formalize


[[2024-03-11]]
water light simluationr redications

[[2024-04-06]]
3 dimensional sphere to outside of the sphere 7 dimension, lowrr topology Nick Hu mentioned  ; makes sense :thinking:

[[2023-09-13]]
3d modulus, perhaps points arrows outward, see where it goes, is it a hypertorus, is that definition like this? Inside to inside or inside to outside?

---

Spreads ro sll possible until another is better and the kthers contracts, adtercseeing lightning,? ; Everything is shrunk from the other side into the channel that now opens up. Entropy. ; ?
; Is lightning branching and hitting the ground phrasable as all the other branches contract back and use the branch that hit the ground? 
Probably many things you could phrase this way 🤔
https://phys.org/news/2008-09-lightning-reconnect.amp
https://discord.com/channels/844566471501414463/1111689941848694924/1234598827298914354

---

High fos water dropplet bounching off water myltiple times, each time higher the smaller it is, then merging witht he water structure below, local gravitational pressure breaks and then merges partially, shockwave below- interesting

---

Lovality in quantum/classical mechanics as field theory suggesting 'far away' no obsevrations have been made that influence them directly. This merely a matter of perception? For through enough time distant interations do impact locality, albeit in a more indirect way, which one wouldn't necessarily say isn't locality.

---

Duplicating traversing structures requires part of the topology to duplicate hence modifying it??

---

Always stopping= always moving  

---

- [ ] https://arthurpesah.me/blog/2023-12-25-transversal-gates/

---

Formulation of "limit of causality" which could be "speed of light"; Trade-off between global movement & local movement? Propagation through space against propagation internally.

---

Non-locality from a direction trying to be followed on ehich there is no continuation defined. One would be, oh it's a fixed point nothing happens it stays herem The other is, it's a pattern match time, what matches this end, well anything. -???


---

But then, at least in the quantum mechanical case, you want to be able to interporaltw between each of the successive points and relate it to the other space. This could be quite nontrivial indeed,  
"and everything in between in relation to some other space" very similar to overlapping - how is this different from superopose?  

---

computational effort. Unless in some extreme some local properties are entirely temporally (local) irrelevant? Doubtful? ; QUantum mechanics no cost to local equivalence of some state except the conversion in time. DIfferent approaches to the same state are locally actually perfectly the same except for potential elements; and thus future trajectory? Or is this contradictory and global state always relevant?  

---

[[2023-11-21]]
That twitter feed with Jonathan and Joscha bach talking about hawking radiation of blackholez, Jonathan saying that in the multiway (or quantum case) it means that branches in which the blackhole isnt formed/differently formed eventually outlive the ones that do, and that corresponding to their evaporation - if that was the case, or if this thought is indeed as interesting - what's the generalization of that? - reference in survival?

---
- [ ] follow up on [[Jonathan Gorard]] message;

The entropically dominant thing - what if that (or is that how) the wave function collapse thing is phrased? That once some measurement is made yhat doesn't necessarily mean that all the other branches are abandoned more that the one in which the measurement is made is entropically dominant and hence the one an observer sees. - Or something along those lines. - or apply this to other kinds

---

From [[Chyp (Cospans of HYPergraphs)]]'s 1st paper: "statistical perfect correlations or (GHZ-like) quantum entanglement." ; brought the thought: So it's the equivalency frame of the connections, if they are connected which means entanglement, not necessarily at the frame of the defined vertex. (Could make sense if in the case of the vertex we assume that that means merely additional constructions which should be considered - and are considered in the quantum case, but usually ignored.)

---

Why is quantum gravity/acceleration such a problem? Is it merely because the different casaul states aren't easily tracked of the thing that's perceived/identified as "the same" particle/structure//... (& hence hard to define what motion(/change and thus what the persisting structures are/is at that scale/level of description?)  

Again the thought of quantum entanglement being the formation of some (possibly nondestructabile - probably??) connection/relation to the frame.  

Could this jumping ahead be generealized as of some higher level of description interaction (for quantum gravity a quick search says the planck scale)

---

[[2023-10-30]]
Could the mass of a blackhole or its gravitational power or m.. be caused by its rotational spin/stored in its rotational spin

[[2023-10-24]]
COuld quantum entanglement be phrased as merely placing some relationship on some frame hence changing what that thing is necessarily?

[[2023-10-23]]
Could you find out whether/where/... some distant place is interacting with certain things (possibly non-locally) quantum-mechanically? (does this question even make sense?) - Detect whether some place is using certain kinds of quantum mechanics?? -. ...

[[2023-10-18]]
Entangled merely some reference to some part if the frame?

[[2023-09-14]]
Subatomic particles necessarily being in groups of primes or their equivalent, any symmetry no new particle

[[2023-09-13]]
Think I recently wrote this already case, could wuantum mechanics of zx calculus be that the double connection break since there's in some frame perfect summetry ignore the direction to be deleted. If not, then it doesn't happen. -

[[2023-09-06]]
[[Sean Caroll]]'s AMA - Quantum Mechanically some temperature with non-moving peieces??? - Definitely need to look into this, is it just non-local effects for taht temp, and so the local structure is not seeming to move or something like that\?

[[2023-09-03]]
How to relate [[Project - Compression (2025?)]] to concepts like attractors/black holes/etc.

[[2023-09-02]]
What's the continuum hypothesis? Is this just that pattern of infinity in some direction being satisfied or something? Isn't the pattern as an assumption enough or is it the pattern as an assumption is actually also consistent??

[[2023-10-31]]
How/(/is it even reasonable to ask) how some local environment of a quantum computer is lrotected against malicious attacks where the supposed cokputation effects something (nonlocally)?

---

If we measure two particles in a quantum cup state with the same meadurement on both 
ends we get a classical cup, not the other way around. This might be phrased that in the direction of the equivalency, if it is the only inconsistent direction, they merge and hence get an ordinary cup. If they are not isomorphic, since for the color of the spiders the frame of each color is another binary value and thus the structures are not the same if one ignores the directionality of equivalency, they break?

This is what the fusing is, equivalency, sameness, ifnoring the inconsistent direction doing the rwuivalencing.

Might this on a small scale also work for any kind of matching pattern ignoring the equivalency directionality? Does it have to be structure preserving beyond the pattern? Perhaps both simultaneously?

[[2023-09-01]]
Is it possible to from quantum states (entanglements), find ones which are thus causally related and have not been interfered with from which unusual patterns of measurement might detail the existence of distant civilizations which have built quantum computers?, and before building safeguards to this sort of detection can he found?

[[2023-08-25]]
Light is massless (or perceived to be in some context, since it isnt) because it doesn't interact between timesteps?

[[2023-08-07]]
Might there be a way(likely incredibly small technology, possibly quantum mechanical), to detect how much time is passing thereby being able to account for how much divergence there is in time passed through referenced speed of the whole structure doing the counting and adjusting for it.

[[2023-08-05]]
Construct neutrons/.... al the other things from the smaller thing?

[[2023-01-03]]
Causality as a conceptual extreme on correlation in time.,.

[[2023-04-07]]
Conceptualize from always moving at the limit speed at every yime step, but get blocked by spatial structures conflicting

construct sounds from light

Physics: Thoughts on Blackholes, having in mind how Stephen Wolfram described them: Information black holes/fixed points through time. They can merge, but that doesn't necessarily rule out that they can 'explode'/'collapse', evidently not an intuitive thing if it's never yet been observed. ; (31/03/2023; The thought occurred: What about something like properly timing the bringing together of multiple blackholes in a way that usually doesn't happen?; Can they be steered someway? Can a particular configuration result in a collapse? Is it not just the halting of any updating rules as Wolfram might suggest; but perhaps a temporally halted one in some aspect? )

On heat dissipation: If forms of energy are either motion or something like abnormalities which cause mass, and most theories see heat or motion as always existing as some form of waste product. Is there not a known process which turns motion into potential mass, is it not conceivable that a black hole can collapse, is it not conceivable that there might be structure inside one?

Are not processes different on the surface of another planet? Are not cognitive processes different on another planet? Is influence of gravitational forces enough to change the emerging layer of information processing? Could it impact lower hardware-levels to such an insignificant extent? Is not even the slightest change in speed or impulses possible which can dramatically alter outcomes?

---

What about waves/wave-length? How does that factor in with the speed limit? ; Somehow I've not thought about this aspect yet.

---

(; 08/03/2023; late night confusion); `Zero mass implies speed limit? Wouldn't that be reframable as speed limit `

What about waves/wave-length? How does that factor in with the speed limit? ; Somehow I've not thought about this aspect yet.

---

h (; planck) (or smaller) being the timestep for speed limit

---

Speed limit (albeit light speed or its general concept whether actually attributed to light or mot); the perfect spacial propegation in some space. A quality possibly attributed to teleportation as well. Nerely perfect propegation, spacial locality is irrelevant to this property.

Isn't the more interesting question how one would slow down once a speed limit is achieved? (; start referencing it without the use of light). Through some external abnormality one might be slowed down, but if internal motion isn't propegated, when is the motion stopped? What happens for instance with light? Some knowledge gaps here to answer these questions properly.

---

More trips around some moduli space representing required additional resources to keep it possible without collapsing to state of confusion (slight rephrase from [[2023-04-07]])

---

It seems to be the interaction of arriving at the 'same place' through high velocity travel, where one is moving, the other, smaller, not. That the thing not moving is interpreted ss the thing moving as a possible 'cosmic ray',

---

... this thought is not so well formed, I'm not sure on the right language for it. Spacial abnormalities being influenced by, or through being at some 'same place' (which is merely a matter of perception, they seem equivalent), through a space. Their interaction is through propegation?

Confusion here, I need some better terms to describe these microscropic influences.

---

A curious thought experiment one might perform is that of accessing previous states as a non-interacting observer without the need of memory - other than having to persist the particulars which would allow for this - which would require memory (; non-trivial persistence).

---

 The nonabsoluteness of time could also be defined as saying it is absolute in the sense of described earlier, but one would've meant by that that all perception of certain specific phenomenon are the same - those could clearly not be, but then they still change and hence you would be able to say thatm It's just that the definition of the realization of certain kinds of information isnt. It hasn't propegated yet. 

---

- universality makes assumptions of temporal stability? 
	- COmputationality/Universal computatinally equivalent in the sense that its abstraction ignores certain practicalities such as temporal factors ... but could in some way hold up in some infinite directionaly were certain assumptions to hold.

---

History: The initial side of the perceived non-trivial temporal directionality. Relying on some non-trivial consistency (; temporal invariance), in order to tell the story (; or be able to recover parts) of that initial side.  

---

Not so sure about these points:
- [ ] Rewrite rules, accidently hitting some "speed up?":: Hence time/inconsistency/motion/acceleration could be conceptualized as some unmatched pattern/relation (where unmatched is no link to some frame) looking for something to latch onto, and usually it's the next one in some directionality, other tumes the skipped a few in that directionality or something completely different - though abstractly if course this would be generalized as its own directionality so this differentiation only makes sense in relation to something else. - What happens if you apply this quantum mechanically/or multicomputationally?

---

[[2024-05-08]]
Supermarasive blackholes that would've merged, already merged, that's why you don't see them. Not this "smaller ones that need to merge to get larger ones" - like on the podcast with Chiara

