from __future__ import print_function
from collections import deque #popleft and append
from time import sleep
from copy import copy

def print_house(house, rows, fire_tims):
    for i in range(rows):
        for j in range(len(house[i])):
            if house[i][j] == ".":
                house[i][j] = fire_tims[i][j] if fire_tims[i][j] != float("inf") else house[i][j]
            print(str(house[i][j]).ljust(4, " "), end="")
        print()

def get_neighbours(house, cord, rows, columns):
    neighbours = []
    neighbours.append((cord[0] - 1, cord[1]))
    neighbours.append((cord[0], cord[1] - 1))
    neighbours.append((cord[0] + 1, cord[1]))
    neighbours.append((cord[0], cord[1] + 1))
    return neighbours

def set_shit_on_fire(house, rows, columns, fire_starts, person_start):
    house_copy = []
    for i in range(rows):
        house_copy.append([])
        for j in range(columns):
            house_copy[i].append(house[i][j])

    fire_queue = deque([])
    for f in fire_starts:
        fire_queue.append(f)
    person_queue = deque([person_start])
    fire_times = []
    for i in range(rows):
        fire_times.append([float("inf")] * columns)

    #spread fire first, atleast on another matrix
    while fire_queue:
        fire = fire_queue.popleft()
        fire_times[fire[0]][fire[1]] = fire[2]
        for n in get_neighbours(house, fire, rows, columns):
            if 0 <= n[0] < rows and 0 <= n[1] < columns:
                if house[n[0]][n[1]] != "#" and house[n[0]][n[1]] != "F":
                    fire_queue.append((n[0], n[1], fire[2] + 1))
                    house[n[0]][n[1]] = "F"
            
    time = -1
    #print_house(fire_times, rows, fire_times)

    while person_queue:
        #sleep(1)
        #print_house(house_copy, rows, [[float("inf")] * columns] * rows)
        person = person_queue.popleft()
        if person[0] == 0 or person[0] == rows - 1 or person[1] == 0 or person[1] == columns - 1:
            #print_house(house_copy, rows, fire_times)
            return person[2] + 1
        for n in get_neighbours(house_copy, person, rows, columns):
            if 0 <= n[0] < rows and 0 <= n[1] < columns:
                if house_copy[n[0]][n[1]] == "." and fire_times[n[0]][n[1]] > person[2] + 1:
                    #print n
                    person_queue.append((n[0], n[1], person[2] + 1))
                    house_copy[n[0]][n[1]] = "J"
           
    #print_house(house_copy, rows, fire_times)
    return -1




r, c = map(int, raw_input().split())
matrix = []
fire_locations = []
my_location = (0, 0, 0)
for i in range(r):
    matrix.append(list(raw_input()))
    for j, char in enumerate(matrix[i]):
        if "F" == char:
            fire_locations.append((i, j, 0))
    if "J" in matrix[i]:
        my_location = (i, matrix[i].index("J"), 0)

t = set_shit_on_fire(matrix, r, c, fire_locations, my_location)
print("IMPOSSIBLE" if t < 0 else t)

