from math import sqrt
def distance(a, b):
    return sqrt((b[0] - a[0])**2 + (b[1] - a[1])**2)

sx, sy, n = map(int, raw_input().split())
distances = []
for i in range(n):
    x, y, r = map(int, raw_input().split())
    distances.append(distance((sx, sy), (x, y)) - r)

distances.sort()
print max(int(distances[2]), 0)