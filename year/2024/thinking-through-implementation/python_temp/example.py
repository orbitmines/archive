from ray import Ray, ray

if __name__ == "__main__":
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
