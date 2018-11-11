cases = int(raw_input())
for case in range(cases):
    raw_input()
    first = map(int, raw_input().split())
    second  = map(int, raw_input().split())
    first.sort()
    second.sort(reverse = True)
    scalar_product = sum(i * j for i,j in zip(first, second))
    print "Case #" + str(case + 1) + ": " + str(scalar_product)