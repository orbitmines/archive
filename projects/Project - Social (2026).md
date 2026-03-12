
###### 2026-03-12
I've created a new repository which will contain all research ideas which are still in a developing stage: https://github.com/orbitmines/lab

Specifically for now, as I said in 2023, I was hoping to by 2026 have a sample gamified problem. So I'm probably going to for the next few months, place a focus on that. The obvious candidate is an optimization problem: The problem is well-defined (not an open problem like much of coding), there's a definite equivalence to what kind of program we're looking for. Now the tricky part is figuring out how to map searching the space of possible programs to the lower-dimensional space that is a game UI. So that's going to be the main challenge, let's see if I can think of some good ideas.

Essentially what I'm looking for is a way to guide the computers exploration of possible programs in such a way that there's two-way feedback between the UI and the currently explored algorithms by the computer; How do you effect world generation based on that feedback loop basically - where navigating through that world; or using certain items, is equivalent to adjusting the search algorithm.

My thinking is that compression is the simplest optimization problem which makes sense here to tackle: There's a definite benchmark for progress we can use in feedback, other things like optimizing a particular algorithm (like sorting) would require benchmarking execution speed only, this way we have an additional dimension for feedback: compression size. There's no ambiguity in the optimization result as we would have if you'd pick a problem like training an AI. Reversibility also makes for a nice property: searching is constrained.

We'll see, for now, I'll document progress in that repo! (Since OrbitMines infrastructure is still a WIP, I'll probably use something like Godot for the prototyping)
