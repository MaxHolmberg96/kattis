import math
from decimal import Decimal

def euler_number(n):
    sum = 0
    for i in range(n + 1):
        sum += Decimal(1)/math.factorial(i)
    return sum

n = int(raw_input())
if n < 17:
    print "{0:.14f}".format(euler_number(n))
else: 
    print "{0:.14f}".format(math.exp(1))