
Beginner use a whole code setup and only take highlights from it, so users can decode the whole thing.

# Open Problems - Quests

A. The Ray Programming Language
- I. 
	- Should you superpose concurrent accesses of a variable?
	- Is a function's control-graph without an initial boundary: a starting point, a valid function?
	- How do you run a function backwards?
	- How do you call and define inverses of functions?
	- What would be an appropriate geometrical library for describing UI languages?

---

# UNPROCESSED
*Tread carefully, confusion abound*

- DNS TXT reserve of domainnames and claiming users already defined.
- Timed/instance permissions (allow this time) or when some condition is true (like app started).
- collapse tests inline iun ide
- Devices as permission levels; Display can see (streamer mode), mouse can edit certain things.

- Ambiguities 
	- (what to do with the platforms which have a @ether name registered?)

- @ether index decentralized (where certain people host their servers if they want to change the visibility to @public)

- Checker whether access permissions dont leave the network as the network doesnt have access if not so defined. (any derivative)
- Abstraction interpretation flag anything that is not Pure, refuse to execute those.

---

keybiunding to see all versions intermingled, go through each version etc.

---


Variants on the same idea:                                                    
  - Linear — must be used exactly once (Linear Haskell, Granule)                
  - Affine — must be used at most once (Rust by default for non-Copy types)     
  - Borrow — temporarily unique within a scope, original ref can't be touched
  until you give it back (Rust's &mut)                                          
  - Quantitative — the type says "0, 1, or many uses" (Idris 2's QTT)

dynamically assert the number of references to a variable basically. Similarly other memory-related things.

---

Apply a change to all stable versions. / inline version control

---

Create virtual filesystems into the ether

---



---


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

---

`ether cli` - Same interface as ether, but as a CLI, render restrictions to text. - just a frontend to the geometry library
sample images with textual equivs

preferred rewrites as (optional)

when not a None the ? after is just the boolean version does this property hold. instead of the is_X? everywhere

types which match, findinble through references, like Program with cycles, findable. or assert that theyre shouldnt be any. or recurison not allowed etc...

x: Type
(x = a: b) // x needs to be set in this cotnext? nbot where it is inlined.

assume computer > whelmed if ∀Language behavior(.) > board
assume sets boolean if not speicified
assume @me.device > whelmed if ∀Language behavior(.) > board

@me/@player

// top of file
dynamiacally {
   assume computer > whelmed if x
}

steramer mode is the screen renderer doesnt have view access to the @player information (so the name cant be displayed)

cli shell replacement for terminals running as the language mapping to usual cli behavior

decentralized index of all other applications and their functionality (how to safely seaparte user data vs public data) - Project Archive

while loop should work as filling lazy partial.

if instead of match if == , 0 => etc..

automatically compiling a program to be equived to a bunch of API calls wthen let opeople switch to the API call version of remote code execution version.

allow people to claim reservedf names through dns text records.

program in memory idea, repeated parts for hot paths that go wide? can that work?

abstractions like pi =/ javasxcript Math.PI need to come with types of approximations so the compiler nknows the information loss and can tell the user.

move OS specifci stuff to the package stuff that needs them.

route exsting OS through a fitlered FS

if # is used it's on the whole thing instead of per.



asserts green, if fails red, need to separate syntax etc. other errors from actually failing the condition

https://github.com/jj-vcs/jj

how to say if not fulfilled default to 1 or max(1, etc)

\n\n needs to work.

recur should be within a closure recurring the closure

[] == false

is a number shift a decimal shift/

!~= as ~= should be general pattern on operator which returns a boolean.

TODO Unit.ray, Unicode.ray, Time.ray, String.ray

---

upper_case? -> boolean automatically checks?

---

secure from UUID v4 goes away, not necessary according to the standard right? 'secure UUID.v4()' remains possible.

The generate\ in UUID should be within the constructor of UUID as defaults.

is compounds really necessary, shouldnt that already by default work or not? 1 + 2 + 3, already compounds by default?

Move roman to a separate roman/ project.


I dont think there's anything left in entrypoint.ray which isnt also in entrypoint.ray2 right? If so move .entrypoint.ray2 to .entrypoint.ray
.


remove same_characters.


asserts need their values decorated on hover or something or setting it inline.

create a general measure of what something costs relative to what is executing it. static analyhzable

UNICODE CHARACTER NEXT = STGRING

doublecheck if all dependencies for each project are necessary.


Name registration
- Names are not to be claimed for reselling purposes. (How to enforce?). Superposition; Enumeration of names not permitted - pattern to @ether, hint there..
- Standards may reserve ranges to redistribute/Company exists before X date.
- After X free reign on who grabs the name first.

inline versions/vc

superposition nseeds to cgo all if/else branches if first one matches and there's still left. (with &)

statically; compile-time

Access nbo method thing, just location. location needs to be set.

Multiple users with the same name, disambiguated by some other field like geolocation in the case of 911 for instance.


Location is Program

genrel ! for booolean funcs

`Choice := Program{.name == "choose"}`
`Choice() needs to work`

minimize X
maximize X (in a file for readability vs etc..)

Explciit `= None` in `a: Test?` shoudlnt be necessary