self.initial -> (-self).terminal
# TODO is_initial = return (-self).terminal().is_none ??

#
# Opposite aliases  # TODO: Could just dynamically assign these - the case for any reversible thing (next/previous, initial/terminal ...) always: A.something and (-A).something
#

as_initial = (-self).as_terminal()  # TODO: These sorts of deductions should be automatic, here as an example

from ray import Ray, ray

(-self).a = self.b
-(self.a) = self.b

is_orbit /  # a.___instance === b.___instance



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
