#![no_std]

use std::rc::Weak;
use crate::spec::DirectionalRef::{Functional, Initial, Terminal};










pub type ArbitraryIterator<T> = Weak<dyn Fn() -> dyn Iterator<Item=T>>;
pub type ArbitrarySuperposition<T> = ArbitraryIterator<T>; // TODO: Does it have much use having this conceptualization of superposition versus an iterator?

pub trait Node<T = bool> {
    // Superposition of values, already expressed through Rays.


    /// A (non-trivial) realized set of [Ray]s going through this [Node],
    fn rays(&self) -> ArbitraryIterator<Arbitrary<Ray<T>>>;

    /// TODO: Currently assumes sequential positional encoding of T through ArbitraryIterator, could be more arbitrary.
    /// Observe/Interact with this [Node].
    ///
    /// TODO: Rephrase a bit here;
    /// Note that this is phrased this way, because we don't necessarily know (from any perspective) how the abstraction of what this Node is supposed to represent is implemented in the universe. One must interact with this non-trivial implementation, whose consistency we cannot guarantee. Nor can one necessarily observe the state of what this Node is (; how its abstraction is implemented) trivially, from any other level of description. Nor, if such an observation is possible, would it be obvious whether one could notice it from this level of description. Nor whether that significantly changes the consistency of what the abstraction assumed this Node would be. Nor, what other impact the existence of this Node and its interactions (realized or not) may have. Nor whether any observation is recorded and persisted (in any non-trivial way) and realized as a possible [Ray] through this [Node]. Hence, whether some [Ray] observing this [Node] (whether possible to conceptualize from this level of description or not), effects its 'abstract state', is non-trivial to realize.
    ///
    /// All these non-trivial things will have to be realized, or remain ignored.
    ///
    /// Interprets some observation in code as possible ways of interpreting/interacting with it according to this [Explorer] : A non-trivial [Superposition] of perceived possible non-trivial [Superposition]s.
    ///
    /// # Encoding in Rays & Nodes
    /// This code is non-trivially encoded within the representation of [Node]s ([Ray::through]), and directed (non-trivially) by following this [Ray].
    ///
    /// # Interpretation
    /// - Abstractly, Any [ArbitraryNode] can be interpreted as Any [ArbitraryNode].
    ///   - Practically: It may be irrelevant to suggest whether two things can be interpreted as being equivalent. The interesting question would be: assuming they are (non-trivially) interpreted as being equivalent, what can we predict about its possible future trajectory?
    /// - No guarantee is made that iterating over possibilities of this [Superposition] will halt.
    /// - No guarantee of uniqueness of functionality is made.
    /// - One cannot guarantee the temporal stability (consistency) of the Node.
    /// - No guarantee is made on 'non-local' effects by executing some function.
    fn observe(&self) -> ArbitraryNode<T>;
}

pub enum ArbitraryNode<T = bool> {
    Fn(Weak<dyn Fn() -> dyn Node<T>>),
    Ref(Weak<dyn Node<T>>),
}

/// A Function could be conceptualized as a non-trivial (implicit) SuperPosition.
///
/// - One cannot necessarily guarantee its temporal stability (consistency).
/// - It is implicit in the sense that one cannot necessarily reduce/transduce it (directly/trivially).
/// - No concept of arity is encoded, for one cannot necessarily enforce it, nor realize that our level of description could even describe every possible way of interaction.
pub type ArbitraryFunction<T> = fn(ArbitraryNode<T>) -> ArbitraryNode<T>;

/// A [Ray], from the perspective of a [Ray].
///
/// Some realized (non-trivial) directionality (read: property, ..., dimensionality) through some arbitrary [Node].
///
/// ---
/// # No expected Symmetry in references.
/// From the perspective of this [Ray], we can reference other [Ray]s & [Node]s, this doesn't necessarily mean, that in return those referenced [Ray]s & [Node]s need to reference this [Ray] This is designed this way on purpose: We do not assume perfect consistency, since one cannot guarantee it.
/// - To conceptualize why: You, can read this, the one writing/displaying this sentence may have predicted that, but that doesn't necessarily mean I know who 'You' are. Nor were you aware of it, before reading this.
///
/// ---
/// # On self-referential initial/terminal ends of [Ray]s:
/// One assumes some infinity in the form of some self-reference for [Ray::initial] = [DirectionalRef::Initial(Option::None)], & [Ray::terminal] = [DirectionalRef::Terminal(Option::None)]: 'I already moved infinitely far in this direction (assuming some non-trivial consistency)'.
/// - This assumption of non-trivial consistency can be broken, by violating it, and growing the [`Ray`] through another [`Node`].
/// - TODO: This realized self-reference will likely have to be revised as a complex set of processes for designing (at least) biologically plausible systems. (Perhaps we this can be said for more places in this abstraction?)
///
///
pub struct Ray<T = bool> {
    initial: DirectionalRef<T>,
    through: Ray<T>,
    terminal: DirectionalRef<T>,
}

/// Represents the `initial` & `terminal` ends of a [Ray].
pub enum DirectionalRef<T = bool> {
    Initial(Option<Arbitrary<Ray<T>>>),
    Terminal(Option<Arbitrary<Ray<T>>>),
    Functional(Option<ArbitraryFunction<T>>),
}

pub type Arbitrary<T> = fn() -> T;

pub trait Explorer<T = bool> {

}

pub trait Evolvable {
    /// Evolve some arbitrary (abstract) (step-)function. ; This notion, one could equate to some non-trivial temporal direction.
    fn step(&self) -> ();
}

pub struct RayExplorer<T = bool> {

    /// The [Ray] which describes the discovery of some [ArbitraryFunction].
    ray: Ray<T>,

    /// The [Node] through which to push this [Ray].
    context: Ray<T>
}
impl Evolvable for RayExplorer {
    fn step(&self) -> () {
        /// The [ray] describes some arbitrary initiated directionality, by interpreting the [Node] through which this [ray] goes, as altering the directionality of the [ray]. Hence, the ray defines on the initial side: the reference to what kind of interpretation, through the [Node], a directionality which we will find on the terminal side:
        if let Functional(Some(func)) = &self.ray.terminal {

            &self.context = Ray {
                initial: Terminal(Some(&self.context.terminal)),
                through: Some(func(&self.context.through)),
                terminal: Terminal(None),
            }

        }
    }
}
