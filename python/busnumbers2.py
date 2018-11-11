n = int(raw_input())
ub = int(n ** (1./3)) #upper bound
solutions = {}
for i in range(1, ub + 1):
    for j in range(i, ub + 1):
        s = i**3 + j**3
        if s in solutions:
            solutions[s] = (i, j, solutions[s][2] + 1)
        else:
            solutions[s] = (i, j, 1)
            
maximum = 0
for key in solutions.keys():
    if maximum < key and key <= n and solutions[key][2] > 1:
        maximum = key

if maximum in solutions:
    print maximum if solutions[maximum][2] > 1 else "none"
else:
    print "none"