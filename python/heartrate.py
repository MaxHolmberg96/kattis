n = int(raw_input())
for i in range(n):
	b, p = map(float, raw_input().split())
	y = float(60*b) / p
	x = y - (float(60) / p)
	z = y + (float(60) / p)
	print "%.5f %.5f %.5f" % (x, y, z)

