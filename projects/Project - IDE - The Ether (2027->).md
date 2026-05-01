

# Open Problems - Quests

A. The Ray Programming Language
- I. 
	- Should you superpose concurrent accesses of a variable?
	- Is a function's control-graph without an initial boundary: a starting point, a valid function?
	- How do you run a function backwards?
	- How do you call and define inverses of functions?
	- What would be an appropriate geometrical library for describing UI languages?
- II.
	- How do you scale large game graphs to millions of players?
	- How do you limit spatial propagation by means of actual computational restraints?
B. Interpretation and Reinterpretation of existing Software
- What is a useful Universal Language in which to compare all existing languages?
	- [A Program in Ray](https://github.com/orbitmines/ray/blob/main/Ether/.ray/Program.ray)
- How do you compare [thousands](https://github.com/orbitmines/ray/blob/main/Ether/library/Index.ray) of languages, without redefining all the semantics by hand? (using their existing implementations)
- Which categories do you use to measure all the diversity?
	- Grammars (verbosity), Runtime Complexity (which abstraction layer), Parallel/Sequential Time/Spatial complexity (??), Measurement of how complex the access to spatial structure of a Program is
- How do you create differentiation of languages based on those measures?
- How do you extract specific features from large executables/source code bases? And then reuse them in yours?
- How do you generate version control for substructures when you're only given the complete current and previous states of the programs? 
- How?
	- Generate surface area of what the distinguishable Items are - doesnt need to adhere to the data schemes used in the code.
	- Generate surface area of what actions those Items can do; Self-modifying, modifying others.
	- What is the purpose of some Item?
		- Which interfaces is it exposed to?: Is it displayed visually/auditory/...
			- Are contents displayed? Or is it the existence of the item?
		- What is the visibility of that item supposed to be? Is it communicated over the network? Or never? Is it encrypted? ; this should be interpreted and respected. Similarly we could identify some code which checks for a license and still identify all the items within the source code if possible, but respect the license as visibility of the item. ; The visibility's visibility - so whether we can see the item, would depend on whether the source code has some preventive mechanism  where the license check is concerned. - Of course users could override this check if there's no preventative mechanism.
			- If accessible still equivalence with open-source free variants, and say there's free alternatives.
		- 
		- How is it updated? Modified within the code, modified externally by an updater; version tracking.
		- 
		- 
		- Equivalences?
			- Find equivalences across other things currently within the interface (or in the library): Is this Item loosely equivalent to this other Item. ; ex. (Chat) Message across platforms. Same for actions.
			- How does it differ? - which we deem useful to ignore for the equivalence ; for instance messages ordering, nested threads displaying beneath them in case of certain platforms etc..
	- Customization:
		- Themes: Use their theme - or equivalent themes. But overlay a possible way to modify it from their perspective.
		- Version changing needs to be diff-able (visually?). ; The interface shouldnt break if there's a breaking change which we still need to resolve because there's some conflict. Either fall back to another theme (the updated one) 
	- Import from source, OS-specific library or drag-and-dropping a link to the start of the program.
	- 
C. Reprogrammable UI
- Create a modular system for items from other interfaces to plug into.


---

# UNPROCESSED
*Tread carefully, confusion abound*

---

Abstract Interpretation
- Needs access to something like `speculatable`, but something more intuitive `interpretable?`.
	- Need to explicitely specify, needs to be smart as to not accedentially run something like rm -rf on the whole directory, if the user is for instance rewriting something like speculatable rm -rf SOME_DIR and removes SOME_DIR. -> Perhaps after a change need to reflag as interpretable.
	- Needs to know when to cache the results, if they're IO or nondeterministic?

- Different levels of trust of whether to execute the code. (Who's the author, run the code as them on my pc, so the @player is set) ; and then we can configure them not to allow to run HTTP requests for instance. ; Prompted with a ; trust this author to run network requests: Or only specifically certain domains, with/without data attached etc..
- Extra level of dont give full write access to drive for instance; only in specific folders things like that. You can override it, but you have to manually change that configuration.
- How do you say: Can not send data over the network, only receive? Pretty impossible, get maybe fix the addresses and then no body. But timings can still be used to communicate. It is much easier to say: It may not send any of this data or its derivatives over the network.

- Different levels of execution. 
	- [FULL RUNTIME] Say we run classes because we flag them as `initializer`? Then we execute all code inside. (actual execution) 
		- [OPTIONALLY PARTIAL] But we also want to support large functions just partially running them and storing the partial stuff and showing that off. Even just normal interpretation.
	- [ABSTRACT INTERPRETATION] Then for other methods, we just run it with the abstract class just put on the variable. And only call all other initializer methods like =/:.

- anything IO flagged returns the abstract class; unless flagged with `speculate`. Ignored when flagged with `refuse` - It only effects the actual IO, not the downstream things done with that IO.
	- First pass, abstract interpretation; call all functions with the abstract classes.
	- Always full runtime, but we flag stuff getting information from outside like environment return the abstract class.
- 

Actually Running
- Store objects in cache, but which ones do we use for then providing the value? Might not be constant.

---

Building, just from the perspective of some directory; it resolves everything inside it. If there are duplicate identifiers used by the classes, it should resolve to the closest one in directory form? TAnd ofc select the other ones by hand by a tool to disambiguate. -> add VS code functionality.  

all the forward references     
  which will have to be resolved. So a loading of a particular file might  
  also send diagnostics of other effected files. 
  
Only reload a single file and all the dependencies it touches, resolutions; then reparse those too.

---

`var: class`
`var: class & String`

---

Generate under/above a function, applicable to these versions etc.. ; migrations from many versions to a new version.
- Focus in on a singular method and all the supported versions.

---

Method for checking whether something came from the STD or from some other package.

---

Versioning: My current thinking is that even though SemVer is widely adopted, the meaning of what is a major/minor/patch is a bit diluted. This is probably because there are multiple levels of arbitrariness to the version number. So approach is rather simple; reduce this to just a single point of arbitrariness: the major version, which is increased after a simple question is answered: Is there a breaking change in its publicly facing API? With the exception of the major version number 0; it is allowed to introduce breaking changes at will.

---

Event system in which you (the user) can inject events into other's code.

---

Env variable at that moment or at startup

---

shared vs non-shared static fields.

---

Hot reloading abstract & production code, introduce migrations at every level of the stack; how does this look in the editor. Test properly? What happens inside loops, are they broken, what else is done differently etc..

Not a single file only dependencise:
Same shape as 
  the dependency tracking we just discussed for hot-reload, but generalized:
  every computed value memoizes against a content-hash of its inputs;

---

Variants on the same idea:                                                    
  - Linear — must be used exactly once (Linear Haskell, Granule)                
  - Affine — must be used at most once (Rust by default for non-Copy types)     
  - Borrow — temporarily unique within a scope, original ref can't be touched
  until you give it back (Rust's &mut)                                          
  - Quantitative — the type says "0, 1, or many uses" (Idris 2's QTT)

dynamically assert the number of references to a variable basically. Similarly other memory-related things.

---

Version control Hybrid logical clocks /CRDTs

Local version of the codebase and then your fork of the codebase easily accessible to others working in the repo. -> Can always push

Apply a change to all stable versions.

Commit/flagging a change as the thing which actually works. Also group like all the changes in a single merge or something like that.

Test my changes against the latest changes, instead of merging the latest changes into my own.

---

Mixed RTL/LTR syntax

---

tests for syntax, which alter the existing external methods etc..

---

error[X] where X is the version the error type got introduced. + a number

---

Create virtual filesystems into the ether

---

```
a = 
  obj
    .func
    .func2

```
a here is obj, not the result of func2. since it accepts the block func2
```
a = obj.
  .func
  .func2
```
this would call func2 explicitely.

Or force the . usage to be the 'typical' call the obj on the next line.

---

URLs have developer caches, in case the original domain goes down/no longer works. ; publish those cashes optionally, by default yes/no?. Require cache for publishing for when the direct one fails at runtime.

---

Each project has a .ether with configuration for that specific project

---

Benchmark/timing buttonfor each function

---

3D/2D modelling app using one of the diffussion models or something.

---

Whether it is databases, or user interfaces or programming languages, we want separability between the layers of applications. Where interfaces are just themes. ...

---

#### Proofs
- More generally about proofs: They're simply a mechanism by means to base your decision on what is vs isn't fruitful to pursue; They're a search and memory mechanism. -> Useful it the sense that it unlocks something you couldnt do before -> They somehow tell you something about the space.; Both in how you arrived at your conclusion as the conclusion itself. A proof already navigates the spaces by probing it in some way, and that tells you something.
- (1) How do you take advantage of what it tells you about a space.
- (2) What distinguishes a proof from a normal program type  
- 


---

commit all changes made in repl session to a specific variable ; set @me @ [persistent var] = @me


---

If there are genuine ambiguities in the editor youd be able to pick one and defer to that one always.

---

Weird bug in Book where if it has the same structure, the codeblock of the previous page gets displayed on the current one, is the case with A. & 3. if you remove the BR at 3

---

Editor up/down shuold remember where it came from and go back if no left/right has been done. End of the line goes to the end of the line on up/down

---

Incentivize optimization: Something like the projected use vs actual use because of optimizations, say evenly split that benifit between optimizer and the beneficiary; 50% of that optimization for 1 year after the change? or no time limit.
Then again incentize contributions where the contributor gets a % of the total costs saved.

Basically when does the baseline optimization change every year? Every 3/5 years?

How's it measured against changes that bring down the optimization for some feature etc.. should effect the baseline properly

How to measure the change against the baseline and whether it is actually caused by that change?

How do you disincentize making a bad baseline in order to rake in early.


---

Smaller cloud/hosting environments (which might in turn be hosted on one of the other providers)

---

Program filter disable certain language features like selfmodiyfing types

---


Maybe 
..{right: .} | {left: .}.. | .. (right?) =>
..{right: .} | {left: .}.. | (.. (right)) => // signature per option

---

status, custom icon

on any icon generate a set of sub=files under it with are the file in different formats.

---
# Database
Class$ uses that. - in memory/disk dynamically when necessary
- Optionally distributed
- Need something which supports arbitarry graphs not just 2d grid of columns/rows.
- The way the object is stored vs showed to the user as a filesystem will diverge, storing isnt optimal as the same data structure. Especially if we account for the fact that we'll support a wide variety of "where data should be hosted". --> minimize reads because reading is expensive.
- Fields of course versioned the same way clasases/functions are; that way renaming doesnt make a whole new object and force us to rename all the records: the entire version history has an ID. (what was its id originally, probably. - perhaps the latest version if thats no overhead, to know for which version the data was created./modified last?)
- uniqueness effectively how? Also what about eventual uniqueness, where conflicts are allowed but force one of them to change; uin case the databases are separated for a long time. -> Basically merge conflicts
- partitioning  - based on time/hash etc. can select which bucket some value would fall into, but might be hard to change this as youd have to rewrite data.
- optimiziations, when to add pathces to the data, when to rewrite completely etc..
	- Want automaticially pick optimizations; but tradeoffs are things like how easy to change that optimization etc.
	- Fastlanes, Adaptive Lossless floating Point (ALP), Fast Symbolic Symbol Table (FSST), DIctionary (dict_string), Bitpacked, RunEnd, PCodec, ZSTD, FFOR, RLE, DElta, ; these things should be part of the language index.
	- What are data dependencies? (bad?) - probably dependent types.
- Statistics of a column/file min/max/null count/sum/... necessary when? for what optimizations?
- benchmarks

Essentially, all that databases, and dataformats try to do, is to optimize some more inefficient, but useful higher-level abstraction. That could be the way objects reference each-other in a typical programming language or the structure of a file system. Essentially they're just some backend to optimize some frontend access, not unlike any other problem in programming languages or compilers. What I take away from that is a few things:
- (1) The frontend, like a file system, should in practice be disconnected from how it is actually stored in practice. 
- (2) Optimizations, like any optimization in the language, should be dynamically allocated, with some preferences defined on what to do in certain situations: Do we rewrite the data, or just adapt our future data access? What is the single-time cost to rewrite the data (energy/time/cost)? Vs the cost of overhead caused by splitting our way previous vs future data is accessed. 
- (3) Most typical databases are only an optimization on a very restricted type of data, which is common, but still restrictive: 2D row/column data. We'd want to support arbitrary data and optimizations for that data, of which our usual databases are just a subset of a subset. 
- (4) In our specific case of version control as well, the backend data (in whatever form it is) is just a specific way of generating frontend data (in whichever form that is) - so the version control should just support the different existing VCS's as frontends (even though they're typically seen as backends); we can compose them in that way. Which should be bidirectional: if I choose I want git exposed as a frontend, I should be able to write to git and it effecting our backends.
- (5) The contents of a file are similarly just a frontend. If it is useful to destruct it into components which are stored and searchable separately, that is another place for optimization.

---

COmponents which shouldn't override top-level property, but only contents of those properties, and overlay those. (But at what level?) How would you configure this? Set property => {property.* to property.components.last) - Want to say property = property.map dynamically how? Then make an extension for this; components.merge/##.merge or something

---

in a repl, settings such that changes are permanent to your character.

---

[y: 5] move in a specific dimension

---

Side quests, unexpected competencies, intrinsic motivation

---

is default set, and should it be set as a part of data storage, or should it only be set once the default changes, should it follow the default adaptively.

---

```
// Standalone: stop string hit → returns content before (stop-at, SUCCESS)
const r2 = parse(ctx.not('=>'), 'hello=>world');
assert('stops at =>, returns "hello"', r2.success && r2.value === 'hello');
```

Should not succeed. If the pattern doesn't fully match it fails. So .not doesnt stop at => it just says it must not continue with that. So the pattern fully fails, of course unless there's another Any which does in fact match.

---

Ongoing prompt like Extract this feature from this binary

---

"".[LANG] to syntax highlight,.

---

canonicalize as a filesystem, delegate certain fields to certain files/dirs. fields under @me.ray , other things separately like stars.

---

Wrap remote executable with what to get out of global context intutively and not so verbose? is @me, the me who sent it or?

---
Use loadbalancer from some cloud or use load balancer to test a new feature from builtin

---

if @public
elsif @,..

// TODO - Notes on Version Control  
// Bundle lot of user changes in a new @ether version
// Accessing a variable of a function (either by partially filling it), but it got renamed in a new version. Alert the user.  
// A monkey-patched function added, is suddenly also used by the library. Notify the user it's now overriding functionality that wasnt, there before.  
// For .ray.txt editor we can inject labels before functions and hide them with some IDE plugins for non-Ether editors. So still support version control in-line  
// If a method doesn't exist on the variable, but it is castable to something which does define that method, say boolean and &/|. Converting it to that value and calling that method should be possible.  
//   |-> Version control: if that method is then implemented by a library, a user should be notified the functionality changed (probably unexpectedly)  
// Support enacting a change across many versions
// Certain updates across functions go together; some grouping version

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
// Editor preference for using math symbols or not: which syntax level do you prefer
/Ctrl + up/down moves the page up a line

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

Keep doing . [search inside] remove the previous searched and save them as the program run, allow ctrl z ofc. As a way of exploring existing executables/codebases etc. eith the keyboard

---

Equivalent code if type is refined Like Number vs i64

---

assume as a separate clause as well

---

Should you superpose concurrent accesses of a variable?
: Could be a range of values if writing is overlapped, to model a languages behavior.

---

defining multiple entrypoints of a function with labels. Use func**.LABEL(). Also define a starting branch which doesn't executed by default but only accessible with a label

  

How to think about Object as a superposed Ray ; Where Object[String] is all those overlapping Rays ; resulting into Strings only.

What about structures which define steps beyond&before the usual property getter/setter (is that just there's equipped structure on the return so .field.next if .field yields a ray

That's in the language's implementation of itself

---

VCS; apply change to every version where this might apply, and respect the changes of those specific versions?

---

Movement but the graph needs to go around some body to be put behind them? Instead if through

profram terminating needs also sone check that every step takes finite time; it needs temporal awareness 

difference in color mapped/filter across frequency

double (()) mapped to the utf8 char 

Any set of actions performed on a single thing, into a function, then into an animation of that function

Any object as tabular rendering; have preferences for certain types to render is certain ways per user

Condition on source file like sort all the classes here in alphabetical order like library index

Language Server Protocol support 


#### Interface Design

- Collapse blocks of code down to an english summarization of what the code does.

- Any interface, hooks(/finds) unbound controls

- Functionality
	- (Random) exploration (; worlds/items/..) ; Phrasing "random exploratory funtionality" ; "Periodic reminder/suggestion/exploration"
		- "What are places I haven't looked? What are the places I could want to look? What are the places I decide not to look but would still want too look?"
	- Better replay ; "replay/detective/.../fossile"
	- Like "npc/bot/exploration functionality I'm not doing myself/others"
		- [ ] Notify me when you've found something you deem relevant for this unknown (while we dont know how to solve some unknown)
		- [ ] This would allow for the hooking of the process by a programmer: Hey while you're still working on this thing, perhaps [some answer to some function] should be considered, what would happen then? (Basically simulating an answer by a programmer ; some arbitrary process which hooks into a function)  
		- [ ] Already start doing something while decision is pending - do the things which one can reverse?  
	- You want to do things like "include this thing like a video", if one has access to that - for instance if it needs to be paid for conditionally, in this place in the rest of the structure. That way you can conditionally include things and get around ownership issues, since it'll only be displayed to ones that do have access. -> For certain things a feature like this would be obnoxious though, so what's a good usage for a thing like this.


---

What type of information is stored on player? Things like: Preferences, interested in these fields, these types of knowledge trees already unlocked (can autogenerate these to some extent?).

- Server discovery with possibilities of some community driven setup. So discovering ways of discovering other servers.
	- auto-join local server if last logout was there. per device, allow to (goto position of this device)
	- non-local servers you'd join via the menu, with a last visited on this instance? or in general.

---

A stack is an arbitrary graph of some type, so say a stack of keys/credentials

Whether a graph allows programmatic cursors to traverse it to find items like files in it. ; Or it requires a player to move there or be close to it. 
Then you have things like "items in this room" or "items in this room I can traverse now"

Infrastructure is there for things like navigating and storing items in any structure.

---  

- Idea for chyp-like functionaltiy: Put the graphs setc at the top, invis lines, then draw them on hover, and maybe make surrounding stuff less visiable. ; context of how to apply somethig. ; minimap as ignorant ref

- Import arbitrary structure (drag/copy/paste)
- Control
	- ignoring attachment of where came from, from which would follow the others as the same ignoring again the compariosn, collapsing the tei structures into each other ; ignoring the embedding. - Basically driving them to some "0 point"
	- Bind structures to controls ; copy/paste, this key does this
	- Single key to show something for everything, ignored structure, could just me a simple program applied to the whole interface, show me all the 'orbits' on all the structure.
		- Basically: use loop to create line, rolling the loop oit by introducing variance in the traversing direction  
	- Some intuitive slider of some level of description over an existing interpretation to match it - quite dynamic

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