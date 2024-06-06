
[[2024-06-06]]


---

[[2024-03-30]]
The Glass Bead Game but the solution to The Glass Bead Game is The Glass Bead Game. 🤔

[[2024-03-30]] 
A Universal Language coming to pixels near you sometime soon™™ in 2024!

---

[[2024-03-25]]
Depending on a few factors (mainly funding for now) the @OrbitMines project will probably start accelerating in scope this year.

Live changes of roadmap-related things can now also be found in the  https://github.com/orbitmines/archive/tree/main/projects repository. (Basically for high-frequency changes) I'll put a general "roadmap" of projects in there in the coming weeks.

I'll still use the ⁠https://discord.orbitmines.com for lower-frequency updates on the projects. Social media & and the beginnings of streams for more general information. 

I think I now finally understand the problem space properly and am turning my eye to implementation only from now on.

---

[[2024-03-20]]
Continuing implementation work on Rays tomorrow: let's see how far I can get before heading to #SYCO12 (Birmingham, UK 15-16 April): https://www.cl.cam.ac.uk/events/syco/12/ (Local organizers: @Tnttodda & @thegeorgejkaye)

Doing work in a separate repository: https://github.com/orbitmines/ray

Notice me @NGI4eu @NLnetFDN, exploratory research is the future~

---

[[2024-02-20]]-[[2024-02-22]] [[Project - OrbitMines as a Game (2025-2026?)]] 

## OrbitMines as ** Project
https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project

  I'm finding myself having to write something along these lines more often recently, so I'm not even sure what a thing like this should be called. Perhaps this is a comprehensive guide on how to be frustrated with pixels. Containing a bit of personal history, a bit of future projections and too many vague ideas which need a practical handle - Ah, that'll be the future projection part.  
  
<Arc head="Introduction">  
  <BR/><BR/>  
  
  Perhaps this should make communicating these things easier by just being able to share a link. An online copy of this can be found <Reference is="reference" simple inline index={referenceCounter()} reference={{title: 'here', link: 'https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project'}} />.  
  
  <BR/><BR/>  
  
  As a follow up of a recent <Reference is="reference" simple inline index={referenceCounter()} reference={{title: 'post', link: 'https://www.linkedin.com/posts/fadishawki_lookingforwork-looking-funding-activity-7162063253718691840-sf38'}} />, this is a letter I've sent to a plentiful of people, which outlines the category of project OrbitMines will be. Please feel to share this with anyone who could help me make these things happen. As with anything with me, this thing is so flexibly general that it should survive any sudden shift in direction I occasionally tend to make.  
  
  <BR/><BR/>  
  
  <Section sub="">  
    <span style={{textAlign: 'left', minWidth: '100%'}}>Probably more accurately, this is <b>OrbitMines as a <span className="bp5-text-muted">(Programming) Language, Version Control, Compiler, Browser, Integrated Development Environment (IDE), Operating System, ..., Game</span> Project</b>. Though "OrbitMines as a Game Project" is probably more provocative and more accurately represents the most important part of this project: its (visual) interface.</span>  
  
    <BR/><BR/>  
    The very example that all those things are so isolated from each-other as concepts itself is shows the entirety of this complex problem. But for a lot of good practical reasons, it is quite understandable that such a thing happens. Simplifying, - compression -, is hard.  
  
    <BR/><BR/>  
  
    <span style={{textAlign: 'left', minWidth: '100%'}}>  
      A broader interpretation of this approach is probably more along the lines of instead of attacking any single problem directly, or to solve any definite problem. To instead assume we can't actually generally do that, and to find tools as generally as possible that can be applied as conveniently as possible. I don't care how its details work, what can you <b>do with it</b>? But not only that, it needs to be satisfying to learn, to explore. The only example I know of which has achieved this for a general audience are video games. Specifically for this category of problem, sandbox video games.  
    </span>  
  
    <BR/><BR/>  
    Ok, enough abstract vagueness without content, onward! ... to less abstract vagueness:  
  
    <BR/><BR/>  
  
    This problem, though filled with incredible technical complexity, in its essence is a visual design problem: What should it feel like? What should it look like?  
  
    <BR/><BR/>  
  
    That makes our lives in a certain respect much easier. Because it's definitely not remotely like anything I've seen before.  
  </Section>  
</Arc>

### Design

There's something entirely problematic about certain types of convenient solutions. Take for instance the interface that is the cursor of a computer people are familiar. And the type of visual interface that i . But there's something quite unsatisfying about keyboard too, it might be better for scale in many cases: But the functionality attached to certain patterns of keyboard-interactions are hidden to the unknowing user. It is seriously hard to find out or spend the time to understand what is even possible in any interface with the keyboard. A more general pattern which is not just applicable to this: once something seemingly convenient is found, it is seriously hard to explore and steer away from that.

#### First feel
In broad terms this is how the game should initially feel: It looks like you're playing something like Minecraft, but then at some point comes the realization that it can be used to do/create *anything*.
You shouldn't even notice you're doing things which could be interpreted as science/engineering. - The moment that you realize you can, you can tap into that.



### Open World Generation
Anything that's *generated, ..., created* which is *accessible, not forgotten and understandable* can be visited as a location. This for example includes whatever intro-screen the game has.

Big challenge is probably ignoring an existing generated world, and instantiating new generation on that same location. Either superposed, ..., portal ... - 

Stability of Space
Non-stability of arbitrary complicated information

---

# [[2024-02-02]] A quick introduction to OrbitMines
https://twitter.com/_FadiShawki/status/1753543155092234463

Arguably, *the* goal of OrbitMines, is to bridge the gap between Languages, Interfaces and Video Games. Perhaps you might find this a bit odd at first: You should start by abandoning the notion anyone has about IDEs, games, programming ... and operating systems. For they are merely an incredibly useful, but restrictive case. And if these ideas can be executed properly, they will **all** blend together.

Though that might sound interesting, how do you *actually* make that happen? A question which has been digging at me for a long time.

This starts with a few complicated but simple ideas:
- Whatever it is (programming) languages are currently doing, they will never get there: This will **never** be possible in *just* the textual interface any programmer is familiar with.
- For some reason, it's incredibly hard to apply the mode of thinking which allows for the creation in, ... of a programming language, to the interface in which one programs.
- It is incredibly hard to throw away all historical context and actually start from something **new**, while still having a practical handle on anything others have done before. Try doing that, while everyone is doing that.
- Whatever this interface will look like, it necessitates conveniently being able to change **anything** about how it looks, ..., how it operates *from the interface itself*. This introduces a hard problem on the side of the implementer: How do you possibly account for that? Or perhaps: Why is that a problem in the first case?
- Whatever function it is that platforms and interfaces serve, they will probably converge to being more of a theme applied on a particular type of structure. Only as a supply of resources (access to certain kinds of information/compute) will they persist. They will not persist as separable interfaces.
- You need to be able to deal in *questions* of different levels of abstraction, description, ..., scales, when each layer introduces arbitrary complexity. This is not simple scale invariance.
- Any scale, ..., any language will in some respect introduce this arbitrary complexity. The only way to properly deal with that is the possibility of exploration. You cannot have this without an open world generation aspect.
- Any translation between any layer necessarily contains something which *cannot* be translated.
- You will have to deal with being able to move in certain data structures for which there might not (yet) be a nice translation to something you can understand.
- Whatever sets up this open world generation must rely on existing structure, information. You can set up something more random, sure. But the only possibility of some feedback on this generation must be some generalization of existing knowledge. Whatever (entropically relevant) information, structure, ..., items have been found.
- This means open world generation must support arbitrary information which will **not** be available in the design of this game/interface.

These are some high-level questions, I'll return to these in more detail at some point.
