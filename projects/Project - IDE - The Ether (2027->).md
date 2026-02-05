Once a simple interface is setup, we'll start to be able to design the next generation of that interface within the interface itself. Though it'll probably be useful to think about a lot of it off-screen. I'm putting this here mainly as a placeholder for now, and will come back to it after I'm back from Birmingham.

See: :orbitmines: [OrbitMines as a Game Project](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project/#:~:text=A%20quick%20step%20towards%20Design)

It's very simple:

> This problem, though filled with incredible technical complexity, in its essence is a visual design problem: What should it feel like? What should it look like?

*:orbitmines: :github: [Archive equivalent](https://github.com/orbitmines/archive/blob/main/projects/Project%20-%20Research%20towards%20Designs%20(2024).md)*
*:orbitmines: :discord: [Discord equivalent](https://discord.com/channels/1055502602365845534/1226863400957513768)*

---

# Open Problems - Quests

A. Interpretation and Reinterpretation of existing Software
- What is a useful Universal Language in which to compare all existing languages?
	- [A Program in Ray](https://github.com/orbitmines/ray/blob/main/Ether/.ray/Program.ray)
- How do you compare [thousands](https://github.com/orbitmines/ray/blob/main/Ether/library/Index.ray) of languages, without redefining all the semantics by hand? (using their existing implementations)
- Which categories do you use to measure all the diversity?
	- Grammars (verbosity), Runtime Complexity (which abstraction layer), Parallel/Sequential Time/Spatial complexity (??), Measurement of how complex the access to spatial structure of a Program is
- How do you create differentiation of languages based on those measures?
- How do you extract specific features from large executables/source code bases? And then reuse them in yours?
- How do you generate version control for substructures when you're only given the complete current and previous states of the programs? 
B. Gamification of Science, Engineering and Education
- What would be an example problem, and example reimplementation of that problem as a game?
- How do you model the existing knowledge of a player?
	- How do you initially calibrate the existing knowledge of a player?
	- How do you create a metric: "leveling system" to describe a players skill-level with certain interfaces?
- How do you tailor the interface to each player? ; When/How would you add to that arsenal?
- Quest Discovery: How do you generate/find quests relevant relative to some model one has of a player's knowledge?
	- How do you do open world generation based on a player's existing knowledge?
- Quest Effectiveness: How does the reward of the quest influence our future?
- Quest Difficulty Rating: How do you assign a difficulty rating to a quest, relative for the character completing it.
- Quest Progress: What would be intermediate feedback states to communicate?
- Quest Completion: How do you verify the solution?
- Quest Refinement: How do you redefine a problem, or subdivide it into many quests?
- What primitives do you need to program NPC Quest selection?
- Translatability: What makes a problem translatable into a game? And what determines how hard it is to translate that problem?
- How does the game start? For new sessions starting with zero knowledge of the player, to one which is calibrated to them?
- How do you make progression feel like a videogame?
- 
C. The Ray Programming Language
- I. 
	- Should you superpose concurrent accesses of a variable?
	- Is a function's control-graph without an initial boundary: a starting point, a valid function?
	- How do you run a function backwards?
	- How do you call and define inverses of functions?
	- What would be an appropriate geometrical library for describing UI languages?
- II.
	- How do you scale large game graphs to millions of players?
	- How do you limit spatial propagation by means of actual computational restraints?


---

# UNPROCESSED
*Tread carefully, confusion abound*

---

  
// TODO - Notes on Version Control  
// Accessing a variable of a function (either by partially filling it), but it got renamed in a new version. Alert the user.  
// A monkey-patched function added, is suddenly also used by the library. Notify the user it's now overriding functionality that wasnt, there before.  
// For .ray.txt editor we can inject labels before functions and hide them with some IDE plugins for non-Ether editors. So still support version control in-line  
// If a method doesn't exist on the variable, but it is castable to something which does define that method, say boolean and &/|. Converting it to that value and calling that method should be possible.  
//   |-> Version control: if that method is then implemented by a library, a user should be notified the functionality changed (probably unexpectedly)  
// TODO - Notes on Type Checking  
// If blocks like if array.length > 2 ... end, change the type of array within that block. // '{==.instance_of IP}' Automatically casts to IP.  
// Functions should relax their arguments to 'actually used this from the type'. (So type refinements)  
// ambniguity of types like String[], String[], defined in dependent type on the first/lkast arg, B = [] if A == ., & A = [] if B == . ; this is circularity, unless they both share the same condition, that should break circularity.
// Allow 'def Ray<T = Ray>', Meaning, T is unknown, but it is a Ray.
// Allow multiple changes which make it adhere to the type, as long as nothing is accessed in between  
//TODO If multiple edits makes it type compliant allow as if a single transaction

// TODO - Notes on Theorem proving  
// Expand tactic to inline proof. (different lvl of description - allow switch back it not altered ; or equivalence and change the view)  
// Tests is the same as theorem proving, -> Combine both approaches, is a specific case  
// example; As an example usage: Use theorem-prover to automatically generate all the possible boolean implementations. How?  
  
// TODO - Editor  
// Can be rewritten as: if higher abstraction level. for all recognized mappings.  
// goto label in an IDE should bring the label back one space. ; if then a type defined instead add it back.  
// If an automatic isomorphism is found, and the user is trying to implement it, notify the user it's not necessary.  
// Function in the editor where you select, press a key, then allow the perform operation on that selection like select capped text, .tolowercase it. done.  
//   -> Similarly, in natural language describe the thing you want to do to that selection. Same with object.[describe] for where the cursor is.  
// Eye-tracking should switch primary/secondary location, if the windows are side to side, if overlayed, the top one takes priority.  
// version control selectors at functions in classes in the editor  
// Use v[SUBSCRIPT] or ^[SUPERSCRIPT], and allow to undo to prefer non-script notation  
//TODO Extend UTF-8 with custom symbols, as a new String type. When copy pasted uses a different format to indicate it's custom symbols.  
// Associate @players.choose, with a comment/dynamic page above it which is quest information on why you can make thise choice, also how do you indicate, you just want to store the results preiodically and use later.  
// Editor, can be rewritten into preferred level of description, like there exists instead of #.some
// When editing inside a double ((, force ((+TAB to turn into a (( (double << might be used for subexpressions.
// Encrypted is editable as plaintext, but then normalizes to Encrypted. Encrypted with password which is required to be filled by the user on use.,

---
Different locations have different normalizers : basically what I'm representing my thing as.

// If a method doesn't exist on the variable, but it is castable to something which does define that method, say boolean and &/|. Converting it to that value and calling that method should be possible.
  
// Superposed values hold their origin.  (Carry which caller effected it)
//   -> The result should be refinable, "now I know it's true, so what's the result".

---

//TODO You want something like ray[500..999] = 500-length array, instead of setting all those values to the 500-length array. How to differentiate

---

// instantiations of a type using something like WaveFunctionCollapse


// KV pair with everything delegated to value, so you can do ==. (separate class like TransparentKV)

---

.cfg.ray

& variables are mapped to & only changes types/flobally defined vars for that context?? Cfg /file/path, Cfg @me/file, If just toplevel, it searches for any with that name unless toplevel exists. Cfg /File, Cfg.File
They still get executed.

All field are instantiated with ?() that is already the default, if? then None

---

Keep doing . <search inside> remove the previous searched and save them as the program run, allow ctrl z ofc. As a way of exploring existing executables/codebases etc. eith the keyboard

---

Equivalent code if type is refined Like Number vs i64

---

assume as a separate clause as well

---

Should you superpose concurrent accesses of a variable?
: Could be a range of values if writing is overlapped, to model a languages behavior.

---

defining multiple entrypoints of a function with labels. Use func**.LABEL(). Also define a starting branch which doesn't executed by default but only accessible with a label

  

How to think about Object as a superposed Ray ; Where Object<String> is all those overlapping Rays ; resulting into Strings only.

What about structures which define steps beyond&before the usual property getter/setter (is that just there's equipped structure on the return so .field.next if .field yields a ray

That's in the language's implementation of itself

---

Movement but the graph needs to go around some body to be put behind them? Instead if through

profram terminating needs also sone check that every step takes finite time; it needs temporal awareness 

difference in color mapped/filter across frequency

double (()) mapped to the utf8 char 

Programming language to create programming languages and IDEs for them
- Have some language which is English compiled to Ray with some way of supporting sentence steucture. What is unsupported? ; Have some way of generating common grammatical structures from the language models. ; somehow integrate them into development here.
- Things like collapse the Ray def to English if simpler ; link the two translations


Any set of actions performed on a single thing, into a function

Any object as tabular rendering; have preferences for certain types to render is certain ways per user

as Renderable on String to define render func instead of the plain string

Condition on source file like sort all the classes here in alphabetical order like library index

Language Server Protocol support 

Of course, we all know that pretty much every language is formally equivalent. But that's not helpful for answering the questions about differences between languages: Physical implementation, energy requirements etc.

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
Complexity relative to some T 

Comparing Languages

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
Lower spatial complexity is fewer kinds of building blocks? (What happens if there are many redundant replicas of that building block?)

resource use for certain types of algorithms

Analysis of compilation process: Spatial and temporal circuit complexity in that specific algorithm
- Quality of the equivalence graph, measured with what?

What makes abstract models better than others? 
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

# Large Game Graphs
Synced across regions (even planetary ones) "here is where this avatar was x ms/minutes ago".
- (Hazy vs ) Can setup delay for the server: Only send my location packets after X.
	- What about receiving audio and other information based on where your character was then: receive a server feed of the perspective of that server's information.
		- (Canonical) Name of this server-feed:
- (Veiled) Invisibility vs no invisibility (infinite delay)
Collision only if on same servers under X ms. Wherever server registered location isnt necessary, prefer player registered location
So there are two different types of Regions on who holds truth: "" & "", one can be distributed much easier than the other.

If locations are only able to receive X number of requests per second. Prefer requests from some nearby location, and do a full 360 sweep or perspectives within some render distance and what to render there. and communicate that to nearby nodes. So that nearby node, say 1 render distance away, only needs to parse that 360 sweep once, instead of traversing it all himself
 - Only directionally need to communicate this information to other Nodes. Only nodes in opposite direction of the source, need the information.
- lowering density of information at each successive step X m away. You need 2x the number of pixels needed to render it provide good quality? (Can we lower density of information of shapes/shaders etc.. to approximations from some distance away?) -Node would need 3D information of what the arcs are between each Node's position, and possible render or have available the information of all the gaps between the Nodes, so if, theyre only positioned in 2D, it would need to have accurate shapes for each value in the 3'rd dimension.
	- So what is the screen resolution used at certain perspectives? ; larger screen more pixels of information needed. Use that information to calculate how much to transfer over boundaries; largest screen used from some perspective would dominate.
		- Resolution and how large that perspective is in the game graph.
	- What about people using zoom-in at some point: That would move their location to something closer to some other node in the system?; If everyone was doing that, you'd have more than the allotted players requesting from that Node, and it would lag. How to support this too? Similarly, if portals/screens are setup to look into other locations. (Is a minor delayed allowed or not? ; the closer you are the less delay.)

Then reserve % of traffic for this communication between nodes.

How many nodes would you need to hold 1 million players & what is the most packed they can be how many m^2
- dynamically allocate more nodes the more players are in some region.

Assuming 2d, though the same would apply over 3d distances, just more communication between Nodes.

10x10cm - 50cm x 50cm avatar size
World (1 million players) 1000x1000 players
- 100m x 100m - 500m x 500m

Let's assume 100 players + a radius of other Nodes talk to each Node.
So we have (100x100) 10,000 Nodes to render a (100m x 100m - 500m x 500m) space.
So 1m x 1m - 5m x 5m per Node

Like this the latency would go up linearly as the distance of Nodes away increases

So technically, it'd have to provide rendering details for a 1m-5m x 1m-5m x Inf cube,
- What if there's additional rendering information, like for certain players, certain players are invisible, or for certain players, certain players are highlighted.

If only privately hosted, if number of players increases, suggest to move to @ether (or partially), or increase @private.managed.

- How to handle collisions across adjacent nodes
- How would you do audio. Let sources interfere with eachother, then add them together and render that. How to do that over a range of perspectives 
- Sound/Light in certain directions.
- Configurable speed of sound, and whether it can travel through something. (lower-bound however is that of the server latency - so also how many servers are needed to render worldgraph); Unless we do multicast of certain information x Nodes away 

Effectively what we need is a way to render audio/light etc.. to go in all directions. Without having to render all perspectives. (But then for efficiency, in a more intelligent way somehow: Interference of abstract structures.) ; Construct waves in the world graph. How is that done efficiently?

OR

Store Ray and iterate through object at that World Node, eventually going through its boundary through another Node. Then defer to that World Node's last version of that information. Dont allow communication with the next Node.

Hazy World

---

Expand .. operator for 2D grid and graphs

---

#### Game Intro
- Already allow moving around even in this quick intro? - even before collapse down
- Quick showcase of the possible worlds ; "See the possibilities" ; Too little to see isn't obvious enough. Short overwhelm, then calm
	- Simple 2d grid spans the screen (from one diagonal to the other) 
	- Some break in the middle ; 2d grid changes color maybe ; opening a portal in the middle.
		- You traverse through it, all around portals opening to possible worlds (other things people have made).
- Collapse back to a point, interface at rest ; "Waiting for you to start exploring"
	- *Could be like the old tv screen shutoff, sucked to the middle.*
- Somehow the idea of "find, extend/recursive",
	- Right from the start already dependent on user input
	- Point to a small figure
	- dot, line, grid, world, color, more complex world generation - till you're thrown in a more complicated world. 
		- See some direction to move into for each step. (; small step automatically, wait for the rest) ;  "Shift the attention focus at the start as a way of guiding the first few quests to get familiar with how it works"
- Zoom back out into a room, in front of an old screen, phase into the screen, and there the starting point of the game. Allowing you to explore the room if wanted. Or it spawns new things in the room.

#### Open World Generation
*A step to translating problems to game-like invariant quests, ..., puzzles.*

World Generation
- [ ] [DreamCraft: Text-Guided Generation of Functional 3D Environments in Minecraft](https://arxiv.org/pdf/2404.15538)
- [ ] https://www.val.town/v/thesephist/webgen
- [ ] https://lumalabs.ai/
- [ ] https://x.com/active_theory
- [ ] Spatial computing
- [ ] 

Read

- Changes to a room, as moved holograms, slider to move back and forth between versions

---
- Function discovery
- Compression/Geodesics
- Inconsistency is statement of reprogrammability - or multiple levels of abstraction - Overlapping multiple levels of description

What are different perspectives, on the same object in terms of the language.

Projectile, or some energy(/localized updates), is a keeping a program pointer around and stepping in forward once. then returning the program pointer again on that variable.

###### Open explorations/quests
*Explorers, researchers, traders, ..., pirates: Gatherers, crafters, ..., spreaders of items unknown to some, ... all*

###### Items & Quests
*Generalized variant, I see this thing in the world, in this particular place, want to decode this particular thing (some communication / item) I see. Can then unlock the ability to solve or see different items etc.. I have this other item/mod/type of vision to look through the world differently. "Portal through, see the world/inventory/server in a different way"*

#### Interface Design

- Collapse blocks of code down to an english summarization of what the code does.

- Any interface, hooks(/finds) unbound controls. Any follow-up changes hence possibly effected. Can be unbound, superposed, etc.. 
	- ; Latching of controls, defaults of controls from context. ; Additional controls based on kind of interface etc..
	- Basically move this aspects to [[Project - Indexing existing Abstract Models (2024-2025?)]]
- Existing interfaces

- Personalized world, ..., workspace
	- Aspects shareable, others not

- Functionality
	- Ignorance/dropping of any structured (say explicitly kept history or others), when used for something (say matching aspects of it to others structures etc..)
	- (Random) exploration (; worlds/items/..) ; Phrasing "random exploratory funtionality" ; "Periodic reminder/suggestion/exploration"
		- "What are places I haven't looked? What are the places I could want to look? What are the places I decide not to look but would still want too look?"
	- Better replay ; "replay/detective/.../fossile"
	- Like "npc/bot/exploration functionality I'm not doing myself/others"
		- [ ] Notify me when you've found something you deem relevant for this unknown (while we dont know how to solve some unknown)
		- [ ] This would allow for the hooking of the process by a programmer: Hey while you're still working on this thing, perhaps [some answer to some function] should be considered, what would happen then? (Basically simulating an answer by a programmer ; some arbitrary process which hooks into a function)  
		- [ ] Already start doing something while decision is pending - do the things which one can reverse?  
	- You want to do things like "include this thing like a video", if one has access to that - for instance if it needs to be paid for conditionally, in this place in the rest of the structure. That way you can conditionally include things and get around ownership issues, since it'll only be displayed to ones that do have access. -> For certain things a feature like this would be obnoxious though, so what's a good usage for a thing like this.

- Exploratory functionality ; people explore differently.
	- Some notion of not expecting people to explore by themselves - simplicity (vs others who do), and guiding a way to stimulate that exploration - some form of ???.

- Experience/Mana/Energy - Gravity/Entropy
- Use the emergent gravity idea from spatial density to construct spaces
	- [[Project - Indexing existing Abstract Models (2024-2025?)]]#differentiability / [[Writing - 2025. A Universal Language]]#compresison - some merge between these things, or where should this be put?
- 
	- Similarly, crafting, resource constraints and how to translate that to how it influences what one can see ; What can I change about my infrastructure vs what can't I? ; "Energy aware contexts, is how people refer to it"
	- Measurement of category if diversity for the thing its useful for
	- Assembly/Disassembly of items ; "Destruct this thing, use it for something else instead"
	- Paths already explored: Cave's, items are influencing what the caves, "what's been searched" by you/or by others/ what can you find.
		- Basically directing movement in a certain way ; Like the ants following a group
	- Don't forget that it's important that the furthering of certain steps can be arbitrarily delayed ; if resources aren't spent on them. (this, and all these things should have direct translations to the programming interfaces?)
	- How much storage?
	- We use up resources to realization of some invariance (symmetry), which lowers the search space, but increases possible interactions. (Basically higher-arity again) ; Non-trivial superpositions through that invariance.
	- From certain perspectives, how many operations need to be performed ; relative to some other thing
	- minimization, compression, of branches basically
	- novelty; basically change parametsrs til you find somer which are so unsual to the one's currently

(Cyber) Security
- Recognize aspects (what to break in/random exploration) ; invariances to things I know that sort of thing, but could be fleeting ; puzzle to solve. Not entering the world, but observing it or something I know about it.
- How do people not know you dropped it there (basically security and things.)

- [ ] If I can show it in some asymmetry in multiple ways, prefer to show in multiple ways to aid disambiguation ; or not always, but a better variant of this.

[[PENDING Project - Computer Networking, Security, Encryption  & Communication (2026?)]]
Server-like/find server-like functionality
- [ ] ideas loke actually being in some servers/having some server list/-like Minecraft, publically indexable etc. for people to collaborate their work in, is an essential idea. 
- [ ] Ways of finding you as "hook into your world"

Interfaces
- https://www.bigscreenvr.com/ [[Bigscreen]]
- https://makereal.tldraw.com/ (https://github.com/tldraw/tldraw)
- 

#### Research of Games, Engines, ...
Link to [[Project - Indexing existing Abstract Models (2024-2025?)]]

- [ ] Are there people who have been thinking about game-invariant puzzles?
- [ ] Self-modifying rendering engines?

Games
- [ ] https://store.steampowered.com/app/303210/The_Beginners_Guide/
- [ ] https://store.steampowered.com/app/221910/The_Stanley_Parable/
- [ ] https://store.steampowered.com/app/587620/Okami_HD/
- [ ] https://store.steampowered.com/app/384190/ABZU/
- [ ] https://store.steampowered.com/app/638230/Journey/
- [ ] https://store.steampowered.com/app/2719750/Star_Birds/
- [ ] http://braid-game.com/
- [ ] http://the-witness.net/
- [ ] https://edoublea.artstation.com/
- [ ] everybody edits
- [ ] 

Science/research games
- [ ] https://fold.it/
- [ ] https://eyewire.org/
- [ ] 

[[Project - Indexing existing Abstract Models (2024-2025?)]] ; tools
- [ ] [pixel-composer](https://makham.itch.io/pixel-composer), [aseprite](https://www.aseprite.org/), [figma](https://www.figma.com/blog/behind-our-redesign-ui3/), 
- [ ] https://hexler.net/kodelife
- [ ] 

- [ ] https://cybercat.institute/2024/05/09/exploiring-best-response-dynamics/

#### Audio
People: [[Pinar Temiz]], ..

- Audio ; basically like [[Writing - 2025. A Universal Language]] ; 'easy-rediscoverability/seperability in a certain way if not in the obvious seperation case.'
	- separate audio sources so disentanglement/referencing is easier ; basically separating the superposed things ; generalize

Rendering Engine
- [ ] https://siboehm.com/articles/22/CUDA-MMM
- [ ] https://jbaker.graphics/
- [ ] https://thebookofshaders.com/07/
	- [ ] How is GLSL used in WebGL, three.js and game engines?
- [ ] https://otoro.net/ml/
- [ ] overlayed, layers in window (https://www.fxhash.xyz/vertex/entangled)
- [ ] https://github.com/Genesis-Embodied-AI/Genesis

---

[igdb.com](http://igdb.com/) submit game to get twitch category

---

What if we tried programming first, how would you gamify aspects of it? We're essentially saying how do you compress something which has so many degrees of freedom, into something which is much less flexible; less degrees of freedom, yet maintain the same sort of functionality.
- What does resource gathering mean?
	- What if we match resource gathering to some active quest? Does something different depending on the active quest? But there's a general pattern of what that resource does?
	- A simple example is somewhere in the world have some 'smithy' which creates keys - which is like a crafting table so it's also a searchable item. So instead of having encryption keys being some command you have to remember, it's remembering you can go some place which will make one for you. Then the 'configuration' of the key is just some 'crafting menu'. This item would be a bundle of two items, private/public, this bundle is like a mine\craft bundle. It's a single item with two inside. Or like an object with two fields.
		- One of the resources used in making that being the 'entropy' resource accumulated by the OS.
- What does maze navigation mean to find new problems?
- 

---

What type of information is stored on player? Things like: Preferences, interested in these fields, these types of knowledge trees already unlocked (can autogenerate these to some extent?).

Other IDE functionality:
- A generating file with some syntax of some alternate language with intermediate code snippets which aren't interfering with the syntax. 
- Server discovery with possibilities of some community driven setup. So discovering ways of discovering other servers.
	- Local servers
		- auto-join local server if last logout was there. per device, allow to (goto position of this device)
		- non-local servers you'd join via the menu, with a last visited on this instance? or in general.
- location could just be a lace in a program for UI. with triggers to leave it etc.
- Keyboard keys per context one is in, configured by looking at program graphs.
	- in keyboard/controller settings, highlight which parts are being used at that time.
- Hotbar is just keyboard and other controls like scroll to scroll trhrough them, items bound to them. With inventory being ordered by recent items, or a fixed amount of stuff set there. OR (can be customized)

---

A stack is an arbitrary graph of some type, so say a stack of keys/credentials

Whether a graph allows programmatic cursors to traverse it to find items like files in it. ; Or it requires a player to move there or be close to it. 
Then you have things like "items in this room" or "items in this room I can traverse now"

Infrastructure is there for things like navigating and storing items in any structure.

**Central question becomes:** What is the game loop outside normal file management of an IDE.

---

Desktop environment which is a 3d room with items/files in specific places. cudtom look in 3d rendering. like a book or a project. Search highlights the in 3d place. Hide stuff "in the air" at certain locations. Access the environment in the usual text/terminal format, define searchfunctions in that or 3d format
Autogenerate some parts of this sort of environment when a user is first loading their desktop in.

Instead of having the entire 3d structure in memory different nodes of "in between with distance x", allow overlapping 


---

Now how do you make it feel like a game?

# **Avatar**
Can optionally reserve another username specific to your avatar. ; or reuse ones from old Avatars
Is a set of unlocked skills and paths traversed with that avatar
Allow merging and copying of your own avatar

Progression
- (permanent) Character
- Avatar ; per World (or group of Worlds)
- Avatar/Character Level
- Avatar/Character Class (Creator{Builder, Engineer},  Explorer)
- Avatar/Character: Skill Proficiency (Skill = class of Quests)

What awards progress? How to combat being gamed as a metric?
- Want some baseline or historic, and a recency variability 

- Whether certain skills are actually used (within some class)
- Change function of what methods are used?; as a proxy for is there change (not necessarily improvement)
- Skill proficiency is linked to recent usage; can be partially lost
- Are because of this usage actual quests getting solved (combat nonuseful automation)
- What downstream effects does your solved quests have? Social value, etc.. (What is contribution to some quest is partial - how to determine value of that contribution)
- 

What is unlocked by progressing?
- Used as metric for difficulty rating of quests
- Want some way for the game's rewards to be actual computational objects somehow; where having a skill is some actual skill instead of a lifeless check. (Takes actual skill to repair something, for instance); Again this question of how you create scarcity 

---

Example problems:
- cryptography problem (for certain problems you could have a timer on how it would take some tactic to solve it)
- theorem proving (can you reach or prove to not reach a certain state).
  -> Every problem is like this
- Search for equivalent but more efficient programs
   - Some importance on their usage -> What's the effect that's caused by some optimization 
- Search for equivalencies (vague?)
- program writing
- 
 
These are all abstract examples, I need something concrete 
---

- Existing programming languages with a more constrained interface like a controller.


Non-trivial interfaces
- [ ] Holotile floor, and things like it, more future-oriented search
- [ ] Tacticle/body movements, ...m anything

---

Features
- [ ] Take two or more poins, collapse them all to reference one thing?.  ; either that selection, or anything else found at that selection.
- [ ] Pulsing out, one perspective can't access but another can

Keyboard
- [ ] Singlke keybind for now to show/hide the ray disambiguation or 'dead edges/..'/
- [ ] Numbers on keyboard to length
- [ ] Number + parallel compose

---  

- Idea for chyp-like functionaltiy: Put the graphs setc at the top, invis lines, then draw them on hover, and maybe make surrounding stuff less visiable. ; context of how to apply somethig. ; minimap as ignorant ref

- Import arbitrary structure (drag/copy/paste)
- Control
	- ignoring attachment of where came from, from which would follow the others as the same ignoring again the compariosn, collapsing the tei structures into each other ; ignoring the embedding. - Basically driving them to some "0 point"
	- Expand/collapse/superpose arbitrarily.
		- Can at each step choose which continuations to follow (`step`)
	- Bind structures to controls ; copy/paste, this key does this
	- Single key to show something for everything, ignored structure, could just me a simple program applied to the whole interface, show me all the 'orbits' on all the structure.
		- Basically: use loop to create line, rolling the loop oit by introducing variance in the traversing direction  
	- Some intuitive slider of some level of description over an existing interpretation to match it - quite dynamic
	- Draw arbitrary continuation to another level of description, basically taking some structure, trying to hook it into another structure ; Say the 2d grid of the screen into the cells of the gpu or something etc..
	- [ ] Which moves one can make depicted visually (<>, circular, etc..) 

	- draw with mouse, multiple in a line
	- Like a paintbrush slowly growing in certain directions having particular steuctures.

- [ ] If you ahve to use mouse, force lock on the structure, close to the mouse?? ; Generalized to drawing in, but this is also a bit of a problem when generalized.

Always, how detailed, how much context, how much can it latch on etc..
- Drag from one point of contact on the background to another place

- 'Install app' in browser for desktop/mobile

 - [ ] Time & Spatial (Circuit) complexity  
   One complexity is related to sequential processing capacity (hence circuit or time complexity, a very well known concept in computer science)  
  
The other is related to parallel processing capacity  
  
   For instance what is usually called high level languages (far from just zeros and ones), I think that affords higher parallel processing.  
  
Robustness of code etc I think is very connected to this too. More complex is usually less robust, but this means there will be two types of robustness I guess  
  
One last note: I think these two types of complexities and costs can be considered also "inverse problem solving" and "forward problem solving":  
  
- agents' cost of training: cost of inverse problem solving (forming the model, building it). Basically induction cost  
- agents' cost of "deployment" or use: cost of forward problem solving (using the model to predict things; ""generative"" or predictive cost). Basically deduction cost  
  
~ Alex