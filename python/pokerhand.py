import sys, math

map = {}

cards = raw_input().split()
for card in cards:
    map[card[:-1]] = 1 + map.get(card[:-1], 0)

print max(map.values())