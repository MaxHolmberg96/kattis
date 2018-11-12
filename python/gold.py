#from __future__ import print_function
from collections import deque #popleft and append
from time import sleep
from copy import copy

def print_house(house, rows):
    for i in range(rows):
        print house[i]

def get_neighbours(house, cord, rows, columns):
    neighbours = []
    neighbours.append((cord[0] - 1, cord[1]))
    neighbours.append((cord[0], cord[1] - 1))
    neighbours.append((cord[0] + 1, cord[1]))
    neighbours.append((cord[0], cord[1] + 1))
    return neighbours

def bfs(house, rows, columns, person_start):
    gold = 0
    queue = deque([person_start])

    while queue:
        p = queue.popleft()
        safe = 1
        neighbours = get_neighbours(house, p, rows, columns)
        for n in neighbours:
            if house[n[0]][n[1]] == "T":
                safe = 0
        if safe:
            for n in neighbours:
                if house[n[0]][n[1]] != "#" and house[n[0]][n[1]] != "P":
                    if house[n[0]][n[1]] == "G":
                        gold += 1
                    queue.append((n[0], n[1]))
                    house[n[0]][n[1]] = "P"
    return gold




w, h = map(int, raw_input().split())
matrix = []
my_location = (0, 0)
for i in range(h):
    matrix.append(list(raw_input()))
    if "P" in matrix[i]:
        my_location = (i, matrix[i].index("P"))

print bfs(matrix, h, w, my_location)
