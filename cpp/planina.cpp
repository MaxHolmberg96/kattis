// Example program
#include <iostream>
#include <string>
#include <tgmath.h>

using namespace std;

int main()
{
    int n;
    cin >> n;
    n = n*2;
    printf("%d", (int)((sqrt(pow(2,n))+1)*(sqrt(pow(2,n))+1)));
}
