#include <stdio.h>
int main(){
  int a = 0;
  scanf("%d", &a);
  for(int i = 0; i < a; i++){
    printf("%d Abracadabra\n", (i+1));
  }
  return 0;
}
