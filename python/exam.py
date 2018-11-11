c = int(raw_input())
yours = raw_input()
friends = raw_input()

count = 0
dif = 0
for i in range(len(yours)):
    if yours[i] == friends[i]:
        count += 1
    else:
        dif += 1

total = 0
if count > c:
    total += c
    total += len(friends) - count
else:
    total += len(friends) - count - (c - count)
    total += count

print total