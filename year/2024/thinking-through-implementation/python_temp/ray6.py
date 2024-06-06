


def has_next(self) -> Ray: return self.next().is_some

#
# If there exists an orbit between A & B anywhere on their equivalency functions - or: their .self - (except for the directions through which we're referencing them)  #  # Note the connection between 'is_orbit' vs 'is_equivalence'. They're essentially the same thing, but:  #    - in the case of 'is_equivalence' we directly have access to their difference but are explicitly ignoring them - in the context in which this functionality is called.  #    - in the case of 'is_orbit', we might need to do more complicated things to acknowledge their differences - we don't have direct access to them.  #  # TODO: (so dually connected, what if only one is aware??) Or basically just ; the answer in this particular instance is just if either end can find the other only once. Consistency of it defined on a more abstract level...
#
# a.self().traverse().is_orbit(b.self().traverse())  # @alias('includes', 'contains') ; (slightly different variants?)
def is_equivalent(self) -> Ray: return self.is_composed.from_perspective_of(self.self)

# a.traverse().is_orbit(b.traverse()) // Basically: does there exist a single connection between the two?

def is_composed(self) -> Ray: return self.is_orbit.from_perspective_of(
  self.traverse)  # Needs some ref from Ray.Function.Self.


# TODO: This should accept Ray: Where 'size' is just a 'shape'
#  -> Should be generalized as any kind of structure, but with this thing repeated on it. ; use traversal or ...
#  # Performing a copy (realizing it) can be conceptualized as traversing the entire structure. (Where the 'entire structure' means the current instantiation of it - with many ignorances attached)  #  # - A problem with a copy, is that in or to be generalizable, it needs to alter all references to the thing it's copying to itself - this cannot be done with certainty.  #    - This copy does not do that. Instead, it is ignorant of other things referencing the thing it's copying.  # - Additionally, a copy necessarily has some non-redundancy to it:  #  # @see "A copy is necessarily inconsistent": https://orbitmines.com/papers/on-orbits-equivalence-and-inconsistencies#:~:text=If%20I%20have%20one%20thing%20and%20I%20make%20a%20perfect%20copy
def size(self, b: Arbitrary) -> Ray:
  # // or
  #    // (self) => self.self.copy.reference()     #    (self) => none().self = self.self.copy()     #     #      // TODO Relies heavily on the execution layer to copy initial/terminal etc... ; and an is_orbit check before calling copy again. - Then again on the execution layer it can lazily do this copy (by not evaluating (i.e.) traversing everywhere), or it first does this traversing directly.

  pass


