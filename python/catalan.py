#from __future__ import print_function
import sys, math

def catalan_number(n):
    return int(math.factorial(2*n) / (math.factorial(n + 1) * math.factorial(n)))

n = int(raw_input())
for i in range(n):
    print format(catalan_number(int(raw_input())), "d")