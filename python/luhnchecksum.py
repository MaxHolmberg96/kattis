n = int(raw_input())
for i in range(n):
    arr = map(int, list(raw_input()))
    for j in range(len(arr) - 2, -1, -2):
        if arr[j] * 2 >= 10:
            arr[j] = sum(map(int, list(str(arr[j] * 2))))
        else: 
            arr[j] *= 2
    print "PASS" if sum(arr) % 10 == 0 else "FAIL"
