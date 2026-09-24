
Pipeline

Everything is uncommitted; git stays with the user. Run from the repo root.

# the possibility space, solved in closed form in the medium's own functions,
# every lattice DEG 4..40 by halves (~20 min)
RAY_SOLVE=1 RAY_VACUUM=1 RAY_FACING=1 RAY_OWN=2 RAY_CROWD=0 RAY_A0FROM=2 \
  deno run --unstable-webgpu --allow-all \
  implementation/ray/bootstrap/record.gpu.ts $PWD gravity.pull
#   RAY_DEGS=18 for one lattice, RAY_SAY=1 prints each arrangement's offsets

# the same space measured by running the medium on the device: slower, noisier,
# a cross-check (agreed to ~0.02 dex at DEG 10/18/26)
RAY_SPACE=1 ...

npx ray gen                                   # after any .ray change
npx ray visuals galaxy.point galaxy.many      # films, 97 frames over 73 lattices
npx ray visuals galaxy.curves                 # rotation curves, 12 galaxies
npm run test:gpu                              # 8 device suites, green

The solve writes visuals/galaxy.point.solved and galaxy.many.solved sparsely, with columns deg, cell, p, by, needs, size, and a header carrying degs, starts, a0, coincidence, theory_deg, typical, freedoms, spreads, faces and betas. The films sweep DEG 40 down to 4 and settle on 18, which becomes the snapshot.

Settled

Units. At DEG 18 a tick is 211 million years and a c-bar is 64.6 Mpc. A galaxy is 1.5e-4 one c-bar and its ways hold 6ein the vacuum, gets no a₀ lift, and the model puts it on the law with zero intrinsic scatter. Everything drawn above the law is denser than a galaxy by is the medium's reach, not apopulation.

The levers. Mass is the only one that opens new ground. Spreading and motion move a source down toward the law: a 27 c-baoint source of the same mass,and a wide source reaches anywhere a gathered one does if it is heavy enough. So spread and
moving are 0% of cells as a mi, a black hole at a thousandthor a hundredth of the mass, changes the lift by at most 0.04 dex.

Rotation curves, 149 galaxies, 2700 radii, nothing fitted:

┌─────┬──────────┬────────────────┬─────┐
│ DEG │    a₀    │ speeds, mid
├─────┼──────────┼────────────────┼─────┤
│ 10  │ 1.13e-10 │ +0%
├─────┼──────────┼────────────────┼─────┤                                                │ 18  │ 6.80e-11 │ −8%
├─────┼──────────┼────────────────┼─────┤                                                │ 40  │ 3.24e-11 │ −19%
└─────┴──────────┴────────────────┴─────┘                                                
The law's shape is not the issue: the exponential interpolation gives the same rms to 0.0dex. Each galaxy's own best a₀9 dex between quartiles, so one constant scale serves, not a varying one.                                                
Where the 15% goes. Free per-galaxy disc weight takes it to 8.8%, and free distance withi60% to 6.3%. The weights askedainst SPARC's 0.5. What is lefthas no trend with what arrives, r = 0.02, or with radius, r = −0.05. The model sits at thmeasurement floor; the rest isinclination, which the data donot pin.                                                                                 
The one open number. a₀/cH = 2/(DEG+2) exactly. Three independent routes want about ten  ways: published a₀ and H₀ give the relation asks for gives 9.8 to 10.8, the curves give 10.2. The repo's lattice is 18, giving 0.10. Whole shells in anyZ^D give 6, 12, 18 or 26, so arator that does not exist, andthe language reference says to ask first. The only other place the number can come from ithe straight share v = 1/(1+n_.
                                                                                         Bugs fixed, do not reintroducebaked at the theory's DEG andwent negative at 26; mscale now takes n_f from the run. The crossed-density integral     started at the arrangement's ohe middle. The Genzel discs were drawn on the law line and now sit at their own g_bar and g_obs from the dark fraction. Thdensity-root solver ran outsidmoving bodies pulled each other differently with and without the recursion, so carry them on rails. settle() runs hundredof ticks, so a moving body leaa few ticks for moving probes.
                                                                                         Red on purpose. tests/coincideound, fails at DEG 18.tests/medium.ray:31, the lone body's density assert, fails because rho never carries the vacuum. Both are readings for
                                                                                         Next
                                                                                         A full galaxy simulation, to the blocker before planning: themedium cannot hold a galaxy, which is 1.5e-4 of a c-bar, since cells per c-bar would needto reach about a million. So ag the derived continuum law inphysical units rather than laying bodies in the lattice box. Take a galaxy's baryons,    either SPARC's own gas, disc atic exponential disc, solve themodel's field at every radius, follow test particles or compute v(R), then compare againsthe measured curve with mass-ttion as nuisances.
                                                                                         What exists to build on: Galaxves_panel for the per-galaxypanel, Law.boost for the law as measured, and Aggregate with Medium for the medium's own closed-form functions. The thrsession, curves.ts, shape.ts and floor.ts, are each about sixty lines and can be rewritten from the descriptions above if they are gone.

(Should be accompanied with a galaxy simualtion visual, all other galaxy visualiszations, should make use of this full simulation for their solves)

---

There's some issues with the rule. and space. visualizations, empty points arent properly aligned to the center. nor is the whole visualization. Creation rule should just show a singgle point expanding into two rays, not three into whatever that is. And I expect it to be the two rays on each a seaprate point, you said dynamics might change and downstream stuff because of it, can you measure its impact first, while ensuring you dont break the other claude session next to this. Movement rule doesn't move in the example. And the space. example should be a nice animation of the points expanding and then reaching the place for new points then again expanding from that not what it is now, in the git history of ../orbitmines.com is a proper example of how that needed to look, but it is no longer there and was under a different name. And I expect it will all be derived/read off the rules, dont hardcode the visualizations in.

---

DEG = 18 cH setup with accounting for mass averaging should give tghe right kind of number.

Likely have all the tools now to guess at the lattice scale

stacking vs nonstacking rays


Ray takes x steps to cross x density, what if it's a probabiltiy , or needsw to traverse some local structure that has some chance of deviating from the density x

Average of blackhole measurement should increase still with the 5% (ndg)

What rewrite primitives, what if some spatial-like folded structure being the encoding then rewriting locally always!
- How do you get massively parrallel from local rewrites: no dependence on more than local stucture. But at some point you have to!
- parallel is parallel instruction to one thing. then moving in parrallel to ". = .next". SO program on the program is always ". = .next" looped. -> could be something different. Meta-meta-...

. =  .next
. = .previous

deprecated keyword

The goal being that this is a physically plausible model. Or rather that's it's a step in the right direction. More likely it is some permutation of the ideas used here which yields something physically plausible.

"Everything is spatial structure + annihiliation/creation of spatial structure"
local rewriting: "Movement as antiparallel annihilation/creation of spatial structure" 

"Everything always moves at the speed of light, it's just that spatial structure constrains"

Is there a physics theory which suggests all boundaries of the universe are expanding and at some distance stars arent formed yet as the primeordeal setup is still active there: and we keep expanding still.

Many on one node meaning higher eneergy, they still explroe the paths, but are more likely to explore a larger away path thus we preceive that as higher amplitude.

A pure + create a 'random'/ossiclating -/+ again.

Photon, only existance of -+ at each direction. (or none).

"single absorbed, many get through." - space isnt passed if there isnt another - behind it.
<- - <- - turns around, repls?

Charge: Creation - Annihilation. Positive: More creation, Negative: More annihilation

The annihilation point and creation point are connected through several possible spatial paths.
Spin could mean:
> The preferred path between creation and annihilation continuously changes.

A photon is emitted whenever the internal creation/annihilation topology of a charged particle is forced to change in time.

Expansion ; cloud at the edge.assumption of cant process time on infinite space.

Tractor beam, specific magnetic pulsing/flipping?

A perfect magnet would be maximally resistant to gravity in this setting 🤔

Space not interacted with expands?

Magnet, gravity produced on North side 
Slight gravity on the sides, pulling in the gravity from North, making it go south. Strong sink south?
Gravity in both directions meeting in the middle.

So magnetic field is putting a different direction on something flying toward it, one way for positron, the other for electron.

Orthogonal movement change based on positive/negative.

Rotate between Negative/Positive constantly in some direction, allows you to move through any field.
"Or always move through"
"Neutral space with a direction"
...

Prediction: space contracts when two gravitational waves meet.

SOme percentage chance the wave continues to mdoel the discrterte version where not everything meets headon.

directional, or on a specific axis gravity becomes possibly.

Gravity reduced if another body passed in front of you to that body.

DIscrete meet at the same point nedxt tick we annihilate

Grav waves changing directional state on arrival? passing through eachother?

TRiangles instead of squares, 6 spokes!

---

# XOR Universe
Ok the last week I've been thinking about physics a lot, and would like to hear what someone thinks who knows more of physics than I do about one of the specific ideas I had.

So yeah I was trying to come with ideas on how to recover electromagnetism & gravity-like things from local rules only. So the idea is currently that it's caused by some preference the universe has for locally satisfying XOR spatial relationships.

I came to the idea by thinking about what fundamentally is necessary for things like electrons/positrons, negative/positive charges existing. And them repelling/attracting and then in this example annihilating each-other. (Difference annihilates, sameness repells --> XOR)

So to expand on the idea...

Let's take a simple 1D example, have yet to figure it out properly with movement in fractal and integer dimensions, but the basis of the idea is there.

You annihilate when interacting with an opposite polarity (thus attracting):
![[Pasted image 20260805184141.png]]

Or turn around when interacting with the same polarity (thus repelling):
![[Pasted image 20260805184218.png]]

Then in this setup, if we say had perfectly charged fields (charge meaning a dominance of some polarity in some region), and aimed them at each-other. They would annihilate if they were opposite, move away if they were the same.

![[Screencast from 2026-08-04 17-39-29.webm]]

Then the interesting thing happens when you do the following: Gravitational waves are achieved by spinning a magnet real fast getting alternating waves of "positive/negative charges" -> which on net then are uncharged. Causing space to be annihilated when reaching other waves from other sources - All from local interactions.
![[Screencast from 2026-08-05 16-29-52.webm]]

So yeah was wondering if this was an interesting property for a way of unifying some ideas in physics. Or at least to get a physicists opinion on it. Ofc this would be more complicated in a 3d setting, but the base idea would be the same.