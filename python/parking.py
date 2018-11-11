def count_trucks(time, arrival1, depature1, arrival2, depature2, arrival3, depature3):
	c = 0
	if arrival1 <= time and depature1 > time:
		c += 1
	if arrival2 <= time and depature2 > time:
		c += 1
	if arrival3 <= time and depature3 > time:
		c += 1
	return c

A, B, C = map(int, raw_input().split())
total = 0
arrival1, depature1 = map(int, raw_input().split())
arrival2, depature2 = map(int, raw_input().split())
arrival3, depature3 = map(int, raw_input().split())

depature_max = max(depature1, max(depature2, depature3))
for i in range(1, depature_max + 1):
	c = count_trucks(i, arrival1, depature1, arrival2, depature2, arrival3, depature3)
	total += A * c if c == 1 else B * c if c == 2 else C * c

print total