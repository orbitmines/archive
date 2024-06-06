self.initial -> (-self).terminal
# TODO is_initial = return (-self).terminal().is_none ??

#
# Opposite aliases  # TODO: Could just dynamically assign these - the case for any reversible thing (next/previous, initial/terminal ...) always: A.something and (-A).something
#

as_initial = (-self).as_terminal()  # TODO: These sorts of deductions should be automatic, here as an example

from ray import Ray, ray

(-self).a = self.b
-(self.a) = self.b


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



    # @functools.wraps(func)
    def wrapper(*args, **kwargs):
        print('Ray.', func.__name__, args, kwargs)

    # return func(*args, **kwargs)
    return wrapper


setattr(Ray, fn.__name__, function(fn, name=fn.__name__))

def not_implemented(self: Any, *args, **kwargs: Any) -> Ray: raise NotImplementedError
for name in [
    '__mul__', '__getattr__', '__setattr__', '__get__', '__set__', '__delete__', '__call__',
    'none', 'some', 'initial', 'self', 'terminal', 'orbit',

    'shape', '__len__' # debugger uses these
]:
    setattr(Ray, name, function(not_implemented, name=name))

# Move aliases elsewhere?
# def alias(func: Callable[[Any, ...], Any], *aliases):  #   for alias in aliases: setattr(Ray, alias, func)  # alias(Ray.terminal, '__call__')



= "__main__":
    a = Ray.none
b = Ray.none
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

a().test()

# a, b = Ray.none * 2
print('a', a)
print('b', b)
print('c', c)
print('d', d)

.function


def test() -> Ray:


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
