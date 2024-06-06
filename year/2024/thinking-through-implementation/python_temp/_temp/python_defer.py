
# def free(self): raise NotImplementedError
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