def is_initial(self) -> Ray: return self.initial().is_none


def is_terminal(self) -> Ray: return self.terminal().is_none


def is_vertex(self) -> Ray: return self.is_initial().nor(self.is_terminal())


def is_reference(self) -> Ray: return self.is_initial() & self.is_terminal()


def is_boundary(self) -> Ray: return self.is_initial() ^ self.is_terminal()


def is_extreme(self) -> Ray: return self.self().is_none & self.is_boundary()


# def is_SOMENAME(self) -> Ray: "OPPOSITE OF REVERENCE" "--] [--", two boundaries to bridge "implicit manifold", dont like that name


# def free(self): raise NotImplementedError


def reverse(self) -> Ray:
  return Ray(initial=self.terminal, self=self.self, terminal=self.initial)


def as_string(self) -> str: raise NotImplementedError


def as_int(self) -> int: raise NotImplementedError


def as_list(self) -> list: raise NotImplementedError


def as_tuple(self) -> tuple: raise NotImplementedError


def as_iterable(self) -> Iterable[Ray]: return self


def as_async_iterable(self) -> AsyncIterable[Ray]: return self

