#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <stdbool.h>

int main(void){
	int x, y, r; r = scanf("%d %d", &x, &y);
    if(x > 0 && y > 0) printf("1");
    else if(x < 0 && y > 0) printf("2");
    else if(x < 0 && y < 0) printf("3");
    else printf("4");
    return 0;
}
