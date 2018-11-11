#include <iostream>
#include <string>

using namespace std;



int main() {
    std::ios_base::sync_with_stdio(false);
    int cases;
    cin >> cases;
    for (int i = 0; i < cases; i++) {
        int p, q, t;
        char c;
        cin >> t >> p >> c >> q;
        if (q == 1)
            cout << i + 1 << " " << "1/" << (p + 1) << endl;
        else if (p < q)
            cout << i + 1 << " " << p+(q-p) << "/" << q-p << endl;
        else {
            int l = 0, p2 = p, q2 = q;
            while (p2 > q2) {
                p2 -= q2;
                l--;
            }
            q2 -= p2;
            p2 += q2;
            for (; l < 0; l++)
                q2 += p2;
            cout << i + 1 << " " << p2 << "/" << q2 << endl;
        }
    }
    return 0;
}
