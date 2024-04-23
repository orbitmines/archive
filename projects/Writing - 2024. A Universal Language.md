- "Can just draw a line (or any structure really) and say I want to regard that as the same, not obvious what would happen if you do that, but you can."

- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail
- [ ] Not quite sure about the last paragraph of whether to mention existing projects (infrageometry, lingua universalis etc...) in the introduction or the first few things after the introduction, but this for now
 
```ts
// TODO: What about showing disconnect when multiple things are rendered at the same position??  
// TODO: It's, rende rboth draw equivalence, then ignore the difference from either perspective or take some middle thing. - Line from both ends, also vertex? (or take the pos, take the x from one/other, y from the other/..)  
  
// TODO: Could be a function on Ray (any func really)
```

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


This one will need some refs/hooks into literature
- https://www.youtube.com/watch?v=p2vadd_6550&list=PLtbvsohNkWeUItHqZ9LAn4Qnz8hT6JMhY
	- Covariant computation & [[Jonathan Gorard]]'s mentioning of graphs
- The [[Bob Coecke]] & [[Stephen Wolfram]] conversation
- [[Chyp (Cospans of HYPergraphs)]] & [[Aleks Kissinger]]
- [[Alexander Grothendieck]]
- ...

---

# A Universal Language
*One Ray to rule them all, One Ray to find them, One Ray to bring them all, and in the darkness bind them: Explore a technical deep dive into Rays. Accompanied by a simple implementation of Aleks Kissinger's Chyp (Cospans of HYPergraphs).*

<Section head="Introduction">  
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
</Section>