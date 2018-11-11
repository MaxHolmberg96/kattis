
#include <algorithm>
#include <iostream>
#include <cmath>
#define N 1.57079632679489661923132
#include <iomanip>
double dist(int X1, int Y1, int X2, int Y2)
{
    return sqrt(pow(X1 - X2, 2) + pow(Y1 - Y2, 2));
}

int* ector(int X1, int Y1, int X2, int Y2){
    int *v = (int*)malloc(2);
    v[0] = X2-X1;
    v[1] = Y2-Y1;
    return v;
}

double angle(int *u, int *v){
    return acos((u[0]*v[0] + u[1]*v[1])/(sqrt(pow(u[0],2)+pow(u[1],2))*sqrt(pow(v[0],2)+pow(v[1],2))));
}

int main()
{
    int t, X1, Y1, X2, Y2, X3, Y3, e;
    double a, l1, l2, l3, v1, v2, v3;
    std::cin >> t;
    for (int i = 1; i <= t; i++) {
        std::cin >> X1 >> Y1 >> X2 >> Y2 >> X3 >> Y3;
        a = ((X2 - X1)*(Y3 - Y1) - (Y2 - Y1)*(X3 - X1)) / 2.0;
        //std::cout << a;
        std::cout << "Case #" << i << ": ";
        if (a != 0)
        {
            l1 = dist(X3, Y3, X1, Y1);
            l2 = dist(X2, Y2, X3, Y3);
            l3 = dist(X1, Y1, X2, Y2);
            int *u = ector(X1, Y1, X2, Y2);
            int *v = ector(X1, Y1, X3, Y3);
            int *w = ector(X2, Y2, X3, Y3);
            int *a = ector(X2, Y2, X1, Y1);
            v1 = angle(u,v);
            v2 = angle(a,w);
            v3 = 3.141592653589793 - v1 - v2;
            //std::cout << std::setprecision(17) << v1 << " " << v2 << " " << v3 << " " << std::endl;
            e = 0;
            if (l1 == l2)
                e++;
            if (l1 == l3)
                e++;
            if (l2 == l3)
                e++;
            if (e)
                std::cout << "isosceles ";
            else
                std::cout << "scalene ";
            if (v1 > N || v2 > N || v3 > N)
                std::cout << "obtuse ";
            else if (v1 < N && v2 < N && v3 < N)
                std::cout << "acute ";
            else
                std::cout << "right ";
            std::cout << "triangle" << std::endl;
        }
        else
            std::cout << "not a triangle" << std::endl;
    }
}