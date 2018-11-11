n, dm = map(int, raw_input().split())
days = map(int, raw_input().split())
for i in range(n):
    if dm >= days[i]:
        print "It hadn't snowed this early in %d years!" % i
        exit(0)

print "It had never snowed this early!"
