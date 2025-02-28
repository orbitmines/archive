###### *Every month*
---

@orbitmines explorations - 2024, May: Explorers, researchers, traders, ..., pirates: Gatherers, crafters, ..., spreaders of items unknown to some, ... all.

###### *Every 10 months. - Instagram*
---

@orbitmines explorations: Explorers, researchers, traders, ..., pirates: Gatherers, crafters, ..., spreaders of items unknown to some, ... all

The last 10 months of my literary exposure (2023-07 - 2024-04)


```shell
cd ~/Desktop/orbitmines/private-journal/

find ./_/attachments/read/ -type f -newermt 2024-09-01

 git whatchanged --since '2024/04/01' --until '2024/04/30' --oneline --name-only --pretty=format: | sort | uniq | grep /read/wikipedia
 
 git whatchanged --since '2024/09/01' --until '2024/10/01' --oneline --name-only --pretty=format: | sort | uniq | grep /read/wikipedia | sed -e 's:.*/::' -e 's/.pdf$//' -e 's/.*/, [&]\(https:\/\/en\.wikipedia\.org\/wiki\/&\)/' | paste -sd ''

git log --since="1 month ago" --diff-filter=ACM --name-only | grep /read/wikipedia | sort | uniq | sed -e 's:.*/::' -e 's/.pdf$//' -e 's/.*/, [&]\(https:\/\/en\.wikipedia\.org\/wiki\/&\)/' | paste -sd ''

find ./_/attachments/read/ -type f -newermt 2023-12-01 | grep /read/wikipedia

find ./_/attachments/read/ -type f -newermt 2023-12-01 | sort | uniq | grep /read/wikipedia | sed -e 's:.*/::' -e 's/.pdf$//' -e 's/.*/, [&]\(https:\/\/en\.wikipedia\.org\/wiki\/&\)/' | paste -sd ''


const policy = window.trustedTypes?.createPolicy("default", {createHTML: (input) => input});

console.log([...document.querySelectorAll("#video-title")].filter(video => video.title !== '').forEach(video => {
	video.insertAdjacentHTML("afterend", policy.createHTML(`<div><input type="text" value="- :youtube: [${video.title} (2025)](${video.href}) ;  **" readonly> <button onclick="this.previousElementSibling.select();document.execCommand('copy');">Copy</button></div>`));
}))


console.log([...document.querySelectorAll("#video-title")].filter(video => video.title !== '').map(video => `- :youtube: [${video.title}](${video.href})`).join('\n'))

```

```js
  
const string =  
    ""  
  
const res = string.split('\n')  
    .filter(l => l.startsWith('-'))  
    .map(l => l.trim())  
    .map(l => {  
        const [title, year, link] = [...l.matchAll(/\[(.+)\s(.+)]\((.+)\)/g)]  
            .map(m => [m[1], m[2], m[3]])[0];  
        const organizations =  [...l.matchAll(/:([a-z_]+):/g)]  
            .map(m => m[1]);  
        // .map(key => (ORGANIZATIONS as any)[key]!);    
const authors = [...l.matchAll(/\*(.+)\*$/g)]  
            .map(m => m[1])  
            .join()  
            .replaceAll(/(\s(and|&)\s)/g, ",")  
            .split(",")  
            .map(name => name.trim());  
  
        const ref = title  
            .replaceAll(/[|&':{}()#",?*$%^=@;\[\]/\\.\"\']/g, "")  
            .replace(/\s{2,}/g, ' ')  
            .replaceAll(/[- ]/g, "_")  
            .toUpperCase();  
  
        return `${ref}: <Content>{  
            reference: {                 title: '${title}',      
                 authors: [${authors.map(author => `{name: '${author}'}`).join(',')}],      
                 organizations: [${organizations.map(org => `ORGANIZATIONS.${org}`)}],  
                 year: '${year}',      
                 link: "${link}"      
            }, status: Viewed.VIEWED, viewed_at: "2023, December"     
        }`  
        //return `REFERENCES.${ref}`;    
}).join(',\n')  
console.log(res);
```

---

![[Pasted image 20240604084826.png]]

# 2025, March - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- 

# 2025, February - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- :youtube: [The equivalence between geometrical structures and entropy (2025)](https://www.youtube.com/watch?v=lp0RgZ6kQF8) ; *Gabriele Carcassi*
- :youtube: :lex_fridman_podcast: [DeepSeek, China, OpenAI, NVIDIA, xAI, TSMC, Stargate, and AI Megaclusters | #459 (2025)](https://www.youtube.com/watch?v=_1f-o0nqpEI) ;  *Dylan Patel, Nathan Lambert, Lex Fridman*
- :youtube: :toe: [Harvard Physicist Debunks Particle Superposition (2025)](https://www.youtube.com/watch?v=MTD8xkbiGis&t=11s) ;  *Jacob Barandes, Manolis Kellis, Curt Jaimungal*
- :youtube: :toe: [Why Physics Without Philosophy Is Deeply Broken... [Part 2] (2025)](https://www.youtube.com/watch?v=YaS1usLeXQM) ;  *Jacob Barandes, Curt Jaimungal*
- :youtube: :toe: [Top AI Scientist Unifies Wolfram, Leibniz, & Consciousness (2025)](https://www.youtube.com/watch?v=3fkg0uTA3qU) ;  *William Hahn, Curt Jaimungal*
- :youtube: :toe: [The Theory That Explains YOU... (Free Energy Principle) (2025)](https://www.youtube.com/watch?v=0yOV9Pzk2zw) ;  *Michael Levin, Karl Friston, Curt Jaimungal*
- :youtube: :toe: [Why Physics Without Philosophy Is Deeply Broken... [Part 2] (2025)](https://www.youtube.com/watch?v=YaS1usLeXQM) ;  *Jacob Barandes, Curt Jaimungal*
# 2025, January - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Einstein: His Life and Universe (2007)](https://en.wikipedia.org/wiki/Einstein:_His_Life_and_Universe) ; *Walter Isaacson*
- [The future of brain emulation is looking spiky (2025)](https://neurobiology.substack.com/p/the-future-of-brain-emulation-is) ; *Andy McKenzie*

- :youtube: :toe: [Why The "Godfather of AI" Now Fears His Own Creation (2025)](https://www.youtube.com/watch?v=b_DUft-BdIE&ab_channel=CurtJaimungal) ; *Geoffrey Hinton, Curt Jaimungal*
- :youtube: :toe: [The Major Flaws in Fundamental Physics (2024)](https://www.youtube.com/watch?v=E3y-Z0pgupg&ab_channel=CurtJaimungal) ; *Sabine Hossenfelder, Curt Jaimungal*
- :youtube: :toe: [The Crisis in String Theory is Worse Than You Think (2024)](https://www.youtube.com/watch?v=2p_Hlm6aCok&ab_channel=CurtJaimungal) ; *Leonard Susskind, Curt Jaimungal*
- :youtube: :toe: [Math Has Changed Forever… (2025)](https://www.youtube.com/watch?v=wbP0KjWm0pw&ab_channel=CurtJaimungal) ; *Yang-Hui He, Curt Jaimungal*

# 2024, October, November & December - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Applied Category Theory in Chemistry, Computing, and Social Networks (2022)](https://math.ucr.edu/home/baez/mrc_2022.pdf) ; *John Baez, Simon Cho, Daniel Cicala, Nina Otter, Valeria de Paiva*
- [Uniqueness Trees: A Possible Polynomial Approach to the Graph Isomorphism Problem (2016)](https://arxiv.org/pdf/1606.06399) ; *Jonathan Gorard*
- :youtube: :lex_fridman_podcast: [Alien Civilizations and the Search for Extraterrestrial Life | Lex Fridman Podcast #455 (2024)](https://www.youtube.com/watch?v=yhZAXXI83-4&ab_channel=LexFridman) ; *Adam Frank, Lex Fridman*
- :youtube: :toe: [There’s No Wave Function? (2024)](https://www.youtube.com/watch?v=7oWip00iXbo&ab_channel=CurtJaimungal) ; *Jacob Barandes, Curt Jaimungal*
- :youtube: :toe: [The Potential of the Human Brain (2024)](https://www.youtube.com/watch?v=Q9sBKCd2HD0&ab_channel=CurtJaimungal) ; *Iain McGilchrist, Curt Jaimungal*
- :youtube: :toe: [The Universe Writes Itself Into Existence Moment by Moment (2024)](https://www.youtube.com/watch?v=pWRAaimQT1E&ab_channel=CurtJaimungal) ; *Avshalom Elitzur, Curt Jaimungal*

# 2024, September - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Hunters of Dune (2006)](https://en.wikipedia.org/wiki/Hunters_of_Dune) ; *Brian Herbert, Kevin J. Anderson*
- [The Little Book of Deep Learning (2023)](https://fleuret.org/public/lbdl.pdf) ; *François Fleuret*
- [Preface: What is OpenGL? (2014)](https://openglbook.com/chapter-0-preface-what-is-opengl.html#:~:text=On%20the%20most%20fundamental%20level,the%20finer%20details%20of%20OpenGL.) *Eddy Luten*
- [Foundations of Bidirectional Programming I: Well-Typed Substructural Languages (2024)](https://cybercat.institute/2024/08/26/bidirectional-programming-i/) ; *Jules Hedges*
- [Foundations of Bidirectional Programming II: Negative Types (2024)](https://cybercat.institute/2024/09/05/bidirectional-programming-ii/) ; *Jules Hedges*
- [The Yoga of Contexts I (2024)](https://cybercat.institute/2024/06/28/yoga-contexts/) ; *Jules Hedges*
- :wolfram: [Why Does Biological Evolution Work? A Minimal Model for Biological Evolution and Other Adaptive Processes (2024)](https://writings.stephenwolfram.com/2024/05/why-does-biological-evolution-work-a-minimal-model-for-biological-evolution-and-other-adaptive-processes/) ; *Stephen Wolfram*

- :youtube: :toe: [20th Century’s Greatest Living Scientist | Sir Roger Penrose (2024)](https://www.youtube.com/watch?v=sGm505TFMbU) ; *Roger Penrose, Curt Jaimungal*  
- :youtube: :toe: [The Quantum Heretic: A New Theory of Everything? (2024)](https://www.youtube.com/watch?v=6Z_p3viqW1g) ; *Jonathan Oppenheim, Curt Jaimungal*  
- :youtube: :lex_fridman_podcast: [Maya, Aztec, Inca, and Lost Civilizations of South America | Lex Fridman Podcast #446 (2024)](https://www.youtube.com/watch?v=AzzE7GOvYz8) ; *Ed Barnhart, Lex Fridman*  
- :youtube: :lex_fridman_podcast: [The Roman Empire - Rise and Fall of Ancient Rome | Lex Fridman Podcast #443 (2024)](https://www.youtube.com/watch?v=DyoVVSggPjY) ; *Gregory Aldrete, Lex Fridman*  
- :youtube: :mindscape: [Mindscape 289 | The Next Generation of Particle Experiments (2024)](https://www.youtube.com/watch?v=ELe3fvuTsdE) ; *Cari Cesarotti, Sean Carroll*  
- :youtube: :mindscape: [Mindscape 291 | The Biology of Death and Aging (2024)](https://www.youtube.com/watch?v=aNqwamgxNiU) ; *Venki Ramakrishnan, Sean Carroll*  
- :youtube: [Maths of Quantum Mechanics (2023)](https://www.youtube.com/watch?v=3nvbBEzfmE8&list=PL8ER5-vAoiHAWm1UcZsiauUGPlJChgNXC) ; *Brandon Sandoval*

- :wikipedia: Wikipedia Articles: [Observational_equivalence](https://en.wikipedia.org/wiki/Observational_equivalence), [Universal_science](https://en.wikipedia.org/wiki/Universal_science)

---

# 2024, June, July & August - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Computing Machinery and Intelligence (1950)](https://academic.oup.com/mind/article/LIX/236/433/986238?url=http://szyxflb.com&login=false) ; *Alan M. Turing*
- [Von Neumann and Lattice Theory (1958)](https://projecteuclid.org/journals/bulletin-of-the-american-mathematical-society/volume-64/issue-3.P2/Von-Neumann-and-lattice-theory/bams/1183522370.pdf) ; *Garrett Birkhoff*
- :wolfram: [When Exactly Will the Eclipse Happen? A Multimillennium Tale of Computation (2024)](https://writings.stephenwolfram.com/2024/03/when-exactly-will-the-eclipse-happen-a-multimillennium-tale-of-computation/) ; *Stephen Wolfram*
- :wolfram: [Are All Fish the Same Shape if You Stretch Them? The Victorian Tale of On Growth and Form (2017)](https://writings.stephenwolfram.com/2017/10/are-all-fish-the-same-shape-if-you-stretch-them-the-victorian-tale-of-on-growth-and-form/) ; *Stephen Wolfram*
- :wolfram: [What’s Really Going On in Machine Learning? Some Minimal Models (2024)](https://writings.stephenwolfram.com/2024/08/whats-really-going-on-in-machine-learning-some-minimal-models/) ; *Stephen Wolfram*

- :youtube: [The Hydrogen Atom: Intro to Quantum Physics](https://www.youtube.com/watch?v=-Y0XL-K0jy0) ; *Richard Behiel*  
- :youtube: :mindscape: [Mindscape 287 | Institutions and the Legacy of History](https://www.youtube.com/watch?v=FKVmYeU11y0) ; *Jean-Paul Faguet, Sean Carroll*  
- :youtube: :wolfram_institute: [Live Science | Spinal Graphs | Hypergraph Confluence, Symmetry and Efficiency](https://www.youtube.com/watch?v=uZkqNDIOQLs)  
- :youtube: :wolfram_institute: [Live Science | Infrageometry: Correspondences | Differential Geometry, Hypergraph Rewriting](https://www.youtube.com/watch?v=Mr1zfZtoFX0)  
- :youtube: :wolfram_institute: [Live Science | Quantum Paradoxes | Delayed Choice Quantum Eraser, CHSH Game, Quasiprobabilities](https://www.youtube.com/watch?v=rTKSWObWtNE)  
- :youtube: :toe: [Consciousness, Biology, Universal Mind, Emergence, Cancer Research](https://www.youtube.com/watch?v=c8iFtaltX-s) ; *Michael Levin, Curt Jaimungal*  
- :youtube: :toe: [The Crisis in (Fundamental) Physics is Worse Than You Think...](https://www.youtube.com/watch?v=9AoRxtYZrZo) ; *Sean Carroll, Curt Jaimungal*  
- :youtube: :lex_fridman_podcast: [Neuralink and the Future of Humanity | Lex Fridman Podcast #438](https://www.youtube.com/watch?v=Kbk9BiPhm7o)  
- :youtube: :lex_fridman_podcast: [Physics of Life, Time, Complexity, and Aliens | Lex Fridman Podcast #433](https://www.youtube.com/watch?v=wwhTfyX9J34) ; *Sara Walker, Lex Fridman*

- :wikipedia: Wikipedia Articles: [Blaise_Pascal](https://en.wikipedia.org/wiki/Blaise_Pascal), [Destination_Earth_(European_Union)](https://en.wikipedia.org/wiki/Destination_Earth_(European_Union)), [Edvard_Moser](https://en.wikipedia.org/wiki/Edvard_Moser), [Existential_graph](https://en.wikipedia.org/wiki/Existential_graph), [Karl_Sims](https://en.wikipedia.org/wiki/Karl_Sims), [Peter_Gärdenfors](https://en.wikipedia.org/wiki/Peter_G%C3%A4rdenfors), [Quantum_entanglement](https://en.wikipedia.org/wiki/Quantum_entanglement)


# 2024, May - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Self-exfiltration is a key dangerous capability (2023)](https://aligned.substack.com/p/self-exfiltration) ; *Jan Leike*
- [Pluralistic: The disenshittified internet starts with loyal "user agents" (2024)](https://pluralistic.net/2024/05/07/treacherous-computing/) ; *Cory Doctorow*
- [Elon Musk (2023)](https://en.wikipedia.org/wiki/Elon_Musk_(Isaacson_book)) ; *Walter Isaacson*

- :youtube: :semf: [Fun Raising | Funding & School Q&A + SEMF Social](https://www.youtube.com/watch?v=FL8zNDbrAR0) ; *Fadi Shawki, Álvaro Moreno Vallori, Alejandro Sospedra Orellano, Elena Isasi Theus, Anmol Agrawal, Carlos Zapata Carratalá*
- :youtube: :lex_fridman_podcast: [Human Memory, Imagination, Deja Vu, and False Memories | Lex Fridman Podcast #430](https://www.youtube.com/watch?v=4iuepdI3wCU) ; *Charan Ranganath, Lex Fridman*  
- :youtube: :lex_fridman_podcast: [Jungle, Apex Predators, Aliens, Uncontacted Tribes, and God | Lex Fridman Podcast #429](https://www.youtube.com/watch?v=pwN8u6HFH8U) ; *Paul Rosolie, Lex Fridman*  
- :youtube: :toe: [Longevity, Meditation, Philosophies, Consciousness, Nature of Reality](https://www.youtube.com/watch?v=PXkhhHPUud4) ; *Bryan Johnson, Curt Jaimungal*

- :wikipedia: Wikipedia Articles: [Chiara_Mingarelli](https://en.wikipedia.org/wiki/Chiara_Mingarelli), [Computational_Complexity_Conference](https://en.wikipedia.org/wiki/Computational_Complexity_Conference), [Cory_Doctorow](https://en.wikipedia.org/wiki/Cory_Doctorow), [Dagstuhl](https://en.wikipedia.org/wiki/Dagstuhl), [DBLP](https://en.wikipedia.org/wiki/DBLP), [European_Open_Science_Cloud](https://en.wikipedia.org/wiki/European_Open_Science_Cloud), [Federal_Ministry_of_Education_and_Research_(Germany)](https://en.wikipedia.org/wiki/Federal_Ministry_of_Education_and_Research_(Germany)), [German_Research_Foundation](https://en.wikipedia.org/wiki/German_Research_Foundation), [IMT_School_for_Advanced_Studies_Lucca](https://en.wikipedia.org/wiki/IMT_School_for_Advanced_Studies_Lucca), [International_Colloquium_on_Automata,_Languages_and_Programming](https://en.wikipedia.org/wiki/International_Colloquium_on_Automata,_Languages_and_Programming), [International_Conference_on_Concurrency_Theory](https://en.wikipedia.org/wiki/International_Conference_on_Concurrency_Theory), [International_Symposium_on_Mathematical_Foundations_of_Computer_Science](https://en.wikipedia.org/wiki/International_Symposium_on_Mathematical_Foundations_of_Computer_Science), [Isomorphic_Labs](https://en.wikipedia.org/wiki/Isomorphic_Labs), [Jan_Leike](https://en.wikipedia.org/wiki/Jan_Leike), [Jeff_Zacks](https://en.wikipedia.org/wiki/Jeff_Zacks), [Leibniz_Association](https://en.wikipedia.org/wiki/Leibniz_Association), [Leibniz_Prize](https://en.wikipedia.org/wiki/Leibniz_Prize), [Marcia_K._Johnson](https://en.wikipedia.org/wiki/Marcia_K._Johnson), [MuJoCo](https://en.wikipedia.org/wiki/MuJoCo), [Oberwolfach_Research_Institute_for_Mathematics](https://en.wikipedia.org/wiki/Oberwolfach_Research_Institute_for_Mathematics), [Philip_Maini](https://en.wikipedia.org/wiki/Philip_Maini), [Raimund_Seidel](https://en.wikipedia.org/wiki/Raimund_Seidel), [Reinhard_Wilhelm](https://en.wikipedia.org/wiki/Reinhard_Wilhelm), [Saarland_University](https://en.wikipedia.org/wiki/Saarland_University), [Stefano_Boccaletti](https://en.wikipedia.org/wiki/Stefano_Boccaletti), [Symposium_on_Computational_Geometry](https://en.wikipedia.org/wiki/Symposium_on_Computational_Geometry), [Symposium_on_Theoretical_Aspects_of_Computer_Science](https://en.wikipedia.org/wiki/Symposium_on_Theoretical_Aspects_of_Computer_Science), [Vittoria_Colizza](https://en.wikipedia.org/wiki/Vittoria_Colizza)

---

![[Pasted image 20240501005725.png]]
# 2024, April - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)
### :orbitmines: OrbitMines Excerpt
- :orbitmines: [Project - Research towards Designs (2024)](https://github.com/orbitmines/orbitmines.com/issues/29)
- :orbitmines: [Project - Education (2027+?)](https://github.com/orbitmines/orbitmines.com/issues/30)
- :syco: [Twelfth Symposium on Compositional Structures (SYCO 12) (2024)](https://www.cl.cam.ac.uk/events/syco/12/) ; *Birmingham, UK*

### Literary Exposure
- :youtube: :tinycorp: [Researching | same thing we do every weekend, documenting the AMD 7900XTX | Part 1 (2024)](https://www.youtube.com/watch?v=j7MRj4N2Cyk) ; *George Hotz*
- :youtube: :tinycorp: [Reverse engineering | same thing we do every weekend documenting the AMD 7900XTX Part2 (2024)](https://www.youtube.com/watch?v=Z04xTlLdZnc) ; *George Hotz*
- :youtube: :tinycorp: [Researching | documenting the AMD 7900XTX so we can understand why it crashes | RDNA 3 (2024)](https://www.youtube.com/watch?v=Y-0yZ1AHb0s) ; *George Hotz*
- :youtube: [What makes high-dimensional networks produce low-dim. activity? (2019)](https://www.youtube.com/watch?v=toeX2mGWDbI) ; *Eric Shea-Brown*
- :youtube: :lex_fridman_podcast: [Lisa Randall: Dark Matter, Theoretical Physics, and Extinction Events | Lex Fridman Podcast #403 (2023)](https://www.youtube.com/watch?v=VPaOy3G1-2A) ; *Lisa Randall, Lex Fridman*
- :youtube: :lex_fridman_podcast: [Reality is a Paradox - Mathematics, Physics, Truth & Love | Lex Fridman Podcast #370 (2023)](https://www.youtube.com/watch?v=Osh0-J3T2nY) ; *Edward Frenkel, Lex Fridman*
- :youtube: [The Langlands Program - Numberphile (2023)](https://www.youtube.com/watch?v=4dyytPboqvE) ; *Edward Frenkel*
- :youtube: :toe: [Time and Quantum Mechanics SOLVED? | Lee Smolin (2024)](https://www.youtube.com/watch?v=uOKOodQXjhc) ; *Lee Smolin, Curt Jaimungal*
- :youtube: :toe: [Edward Frenkel: Infinity, Ai, String Theory, Death, The Self (2023)](https://www.youtube.com/watch?v=n_oPMcvHbAc) ; *Edward Frenkel, Curt Jaimungal*

- :youtube: :wolfram_institute: [Live Science | Infrageometry: Core Definitions | Differential Geometry, Tangent Bundles, Functions (2024)](https://www.youtube.com/watch?v=QxtG4tr6VY0) ; *Nikolay Murzin, Carlos Zapata-Carratalá, James Wiles, Utkarsh Bajaj*
- :youtube: :wolfram_institute: [Live Science | Infrageometry: Working Session | Functions, Edges-Places, Bipartite Graphs (2024)](https://www.youtube.com/watch?v=pdPBzPyJqcE) ; *Nikolay Murzin, Carlos Zapata-Carratalá, James Wiles, Utkarsh Bajaj*
- :youtube: :wolfram_institute: [Fellow Focus | Richard Assar | MetaMetaverse, Alien Minds, Machine Learning Cellular Automata (2024)](https://www.youtube.com/watch?v=xg9pAx4bupk) ; *Nikolay Murzin, Carlos Zapata-Carratalá, James Wiles*
- :youtube: :wolfram_institute: [Fellow Focus | Nik Murzin | Quantum Framework (2024)](https://www.youtube.com/watch?v=eG6d8_2GuCw) ; *Nikolay Murzin, Carlos Zapata-Carratalá, James Wiles*
- :youtube: :wolfram_institute: [Explore & Learn | The Map of Institute Research | Quantum Probabilities, Multicomputation, Causality (2024)](https://www.youtube.com/watch?v=OKHrPZ6tT6M) ; *Nikolay Murzin, James Wiles*
- :youtube: :wolfram_institute: [Explore & Learn | The Map of Institute Research | Multicomputation, Infrageometry, Ruliad (2024)](https://www.youtube.com/watch?v=8F9YL887Bck) ; *Carlos Zapata-Carratalá, James Wiles*
- :youtube: :wolfram_institute: [Explore & Learn | Fundamentals: What's hype about Hypergraphs? | Graph Theory, Hypermatrix, Arity (2024)](https://www.youtube.com/watch?v=N3vGEp1uLvk) ; *Carlos Zapata-Carratalá, Richard Assar, James Wiles*
- :youtube: :mindscape: [Mindscape 274 | Gizem Gumuskaya on Building Robots from Human Cells (2024)](https://www.youtube.com/watch?v=jwaOzmW3xfs) ; *Gizem Gumuskaya, Sean Carroll*
- :youtube: :semf: [Community Livestream | Data & Dimensionality (2024)](https://www.youtube.com/watch?v=zBV1nLw2WuM)
- :youtube: :all_in: [All-In Podcast E173 (2024)](https://www.youtube.com/watch?v=z3Zzlgo-xZM) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E174 (2024)](https://www.youtube.com/watch?v=hZp80SYIRlY) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E175 (2024)](https://www.youtube.com/watch?v=HKtlezdPNAI) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E176 (2024)](https://www.youtube.com/watch?v=1ZQ33OnGFWE) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*

- :wikipedia: Wikipedia Articles: [Academia_Europaea](https://en.wikipedia.org/wiki/Academia_Europaea), [Advanced_Research_and_Invention_Agency](https://en.wikipedia.org/wiki/Advanced_Research_and_Invention_Agency), [Andrej_Karpathy](https://en.wikipedia.org/wiki/Andrej_Karpathy), [Bryan_Johnson](https://en.wikipedia.org/wiki/Bryan_Johnson), [Center_for_Neurotechnology](https://en.wikipedia.org/wiki/Center_for_Neurotechnology), [Centrum_Wiskunde_&_Informatica](https://en.wikipedia.org/wiki/Centrum_Wiskunde_&_Informatica), [Chiara_Marletto](https://en.wikipedia.org/wiki/Chiara_Marletto), [Corpuscularianism](https://en.wikipedia.org/wiki/Corpuscularianism), [CWTS_Leiden_Ranking](https://en.wikipedia.org/wiki/CWTS_Leiden_Ranking), [Edward_Frenkel](https://en.wikipedia.org/wiki/Edward_Frenkel), [Edward_Witten](https://en.wikipedia.org/wiki/Edward_Witten), [E-flux](https://en.wikipedia.org/wiki/E-flux), [Institution_(computer_science)](https://en.wikipedia.org/wiki/Institution_(computer_science)), [Jean-Yves_Girard](https://en.wikipedia.org/wiki/Jean-Yves_Girard), [Joseph_Goguen](https://en.wikipedia.org/wiki/Joseph_Goguen), [Laurent_Fargues](https://en.wikipedia.org/wiki/Laurent_Fargues), [Lee_Smolin](https://en.wikipedia.org/wiki/Lee_Smolin), [Manlio_De_Domenico](https://en.wikipedia.org/wiki/Manlio_De_Domenico), [Meta-Research_Innovation_Center_at_Stanford](https://en.wikipedia.org/wiki/Meta-Research_Innovation_Center_at_Stanford), [Michael_Atiyah](https://en.wikipedia.org/wiki/Michael_Atiyah), [Michel_Talagrand](https://en.wikipedia.org/wiki/Michel_Talagrand), [Netherlands_Organisation_for_Applied_Scientific_Research](https://en.wikipedia.org/wiki/Netherlands_Organisation_for_Applied_Scientific_Research), [Open_Knowledge_Foundation](https://en.wikipedia.org/wiki/Open_Knowledge_Foundation), [Perimeter_Institute_for_Theoretical_Physics](https://en.wikipedia.org/wiki/Perimeter_Institute_for_Theoretical_Physics), [Peter_Higgs](https://en.wikipedia.org/wiki/Peter_Higgs), [Peter_Scholze](https://en.wikipedia.org/wiki/Peter_Scholze), [Peter_Woit](https://en.wikipedia.org/wiki/Peter_Woit), [Plan_S](https://en.wikipedia.org/wiki/Plan_S), [Robert_Langlands](https://en.wikipedia.org/wiki/Robert_Langlands), [Sabine_Hossenfelder](https://en.wikipedia.org/wiki/Sabine_Hossenfelder), [Sanjeev_Arora](https://en.wikipedia.org/wiki/Sanjeev_Arora), [Strelka_Institute](https://en.wikipedia.org/wiki/Strelka_Institute), [Toptica_Photonics](https://en.wikipedia.org/wiki/Toptica_Photonics), [Universal_logic](https://en.wikipedia.org/wiki/Universal_logic), [Vinod_Khosla](https://en.wikipedia.org/wiki/Vinod_Khosla)



![[Pasted image 20240401022536.png]]

# 2024, March - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)
### :orbitmines: OrbitMines Excerpt
- :orbitmines: [A Universal Language coming to pixels near you sometime soon™™ in 2024! The Glass Bead Game but the solution to The Glass Bead Game is The Glass Bead Game.🤔](https://twitter.com/_FadiShawki/status/1774086843765530833)
- :youtube: :semf: [In-Person Workshop | Into the Information Continuum](https://www.youtube.com/watch?v=KM97bUcVPDE&t=2786s)
- :youtube: :orbitmines: [Silent - Archive - Thinking on OrbitMines' Rays implementation in Python](https://www.youtube.com/watch?v=MEDL_D89GFA&t=9212s)

### Literary Exposure
- [Calculus Ratiocinator vs. Characteristica Universalis? The Two Traditions in Logic, Revisited (2004)](https://www.researchgate.net/publication/228386287_Calculus_Ratiocinator_vs_Characteristica_Universalis_The_two_traditions_in_logic_revisited) ; *Volker Peckhaus*
- [Cargo Cult Science (1974)](https://calteches.library.caltech.edu/51/2/CargoCult.htm) ; *Richard P. Feynman*
- [Millions of children learn only very little. How can the world provide a better education to the next generation? (2022)](https://ourworldindata.org/better-learning) ; *Max Roser*
- [Stripe's 2023 annual letter (2024)](https://stripe.com/en-nl/annual-updates/2023) ; *Patrick Collison, John Collison*
- [Playing, Valuing, and Living: Examining Nietzsche’s Playful Response to Nihilism (2015)](https://philpapers.org/rec/HARPVA-2) ; *Aaron Harper*
- [The Build Your Own Open Games Engine Bootcamp — Part I: Lenses (2024)](https://blog.20squares.xyz/open-games-bootcamp-i/) ; *Daniele Palombi*
- :wolfram: [Can AI Solve Science? (2024)](https://writings.stephenwolfram.com/2024/03/can-ai-solve-science/) ; *Stephen Wolfram, Richard Assar, Nik Murzin*

- :youtube: :semf: [Community Livestream | Bioelectricity (2024)](https://www.youtube.com/watch?v=XBNh3Yoxei0)
- :youtube: :toe: [Quantum Gravity & Wolfram Physics Project (2024)](https://www.youtube.com/watch?v=ioXwL-c1RXQ) ; *Jonathan Gorard, Curt Jaimungal*
- :youtube: :toe: [Paradigm Shift, Ghost Particles, Constructor Theory (2024)](https://www.youtube.com/watch?v=40CB12cj_aM&t=6443s) ; *Chiara Marletto, Curt Jaimungal*
- :youtube: :toe: [The String Theory Iceberg EXPLAINED (2024)](https://www.youtube.com/watch?v=X4PdPnQuwjY&t=9496s) ; *Curt Jaimungal*
- :youtube: :tinycorp: [Exploring | sniffing NVIDIA's ioctls | open-gpu-kernel-modules | DEBUG | PTX | CUDA (2024)](https://www.youtube.com/watch?v=rUsx1b7rQ8Q&t=9910s) ; *George Hotz*
- :youtube: :tinycorp: [Programming | writing a fuzzer and not getting triggered when the AMD GPU crashes UMR (2024)](https://www.youtube.com/watch?v=BCnTXwhzzxA&t=9780s) ; *George Hotz*
- :youtube: :tinycorp: [Programming | ripping out all of AMD's userspace, AMDGPU ioctls | GPU memory | HSA KFD (2024)](https://www.youtube.com/watch?v=-iH5wvFnsKs) ; *George Hotz*
- :youtube: :all_in: [All-In Podcast E169 (2024)](https://www.youtube.com/watch?v=snbTCWL6rxo) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E170 (2024)](https://www.youtube.com/watch?v=uMajFsCkzxY) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E171 (2024)](https://www.youtube.com/watch?v=3tEcLAud7Nc) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E172 (2024)](https://www.youtube.com/watch?v=4t4YkHSTZbw) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: [Shannon Luminary Lecture Series - Stephen Fry (2017)](https://www.youtube.com/watch?v=24F6C1KfbjM) ; *Stephen Fry*
- :youtube: [Containers for compiler architecture (2024)](https://www.youtube.com/watch?v=BnzAxT-O0Y8) ; *Andre Videla*
- :youtube: [Why It Was Almost Impossible to Make the Blue LED (2024)](https://www.youtube.com/watch?v=AF8d72mA41M) ; *@Veritasium*
- :youtube: [Compositional Game Theory – Towards Incentives Modelling at Scale (2024)](https://www.youtube.com/watch?v=2b4hxOP7g9I) ; *Jules Hedges*
- :youtube: :mindscape: [Mindscape 268 | Matt Strassler on Relativity, Fields, and the Language of Reality (2024)](https://www.youtube.com/watch?v=kCpELmx425w) ; *Matt Strassler*
- :youtube: :active_inference_institute: [ActInf MathStream 009.1 ~ Jonathan Gorard: A computational perspective on observation and cognition (2024)](https://www.youtube.com/watch?v=I3rhsT-8isk) ; *Jonathan Gorard*
- :youtube: [A Conversation with Mark Zuckerberg, Patrick Collison and Tyler Cowen (2019)](https://about.fb.com/news/2019/11/a-conversation-with-mark-zuckerberg-patrick-collison-and-tyler-cowen/) ; *Mark Zuckerberg, Patrick Collison, Tyler Cowen*

- :wikipedia: Wikipedia Articles: [École_polytechnique](https://en.wikipedia.org/wiki/École_polytechnique), [Golan_Levin](https://en.wikipedia.org/wiki/Golan_Levin), [Institut_de_recherche_en_informatique_fondamentale](https://en.wikipedia.org/wiki/Institut_de_recherche_en_informatique_fondamentale), [Interaction_Design_Foundation](https://en.wikipedia.org/wiki/Interaction_Design_Foundation), [Jonathan_Oppenheim](https://en.wikipedia.org/wiki/Jonathan_Oppenheim), [Mark_Zuckerberg](https://en.wikipedia.org/wiki/Mark_Zuckerberg), [Max_Roser](https://en.wikipedia.org/wiki/Max_Roser), [Mehrnoosh_Sadrzadeh](https://en.wikipedia.org/wiki/Mehrnoosh_Sadrzadeh), [Olivia_Caramello](https://en.wikipedia.org/wiki/Olivia_Caramello), [Our_World_in_Data](https://en.wikipedia.org/wiki/Our_World_in_Data), [Probabilistic_programming](https://en.wikipedia.org/wiki/Probabilistic_programming), [Procedural_generation](https://en.wikipedia.org/wiki/Procedural_generation), [Slow_science](https://en.wikipedia.org/wiki/Slow_science), [Spectral_graph_theory](https://en.wikipedia.org/wiki/Spectral_graph_theory), [Tallinn_University_of_Technology](https://en.wikipedia.org/wiki/Tallinn_University_of_Technology), [University_of_Birmingham](https://en.wikipedia.org/wiki/University_of_Birmingham)

---

# 2024, February - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)
*till 2024, March 05*

### :orbitmines: OrbitMines Excerpt
- :orbitmines: [OrbitMines as a Game Project (2024)](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project)

### Literary Exposure
- [Solving SAT via Positive Supercompilation (2024)](https://hirrolot.github.io/posts/sat-supercompilation.html) ; *Tima Kinsart (Hirrolot)*
- [Navigating cognition: Spatial codes for human thinking (2018)](https://www.science.org/doi/10.1126/science.aat6766) ; *Jacob L. S. Bellmund, Peter Gärdenfors, Edvard I. Moser, Christian F. Doeller*
- [Towards a structural turn in consciousness science (2024)](https://pubmed.ncbi.nlm.nih.gov/38422757/) ; *Johannes Kleiner*
- [The Glass Bead Game (1970)](https://www.nytimes.com/1970/01/04/archives/the-glass-bead-game-glass-bead.html) ; *Ralph Freedman*

- :youtube: [An Introduction to Higher Arity Science (2021)](https://www.youtube.com/watch?v=62UFbGsj5Jg) ; *Carlos Zapata-Carratalá*
- :youtube: [History of Science and Technology Q&A (February 28, 2024)](https://www.youtube.com/watch?v=kNXXksujIHM) ; *Stephen Wolfram*
- :youtube: [GReTA seminar: Higher-Arity Algebra via Hypergraph Rewriting (2024)](https://www.youtube.com/watch?v=ZBjagJvNEn8) ; *Carlos Zapata-Carratalá*
- :youtube: :semf: [Workshop | Axiomatic Creation (2024)](https://www.youtube.com/watch?v=StNfdknDQ9c)
- :youtube: :semf: [Community Livestream | Axioms & Creativity (2024)](https://www.youtube.com/watch?v=9ddJAJaYk_E)
- :youtube: :semf: [Concept Collider | Geometry of Data and Neural Correlates (2024)](https://www.youtube.com/watch?v=mROz1U4VkGY)
- :youtube: :wolfram: [Wolfram Physics Project: Working Session - Causal Multiway Systems (2020)](https://www.youtube.com/watch?v=OXSE6KhRUF4) ; *Stephen Wolfram, Jonathan Gorard*
- :youtube: :wolfram: [Science Research Session: Hyporuliad (2023)](https://www.youtube.com/watch?v=lZaBjuHk7Ms) ; *Stephen Wolfram, Jonathan Gorard*
- :youtube: :wolfram: [A conversation between Bob Coecke and Stephen Wolfram (2021)](https://www.youtube.com/watch?v=8CUTXaGqvSQ) ; *Bob Coecke, Stephen Wolfram*

- [Steve Jobs (2011)](https://en.wikipedia.org/wiki/Steve_Jobs_(book)) ; *Walter Isaacson*
- :youtube: [John Cleese on Creativity In Management (2017)](https://www.youtube.com/watch?v=Pb5oIIPO62g) ; *John Cleese*
- :youtube: [The Trillion Dollar Equation (Veritasium)](https://www.youtube.com/watch?v=A5w-dEgIU1M) ; *@Veritasium*
- :youtube: [Steve Jobs President & CEO, NeXT Computer Corp and Apple. MIT Sloan Distinguished Speaker Series (1992)](https://www.youtube.com/watch?v=Gk-9Fd2mEnI) ; *Steve Jobs*
- :youtube: [Carl Sagan at MIT - Management in the Year 2000: Sloan School Symposium (1987)](https://www.youtube.com/watch?v=gLOZsTMuars) ; *Carl Sagan*
- :youtube: [Chamath Palihapitiya (SocialCapital) @ Startup Grind (2015)](https://www.youtube.com/watch?v=ncjum-bkW98) ; *Chamath Palihapitiya*
- :youtube: [Chamath Palihapitiya speaking at Waterloo Innovation Summit (2016)](https://www.youtube.com/watch?v=D82_ppT2iic) ; *Chamath Palihapitiya*
- :youtube: :all_in: [All-In Podcast E165 (2024)](https://www.youtube.com/watch?v=FHO4hoXc75k) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*
- :youtube: :all_in: [All-In Podcast E164 (2024)](https://www.youtube.com/watch?v=bUuEE2jmP2c) ; *Chamath Palihapitiya, Jason Calacanis, David Friedberg, David O. Sacks*

- :wikipedia: Wikipedia Articles: [Chamath_Palihapitiya](https://en.wikipedia.org/wiki/Chamath_Palihapitiya), [Characteristica_universalis](https://en.wikipedia.org/wiki/Characteristica_universalis), [Chris_Quigg](https://en.wikipedia.org/wiki/Chris_Quigg), [David_Friedberg](https://en.wikipedia.org/wiki/David_Friedberg), [David_O._Sacks](https://en.wikipedia.org/wiki/David_O._Sacks), [Eric_Schwitzgebel](https://en.wikipedia.org/wiki/Eric_Schwitzgebel), [Garrett_Birkhoff](https://en.wikipedia.org/wiki/Garrett_Birkhoff), [George_David_Birkhoff](https://en.wikipedia.org/wiki/George_David_Birkhoff), [Gordon_Moore](https://en.wikipedia.org/wiki/Gordon_Moore), [Gottfried_Wilhelm_Leibniz](https://en.wikipedia.org/wiki/Gottfried_Wilhelm_Leibniz), [Hermann_Hesse](https://en.wikipedia.org/wiki/Hermann_Hesse), [Isaac_Newton](https://en.wikipedia.org/wiki/Isaac_Newton), [Jason_Calacanis](https://en.wikipedia.org/wiki/Jason_Calacanis), [Joe_Armstrong_(programmer)](https://en.wikipedia.org/wiki/Joe_Armstrong_(programmer)), [John_Collison](https://en.wikipedia.org/wiki/John_Collison), [Lingua_generalis](https://en.wikipedia.org/wiki/Lingua_generalis), [Patrick_Collison](https://en.wikipedia.org/wiki/Patrick_Collison), [Philosophical_language](https://en.wikipedia.org/wiki/Philosophical_language), [Proofs_from_THE_BOOK](https://en.wikipedia.org/wiki/Proofs_from_THE_BOOK), [Robert_Noyce](https://en.wikipedia.org/wiki/Robert_Noyce), [Sabine_Stanley](https://en.wikipedia.org/wiki/Sabine_Stanley), [Social_Capital_(venture_capital)](https://en.wikipedia.org/wiki/Social_Capital_(venture_capital)), [The_Glass_Bead_Game](https://en.wikipedia.org/wiki/The_Glass_Bead_Game), [Tyler_Cowen](https://en.wikipedia.org/wiki/Tyler_Cowen), [Universal_language](https://en.wikipedia.org/wiki/Universal_language)

---
![[_/attachments/Screenshot from 2024-02-01 00-01-33.png]]
![[Pasted image 20231231155320.png]]

---


# 2024, January - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### :orbitmines: OrbitMines Excerpt
- :orbitmines: :youtube: [What is OrbitMines?, Implementing Aleks Kissinger's Chyp and maybe looking at Tinygrad (2024)](https://www.youtube.com/watch?v=O6v_gzlI1kY)
- :orbitmines: :youtube: [Implementing Aleks Kissinger's Chyp: Cospans of Hypergraphs: Compose, DPO(I), ..., Tensor. (2024)](https://www.youtube.com/watch?v=nob8BQhC8nQ)
- :orbitmines: :discord: :github: :chyp: [Implementing Chyp into OrbitMines' Rays - (Cospans of HYPergraphs - Aleks Kissinger)](https://discord.com/channels/1055502602365845534/1185009740103811122)
- :orbitmines: :discord: [Project - (Hypergraphic) Version Control System through Rays (2024)](https://discord.com/channels/1055502602365845534/1200225618164461639)
- :orbitmines: :discord: [Project - Compute (2024?) - Rays to GPUs](https://discord.com/channels/1055502602365845534/1200210127358267522)
- :orbitmines: :discord: [Project - Indexing existing Abstract Models (2024-2025?)](https://discord.com/channels/1055502602365845534/1200246205473619968)
- :orbitmines: :discord: [Project - Compression (2025-2026?)](https://discord.com/channels/1055502602365845534/1200214011023728650)
- :orbitmines: :discord: [OrbitMines as Game Project (2025/2026?)](https://discord.com/channels/1055502602365845534/1194769877542649938)
- :orbitmines: :discord: [Project - Archive - "OrbitMines' Journey" (2025/2026?)](https://discord.com/channels/1055502602365845534/1200218769172205688)
- :youtube: :semf: [Concept Collider | Mathematical Physics + Active Inference, Free Energy & Entropy (2024)](https://www.youtube.com/watch?v=GwbLOCCI2yE)

### Literary Exposure
- :youtube: [This Week's Finds 18: categorifying the quantum harmonic oscillator (2023)](https://www.youtube.com/watch?v=pvVm3L92pdc) ; *John Baez*
- :youtube: :wolfram: [Wolfram Physics Project Working Session: Quantum Black Holes and Other Things (2023)](https://www.youtube.com/watch?v=fFEVq76_Pu0) ; *Stephen Wolfram, Jonathan Gorard*
- :youtube: [Causal invariance versus confluence (2023)](https://www.youtube.com/watch?v=LYFzm_xSWXw) ; *Jonathan Gorard, Mark Jeffery*
- :youtube: [CRDTs: The Hard Parts (2020)](https://www.youtube.com/watch?v=x7drE24geUw) ; *Martin Kleppmann*
- :youtube: [Riak & Dynamo, Five Years Later Presented (2013)](https://www.youtube.com/watch?v=AxG9DROsnqg) ; *Andy Gross*
- [Riak Core - An Erlang Distributed Systems Toolkit (2011)](https://vimeo.com/21772889) ; *Andy Gross*
- :youtube: :zx_calculus: [ZXLive - An Interactive GUI for the ZX Calculus - Razin A. Shaikh (2023)](https://www.youtube.com/watch?v=J--c2q-KOc8) ; *Razin A. Shaikh*
- :youtube: :zx_calculus: [Graphical CSS Code Transformation Using ZX Calculus (2023)](https://www.youtube.com/watch?v=ZhfQxdjodNs) ; *Jiaxin Huang*
- :youtube: :zx_calculus: [The Zeta Calculus (2023)](https://www.youtube.com/watch?v=iUHEy3PZCso) ; *Nicklas Botö*
- :youtube: [How to Take the Factorial of Any Number (2022)](https://www.youtube.com/watch?v=v_HeaeUUOnc) ; *@Lines That Connect*
- :youtube: :lex_fridman_podcast: [Jeff Bezos: Amazon and Blue Origin | Lex Fridman Podcast #405 (2023)](https://www.youtube.com/watch?v=DcWqzZ3I2cY) ; *Jeff Bezos, Lex Fridman*
- :youtube: [[1hr Talk] Intro to Large Language Models (2023)](https://www.youtube.com/watch?v=zjkBMFhNj_g) ; *Andrej Karpathy*
- :youtube: [Stream #0: Why all video game programmers should learn geometric algebra (2023)](https://www.youtube.com/watch?v=pHKOdxgr5lE) ; *Hamish Todd*
- :youtube: [The Periodic Table of Geometric Algebras - CL(3,0,1) does all 3D game math, so what does CL(p,q,r) d (2023)](https://www.youtube.com/watch?v=oXcp3gA8erQ) ; *Hamish Todd*
- :youtube: [Geometric Algebra as a tool in technical communication (2020)](https://www.youtube.com/watch?v=hR-MQm3c13Q) ; *Hamish Todd*
- :youtube: :mindscape: [Mindscape 260 | Ricard Solé on the Space of Cognitions (2024)](https://www.youtube.com/watch?v=lJltHIlUHvQ) ; *Ricard Solé, Sean Carroll*
- :youtube: :mindscape: [Mindscape 261 | Sanjana Curtis on the Origins of the Elements (2024)](https://www.youtube.com/watch?v=V28YdLuYnjk) ; *Sanjana Curtis, Sean Carroll*
- :youtube: :mindscape: [Mindscape 264 | Sabine Stanley on What's Inside Planets (2024)](https://www.youtube.com/watch?v=myU8GNdpPjU) ; *Sabine Stanley, Sean Carroll*
- :youtube: :mindscape: [Mindscape 263 | Chris Quigg on Symmetry and the Birth of the Standard Model (2024)](https://www.youtube.com/watch?v=-q-HBIBiTQ0) ; *Chris Quigg , Sean Carroll
- :youtube: :mindscape: [Mindscape 262 | Eric Schwitzgebel on the Weirdness of the World (2024)](https://www.youtube.com/watch?v=V0evRaWV_HU) ; *Eric Schwitzgebel , Sean Carroll
- [CRDTs go brrr (2021)](https://josephg.com/blog/crdts-go-brrr/) ; *Seph Gentle*

- :youtube: :tinycorp: [Just Chatting | techno optimism | Winning over nature | Progressive | Acceleration (2023)](https://www.youtube.com/watch?v=WS5wGal3ukw) - *George Hotz*
- :youtube: :tinycorp: [Programming | Decision Transformer Reinforcement Learning (RL) | LunarLander | Part 1 (2024)](https://www.youtube.com/watch?v=8U8kK3SpLTU) - *George Hotz*
- :youtube: :tinycorp: [Programming | RL is dumb and doesn't work | Reinforcement Learning LunarLander Part 2 (2024)](https://www.youtube.com/watch?v=-tZkb0vgaDk) - *George Hotz*
- :youtube: :tinycorp: [Researching | RL is dumb and doesn't work (theory) | Reinforcement Learning | Part 3 (2024)](https://www.youtube.com/watch?v=Ul5-NKOP8RQ) - *George Hotz*
- :youtube: :tinycorp: [Researching | multiGPU with HIP (or maybe without HIP) | HSA | HIP Graph | Part 1 (2024)](https://www.youtube.com/watch?v=X4J_GUhp9jI) - *George Hotz*
- :youtube: :tinycorp: [Programming | multiGPU with HIP (or maybe without HIP) | HSA_DISABLE_CACHE=1 | Part 2 (2024)](https://www.youtube.com/watch?v=kh2z9J_gXWg) - *George Hotz*

- :wikipedia: Wikipedia Articles: [Convergence_(logic)](https://en.wikipedia.org/wiki/Convergence_(logic)), [Curtis_Yarvin](https://en.wikipedia.org/wiki/Curtis_Yarvin), [Fredkin_gate](https://en.wikipedia.org/wiki/Fredkin_gate), [Jeremy_England](https://en.wikipedia.org/wiki/Jeremy_England), [Matrix_clock](https://en.wikipedia.org/wiki/Matrix_clock), [Michael_Nielsen](https://en.wikipedia.org/wiki/Michael_Nielsen), [Vector_clock](https://en.wikipedia.org/wiki/Vector_clock)

---


---

# 2023, December - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### :orbitmines: OrbitMines Excerpt
- :orbitmines: [2023-12-31. On Orbits, Equivalence and Inconsistencies](https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies)
	- *A preliminary exploration and introduction of a simple (visual) language I'm using to understand Orbits, Equivalence and Inconsistencies. - A yearly excerpt of thoughts.*

![[header.png]]
### Literary Exposure
- [String Diagram Rewrite Theory II: Rewriting with Symmetric Monoidal Structure](https://arxiv.org/abs/2104.14686) ; *Filippo Bonchi, Fabio Gadducci, Aleks Kissinger, Pawel Sobocinski, Fabio Zanasi*
- [Chyp: Composing Hypergraphs, Proving Theorems (2023)](https://act2023.github.io/papers/paper25.pdf) ; *Aleks Kissinger*
- [Observer Theory (2023)](https://writings.stephenwolfram.com/2023/12/observer-theory/) ; *Stephen Wolfram*
- :wasm: [Wasm SpecTec: Engineering a Formal Language Standard](https://arxiv.org/pdf/2311.07223.pdf) ; *Joachim Breitner, Philippa Gardner, Jaehyun Lee, Sam Lindley, Matija Pretnar, Xiaojia Rao, Andreas Rossberg, Sukyoung Ryu, Wonho Shin, Conrad Watt, Dongjun Youn*

- :youtube: :mindscape: [Mindscape 259 | Adam Frank on What Aliens Might Be Like (2023)](https://www.youtube.com/watch?v=UzmlA3g2nRE) ; *Adam Frank and Sean Carroll*
- :youtube: [Animation vs. Physics (2023)](https://www.youtube.com/watch?v=ErMSHiQRnc8) ; *Alan Becker + Team*
- :youtube: :3b1b: [Why light can “slow down”, and why it depends on color | Optics puzzles (2023)](https://www.youtube.com/watch?v=KTzGBJPuJwM) ; *3Blue1Brown*
- :youtube: :lex_fridman_podcast: [Lee Cronin: Controversial Nature Paper on Evolution of Life and Universe | Lex Fridman Podcast #404 (2023)](https://www.youtube.com/watch?v=CGiDqhSdLHk) ; *Lee Cronin, Lex Fridman*
- :youtube: :topos_institute: [Berkeley Seminar: David Jaz Myers, 8/7/2023 (2023)](https://www.youtube.com/watch?v=WvniD62U_W4) ; *David Jaz Myers*

- [Yugoslavia’s Digital Twin (2023)](https://www.thedial.world/issue-9/yugolsav-wars-yu-domain-history-icann) ; *Kaloyan Kolev*
- [Physics explains why there is no information on social media (2021)](https://www.zdnet.com/article/physics-explains-why-there-is-no-information-on-social-media/) ; *Tiernan Ray*
- [How To Ask Questions The Smart Way (2001-2014)](http://www.catb.org/~esr/faqs/smart-questions.html) ; *Eric S. Raymond, Rick Moen*

- :wikipedia: Wikipedia Articles: [Computability_in_Europe](https://en.wikipedia.org/wiki/Computability_in_Europe), [Elvira_Mayordomo](https://en.wikipedia.org/wiki/Elvira_Mayordomo), [Geoff_Smith_(mathematician)](https://en.wikipedia.org/wiki/Geoff_Smith_(mathematician)), [Louis_Kauffman](https://en.wikipedia.org/wiki/Louis_Kauffman), [Nicolas_Gisin](https://en.wikipedia.org/wiki/Nicolas_Gisin), [Parallel_transport](https://en.wikipedia.org/wiki/Parallel_transport), [Single_pushout_graph_rewriting](https://en.wikipedia.org/wiki/Single_pushout_graph_rewriting), [Terence_Tao](https://en.wikipedia.org/wiki/Terence_Tao)

### :twitch:/:youtube: Livestreams
- :youtube: :semf: [Complexity & Mathematics | Community Livestream (2023)](https://www.youtube.com/watch?v=MWQ7XFjkOhs)
- :youtube: :semf: [Holiday Special Livestream (2023)](https://www.youtube.com/watch?v=m_rATW4Nrqk)

- :youtube: [Just Chatting | Tesla AI Day 2022 | Science & Technology (2022)](https://www.youtube.com/watch?v=lSXwIzww6Us) - *George Hotz*
- :youtube: [Programming | Mistral mixtral on a tinybox | AMD P2P multi-GPU mixtral-8x7b-32kseqlen (2023)](https://www.youtube.com/watch?v=H40QRJFzThQ) - *George Hotz*
- :youtube: [Programming | what is the Q* algorithm? OpenAI Q Star Algorithm | Mistral 7B | PRM800K (2023)](https://www.youtube.com/watch?v=2QO3vzwHXhg) - *George Hotz*
- :youtube: [Just Chatting | effective accelerationism | e/acc | Techno-pessimism | Deceleration (2023)](https://www.youtube.com/watch?v=YrWEDOQQ8pw) - *George Hotz*
- :youtube: [Science | Thermodynamics is to Energy as ??? is to Intelligence (2023)](https://www.youtube.com/watch?v=vn9Dq24RDn8) - *George Hotz*
- :youtube: [Science | Thermodynamics is to Energy as Entropics is to Intelligence | Part 2 (2023)](https://www.youtube.com/watch?v=mEoiQ_PZNTE) - *George Hotz*
- :youtube: :tinycorp: [Programming | a tiny tour through tinygrad (noob lesson) (2023)](https://www.youtube.com/watch?v=-MhwhiReY-s) - *George Hotz*
- :youtube: :tinycorp: [Programming | tinygrad: writing tutorials for noobs (2023)](https://www.youtube.com/watch?v=Sk35MKtCXfQ) - *George Hotz*
- :youtube: :tinycorp: [Rant | Complaining about how terrible Qualcomm is | The business world (2023)](https://www.youtube.com/watch?v=rzb2cuT9vaY) - *George Hotz*
- :youtube: :tinycorp: [Chatting | challenges hiring people, vision, building a company tiny corp tinygrad.org (2023)](https://www.youtube.com/watch?v=4_6eY-8dibI) - *George Hotz*
- :youtube: :tinycorp: [Reading & Talking | let's read ML papers (2023)](https://www.youtube.com/watch?v=YrWEDOQQ8pw) - *George Hotz*

---

# 2023, November - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### :orbitmines: OrbitMines Excerpt
- :orbitmines: :github: [OrbitMines Explorer - Preliminary Technical Implementation/Exploration (2023-11-19)](https://github.com/orbitmines/orbitmines.com/pull/1)
- :orbitmines: :discord: :wolfram_institute: [Possible connections to the Wolfram Institute's Infrageometry project (2023-11-25)](https://discord.com/channels/1055502602365845534/1177982001979064340)
- :orbitmines: :discord: [Preliminary Ray Visualizations (Notebook 2023/05 - 2023/11)](https://discord.com/channels/1055502602365845534/1114585571772338357)
### Attended Events
- :ngi: [NGI FORUM 2023](https://www.ngi.eu/event/ngi-forum-2023/)
### Literary Exposure
- [String Diagram Rewrite Theory I: Rewriting with Frobenius Structure](https://arxiv.org/abs/2012.01847) ; *Filippo Bonchi, Fabio Gadducci, [[Aleks Kissinger]], Pawel Sobocinski, Fabio Zanasi*
- [Reptar (2023)](https://lock.cmpxchg8b.com/reptar.html) ; *Tavis Ormandy*
- [Aggregation and Tiling as Multicomputational Processes (2023)](https://writings.stephenwolfram.com/2023/11/aggregation-and-tiling-as-multicomputational-processes/) ; *Stephen Wolfram*

- :youtube: :semf: [Physics & Economics | SEMF Community Livestream (2023)](https://www.youtube.com/watch?v=enR68VVQPtY)
- :youtube: :wolfram_institute: [Wolfram Institute's Infrageometry Project Livestreams (2023)](https://www.youtube.com/playlist?list=PLtbvsohNkWeVO_PMxoZfDEiiY8tuYOjgf) ; *Jonathan Gorard, Carlos Zapata-Carratalá, Nikolay Murzin, Utkarsh Bajaj*
- :youtube: :wolfram_institute: [HyperMatrix Workshop (2023)](https://www.youtube.com/watch?v=E8s9Daqy_2A) ; *Edinah Koffi Gnang, Richard Kerner, Luke Oeding, Joshua Grochow, Harm Derksen, Tali Beynon, Michel Rausch, Carlos Zapata-Carratalá*
- :youtube: [Wolfram Physics Project: Relations to Category Theory (2020)](https://www.youtube.com/watch?v=0LAtNXo9rbE) ; *Stephen Wolfram, Fabrizio Remano Genovese, Matteo Capucci, Jonathan Gorard, Tali Beynon*
- :youtube: :topos_institute: [All Concepts are Cat# (2023)](https://www.youtube.com/watch?v=_1-rueSZMGc) ; *David Spivak*
- :youtube: :topos_institute: [(Higher) category theory in Cat^# (2023)](https://www.youtube.com/watch?v=AKyHHykroWg) ; *Brandon Shapiro*
- :youtube: :topos_institute: [Abstraction Engineering with the Prototype Verification System (PVS) (2023)](https://www.youtube.com/watch?v=MHf07noO9KA) ; *Nat Shankar*
- :youtube: [Causal vs Acausal Modeling By Example: Why Julia ModelingToolkit.jl Scales (2023)](https://www.youtube.com/watch?v=ZYkojUozeC4) ; *Chris Rackauckas*
- :youtube: [Entropic Gravity, Black Holes, and the Holographic Principle | RP#159 (2023)](https://www.youtube.com/watch?v=TgQg1Oy37r0) ; *Erik Verlinde, Robinson Erhardt*
- :youtube: [Quantum Physics, the Multiverse, and Time Travel | RP #118 (2023)](https://www.youtube.com/watch?v=735mYcl3Lrg) ; *Slavoj Žižek, Sean Carroll, Robinson Erhardt*
- :youtube: :mindscape: [Mindscape 256 | Kelly & Zach Weinersmith on Building Cities on the Moon and Mars (2023)](https://www.youtube.com/watch?v=dJqr_cCi9tM) ; *Kelly & Zach Weinersmith, Sean Carroll*
- :youtube: [This Week's Finds 15: combinatorics, groupoid cardinality and species (2023)](https://www.youtube.com/watch?v=yLtgs7Fz8aw) ; *John Baez*
- :youtube: [This Week's Finds 14: the 3-strand braid group (2023)](https://www.youtube.com/watch?v=MnS4hduP5xg) ; *John Baez*
- :youtube: [Scales and Science Fiction with Biologist Michael Levin (2023)](https://www.youtube.com/watch?v=n15xS4YcyG0) ; *Michael Levin, Andrea Hiott*
- :youtube: :papers_we_love: [Delimited Continuations for Everyone (2017)](https://www.youtube.com/watch?v=QNM-njddhIw) ; *Kenichi Asai*
- :youtube: [Homotopy Type Theory 101 (2021)](https://www.youtube.com/watch?v=VMqF06fDljU) ; *Carlo Angiuli*
- :youtube: [From categorical systems theory to categorical cybernetics (2022)](https://www.youtube.com/watch?v=wtgfyjFIHBQ) ; *Matteo Capucci*
- :youtube: [The Search for the Perfect Door (2016)](https://www.youtube.com/watch?v=4YYvBLAF4T8) ; *Deviant Ollam*
- :youtube: :santa_fe_institute: [Evolving Brains: Solid, Liquid and Synthetic (2023)](https://www.youtube.com/watch?v=EIb5-LJbcIM) ; *Ricard Solé*

- :wikipedia: Wikipedia Articles: [AngelList](https://en.wikipedia.org/wiki/AngelList), [CodePen](https://en.wikipedia.org/wiki/CodePen), [Intel_GMA](https://en.wikipedia.org/wiki/Intel_GMA), [Joseph_Engelberger](https://en.wikipedia.org/wiki/Joseph_Engelberger)

---
# 2023, October - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Zenbleed (2023)](https://lock.cmpxchg8b.com/zenbleed.html) ; *Tavis Ormandy*
- [Downfall: Exploiting Speculative Data Gathering (2023)](https://downfall.page/media/downfall.pdf) ; *Daniel Moghimi*
- [Curry-Howard is overrated (2021)](https://blag.cedeela.fr/curry-howard-scam/) ; *Simon Cruanes*
- [Assembly theory explains and quantifies selection and evolution (2023)](https://www.nature.com/articles/s41586-023-06600-9) ; *Abhishek Sharma, Dániel Czégel, Michael Lachmann, Christopher P. Kempes, Sara I. Walker and Leroy Cronin*
- [Robots and Empire (1985)](https://en.wikipedia.org/wiki/Robots_and_Empire) ; *Isaac Asimov*

- :youtube: :strangeloop: :wasm: [Inside the Wizard Research Engine (2023)](https://www.youtube.com/watch?v=43ENxjq2Vhc) ; *Ben L. Titzer*
- :youtube: :strangeloop: :wasm: [IPVM: Seamless Services for an Open World (2023)](https://www.youtube.com/watch?v=Z5U8JQZXABs) ; *Brooklyn Zelenka*
- :youtube: :strangeloop: [Why Programming Languages Matter (2023)](https://www.youtube.com/watch?v=JqYCt9rTG8g) ; *Andrew Black*
- :youtube: :strangeloop: [We Really Don't Know How to Compute! (2011)](https://www.youtube.com/watch?v=HB5TrK7A4pI) ; *Gerald Sussman*
- :youtube: :strangeloop: [From Geometry to Algebra and Back Again: 4000 Years of Papers (2023)](https://www.youtube.com/watch?v=1cRFfYQYGxE) ; *Jack Rusher*
- :youtube: :strangeloop: [War Time Proofs and Futuristic Programs (2023)](https://www.youtube.com/watch?v=4_6uboxUYR8) ; *Valeria de Paiva*
- :youtube: :strangeloop: [The Economics of Programming Languages (2023)](https://www.youtube.com/watch?v=XZ3w_jec1v8) ; *Evan Czaplicki*
- :youtube: :strangeloop: [An approach to computing and sustainability inspired from permaculture (2023)](https://www.youtube.com/watch?v=T3u7bGgVspM) ; *Devine Lu Linvega*
- :youtube: :strangeloop: [Computational Physics, Beyond the Glass (2023)](https://www.youtube.com/watch?v=Jv2JgzAl5yU) ; *Sam Ritchie*
- :youtube: :strangeloop: [Cursorless: A spoken language for editing code (2023)](https://www.youtube.com/watch?v=NcUJnmBqHTY) ; *Pokey Rule*

- :youtube: [Automated Reasoning, SMT Solvers, Artificial Intelligence • YASP #2 (2023)](https://www.youtube.com/watch?v=RVjQkUI0kcw) ; *Clark Barrett*
- :youtube: [Modernizing Compiler Design for Carbon Toolchain - CppNow (2023)](https://www.youtube.com/watch?v=ZI198eFghJk) ; *Chandler Carruth*
- :youtube: :topos_institute: [Compositional Intelligence (2022)](https://www.youtube.com/watch?v=03ZPDyj8TtM) ; *Bob Coecke*
- :youtube: :mlst: [MLST - Observers (2023)](https://www.youtube.com/watch?v=6iaT-0Dvhnc) ; *Stephen Wolfram, Karl Friston and Keith Duggar*
- :youtube: :higher_order_company: [Higher Order Company - Origins of the HVM (2023)](https://www.youtube.com/watch?v=UQNNs77SpXA) ; *Victor Taelin*
- :youtube: [The Discovery of Zenbleed (2023)](https://www.youtube.com/watch?v=neWc0H1k2Lc) ; *Tavis Ormandy and Fabian Faessler (LiveOverflow)*
- :youtube: [The Ring 0 Facade Awakening the Processors Inner Demons (2018)](https://www.youtube.com/watch?v=XH0F9r0siTI) ; *Christopher Domas*
- :youtube: [reductio ad absurdum (2017)](https://www.youtube.com/watch?v=NmWwRmvjAE8) ; *Christopher Domas*
- :youtube: [Breaking the x86 Instruction Set (2017)](https://www.youtube.com/watch?v=KrksBdWcZgQ) ; *Christopher Domas*
- :youtube: [GOD MODE UNLOCKED - Hardware Backdoors in x86 CPUs (2018)](https://www.youtube.com/watch?v=_eSAF_qT_FY) ; *Christopher Domas*
- :youtube: [Grant Sanderson (3Blue1Brown) - Past, Present, & Future of Mathematics (2023)](https://www.youtube.com/watch?v=oDyviiN4NVo) ; *Grant Sanderson & Dwarkesh Patel*

- :youtube: :mindscape: [Mindscape 253 | David Deutsch on Science, Complexity, and Explanation (2023)](https://www.youtube.com/watch?v=ldgK7EhEnto) ; *David Deutsch and Sean Carroll*
- :criticalthinkingpodcast: [Critical Thinking - Episode 1: Introductions, Bug Bounty Reports, and BB Tips](https://www.criticalthinkingpodcast.io/episode-1-introductions-bug-bounty-reports-and-bb-tips/) ; *Joel Margolis and Justin Gardner*

- :wikipedia: Wikipedia Articles: [Alisa_Esage](https://en.wikipedia.org/wiki/Alisa_Esage), [Alyssa_Rosenzweig](https://en.wikipedia.org/wiki/Alyssa_Rosenzweig), [American_National_Standards_Institute](https://en.wikipedia.org/wiki/American_National_Standards_Institute), [André_Joyal](https://en.wikipedia.org/wiki/André_Joyal), [Battelle_Memorial_Institute](https://en.wikipedia.org/wiki/Battelle_Memorial_Institute), [Bug_bounty_program](https://en.wikipedia.org/wiki/Bug_bounty_program), [Bugcrowd](https://en.wikipedia.org/wiki/Bugcrowd), [Common_Weakness_Enumeration](https://en.wikipedia.org/wiki/Common_Weakness_Enumeration), [Complex_instruction_set_computer](https://en.wikipedia.org/wiki/Complex_instruction_set_computer), [Conference_on_Automated_Deduction](https://en.wikipedia.org/wiki/Conference_on_Automated_Deduction), [Coordinated_vulnerability_disclosure](https://en.wikipedia.org/wiki/Coordinated_vulnerability_disclosure), [Downfall_(security_vulnerability)](https://en.wikipedia.org/wiki/Downfall_(security_vulnerability)), [European_Space_Agency](https://en.wikipedia.org/wiki/European_Space_Agency), [European_Space_Research_and_Technology_Centre](https://en.wikipedia.org/wiki/European_Space_Research_and_Technology_Centre), [European_Union_Agency_for_the_Space_Programme](https://en.wikipedia.org/wiki/European_Union_Agency_for_the_Space_Programme), [Forum_of_Incident_Response_and_Security_Teams](https://en.wikipedia.org/wiki/Forum_of_Incident_Response_and_Security_Teams), [Freedesktop.org](https://en.wikipedia.org/wiki/Freedesktop.org), [Gerald_Jay_Sussman](https://en.wikipedia.org/wiki/Gerald_Jay_Sussman), [HackerOne](https://en.wikipedia.org/wiki/HackerOne), [HashiCorp](https://en.wikipedia.org/wiki/HashiCorp), [Igalia](https://en.wikipedia.org/wiki/Igalia), [Intel_Arc](https://en.wikipedia.org/wiki/Intel_Arc), [Intel_Xe](https://en.wikipedia.org/wiki/Intel_Xe)

- [Interactive_Theorem_Proving_(conference)](https://en.wikipedia.org/wiki/Interactive_Theorem_Proving_(conference)), [International_Conference_on_Automated_Reasoning_with_Analytic_Tableaux_and_Related_Methods](https://en.wikipedia.org/wiki/International_Conference_on_Automated_Reasoning_with_Analytic_Tableaux_and_Related_Methods), [International_Joint_Conference_on_Automated_Reasoning](https://en.wikipedia.org/wiki/International_Joint_Conference_on_Automated_Reasoning), [Isabelle_(proof_assistant)](https://en.wikipedia.org/wiki/Isabelle_(proof_assistant)), [Martin_Davis_(mathematician)](https://en.wikipedia.org/wiki/Martin_Davis_(mathematician)), [Max_Kelly](https://en.wikipedia.org/wiki/Max_Kelly), [Mitre_Corporation](https://en.wikipedia.org/wiki/Mitre_Corporation), [Netherlands_Space_Office](https://en.wikipedia.org/wiki/Netherlands_Space_Office), [OpenCL](https://en.wikipedia.org/wiki/OpenCL), [Pat_Gelsinger](https://en.wikipedia.org/wiki/Pat_Gelsinger), [Software_Freedom_Conservancy](https://en.wikipedia.org/wiki/Software_Freedom_Conservancy), [SPASS](https://en.wikipedia.org/wiki/SPASS), [Tavis_Ormandy](https://en.wikipedia.org/wiki/Tavis_Ormandy), [Tobias_Nipkow](https://en.wikipedia.org/wiki/Tobias_Nipkow), [Valeria_de_Paiva](https://en.wikipedia.org/wiki/Valeria_de_Paiva), [X.Org_Foundation](https://en.wikipedia.org/wiki/X.Org_Foundation), [YesWeHack](https://en.wikipedia.org/wiki/YesWeHack)


---
# 2023, September - [Fadi Shawki](https://orbitmines.com/profiles/fadi-shawki)

### Literary Exposure
- [Remembering Doug Lenat (1950–2023) and His Quest to Capture the World with Logic (2023)](https://writings.stephenwolfram.com/2023/09/remembering-doug-lenat-1950-2023-and-his-quest-to-capture-the-world-with-logic/) ; *Wolfram, Stephen*
- [ALEXANDRIA: Large-Scale Formal Proof for the Working Mathematician (2021)](https://lawrencecpaulson.github.io/2021/12/08/ALEXANDRIA.html) ; *Paulson, Lawrence C.*
- [The ALEXANDRIA Project: what has been accomplished? (2023)](https://lawrencecpaulson.github.io/2023/04/27/ALEXANDRIA_outcomes.html) ; *Paulson, Lawrence C.*
- [When is a computer proof a proof? (2023)](https://lawrencecpaulson.github.io/2023/08/09/computer_proof.html) ; *Paulson, Lawrence C.*
- [The End (?) of the ALEXANDRIA Project (2023)](https://lawrencecpaulson.github.io/2023/08/31/ALEXANDRIA_finished.html) ; *Paulson, Lawrence C.*
- [The Origins and Motivations of Univalent Foundations (2014)](https://www.ias.edu/ideas/2014/voevodsky-origins) ; *Voevodsky, Vladimir*
- [The Robots of Dawn (1983)](https://en.wikipedia.org/wiki/The_Robots_of_Dawn) ; *Asimov, Isaac*

- :youtube: [The Computer Algebra System of the Future (2023)](https://www.youtube.com/watch?v=k1VvJFjIo7k) ; *Lynch, Owen*
- :youtube: [Entropy and Energy (2023)](https://www.youtube.com/watch?v=_sVFZv9tYdA) ; *Lynch, Owen*
- :youtube: [Algebraic Theories and Computer Algebra (2023)](https://www.youtube.com/watch?v=hsgxoLEzLyo) ; *Lynch, Owen*
- :youtube: [Applied Category Theory (2023)](https://www.youtube.com/watch?v=tfiour4xJ7o) ; *Baez, John C.*
- :youtube: [What A General Diagonal Argument Looks Like (Category Theory) (2022)](https://www.youtube.com/watch?v=dwNxVpbEVcc) ; *@Thricery*
- :youtube: [Topology, Categories, and the Future of Mathematics (2021)](https://www.youtube.com/watch?v=PfAENWzgIes) ; *Riehl, Emily*
- :youtube: [Infracalculus: Beyond Discrete and Continuous? (I) (2023)](https://www.youtube.com/watch?v=CY9ZwYiftxA) ; *Gorard, Jonathan and Zapata, Carlos*
- :youtube: [Infrageometry: Beyond Discrete and Continuous? (II) (2023)](https://www.youtube.com/watch?v=93ZZFGYltgM) ; *Gorard, Jonathan and Zapata, Carlos*
- :youtube: [Infrageometry: Beyond Discrete and Continuous? (III) (2023)](https://www.youtube.com/watch?v=NdlDlcK78_g) ; *Gorard, Jonathan & Zapata, Carlos & Bajaj, Utkarsh*
- :youtube: [What is Lie theory? (2023)](https://www.youtube.com/watch?v=ZRca3Ggpy_g) ; *@Mathemaniac*
- :youtube: [Benedikt Ahrens - Univalent Foundations and the UniMath library (2023)](https://www.youtube.com/watch?v=-Hc1uP5UChw) ; *Ahrens, Benedikt*
- :youtube: [The mathematical work of Vladimir Voevodsky (2018)](https://www.youtube.com/watch?v=BanMgvdKP8E) ; *Grayson, Dan*
- :youtube: [HoTT Lecture 1: Dependent types and dependent functions -- HoTTEST Summer School 2022 (2022)](https://www.youtube.com/watch?v=HvYYCHMeM-8) ; *North, Paige*
- :youtube: [The Craft of Writing Effectively (2014)](https://www.youtube.com/watch?v=vtIzMaLkCaM) ; *McEnerney, Larry*
- :youtube: ["The new era of formalised mathematics and the ALEXANDRIA Project" (2022)](https://www.youtube.com/watch?v=084UXiJvFfY) ; *Angeliki Koutsoukou Argyraki*

- :wikipedia: Wikipedia Articles:  [Agda_(programming_language)](https://en.wikipedia.org/wiki/Agda_(programming_language)), [Augmented_Backus–Naur_form](https://en.wikipedia.org/wiki/Augmented_Backus–Naur_form), [Automated_reasoning](https://en.wikipedia.org/wiki/Automated_reasoning), [Backus–Naur_form](https://en.wikipedia.org/wiki/Backus–Naur_form), [Bun_(software)](https://en.wikipedia.org/wiki/Bun_(software)), [CADE_ATP_System_Competition](https://en.wikipedia.org/wiki/CADE_ATP_System_Competition), [Calculus_of_constructions](https://en.wikipedia.org/wiki/Calculus_of_constructions), [Christine_Paulin-Mohring](https://en.wikipedia.org/wiki/Christine_Paulin-Mohring), [Coinduction](https://en.wikipedia.org/wiki/Coinduction), [Compiler-compiler](https://en.wikipedia.org/wiki/Compiler-compiler), [Compiler](https://en.wikipedia.org/wiki/Compiler), [Computer-assisted_proof](https://en.wikipedia.org/wiki/Computer-assisted_proof), [Confluence_(abstract_rewriting)](https://en.wikipedia.org/wiki/Confluence_(abstract_rewriting)), [Conor_McBride](https://en.wikipedia.org/wiki/Conor_McBride), [Coq](https://en.wikipedia.org/wiki/Coq), [Corrado_Böhm](https://en.wikipedia.org/wiki/Corrado_Böhm), [Damien_Doligez](https://en.wikipedia.org/wiki/Damien_Doligez), [DataCite](https://en.wikipedia.org/wiki/DataCite), [David_E._Kaplan_(physicist)](https://en.wikipedia.org/wiki/David_E._Kaplan_(physicist)), [David_Spivak](https://en.wikipedia.org/wiki/David_Spivak), [Decompiler](https://en.wikipedia.org/wiki/Decompiler), [Dependent_type](https://en.wikipedia.org/wiki/Dependent_type), [Digital_object_identifier](https://en.wikipedia.org/wiki/Digital_object_identifier), [Douglas_Lenat](https://en.wikipedia.org/wiki/Douglas_Lenat), [Emily_Riehl](https://en.wikipedia.org/wiki/Emily_Riehl), [Erik_Meijer_(computer_scientist)](https://en.wikipedia.org/wiki/Erik_Meijer_(computer_scientist)), [European_Congress_of_Mathematics](https://en.wikipedia.org/wiki/European_Congress_of_Mathematics), [European_Cooperation_in_Science_and_Technology](https://en.wikipedia.org/wiki/European_Cooperation_in_Science_and_Technology), [European_Mathematical_Society](https://en.wikipedia.org/wiki/European_Mathematical_Society), [Extended_Backus–Naur_form](https://en.wikipedia.org/wiki/Extended_Backus–Naur_form), [Fastly](https://en.wikipedia.org/wiki/Fastly), [Formal_verification](https://en.wikipedia.org/wiki/Formal_verification), [French_Institute_for_Research_in_Computer_Science_and_Automation](https://en.wikipedia.org/wiki/French_Institute_for_Research_in_Computer_Science_and_Automation), [Geoff_Sutcliffe](https://en.wikipedia.org/wiki/Geoff_Sutcliffe), [Georges_Gonthier](https://en.wikipedia.org/wiki/Georges_Gonthier), [Gérard_Huet](https://en.wikipedia.org/wiki/Gérard_Huet), [Harry_Coonce](https://en.wikipedia.org/wiki/Harry_Coonce), [History_of_compiler_construction](https://en.wikipedia.org/wiki/History_of_compiler_construction), [Ilyas_Khan](https://en.wikipedia.org/wiki/Ilyas_Khan), [Inductive_type](https://en.wikipedia.org/wiki/Inductive_type), [International_Brain_Research_Organization](https://en.wikipedia.org/wiki/International_Brain_Research_Organization), [International_Centre_for_Mathematical_Sciences](https://en.wikipedia.org/wiki/International_Centre_for_Mathematical_Sciences), [International_Conference_on_Functional_Programming](https://en.wikipedia.org/wiki/International_Conference_on_Functional_Programming), [International_Council_for_Industrial_and_Applied_Mathematics](https://en.wikipedia.org/wiki/International_Council_for_Industrial_and_Applied_Mathematics), [Isaac_Newton_Institute](https://en.wikipedia.org/wiki/Isaac_Newton_Institute), [Jasmin_Blanchette](https://en.wikipedia.org/wiki/Jasmin_Blanchette), [Jeremy_Avigad](https://en.wikipedia.org/wiki/Jeremy_Avigad), [John_Backus](https://en.wikipedia.org/wiki/John_Backus), [JSON-LD](https://en.wikipedia.org/wiki/JSON-LD), [KAIST](https://en.wikipedia.org/wiki/KAIST)


- [Kevin_Buzzard](https://en.wikipedia.org/wiki/Kevin_Buzzard), [Lawrence_Paulson](https://en.wikipedia.org/wiki/Lawrence_Paulson), [Lean_(proof_assistant)](https://en.wikipedia.org/wiki/Lean_(proof_assistant)), [Machine_Intelligence_Research_Institute](https://en.wikipedia.org/wiki/Machine_Intelligence_Research_Institute), [Marijn_Heule](https://en.wikipedia.org/wiki/Marijn_Heule), [Mathematics_Genealogy_Project](https://en.wikipedia.org/wiki/Mathematics_Genealogy_Project), [Meta-circular_evaluator](https://en.wikipedia.org/wiki/Meta-circular_evaluator), [ML_(programming_language)](https://en.wikipedia.org/wiki/ML_(programming_language)), [Neri_Oxman](https://en.wikipedia.org/wiki/Neri_Oxman), [Niklaus_Wirth](https://en.wikipedia.org/wiki/Niklaus_Wirth), [Nima_Arkani-Hamed](https://en.wikipedia.org/wiki/Nima_Arkani-Hamed), [Nobuo_Yoneda](https://en.wikipedia.org/wiki/Nobuo_Yoneda), [Normal_form_(abstract_rewriting)](https://en.wikipedia.org/wiki/Normal_form_(abstract_rewriting)), [Obsidian_(software)](https://en.wikipedia.org/wiki/Obsidian_(software)), [OCaml](https://en.wikipedia.org/wiki/OCaml), [OOPSLA](https://en.wikipedia.org/wiki/OOPSLA), [ORCID](https://en.wikipedia.org/wiki/ORCID), [Owl_Scientific_Computing](https://en.wikipedia.org/wiki/Owl_Scientific_Computing), [Peter_Aczel](https://en.wikipedia.org/wiki/Peter_Aczel), [Peter_Naur](https://en.wikipedia.org/wiki/Peter_Naur), [Philippa_Gardner](https://en.wikipedia.org/wiki/Philippa_Gardner), [Powerset_construction](https://en.wikipedia.org/wiki/Powerset_construction), [Programming_Language_Design_and_Implementation_(conference)](https://en.wikipedia.org/wiki/Programming_Language_Design_and_Implementation_(conference)), [Proof_assistant](https://en.wikipedia.org/wiki/Proof_assistant), [Proof_compression](https://en.wikipedia.org/wiki/Proof_compression), [QED_manifesto](https://en.wikipedia.org/wiki/QED_manifesto), [Quantinuum](https://en.wikipedia.org/wiki/Quantinuum), [Royal_Dutch_Mathematical_Society](https://en.wikipedia.org/wiki/Royal_Dutch_Mathematical_Society), [Samuel_Eilenberg](https://en.wikipedia.org/wiki/Samuel_Eilenberg), [Saunders_Mac_Lane](https://en.wikipedia.org/wiki/Saunders_Mac_Lane), [Savas_Dimopoulos](https://en.wikipedia.org/wiki/Savas_Dimopoulos), [SIGPLAN](https://en.wikipedia.org/wiki/SIGPLAN), [SPLASH_(conference)](https://en.wikipedia.org/wiki/SPLASH_(conference)), [Stephen_Schanuel](https://en.wikipedia.org/wiki/Stephen_Schanuel), [Structural_induction](https://en.wikipedia.org/wiki/Structural_induction), [Symposium_on_Logic_in_Computer_Science](https://en.wikipedia.org/wiki/Symposium_on_Logic_in_Computer_Science), [Symposium_on_Principles_of_Programming_Languages](https://en.wikipedia.org/wiki/Symposium_on_Principles_of_Programming_Languages), [Thierry_Coquand](https://en.wikipedia.org/wiki/Thierry_Coquand), [Thomas_Callister_Hales](https://en.wikipedia.org/wiki/Thomas_Callister_Hales), [Thousands_of_Problems_for_Theorem_Provers](https://en.wikipedia.org/wiki/Thousands_of_Problems_for_Theorem_Provers), [Translational_Backus–Naur_form](https://en.wikipedia.org/wiki/Translational_Backus–Naur_form), [William_Lawvere](https://en.wikipedia.org/wiki/William_Lawvere), [Xavier_Leroy](https://en.wikipedia.org/wiki/Xavier_Leroy)

![[Pasted image 20231001004505.png]]

