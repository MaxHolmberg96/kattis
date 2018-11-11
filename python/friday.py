week = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]
T = int(raw_input())
for t in range(T):
    D, M = map(int, raw_input().split())
    months = map(int, raw_input().split())
    friday_13 = 0
    current_month = 0
    d = 0
    shift = 0
    while True:
        d += 1
        if week[((d - 1) + shift) % 7] == "Fri" and d == 13:
            friday_13 += 1

        if d >= months[current_month]:
            shift = ((d - 1) + shift) % 7 + 1
            d = 0
            current_month += 1
            if current_month > len(months) - 1:
                break
    
    print friday_13