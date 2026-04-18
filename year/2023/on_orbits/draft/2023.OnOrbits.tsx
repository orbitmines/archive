import React from 'react';
import Paper, {
  Arc,
  Author,
  BR,
  Footnote,
  Organization,
  PaperView,
  Reference,
  ReferenceProps,
  Section,
  Subtitle,
  Title,
  useCounter,
  Link,
  TODO
} from "../../lib/pdf/paper/Paper";
import fadishawki, {Socials} from "../../lib/profiles/fadishawki";
import logo from "../../lib/images/orbitmines/logo/orbitmines.logo.3000x1000.png";
import JetBrainsMono from "../../lib/font/fonts/JetBrainsMono/JetBrainsMono";
import {Col, Row} from '../../lib/layout/flexbox';
import {Divider, H3, Icon, Intent, Tag} from "@blueprintjs/core";
import {ON_INTELLIGIBILITY} from "./2022.OnIntelligibility";
import CodeBlock from "../../lib/syntax-highlighting/CodeBlock";
import Children from "../../lib/typescript/Children";
import CustomIcon from "../../lib/icons/CustomIcon";
import brands from "../../lib/external/brands";
import _ from "lodash";
import {useNavigate} from "react-router-dom";

export const HUTTER_PRIZE: ReferenceProps = {
  title: "Hutter Prize",
  author: "Hutter, Marcus",
  link: "https://en.wikipedia.org/wiki/Hutter_Prize",
};

const OnOrbits = () => {
  const navigate = useNavigate();

  const referenceCounter = useCounter();

  const OnIntelligibilityReference = <Reference is="reference" index={referenceCounter()} {...ON_INTELLIGIBILITY.reference} />;
  const HutterPrizeReference = <Reference is="reference" index={referenceCounter()} inline {...HUTTER_PRIZE} simple />;
  const WebAssemblyReference = <Reference is="reference" index={referenceCounter()} title="WebAssembly" link="https://webassembly.github.io/spec/core/_download/WebAssembly.pdf" simple inline />;

  const WebAssemblyBinaryReference = <Reference is="reference" index={referenceCounter()} title="binary" link="https://webassembly.github.io/spec/core/binary/index.html" simple inline />;

  const WebAssemblyTextualReference = <Reference is="reference" index={referenceCounter()} title="textual" link="https://webassembly.github.io/spec/core/text/index.html" simple inline />;

  const draft = true;

  //  TODO: Section header reference not found by footnote

  const socials: Socials = _.pickBy(fadishawki, (value, key) => [
    brands.github.key,
    brands.twitter.key,
    brands.discord.key,
  ].includes(key));

  return <Paper view={PaperView.Browser} pdf={{
    fonts: [ JetBrainsMono ],
  }}>
    <Title>On Observers, Recursion, Boundedness, Ignorance and Transformations</Title>
    {/*<Title>On Observers, Recursion/Reference, Boundedness, Ignorance/Irreversibility and Transformation/Time</Title>*/}
    {/*<Title>On Equivalence, Observers and Compression</Title>*/}
    {/*<Title>On Equivalence and Uncertainty</Title>*/}
    {/*<Title>On (Functional) Equivalence, Observers and Compression</Title>*/}

    <Subtitle>A continuation of earlier thoughts on intelligibility {OnIntelligibilityReference}. An attempt to formalize a set of complex assumptions as an approach to understand arbitrarily unknown dynamical systems. Demonstrated by the generation of a {HutterPrizeReference} submission (enwik9 in XMB|x86_64-linux (+X% improvement)).</Subtitle>

    <Row center="xs" middle="xs" className="child-px-20">
      <Col>
        <Organization name="OrbitMines Research" logo={logo} />
      </Col>
      <Col className="hidden-xs hidden-sm hidden-md">
        <Divider style={{height: '80px'}}/>
      </Col>
      <Col>
        <Author
          title={<a onClick={() => navigate("/profiles/fadi-shawki")}>Fadi Shawki</a>}
          subtitle={<a href="mailto:fadi.shawki@orbitmines.com" target="_blank">fadi.shawki@orbitmines.com</a>}
          socials={socials}
        />
      </Col>
    </Row>

    <Row center="xs" middle="xs" className="child-px-10">
      <Col>
        <H3 className="m-0">June, 2023</H3>
      </Col>
      {draft ? <Col>
        <Tag intent={Intent.DANGER} minimal style={{fontSize: '1.1rem'}}>DRAFT</Tag>
      </Col> : <></>}
    </Row>

    <Row center="xs">
      <Divider style={{width: '80%'}}/>
    </Row>
    <Row/>

    <Row center="xs">
      {/* If perceived is not perfectly the same as that thing in any dimension: arbitrary uncertain things happen (this arbitraryness can be better understood somehow? */}

      <Section head="Abstract">
        This paper can be considered as four (somewhat) separable arcs: (1) A (perhaps) more theoretical side expressing a set of complex assumptions. Mainly concerned with issues of equivalence, ignorance, inconsistencies, ..., abstractions. (2) Using these assumptions, a strategy for representing abstractions (; hypergraphs) is discussed, as a more explicit way to represent multidimensional encodings of programs. (3) Using this strategy, the assumptions of {WebAssemblyBinaryReference}, {WebAssemblyTextualReference} and abstract {WebAssemblyReference} are modelled and then encoded in WebAssembly. (4) And last, these assumptions are then used to rephrase the {HutterPrizeReference} to a search problem in possible-webassembly-program-space and the journey of finding a solution is described.
      </Section>
    </Row>

    <Arc head="Arc I: A set of complex (theoretical) Assumptions">
      <Section head="A disclaimer" sub="From a perspective of Conceptual Uncertainty">
        In some sense, several aspects of this paper could be considered as generalizations of many ideas I've exposed myself to. In a struggle to understand their inconsistencies, I believe I found a proper language to do so.

        <BR/>


      </Section>
      <Section head="On Time" sub="Some [seeming non-trivial (perceived)] Directionality">

      </Section>
      <Section head="On Persistence" sub="Some [seeming non-trivial (perceived)] Directional-Invariance">

      </Section>
    </Arc>

    <Arc head="Arc II: Hypergraph interface (for humans)">
      <Link link="https://github.com/orbitmines/explorer" icon={brands.github.key}/>

    </Arc>

    <Arc head="Arc III: WebAssembly's Assumptions">
      <Link link="https://github.com/orbitmines/wasm" icon={brands.github.key}/>

      <Section head="A broader perspective: Why WebAssembly?">

      </Section>

      <Section head={<>
        <Reference is="reference" index={referenceCounter()} title="LEB128" link="https://en.wikipedia.org/wiki/LEB128" simple inline />, Little Endian Base 128 encoding
      </>}>
        <TODO> </TODO>
      </Section>
      <Section head={<>
        <Reference is="reference" index={referenceCounter()} title="Unicode" link="https://www.unicode.org/versions/latest/" simple inline />, UTF-8 encoding
      </>}>
        <TODO> </TODO>
      </Section>
      <Section head={<>
        <Reference is="reference" index={referenceCounter()} title="IEEE 754" link="https://ieeexplore.ieee.org/document/8766229" simple inline journal="IEEE Std 754-2019 (Revision of IEEE 754-2008)" year="2019" page="1-84" />, Floating-Point Arithmetic
      </>}>
        <TODO> </TODO>
      </Section>
    </Arc>

    <Arc head="Arc IV: Finding a solution to the Hutter Prize">
      <Link link="https://github.com/orbitmines/enwik9" icon={brands.github.key}/>

      <Section head={<>Rephrasing the {HutterPrizeReference} as a {WebAssemblyReference} search problem</>}>
        <TODO> </TODO>
      </Section>
      <Section head="Some useful set of ignorances for the search">

        <TODO> </TODO>
      </Section>
    </Arc>

    <Arc head="Wrapping up">
    </Arc>

    <Row center="xs">
      <Section head="Conceptual Uncertainty">
        It seems inconceivable that forming these assumptions, at the very least initially, bring with them a certain circularity. For its assumptions, in their seeming generality, will directly also apply to humans; and thus myself. A form of uncertain caution seems appropriate: especially since its arguments are abstract and are initially conceived from a perspective which is bound to have certain ignorances the provided theory is hoping to tackle (; or understand). But self-referentially, it renders itself to a similar uncertain scrutiny.

        <CodeBlock code=".. self-referential uncertainty : conceptual uncertainty"/>

        <BR/>

        As such, better understanding of interpretation, whether deemed misinterpretation or not perfectly coherent but seemingly practical, is an expected goal. Note that this goal is vague and self-referential; this interpretation and expected interpretation of itself is likely to be volatile/chaotic. Similarly I'd expect better understanding of abstractness; its practical-ness and seemingly inherent danger. Another goal would be giving better grounding for these assumptions: While their abstractness could render them as not falsifiable, this doesn't necessarily mean they cannot be understood: their impact and their (perhaps) conditional correctness.

        <CodeBlock code=".. "/>

        <BR/>

        A less vague interpretation might be that this is merely a practical approach to a complex problem; and I might as well take that stance. The assumptions expressed in this paper can be considered as perceived impossibilities I currently cannot see a way around.

        <BR/>

        Similarly, whilst I try explicitly mentioning the assumptions, through uncertainty one is able to define potential latent (hidden) assumptions. Which is a reference carried forward in time with the potential to modify any particular assumption.

        <BR/>

        <CodeBlock code=".. uncertainty within the assumptions"/>

        <BR/>

        A general argument after each assumption might be the following: However (un)intuitive it might seem, it may be possible to conceive of some seemingly contradictory system in which any abstract notion of this assumption wouldn't make sense. Practically, one might dismiss such a notion due to its seeming contradictions, but nevertheless if it can persist in an observer it should spike curiosity as to how it persists and its possible influences, and whether one can identify parts which one might interact with.

        <BR/>

        {/*
        If one refutes this assumption of directionality, or any aspect of boundedness, however local, temporal, ... spacial. This refutation can be represented with
*/}
        <TODO>Always end each assumption with how they can be refuted?</TODO>

        <BR/>

        <CodeBlock code=".. implications of deeming an assumption as refuted"/>

        <BR/>

        Perhaps the (best) argument to be made against this theory is that its line of reasoning seems unfair/incoherent: for claims to abstraction would allow one to map it to any possible conceptualization. This would likely be constructed through its self-reference or its claims that in the extreme consistency seems to lie in the space of impossibilities. An argument I would probably make following any abstraction or assumption.

        <BR/>

        Thus, allow me to demonstrate why I deem coherence to be futile, how to construct it, and how I can then say coherence is not futile.

      </Section>

      <Section head="Time: Seeming non-trivial (perceived) directionality and implied Boundedness">
        A permeating assumption among all (perhaps hidden) assumptions is that of time. Not necessarily any particular perception or conceptualization of time, but a more abstract one: A subtle notion within concepts like computation, functions, dynamics, process, systems, change, ... transformations. While they might not necessarily be describing a system with a temporal dimension, their very conceptualization is one which one could equate to this abstract notion of time.

        <BR/>

        A practical take on this might be the following: While one can abstractly construct systems which are ignorant of time, their very conceptualization is describing a form of time, and the simplifications can be incredibly useful [footnote on mathemetics?].
        <BR/>

        <BR/>

        Some directionality, some dimensionality, already seems to indicate a form of boundedness, if not in the extreme, then at least at some level of description: locally, temporally, ..., spatially: a limitation <Footnote is="footnote"  index={referenceCounter()}>This limitation might again only hold up in a certain reference frame.</Footnote>.

        <CodeBlock code="...time"/>

        Whereas an abstract directionality doesn't necessarily distinguish between seemingly infinitely growing systems, further (perceived) boundedness, might.

        <BR/>

        One can separate this directionality assumption quite nicely from that of persistence.

        <BR/>

      </Section>
      <Section head="Persistence: Seeming non-trivial (perceived) directional-invariance">
        The abstract idea of persistence is quite straight-forward: In some directionality, the 'next step' as it were, non-trivially limits access to the previous 'steps'. Note that this doesn't necessarily make any claims to 'causality' (at any level of description <Footnote is="footnote" index={referenceCounter()}>Although, this assumption could be causality's building block.</Footnote>), merely that previous states aren't perfectly preserved <Footnote is="footnote"  index={referenceCounter()}>A curious thought experiment one might perform is that of accessing previous states as a non-interacting observer without the need of memory - other than having to persist the particulars which would allow for this - which would require memory (; non-trivial persistence).</Footnote>.

        <BR/>

        Hence, one should view this assumption as a further extension on that of directionality (time).

        <CodeBlock code="...persistence"/>

        Following from the assumptions of time and associated non-trivial persistence, one can start constructing additional assumptions. Always with a certain underlying connotation of: "If some non-trivial part persists".

        <BR/>

        One can, abstractly, construct systems which are 'free/ignorant' of some directionality (; time), at least internally in its definition. Building on the previous assumption of persistence, from this perspective this would be deemed an ignorant one: We currently perceive it as impossible to actually separate that system from time. No necessary conclusions need to be drawn as to its usefulness nor correctness: If it can persist, that is enough for this assumption.

        <CodeBlock code="...systems definition ignorant of internal time"/>

        And hence, we can make the following statement: Whether the perceived system internally recognizes a temporal dimension or not, is not necessarily obviously relevant to its persistence. Patterns (; abstractions), however implemented just as they can be non-trivially discovered, can be non-trivially forgotten <Footnote is="footnote" index={referenceCounter()}>Which may be a way of saying that all knowledge, ..., structure, is inherently unstable: Some parts might be easy to rediscover, some might not be.</Footnote>.

        <CodeBlock code="...systems ignorant of time is forgotten through actualities"/>

        Certainly, in the face of non-trivial boundedness, strategies for persistence at any level of description is a perceived necessity if those levels of description are to persist. Among non-obvious candidates the strategy of expected re-discoverability is one which deserves additional mention. Patterns expected to be easily re-discoverable under boundedness would likely experience less pressure as to explicitly be preserved: Such an expectation, as a predication is an assumption however, and the mode of rediscovering subject to being forgotten (and then perhaps re-discovered) itself.

        <CodeBlock code="...(re-)discoverability"/>

      </Section>
      <Section head="Ignorance: Constructing Abstractions, Separability, Encapsulation, Transduction, Inconsistencies and operating under Arbitrary Unknowns">
        <TODO>Some quick reference on using the word ignorance?</TODO>

        When one invokes some abstraction, conceptualization, pattern, assumption, prediction, infinity, ..., level of description like 'equivalence' without additional context; One invokes a certain generality <Footnote is="footnote" index={referenceCounter()}>Which could perhaps be phrased as: in some directionality there is a lurking infinity.</Footnote>. By doing so, one is giving the question a certain unanswerable property, which is perhaps a non-trivial necessity for all concepts. A perhaps more practical approach is saying conceptually, one will always be able to point out ways in which something is not equivalent, if only by observation, relative location, possible persistence, unknown differences, ..., time {OnIntelligibilityReference}. And thus how something seems to be equivalent under specific contexts and whether that is deemed appropriate, seems the relevant thing to an observer <Footnote is="footnote" index={referenceCounter()}>A way to understand this concept is that of two perfectly identical things, being observed by two different observers/observations, will in the abstract have different consequences and are thus in the extreme, not equivalent. Hence, the notion of 'two perfectly identical things', is a seemingly incorrect notion, as they are not perfectly identical, in the directionality of observation/interaction. (However fleeting or long-lasting those interactions are)</Footnote>.

        <BR/>

        This brings us to a seemingly critical concept of abstraction. Importantly how it is implemented by this theory: I am currently bounded by a level of description which will only allow me to setup this theory in an inherently quantized (; discrete) way. However (un)intuitive the notion, if the construction of something actually infinite in any particular directionality (; or in its extreme in any possible direction) is possible <Footnote is="footnote" index={referenceCounter()}>Or already implicitly achieved through arbitrary properties of this quantized construction which are not yet understood by this theory: Importantly, as demonstrated later, it does allow for this possibility through a similar statement of that of conceptual uncertainty.</Footnote>, I do not know how <Footnote is="footnote" index={referenceCounter()}>I suspect that either can be constructed from the other, conceptually, if either is possible.</Footnote>. It is much easier to suggest that these notions can be constructed through bounded constructs, and seemingly not necessary for practicality.

        <BR/>

        <CodeBlock code="...bounded in some directionality (already indicated by time, and others)"/>

        <BR/>

        {/*A different way of phrasing this, is that an observer implies additional directionalities alongside the one of time, which signal additional limitations.*/}

        {/*A different way of phrasing this, is that in addition to some boundedness implied by our assumption of time, further bounding is implied by the level of description some observer is operating under.*/}

        {/*Like the boundedness*/}
        Since one assumes boundedness, we start off by constructing a level of description which perceives some arbitrarily complex structure as a single (; discrete) thing. Like boundedness indicated by time, This already, like directionality, implies boundedness at some level of description: already signals a limitation, and not infinite in its extreme.

        <CodeBlock code="Node: (..)"/>

        A recurring notion around (at least human) observers is that of representations, interpretations: separability. While such notions often seem practical, at least to a human, in their extreme they don't necessarily seem that different, apart from how they are indeed, interpreted <Footnote is="footnote" index={referenceCounter()}>Note that 'interpreted' might as well be replaced with the 'interacted'. Where 'interpreted' places more emphasis on modelling something else.</Footnote>.

        <BR/>
        <CodeBlock code="...anything can be interpreted as anything (no arity..)"/>

        <BR/>

        This is more accurately portrait by the following: If interaction (; communication, ..., interpretation) is possible however non-trivially, then assuming separability in every possible directionality (; or saying in their extreme that they are not connected), seems fallible.

        <BR/>
        <CodeBlock code="...either actually separate, or enforced "/>
        <BR/>

        It is much more trivial to suggest how such things might be influencing observers, despite their abstract inconsistency. Certainly, in the abstract, one can say that the interpretations of their seeming differences, or representations can have influence on observers. That alone suggests something of interest to an inquiring observer, which can perhaps be understood. A simple indication of this might be found in ideas of tautology (; equivalence). Even if a certain non-trivial equivalence relationship is realized by the observer, it seems trivial to suggest that even then it might have a different influence on the observer, however seemingly fleeting that may be.

        <BR/>

        Hence, permeating ideas of uncertainty include the possibility of persisting inconsistencies, internally within the manipulations of abstractions, ..., or in the constructed assumptions. Note that since they persist their influence would be non-trivial: It's not necessary to abstractly construct its perceived (non-)usefulness for this assumption. If they can persist their influence and possible usefulness may be understood.

        <BR/>
        <CodeBlock code="...influence on observers (seeming incoherence?)"/>
        <BR/>

        From the previous assumptions the definition of an abstraction is then seemingly trivial: Some imagined non-trivial directionality which is merely deemed as periodic; as an imagined perfect orbit which keeps happening. (; or: It is going in this direction, and will simply keep going in this direction) The directionality doesn't have to be trivial. The correctness of the imagined space for the direction doesn't need to be valid. The correctness of the orbit doesn't need to be valid. There is no need to construct its usefulness. If it can be constructed and can persist however fleetingly, that is enough for this assumption.

        <CodeBlock code="...imagined structure simply said to be repeating (in some context)"/>

        {/* direction: movement, space: context, keeps happnening: permeating assumption of time (sepaarbility says space &context is not really different in some senes?)*/}

        From that frame, one could define 'ignorance' as defining the direction in which something seems equivalent (in that directionality) to the observer. Thus resulting from this is that an idea like self-reference can only be maintained abstractly by ignoring aspects which would make each iteration of self-reference different <Footnote is="footnote" index={referenceCounter()}>Again, under the assumption of possible actual infinities beyond their conception in this bounded way.</Footnote>.

        <CodeBlock code="...self-reference through ignorance"/>

        Hence a more generalized variant of this: Considering some directionality and abstractions, we can construct abstractions which are ignorant of that directionality: This allows one to create an abstraction of indirection, from direction, ..., of infinity from finity, of invariance from variance <Footnote is="footnote" index={referenceCounter()}>Note that this is a frame of reference from some form of boundedness: The reverse might be possible if one doesn't take this view.</Footnote>.

        <CodeBlock code="...indirectionality from directionality"/>

        In the abstract, it seems that such a thing is always merely a matter of perception. Their seeming complexity, their associated ignorances, seem entirely dependant on the observer and their particulars. Similar to my phrasing of conceptual uncertainty. Another example of this might be the following: It may be possible that there are actualities which in their extreme happen simultaneously.

        <CodeBlock code="...in some infinite directionality actuality"/>

        Nonetheless, abstractly, we can always <Footnote is="footnote" index={referenceCounter()}>Note that references to 'always' assume consistency and indicate more circularity within abstractions.</Footnote> make the argument of separating their simultaneity and assume them as not happening simultaneously (; or assuming some variance).

        <BR/>
        <CodeBlock code="...separate directionality"/>
        <BR/>

        Similarly, one might also do the opposite and assume simultaneity where there was none (; or assuming some invariance):

        <BR/>
        {/* Any variance perceived as invariance when defined at a frame, */}
        <CodeBlock code="...assume indirection"/>
        <BR/>

        Such ignorance, doesn't necessarily have to influence the internal structure of the abstract definitions (nor necessarily takes away at their usefulness). However, if this idealization of the abstract structure is violated due to something arbitrarily unknown and is not corrected for, its persistence could be non-trivially altered. Note that it then wouldn't entirely be obvious what would happen to its persistence from the frame that is the description. Non-trivially parts might persist and may continue to have influence, ..., non-trivially this perception of a fidelity error may make possible seemingly arbitrary complexity. To demonstrate this complexity, one might leap from here to draw an analogy between vulnerabilities in systems, ..., (evolutionary) biology <Footnote is="footnote" index={referenceCounter()}>This is merely to demonstrate the concept, its abstract leap will need to be constructed by framing biology in this system of assumptions.</Footnote>.

        <BR/>
        <CodeBlock code="...forgetting is relevant for perceived structure (perceived coherence)"/>
        <BR/>

        This idea, which permeates this paper, could probably be seen as a more general form of renormalization [ref], coarse-graining [ref] and similar ideas. Which brings one to another continuation on boundedness: unknowns.

        <BR/>

        This is perhaps best demonstrated by ideas of (mechanistic) interpretability, reproducibility, fidelity, ..., reverse engineering. Abstractly, it would be ignorant to assume that full predictability, full understanding of even the simplest of systems could be achieved. For one makes a prediction by assuming consistency ; one which may have a possibility of being violated. This is formulated this way, to demonstrate a seeming fallibility/.../view of abstractions (; assuming some directionality as infinite), despite its usefulness. Again, this assumption, might in return be violated by the interaction of something with an infinite directionality, but as a basis for this theory I only know how to get there through abstraction: assuming an infinity <Footnote is="footnote" index={referenceCounter()}>One could leap from here to reference how this might influence (a human) observer, but initially I find that not to be awfully practical until a better understanding of this is reached. Or: it's much more practical or seemingly obvious to operate from a position of (some-level-of-description-local-) boundedness and necessary assumptions and ignorances in predictions.</Footnote>.

        <BR/>

        Practically, this would indicate that independent of the level of description one initially operates under, that one will be dealing with unknown underlying implementations of abstractions, and that it is perhaps not initially necessary for understanding. Certainly, the specific implementations would have different kinds of unknown limitations, but those would have to be discovered or remain ignored. Thus, one assumes, abstractly, that any particular interaction, ..., state, is perceived to be inherently non-trivially mutable (; and following from that is that one's level of description itself, is thus mutable), and that immutability in any particular directionality is perceived to only be achievable through ignorance, and only locally, ..., spatially, (assuming some ...) temporally immutable. (; might be possible to actually be immutable in certain directionalities, but how could this be certain??)

        <CodeBlock code="...inherently mutable, immutability of node, achievable through ignorance"/>

        Hence, abstractly, while at a level of description one can define different possible ways to interact with any particular node, one assumes that the level of description is inherently flawed, and that all possible ways of interaction are not realized, nor could even be described by this level of description.

        <CodeBlock code="...coarse-grained node"/>

        From here one could claim some form of transformation-conservation holding certain symmetries, but this leap doesn't necessarily seem that obvious to me in every directionality, certainly not so within an abstract definition. But practically, I'd guess that this is easier to encode in a form of permeating uncertainty. This particular thought is somewhat peculiar, and likely better formulated through arguments of compression, ..., fidelity: persisting structures otherwise forgotten whose rediscoverability is not entirely obvious. Which at some level of description seems a necessity when one assumes some form of boundedness: The assumption that some seemingly low-entropy description can be more easily preserved.

        <BR/>

        Or perhaps demonstrable through contemporary information storage: Where at some level of description one assumes that the default state be all 'zeros'. And the only way to preserve other information is by violating the initial level of description of 'all zeros', for that structure is more easily otherwise preserved through abstractions than whatever other information one supposedly stores. With many (hidden) assumptions being made through the implementation of that level of description, ..., how it might influence observers onlooking that information storage, and thus the future trajectory of its implementations.

        <BR/>

        The hope is that such an approach to uncertainty would yield to a permeating hesitancy of this theory to interact or state with certainty any system it is describing, while still being able to understand how one might achieve certainty and its consequences. But this will hopefully be demonstrated by the effectiveness of this theory, so one doesn't need to cling to this notion.

        <BR/>

        Thus, allow me to more formally state the abstraction of this theory following these assumptions, followed by a demonstration of its use.
      </Section>
      <Section head="..">
        <BR/>

        Through abstraction

        Quite invariant to the actual implementation of this frame, . Abstractly we will always be able to define the following:

        <TODO>Practically speaking, that would mean constructing the following: Ignoring how they influence future trajectories, in these directionalities they seem equivalent. If that ignorance is however ignored when relevant ..</TODO>

        <pre className="bp5-code-block" style={{fontSize: '1.1rem', width: '80%'}}>
          <Row className="child-px-3" center="xs">
            <Col>
              <Row>Any</Row>
              <Row center="xs" style={{color: 'indianred'}}>∞</Row>
            </Col>
            <Col>
              <Row>Node</Row>
              <Row center="xs"><Icon icon="git-commit"/></Row>
            </Col>
            <Col>
              <Row>can be interpreted as</Row>
              <Row center="xs">{'->'}</Row>
            </Col>
            <Col>
              <Row>Any</Row>
              <Row center="xs">∞</Row>
            </Col>
            <Col>
              <Row>Node</Row>
              <Row center="xs"><Icon icon="git-commit"/></Row>
            </Col>
          </Row>
          <Row end="xs">
            <Icon icon="lab-test" intent="primary"/>
          </Row>
          <Row end="xs">Assuming consistency.</Row>
          <Row end="xs">Assuming boundedness.</Row>
        </pre>
        {/*<pre className="bp5-code-block" style={{fontSize: '1.1rem', width: '80%'}}>*/}
      </Section>
      <Section head="Assumption: Transformation and perceived Boundedness">
        <TODO>Every transformation perceived, is perceived as a wasteful one initially</TODO>

        <TODO>Uboundedness ..</TODO>
      </Section>
    </Row>

    <Row center="xs">
      <Divider style={{width: '80%'}}/>
    </Row>

    <Row center="xs">
      <Section head="Formulation and Consequences">
        Let me now continue building on the formalization of these ideas, with these assumptions aside and the following acknowledgement: There may possibly be non-expressed assumptions which I am not able to explicitly state because of my own ignorance in the direction of non-perceived possibilities and especially in the direction of that which does this perceiving; myself [Show the formulation of this].

        <BR/>

        {/*  Important: this is not consistent, but what can one do? Could be stated as: This theory is through its assumptions, not interested in consistency (in its extreme). It is merely interested in how inconsistencies which can give rise to abstractions to talk about consistency. And how those inconsistencies, depending on how they are implemented, have influence on a system. */}

        <BR/>


      </Section>
    </Row>

    <Row center="xs">
      <Divider style={{width: '80%'}}/>
    </Row>

    <Row center="xs">
      <Section head="A demonstration: Some practicality considerations">
        <TODO>Refine this..</TODO>
        Eventually, a possible goal of this project would be the ability to ask the question: "What if I did not know about something, nor could rely on these particular discoveries, how would and could I rediscover this something?". Possibly phrased as the posing/constructing of conjectures and simulations in non-trivial directionalities. One would still be making some assumptions about consistency or some invariance in such a conjecture, but possibly such an exercise of testing fidelity could be quite useful. This framing seems incredibly similar to search problems of reversibility: compression.

        <BR/>

        Another way of phrasing this problem, is that the mode of (potential) (re-)discovery, (un)known contextual and thus also historical aspects, make such a proposition incredibly complex. At least, with some level of certainty, the following can be said somewhat irrespective of which particular frame one is operating under:

        <BR/>

        The limitations nor abstractly unexpected inconsistencies may be non-trivial to find at any level of description. The initial choice of architecture may non-trivially influence future trajectories of this project and the actual physical mechanisms within which this level of description operates. Thus being relevant to the size, dynamics, ..., interpretation of the compression being done.

        <CodeBlock code="...non-trivial future trajectories"/>

        <BR/>

        Practically, what this may mean, is that from a historical perspective certain decisions in this project will be made to operate under. While a goal is to eventually describe many different levels of descriptions simultaneously, I start with one which initially doesn't necessarily acknowledge all those descriptions nor can directly operate under them. Hence, the interfaces we are currently practically operating under will include: existing human interfaces (browsers, ..., keyboard) and thus for working within browsers resulting in the choice of achieving x86-64 through WASM. Each of those choices bringing immense complexity.

        <CodeBlock code="...x86-64 through WASM"/>

        <BR/>

        Note that among these choices are some initial interfaces, mainly aimed at contemporary humans: This doesn't necessarily limit its use to humans, but it creates a certain reference frame from which seeming arbitrary choices seem less arbitrary. I will currently label any interface choice as a practical guess, marked as a conjecture with some seemingly speculative contemporary intuitive reason, whose detail I don't necessarily understand. As such, marking the choices for future inquiry as whether a change is appropriate <Footnote is="footnote" index={referenceCounter()}>Hopefully, making these kinds of choices quite explicit, will aid design in the future.</Footnote>.

        <BR/>

        A simple example would be the following two choices: When displaying some binary selection, instead of relying on the symbolic association a human has with a representative 0 or 1, use black and white as colors respectively.

        <BR/>

        The guess of relying on more sophistication on the human side for picking up visual patterns by mapping the abstract binary symbol to a color mapping of opposite extremes. ; In contrast to displaying symbolic 0's & 1's, by default. We could probably already construct situations in which the (human) observer can more easily pick up a more non-trivial pattern by associating it with numbers directly, hence the complexity of this choice as a default.

        <BR/>

        <CodeBlock code="..."/>
        <TODO>Assumes the (human) observer interprets the color description when analysing the pattern as opposites [Although, I'm assuming that this is likely to be somewhat inconsistent in some respect, for the color mapping is likely to be more high-dimensional].</TODO>

        <BR/>

        Note that, while I can make these choices following some conjecture, the consequences of such choices are non-trivial. Displaying the patterns as black-white, white-black (or other colors/.../patterns), will likely have different effects on the intended human (and seemingly unintended other) observers [Similarly, if we'd swap the identification of a 0 or 1, it's not necessarily trivial to suggest one would find certain patterns easier than others.]. This can be formulated as another assumption following the conjecture, which is similarly non-trivial.

        <CodeBlock code="...non-trivial (future trajectories specification?)"/>

        <BR/>

      </Section>
    </Row>

    <Row center="xs">
      <Section head="A demonstration: Compressing enwik9 to x86-64 (The Hutter Prize)">

      </Section>
    </Row>

    <Row center="xs">
      <Divider style={{width: '80%'}}/>
    </Row>

    <Row center="xs">
      <Section head="Wrapping up">

      </Section>
    </Row>
  </Paper>;
}

export default OnOrbits;