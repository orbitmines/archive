D. Gamification of Science, Engineering and Education
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

---
# UNPROCESSED
*Tread carefully, confusion abound*

---

Stargate apparently has an episode/serie on encoding a problem in a videogame.

---


# Constrained Physical Propagation
- Blockchains on each node, then the physical move through idea.
- No random access, need to actually move through the graph to discover or copy the graph.
- Synchronize the past not the present.

# Large Game Graphs
Zoom in is an actual npc probe sending out in eye direction directly communicating the higher res information to you

Communicate equations up to inflection points disntance away from origin at which point you communicate less polygons ; fuether away less plugons

Generalize past visual text for instance keep summerizing

The further away the different information like equivalent to mobile resizing of dcreens rendering differently. Like text resorting to a symbol or a bigger smaller words

---

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

# Guided Navigation Language
Essentially what we want, is to reformalize engineering (creation), reverse-engineering (identification), optimization and search; into an intuitive language, which guides computer exploration/navigation. In such a way that whenever something can be brute-forced, it will be brute-forced.

# Visuals

Problem categories: (They're all intertwined)
- Creation
	- Interface definition (frontend/intermediate/backend): Just item creation. (similarly types) - Just interactive design
		- Function definitions: Item interactions
			- ??
- Identification
	- Reverse engineering problems.
		- Cherry-picking, categorizing, taxonomy.
		- Guided search to match a particular type of pattern?
- Search
	- Optimization
		- Optimization problems: Take existing function as specification (search/sort/compression/disk access/...), and optimize.
		- Should be guided search: Look here, etc.
	- Search for existing items to use (whether that's identification or ?)


- How do you not lose the advantage text prograsmming languages have: a quick overview
- Have some item in hand, then do an action then get a popup on what that action should mean, and start defining it that way. Like projectile etc..
- Throw out the idea of having names for things. (Or rather make it optional?)
- Perhaps islands of competency, and connecting them?
- Description of like a type/room for instance, being an example built from that perspective, using the objects as types, then being able to configure additional details like age etc. then saying generate something with these properties 'choose'. (Ignoring the existing structure). 5x for instance floating underneath/above. Also translatable to a text variant (should be the case for everything) where the 3d coordinates are modifiers or <> in front.
- Every item being an inside room which describes it.
- Things like all these object formats are just [Specific backend] to a [3D + Dynamics] frontend.
- Click specific key, when hovering over item, then any keycombination to bind it there. (Can be a pattern of key combinations)
- Properties of some object being just items put in some 3d space which together make up that item. (But in this case there's also an actual 3d orientation to it we can use.)
- What is the main advantage gained in 3D?
	- Can easily describe 3d relations, can layout things spatially.
- What are things lost while going 3D/visual?
	- Arbitrary names linking - instead would have to be through items, which could still have names though.
- So items with insides for the objects, so that would be some frontend backend. The real question is how to construct something similar to functions?
	- One way is to record some chain of interactions, where the functions are just items within the item, but this is just a normal programming language; need something more creative.
	- Competency islands (; algorithms?), what would be an example:
		- Perhaps only works for optimization-like problems? What would an open problem look like?
		- Navigational types/algorithms, how to search a space.
		- 
- Stretching to right adding points,length/count displayed bottom right
- Something like if this screensize, is if the ray from certain square size is activiated; part of the chain. Take a ref to that item, and say This: then apply this transformation change. ; In this sense if is just an item toggle all changes made are only the case for that if.
- Instead of having events named, instead press a key, then have some event happen (record), and then something pops up which says when that happens. Taking the latest event as a default, for instance; clicking, means first hovering then clicking. Shooting means first releasing, then hitting (so if stopped in between we take the release event).; But also events like travelling through, certain events should get priority over travelling through for instance, but be able to switch easily from event to event (group).
- Comments as descriptions on properties and items (shown in some menu on the right); when having some Identifier toggled. (Similarly just some item)
- UI layout just a place you can visit and move stuff around. (& Add the key item to.)
- Worlds/scenes you can visist and connect arbitrarily (view those connections from the specific worlds as well). (Like a list of worlds each of them being a possible way to render something)
- Probably makes most sense to make a mixture of text vs visual/3d where which makes most sense, saying + 3 for instance, or move X times, is good to type.
- NUmber/Base with an infinity symbol bottom right is unbounded

# Gamification of Optimization Problems
- Programming language for visual environment instead as step 1

By playing tell the computer what to focus on, feedback means what?

Gamification of Optimization Problems
- There's optimization problems: So systematically steering optimization basically.
- There's always an equivalence relationship with optimization

Optimizing compression algorithms, so + an equivalence relationship on input/output given the algorithm. ; reversibility at every step is key. 
- benchmarking: A specific file vs A category of files
- tradeoffs: What category increases, what category decreases


Optimizing a specific goal functionality, so + equivalence semantics 
What if we say, the goal is to design some sorting algorithm, so there's a well-defined problem, how would you map that to something on which we have feedback on how to explore possible equivalent programs. Where complexity & size of the sorting algorithm is a resource, and we're trying to optimize speed.
Basically we're influencing some algorithm/AI/traversing mechanism which is checking all possible programs.
Induction/deduction again; how does one explore.
How do you input more symbolically expressed ideas?
How would you understand what the current state(s) are?
You want to be able to say, ditch this line of inquiry, go back and persue some other thing; actually a 3d location?
- A way to translate/compress the problem of moving through possible program space, into the lower dimensional which is the UI.
- Obvious problem becomes how do you benchmark a solution; if we have access to the steps why it's an equivalence it becomes but what does it actually change?

- Equipped items as what is currently being checked; obvious nonuseful paths to explore etc. You can then create new items of course to do different things 

- Specific locations map to specific types of algorithms, items mined at those locations have properties based on how useful they are; They stack to stuff of the same category; similar properties. You can always retrace where you got an item based on that item; holds that history.
- What do those items look like? Specific to a problem?

- NPC which magically (at distance) influences whole world gen; or current state

What if you have two worlds/locations you're at, one is some higher level location, the other details on that location; Or as a way of jumping abstraction levels; zooming in/going smaller

- Current best, and current path.
- Strategies: Finding a 'nearby' (nearby in the sense of close in possible operations space) number which has nice symmetry properties. (naieve for the general case - but probably still applicable in many cases)
	- Need to be able to do numeric operations on LARGE numbers.
- The current cursor (how we've reshuffled the number) according to certain compression mechanisms responds like X: runs in the background because it's likely to be slow for large files.
- Building a Model
	- Need to be reversible, different position different model
- Extracting modular features? ; Learn patterns, extract them and construct them using code; or compress that code into a modular model which calls code.
- What would an architecture look like which is made for this sort of quick feedback; how do we combine ideas of statistics with this new architecture.
- Pattern search: High-level/low-level patterns across data. How do you guide search for that: That's like a mode on finding things to compress, then later a mode of how to compress it.
	- How to make the strategies for searching for this configurable too, so this would mean a sub-problem which is not an optimization problem. It's an open problem to find all the patterns; how do you benchmark that? Quality/compressibility of the found pattern probably.
	- What makes it a pattern is that we can generate it with from a lower space. So repeating is just \*, frequency is just ??
	- What is training/using an embedding equivalent to in pattern search?

Another issue is that in compression like using an autoencoder/decoder is incredibly slow since we can't parallelize the token-dependence. How far can you compress without that?  

You want existing algorithms to be importable: So a specific interpretation which is a compression algorithm to use it as a starting point. You want some way to differentiate between two of those imported implementations; how do you decide where to use what. Probably nestedly use as a components, or actually use aspects of that algorithm in the current one.

---
Functions/items made by others which are equivalent, select one, search space for new items...
Combine different physics engines which approximate some general def of a physics engine 3D + Dynamics.


#### Ideas for a setting which works
- When putting on the VR glasses zoom out to the moonbase, highlighting the accelerator, putting it into focus + the larger one, then switch to a view where it is where one is balancing the forces in the machine?
- Upgrade capacity (mana) by adding computers to the network. Visually displayed how?
- Aid the creation of a model while it is training
	- Model output needs to partly be what is used for player feedback. Which becomes input as well.
- Multiplayer; pool together resources.
- Train tools independent and dependent on the model; which impact how to learn.
- Speed being combination of relative processing speed and learning rate.
- Mana is processing power - with an overhead mana cost to connecting many together?
	- Required operating mana cost vs sequencing cost.
	- Say compress the network/prune then expand or submodule part of it. Which requires mana ofc.
- Problems: Speed, effectiveness (loss-entropy).
	- Actual algorithm used?\
- Develop submodules you use for other expriments.
- For compression we essentially say: The search space of possibilities is too vast to get to the proper entropic qualities of any specific structure, so instead we resort to analyzing what happens with a distribution of similar numbers to compress. Is it possible to find a  middleground?
- Configurable reliability of the substrate
- Perhaps there's is a strong tradeoff between predictive power & interpretebility, which plays a role here - dani

- World State, Player/Inventory State - both reflect something to about the system controls.
	- Again, translation.
	- Developing associations, doing stuff while it is training, those world interactions become intertwined with the model at particular times? So that would mean you could do anything in this world and it then becoming a control surface; but only possibly if the network latches onto it. Like creating a donut and it then being associated with particular aspects which are donut-like. So create 3d analogies.
	- Enforcing certain topologies in certain places; how to get the hint that certain topologies might be useful there. What is lost? (predictive power?) What is gained? (speed to learn this shape?)?

- Science lab, you're trying to create a new element, you have your energy which you can focus on very specific instantiations of an item. Then you search for those items and have some predictive capability of how well it will work for that element.
	- Or similarly some industrial factory or something, or workbench with an NPC which does work for you -> and you can give them certain
- The machine has a VR setup next to it, to enter exploration mode?
- You could later imagine hiring more equipment, by which we mean literally running stuff on some server/cloud.

- Things which have more than one 'mana bar' are actually just multiple items in some environment which all separately have a mana bar, say network, disk, etc.. capacity.
- Mana just T instead of TB etc..
- Mana of the room; max storage capacity.
- Copying is a magic spell which might take a little bit (so it actually copies on disk); uses "Mana"; let's rephrase mana as a thing which says we have certain capacity X/GB/s write speed, and we use temporarily use it.
	- Over network and locally too; requires Concentration. Can be interrupted. What do you call requires concentration, but we dont mind if it's interrupted?. Different levels of concentration: not every interrupt interrupt all concentration.
	- The one who sent it is the opposite: it's clear, because it's just a ref to the current object, and slowly it becomes less opacity; it's remote now.
- In a similar way if the room is being downloaded it use the same opacity effect and come into view? ; But that only makes sense if we get an outline of the room first.
- Have items be recognizable when they're only stored in memory, or not even and stored remotely. Cast a way to materialize; localize.
- Capacity of GPU/CPU/PCIe buss; "Mana" of objects.
	- Purposes of what they're used for: 
		- Buffer so that I don't have to redo the PCI thing: Moving the material from Place to Place, or keeping it in some specific place. 

---

Encryption key being a physical key, handing it to someone (with some extra step) transferring thst item. Putting it in a door which represents the space you want to tp to.

Copyable items

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
- Zoom back out into a room, in front of an old screen, phase into the screen, and there the starting point of the game. Allowing you to explore the room if wanted. Or it spawns new things in the room.

#### Open World Generation
*A step to translating problems to game-like invariant quests, ..., puzzles.*

World Generation
- [ ] [DreamCraft: Text-Guided Generation of Functional 3D Environments in Minecraft](https://arxiv.org/pdf/2404.15538)
- [ ] Spatial computing
- [ ] 

- Changes to a room, as moved holograms

---
###### Open explorations/quests

- What about non-technical translations, could you for instance do history in the sense of a storyline story and convey all the important information. Based on some book? 


---

Desktop environment which is a 3d room with items/files in specific places. cudtom look in 3d rendering. like a book or a project. Search highlights the in 3d place. Hide stuff "in the air" at certain locations. Access the environment in the usual text/terminal format, define searchfunctions in that or 3d format
Autogenerate some parts of this sort of environment when a user is first loading their desktop in.

Instead of having the entire 3d structure in memory different nodes of "in between with distance x", allow overlapping 

Generate room for me, or choose your own, then type of room picker and at every step describe your room.

'here' triggering current eye location, or pointer using fingers.

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
---

- Existing programming languages with a more constrained interface like a controller.