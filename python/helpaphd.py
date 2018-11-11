x = int(input())
for i in range(x):
  a = input()
  print("skipped" if a == "P=NP" else eval(a))