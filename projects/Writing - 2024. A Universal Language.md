*Let's try for [[2024-05-31]]*




```ts

from __future__ import annotations  
  
import inspect  
from typing import Iterator, AsyncIterator, Union, Callable, Any, Iterable, AsyncIterable, Tuple  
  
  
# TODO: Restrictive cases:  
# - TODO: Tensor as restrictive case  
#  
#  
  
# TODO: Better python solution than just @ray everywhere (for typechecker) - gen for typechecker?  
  
# TODO: match, switch, enum (like key=value), dict, keyvalue, pair, ....  
# TODO: zip, tensor (are these the same as match/switch?)  
  
# TODO: .equivalent vs .is_equivalent ? (Could do: .equivalent. somethimg??) Basically the connection between .equivalent & .is_orbit  
# TODO: That's basically the same connection of .next/.has_next/.last, .end/.boundary/.is_boundary/...  
  
# TODO: Runtime with its read/writeonly, basically (non-/)availability of write operations. Where read operations are already also write operations from another perspective, just not the one accessible here.  
  
def ray(func: Callable[[Any, ...], Any]) -> Ray:  
    pass  
  
class Ray2:  
  def __getattr__(self, name: str) -> Any:  
    print(f'__getattr__.{name}')  
    pass  
  def __setattr__(self, key, value) -> Any:  
    print(f'__setattr__{key}={value}')  
    pass  
  
#   These basically fall under naming/grouping  
#     @staticmethod: Implement a function from no (or: an ignorant) perspective.  
#     method(self): Implement a function from the perspective of 'this'  
class Ray:  
  def __init__(self, *args, **kwargs):  
      # TODO: Named args in the sense, similar to class definition, in the sense that they equivalences on the existing functions. Again this thing of assign.  
  
      pass  
  
  # TODO: DEBUG/LISTENER/OBSERVER/WRAPPER IS A WRAPPER AROUND EVERY FIELD, callbacks. "Ignorant of how it effects, ..., doesn't effect the function."  
  
  #  
  # Basic Ray operators  #  
  # TODO: set = none;  
  # TODO: Destroy the current thing, connect .initial & .terminal ? (can do just direct connection, preserves 'could have been something here') - then something like [self.initial, self, self.terminal].pop().  
  # TODO: Leave behind --] [-- or connect them basically..  
  @staticmethod  
  @ray  def none() -> Ray: return -Ray.some  
  alloc = new = create = initialize \  
    = none  
  
  @staticmethod  
  @ray  def some() -> Ray: return -Ray.none  
  self_reference \  
    = some  
  
  @ray  
  def free(self): raise NotImplementedError  
  destroy = clear = delete = pop = prune \  
    = free  
  
  # TODO: Like any method, .initial/.terminal could be seen as a particular section of .self, which .self itself ignores. - This should be generalizable to other things setup on .self.  
  
  # An arbitrary Ray, defining what continuing in the reverse of this direction is equivalent to.  
  @ray  
  def initial(self) -> Ray: return (-self).terminal  
  previous = backward = decompile = predecessor \  
    = initial  
  # An arbitrary Ray, defining what continuing in this direction is equivalent to.  
  @ray  
  def terminal(self, *args, **kwargs) -> Ray:  
    print(f'{self.name}.__call__ {args} {kwargs}')  
    return (  
      (-self).initial  
      # or (self.initial.is_boundary and self.self.is_boundary) -> Best place for this? Steps to initial=self.self & self=self.self.terminal . But then a nice variant of this generalzied to each step type.  
      # TODO: If nothing works, probably like any function, that means .none: "Cannot determine what to do without context of where we are.", the thing that calls .terminal is the thing that needs to make sense of that?, Then it makes sense that a .reference calls into its .self, since it cannot find anything in its direction, it assumes it's at a boundary, and then starts traversing .self ; Needs generalization  
    )  
  next = __call__ = __next__ = __anext__ = forward = step = apply = run = successor \  
    = map = render = compile = realize = generate \  
    = terminal  
  # TODo: __anext__ in python case might need addition async def setup? - How is that interpreted as operators for awaitable?  
  # Todo: slightly different perspectives in cases of map/render etc..., where certain aliases of these are expected not to have alternative behaviors based on binary/ternary calls to this... ; Basically; some of these aliases are probably more appropriate as separate perspectives.  
  # TODO: compile/map/cast/ ... probably fit in that separate category. Wrap to any object if translation exists (in python case inspect?). - Realize is probably similarly on another level of abstraction.  
  # TODO: FILTER/WHERE/IF/... for instance - branch different effect  
  
  # @see "Reversibility after ignoring some difference": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility  
  # @see "More accurately phrased as the assumption of Reversibility: with the potential of being violated.": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20Assumptions%20%26%20Assumption%20Violation  @ray  
  def reverse(self) -> Ray:  
    return Ray(initial=self.terminal, self=self.self, terminal=self.initial)  
  neg = __neg__ = __invert__ = opposite = _not = converse = negative = swap \  
    = reverse # TODO ; Could also be implemented as copy - hence the __call__ on Ray() - this is the case for any sort of constructor/type.  
  
  # An arbitrary Ray, defining what our current position is equivalent to.  
  # Moving to the intersecting Ray at `.self` - as a way of going an abstraction layer (lower), and asking what's inside.  @ray  
  def self(self) -> Ray: raise NotImplementedError  
  element = dereference = selected = selection = cursor = auto \  
    = self # TODO: = branch?  
  
  # TODO: Like this, ignorant vs non-ignorant? What to do here?  
  #   return vertex  
  # TODO: These are very close to binary ops / makes sense since some/none is a boolean.  
  #       /**  
  #        * Placing existing structure on a new Reference, Boundary or Vertex:  
  #        */  
  #         // TODO: These should allow as_vertex as zero-ary, but that means self = self_reference, not none. ?  
  #         /**  
  #          * Moving `self` to `.self` on an abstraction layer (higher). As a way of being able to describe `self`.  #          *  #          * TODO: the .reference might need two levels of abstraction higher, one to put it at the .self, another to reference that thing? (Depends a bit on the execution layer)  
  #          */  
  #            // TODO as_reference.as_vertex instead of as_vertex ignorant by default?  
  def as_reference(self) -> Ray: return Ray(initial=Ray.none, self=self, terminal=Ray.none)  
  def as_vertex(self) -> Ray: return Ray(initial=Ray.some, self=self, terminal=Ray.some)  
  def as_initial(self) -> Ray: return (  
    (-self).as_terminal() # TODO: These sorts of deductions should be automatic, here as an example  
    or Ray(initial=Ray.none, self=self, terminal=Ray.some)  
  )  
  def as_terminal(self) -> Ray: return (  
    (-self).as_initial() # TODO: These sorts of deductions should be automatic, here as an example  
    or Ray(initial=Ray.some, self=self, terminal=Ray.none)  
  )  
  # TODO: Ray.vertex/initial/terminal ? places empty_initial/terminal in the expected style?  
  
  # TODO: These might be slightly different?  
  # def empty_initial(self) -> Ray: return Ray(initial=Ray.none, self=Ray.none, terminal=self)  
  # def empty_terminal(self) -> Ray: return Ray(initial=self, self=Ray.none, terminal=Ray.none)  
  # An arbitrary Ray, defining what continuing in this direction is equivalent to.  
  # This is basically what breaks the recursive structure.  #  # Tries for "global coherence", practically this just means self-reference, were no change is (inconsistently) assumed...  #  # ---  #  # Another way of interpreting a possible way of implementing it, is no matter how much more detail we would like to ask, the only thing we ever see is the same structure again (if we ignore the difference of us asking about that additional structure, that's still a possible handle on some difference).  #  # As a way of saying/.../assuming: I only 'infinitely' assume it's only this structure, "it seems to halt here". Note that this is necessarily an assumption. No guarantee of this can be made. This is necessarily an equivalence, ..., ignorance.  #  # @see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Quite%20similarly%20to%20the%20loops%2C%20I%20could%20be%20ignorant%20of%20additional%20structure%20by%20assuming%20it%27s%20not%20there.  # TODO: is none, ref, init terminal as global equiv check kn the structure? as generalization ; yep, is_orbit.  
  #  
  # Concretely, we use this as the thing which has power over the equivalence assumption we use to halt programs. - The asymmetry which allows the engine to make a distinction between each object.  # @see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=And%20there%20we%20have%20it%2C%20an%20infinity%2C%20loop%2C%20...%2C%20orbit%20if%20we%20ignore%20the%20difference.  @ray  
  # @alias('is_none')  
  def is_orbit(a, b: Arbitrary) -> Ray: raise NotImplementedError # a.___instance === b.___instance  
  __eq__ \  
    = is_orbit  
  # TODO: Constant as local orbit.  
  
  # -__eq__ == __ne__  
  # @ray  # def __ne__(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  @ray # TODO  
  def is_none(self) -> Ray: return self.is_orbit(self, self.self)  
  
  #  
  # Predefined functionality  #  
  @ray  
  # TODO is_initial = return (-self).terminal().is_none ??  
  def is_initial(self) -> Ray: return self.initial().is_none  
  @ray  
  def is_terminal(self) -> Ray: return self.terminal().is_none                    # [?-|  ]  
  @ray  
  def is_vertex(self) -> Ray: return self.is_initial().nor(self.is_terminal())    # [--|--]  
  @ray  
  def is_reference(self) -> Ray: return self.is_initial() & self.is_terminal()    # [  |  ]  
  # TODO: reference = pointer ...  
  # TODO: Reference maybe as an orbit at the point is the thing ignorant  
  #     TODO: This is basically saying "reference as a constant"  
  # TODO Could say orbit = constant, meaning this entire direction repeats??? - maybe it's slightly different  
  @ray  
  def is_boundary(self) -> Ray: return self.is_initial() ^ self.is_terminal()     # [?-|  ] or [  |-?]  
  
  @ray  
  def has_next(self) -> Ray: return self.next().is_some  
  @ray  
  def last(self) -> Ray: raise NotImplementedError # TODO: Other layer of abstraction waiting for .next step function - will hook into anything that finishes, and allows already composing stuff after .last ..  
  end = result = back = output = max \  
    = last  
  
  # @see "Continuations as Equivalence (can often be done in parallel - not generally)": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Constructing%20Continuations%20%2D%20Continuations%20as%20Equivalence  
  @ray  
  # @alias('merge',  
  def compose(a, b: Arbitrary) -> Ray: return a.terminal().equivalent(b.initial())  
  continues_with \  
    = compose  
  
  # Equivalence as "Composition of Ray."  
  #  # NOTE:  #  - An equivalence, is only a local equivalence, no global coherence of it can be guaranteed. And it is expensive work to edge towards global coherence.  #  - Though changes are only applied locally, their effects can be global (Take for instance, the example of adding to one Ray, which changes the perspective of everything connected to that Ray if they were to traverse the connection).  #  # @see https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=On%20Equivalences%20%26%20Inconsistencies  @ray  
  def equivalent(a, b: Arbitrary) -> Ray:  
    # raise NotImplementedError  
  
    # TODO: This is close but not quite, use the shifting thing I wrote down a few days ago: (And then use something to break the self-reference) - Either on this side. compose, or outside the definitions  
    # This one harder to do in parallel?  
    return a.self().compose(b.self())  
  
  # "Composing an terminal & initial boundary"  
  # - TODO: Note that an orbit is reversibility. ?  
  # - TODO: Could represent this abstraction in another layer what we want to accomplish while the actual search is still taking place.  
  #  
  # - Like with 'copy' and all concepts: Note that we're only after reversibility after ignoring some difference.  #  # @see "Reversibility is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility  @ray  
  #@alias('modular', 'modulus',  
  def orbit(a, b: Arbitrary) -> Ray:  
    # - TODO: If we're only doing one end: This already assumes they are connected on the other end.  
    # - TODO: should be a connection here, with is_composed ; or "reference.is_equivalent" so that you can drop one of the sides, or both.  
    b.last().compose(a.first())  
    a.first().compose(b.last())  
  
    return a # TODO ?  
  circle = repeats = period = infinitely \  
    = orbit  
  
  # "Applying the same thing in a different context"  
  # TODO: Somewhat related to Functors?  
  # TODO: .ref perspecctive: self.as_reference & self.dereference  
  @ray  
  def from_perspective_of(a, b):  
    raise NotImplementedError  
  @ray  
  def perspective(self) -> Ray: raise NotImplementedError  
  # TODO ; is parameters?  
  
  #  
  # If there exists an orbit between A & B anywhere on their equivalency functions - or: their .self - (except for the directions through which we're referencing them)  #  # Note the connection between 'is_orbit' vs 'is_equivalence'. They're essentially the same thing, but:  #    - in the case of 'is_equivalence' we directly have access to their difference but are explicitly ignoring them - in the context in which this functionality is called.  #    - in the case of 'is_orbit', we might need to do more complicated things to acknowledge their differences - we don't have direct access to them.  #  # TODO: (so dually connected, what if only one is aware??) Or basically just ; the answer in this particular instance is just if either end can find the other only once. Consistency of it defined on a more abstract level...  
  #  
  # a.self().traverse().is_orbit(b.self().traverse())  # @alias('includes', 'contains') ; (slightly different variants?)  @ray  
  def is_equivalent(self) -> Ray: return self.is_composed.from_perspective_of(self.self)  
  
  # TODO: Either is_equiv or is_composed will likely change?.  
  # a.traverse().is_orbit(b.traverse()) // Basically: does there exist a single connection between the two?  
  @ray  
  def is_composed(self) -> Ray: return self.is_orbit.from_perspective_of(self.traverse) # Needs some ref from Ray.Function.Self.  
  
  @staticmethod  
  @ray  def boolean() -> Ray: return Ray.none * 2  
  bit \  
    = boolean  
  
  # TODO: This should accept Ray: Where 'size' is just a 'shape'  
  # @alias('resize', 'size', 'structure', 'length', 'duplicate', 'copy', 'clone', 'times', 'mul', '__mul__') -> Should be generalized as any kind of structure, but with this thing repeated on it. ; use traversal or ...  
  #  # Performing a copy (realizing it) can be conceptualized as traversing the entire structure. (Where the 'entire structure' means the current instantiation of it - with many ignorances attached)  #  # - A problem with a copy, is that in or to be generalizable, it needs to alter all references to the thing it's copying to itself - this cannot be done with certainty.  #    - This copy does not do that. Instead, it is ignorant of other things referencing the thing it's copying.  # - Additionally, a copy necessarily has some non-redundancy to it:  #  # @see "A copy is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=If%20I%20have%20one%20thing%20and%20I%20make%20a%20perfect%20copy  @ray  
  def size(self, b: Arbitrary) -> Ray:  
     # // or  
     #    // (self) => self.self.copy.reference()     #    (self) => none().self = self.self.copy()     #     #      // TODO Relies heavily on the execution layer to copy initial/terminal etc... ; and an is_orbit check before calling copy again. - Then again on the execution layer it can lazily do this copy (by not evaluating (i.e.) traversing everywhere), or it first does this traversing directly.  
  
    pass  
  # size = length = no params different behavior  
  # resize = structure  mul = __mul__ = times \  
    = size  
  # duplicate = copy = clone = size.from_perspective_of  
  
  @ray  
  def xor(self) -> Ray: return (  
    -self.xnor  
  )  
  __xor__ \  
    = xor  
  @ray # TODO: Could be 'is_equivalent' too? or is_orbit  
  def xnor(self) -> Ray: return (  
    -self.xor  
  )  
  @ray  
  def nand(self) -> Ray: return (  
    -self._and  
  )  
  @ray  
  def nor(self): return (  
    -self._or  
  )  
  @ray  
  def _and(self) -> Ray: return (  
    -self.nand  
  )  
  __and__ = \  
    _and  
  @ray  
  def _or(self) -> Ray: return (  
    -self.nor  
  )  
  __or__ = \  
    _or  
  
  @ray  
  def add(self) -> Ray: return (  
    -self.sub  
  )  
  __add__ \  
    = add  
  @ray  
  def sub(self) -> Ray: return (  
    -self.add  
  )  
  __sub__ \  
    = sub  
  
  @ray  
  def radd(self) -> Ray: return -self.add.perspective  
  @ray  
  def pow(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  __pow__ \  
    = pow  
  @ray  
  def div(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  __truediv__ \  
    = div  
  @ray  
  def mod(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  __mod__ \  
    = mod  
  @ray  
  def matmul(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  __matmul__ \  
    = matmul  
  
  @ray  
  # @alias(f'push_{last.alias}')  
  def push_back(a, b: Arbitrary) -> Ray: return a.last().compose(b)  
  # TODO: lshift/rshift respects the .size of the ray. So it's push_back & pop front, or in certain interpretations, we might keep and not pop...  
  __lshift__ \  
    = push_back  
  
  #  
  # Python runtime conversions  # ; TODO: Could have enumerated possibilities, but just ignore that for now.  
  #  
  
  # TODO: similar to next/anext, these might collapse if there's a python awaitable operator...  
  def as_iterator(self) -> Iterator[Ray]: return self  
  __iter__ \  
    = as_iterator  
  def as_async_iterator(self) -> AsyncIterator[Ray]: return self  
  __aiter__ \  
    = as_async_iterator  
  
  def as_iterable(self) -> Iterable[Ray]: return self  
  def as_async_iterable(self) -> AsyncIterable[Ray]: return self  
  def as_string(self) -> str: raise NotImplementedError  
  def as_int(self) -> int: raise NotImplementedError  
  def as_list(self) -> list: raise NotImplementedError  
  def as_tuple(self) -> tuple: raise NotImplementedError  
  @staticmethod  
  def as_javascript() -> str: raise NotImplementedError  
  
  @staticmethod  
  @ray  def runtimes() -> Ray: raise NotImplementedError  
  
  # TODO: Any function calls which do not return or are convertable to ray, convert as an operator.  
  @staticmethod  
  @ray  def compiler() -> Ray: raise NotImplementedError  
  
  def __get__(self, instance, owner) -> Ray:  
    print(f'{self.name}.__get__ {instance} {owner}')  
    return self  
    # raise NotImplementedError  
  def __set__(self, instance, value) -> Ray:  
    print(f'{self.name}.__set__ {instance} {value}')  
    return self  
  assign = \  
    __set__ # TODO: This thing I mentioned in my notes a while back is relevant to this: Assign in the sense of adding to existing equivalences: i.e. offering a specific implementation for a certain thing, vs the destroy of them and replacing it with something specific: i.e. removing all existing assigns and setting a single one.  
  def __delete__(self, instance) -> Ray: raise NotImplementedError  
  
  # def __str__(self) -> str: return self.as_string()  
  # def __repr__(self) -> str: raise NotImplementedError  # def __hash__(self) -> str: raise NotImplementedError  # def __bool__(self) -> bool: raise NotImplementedError  
  # def __iadd__(a, b: Arbitrary) -> Ray: return a.assign(a.add(b))  # def __isub__(a, b: Arbitrary) -> Ray: return a.assign(a.sub(b))  # def __imul__(a, b: Arbitrary) -> Ray: return a.assign(a.mul(b))  # def __ipow__(a, b: Arbitrary) -> Ray: return a.assign(a.pow(b))  # def __itruediv__(a, b: Arbitrary) -> Ray: return a.assign(a.div(b))  # def __imatmul__(a, b: Arbitrary) -> Ray: return a.assign(a.matmul(b))  # def __ibor__(a, b: Arbitrary) -> Ray: return a.assign(a.bor(b))  
  #  TODO: Are these "GLOBAL" varibles from the perspective of the ignorant setup - or more accuarrately something which it could be made aware of.  
  # TODO: WHILE = WITH = SCOPE = CONTEXT = GLOBAL = //...  
  def __enter__(self) -> Ray: raise NotImplementedError  
  def __exit__(self, exc_type, exc_val) -> Ray: raise NotImplementedError  
  async def __aenter__(self) -> Ray: raise NotImplementedError  
  async def __aexit__(self, exc_type, exc_val) -> Ray: raise NotImplementedError  
  
  
  def __floordiv__(self, item): raise NotImplementedError  
  
  # TODO: THESE ARE ALL MAPS.  
  def __contains__(self, item): raise NotImplementedError  
  def __delitem__(self, item): raise NotImplementedError  
  def __getitem__(self, item): raise NotImplementedError  
  def __setitem__(self, key, value): raise NotImplementedError  
  def __pos__(self): raise NotImplementedError  
  
  @ray  
  def less_than(self) -> Ray: return (  
    -self.greater_than_or_equal_to  
  )  
  __lt__ \  
    = less_than  
  @ray  
  def greater_than_or_equal_to(self) -> Ray: return (  
    -self.less_than  
  )  
  __ge__ \  
    = greater_than_or_equal_to  
  @ray  
  def __gt__(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  @ray  
  def __le__(a, b: Arbitrary) -> Ray: raise NotImplementedError  
  
  #  
  # Opposite aliases  # TODO: Could just dynamically assign these - the case for any reversible thing (next/previous, initial/terminal ...) always: A.something and (-A).something  
  #  
  
  @ray  
  def has_previous(self) -> Ray: return (-self).has_next  
  @ray  
  def first(self) -> Ray: return (-self).last  
  beginning = front = min \  
    = first  
  @ray  
  def is_some(self) -> Ray: return (-self).is_none  
  @ray  
  # @alias(f'push_{first.alias}')  
  def push_front(self) -> Ray: return (-self).push_back  
  __rshift__ \  
    = push_front  
  
  # Several ways of achieving these:  
  #   -a.__add__.perspective(b)  #   Ray(b).__add__(a)  #   __add__ = -__add__.perspective (if python would allow for this)  #   ; TODO could be automatic  
  def __radd__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__add__(a)  
  def __rsub__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__sub__(a)  
  def __rmul__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__mul__(a)  
  def __rpow__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__pow__(a)  
  def __rtruediv__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__truediv__(a)  
  def __rmatmul__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__matmul__(a)  
  def __rxor__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__xor__(a)  
  def __rfloordiv__(a, b: Arbitrary) -> Ray: return Ray.arbitrary(b).__floordiv__(a)  
  
  #  
  # Python runtime converters  #  
  @staticmethod  
  def function(name: str, func: Callable[[Any, ...], Any]) -> Ray:  
    a = Ray()  
    a.name = name  
    return a  
  @staticmethod  
  def integer(val: int) -> Ray: raise NotImplementedError  
  @staticmethod  
  def iterator(val: Iterator[Any]) -> Ray: raise NotImplementedError  
  @staticmethod  
  def iterable(val: Iterable[Any]) -> Ray: raise NotImplementedError  
  @staticmethod  
  def boolean(val: bool) -> Ray: raise NotImplementedError  
  @staticmethod  
  def string(val: str) -> Ray: raise NotImplementedError  
  @staticmethod  
  @ray  def false(): return Ray.boolean(False)  
  @staticmethod  
  @ray  def true(): return Ray.boolean(True)  
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
  @ray  
  def memoized(self) -> Ray:  
    # TODO: something along the lines of:  
    # res = self.next  
    # res.initial = self    # return res    raise NotImplementedError  
  # TODO = cached  
  # TODO: Better ideas what local caching looks like, (i.e. put it in some local structure to cache, this can be delayed till some useful implementation is ready)  
  
  # print(f'{type(func)}')  
  # def method(*args, **kwargs) -> Ray:  #   return Ray()  
  # return await func(self, *args, **kwargs)  # TODO: Binary on self is (a, a) like is_orbit(a, a) ?  
  
  # By default a = -b is -b = a  
  # __set__(self, '')  
for name, fn in inspect.getmembers(Ray, inspect.isfunction):  
  if name.startswith('__'): continue  
  print(f'{name}')  
  setattr(Ray, name, Ray.function(name, fn))  
  
# a: Callable[[Ray], Ray] = lambda self: self.is_terminal  
setattr(Ray, '__mul__', Ray.function('__mul__', Ray.size))  
  
print('----------------')  
ray = Ray2()  
ray.__init__ = lambda self: self  
  
ray.__mul__ = 'test'  
setattr(ray, '__mul__', lambda self: self)  
  
# class Ray3(ray):  
#   mul = times = size \  
#     = ray__mul__  
#   pass  
  
print('----------------')  
# Ray.__add__ = -Ray.__sub__  
# Ray.__sub__ = -Ray.__add__  
  
Arbitrary = Union[int, Ray]  
  
# if __name__ == "__main__":  
#   pass
```

```ts
from ray import Ray, ray  
  
print('test')  
  
# Target first implementation  
  
@Ray.function  
def test() -> Ray:  
  a = Ray.none; b = Ray.none  
  a, b = Ray.none * 2  
  a, b = Ray.boolean  
  *a, b = Ray.boolean  
  a, *b = Ray.boolean  
  a, *between, b = Ray.boolean  
  b, none = -Ray.boolean  
  b, a = -Ray.boolean.orbit  
  a, b = --Ray.boolean.orbit  
  b, a = ---Ray.boolean.orbit  
  a, b = --Ray.boolean  
  
  # TODO: Normal way of talking about a boolean, or probably any concept, is that this is always with .orbit on it. And without .orbit it's probably a weird case. We assume modularity of booleans.  
  
  # TODO: This is only if Ray.boolean is .orbit, otherwise reverse would be different.  
  
# Compile the function to javascript  
print(test.as_javascript())  
# Compile the Compiler (i.e. Ray functionality) to javascript  
compiler = (  
  Ray.compiler  
  or test.compiler  
  or Ray.compiler.compiler  
)  
print(Ray.as_javascript())  
  
# test.runtimes.javascript()  
test.run(lambda ray: ray)  
# Ray.runtime(lambda ray: ray).run(test)  
  
# TODO These also the same:  
# Ray(  
#   initial = lambda ray: ray,  
#   self = lambda ray: ray,  
#   terminal = lambda ray: ray,  
#   is_orbit = lambda ray: ray  
# )  
# class Object(Ray):  
#   @property  
#   def initial(self) -> Ray: raise NotImplementedError  
#   @property  
#   def self(self) -> Ray: raise NotImplementedError  
#   @property  
#   def terminal(self) -> Ray: raise NotImplementedError  
#  
# ray = Ray()  
# ray.initial = lambda ray:  
# ...  
#  
#  
# Then copy is simple:  
# ray.copy() / Ray(ray) / sometimes even ray()  
#  
  
  
test.compile(lambda ray: ray)  
Ray.compile(lambda ray: ray)  
  
# test.compile(python).run(python)  
  
# Hence the difference between add/sub and a normal boolean. Is context. What add/sub is applied to; i.e. what effects it has.  
# These should be the same  
# def add(self) -> Ray: return -self.sub  
# def sub(self) -> Ray: return -self.add  
# def add(a, b: Arbitrary) -> Ray: return (-self.sub)(b)  
# def sub(a, b: Arbitrary) -> Ray: return (-self.add)(b)  
# add = -sub  
# sub = -add  
# [add, sub].orbit  
  
# TODO: Message: "Cannot run, need more implementations, for example these:"  
  
# TODO: Could just randomly start generating possible combinations of logical gates (or any methods on Ray), which if the runtime has an explanation for (or in the debug mode just to listen), you can hook into that and create an implementation. In the case of python made something along the lines of an interpreter which gives you one, asks to write one in python...
```

In-place dynamic window:
- writing on one side, interactive on the other, or centered, so a moving box - gotta make sure interop is good.

Header
- [ ] Some excerpt of the chyp implementation in the header as background & same for the thumbnail

Unprocessed
- [ ] (SEMF) Discord messages / livestream transcript
- [ ] Some of the notebooks from 2023

Introduction
Admittedly, this starts with a simple concession: that this is a generalization of many ideas whose details I don't fully understand. Though crucially, this is not important for my purposes here.

A list which undoubtedly falls short, would contain: . A more complete set of ideas and partial history of me becoming aware of them can be found in [my archive](https://github.com/orbitmines/archive/blob/main/projects/Project%20-%20Indexing%20existing%20Abstract%20Models%20(2024-2025%3F).md).

I suspect that a large numbers of problems arise from a rather simple conceptual mistake. And perhaps calling it a mistake - is itself a mistake. For we are always forced to first find practical tools, before we can find better ones. But therein lies to me the possibility of that mistake: ["Once something seemingly convenient is found, it is seriously hard to explore and steer away from that."](https://orbitmines.com/archive/2024-02-orbitmines-as-a-game-project#:~:text=Once%20something%20seemingly%20convenient%20is%20found%2C%20it%20is%20seriously%20hard%20to%20explore%20and%20steer%20away%20from%20that.). 



Consider this my attempt to provide infrastructure for that exploration.


###### ["You will have to deal with being able to move in certain data structures for which there might not (yet) be a nice translation to something you can understand."](http://localhost:3000/archive/2024-02-orbitmines-as-a-game-project/#:~:text=You%20will%20have%20to%20deal%20with%20being%20able%20to%20move%20in%20certain%20data%20structures%20for%20which%20there%20might%20not%20(yet)%20be%20a%20nice%20translation%20to%20something%20you%20can%20understand.)
- [ ] Modelling unknown systems - possibly to in the future match em - or directly something possibly not understood
	- [ ] Will have to kick in by having some way of realizing that externality - much more intuitive to phrase it this way, and see how it can be broken  
	- [ ] Conjecture, 
	  - Unknowns not yet verified with proposed consequences for either option?   
	  - Expectations/claims based on incompleteness of some intermediary step.  
	  - Also without expectation but simply an unsolved unknown.
- Other way around: determining that something outside the context is looking inside the context

Ideas like:
- [ ] Effectively random, like effective field equations, some idea from ignorance in the sense that: "might as well be truely random".  - unable to understand structure..
- [ ] Non-abstract realizations: Potentially important: distinguishability doesn't need to be abstractly realized, it could just be in the temporal mechanisms of the system: Not reanosable to suggest that certain things should be known in certain cases?
- [ ] Basically also this thing of, some type of assumption/proof - not need to check some thing ; you can use it without


---

- The problem is not .. it's missing tools to think across fields. 
	- Most definitions and/or names of things assume some perspective. Make it hard to generalize.
	- Similar to things like references: In
	- It doesn't matter that you want a particular way to deal with your conflict free stuff, the solution is not only to isolate an environment, but just to be able to deal or handle when it arises. ; better way of phrasing this? single sentence?
	- It's not just about being able to work with unique data, but also about what you do when that's not available ; restate some things from [[Project - OrbitMines as a Game (2025-2026?)]]
	- 
- "Can just draw a line (or any structure really) and say I want to regard that as the same, not obvious what would happen if you do that, but you can."

- Reference to existing ideas. This is the generalization of many ideas, it would be ...
	- first few things after the introduction, but this for now
	- Which others to name/ref.
	- https://www.youtube.com/watch?v=p2vadd_6550&list=PLtbvsohNkWeUItHqZ9LAn4Qnz8hT6JMhY
		- Covariant computation & [[Jonathan Gorard]]'s mentioning of graphs
	- The [[Bob Coecke]] & [[Stephen Wolfram]] conversation, Bob Coecke's work
	- [[Chyp (Cospans of HYPergraphs)]] & [[Aleks Kissinger]]
		- ```// Accompanied by a simple implementation of <Reference is="reference" simple inline index={referenceCounter()} reference={{title: 'Aleks Kissinger\'s Chyp (Cospans of HYPergraphs)', link: 'https://github.com/akissinger/chyp', authors: [{name: 'Aleks Kissinger'}]}} />
	- [[Alexander Grothendieck]]
	- Lingua Universalis
	- Infrageometry
	- Hook into [[Project - Indexing existing Abstract Models (2024-2025?)]] future inquiries

- A lot of this started with the idea: "You cannot have interaction without something like gravity." ; I think? Probably a question similar to this.

- Local changes..

visualization
- Small ring outline in continuation + vertex?
- Intersection on screen been non-intersection in the structure, way of rendering it.

process
Only difference is the assymetry of is_orbit and the consequences of that if self/initial/terminal all are is_orbit that of another  


Reverse direction as teo points. Need a good intuition for this. Basically one of tep values selected and the switching of direction to the other way. Perhaps similarly a tep step modular structure of which you can see the intial/terminals being swapped. Is_equiv if can tell the difference and ignore, is_orbit if cannot  

- [ ] ignorant referencing ray ; all these as ; 

`.as_[]` Switch of perspective should automatically map any other functionality, say `.traverse` .. 
- Switch perspective is switching names of functions
- It is ordered from one perspective, unordered from another.
`.and` compose terminal/initial
	- Only thing needed for addition, is equivalencing initial/terminal. - Equivalencing continuations.  
`.terminal / ..`
	- Move `.self` to `.terminal`
	- Terminal expectation ; could also be arbitrary structure again.
`.traverse / .all / .map / .any`
- initial/terminal, basically, which direction and then whether to skip the thing you're currently at. (direction by a ray abstract-level higher.)
- .traverse is move self to .terminal
- the "teleport over thing" could just be the calculus of slow destroying the green ray on a side of the direction you want it to move to, hence moving it from vertex to initial to following the thing
- becomes ignorant of `.all`, pick something, or allow in parallel from this perspective.
- places another ray at another level of description, pointing that way (for .initial.traverse or .self etc.. .traverse)
- `.all` / `.any` pending/.../lazy to generate things from those pointers.
- `.all` if looking for boundary, `.any` if looking for vertex.
Continuity
- vertex->vertex from initial/terminal means no access in between.
Traversing `.self` 
- Like [[Jonathan Gorard]] mentioned inability to parallize obstruction to causality - in the sense of cant traverse the .self ray fast enough to parallize like the superposition of a larger structure, hence it breaks on the further away things on .self
	- Trade-off between branching spatial extent
- Traversing `.self` without time-step would be a projective plane? ; So this could be relatively be constructed in certain settings.
	- a recursive definition of a projective plane but then (partially?) accessible as a calculus?
`.is_equivalent = a.self.traverse.is_orbit(b.self.traverse))` Basically: does there exist a single connection between the two?
- Then homotopy equivalent, when a particular perspective allows to collapse some ray to a single point/empty.
	- similar to copying again, move from one vertex which branches into two, is similar to having a ray which holds the initial on either side. Basically just removing the left one, this being the mechanism to collapse the entire graph to a point. Where in the case of cohomoloy, something stops this from happening. Additional structure at each of the points perhbaps? ANother layer of descriptionwhich says there's something in between.
	- Homotopy equivalence merely as some direction/reversibility constraint on some direction, ignoring additional structure (or incorporating it into the equiv) at the vertices. (Could be loosened where certain vertex-equivalences are also part of the homotopy)
	- ; follows from matching rewrite structure&merge ; If some underlying level of description doesn't match the relations at the other level of description we're using for equivalencies / hence homotopies. Then don't permit the invariance/variance and force no difference. Hence any equivalencr necessarily implies possible homotopies. Whether those spaces can actually be differentiated between to create infinite continuous differences between those points ss enumeration of possible homotopies isn't necessarily that obvious in the embedded space ; the underlying level of description  
- "Hyperdistance Oracles in hypergraphs" seems obvious from the perspective of Ray? ; it's just traversing `.self` from some perspective instead of other things.
- equivalence is an inconsistency from some perspective (and the other way round)
`.none` Many ways of phrasing this ; "it's explored/.../branched but dies", ..., "looked at, then ignored".
- none: initial direct to terminal, no vertex in between. & reference none for "select none"
- Like that you can also conceptualize multiple steps of none, initial -> initial -> initial -> terminal

`composition - equivalence - >` ; up the arity, probably makes less sense?

- noticing of runtime inconsistencies from some perspective ; adjustable
##### "Binary"
just list a few possible ways of constructing it.
- binary reverse op is also conceivable as initial/self/terminal over two possible values
- orbiting ray around it / bouncing off the edges
- ...

- [ ] ; ideas from the notebooks
Encoding/symbols..
- Perspective of 0/1,
- What is we interpret 0/1 as our frame, then it becomes something else.
	- Then it becomes hey: "I keep being at this same place from this perpspective, hence the assumption: constantly a boolean/binary value, -> creaton of some loop through homology?"
- Hence, from this point, one might say the binary sequence are two high-dimensional points (lcoally connected).
- "Some line as saying: anything on it is the frame and deemed the same, all deemed as ignored, all deemed as the identity"

##### "Superpose in more detail"

- `qubit / linear superposition / complex numbers` is a binary superposition, ..., orbit, which is differentiable in between steps (basically, if something else from outside the context can reach in between, it would find something there. ; Based on that precision). So `qubits, orbits, higher-arity structures, ignorance along rays`, same thing?.
	- "Can abstractly only satisfy a loop through another loop? While pattern matching?"
	- Some way to conceptualize a qubit as pattern matched on any other thing ; similar to the "push structure inside thing."
	- ; So that would be like finding the higher-arity structure there, and selecting it like the vertex on vertex, having it branch off.
	- ; So similarly, it's infinity groupoids which break the recursion of the stack. So the `.is_orbit`s.
	- Usual superposition is where every entry of an arbitrarty direction only references itself on the `.self`. Hence a tensored variant like this in linear time, if you can traverse that in one step.
	- At every branch cotains the one added thing necessary for spliting the vranch for conservation, but that destroys the embedding if that wnats to be prrserved, ?
	- DIfference between a bit and a qubit is that in the case of a qubit we assume differentiability between. But for a bit also we assume modularity of the two options. Or different boundaries, What about on the frame/middle, what about ...

direction at the point**: What does it mean for a point yo become its own direction? ; function becoming data becoming toplogies becoming ..

Tripple superposition, two continuated (two perm), binary superposition  

- Could use closensss as the initial/twrminal question and addition dimensionalities as the expansion of the additional rays. Could also create some automatic way of folding the ray structures onto a high dimensional tensor which preserves its steucture relative to the functioms applied to them theough gpu. Would have to check whether this is better than writing code in the way things like cuda/hip/ write the gpu kernels for gpgpu

Local .orbit instead of composing at .terminal? ; pulling further-away stuff into this ; locally

- [ ] Expanding superpositions to there permutations (a simple rewrite rule?) - For the general case? (/combinatorics)
- [ ] Using them for fractal expansion - shoving structure in between.


##### Arbitrarily branching, stepwise, superposed, ..., partial traversal & equivalences
*better name*

- [ ] Non-commital ignorance, lazy functions ; Carrying of an initial/terminal from a reference without traversing the direction
	- [ ] Similarly: unresolved pointers, cut off/short, pending, waiting for ..
	- [ ] 'Unintended'/'Unrealized' effects realized? / Resources one didn't know one is consuming etc... (unknowns)  


The concept is never really direct execution, and if it is, that's often more like ignorance. Basically, arbitrary lazyness. Like this we basically rephrase "output" or "halting" as "what if we assume it halts here". Inaccessible, ..., Ignorant ones turn into the inability to ask that question.  

@see "What if this wasn't the case?" https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=%22What%20if%20this%20wasn%27t%20the%20case%3F%22

In the case of Rays, whether something is a vertex/initial/terminal is only inferred from surrounding context. And these checks only need to happen locally in order to decide how to traverse arbitrary structure (as in - I only need to check the presence of something next to me, not traverse the whole direction recursively in order to decide what to do).

Leaves the following questions:  
- [ ] How to define currently trying some directionality: waiting for some function, perhaps some partial state acquirable? ; parallel, one at the completion step, the other in between still waiting
##### Fuzzing / discovery
Partially, locally, ... (same as on orbits)

- [ ] Brute-forcing if no better alternative has yet been found? ; try to explore combinatorial exploding spaces.
- [ ] Solving ambiguity with additional context ; tolerance of ambiguity
	- [ ] In reference to the idea of not having access to the details of what some point is, then gaining them, there is an ambiguity on where exactly one mentions the structure. Ambiguity arises from this ignorance of structure.
	- [ ] You want to allow for ambiguity, and ways of resolving it.
	- [ ] Then combating it would be: Want to collapse it, snap the modular structure. To converge to some structure (which could still be used as a modular space), but is now realized as not one within that context.
	- [ ] Relate to [[Project - Indexing existing Abstract Models (2024-2025?)]] ; closeness/how quick does it fit your structure
- [ ] Making a non theorem a theorem holding all properties and symmetries except its initial violation. It's not necessarily: "But that's not inside the definition of what this thing is supposed to be" - it's merely, well apparently I can do this, so your abstraction/description/implementation/... is clearly ignorant of something (obviously).
- [ ] Deletion of information

- [ ] Unknowns & inconsistencies driving curiosity?   ; same with items, finding hints of possible quests to pursue

*Unusual exploration, sporadic, probing*
- TODO: How about treating something like something which the context says it's not? (Could apply this sort of thing in some fidelity/consistency checking mechanism as a way of fuzzing the fidelity mechanism)
	- Trying again: doesn't change?
- practical guesses

Whether either end, once found in isolation, can have itself be linked conceptually to its counterpart, is the interesting question. ; What can we say about the information when we are missing or thinking corruption of it? - ; compression

Compression
Allows for a generalization of geodesic (partially)
- One could simply see it as additional resources, capabilities, function, however one wants to define it. It generally can (and should) alter possible compression for anything that follows.
- Any function or structural access poses limitations and offers functions ; non-trivial superpositions 
- https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Such%20expectations%20however%2C%20as%20a%20prediction%20relying%20on%20some%20invariance.%20Is%20an%20assumption%20at%20risk%20of%20being%20violated.
 curvature and noncompressability ; tweet ([[Jonathan Gorard]])

- [ ] Against forgetting/violation/inconsistencies
	- [ ] Forgetting but remembering one has forgotten - structure, but acknowledgement, structure is missing.
	- [ ] It's crossing some directionality and finding one cannot return back? (That would imply next time step or something - any inconsistency possibly 
	- [ ] differently structurally forgetting
	- [ ] Testing/Simulating: Does a certain property still hold; what if not and deemed violated?  
	- [ ] How could failures be detected? How can failures be prevented? 
	- [ ] Redundancy: redundancy defined as aiding the resolving of unresolved values? (if compression is the goal: least redundant, if the goal is adaptability; sparsity)
	  - [ ] Run multiple simultaneous processes which are supposed to do the same thing - compare  
	- [ ] Self-imposed limitations to see if that can be sufficient  
		- [ ] "What if I were to treat this as forgotten, what would happen?"  
		- [ ]  - fidelity: If I don't check, I assume it will be consistent, if I do check, I assume the checking will be consistent. ; What to do when certain types of consistency fail?  
		- [ ] If ones particular assumption falls it can be caught up by another: If some abstract form of time isn't necessary then one can revert to theories that allow perfect symmetries of relations which are not described by computation. ...etc. How would one invalidate the whole thing?  - safety mechanism for tests - or at least, that would be assumed
	  - [ ] Try limitation on hardcoded relationships between things: Visual representations, symmetries of them etc..  
	  - [ ] Testing/Simulating with fewer resources, see how that impacts behavior; temporal/visual/... (Modeling resources?)
	  - [ ] Not having access to inner perceived structure (transduction/..)/equivalency rules  
- [ ] Keep pulsing certain directionalitiws for changes in sone "does it continue", agift behavior based on such changes
- [ ] Proved in some finite space as opposed to general one.  
- [ ] Dangers of simulating ignorances (removing certain inhibitions; (same for safety constraints in some sense..))
- [ ] 'Monkey testing':/.../fuzzing Random changing values/random forgetting: Simulating, what would happen?

##### Different levels of abstraction simultaneously, ..., simulation


##### Self-referential operators & multiple abstract implementations
- Note that whenever you have a self-reference through operators, that requires an implementation to break this self-reference. For example ray functionality only requires initial + negative, or terminal + negative, or initial + terminal, to make all the other three.

##### On Naming, ..., Grouping
This is basically: When to decide that perspective switches should have a different name associated with them, when they can probably be thrown in a bag with other stuff: I.e. Why is it so significantly different it should be separate?
 - ex: TODO: Do I want to keep the is_equiv/is_composed pattern? Or simplify to one of the two?

encoding usually ignorant of its use

##### Mathematics, Physics, ..., Dynamics

Yellow is how you could define zero. Or a selection pointer on pink. ; Basically you can define the boundary as a zero point. ; "split point between opposites" ; "distinguishability begins here for modular structure" ; ... "selection"
![[Pasted image 20240501193810.png]]

Mathematics as ignoring `.self` ? or something close to it.

Defer to [[Jonathan Gorard]]'s work, for more physics details there. As for example this: ["The boundary of a boundary is always empty."](https://twitter.com/getjonwithit/status/1784599157015007391)

- Some of my intuitions of physics
- Something like: Constantly all the rays as functions are executing (in orbits), then if something causes something else's behavior to change, you get the inconsistencies.
- Wrong dynamics from a particular perspective, often probably still keep traversing.

"Even wrong profram dynamics still work"

With some physics connections here as well:
- Then energy conservation (if it holds up), could be using anything to the initial sides (casual histories/or some structure/.../topology) and shove them in the traversing direction until there's nothing there. And hence we stop branching and in some ways collapsing in the sense of the teminal side then doing that similarly to the initial side.
- Could like this be much more non-trivial based on the structure being pushed in exploring the branches ; i.e. like that similarly determining which and how the branches are explored.
- Fitting another layer of abstraction on the structure which determines the following direction (or generally this could be phrased as inferred from context) .terminal here is possibly undefined. ONly needs presence, no recursion checks. Concurrency issues then in many cases resolved, through always being associated with a particular direction. (See note)

Hermission/herminisity /time reversal; i.e. ray swap ; look up hermission?

Blackhole as boundary?

---

How to phrase storage as compute? It's using some compute to persist some structure, though we might not know how to use it for anything else than storage, this is essentially the case. All equated as the same resource? Persistence/Compute/Effort/resources  

---

How about phrasing that nothing there as traversal branching into a small local black hole. So more structure more of these small black holes, could you phrase energy release as these local realizations of some 'nothing' as the things that have actually built up additional energy you otherwise wouldn't see?

Perhaps like this: Equality is admission of a difference and the ignorance of it. ; like them semf livestream again

Ah the rewrite, similar to the structure itself, require the presence answer to three things beside it
3 for the checks (duplication & traversal)
+3 for the orbit checks?
and 3 for 

Can implement the ignorances through those traversal layers on branches which dont go left/right but only one direction?

it';s the freference thing, evidently you can reference things without a direction connection, the point is not to ignore that idea, but to try to find a way to phrqase that that's possible to setup

---

Invariances at star hence a modular structure might be a necessity physically, forcing necessarily a finite accessible structure possible allowing it to grow?

split off branching initial remainin o. the temrinal the ret marching along

---

At every branch comtains the one added thing necessary for spliiting the vranch for conservation, but that destroys the embedding if that wnats to be prrserved

---

- ? Better variant of : *Compose as Equivalence as Compose*
	- Equivalence at continuation is parallel composition

#### No memory
The basic premise is this, there might be arbitrarily complex structure around me, but I need to start traversing to find out what it looks like. So the screen being a form of memory, and me 

#### Version control
persisting structures otherwise forgotten whose rediscoverability is not entirely obvious. 
 "What if I did not know about something, nor could rely on these particular discoveries, how would and could I rediscover this something?"

#### Equivalences
- Global changes from local equivalences
- Can just move the terminal which holds the pointer to the boundary
- Is equivalent ; Can A & B be found on the a line/ray/graph? - Or a particular one

-  A traversal = copy = compile = .... (compute?)

- Induced ignorance/equivalence along arbitrary rays. = Equivalence

- Context is defines what something looks like from a particular perspective: Or: "What it is"

### Traversing
-  Dereferencing is likely in many cases quickly subject to infinite stepping (similar to INITIAL -> INITIAL, TERMINAL -> TERMINAL, VERTEX -> VERTEX. (Could be that this means that there's no continuation, a self-reference defined here, or it's some mechanism of halting.)
	- Simple example of infinitely finding terminals, or a reference to 'nothing - infinitely'.
	- If both are references, allow deref of both in parallel? - for later probably
- Rewriting as placing the direction encoded as `.type` of initial/vertex headed to terminal. Where terminal is undecided (from the perspective of `.terminal`, can recursively be the case for any of these.) - So .initial is VERTEX, .self is TERMINAL, which means this .terminal returns ... (Basically abstraction layer fitting the structure - See [[2024-03-28]] note.)


#### Rendering engine
[[Project - Research towards Designs (2024)]]
- Different OS & browsers - intercompile

---

# A Universal Language
This thing is, in essence, a language to understand inconsistencies. A conceptual framework to make sense of ambiguity: A story of how destructively confusing languages can be. Though to me, most importantly, it is here as infrastructure. Infrastructure for the design and implementation of a <Reference is="reference" index={referenceCounter()} reference={{link: _2024_02_ORBITMINES_AS_A_GAME_PROJECT.reference.link, title: "different category of (programming) interfaces"}} simple inline />.  
  
<BR/>  
  
<span style={{textAlign: 'left', minWidth: '100%'}}>A simple way of phrasing this, is that the concept of a <span  
    className="bp5-text-muted"><span  
    className="bp5-text-disabled">(hyper-/)</span>'Vertex', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Edge', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Graph', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Rule', <span  
    className="bp5-text-disabled">(hyper-/)</span>'Tactic', <span  
    className="bp5-text-disabled">(hyper-/)</span>..., <span  
    className="bp5-text-disabled">(hyper-/)</span>'Rewrite'</span> are merged into one thing: a Ray. It handles <span  
    className="bp5-text-muted">surrounding context, ignorances, equivalences, ..., differentiation</span> (And if it cannot, then it offers a way of implementing it for all of the above).</span>  
  
<BR/>  
  
<span style={{textAlign: 'left', minWidth: '100%'}}>Though quite importantly, even if those previous words are complete nonsense to you: Either this, or projects following from this, will aid in your understanding. This is the start of a story which will provide infrastructure for communication between all <span className="bp5-text-muted">sciences, (programming) languages, compilers, interfaces, ..., videogames</span>.</span>  
  
<BR/>  
  
Let me show you how.