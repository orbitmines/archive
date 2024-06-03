# Project - Indexing existing Abstract Models (2024-2025?)
*Once a proper interface for Rays is setup, one of the things I'd like to do with it, is to point it to a lot of existing abstract models of computation/mathematics/calculi/theorem-provers/compilers/proof assistants/automated program synthesizers/.../programming languages. And create a way of analyzing/comparing them which **does not** include manual human labor of specifying their grammars.*

- Rays are probably a [Characteristica_universalis](https://en.wikipedia.org/wiki/Characteristica_universalis) (Or rather a Universal Language, or as [[Jonathan Gorard]] phrased a similar concept; a "general theory of graphs" (See [[Category Theory]] notes when at [[Society for Multidisciplinary and Fundamental Research (SEMF)]]))
	- [Wikipedia universalis pageviews (this year)](https://pageviews.wmcloud.org/?project=en.wikipedia.org&platform=all-access&agent=user&redirects=0&range=this-year&pages=Characteristica_universalis|Lingua_generalis) ; 👀 Let's see the change

- [[Society for Multidisciplinary and Fundamental Research (SEMF)]] discord equivalent: https://discord.com/channels/844566471501414463/1225907185079287971

---
Comments on [[2024-04-05]]

>This thing is probably way too big a project, but thinking about it will probably get much easier in the coming years. I'm preemptively putting this here mainly because I want to find out if there are currently (or have been) people attempting something like this.
>
> The only stuff I've been able to find so far is either incredibly limited in scope or is doing too much of this by hand. Would love to find out that there's someone who has been working on this already though :upside_down:
> 
> Seamless direct (partial) inter-compilation/.../translation of things will probably become much more tractable at some point in the near future ^ Though all the more insane complexity of software/firmware/hardware to me seem to pose the most challenges.

Comments on [[2024-02-22]]
> "Also, interesting to note might be that Von Neumann and Birkhoff attempted to ground quantum mechanics using order theory (their attempt was not very successful at that)."
> 
> Me: "I think my intuition is trying to say something like. I want it ordered to talk about it usefully. But high-arity cases are probably more in line with ignoring/invariances of that order."

*Where invariance in this case is something like a branching ray as a cursor along a ray indicating an invariance: i.e. copies over every entry.*

---
#### Some interesting/pending questions regarding this project:
*[[ONGOING Project Logistics]]*

- [ ] **People:** Are there people who have compiled something like this yet?
	- [ ] Setup collaboration for others to add to this
	- [ ] Are there people who have been thinking about game-invariant puzzles?
	- [ ] There are probably many people who are thinking about something like this in the context of biology, and probably other fields too. Find out who?
	- [ ] This could involve people who are interested in studying researchers/projects. Find out who?
	- [ ] **Legal:** *Compile a list of people who need to be contacted for this: Just exclude the ones without open licenses. ; or if the project is big enough might as well contact all of them to lift the licenses*
- [ ] **Logistics:** This entire thing should be compiled into a writing/study of existing stuff
- [ ] **Differentiation:** Measurement of category if diversity for the thing its useful for ; this is essentially the closeness idea ([More usefully: How much do I need to change/ignore before they're the same to me?](https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=More%20usefully%3A%20How%20much%20do%20I%20need%20to%20change/ignore%20before%20they%27re%20the%20same%20to%20me%3F)) 
	- Basically, how much shifting/.../ignoring do I have to do before particular kind of symmetries/equivalences are reached so there's an/.../better interface into it.
	- Becomes "contextual/.../computational closeness?"
	- Language barriers / Different perspectives
		- Get things like taking items from one particular world back to another world, could suddenly see quests you couldn't see before (immigration / ...).
		- Switching between different abstraction levels
	- [ ] What are mistakes in trying to spin up new projects/languages? 
	- [ ] Compiled grammar vs analysis of runtimes?
		- [ ] What can be (partially) compiled to what using what? (Natively supported vs finding (accidental) symmetries to allow for compilation)
		- [ ] Apply this question again by loosely changing constraints?
	- [ ] What mistake in indexing multiple levels of descriptions ; Non-overlap, points resulting in confusion etc..
	- [ ] Realized invariances/.../redundancies of particular layers.
	- [ ] Part of this becomes how do certain fields/perspectives/projects have a view on other projects (partly [[PENDING (2032+?); Sociology, Economics]]). A simple example is confusion between programming fields in what the meaning of frontend/backend is. - People's fixation on using a particular word very specifically. That sort of thing.
		- complex/complicated is another example
		- another is hardware/software distinction (in the sense of superposed languages, this fails a bit). This distinction isn't really that clear-cut.

---

- [ ] Whole project makes it necessary to get the practical low-level systems in this too.
	- [ ] Lookup existing projects in that space, decompilers, interfaces for binary analysis etc..
	- [ ] BIOS..

---

### This is a current list of the projects I found so far related to this project - and possibly some to apply the beast to:

- [Infrageometry](https://github.com/WolframInstitute/Infrageometry) (& basically translate to usual hypergraphs), Polycomputation ([[Michael Levin]]), [Covariant computation](https://twitter.com/getjonwithit/status/1780722985747263709) ([[Jonathan Gorard]] doesn't like the name)
- [Chyp](https://github.com/akissinger/chyp), [Coq](https://github.com/coq/coq), [Agda](https://github.com/agda/agda), [LLVM](https://github.com/llvm), [Unicode](https://github.com/unicode-org), [nLab](https://ncatlab.org/nlab/show/HomePage), [Category Theory](https://en.wikipedia.org/wiki/Category_theory), [WebAssembly](https://webassembly.org/), [WebAssembly System Interface](https://github.com/WebAssembly/WASI), [Wasm SpecTec](https://github.com/WebAssembly/spec), [wasm3](https://github.com/wasm3/wasm3), wasm4, [OCaml](https://github.com/ocaml/ocaml), [Backus-Naur Form (BNF)](https://en.wikipedia.org/wiki/Backus%E2%80%93Naur_form), [UniMath](https://github.com/UniMath), [Lean](https://github.com/leanprover), [Type Theory](https://en.wikipedia.org/wiki/Type_theory), [Set Theory](https://en.wikipedia.org/wiki/Set_theory), [Metamath](https://github.com/metamath), [Mizar System](https://en.wikipedia.org/wiki/Mizar_system), [NuPRL](https://en.wikipedia.org/wiki/Nuprl), [HOL](https://en.wikipedia.org/wiki/HOL_(proof_assistant)), [Homotopy Type Theory](http://homotopytypetheory.org), [Dependent Type Theory](https://en.wikipedia.org/wiki/Dependent_type), [Hopf algebdra](https://en.wikipedia.org/wiki/Hopf_algebra), [Prover9](https://en.wikipedia.org/wiki/Prover9), [Otter](https://en.wikipedia.org/wiki/Otter_(theorem_prover)), [Z3](https://github.com/Z3Prover), [CUDA](https://developer.nvidia.com/cuda-toolkit), [x86](https://en.wikipedia.org/wiki/X86), [HVM, HOL, Kind](https://github.com/HigherOrderCO/), [Haskell](https://github.com/haskell), [WebGPU](https://www.w3.org/TR/webgpu/), [Treesitter](https://github.com/tree-sitter), [MathJax](https://www.mathjax.org/), [Gen.jl](https://github.com/probcomp/Gen.jl), [Julia](https://julialang.org/), [Idris](https://www.idris-lang.org/), [Quantomatic](https://github.com/Quantomatic), [Interaction nets](https://en.wikipedia.org/wiki/Interaction_nets), [Petri net](https://en.wikipedia.org/wiki/Petri_net), [Lie algebra](https://en.wikipedia.org/wiki/Lie_algebra), [Rzk](https://github.com/rzk-lang), [cubicaltt](https://github.com/mortberg/cubicaltt), [SageMath](https://www.sagemath.org/), [Xena Project](https://github.com/kbuzzard/xena), [Formal Abstract (FAbstracts)](https://github.com/formalabstracts), [Dedukti](https://github.com/Deducteam), [TPTP](https://github.com/TPTPWorld), [Isabelle](https://github.com/isabelle-prover), [Nekoka](https://github.com/nekoka-project), [E (Theorem Prover)](https://github.com/eprover), [SPASS](https://en.wikipedia.org/wiki/SPASS), [CVC](https://github.com/cvc5), [Wolfram Language](https://en.wikipedia.org/wiki/Wolfram_Language), [MiniSat](http://www.minisat.se/), [PicoSAT](http://fmv.jku.at/picosat) , [microsat](https://github.com/glnc/microsat), [SPUR](https://github.com/ZaydH/spur), [miniC2D](http://reasoning.cs.ucla.edu/minic2d), [clasp](https://potassco.org/clasp), [sat-research](https://github.com/Mateusz-Grzelinski/sat-research), [Project Everest](https://project-everest.github.io/), [pyfolderol](https://github.com/akissinger/pyfolderol), [Research in Software Engineering (RiSE)](https://www.microsoft.com/en-us/research/group/research-software-engineering-rise/), [LFSC Checker](https://github.com/cvc5/LFSC), [nunchaku](https://github.com/nunchaku-inria/nunchaku/), [CaDiCaL](https://github.com/arminbiere/cadical), [Boolector](https://boolector.github.io/), [ddSMT](https://github.com/ddsmt/ddSMT), [Bitwuzla](https://bitwuzla.github.io/), [Quantumcodes.io](https://gui.quantumcodes.io/3d), [pl-catalog](https://github.com/prathyvsh/pl-catalog), [Group Explorer](https://github.com/nathancarter/group-explorer), [lambda-calculus-visualizations](https://github.com/prathyvsh/lambda-calculus-visualizations), [Cohomology](https://en.wikipedia.org/wiki/Cohomology), [yatima](https://github.com/lurk-lab/yatima), [Paper-Proof](https://github.com/Paper-Proof/paperproof), [Categorica](https://github.com/JonathanGorard/Categorica), [lambdaexplorer](https://lambdaexplorer.com/)
- [switchboard](https://github.com/zeroasiccorp/switchboard/), [Why3](https://www.why3.org/), [PyZX](https://github.com/Quantomatic/pyzx), [homotopy.io](https://homotopy.io/), [The Incredible Proof Machine](https://incredible.pm/), [formal-proofs](https://github.com/starkware-libs/formal-proofs), [Formal Verification](https://github.com/formalverification), [Leo](https://github.com/leoprover), [ProofNet Isabelle](https://github.com/Wenda302/ProofNet_Isabelle), [Unilab](https://github.com/AnthonyBordg/UniLab), [MetiTarski](https://www.cl.cam.ac.uk/~lp15/papers/Arith/), [eo](https://github.com/objectionary/eo), [Clojure](https://clojure.org/), [Glencoe](https://github.com/glnc), [aeneas](https://github.com/AeneasVerif/aeneas), [GAPT](https://github.com/gapt), [coch-demo](https://github.com/marijnheule/coch-demo), [NQTHM](https://en.wikipedia.org/wiki/Nqthm), [ACL2](https://en.wikipedia.org/wiki/ACL2), [LEGO](https://en.wikipedia.org/wiki/LEGO_(proof_assistant)), [ALF](https://en.wikipedia.org/wiki/ALF_(proof_assistant)),  [Twelf](https://en.wikipedia.org/wiki/Twelf),  [Epigram](https://en.wikipedia.org/wiki/Epigram_(programming_language), [Saturn](https://github.com/siddhartha-gadgil/Saturn), [ProvingGround](https://github.com/siddhartha-gadgil/ProvingGround), [Elm](https://github.com/elm), [Lua](https://www.lua.org/), [Qt](https://www.qt.io/), [Bazel](https://bazel.build/), [Docker](https://www.docker.com/), [pp](https://github.com/RobArthan/pp), [GrapeVine](https://github.com/jenshweber/grape), [HOL Light](https://github.com/jrh13/hol-light), [itex2MML](https://github.com/ncatlab/itex2MML), [reStructuredText](https://en.wikipedia.org/wiki/ReStructuredText), [Cyc](https://github.com/asanchez75/opencyc), [Combinators](https://en.wikipedia.org/wiki/Combinatorics), [IPFS](https://ipfs.tech/), [IPLD](https://ipld.io/), [Pandoc](https://pandoc.org/), [LaTeX](https://www.latex-project.org/), [dolmen](https://github.com/Gbury/dolmen), [Andromeda](https://github.com/Andromedans/andromeda), [QED](https://github.com/teorth/QED), 
- [Spectral graph theory](https://en.wikipedia.org/wiki/Spectral_graph_theory), [Python: wolfram_model](https://github.com/phcerdan/wolfram_model), [SetReplace](https://github.com/maxitg/SetReplace), [hypercore-decomposition](https://github.com/marco-mancastroppa/hypercore-decomposition), [higher-order-motifs](https://github.com/FraLotito/higher-order-motifs), [XGI](https://github.com/xgi-org), [hypergraphx](https://github.com/HGX-Team/hypergraphx), [Probabilistic programming](https://en.wikipedia.org/wiki/Probabilistic_programming), [BoomFilters](https://github.com/tylertreat/BoomFilters), [MJr](https://github.com/kaya3/MJr), [Agents.jl](https://github.com/JuliaDynamics/Agents.jl), [particle-life](https://github.com/hunar4321/particle-life), [Lenia](https://github.com/Chakazul/Lenia), [The-Powder-Toy](https://github.com/The-Powder-Toy/The-Powder-Toy), [Procedural generation](https://en.wikipedia.org/wiki/Procedural_generation), ZW, ZH, [Zeta Calculus](https://zeta.nicbot.xyz/), 
- [Tinygrad](https://github.com/tinygrad), ...
- [ ] https://en.wikipedia.org/wiki/Probabilistic_programming
	- [ ] Analytica, bayesloop, Bean Machine, CuPPL, Venture, Probabilistic-C, Anglican, IBAL, BayesDB, PRISM, Infer.NET, dimple, chimple, BLOG, diff-SAT, PSQL, BUGS, FACTORIE, PMTK, Alchemy, Dyna, Figaro, Church, ProbLog, ProBT, Stan, Hakaru, BAli-Phy, ProbCog, Gamble, PWhile, Tuffy, PyMC, Rainier, greta, pomegranate, Lea, WebPPL, Let's Chance, Picture, [Turing.jl](https://github.com/TuringLang/Turing.jl), Low-level First-order PPL, Troll, Edward, TensorFlow Probability, Edward2, Pyro, NumPyro, Saul, RankPL, Birch, PSI, Blang, MultiVerse
- [Erlang](https://en.wikipedia.org/wiki/Erlang_(programming_language), [metalang99](https://github.com/Hirrolot/metalang99), [SL](https://github.com/sl-lang/sll), [Abstract object theory (AOT)](https://en.wikipedia.org/wiki/Abstract_object_theory), [Causal graph](https://en.wikipedia.org/wiki/Causal_graph), [chemlambda](https://chemlambda.github.io/), [Representation theory](https://en.wikipedia.org/wiki/Representation_theory), [Lattice theory](https://en.wikipedia.org/wiki/Lattice_(order)), [Metamathematics](https://www.wolfram-media.com/products/metamathematics-foundations-and-physicalization/), [archon](https://homepage.divms.uiowa.edu/~astump/papers/archon.pdf), [open-hypergraphs](https://github.com/statusfailed/open-hypergraphs), [catgrad](https://github.com/statusfailed/catgrad)
- [Solid](https://github.com/solid/), 
- Chemistry: [Assembly Theory](http://assembly-theory.com/learn/)
- [liquidsoap](https://github.com/savonet/liquidsoap), [The Munich Quantum Toolkit (MQT)](https://github.com/cda-tum/mqt), 
- https://github.com/StructuralXplorationLab/Libra (Parametric Design)
- [Guppy](https://github.com/CQCL/guppylang), 
- [OpenQL](https://github.com/QuTech-Delft/OpenQL), [Narya](https://github.com/mikeshulman/narya), [NuprlinCoq](https://github.com/vrahli/NuprlInCoq), 
- https://en.wikipedia.org/wiki/Spinor
- [Transcendental syntax](https://ncatlab.org/nlab/show/transcendental+syntax) ; reminds me of the need to include everything of [[nLab]] needs to be compiled to this list too, so much stuff there
- https://en.wikipedia.org/wiki/Bondi_k-calculus
- zxlive, [Semagrams.jl](https://github.com/AlgebraicJulia/Semagrams.jl ), 
- CSS, JavaScript, TypeScript, React (& ecosystem of these things ; React Native), HTML, Bun, Node.js, ...
- Character encodings, renderings, groupings, UTF-8, https://typedrawers.com/, tyopgraphy, 
- [Andromeda](https://github.com/Andromedans/andromeda), Apache TVM, Controlled Natural Language (CNL), Formalisation of Constructive Univalent Type Theory (ForCUTT), [Foundations of Mathematics (FOM)](https://ncatlab.org/nlab/show/foundation+of+mathematics), [Virgil](https://github.com/titzer/virgil/), https://github.com/TodePond/DreamBerd, 
- [staq](https://github.com/softwareQinc/staq), 
- https://github.com/kenjihiranabe/The-Art-of-Linear-Algebra
- https://github.com/mirage-project/mirage
- https://github.com/Janiczek/apl-in-hvm
- Carbon lang [[Chandler Carruth]] (https://muxup.com/2024q2/notes-from-the-carbon-panel-session-at-eurollvm)
- Twemex, explainpaper, lu.ma, noti.st, leanpub.com, conf.tube, openreview, ....

### Some other names I found but didn't save a link to: 
- *DisCoPy2, Aletha, Inkresat, F star, smt-comp, starexec, verdict, vau calculus, SF-Calculus, Monoidal Computer, Certora Prover, smt workshop, Imandra, Waldmeister, POG, QuiZX, Globular, proofweb, holyhammer, B, Event-B, TLA+, Atelier B, Rodin, TLAPS, OpenTheory, FoCaLize, Zenon, iProver, CoqinE, veriT, BWare, B-Method, ArchSAT, sel4, HOL4, Flexiformalized math, OMDoc, Schurr 1999, GP/GP2 Plump 2009, GRAPE / Grape PRess - Weber 2017/2021, AGG Taentzer 2004, FUJABA Nickel 2000, GReAT Agrawal 2006, GROOVE Rensik 2004, TPS, PhoX, Markdown, JPEG, JPG, PNG, MINLOG, Jape, ae (alt-ergo), dimacs, iCNF, smtlib, zf (zipperposition), HELM, MathWeb, MathScheme, MathClasses, ForMath Project, Opetopic Type Theory, RedPRL, yaccyt, redtt, PVS, Matita, Guru, Dependent ML, Gallina, Cayenne, Arend*
- Ro, aUI
- Ott/Lem, Prose/Sphinx, Amulet, B-pog, lambdapi, [BabylonJS](https://github.com/BabylonJS),
- Calculus, Calculus of communicating systems, Calculus of Constructions, Coinduction (other statrgies, ... [[nLab]]), [Dawn](https://dawn.googlesource.com/dawn), SInE, LEO-II, Emacs, [Flyspeck project](https://github.com/flyspeck/flyspeck), Fredkin gate, Frobenius algebra, Genaille-Lucas rulers, General-purpose computing on graphics processing units (GPGPU), [Glasgow Haskell Compiler (GHC)](https://www.haskell.org/ghc/), [HypergraphDB](https://github.com/hypergraphdb/hypergraphdb), [IsarMathLib](https://github.com/SKolodynski/IsarMathLib), Intermediate Representation (IR), Interoperable and Confident Set-based Proof Assistants (ICSPA), [JSON-LD](https://github.com/json-ld), Many-sorted logic, [Matryoshka Project](https://github.com/matryoshka-project), Message passing, Modal Type Theory, [OCaml Scientific Computing (OWL)](https://github.com/owlbarn), [Proofcraft](https://proofcraft.systems/), ProofPower, [Qimaera](https://github.com/zamdzhiev/Qimaera), Quaternion, Rust, Simplical Type Theory, Simultaneous Multithreading (SMT), [smt2d](https://github.com/Deducteam/smt2d), Special Commutative Frobenius Algebra (SCFA), Statebox, Superposition calculus, Vampire, Superscalar Processor, [QED](https://github.com/teorth/QED), Topology, K-theory, Univalent Foundations, Reflective Lambda Calculus, Reversible Computation
- YJIT, ..
- Git, ..
- [schema.org](https://github.com/schemaorg),

##### Some Interface design / ... / visualization / game / generation projects
*Game-side need to be extended a bit as well: Perhaps some merging between here and [[Project - Research towards Designs (2024)#Research of Games, Engines, ...]]*

- [Unit](https://github.com/samuelmtimbo/unit), [Tiny Glade](https://store.steampowered.com/app/2198150/Tiny_Glade/), [Processing](https://processing.org/), [WaveFunctionCollapse](https://github.com/mxgmn/WaveFunctionCollapse), [MarkovJunior](https://github.com/mxgmn/MarkovJunior), [open-game-engine](https://github.com/CyberCat-Institute/open-game-engine), [DGtal](https://github.com/DGtal-team/DGtal), [hg_sdf](https://mercury.sexy/hg_sdf/), [Pixar's OpenUSD](https://github.com/PixarAnimationStudios/OpenUSD), [Pixar's OpenSubdiv](https://github.com/PixarAnimationStudios/OpenSubdiv), [three-gpu-pathtracer](https://github.com/richardassar/three-gpu-pathtracer), [TiltBrush](https://www.tiltbrush.com/), [nannou](https://github.com/nannou-org/nannou), [thi-ng/umbrella](https://github.com/thi-ng/umbrella), [toxiclibsjs](https://github.com/hapticdata/toxiclibsjs), [vertexshadeart](https://www.vertexshaderart.com/), [openrndr](https://github.com/openrndr), [vizhub](https://vizhub.com/), [utymap](https://github.com/reinterpretcat/utymap), [NVIDIA Omniverse](https://www.nvidia.com/en-us/omniverse/), [voxel-builder](https://nimadez.github.io/voxel-builder/), [differentiable-graphics](https://tiarkrompf.github.io/notes/?/differentiable-graphics/), [g9](https://github.com/bijection/g9), [Apparatus](https://github.com/cdglabs/apparatus), [sketch-n-sketch](https://github.com/ravichugh/sketch-n-sketch), [observablehq](https://observablehq.com/), [printeff(...)](https://twitter.com/printeff_app), [badspreadsheet](https://github.com/adam-james-v/badspreadsheet), [uwdata/mosaic](https://github.com/uwdata/mosaic), [natto.dev](https://natto.dev/), [Bunkatopics](https://github.com/charlesdedampierre/BunkaTopics), [HoTT Game](https://github.com/thehottgame/theHoTTGame), 
- https://websim.ai/, https://fframes.studio/, 
- Differential Games
- [Fantasy-Map-Generator](https://github.com/Azgaar/Fantasy-Map-Generator), [veloren](https://github.com/veloren/veloren?tab=readme-ov-file), 
- [AtomicData.dev](https://github.com/atomicdata-dev), [Ink & Switch](https://www.inkandswitch.com/), [tikzit](https://github.com/tikzit)
- Blender tools (Geometry Nodes?. etc..), [gephi](https://github.com/gephi/gephi), Pyramid (image processing), 
- [Builder.io](https://github.com/BuilderIO), [pflow.dev](https://github.com/pFlow-dev), [Grasshopper](https://en.wikipedia.org/wiki/Grasshopper_3D)
	- [ ] https://en.wikipedia.org/wiki/Visual_programming_language
- https://github.com/chrxh/alien, [Nomic Atlas](https://github.com/nomic-ai/nomic)
- [quiver](https://github.com/varkor/quiver), [t-SNE](https://distill.pub/2016/misread-tsne/), UMAP "uniform manifold approximation and projection", [distill.pub](https://distill.pub/), [perfect-arrow](https://github.com/ChrisShank/perfect-arrow), [StateML](https://www.stateml.org/), https://azlen.me/gallery/, [Practal](https://github.com/practal), LayerProcGen, https://lazy.so/, [muxViz](https://github.com/manlius/muxViz), [n8n](https://github.com/n8n-io/n8n)
- [ ] Graph/Visualization to SVG (vector representation. From [[MakerJS]], also: DXF, SVG, PDF, JSCAD CAG, STL, ...).
- [ ] https://github.com/kosmos/awesome-generative-art
- [ ] [[Obsidian]], [[notion.site]], other IDEs, [typecell](https://www.typecell.org/), [starboard](https://starboard.gg/), Android Studio, ...
- [ ] [manim](https://github.com/3b1b/manim), [threejs.org](https://threejs.org/), 
- [ ] Like the probabilistic programming languages and world generation techniques ; index existing those generation techniques like Perlin Noise, things like that.
	- [ ] Link to how it's currently done within games ; Minecraft as a simple example.
- [ ] [Mesa 3D](https://gitlab.freedesktop.org/mesa), OpenCL,
- [ ] [Playcanvas](https://github.com/playcanvas/engine), [Stardust](https://github.com/StereoKit), Wireworld, [Wizard Engine](https://github.com/titzer/wizard-engine/), 
- [ ] Tenstorrent SMI terminal
- [ ] "Color-coded parameterspace of a double pendulum reminds of the Mandelbrot set." ; 
- [ ] wavelets
- [ ] https://github.com/enso-org/enso
- [ ] https://antoinebrl.github.io/blog/conv1d/
- [ ] https://cremuss.artstation.com/projects/mDwBP9
- [ ] https://woolgather.sh/ ; https://mmm.page/fadishawki?first_page
- [ ] layers.to
- [ ] https://www.val.town/
- [ ] https://vastgaussian.github.io/
- [ ] https://www.sidefx.com/
- [ ] https://medium.com/@kacper.szwajka842/efficient-gpu-rendering-for-dynamic-instances-in-game-development-9cef0b1eeeb6
- [ ] https://projectneo.adobe.com/ & the whole adobe stack
- [ ] https://github.com/MurpheyLab/ergodic-control-sandbox
- [ ] https://github.com/fargolo/TextGraphs.jl
- [ ] https://gist.github.com/futureengine2/7c8fbc6fefce1818ff1edcd4d7e7bfcf
- [ ] https://github.com/OrionReed/dom3d
- [ ] https://palet.app/
- [ ] 

- [ ] http://elseheartbreak.com/
- [ ] https://tomorrowcorporation.com/humanresourcemachine
- [ ] https://github.com/futureofcoding/futureofcoding.org
- [ ] https://github.com/ivanreese/visual-programming-codex
- [ ] https://github.com/jangafx
- [ ] https://en.m.wikipedia.org/wiki/Symplectic_geometry
- [ ] https://github.com/pererossello/nbody_whatever
- [ ] https://minos.tessera.li/genealogy
	- [ ] https://github.com/tesseralis
- [ ] http://wiki.fun-arch.org/index.php?title=Main_Page
- [ ] https://openprocessing.org/
- [ ] https://huggingface.co/spaces/HuggingFaceFW/blogpost-fineweb-v1
- [ ] https://gamemaker.io/en

##### Version Control, dependency management, concurrency, causal histories
- [Confluence](https://en.wikipedia.org/wiki/Confluence_(abstract_rewriting)), [Convergence](https://en.wikipedia.org/wiki/Convergence_(logic)), [Commutes](https://en.wikipedia.org/wiki/Commutative_property),  [CRDT](https://en.wikipedia.org/wiki/Conflict-free_replicated_data_type) ([CRDTs go brrr (2021)](https://josephg.com/blog/crdts-go-brrr/), [CRDTs: The Hard Parts (2020)](https://www.youtube.com/watch?v=x7drE24geUw)), [Concurrency control](https://en.wikipedia.org/wiki/Concurrency_control), [Riak](https://riak.com/) ([Riak Core - An Erlang Distributed Systems Toolkit (2011)](https://vimeo.com/21772889), [Riak & Dynamo, Five Years Later Presented (2013)](https://www.youtube.com/watch?v=AxG9DROsnqg))
- Some others [RxDB](https://rxdb.info/), [ShareJS](https://github.com/share), [ottypes](https://github.com/ottypes), [Operational transformation](https://en.wikipedia.org/wiki/Operational_transformation), [IPFS](https://ipfs.tech/), [IPLD](https://ipld.io/), [OrbitDB](https://github.com/orbitdb/orbitdb), [Git](https://en.wikipedia.org/wiki/Git), [Merkle Tree](https://en.wikipedia.org/wiki/Merkle_tree), [Vector Clock](https://en.wikipedia.org/wiki/Vector_clock), Plausible Clock, Chain Clock, Interval Tree Clock, Bloom Clock, [Matrix clock](https://en.wikipedia.org/wiki/Matrix_clock), [SpacetimeDB](https://github.com/clockworklabs/SpacetimeDB)

### Some other ways of possibly extending this list (non-completed tangents):

- [ ] Like [[Liubov Tupikina]]'s projects ; Papers, all these journals listed below. Associated with code, bridge these things.

- [ ] All the people I've followed GitHub, Twitter, Zulip, (mutual Discord servers) etc... & some distance away as preference
- [ ] Quick/automatic GitHub/.../Gitlab search.
- [ ] other diff tools / VCS
- [ ] [Cambridge Quantum](https://github.com/CQCL), nForum

- From [[Category Theory]]
	- https://bartoszmilewski.com/2023/09/19/exercise-in-coherence/
	- https://github.com/bgavran/Category_Theory_Machine_Learning
	- https://en.wikipedia.org/wiki/Transfinite_number
	- https://juliapoo.github.io/mathematics/2022/12/15/homomorphism-illustrated.html
	- https://www.localcharts.org/t/learning-resources-for-applied-category-theory/8285
	- https://cybercat.institute/2024/04/12/enriched-closed-lenses/
	- https://github.com/prathyvsh/category-theory-resources
	- https://github.com/statusfailed/catgrad
	- https://github.com/abuseofnotation/category-theory-illustrated
	- https://clowderproject.com/ ; https://github.com/topological-modular-forms/the-clowder-project

- Research into https://en.wikipedia.org/wiki/Data_and_information_visualization , also more non-trivival stuff than just plots
	- https://en.wikipedia.org/wiki/T-distributed_stochastic_neighbor_embedding
	- https://en.wikipedia.org/wiki/Distributive_property
- Mathematics Genealogy Project
- 
	- [ ] https://proofassistants.stackexchange.com/
- 
	- [ ] https://github.com/terkelg/awesome-creative-coding?tab=readme-ov-file
	- [ ] Through GitHub (& search elsewhere) topics: [interaction-design](https://github.com/topics/interaction-design), [procedural-generation](https://github.com/topics/procedural-generation), [probabilistic-programming](https://github.com/topics/probabilistic-programming), [awesome](https://github.com/topics/awesome), [cellular-automata](https://github.com/topics/cellular-automata), [computational-design](https://github.com/topics/computational-design), [awesome-applied-category-theory](https://github.com/jules-hedges/awesome-applied-category-theory), [visualization](https://github.com/topics/visualization), [graph-rewriting](https://github.com/topics/graph-rewriting), [differentiable-rendering](https://github.com/topics/differentiable-rendering), [gamedev](https://github.com/topics/gamedev), [interaction-design](https://github.com/topics/interaction-design), 
	- [ ] https://github.com/Liyubov?tab=repositories
	- [ ] https://zenodo.org/communities/owseu/records?q=&l=list&p=1&s=10&sort=newest
	- [ ] "Creative coding?" - mostly some art stuff, though probably has some practical applications hidding somewhere too
	- [ ] Lot of interesting things here: https://github.com/thi-ng/umbrella?tab=readme-ov-file
	- [ ] https://iquilezles.org/articles/
	- [ ] https://github.com/nplresearch/higher_order_LRG
- 
	- [ ] https://www.cs.ru.nl/~freek/100/
	- [ ] https://www.tptp.org/CASC/ - https://www.tptp.org/CASC/ - https://www.tptp.org/cgi-bin/SystemOnTPTP
	- [ ] https://proofwiki.org/wiki/Main_Page
	- [ ] https://proofassistants.stackexchange.com/
	- [ ] https://personal.cis.strath.ac.uk/robert.atkey/cs208/prover.html
	- [ ] https://europroofnet.github.io/tools/
	- [ ] https://wtgowers.github.io/human-style-atp/
	- [ ] https://coq-tactician.github.io/
	- [ ] https://github.com/jaalonso/Lecturas_GLC
	- [ ] https://en.wikipedia.org/wiki/Satisfiability_modulo_theories
	- [ ] https://github.com/berenoguz/Math
	- [ ] https://github.com/alexkrauss/isabelle-zf-experiments
	- [ ] https://books.google.nl/books?hl=en&lr=lang_en&id=vznnEAAAQBAJ&oi=fnd&pg=PP6&ots=JAO2M-hF-_&sig=mbPYLt3UOr6fCMEKheQQ3-sVeao&redir_esc=y#v=onepage&q&f=false
	- [ ] http://satcompetition.org/
	- [ ] https://www.lix.polytechnique.fr/team/5/view
	- [ ] Games
		- [ ] https://github.com/threerings/narya (accidentally found)
		- [ ] 
- 
	- [ ] https://jesper.sikanda.be/links.html
	    - [ ] & similar lists of people online (i.e. followers of followers)
	    - [ ] https://github.com/sw1sh
	- [ ] https://mundyreimer.github.io/blog/thermodynamics-agency-livingsystems
	- [ ] [[Jasmin Christian Blanchette]]
	- [ ] [[Simon Cruanes]]
	- [ ] Biology/Chemistry/... other fields
		- [ ] [[PENDING (2028+?); Biology]]
		- [ ] https://github.com/OpenFOAM/OpenFOAM-dev ... other simulation
	- [ ] Active Inference, ...
	- [ ] Computational Metaphysics
		- [ ] https://mally.stanford.edu/cm/
		- [ ] https://page.mi.fu-berlin.de/cbenzmueller/compmeta/htdocs/
- 
	- [[Mealy machines]]
	- Bi-directional programming languages (Monoidal cafe?). Same with the [[Category Theory]] para lenses etc.. just the ray selection (arbitrarily branching)?
- https://en.wikipedia.org/wiki/Forbidden_graph_characterization
- https://github.com/NEASQC/qrbs
- https://cseweb.ucsd.edu/~goguen/cool.html [[Joseph Amadee Goguen]]
- https://docs.google.com/document/d/1kD7H4E28656ua8jOGZ934nbH2HcBLyxcRgFDduH5iQ0/mobilebasic
- https://prooftheory.blog/resources/
- https://geometricdeeplearning.com/blogs/
- https://learn.microsoft.com/en-us/sysinternals/downloads/process-explorer

- https://github.com/Scinawa/quantumalgorithms.org
- 
- Hardware/firmware/embedded systems etc... (*TODO Actually expand this list...*)
	- HSA, HIP, CUDA, firmware, ..... 
	- [ ] https://en.wikipedia.org/wiki/Interactive_Disassembler
	- [ ] https://github.com/GPUOpen-Tools,
	- [ ] https://lists.freedesktop.org/archives/amd-gfx/2017-February/005122.html
	- [ ] https://martty.github.io/
	- [ ] https://themaister.net/blog/
	- [ ] AMD: https://gitlab.freedesktop.org/tomstdenis/umr, AQL ?
- 
	- [ ] https://github.com/martinescardo/TypeTopology
	- [ ] https://scholar.archive.org/
	- [ ] https://www.semanticscholar.org/paper/TOWARDS-HIGHER-DIMENSIONAL-REWRITING-THEORY-Mimram/a88710b141afeb7bcee157e56beff635dcfb4350
	- [ ] https://github.com/cda-tum
	- [ ] https://github.com/totogo/awesome-knowledge-graph
	- [ ] Emulators, ... devkits etc..
		- [ ] https://www.synopsys.com/verification/emulation/zebu-ep1.html
	- [ ] rocm (amd)
	- [ ] https://en.wikipedia.org/wiki/STMicroelectronics
	- [ ] [Tenstorrent](https://github.com/tenstorrent)
	- [ ] [VHDL (VHSIC Hardware Description Language)](https://en.m.wikipedia.org/wiki/VHDL)
	- Compiler toolchains etc..
		- [XLA](https://openxla.org/)
	- RDNA3, (Tinygrad's RDNA3 emulator) etc..
	- chiups have these things calls efuses, you can burn them to disable/enable (cant be unburned) ; hardware changes.
	- [ ] https://github.com/gnif/LookingGlass (... others, throughput channels ..)
	- [ ] https://binvis.io/#/
	- [ ] [VirtualBox](https://www.virtualbox.org/), Vulkan, WebGL, [WebGPU Shading Language (WGSL)](https://gpuweb.github.io/gpuweb/wgsl/), [WebXR](https://github.com/immersive-web), [wgpu](https://github.com/gfx-rs/wgpu), https://thebookofshaders.com/, https://github.com/oracle/graal,  
		- [ ] https://github.com/SaschaWillems/Vulkan/blob/master/examples%2Foffscreen%2Foffscreen.cpp
		- [ ] https://github.com/NVIDIA/cuda-samples/blob/master/Samples%2F5_Domain_Specific%2FvulkanImageCUDA%2FREADME.md ; cuda interop
		- [ ] https://github.com/SaschaWillems/Vulkan
		- [ ] https://github.com/DTolm/VkFFT
		- [ ] https://git.datenwolf.net/
	- [ ] Graphics programming discord: https://discord.com/invite/Eb7P3wH , [[Graphics Programming]]
	- [ ] 
- GKEYLL, simulation, emulation, render/physics/.../game engines etc..
- MuJoCo
- https://www.mathstat.dal.ca/~selinger/quipper/
- All the [[PENDING (2027?+) ; Physics (& Hardware)]] things... String theories, Ring Theory, ..., Knot Theory, Graph Percolation Theory, constructor theory etc... 
	- Expand for any field
	- https://en.wikipedia.org/wiki/Game_semantics
	- 
- Networking... ([[Anoma]])
- Ah, of course, infrastructure/engineering/design things/tools:
	- https://twitter.com/thatopencompany
- dimensional analysis
- Computational geometry ; https://www.computational-geometry.org/
- huets algorithm, higher-order unification, ....

---

### Some more relevant historical stuff: 
- [Characteristica_universalis](https://en.wikipedia.org/wiki/Characteristica_universalis), [Lingua_generalis](https://en.wikipedia.org/wiki/Lingua_generalis), [Philosophical_language](https://en.wikipedia.org/wiki/Philosophical_language), [Proofs_from_THE_BOOK](https://en.wikipedia.org/wiki/Proofs_from_THE_BOOK), [The_Glass_Bead_Game](https://en.wikipedia.org/wiki/The_Glass_Bead_Game), [Universal_language](https://en.wikipedia.org/wiki/Universal_language), [Langlands program](https://en.wikipedia.org/wiki/Langlands_program), [Mathesis universalis](https://en.wikipedia.org/wiki/Mathesis_universalis), [Universal logic](https://en.wikipedia.org/wiki/Universal_logic), [Institution (computer science)](https://en.wikipedia.org/wiki/Institution_(computer_science)), 

- [Phenomenology](https://en.wikipedia.org/wiki/Phenomenology_(philosophy) apparently [also interested](https://twitter.com/JohannesKleiner/status/1762893159044931637) in these things

- old old & linguistics https://en.wikipedia.org/wiki/Cuneiform, https://en.wikipedia.org/wiki/Hangul 

- Floating-Point Arithmetic (there were people who created neat graphs for these, find them? - probably a very neat way of phrasing them in terms of rays ; as in where the ambiguity happens), eNDIAN BASE ENCODING, ..

---

- https://zenodo.org/
- https://learn-anything.xyz/
- 

## Some old notes for possible ways to expand the list:
- https://en.wikipedia.org/wiki/Sigma_model
- 

###### Indexing existing archives/knowledge bases for preservation and possible future analysis...
  - Github  
  - gitlab  
  - https://www.ietf.org/,   
  - Google Scholar...  
  - https://numenta.com/neuroscience-research/research-publications/papers/  
  - https://www.pnas.org/  
  - https://figshare.com/ (; datasets; found after toroidal topology paper)  
  - Kaggle.com  
  - arXiv dataset (https://info.arxiv.org/help/bulk_data/index.html)  
  - https://www.sciencedirect.com/  
  - other journals...  
  - https://iopscience.iop.org/  
  - https://dl.acm.org/  
  - https://en.wikipedia.org/wiki/MathSciNet  
  - https://github.com/keras-team/keras (François Chollet)  
  - https://github.com/CarperAI/OpenELM  
  - https://huggingface.co/  
  - https://research.tudelft.nl/en/publications/ ( other uniss.)
  - (collects models & datasets;) https://github.com/intel/dffml  
  - Theorems/mathematics/proofs/grammers...  
  - https://theoretics.episciences.org/
  - https://eprint.iacr.org/
Some tooling?/datasets  
  - https://en.wikipedia.org/wiki/Wikipedia:Database_download#Where_do_I_get_it?  
  - https://resources.wolframcloud.com/  
  - https://www.wolframphysics.org/archives/index/  
  - https://openlibrary.org/  
  - https://archiveprogram.github.com/  
  - https://archive.org/  
  - Crawling [[IPFS]]: https://github.com/adlrocha/go-libp2p-crawler  
  - digital library: [[JSTOR]]  
  - https://github.com/hartator/wayback-machine-downloader  
  - https://mathshistory.st-andrews.ac.uk/
  - https://www.connectedpapers.com/
  - https://universaldependencies.org/
  - https://open-science-cloud.ec.europa.eu/ & other
  - 

---

Proof Assistant exploration, [[Proof_assistant.pdf]], [[Formal_verification.pdf]], [[Computer-assisted_proof.pdf]], [[Automated_reasoning.pdf]], [[QED_manifesto.pdf]], [[Proof_compression.pdf]]
,[[Automated_theorem_proving.pdf]], [[Compiler-compiler.pdf]],[[History_of_compiler_construction.pdf]], [[Compiler.pdf]], [[Decompiler.pdf]], [[Corrado Böhm]]

---

Platform interop
[[ONGOING Project Logistics]]
- [ ] Others.. Telegram, Signal, Whatsapp, Zulip, Slack ..., Matrix, ... ?  IRC, RSS feed, Substack, arXiv, research gate etc..., SEO properties ...
	- [ ] (?hosted matrix?)  
	- [ ] Similarly, link github/gitlab/ prs/... (project descriptions etc..)  
	- [ ] profile pictures (emotes) .. (account linking..)  
		- [ ] Just use "@OrbitMines (bot) some link/code"  
		- [ ] ; make that one available through the protocol too)  - RMTP//...
	- [ ] Status etc..
- [ ] Intercompilation images..
- [ ] Cross boundaries of things/communication ; basically this as the general pattern for all of this
[[PENDING (2027?+) ; Operating System]]
- NixOS


---

# UNPROCESSED
*Tread carefully, confusion abound*

---


Digesting some wikipedia articles (; mainly as exploratory, not necessarily interested in rigor on this expedition, just looking for some interesting ideas I hadn't heard of/hadn't thought of before)

Assume all comments on these as quick conclusions drawn from summaries which may themselves be, as well as my interpretation of them, ignorant of the actual writings on the subject:  
  
- [π-calculus](Π-calculus.pdf)  
- [Universal algebra](Universal_algebra.pdf)  
- [Ambient calculus](Ambient_calculus.pdf)  
- [Church–Turing thesis](Church–Turing_thesis.pdf)  
- [Horseshoe map](Horseshoe_map.pdf) ; https://www.youtube.com/watch?v=aSbTDJCGyfc&ab_channel=ProfGhristMath  
- [Claude Shannon](Claude_Shannon.pdf)  
- [Mitchell Feigenbaum](Mitchell_Feigenbaum.pdf)  
- [Unobservable](Unobservable.pdf)  
- [Hilary Putnam](Hilary_Putnam.pdf)  
- [David Hilbert](David_Hilbert.pdf) ; Still deeper dive into the mathematics soon...  
- [Hilbert's problems](Hilbert's_problems.pdf)  
- [Hilbert's twenty-fourth problem](Hilbert's_twenty-fourth_problem.pdf)  
- [The Grand Design (book)](The_Grand_Design_(book).pdf)  
- [Proof theory](Proof_theory.pdf)  
- [Ordinal analysis](Ordinal_analysis.pdf) ; Spent some effort to understand this.  
- [Finitary](Finitary.pdf)  
- [Provability logic](Provability_logic.pdf)  
- [Self-verifying theories](Self-verifying_theories.pdf)  
- [Higher-order logic](Higher-order_logic.pdf)  
- [Alonzo Church](Alonzo_Church.pdf)  
- [Interpretability logic](Interpretability_logic.pdf)  
- [Models of scientific inquiry](Models_of_scientific_inquiry.pdf)  
- [Pluralism (philosophy)](Pluralism_(philosophy).pdf)  
- [Paraconsistent logic](Paraconsistent_logic.pdf) ; This sort of thing is probably just encoding on the observer's side. And this can likely be encoded into most forms of logic/mathematics? Think it's conceptually close to my conclusions but doesn't make the connection?  
- [Graham Priest](Graham_Priest.pdf)  
- [Constructive empiricism](Constructive_empiricism.pdf)  
- [Relevance logic](Relevance_logic.pdf)  
- [Intuitionistic logic](Intuitionistic_logic.pdf)  
- [Logical constant](Logical_constant.pdf)  
- [Perspectivism](Perspectivism.pdf)  
- [Leonard Mlodinow](Leonard_Mlodinow.pdf)  
- [Instrumentalism](Instrumentalism.pdf)  
- [HOL (proof assistant)](HOL_(proof_assistant).pdf)  
- [Dana Scott](Dana_Scott.pdf)  
- [Gordon Plotkin](Gordon_Plotkin.pdf)  
- [Axiomatic semantics](Axiomatic_semantics.pdf)  
- [Trusted computing base](Trusted_computing_base.pdf)  
- [Black box](Black_box.pdf) ; Part not predictably reducible ; not directly with the current available tools, anyway.  
- [Grey box model](Grey_box_model.pdf)  
- [Black box group](Black_box_group.pdf) ; further inquiry into group theory  
- [Cybernetics](Cybernetics.pdf)  
- [Radical constructivism](Radical_constructivism.pdf)  
- [Autopoiesis](Autopoiesis.pdf) ; Maturana himself stated he would "[n]ever use the notion of self-organization ... Operationally it is impossible. That is, if the organization of a thing changes, the thing changes ; Look him up and see if there's anything interesting there.
- [Humberto Maturana](Humberto_Maturana.pdf) ; Read one of his translated earlier papers? Probably the 1998 one.
- [Enactivism](Enactivism.pdf)  
- [Constructivism (philosophy of science)](Constructivism_(philosophy_of_science).pdf)  
- [Ernst von Glasersfeld](Ernst_von_Glasersfeld.pdf)  
- [Social constructivism](Social_constructivism.pdf)  
- [Social constructionism](Social_constructionism.pdf)  
- [Model-dependent realism](Model-dependent_realism.pdf) ; Pretty much exactly along my line of thinking.  
- [All models are wrong](All_models_are_wrong.pdf) ; Perhaps recite all these topics in the next paper to cover the previous collection of ideas. ; Evidently a lot of it has been permeating through science for some time.
- [George E. P. Box](George_E._P._Box.pdf)  
- [Anscombe's quartet](Anscombe's_quartet.pdf) ; Could be characterized as numbers in high volume don't necessarily encode strict positional relationships to each-other as a visual graph would for humans.  
- [Bonini's paradox](Bonini's_paradox.pdf)  
- [Reification (fallacy)](Reification_(fallacy).pdf) ; Constructs/models/patterns/..  
- [Counterfactual definiteness](Counterfactual_definiteness.pdf)  
- [Quantum indeterminacy](Quantum_indeterminacy.pdf) ; "In classical physics, experiments of chance, such as coin-tossing and dice-throwing, are deterministic, in the sense that, perfect knowledge of the initial conditions would render outcomes perfectly predictable. The ‘randomness’ stems from ignorance of physical information in the initial toss or throw. In diametrical contrast, in the case of quantum physics, the theorems of Kochen and Specker,[5] the inequalities of John Bell,[6] and experimental evidence of Alain Aspect,[7][8] all indicate that quantum randomness does not stem from any such physical information." ; This latter part is resultant from the idea that we seemingly can't obtain such information according to quantum mechanics right? Which would be similarly ignorance we would currently not be aware until a way around it is formed, or if it is indeed impossible. ; Or I'm completely missing the point and this confusion needs to be sorted.  
- [Independence (mathematical logic)](Independence_(mathematical_logic).pdf)  
- [Bell's theorem](Bell's_theorem.pdf) & [ON THE EINSTEIN PODOLSKY ROSEN PARADOX](../2022/read/PhysicsPhysiqueFizika.1.195.pdf); Just read Bell's paper again, and I believe my previous statement is correct. Although it gave me some distress in thinking a core assumption I've had for a while was incorrect. (; I believe not the first time this happened around this issue, either.)  
- [Superdeterminism](Superdeterminism.pdf)  
- [Continuum hypothesis](Continuum_hypothesis.pdf)  
- [Freiling's axiom of symmetry](Freiling's_axiom_of_symmetry.pdf)  
- [Tacit assumption](Tacit_assumption.pdf)  
- [Absolute Infinite](Absolute_Infinite.pdf)  
- [Actual infinity](Actual_infinity.pdf)  
- [Surrogation](Surrogation.pdf) ; Similar to ideas of benchmarking/targets. Likely a generalization of something like this could be found somewhere.  
- [Goodhart's law](Goodhart's_law.pdf) ; Probably not a bad idea to see if a more general version of this exists which takes the observer into account more formally.  
- [Hypostatic abstraction](Hypostatic_abstraction.pdf)  
- [Verisimilitude](Verisimilitude.pdf)  
- [Commensurability (philosophy of science)](Commensurability_(philosophy_of_science).pdf)  
- [Philosophical realism](Philosophical_realism.pdf)  
- [Process philosophy](Process_philosophy.pdf)  
- [Denotational semantics](Denotational_semantics.pdf)  
- [Unbounded nondeterminism](Unbounded_nondeterminism.pdf) ; More examples of a frame of reference being relevant for what is considered to be nondeterministic against some ideal computational system (; as an extreme?). Interestingly does make an argument of how one would interact with something deemed as something unbounded nondeterministic ; look further into that part?  
- [Concurrency (computer science)](Concurrency_(computer_science).pdf) ; Example of invariance in some dimension being useful. THis one being some relation of time-invariance (; order invariance, allow for partial states) in a certain general way. ; Argument would be that such a thing could be violated by something arbitrarily unknown. How does one shield against that to hold the required property for this useful thing?  
- [Mutual exclusion](Mutual_exclusion.pdf) ; Strategy of concurrency control ; or a violation of the extreme (/property) in concurrence.  
- [Concurrency control](Concurrency_control.pdf)  
- [Race condition](Race_condition.pdf)  
- [Hazard (logic)](Hazard_(logic).pdf)  
- [Indeterminacy in concurrent computation](Indeterminacy_in_concurrent_computation.pdf)  
- [Process calculus](Process_calculus.pdf) ; Not sure if I've read something on this before, but a lot of its concepts come quite close to my thoughts. (; if I did most likely while I was reading up some stuff up on Kindelia/HVM/Combinators.)  
  - "In some process calculi (notably the π-calculus) channels themselves can be sent in messages through (other) channels, allowing the topology of process interconnections to change. Some process calculi also allow channels to be created during the execution of a computation." This part seems critical, further inquiry... ; self-referentialness there  
  - "Processes do not limit the number of connections that can be made at a given interaction point." ; Similar to my assessment, not necessarily indicating one's that are not perceived by the system itself.  
  - "But interaction points allow interference (i.e. interaction). For the synthesis of compact, minimal and compositional systems, the ability to restrict interference is crucial. Hiding operations allow control of the connections made between interaction points when composing agents in parallel" ; Very close to a definition of ignorance.  
  - "Generally, processes are considered to be the same if no context, that is other processes running in parallel, can detect a difference. Unfortunately, making this intuition precise is subtle and mostly yields unwieldy characterisations of equality (which in most cases must also be undecidable, as a consequence of the halting problem)" ; very close to my assessments; I'd also conclude from that, that it's the act of ignoring certain differences which makes this possible: Neither system is 'perfectly' the same, abstractly.  
- [Actor model and process calculi](Actor_model_and_process_calculi.pdf)  
- [Actor model](Actor_model.pdf) ; Somewhat analogous to programming from a specific reference frame.  
- [Actor model implementation](Actor_model_implementation.pdf)  
- [Irene Greif](Irene_Greif.pdf)  
- [Operational semantics](Operational_semantics.pdf)  
- [Divergence (computer science)](Divergence_(computer_science).pdf)  
- []() ; "Normal form" -> 'irreducible'  
- [Stochastic probe](Stochastic_probe.pdf)  
- [Temporal Process Language](Temporal_Process_Language.pdf) ; Probably a good idea to look up what the state-of-the-art is on actual time keeping.  
- [Fellow of the Royal Society](Fellow_of_the_Royal_Society.pdf)  
- [Robin Milner](Robin_Milner.pdf)  
- [Logic for Computable Functions](Logic_for_Computable_Functions.pdf)  
- [Programming Computable Functions](Programming_Computable_Functions.pdf)  
- [Foundherentism](Foundherentism.pdf)  
- [Foundationalism](Foundationalism.pdf) ; Alterable/Unalterable assumptions as a set of 'basic beliefs' to compare other things to.  
- [Coherentism](Coherentism.pdf)  
- [Neopragmatism](Neopragmatism.pdf)  
- [Postanalytic philosophy](Postanalytic_philosophy.pdf)  
- [Analytic philosophy](Analytic_philosophy.pdf)  
- [Ludwig Wittgenstein](Ludwig_Wittgenstein.pdf)  
- [Wittgenstein on Rules and Private Language](Wittgenstein_on_Rules_and_Private_Language.pdf)  
- [On Certainty](On_Certainty.pdf)  
- [Ordinary language philosophy](Ordinary_language_philosophy.pdf)  
- [Context principle](Context_principle.pdf) ; Similar ideas to stating something like that  a certain generality in proposition makes something a certain form of unanswerable. At the same time a certain extreme in the sense that context (in its extreme) implies certain 'impossibilities' in having to evaluate all context which seems impossible. ; Seems just as confused as its opposite extreme?  
- [Semantic holism](Semantic_holism.pdf)  
- [Pragmatics](Pragmatics.pdf)  
- [Historical pragmatics](Historical_pragmatics.pdf)  
- [Historical linguistics](Historical_linguistics.pdf)  
- [Lexicostatistics](Lexicostatistics.pdf)  
- [Paleolinguistics](Paleolinguistics.pdf)  
- [Proto-language](Proto-language.pdf)  
- [Uniformitarianism](Uniformitarianism.pdf) ; Similar models of computation when shifted to different environments in the sense of different computers they're operating on, would to some extent fall under a shift of uniformity. If one doesn't already apply that to the temporal changes to the observer. ; Stability is likely useful though. ; Perhaps something like tstating this initially in any observer must in some sense hold, and not in another.  
- [Anaphora (linguistics)](Anaphora_(linguistics).pdf)  
- [Collapsing sequence](Collapsing_sequence.pdf)  
- [Universal pragmatics](Universal_pragmatics.pdf)  
- [Pragmatism](Pragmatism.pdf) ; Seems like many similarities can be found here.  
- [Nominalism](Nominalism.pdf)  
- [Pragmatic theory of truth](Pragmatic_theory_of_truth.pdf)  
- [Rudolf Carnap](Rudolf_Carnap.pdf)  
- [Willard Van Orman Quine](Willard_Van_Orman_Quine.pdf)  
- [Quine Putnam indispensability argument](Quine–Putnam_indispensability_argument.pdf)  
- [Duhem–Quine thesis](Duhem–Quine_thesis.pdf) ; As with confirmation holism, some similarities with observer/outside-observer argument.  
- [Marcello Truzzi](Marcello_Truzzi.pdf)  
- [Radical empiricism](Radical_empiricism.pdf)  
- [Daniel Dennett](Daniel_Dennett.pdf)  
- [Opaque context](Opaque_context.pdf)  
- [Aberrant decoding](Aberrant_decoding.pdf)  
- [Dynamical system](Dynamical_system.pdf)  
- [Manifold](Manifold.pdf)  
- [Phase space](Phase_space.pdf) ; Realization here that perhaps an orbit is nothing more than the idealized realization of some form of equivalency which is perceived to keep repeating. A minor chuckle appropriate at the naming of OrbitMines ~10 years ago, which I had already attached as a name to these explorations. ; Perhaps use orbiting as a more general concept in cases of equivalency?  
- [Orbit (dynamics)](Orbit_(dynamics).pdf) ; The above realization came after looking at the animation so promptly depicted here before reading the article.  
- [Catastrophic interference](Catastrophic_interference.pdf) ; forgetting  
- [Iterated function](Iterated_function.pdf) ; composition (; realized through extremes as infinities as 'what if it keeps happening?')  
- [Periodic point](Periodic_point.pdf) ; repeating patterns ; hence periodic; relating to time.  
- [Attractor](Attractor.pdf) ; How are things like this effected by uncertainty?  
- [Gottlob Frege](Gottlob_Frege.pdf)  
- [Principle of compositionality](Principle_of_compositionality.pdf)  
- [Context (language use)](Context_(language_use).pdf)  
- [Sharkovskii's theorem](Sharkovskii's_theorem.pdf) ; Perhaps look a little further into this idea & its generalizations. ; [ADS : Vol 4 : Chapter 4.4 : Sharkovski's Theorem](https://www.youtube.com/watch?v=ZF4N3oGkiN0&ab_channel=ProfGhristMath) ; Ordering seems like such an abstract formulation of some ordering of some space I believe I mentioned somewhere earlier in this journal as something like: "some ordering such that a sorting function sorts the elements in a particular (always the same) kind of way" as such that ordering will have some properties. I'm assuming as we'll see here. ; Find out if there are some interesting generalizations & ideas around this. ; [Lecture 15: Double pendulum & Sharkovskii's Theorem](https://www.youtube.com/watch?v=r74SvaQomrw&ab_channel=Chaos%2CFractals%2C%26DynamicalSystems) ; [This equation will change how you see the world (the logistic map)](https://www.youtube.com/watch?v=ovJcsL7vyrk&ab_channel=Veritasium)  
- [James A. Yorke](James_A._Yorke.pdf) ; This does seem a little interesting, definitely look into this further.  
- [Feigenbaum constants](Feigenbaum_constants.pdf) ; Chaos  
- [Bifurcation diagram](Bifurcation_diagram.pdf)  
- [Fixed point (mathematics)]() ; Invariant to transformation.  
- [Saul Kripke](Saul_Kripke.pdf) ; Avoids self-reference by not allowing self-reference? Seems merely as saying the same pattern-like things as Tarski but merely with different language, or merely a different conceptualization. ; Relate some of this work to Tarski/Godel...  
- [Ignoramus et ignorabimus](Ignoramus_et_ignorabimus.pdf) ; Ideas like this seem so close to the ideas I'm trying to realize. Does the initial offering of the idea mention self-reference, likely not due to its time. The article makes a mention of Godel, but not necessarily the phrasing is made that the statement 'ignoramus et ignorabimus' in its initialization should be self-referential ; or that would be my definition.  
- [Ignorance management](Ignorance_management.pdf) ; Further inquiry in links  
- [Ignorance](Ignorance.pdf) ; Some more fields found here.  
- [Agnoiology](Agnoiology.pdf) ; Look up a paper.  
- [James Frederick Ferrier](James_Frederick_Ferrier.pdf) ; is a bit discouraging to read up on his writing. Perhaps such a realization might happen more by going back further in time? Perhaps there's something interesting to be found.  
- [Avidyā (Hinduism)](Avidyā_(Hinduism).pdf) ; Will at some point have to create a better picture of religions / possible belief structures. I'm assuming that the formulation I have of ignorance will likely do that indirectly. ; Similarly mapping cultures / languages I have no frame for is probably a good idea.  
- [Acatalepsy](read/wiki/Acatalepsy.pdf) ; 'Actual unknowable certainty' vs 'perceived certainty'. ; One keeps finding examples where ideas are used as extremes and as their more vague ambiguous pointers.  
- [Fallibilism](read/wiki/Fallibilism.pdf)  
- [Diagonal lemma](read/wiki/Diagonal_lemma.pdf) ; self-reference. Also found a name: 'Kleene' / 'Tarski' ; perhaps worth looking into.  
- [Tarski's undefinability theorem](read/wiki/Tarski's_undefinability_theorem.pdf)  
- [Alfred Tarski](read/wiki/Alfred_Tarski.pdf) ; further inquiry into his papers (as with Godel's I suppose)  
- [Metaphysics](Metaphysics%20-%20Wikipedia.pdf) ; Starting the journey here  
- [Philosophical logic](Philosophical%20logic%20-%20Wikipedia.pdf) ; Concept mentioned here as 'paraconsistent' seems at least worthy of some additional reading. Although the connection made here to what is called 'dialetheism (; greek: both true & false)' seems like the system doesn't deal with its own self-reference.  
- [Dialetheism](read/wiki/Dialetheism.pdf) ; As I promptly (accidentally) worded before reading it by 'translating' the greek word (without making the direct link yet) ; This seems to be reasoning by superposition, and the superficial summaries of some of its criticisms already seem to mention that this does not remove self-reference.  
- [Absoluteness](read/wiki/Absoluteness.pdf) ; Probably a good idea to make a more formal dive into the mathematics behind set/group/... theory, and see how they would relate to the more abstract 'observer/ignorant' thing I'm trying to realize.  
- [Deflationary theory of truth](read/wiki/Deflationary_theory_of_truth.pdf) ; Don't know necessarily what to say about this. Seems more of a case study of particulars of the human mind and its languages. I'd argue that additional information is added to the sentence and thus possible leads to different conclusions dependent on the observer. Where in the case of humans these might be the case. I guess a little related to the descriptions can't possibly be the actual truth and are in that sense a deflation of unknowable states of the universe. ; Hence a little related to the ideas of an outside observer in the following sense: 'disquotational theory of truth' as extremes on belief as truth, where truth in the sense of belief would be 'observer-dependant'. ; Probably just more related to confusion resulting from extremes.  
- [Correspondence theory of truth](read/wiki/Correspondence_theory_of_truth.pdf) ; More confusion similar to the previous item. The relationship between conclusions 'an outside observer' might be able to draw, and the 'observer within the system'. In describing the relation of perceived truth and actual truth. More of the same thing analogous to: 'If an observer cannot tell they are hallucinating, they will not know so.'.  
- [Coherence theory of truth](read/wiki/Coherence_theory_of_truth.pdf) ; Coherence conflicting with dynamics? ; Makes me think a little about the idea that any assertion should be considered within the context of the information used to make the assertion. Or at least, it would be likely useful to do so.  
- [Confirmation holism](read/wiki/Confirmation_holism.pdf) ; Interesting, more inquiry here at some point.  
- [Underdetermination](read/wiki/Underdetermination.pdf); Simiarly any definition of a system can be abstractly attributed to some other system it's operating under which could undermine the observer entirely with sufficient control. Makes mention of Bell's inequality. Quite similar to some ideas I've been having. The skeptical section is interesting. I believe I made a similar assertion about my own ideas in the sense that the best argument against it is that it's always correct in some sense. Where I'd diverge int he skeptical argument that it's unknowable whether breaking through that unknown layer is possible or not: hence exploration. And it'd be true some forms would not be knowably correct, but there are variants where this might be the case. But self-referentially, perhaps similar claims of unknowability would be applicable to the layer 'outside' of the system. ; One can re-conceptualize the two systems as being one system. Interesting, probably return to this later. Perhaps one should apply an argument to this in the form of accidentally making the 'right conclusion for conceivably accidental reasons (accidental being only held up in a certain frame of reference similar to arbitrary/infinity/..)'. This initially wrong jump might lead to investigation with could help one determine something like this. ; "It is therefore too powerful an argument to have any significance in the philosophy of science, since it does not cast doubt uniquely on conjectured unobservables." seems like an argument I need to address for my ideas. ; Perhaps in the sense of 'knowing some property applicable everywhere is useful, since it gives one a language to talk about it instead of being ignorant of it'. Or perhaps something else.  ([[Rosemary Braun]] made mention of this concept in the [[Sean Caroll]] podcast ; this intuition may me quite generalizable - that of course graining necessarily, and being quite explicit about that - 'wiring diagrams')
