def is_on(n, k):
    return k % 2**n == 2**n - 1

T = int(raw_input())
for i in range(T):
    N, K = map(int, raw_input().split())
    if N == 1:
        state = "ON" if K % 2 != 0 else "OFF"
    else:
        state = "ON" if is_on(N, K) else "OFF"
    print "Case #%d: %s" % (i + 1, state)