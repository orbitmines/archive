


#
# If there exists an orbit between A & B anywhere on their equivalency functions - or: their .self - (except for the directions through which we're referencing them)  #  # Note the connection between 'is_orbit' vs 'is_equivalence'. They're essentially the same thing, but:  #    - in the case of 'is_equivalence' we directly have access to their difference but are explicitly ignoring them - in the context in which this functionality is called.  #    - in the case of 'is_orbit', we might need to do more complicated things to acknowledge their differences - we don't have direct access to them.  #  # TODO: (so dually connected, what if only one is aware??) Or basically just ; the answer in this particular instance is just if either end can find the other only once. Consistency of it defined on a more abstract level...
#
# a.self().traverse().is_orbit(b.self().traverse())  # @alias('includes', 'contains') ; (slightly different variants?)
def is_equivalent(self) -> Ray: return self.is_composed.from_perspective_of(self.self)

# a.traverse().is_orbit(b.traverse()) // Basically: does there exist a single connection between the two?
lf.is_orbit.from_perspective_of(
  self.traverse)

#  # Performing a copy (realizing it) can be conceptualized as traversing the entire structure. (Where the 'entire structure' means the current instantiation of it - with many ignorances attached)  #  # -



