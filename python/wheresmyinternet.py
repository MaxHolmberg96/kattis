from collections import deque

class Vertice:

    def __init__(self, name):
        self.neighbours = []
        self.name = name

    def add_neighbour(self, neighbour):
        self.neighbours.append(neighbour)

def bfs(src, visited):
    queue = deque([])
    queue.append(src)
    visited[src.name] = True
    while queue:
        s = queue.popleft()
        for neighbour in s.neighbours:
            if visited[neighbour.name] == False:
                queue.append(neighbour)
                visited[neighbour.name] = True
    return visited

N, M = map(int, raw_input().split())
list = {}
for i in range(N):
    list[i] = Vertice(i)

for i in range(M):
    a, b = map(int, raw_input().split())
    list[a-1].add_neighbour(list[b-1])
    list[b-1].add_neighbour(list[a-1])

visited = [False] * N
visited = bfs(list[0], visited)
if sum(visited) == N:
    print "connected"
else:
    for i, bool in enumerate(visited):
        if not bool:
            print i + 1