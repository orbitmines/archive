from __future__ import annotations

import functools
import inspect
    from typing import Iterator, AsyncIterator, Union, Callable, Any, Iterable, AsyncIterable, Tuple


def __ray__(
# GLOBAL_ARGS & GLOBAL_KWARGS can be phrased as ignorant context? - TODO: Similar to enter_exit contexts. Or contexts far away we don't yet, or dont know how to get access to.
*GLOBAL_ARGS, **GLOBAL_KWARGS
):
class Ray:
# def initial(self) -> Ray: raise NotImplementedError
# def self(self) -> Ray: raise NotImplementedError    # def terminal(self) -> Ray: raise NotImplementedError
@staticmethod
def __new__(cls, *args, **kwargs):
return super().__new__(cls)

@staticmethod
def boolean() -> Ray: return (Ray.none * 2).orbit

def __init__(self, *args, **kwargs) -> Ray:
    pass

# @staticmethod
def function(func: Callable[[Any, ...], Any], name: str):
# @functools.wraps(func)
def wrapper(*args, **kwargs):
print('Ray.', func.__name__, args, kwargs)
# return func(*args, **kwargs)
return Ray()

return wrapper

for name, fn in inspect.getmembers(Ray, inspect.isfunction):
if name == '__new__' or name == '__init__' or name == 'function': continue

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
return Ray

Ray = __ray__()

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