from itertools import permutations
import datetime

indata = raw_input().split("/")
valid_dates = []
for i in permutations(indata):
	try:
		year = "20" + i[0] if len(i[0]) == 2 else "200" + i[0] if len(i[0]) == 1 else i[0]
		date = datetime.datetime(int(year), int(i[1]), int(i[2]))
		valid_dates += [date]
	except:
		pass

valid_dates.sort()
if len(valid_dates) == 0:
	print indata[0] + "/" + indata[1] + "/" + indata[2] + " is illegal"
else:
	print str(valid_dates[0])[:-9]