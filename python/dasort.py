from copy import copy

cases = raw_input()
for case in range(int(cases)):
    line = raw_input().split()
    case_number = line[0]
    number_elements = int(line[1])
    arr = []
    count = 0
    while count != number_elements:
        line = map(int, raw_input().split())
        count += len(line)
        arr = arr + line
    expected = copy(arr)
    expected.sort()
    count = 0
    expectedIndex = 0
    for i in range(len(arr)):
        if expected[expectedIndex] == arr[i]:
            expectedIndex += 1
        else:
            count += 1
    print case_number + " " + str(count)    
    