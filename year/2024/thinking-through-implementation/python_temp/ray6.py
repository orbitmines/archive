# TODO: .equivalent vs .is_equivalent ? (Could do: .equivalent. somethimg??) Basically the connection between .equivalent & .is_orbit
# TODO: That's basically the same connection of .next/.has_next/.last, .end/.boundary/.is_boundary/...
# TODO: Other layer of abstraction waiting for .next step function - will hook into anything that finishes, and allows already composing stuff after .last .


# TODO: Runtime with its read/writeonly, basically (non-/)availability of write operations. Where read operations are already also write operations from another perspective, just not the one accessible here.

kwargs / args  # TODO: Named args in the sense, similar to class definition, in the sense that they equivalences on the existing functions. Again this thing of assign.


# TODO: DEBUG/LISTENER/OBSERVER/WRAPPER IS A WRAPPER AROUND EVERY FIELD, callbacks. "Ignorant of how it effects, ..., doesn't effect the function."

#
# TODO: set = none;
# TODO: Destroy the current thing, connect .initial & .terminal ? (can do just direct connection, preserves 'could have been something here') - then something like [self.initial, self, self.terminal].pop().
# TODO: Leave behind --] [-- or connect them basically..


# TODO: Like any method, .initial/.terminal could be seen as a particular section of .self, which .self itself ignores. - This should be generalizable to other things setup on .self.

def terminal(self, *args, **kwargs) -> Ray:
  print(f'{self.name}.__call__ {args} {kwargs}')
  return (
    (-self).initial
    # or (self.initial.is_boundary and self.self.is_boundary) -> Best place for this? Steps to initial=self.self & self=self.self.terminal . But then a nice variant of this generalzied to each step type.
    # TODO: If nothing works, probably like any function, that means .none: "Cannot determine what to do without context of where we are.", the thing that calls .terminal is the thing that needs to make sense of that?, Then it makes sense that a .reference calls into its .self, since it cannot find anything in its direction, it assumes it's at a boundary, and then starts traversing .self ; Needs generalization
  )

  # TODO: Ray.vertex/initial/terminal ? places empty_initial/terminal in the expected style?


# TODO: These might be slightly different?
# Ray.terminal(empty=true)
# Ray.terminal.empty
# Ray.terminal.empty()

@staticmethod
def none() -> Ray: return -Ray.some


@staticmethod
def some() -> Ray: return -Ray.none


# def empty_initial(self) -> Ray: return Ray(initial=Ray.none, self=Ray.none, terminal=self)
# def empty_terminal(self) -> Ray: return Ray(initial=self, self=Ray.none, terminal=Ray.none)
# An arbitrary Ray, defining what continuing in this direction is equivalent to.
# This is basically what breaks the recursive structure.  #  # Tries for "global coherence", practically this just means self-reference, were no change is (inconsistently) assumed...  #  # ---  #  # Another way of interpreting a possible way of implementing it, is no matter how much more detail we would like to ask, the only thing we ever see is the same structure again (if we ignore the difference of us asking about that additional structure, that's still a possible handle on some difference).  #  # As a way of saying/.../assuming: I only 'infinitely' assume it's only this structure, "it seems to halt here". Note that this is necessarily an assumption. No guarantee of this can be made. This is necessarily an equivalence, ..., ignorance.  #  # @see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Quite%20similarly%20to%20the%20loops%2C%20I%20could%20be%20ignorant%20of%20additional%20structure%20by%20assuming%20it%27s%20not%20there.  # TODO: is none, ref, init terminal as global equiv check kn the structure? as generalization ; yep, is_orbit.
#
# Concretely, we use this as the thing which has power over the equivalence assumption we use to halt programs. - The asymmetry which allows the engine to make a distinction between each object.  # @see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=And%20there%20we%20have%20it%2C%20an%20infinity%2C%20loop%2C%20...%2C%20orbit%20if%20we%20ignore%20the%20difference.
# @alias('is_none')
def is_orbit(a, b: Arbitrary) -> Ray: raise NotImplementedError


def is_orbit(self) -> Ray: raise NotImplementedError


def is_none(self) -> Ray: return self.is_orbit(self, self.self)


#
# Predefined functionality
# TODO: Reference maybe as an orbit at the point is the thing ignorant
#     TODO: This is basically saying "reference as a constant"
# TODO Could say orbit = constant, meaning this entire direction repeats??? - maybe it's slightly different


def has_next(self) -> Ray: return self.next().is_some


def last(self) -> Ray: raise NotImplementedError


def compose(a, b) -> Ray: return a.terminal().equivalent(b.initial())


# Equivalence as "Composition of Ray."
#  # NOTE:  #  - An equivalence, is only a local equivalence, no global coherence of it can be guaranteed. And it is expensive work to edge towards global coherence.  #  - Though changes are only applied locally, their effects can be global (Take for instance, the example of adding to one Ray, which changes the perspective of everything connected to that Ray if they were to traverse the connection).  #  # @see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20Equivalences%20%26%20Inconsistencies
def equivalent(a, b: Arbitrary) -> Ray:
  # raise NotImplementedError

  # TODO: This is close but not quite, use the shifting thing I wrote down a few days ago: (And then use something to break the self-reference) - Either on this side. compose, or outside the definitions
  # This one harder to do in parallel?
  return a.self().compose(b.self())

  # "Composing an terminal & initial boundary"


# - TODO: Note that an orbit is reversibility. ?
# - TODO: Could represent this abstraction in another layer what we want to accomplish while the actual search is still taking place.
#
# - Like with 'copy' and all concepts: Note that we're only after reversibility after ignoring some difference.  #  # @see "Reversibility is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility
def orbit(a, b: Arbitrary) -> Ray:
  # - TODO: If we're only doing one end: This already assumes they are connected on the other end.
  # - TODO: should be a connection here, with is_composed ; or "reference.is_equivalent" so that you can drop one of the sides, or both.
  b.last().compose(a.first())
  a.first().compose(b.last())

  return a  # TODO ?


# TODO: .ref perspecctive: self.as_reference & self.dereference

def from_perspective_of(a, b):
  raise NotImplementedError


def perspective(self) -> Ray: raise NotImplementedError


# TODO ; is parameters?

#
# If there exists an orbit between A & B anywhere on their equivalency functions - or: their .self - (except for the directions through which we're referencing them)  #  # Note the connection between 'is_orbit' vs 'is_equivalence'. They're essentially the same thing, but:  #    - in the case of 'is_equivalence' we directly have access to their difference but are explicitly ignoring them - in the context in which this functionality is called.  #    - in the case of 'is_orbit', we might need to do more complicated things to acknowledge their differences - we don't have direct access to them.  #  # TODO: (so dually connected, what if only one is aware??) Or basically just ; the answer in this particular instance is just if either end can find the other only once. Consistency of it defined on a more abstract level...
#
# a.self().traverse().is_orbit(b.self().traverse())  # @alias('includes', 'contains') ; (slightly different variants?)
def is_equivalent(self) -> Ray: return self.is_composed.from_perspective_of(self.self)


# TODO: Either is_equiv or is_composed will likely change?.
# a.traverse().is_orbit(b.traverse()) // Basically: does there exist a single connection between the two?

def is_composed(self) -> Ray: return self.is_orbit.from_perspective_of(
  self.traverse)  # Needs some ref from Ray.Function.Self.


# TODO: This should accept Ray: Where 'size' is just a 'shape'
# @alias('resize', 'size', 'structure', 'length', 'duplicate', 'copy', 'clone', 'times', 'mul', '__mul__') -> Should be generalized as any kind of structure, but with this thing repeated on it. ; use traversal or ...
#  # Performing a copy (realizing it) can be conceptualized as traversing the entire structure. (Where the 'entire structure' means the current instantiation of it - with many ignorances attached)  #  # - A problem with a copy, is that in or to be generalizable, it needs to alter all references to the thing it's copying to itself - this cannot be done with certainty.  #    - This copy does not do that. Instead, it is ignorant of other things referencing the thing it's copying.  # - Additionally, a copy necessarily has some non-redundancy to it:  #  # @see "A copy is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=If%20I%20have%20one%20thing%20and%20I%20make%20a%20perfect%20copy
def size(self, b: Arbitrary) -> Ray:
  # // or
  #    // (self) => self.self.copy.reference()     #    (self) => none().self = self.self.copy()     #     #      // TODO Relies heavily on the execution layer to copy initial/terminal etc... ; and an is_orbit check before calling copy again. - Then again on the execution layer it can lazily do this copy (by not evaluating (i.e.) traversing everywhere), or it first does this traversing directly.

  pass


def radd(self) -> Ray: return -self.add.perspective


def push_back(a, b: Arbitrary) -> Ray: return a.last().compose(b)

# TODO: lshift/rshift respects the .size of the ray. So it's push_back & pop front, or in certain interpretations, we might keep and not pop...
![[PXL_20240603_103223737.jpg]]


#
# Python runtime conversions  # ; TODO: Could have enumerated possibilities, but just ignore that for now.
#


@staticmethod
def as_javascript() -> str: raise NotImplementedError


@staticmethod
def runtimes() -> Ray: raise NotImplementedError


# TODO: Any function calls which do not return or are convertable to ray, convert as an operator.
@staticmethod
def compiler() -> Ray: raise NotImplementedError


# TODO: This thing I mentioned in my notes a while back is relevant to this: Assign in the sense of adding to existing equivalences: i.e. offering a specific implementation for a certain thing, vs the destroy of them and replacing it with something specific: i.e. removing all existing assigns and setting a single one.
__set__

#  TODO: Are these "GLOBAL" varibles from the perspective of the ignorant setup - or more accuarrately something which it could be made aware of.
# TODO: WHILE = WITH = SCOPE = CONTEXT = GLOBAL = //...
enter / exit


# TODO: Binary on self is (a, a) like is_orbit(a, a) ?
# By default a = -b is -b = a
# __set__(self, '')


#
# Python runtime converters  #
@staticmethod
def integer(val: int) -> Ray: raise NotImplementedError


@staticmethod
def iterator(val: Iterator[Any]) -> Ray: raise NotImplementedError


@staticmethod
def iterable(val: Iterable[Any]) -> Ray: raise NotImplementedError


@staticmethod
def string(val: str) -> Ray: raise NotImplementedError


@staticmethod
def false(): return Ray.boolean(False)


@staticmethod
def true(): return Ray.boolean(True)


@staticmethod
def obj(val: object) -> Ray: raise NotImplementedError


@staticmethod
def arbitrary(val: Arbitrary) -> Ray:
  if isinstance(val, bool): return Ray.boolean(val)
  if isinstance(val, int): return Ray.integer(val)
  if isinstance(val, str): return Ray.string(val)
  if isinstance(val, object): return Ray.obj(val)
  # TODO ... - Could do all through object/iterable in the case of python ...

  raise NotImplementedError

  #


# Some functions which demonstrate control of (non-/)lazyness of functions  # TODO: this concept should be expanded (more like ignorant function calls from certain perspectives).
#

@staticmethod
# - TODO: readonly setup, where only traversal ops are allowed. Of course these are writing in some sense, but those writings aren't directly accessible from this perspective
def readonly() -> Ray: raise NotImplementedError


# TODO, writeonly would be?

# Any arbitrary direction, where reversing the direction relies on some arbitrary memory mechanism

def memoized(self) -> Ray:


# TODO: something along the lines of:
# res = self.next
# res.initial = self    # return res    raise NotImplementedError
# TODO = cached
# TODO: Better ideas what local caching looks like, (i.e. put it in some local structure to cache, this can be delayed till some useful implementation is ready)


Arbitrary = Union[int, Ray]