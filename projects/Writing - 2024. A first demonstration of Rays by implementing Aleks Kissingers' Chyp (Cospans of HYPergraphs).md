*Technical deep dive into the initial implementation Rays*

- ? Better variant of : *Compose as Equivalence as Compose*

See () for am introduction into some of these visualizations and my thinking. Oor () if you like ..

#### Existing Ideas
- [ ] Usual way of thinking about vertices/edges is more like a single arbitrary ray which defines in/out going rays along it. 

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
- Rewriting as placing the direction encoded as `.type` of initial/vertex headed to terminal. Where terminal is undecided (from the perspective of `.terminal`, can recursively be the case for any of these.) - So .initial is VERTEX, .self is TERMINAL