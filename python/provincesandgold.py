from __future__ import print_function
table_victory = ["Province", "Duchy", "Estate"]
table_treasure = ["Gold", "Silver", "Copper"]
prices_victory = [8, 5, 2]
prices_treasure = [6, 3, 0]
buying_power = [3, 2, 1]

arr = map(int, raw_input().split())
current_buying_power = sum([i*j for i,j in zip(arr, buying_power)])
for i in range(3):
    if current_buying_power >= prices_victory[i]:
        print(table_victory[i] + " or ", end="")
        break
for i in range(3):
    if current_buying_power >= prices_treasure[i]:
        print(table_treasure[i])
        break

