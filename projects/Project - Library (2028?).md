

---
# UNPROCESSED
*Tread carefully, confusion abound*

---



# Tools for Excavation of Languages
Reverse equivalence graph - add abstract definitions instead of specific code

- Extract features from programming language/executable and implement in my own language (if possible)
  - Assets, and renderable abstractions which use those assets
  - Create scoped objects; What is relevant to what; what are functions applied to things which we can extract
    - Rewrite as higherlevel code to analyze separately 
- Compare differences of two separate executables
- Find source code of targeting code, if in public repo somewhere, and being able to ref back to the original code from the generated code
- Likely original highlevel language - or highest, in the case of LLVM they might look alike alot for instance
- For translation from language A to B we might want custom compiler rules for specific languages
- Run with breakpoints and the usual debugging tooling & edit the code (from multiple descriptions levels)
- Use "Comparing Languages" for specific algorithm comparisons; what changes in the possible analysis; what can we deduce now what we couldn't before
- Endpoints, network calls, db, files etc.. all of it, configure custom values at each point

# Comparing Languages
How do you start classifying arbitrary complexity? One of the things I've directly arrived at is that whatever that classification is, it must be some mutable thing; every judgement made of some metric (say some kind of complexity rating), is not (easily; if at all) reduced to the least complex implementation of that classification. The metric will necessarily be a judgement: It is a rephrasing of: "currently it is this metric" instead of "it is this metric". A subtle but important difference.

You also need some reference frame in order to make these judgements. Essentially to compare two different languages, you are required to have some other language in which to phrase and compare the two. Any judgement you'll make will be relative to this language: if one were to pick a different language as its basis, you might come to different conclusions. Once you have picked your universal language as your reference frame, we can solve the issue of reference frames: We can lift it to another reference frame and ignore anything caused by that change of frame. Basically: what complexity is required to express that other language, and subtract that complexity (if possible) from the final judgement. This allows us to say: from which perspective do you want to classify the arbitrary complexity.

We'll call our initial reference frame our universal language. And the perspective we're currently judging from our reference language.

Once we have that setup you can ask: How useful is our universal language, importantly: given our existing languages. This rather simplifies the - Is something """the universal language"""? -. And instead rephrases it as a cultural question. Which leaves the rather gnawing question of what we deem as "useful" here. Whatever it is, we'll consider it as a mutable cultural thing: It depends on what your preferences are. Let's go over some of these preferences we may have: 

### Judgements
- What does "useful" mean here?
	- Lowest complexity of existing languages
	- Given which preferences? Weighted by use of the language? "use" in the sense of active development vs existing code basis in "use", by how many devices/people. How critical are they?

You want to also compare things like LLM/models as implementations of English or other languages. -> Can be targeted in the sense that they then in turn generate something else. Large surface area of how to target them though: what format do you use.

Need to have some metrics and some useful meaning to them, categorized or?
Complexity relative to some target (specific implementation of that target) -> or a series of compilation paths. 
- Filter for what do you want to optimize for.
	- Optimize targeting X. (In least complexity or ..)
	- Optimize 
	- Does it have support for X -> X is a selection from some other library (otherwise X is ill-defined). Possibly through library.
	- Precision of changes of states.

(Running evaluation)
Spatial extent (memory&threads) & temporal extent - then compare the same function across languages

Dichotomies: 
Can we use the same thing Alex thought about?
Markovian Nonmarkovian
Abstract (High Level) vs  (Low Level) -> Interaction nets/combinators vs instruction sets, or gate implementations of those instruction sets
In Time (x) In Space (y)

Higher spatial density -> lower spatial circuit complexity
Higher spatial density & higher temporal circuit complexity -> Higher gravity

High/low spatial/temporal abstraction 

Higher temporal complexity is many in sequence layers?
Lower spatial complexity is fewer kinds of building blAs a wayocks? (What happens if there are many redundant replicas of that building block?)

resource use for certain types of algorithms

Analysis of compilation process: Spatial and temporal circuit complexity in that specific algorithm
- Quality of the equivalence graph, measured with what?

What makes abstract models better than others? 
- Flexibility, how flexible are the types of expressions 
- Time&Space vs Abstraction Depth? : Verboseness; How abstract certain statement are; deep meaningful statements, but still customizable 
  - Sense of meaningful: Useful abstraction that get depended on a lot; and what they otherwise would've looked like without 
- Coverage of what kind of functionality it has; but how do you put that in a 1d?
- What kind of (classes of) thinking do they unlock; [how do you know this]
- What is the abstraction ceiling? What paradigm are not expressible within some time/space complexity 
- As abstraction increases what happens to control interface; what do you have influence over
- Which abstract spaces are described effectively relative to the surface area (interface) one has. So a 3D interactive maps nicely but constructing a graph with just text less so? (what would be a 1d interpretation)
- How competent in dealing with infinities & time 
- Similarities in libraries or structures so that from the perspective of each language, how different/hard to learn is another language,( rudimentary difficulty rating)

Competencies calculated with vs without all the libraries made for it 
- Effectiveness of standard library? How much duplicate code is out there in libraries.

Can you use these criteria to search for new useful abstract languages? Pick/Generate a new model with certain picked qualities

Better for what?
- Control over what type of system 
