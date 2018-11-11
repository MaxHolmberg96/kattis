import sys, math

case = 1
for line in sys.stdin:
    print "Case " + str(case) + ": " + str(int(math.log10((3**(int(line) + 1)) / (2**(int(line)))) + 1))
    case += 1