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
    double x;
    double y;

    bool operator <(const Point& p) {
        return polar_angle(*this) < polar_angle(p);
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
    string s;
    while (getline(cin, s)) {
        if (!s.length()) return 0;
        vector<Point> points;
        unordered_set<Point> set;
        map<double, Point> angle;
        stringstream iss(s);
        int darts = 0;
        double x, y, X, Y;
        iss >> x; 
        iss >> y;
        Point p{ x, y };
        points.push_back(p);
        set.insert(p);
        X = p.x;
        Y = p.y;
        selectedP = p;
        darts++;
        while (iss >> x && iss >> y) {
            Point p{ x, y };
            if (p.y < Y || (p.y == Y && p.x < X)) {
                selectedP = p;
                X = p.x;
                Y = p.y;
            }
            auto got = set.find(p);
            if (got == set.end()) {
                points.push_back(p);
                set.insert(p);
            }
            darts++;
        }
        
        //removing start point from vector and sorting by angle
        for (int i = 0; i < points.size(); i++) {
            if (selectedP == points[i])
                points.erase(points.begin() + i);
        }

        for (int i = 0; i < points.size(); i++) {
            if (angle.size() > 0) {
                auto got = angle.find(floor(polar_angle(points[i]) * 1000000000) / 1000000000);
                if (got != angle.end()) {
                    if (dist(selectedP, points[i]) > dist(selectedP, got->second)) {
                        angle[floor(polar_angle(points[i]) * 1000000000) / 1000000000] = points[i];
                    }
                }
                else {
                    angle[floor(polar_angle(points[i]) * 1000000000) / 1000000000] = points[i];
                }
            }
            else
                angle[floor(polar_angle(points[i]) * 1000000000) / 1000000000] = points[i];
        }
        points.clear();
        for (const auto& v : angle) {
            points.push_back(v.second);
        }
       
        sort(points.begin(), points.end());
        //add start point to the last element so one know when its done

        points.push_back(selectedP);

        vector<Point> s;
        s.push_back(selectedP);
        s.push_back(points[0]);

        for (int i = 1; i < points.size(); i++) {
            Point p1 = s[s.size() - 1];
            Point p2 = s[s.size() - 2];
            if (ccw(p2, p1, points[i]) > 0) {
                s.push_back(points[i]);
            }
            else {
                while (ccw(p2, p1, points[i]) < 0) {
                    s.pop_back();
                    //update p2, p1
                    p1 = s[s.size() - 1];
                    p2 = s[s.size() - 2];
                }
                s.push_back(points[i]);
            }
        }
        double sum = 0;
        for (int i = 0; i < s.size() - 1; i++) {
            sum += dist(s[i], s[i + 1]);
        }
        printf("%.7lf\n", 100 * darts / (1 + sum));
    }
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