
### A textual programming language to relate to the hypergraphs?
- Also allow other programming language syntax?

Third iteration;

Combining multiple properties syntactically: A.(B = 3 & C = 4), A.(B = 3, C = 4) ... or something else.

```
a = 1
b = 2
ab = 41 --> [a, b] = 41 | ab = 41
[a, b] = ab --> [a, b] | ab=3
a-b-c.x


/// (.)
/// .
/// .identity
/// .() | .eval | .evaluate
/// .move(loc)
/// .clone(loc)
/// .= (| = )
/// .: (| : )
/// 
/// .|
/// .->
/// .<-
/// .ignore
///
```

---

Second iteration;


... where the cursor would be the ? ; likely
 ```
LHS'.'RHS 
 
(A)     (B)                 // apply A      to B
(A)     (.)                 // apply A      to .
(.)     (B)                 // apply .      to B

(A(.))  (B)                 // apply A(.)   to B
(A)     ((.)B)              // apply A      to ((.)B)

(A.)    (B)                 // apply A.     to B
(A)     (.B)                // apply A      to (.B)

A       .       B           // apply B      to A
(A)     .       (B)         // apply B      to A


A.B         // apply B to A
A(B)        // apply A to B
(A)         // interpret A as a single Node2

(A.B).equivalent -> 5     // A.B can be rewritten as 50

A               // A -> ?               ; How could A be related? (; conceptually arbitrary)
(A)             // (A) -> ?             ; How could (A) be related? (; conceptually arbitrary)

A()             // A -->(_ -> _)        ; What could A be applied to? (; arbitrary input / output)
A(?)            // A -->(? -> _)        ; What could A interpret? (; arbitrary input / output) ; attention at input
A() = ?         // A -->(_ -> ?)        ; What could A reduce to? (; arbitrary input / output) ; attention at output
A(B)            // A -->(B -> ?)        ; What would happen if A is applied to B? (; conceptually arbitrary output)
A(B) = ?        // A -->(B -> ?)        ; What would happen if A is applied to B? (; conceptually arbitrary output)
A(.)            // A -->(. -> ?)        ; What would happen if A is applied to .? (; conceptually arbitrary output)

if .... holds
AB              // A -> B               ; a relationship of A -> B
(AB)            //                      ; How could (AB) be related? (; conceptually arbitrary)

A.              // ? -->(A -> _)        ; How could A be interpreted? (; applying function conceptually arbitrary, as for output)
A.:             // : -->(A -> _)
A:              // : -->(? -->(A -> _))
A.B             // B -->(A -> ?)        ; What would happen if B is applied to A? (; conceptually arbitrary output)
(A.B)           //                      ; How could (A.B) be related?
(A.B).=         //                      ; What would happen if (A.B) is appl ied to =? (; conceptually arbitrary output)
((A.B).=)       //                      ; How could ((A.B).=) be related?
((A.B).=)( )    //                      ; What could ((A.B).=) interpret?
((A.B).=)(C)    //                       ; What would happen if ((A.B).=) is applied to C? (; conceptually arbitrary output)

All the 'more explit' syntax can de dropped, but could result into superpositions of interpretabilities...

A 
A B
A B
A B =           // (or also A B)
A B =           // ..
A B = C

?.B

Variables as realized unresolved values...

Ignorance // Added Ignorance // Reversed Ignorance ... -> non-trivial

..


A
AB
AB
AB= | AB
AB= | AB
AB=C


Mathematical names for these kinds of rewrites...

A.move(location)
A.(location.move)
A.location.move
location.(A.move)
location.A.move
move(A.location)
move(location(A))

What if A = B? --> Self-inflicted ambiguity
Is A = B? --> Fidelity checking
A = B --> Trust/ignorance of prefect observations of above; allow A to be rewritten as B. 

```

---

First iteration;

```

|--A--|

A(B)        (A)|--B-->--OUT--|           -  A-->(B-->_)
B.A         (A)|--B-->--OUT--|


If A.B = B.A => Commutative; inhibitory extreme on order of computations. (Inherently inhibitory on a time-dimension)

A.identity = A

A.move
move(A)

--

infinity: ... (conceptually; keeps going)
base_information_carrier: 0 | 1
arbitrary: base_information_carrier...

(...) : node : some arbitrary sequence/structure as a single node
(bit | node)... (arbitrary sequence)
0 | 1 : bit
(bit | node) -> ((0 | 1) | node) or inlining: (0 | 1 | node)  // Any rewrite rule as a superposition on inlining / non-inlining?

```


```
Rewrite rule, first checks equivalency of the rule to the state. (Which can be faulty). Then allows applying it. --> This is validation, and the same as two functions. One for if it matches, the other the actual implementation.

Permutations & Cardinality

A : (A | Uncertainty)

Rewrite rule: Transformation of some state, while being inhibitory on everything outside the state.

A : B       // (A : B).english : ((A) can be rewritten as (B))
A.english : // A
if A        // (if A).english : if.english A.english : if A.english
if A : B    // ; if (A : B).english : if ((A) can be rewritten as (B))


(if A) : (A = 1).check (--> check or '==' (is equivalent) or ..)

(A.B | B.A).commutative = true if (A.B : B.A)

...
if (A.B).B : A.B 

```

```
: -> 'adds' Can be rewritten as (explicit bi-directional relationship, where the inverse could be a hard problem)
= -> 'sets' Set equivalent to (would track history); more like 'must be rewritten as'.

Notice:
(A : B : C) = (A = (B | C))

(A : B) : C != `Rewrite rule (A : B) can be rewritten as C`

A.:(B.:(C))

A : B : C if (A : B) & (A : C) & (B : A) & (B : C) & (C : A) & (C : B)

(While 'setting' doesn't actually happen, it's mor still be interpreted as something
it was previously set to; unless that history is inhibited. (or actually deleted, which could be categorized as unknown inhibition))

A    : A
A    : A.identity
A    : A()      // A can be rewritten as A(). (; rewrite rules; equivalence in some sense that they can be transformed into one-and-other)
A    : A(.)
A(.) : A.

Differentiate between prediction of functions & modelled superpositions of output/input/func. Try to make a generalization
then test it for some values, or construct reasoning why that function would always work conceptually.

Conceptually infinite, under these constraints it'd be this...

```


```

if (A.B).B : A.B.B     // ; The evaluation of A.B is not necessary for the 'final' result. (; or, can be simplified / compressed)
```


