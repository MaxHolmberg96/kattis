#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>


int main() {
	char* s = (char*)calloc(sizeof(char), 1000000);
	scanf("%s", s);
	int* indexes = malloc(sizeof(int) * 1);
	int size = 0;
	int halt = 0;
	for (int i = strlen(s) - 1; i >= 0; i--) {
		if (s[i] != '<') {
			if(halt > 0)
				halt--;
			else {
				size++;
				indexes = realloc(indexes, (size)*sizeof(int));
				indexes[size - 1] = i;
			}
		}
		else {
			halt++;
		}
	}
	for (int i = size - 1; i >= 0; i--) {
		printf("%c", s[indexes[i]]);
	}
	return 0;
}

