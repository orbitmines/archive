*Researching (Hypergraphic) Version Control through arbitrary traversal of Rays*


---

---
What to do with it

- [ ] Which I believe was something along the lines of seeing where certain changes had happened in dependencies/how that would break symmetries, notify that they have changed and need human attentioin overarching features of some programming language (across some versions), and provide entry into what is not defined. (this a ref to the robert project)
- [ ] History of rotations movements, replay at any accuracy  
- [ ] Track program movements.  
- [ ] Track interface movements. (Some directionality seen as temporal as to interface inputs.) 
	- [ ] Note on interface logging  "Since it's essentially a keylogger"
- [ ] possible: log the things one might want to undo to, instead of logging the thing something currently is after applying something  
- [ ] Becomes a story of redundancy/copies, could maybe move this file to [[Project - Indexing existing Abstract Models (2024-2025?)]]

- [ ] [USENIX Enigma 2016 - Timeless Debugging](https://www.youtube.com/watch?v=eGl6kpSajag) ; *George Hotz*


---
---

As part of the requirements for broader :orbitmines: OrbitMines projects, this will necessarily include a novel way of dealing with histories of arbitrary structures.

This is also the part of the project I will reapply with to NGI by 2024-02-01 as a possible source of funding. I'll soon post more information here regarding that by then.

---
# Researching (Hypergraphic) Version Control through arbitrary traversal of Rays

In the case of Rays, whether something is a vertex/initial/terminal is only inferred from surrounding context. And these checks only need to happen locally in order to decide how to traverse arbitrary structure (as in - I only need to check the presence of something next to me, not traverse the whole direction recursively in order to decide what to do).

More generally, we cannot actually guarantee consistency of anything. And so the system will just need to be able to deal with that at some level. This project will in its initial implementation probably not attack this directly, but it's just a general thing to keep in mind. And something I'll come back to in the other OrbitMines projects.

### In the case of a Version Control System this will require the following things:
- [ ] Arbitrary (partial, ..., incomplete) history of arbitrary functions, rewrites, ..., data types (generalized to some arbitrary Ray).
	- [ ] This then includes the automatic inclusion of existing data structures
		- [ ] Automatically includes DPO(I), ..., Git histories.
	- [ ] Allow for the realization that any arbitrary part of the rays are destroyed (this could include local connectivity).
- [ ] Can have a history, but no current value. No structure, ..., type, permutation information on, ..., between vertices except for that of something we identify as history.
- [ ] Arbitrary initial setup not necessarily optimal version. And through time find more optimal one's given a particular situation. (Hence just apply the same version control system on the version control system itself.)
	- [ ] Thus requires the automatic shifting between possible ways of representing histories.
	- [ ] This thus includes a way of mapping perceived geodesics.
- [ ] Unrolling of loops, ..., orbits, and setup argument for what kind of information one needs to differentiate between iterations of that loop, and possibly what certain initial places were.

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
	- As long as you can recall/.../remember something, in the case of some eventual consistency, you're often going to be causally invariance in some local respect (ignoring some difference).

- [Confluence](https://en.wikipedia.org/wiki/Confluence_(abstract_rewriting)) 
- [Convergence](https://en.wikipedia.org/wiki/Convergence_(logic))
- [Commutes](https://en.wikipedia.org/wiki/Commutative_property)
- [CRDT](https://en.wikipedia.org/wiki/Conflict-free_replicated_data_type)
	- [CRDTs go brrr (2021)](https://josephg.com/blog/crdts-go-brrr/) ; *Seph Gentle*
	- [CRDTs: The Hard Parts (2020)](https://www.youtube.com/watch?v=x7drE24geUw) ; *Martin Kleppmann*
- [Concurrency control](https://en.wikipedia.org/wiki/Concurrency_control)
	- 
- [Riak](https://riak.com/)
	- [Riak Core - An Erlang Distributed Systems Toolkit (2011)](https://vimeo.com/21772889) ; *Andy Gross*
	- [Riak & Dynamo, Five Years Later Presented (2013)](https://www.youtube.com/watch?v=AxG9DROsnqg) ; *Andy Gross*
- Some others [RxDB](https://rxdb.info/), [ShareJS](https://github.com/share), [ottypes](https://github.com/ottypes), [Operational transformation](https://en.wikipedia.org/wiki/Operational_transformation), [IPFS](https://ipfs.tech/), [IPLD](https://ipld.io/), [OrbitDB](https://github.com/orbitdb/orbitdb), [Git](https://en.wikipedia.org/wiki/Git), [Merkle Tree](https://en.wikipedia.org/wiki/Merkle_tree), [Vector Clock](https://en.wikipedia.org/wiki/Vector_clock), Plausible Clock, Chain Clock, Interval Tree Clock, Bloom Clock, [Matrix clock](https://en.wikipedia.org/wiki/Matrix_clock), 

---

[SpacetimeDB](https://github.com/clockworklabs/SpacetimeDB)


---


# UNPROCESSED
*Tread carefully, confusion abound*

- [ ] Compressing/minimizing ambiguity
