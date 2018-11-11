from datetime import datetime
import itertools 
import math
import time

def pad_x(n, desired):
    l = int(math.log10(n)) + 1
    pad_length = desired - l
    n *= 10**(pad_length)
    return n


start = datetime(2000, 1, 1)
n = int(raw_input())
for i in range(n):
    date = list(raw_input())
    date.remove(" ")
    date.remove(" ")
    valid_dates = set([])
    for per in itertools.permutations(date, 8):
        try:
            d = datetime(pad_x(int(per[0] + per[1] + per[2] + per[3]), 4), int(per[4] + per[5]), int(per[6] + per[7]))
            if d >= start:
                valid_dates.add(d)
        except:
            pass

    x = list(valid_dates)
    x.sort()
    if len(x) > 0:
        date = str(x[0].day).zfill(2) + " " + str(x[0].month).zfill(2) + " " + str(x[0].year).zfill(4)
    print "%d %s" % (len(x), date if len(x) > 0 else "")