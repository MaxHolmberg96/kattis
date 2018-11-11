import math

def lcm(x, y):
    return abs(x * y) / math.gcd(x, y)

l = input().split()
print("yes" if int(l[0]) * int(l[1]) <= int(l[2]) or lcm(int(l[0]), int(l[1])) <= int(l[2]) else "no")