#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#include <string.h>

int find(int parent[], int i) {
    while(parent[i] != i) {
        i = parent[i];
        parent[i] = parent[parent[i]];
    }
    return i;
}

int unionf(int parent[], int rank[], int i, int j) {
    int i_rep = find(parent, i);
    int j_rep = find(parent, j);
    int size = -1;
    if(i_rep == j_rep) {
        return rank[j_rep];
    }
    if(rank[i_rep] > rank[j_rep]) {
        rank[i_rep] += rank[j_rep];
        size = rank[i_rep];
        parent[j_rep] = i_rep;
    } else {
        rank[j_rep] += rank[i_rep];
        size = rank[j_rep];
        parent[i_rep] = j_rep;
    }
    return size;
}


int main(void){
    int N, Q, r;
    r = scanf("%d %d", &N, &Q);
    int parent[N];
    int rank[N];
    for(int i = 0; i < N; i++) {
        parent[i] = i;
        rank[i] = 1;
    }
    for(int i = 0; i < Q; i++) {
        char op;
        int a, b;
        r = scanf(" %c %d %d", &op, &a, &b);
        if(op == '?') {
            printf("%s", find(parent, a) == find(parent, b) ? "yes\n" : "no\n");
        } else {
            unionf(parent, rank, a, b);
        }
    }
}
