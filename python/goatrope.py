import math

def is_inside_x_bounds(x1, x2, x3):
	if (x1 >= x2 and x1 <= x3) or (x1 >= x3 and x1 <= x2):
		return 1
	return 0

def is_inside_y_bounds(y1, y2, y3):
	if (y1 >= y2 and y1 <= y3) or (y1 >= y3 and y1 <= y2):
		return 1
	return 0

def dist_to_point(x, y, x1, y1):
	return float(math.sqrt(pow(x1 - x, 2) + pow(y1 - y, 2)))

x, y, x1, y1, x2, y2 = map(int, raw_input().split())
x3 = x1
y3 = y2
x4 = x2
y4 = y1

# check if inside x bounds
if is_inside_x_bounds(x, x1, x2):
	print "%.5f" % min(abs(y - y1), abs(y - y2))
elif is_inside_y_bounds(y, y1, y2):
	print "%.5f" % min(abs(x - x1), abs(x - x2))
else:
	print "%.5f" % min(min(dist_to_point(x, y, x1, y1), dist_to_point(x, y, x2, y2)), min(dist_to_point(x, y, x3, y3), dist_to_point(x, y, x4, y4)))