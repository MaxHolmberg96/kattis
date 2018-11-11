
from __future__ import print_function
A, B = raw_input().split()
N = len(A)
M = len(B)
output = []
for i in range(M):
    output.append(["."] * N)
for j, char in enumerate(A):
    try:
        i = B.index(char)
        if i >= 0:
            index_A = j
            index_B = i
            break
    except:
        pass


for i in range(N):
    output[index_B][i] = A[i]
    

for i in range(M):
    output[i][index_A] = B[i]

for row in output:
    for column in row:
        print(column, end="")
    print()