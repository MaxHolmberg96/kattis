def is_red(S, tuple):
    S -= 1
    if tuple == -1:
        return False
    else:
        if 0 <= S % (tuple[1] + tuple[2]) < tuple[1]:
            return True
        else:
            return False

N, L = map(int, raw_input().split())
traffic_lights = {}
for i in range(N):
    D, R, G = map(int, raw_input().split())
    traffic_lights[D] = (D, R, G)

sec = 0
curr_dist = 0
while True:
    if curr_dist == L:
        print sec - 1
        break
    if is_red(sec, traffic_lights.get(curr_dist, -1)):
        sec += 1
    else:
        curr_dist += 1
        sec += 1
    

