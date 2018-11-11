#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>


int main() {
	int j;
	int k;
	int t;
	int y = 0;
	int x = 0; 
	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d %d", &k, &j);
		if (j <= k) {
			y = (j + k) / 2;
			if ((j+k) % 2 != 0) {
				goto here;
			}
			else {
				x = y - k;
			}
			x = abs(x);
			y = abs(y);
			if (x > y)
				printf("%d %d\n", x, y);
			else {
				printf("%d %d\n", y, x);
			}
			
		}
		else {
			here:
			printf("impossible\n");
		}
	}
	return 0;
}