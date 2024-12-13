#!/usr/bin/env python3

class A:
    def __init__(self, name):
        self.name = name

def make_a():
    return A('a')

class B(A):
    def __init__(self, surname):
        self.surname = surname

    def __str__(self):
        return 'B(name:%s, surname:%s)' % (self.name, self.surname)

    @classmethod
    def from_a_make_b(cls, surname):
        a = make_a()
        a.__class__ = B
        a.surname = surname
        return a

class C(A):
    def __init__(self, surname):
        self = make_a()
        self.surname = surname

    def __str__(self):
        return 'B(name:%s, surname:%s)' % (self.name, self.surname)

a = make_a()
b = B.from_a_make_b('B')
print(a)
print(b)
