from math import factorial
T = int(raw_input())
for i in range(T):
    N = int(raw_input())
    s = str(factorial(N))
    print s[len(s) - 1]