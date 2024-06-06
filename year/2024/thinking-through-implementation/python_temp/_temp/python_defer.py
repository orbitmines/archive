
# def free(self): raise NotImplementedError
# TODO: Destroy the current thing, connect .initial & .terminal ? (can do just direct connection, preserves 'could have been something here') - then something like [self.initial, self, self.terminal].pop().
# TODO: Leave behind --] [-- or connect them basically..


def reverse(self) -> Ray:
  return Ray(initial=self.terminal, self=self.self, terminal=self.initial)
def as_string(self) -> str: raise NotImplementedError
def as_int(self) -> int: raise NotImplementedError
def as_list(self) -> list: raise NotImplementedError
def as_tuple(self) -> tuple: raise NotImplementedError
def as_iterable(self) -> Iterable[Ray]: return self
def as_async_iterable(self) -> AsyncIterable[Ray]: return self

# @staticmethod
# def ring() -> Ray: return Ray.none.orbit TODO, modulus by default ;


# def __iadd__(a, b: Arbitrary) -> Ray: return a.assign(a.add(b))
# def __isub__(a, b: Arbitrary) -> Ray: return a.assign(a.sub(b))
# def __imul__(a, b: Arbitrary) -> Ray: return a.assign(a.mul(b))
# def __ipow__(a, b: Arbitrary) -> Ray: return a.assign(a.pow(b))
# def __itruediv__(a, b: Arbitrary) -> Ray: return a.assign(a.div(b))
# def __imatmul__(a, b: Arbitrary) -> Ray: return a.assign(a.matmul(b))
# def __ibor__(a, b: Arbitrary) -> Ray: return a.assign(a.bor(b))



aliases
# .none @alias('alloc', 'new', 'create', 'initialize')
# .some @alias('self_reference')
# .reference @alias('pointer', 'cursor')
# .free @alias(destroy = clear = delete = pop = prune)
# .compose @alias(continues_with, merge)
# .last @alias( end = result = back = output = max)
# .orbit @alias(modular, modulus, circle, repeats, period, infinitely)
# .__eq__ @alias(is_orbit)
# .__and__ @alias(_and)
# .__or__ @alias(_or)
# .__add__ @alias(add)
# .__sub__ @alias(sub)
# .__pow__ @alias(pow)
# .__trudiv__ @alias(div)
# .__xor__ @alias(xor)
# .__matmul__ @alias(matmul)
# .__mod__ @alias(mod)
# .__ge__ @alias(greater_than_or_equal_to)
# .__lt__ @alias(less_than)
# .__str__ @alias(as_string)
# .push_front @alias(__rshift__)
# .push_back @alias(__lshift__)
# .first @alias(beginning, front, min)
# .__aiter__ @alias(as_async_iterator)
# .__iter__ @alias(as_iterator)
# .boolean @alias(bit, two)
# .reverse @alias(neg = __neg__ = __invert__ = opposite = _not = converse = negative = swap)
# .self @alias(element = dereference = selected = selection = cursor = auto) # TODO: branch?
# .terminal @alias(next = __call__ = __next__ = __anext__ = forward = step = apply = run = successor \
    = map = render = compile = realize = generate)
# .initial @alias(previous = backward = decompile = predecessor)
# .__set__ @alias(assign)

reverse
# TODO ; Could also be implemented as copy - hence the __call__ on Ray() - this is the case for any sort of constructor/type.

size/add/pow... (basically copies/merges, different perspectives/context)
  # size = length = no params different behavior
  # resize = structure  mul = __mul__ = times
  # duplicate = copy = clone = size.from_perspective_of


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

#  TODO: Are these "GLOBAL" varibles from the perspective of the ignorant setup - or more accuarrately something which it could be made aware of.
# TODO: WHILE = WITH = SCOPE = CONTEXT = GLOBAL = //... (= DEBUG/LISTENER/OBSERVER/WRAPPER / MONAD)
enter / exit


@staticmethod
# - TODO: readonly setup, where only traversal ops are allowed. Of course these are writing in some sense, but those writings aren't directly accessible from this perspective
def readonly() -> Ray: raise NotImplementedError
# TODO: Runtime with its read/writeonly, basically (non-/)availability of write operations. Where read operations are already also write operations from another perspective, just not the one accessible here.

# TODO, writeonly would be?

# Any arbitrary direction, where reversing the direction relies on some arbitrary memory mechanism
def memoized(self) -> Ray:
# = cached
# TODO: Better ideas what local caching looks like, (i.e. put it in some local structure to cache, this can be delayed till some useful implementation is ready)
# res = self.next
# res.initial = self    # return res    raise NotImplementedError

Arbitrary = Union[int, Ray]

def as_javascript() -> str: raise NotImplementedError
def runtimes() -> Ray: raise NotImplementedError
def compiler() -> Ray: raise NotImplementedError


def radd(self) -> Ray: return -self.add.perspective
def push_back(a, b: Arbitrary) -> Ray: return a.last().compose(b)
# TODO: lshift/rshift respects the .size of the ray. So it's push_back & pop front, or in certain interpretations, we might keep and not pop...


def from_perspective_of(a, b):
  raise NotImplementedError
def perspective(self) -> Ray: raise NotImplementedError

# def filter / search

#
# - Like with 'copy' and all concepts: Note that we're only after reversibility after ignoring some difference.  #  # @see "Reversibility is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=Another%20example%20of%20this%20is%20reversibility
# TODO: Make use of extremes (.last/.first as extreme
def orbit(a, b: Arbitrary) -> Ray:
  # - TODO: If we're only doing one end: This already assumes they are connected on the other end.
  # - TODO: should be a connection here, with is_composed ; or "reference.is_equivalent" so that you can drop one of the sides, or both.
  b.last().compose(a.first())
  a.first().compose(b.last())

  return a