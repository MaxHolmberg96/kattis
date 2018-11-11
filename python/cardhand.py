from __future__ import print_function
from itertools import permutations, groupby
import sys, math

def index_lis(list, indexMap):
    vector = [[]] * len(list)
    vector[0] = [list[0]]
    for i in range(1, len(list)):
        for j in range(0, i):
            if indexMap.index(list[i]) > indexMap.index(list[j]) and len(vector[i]) < len(vector[j]) + 1:
                vector[i] = vector[j]
        vector[i] = vector[i] + [list[i]]

    max_length = 0
    for lis in vector:
        if len(lis) > max_length:
            max_length = len(lis)
            longest_lis = lis

    return longest_lis

def rank_sort(r1, r2):
    return cmp(replace_rank(r1), replace_rank(r2))

def replace_rank(r):
    return {
        'T': 'a',
        'J': 'b',
        'Q': 'c',
        'K': 'd',
        'A': 'e'
    }.get(r, r)

suits = {}
nr_cards = int(raw_input())
cards = [(card[0], card[1]) for card in raw_input().split()]
distinct_suits = set([c[1] for c in cards])
suits = {c:[] for c in distinct_suits}
for card in cards:
    suits[card[1]].append(card[0])

per = permutations(distinct_suits, len(distinct_suits))

valid_order = []

#for each permutation p of suits
for p in list(per):
    #for each way of ascending/descending
    for binary in range(2**len(distinct_suits)):
        recipie = zip(list(p), bin(binary)[2:].rjust(len(distinct_suits), '0'))
        tmp = []
        for i, r in enumerate(recipie):
            if r[1] == '1':
                sort = sorted(suits[r[0]], cmp=rank_sort)
            else:
                sort = sorted(suits[r[0]], cmp=rank_sort, reverse=True)
            tmp += [x + p[i] for x in sort]


        valid_order.append(tmp)

#remove duplicate lists
new_valid_order = []
for l1 in valid_order:
    if l1 not in new_valid_order:
        new_valid_order.append(l1)

valid_order = new_valid_order

indexMap = []
for card in cards:
    indexMap.append(card[0] + card[1])

maximum_lis = 0
for valid in valid_order:
    lis = len(index_lis(valid, indexMap))
    if lis > maximum_lis:
        maximum_lis = lis

print(nr_cards - maximum_lis)