n = int(raw_input())
ballons = map(int, raw_input().split())
arr = []
arrows = 0
for i in range(n):
    if ballons[i] in arr:
        arr[arr.index(ballons[i])] -= 1
    else:
        arr += [ballons[i] - 1]
        arrows += 1
print arrows
