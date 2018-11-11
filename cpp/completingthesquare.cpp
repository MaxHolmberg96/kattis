#include <iostream>
#include <string>
#include <cmath>
#include <vector>
#include <algorithm>
#include <stack>
#include <unordered_set>
#include <map>
#include <sstream>

using namespace std;

struct Point;
double k(Point p);
double polar_angle(Point p);
double dist(Point p1, Point p2);
double ccw(Point p1, Point p2, Point p3);

struct Point {
    int x;
    int y;

    bool operator <(const Point& p) {
        return x < p.x || (x == p.x && y < p.y);
    }

    Point operator +(const Point& p){
        return {x+p.x, y+p.y};
    }
    Point operator -(const Point&p){
        return {x-p.x, y-p.y};
    }
};

bool operator ==(const Point& p1, const Point& p2) {
    return p1.x == p2.x && p1.y == p2.y;
}

ostream& operator <<(ostream& os, const Point& p) {
    return os << p.x << " " << p.y << endl;

}

namespace std {
    template<>
    struct hash<Point> {
        inline size_t operator()(const Point& x) const {
            size_t value = 53 + x.x * 53 * x.y;
            return value;
        }
    };
}

Point selectedP;

int main() {
    ios_base::sync_with_stdio(false);
    vector<Point> v;
    for(int i = 0; i < 3; i++){
        int x, y;
        cin >> x >> y;
        v.push_back({x, y});
    }
    Point u,d,p;
    //v0
    if(dist(v[0], v[1]) == dist(v[0], v[2])){
        p = v[0];
        u = {v[1].x-v[0].x, v[1].y-v[0].y};
        d = {v[2].x-v[0].x, v[2].y-v[0].y};
    }
    //v1
    else if(dist(v[1], v[2]) == dist(v[1], v[0])){
        p = v[1];
        u = {v[0].x-v[1].x, v[0].y-v[1].y};
        d = {v[2].x-v[1].x, v[2].y-v[1].y};
    }
    //v2
    else{
        p = v[2];
        u = {v[1].x-v[2].x, v[1].y-v[2].y};
        d = {v[0].x-v[2].x,v[0].y-v[2].y};
    }
    Point f = u+d;
    f = f + p;
    cout << f.x << " " << f.y << endl;
    return 0;
}

inline double dist(Point p1, Point p2) {
    return sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
}

double k(Point p) {
    return (selectedP.y - p.y) / (selectedP.x - p.x);
}

inline double polar_angle(Point p) {
    return acos((p.x - selectedP.x) / dist(selectedP, p));
}
/**
# Three points are a counter-clockwise turn if ccw > 0, clockwise if
# ccw < 0, and collinear if ccw = 0 because ccw is a determinant that
# gives twice the signed  area of the triangle formed by p1, p2 and p3.
*/
inline double ccw(Point p1, Point p2, Point p3) {
    return (p2.x - p1.x)*(p3.y - p1.y) - (p2.y - p1.y)*(p3.x - p1.x);
}
