#include <stdio.h>

int main(void){
    int a, b; 
    scanf("%d %d", &a, &b);
    if(a+b == 0){
        printf("Not a moose\n");
    }
    else if(a == b){
        printf("Even %d\n", a+b);
    }
    else{
        if(a > b)
            printf("Odd %d\n", a*2);
        else
            printf("Odd %d\n", b*2);
    }
    
    return 0;
}