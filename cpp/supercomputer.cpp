
// Example program
#include <iostream>
#include <string>

using namespace std;

void add(int* tree, int x, int i, int tree_SIZE) {
	for (; i <= tree_SIZE; i += i&-i)
		tree[i] += x;
}

void set(int* tree, int x, int i){
    tree[i] = x;
}

int sum(int* tree, int x) {
	int sum = 0;
	for (; x > 0; x -= x&-x)
		sum += tree[x];
	return sum;
}

int sumRange(int* tree, int x, int y) {
	return sum(tree, y) - sum(tree, x-1);
}


int main() {
    std::ios_base::sync_with_stdio(false);
	int N, K;
	cin >> N >> K;
	int* arr = (int*)calloc(sizeof(int), N+1);
	char c;
	//Create fenwick tree
	for (int i = 0; i < K; i++) {
		cin >> c;
		if (c == 'F') {
			int index;
			cin >> index;
			if (sum(arr, index)-sum(arr, index-1) == 1) {
				add(arr, -1, index, N+1);
			}
			else {  
				add(arr, 1, index, N+1);
			}
		}
		else {
		    int a,b;
		    cin >>  a>> b;
			cout << sumRange(arr, a, b) << endl;
		}
		    
	}
	free(arr);
	return 0;
}