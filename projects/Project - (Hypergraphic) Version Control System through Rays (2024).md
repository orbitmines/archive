
- [ ] Which I believe was something along the lines of seeing where certain changes had happened in dependencies/how that would break symmetries, notify that they have changed and need human attentioin overarching features of some programming language (across some versions), and provide entry into what is not defined. (this a ref to the robert project)
- [ ] Track program, rotation, ..., interface movements. Possibly replay at some accuracy. (Some directionality seen as temporal as to interface inputs.) ; causal histories.
	- [ ] possible: log the things one might want to undo to, instead of logging the thing something currently is after applying something  

- [ ] [USENIX Enigma 2016 - Timeless Debugging](https://www.youtube.com/watch?v=eGl6kpSajag) ; *George Hotz*

- [ ] How to separate one's personal work, how to combine them, merge them, view them from the outside.
- [ ] Consistency as some verifications built in some temporal histories as tests or something: Dismissing as chaned..
	- [ ] The abstract idea of persistence is quite straight-forward:  non-trivially limits access to the previous 'steps'. ; initial

---

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
