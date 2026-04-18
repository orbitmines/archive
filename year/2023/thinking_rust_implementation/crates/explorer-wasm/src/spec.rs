// Just some arbitrarily (un)known structures.
pub enum Arbitrary<T> {
    Fn(Weak<dyn Fn() -> Option<T>>),
    Ref(Weak<dyn Option<T>>),
}

pub enum Extreme {
    Initial(Arbitrary<Ray>),
    Frame(Arbitrary<Ray>),
    Terminal(Arbitrary<Ray>)
}

pub trait Ray {
    fn initial_side(&self) -> Extreme;
    fn frame(&self) -> Extreme;
    fn terminal_side(&self) -> Extreme;
}
