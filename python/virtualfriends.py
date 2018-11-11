def find(parent, i):
    x = i
    while parent[i] != i:
        i = parent[i]

    while x != i:
        parent[x] = i
        x = parent[x]

    return i


def union(parent, rank, i, j):
    i_rep = find(parent, i)
    j_rep = find(parent, j)
    if i_rep == j_rep:
        return rank[j_rep]
    if rank[i_rep] > rank[j_rep]:
        rank[i_rep] += rank[j_rep]
        size = rank[i_rep]
        parent[j_rep] = i_rep
    else:
        rank[j_rep] += rank[i_rep]
        size = rank[j_rep]
        parent[i_rep] = j_rep
    return size

T = int(raw_input())
for j in range(T):
    F = int(raw_input())
    friendships = []
    distinct_names = set([])

    for i in range(F):
        a, b = raw_input().split()
        distinct_names.add(a)
        distinct_names.add(b)
        friendships.append((a, b))

    number_of_distinct_names = len(distinct_names)
    name_mapping = {}
    for i, dn in enumerate(list(distinct_names)):
        name_mapping[dn] = i

    parent = [i for i in range(number_of_distinct_names)]
    rank = [1] * number_of_distinct_names

    for friendship in friendships:
        print union(parent, rank, name_mapping[friendship[0]], name_mapping[friendship[1]])

