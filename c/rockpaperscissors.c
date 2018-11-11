#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int win(char *m1, char *m2) {
	if (m1 != NULL && m2 != NULL) {
		if (strlen(m1) == 4 && strlen(m2) == 8)
			return 1;
		if (strlen(m1) == 8 && strlen(m2) == 5)
			return 1;
		if (strlen(m1) == 5 && strlen(m2) == 4)
			return 1;
		if (strlen(m1) == 4 && strlen(m2) == 4)
			return 0;
		if (strlen(m1) == 5 && strlen(m2) == 5)
			return 0;
		if (strlen(m1) == 8 && strlen(m2) == 8)
			return 0;
		return 2;
	}
	else {
		printf("m1 || m2 == null");
		exit(1);
	}
}

int main() {
	while (true) {
		int n;
		int k;
		scanf("%d", &n);
		if (n == 0)
			break;
		scanf("%d", &k);
		int games = ((n*k)*(n - 1)) / 2;
		int** p = malloc(sizeof(int*)* n);
		for (int i = 0; i < n; i++) 
			p[i] = calloc(sizeof(int),2);
		for (int i = 0; i < games; i++) {
			char *m1 = calloc(sizeof(char), 8);
			char *m2 = calloc(sizeof(char), 8);
			int pp[2];
			scanf("%d %s %d %s", &pp[0], m1, &pp[1], m2);
			if (win(m1, m2) == 1) {
				p[pp[0] - 1][0]++;
			}
			else if (win(m1, m2) == 2) {
				p[pp[1] - 1][0]++;
			}
			if (win(m1, m2) != 0) {
				p[pp[0] - 1][1]++;
				p[pp[1] - 1][1]++;
			}
			free(m1);
			free(m2);
		}
		for (int i = 0; i < n; i++) {
			if (p[i][1] == 0) {
				printf("-");
			}
			else {
				printf("%.3lf", (double)p[i][0] / (double)p[i][1]);
			}
			printf("\n");
		}
		free(p);
	}
}

