#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <stdbool.h>

int main(void){
	int a,r,e,c;
    scanf("%d", &a);
    for(int i=0;i<a;i++){
        scanf("%d %d %d",&r,&e,&c);
        if(r==e-c) printf("does not matter\n");
        else if(r<e-c) printf("advertise\n");
        else if(r>e-c) printf("do not advertise\n");
    }
	return 0;
}
