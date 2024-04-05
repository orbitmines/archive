
- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail

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
- Rewriting as placing the direction encoded as `.type` of initial/vertex headed to terminal. Where terminal is undecided (from the perspective of `.terminal`, can recursively be the case for any of these.) - So .initial is VERTEX, .self is TERMINAL, which means this .terminal returns ... (Basically abstraction layer fitting the structure - See [[2024-03-28]] note.)


With some possible physics connections here as well:
- Then energy conservation (if it holds up), could be using anything to the initial sides (casual histories/or some structure/.../topology) and shove them in the traversing direction untill there's nothing there. And hence we stop branching and in some ways collapsing in the sense of the teminal side then doing that similarly to the initial side.
- Could like this be much more non-trivial based on the structure being pushed in exploring the branches ; i.e. like that similarly determining which and how the branches are explored.
- FItting another layer of abstraction on the structure which determines the following direction (or generally this could be phrased as inferred from context) .terminal here is possibly undefined. ONly needs presence, no recursion checks. Concurrency issues then in many cases resolved, through always being associated with a particular direction. (See note)
![[PXL_20240328_160945724.jpg]]


#### Meh, need a good introduction, this isnt it
I suspect that a large number of problems arise from a rather simple conceptual mistake. We build languages, ..., interfaces as tools for understanding certain complexities. Yet we fail to realize proper tools for saying: Sure, those symmetries make sense in your language. But the moment you take in additional context, your symmetries fall apart.  
  
<BR/>  
  
Now similarly, calling this a "conceptual mistake" is itself also a mistake.  
  
<BR/>  
  
This is, in essence, a language to understand inconsistencies.

#### mEHbe
This thing is, in essence, a language to understand inconsistencies. A conceptual framework to make sense of ambiguity: A story of how destructively confusing languages can be. Though to me, most importantly, it is here as infrastructure. Infrastructure for the design and implementation of a different category of (programming) interfaces.


Refs
- https://www.youtube.com/watch?v=p2vadd_6550&list=PLtbvsohNkWeUItHqZ9LAn4Qnz8hT6JMhY
	- Covariant computation & [[Jonathan Gorard]]'s mentioning of graphs
- The [[Bob Coecke]] & [[Stephen Wolfram]] conversation
-  
- 