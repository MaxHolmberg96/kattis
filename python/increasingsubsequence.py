from __future__ import print_function
import sys, math

# [10, 22, 09, 33, 21, 50, 41, 60, 80]


def lis(arr):

    vector = [[]] * len(arr)
    vector[0] = [arr[0]]
    index = 0

    for i in range(1, len(arr)):
        for j in range(0, i):
            if arr[i] > arr[j] and len(vector[i]) < len(vector[j]) + 1:
                vector[i] = vector[j]
        vector[i] = vector[i] + [arr[i]] 
    
    return vector

running = 1

while running:

    line = raw_input()

    length = int(line.split()[0])

    if length == 0:
        exit(0)
    
    arr = map(int, line.split()[1:])

    sequence = lis(arr)

    maximum = 0
    for seq in sequence:
        if len(seq) > maximum:
            maximum = len(seq)

    minSum = 2**64
    minIndex = 0

    for i, seq in enumerate(sequence):
        if len(seq) == maximum and sum(seq) < minSum:
            minSum = sum(seq)
            minIndex = i
    print(str(maximum) + " ", end="")
    print(str(sequence[minIndex])[1:-1].replace(",", ""))
