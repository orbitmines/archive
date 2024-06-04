Should
be
automatic:
So
all
self.initial -> (-self).terminal
# TODO is_initial = return (-self).terminal().is_none ??

#
# Opposite aliases  # TODO: Could just dynamically assign these - the case for any reversible thing (next/previous, initial/terminal ...) always: A.something and (-A).something
#

as_initial = (-self).as_terminal()  # TODO: These sorts of deductions should be automatic, here as an example

(-self).a = self.b
-(self.a) = self.b

is_orbit /  # a.___instance === b.___instance


# @staticmethod
# def ring() -> Ray: return Ray.none.orbit TODO, modulus by default ;

# TODO: Autogen these from is_vertex/terminal etc..
@staticmethod
def reference(ray: Ray) -> Ray:
  return Ray(initial=Ray.none, self=ray, terminal=Ray.none)


def as_reference(self) -> Ray: return Ray.reference(self)


def as_vertex(self) -> Ray: return Ray(initial=Ray.some, self=self, terminal=Ray.some)


def as_initial(self) -> Ray: return Ray(initial=Ray.none, self=self, terminal=Ray.some)


def as_terminal(self) -> Ray: return Ray(initial=Ray.some, self=self, terminal=Ray.none)


autogen
these
# def __iadd__(a, b: Arbitrary) -> Ray: return a.assign(a.add(b))
# def __isub__(a, b: Arbitrary) -> Ray: return a.assign(a.sub(b))
# def __imul__(a, b: Arbitrary) -> Ray: return a.assign(a.mul(b))
# def __ipow__(a, b: Arbitrary) -> Ray: return a.assign(a.pow(b))
# def __itruediv__(a, b: Arbitrary) -> Ray: return a.assign(a.div(b))
# def __imatmul__(a, b: Arbitrary) -> Ray: return a.assign(a.matmul(b))
# def __ibor__(a, b: Arbitrary) -> Ray: return a.assign(a.bor(b))
