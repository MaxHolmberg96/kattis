def ch(n):
	days = range(1, n+1)
	candles = sum(days)
	candles += n
	return candles

n = int(raw_input())
for i in range(n):
	K, N = map(int, raw_input().split())
	print "%d %d" % (K, ch(N))