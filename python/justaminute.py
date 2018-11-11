n = int(raw_input())
l1 = []
l2 = []
for i in range(n):
	M, S = map(int, raw_input().split())
	l1 += [M]
	l2 += [S]
avg_min = (float(sum(l2)) / sum([i*60 for i in l1]))
print ("%.10f" % avg_min) if avg_min > 1 else "measurement error"
