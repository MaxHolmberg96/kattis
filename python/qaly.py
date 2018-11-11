n = int(raw_input())
sum = 0
for i in range(n):
    line = map(float, raw_input().split())
    sum += line[0] * line[1]
print sum