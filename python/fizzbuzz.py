tmp = raw_input();
x = tmp.split()[0];
y = tmp.split()[1];
n = tmp.split()[2];
for i in range(1,int(n)+1):
    if i % int(x) == 0 and i % int(y) == 0:
        print("FizzBuzz")
    elif i % int(x) == 0:
        print("Fizz")
    elif(i % int(y) == 0):
        print("Buzz")
    else:
        print(i);
