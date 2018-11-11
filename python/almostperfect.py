import sys
from math import sqrt

def divisors(n):
    list = []
    for i in range(1, int(sqrt(n)) + 1):
        if n % i == 0:
            if n / i == i:
                list.append(i)
            else:
                list.append(i)
                list.append(n / i)

    return list

for line in sys.stdin:
    n = int(line)
    a = abs((sum(divisors(n)) - n) - n)
    if a == 0:
        print "%d perfect" % n
    elif a <= 2:
        print "%d almost perfect" % n
    else:
        print "%d not perfect" % n