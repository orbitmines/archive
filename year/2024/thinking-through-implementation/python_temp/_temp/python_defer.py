
# def free(self): raise NotImplementedError
def reverse(self) -> Ray:
  return Ray(initial=self.terminal, self=self.self, terminal=self.initial)
def as_string(self) -> str: raise NotImplementedError
def as_int(self) -> int: raise NotImplementedError
def as_list(self) -> list: raise NotImplementedError
def as_tuple(self) -> tuple: raise NotImplementedError
def as_iterable(self) -> Iterable[Ray]: return self
def as_async_iterable(self) -> AsyncIterable[Ray]: return self

