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