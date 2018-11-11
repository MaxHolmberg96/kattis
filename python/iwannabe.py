def attack_cmp(x, y):
    return cmp(x[0], y[0])

def defense_cmp(x, y):
    return cmp(x[1], y[1])

def health_cmp(x, y):
    return cmp(x[2], y[2])

N, K = map(int, raw_input().split())
max_attack_list = []
max_defense_list = []
max_health_list = []
best = {}
for i in range(N):
    A, D, H = map(int, raw_input().split())
    max_attack_list += [(A, D, H)]
    max_defense_list += [(A, D, H)]
    max_health_list += [(A, D, H)]

max_attack_list = sorted(max_attack_list, cmp=attack_cmp)
max_defense_list = sorted(max_defense_list, cmp=defense_cmp)
max_health_list = sorted(max_health_list, cmp=health_cmp)
max_index = N - 1
for i in range(K):
    best[max_attack_list[max_index]] = 1
    best[max_defense_list[max_index]] = 1
    best[max_health_list[max_index]] = 1
    max_index -= 1
print len(best.keys())