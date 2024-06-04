# TODO, wraps in @ray
for name, fn in inspect.getmembers(Ray, inspect.isfunction):
  setattr(Ray, name, wrapped(fn))
  pass
  # if name.startswith('__'): continue
  # setattr(Ray, name, Ray.function(name, fn))    # setattr(Ray, '__mul__', Ray.function('__mul__', Ray.size))    # ray.__init__ = lambda self: self    # a: Callable[[Ray], Ray] = lambda self: self.is_terminal    # setattr(ray, '__mul__', lambda self: self)    #
  # TODO: Map the radd, rsub, rmul, rpow, ....
  # Several ways of achieving these:
  #   -a.__add__.perspective(b)  #   Ray(b).__add__(a)  #   __add__ = -__add__.perspective (if python would allow for this)  #   ; TODO could be automatic

# Ray.__eq__ = -Ray.__ne__
# (Ray.__eq__ & Ray.__ne__).orbit  # [  #   (Ray.initial, Ray.terminal),  #   (Ray.__eq__, Ray.__ne__),  #   (Ray.__or__, Ray.__nor__),  #   (Ray.__xor__, Ray.__xnor__),  #   (Ray.__and__, Ray.__nand__),  #   (Ray.__add__, Ray.__sub__),  #   (Ray.__pow__, Ray.__truediv__),  #   (Ray.__lt__, Ray.__ge__),  #   (Ray.__gt__, Ray.__le__),  #   (Ray.__gt__, Ray.__le__),  #   (Ray.is_some, Ray.is_none),  #   (Ray.push_back, Ray.push_front),  #   (Ray.has_previous, Ray.has_next),  #   (Ray.first, Ray.last),  # ].all.orbit
# Ray.a = lambda self, b: print(b)  # Ray.__eq__ = lambda self, b: print(b)
# Ray.__add__ = -Ray.__sub__  # Ray.__sub__ = -Ray.__add__  return Ray

Ray = __ray__([1, 2, 3])

if __name__ == "__main__":
  Ray().a([4, 5, 6])


  @Ray.function
  def a():
    print('b')


  a.a([6, 7, 8])
  a.b([6, 7, 8])
  print(a == 'b')