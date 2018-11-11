import sys

def manhattanDistance(fro, to):
    return abs(fro[0] - to[0]) + abs(fro[1] - to[1])

table = {"A" : [0, 0], "B" : [0, 1], "C" : [0, 2], "D" : [0, 3], "E" : [1, 0], 
       "F" : [1, 1], "G" : [1, 2], "H" : [1, 3], "I" : [2, 0], "J" : [2, 1], 
       "K" : [2, 2], "L" : [2, 3], "M" : [3, 0], "N" : [3, 1], "O" : [3, 2], 
       "." : [3, 3]}
matrix = [line.strip() for line in sys.stdin]
sum = 0;
for i in range(len(matrix)):
    for j in range(len(matrix[i])):
        if matrix[i][j] != '.':
            sum = sum + manhattanDistance([i, j], table[matrix[i][j]])
print sum