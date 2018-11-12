#calculate fib numbers
f = [0] * 100002
f[0] = 0
f[1] = 1
for i in range(2, 100002):
    f[i] = f[i - 1] + f[i - 2]


for i in range(int(raw_input())):
print f[int(raw_input()) + 2] % (10**9 + 7) 