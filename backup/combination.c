#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TARGET 100

typedef struct {
    int **combinations;
    int count;
} ComboMap;

ComboMap getCombos(int *a, int len, int t) {
    ComboMap h[MAX_TARGET + 1] = {0};
    ComboMap result = {NULL, 0};
    int n;

    for (int i = 0; i < len; i++) {
        n = a[i];
        if (h[n].combinations == NULL) {
            h[n].combinations = (int **)malloc(sizeof(int *));
            h[n].combinations[0] = (int *)malloc(sizeof(int));
            h[n].combinations[0][0] = n;
            h[n].count = 1;
        } else {
            h[n].combinations = (int **)realloc(h[n].combinations, (h[n].count + 1) * sizeof(int *));
            h[n].combinations[h[n].count] = (int *)malloc(sizeof(int));
            h[n].combinations[h[n].count][0] = n;
            h[n].count++;
        }

        for (int j = a[0]; j <= t; j++) {
            if (h[j].combinations != NULL) {
                int newCount = h[j].count;
                for (int k = 0; k < newCount; k++) {
                    int newSize = h[j].combinations[k][0] + 1;
                    h[j + n].combinations = (int **)realloc(h[j + n].combinations, (h[j + n].count + 1) * sizeof(int *));
                    h[j + n].combinations[h[j + n].count] = (int *)malloc(newSize * sizeof(int));
                    memcpy(h[j + n].combinations[h[j + n].count], h[j].combinations[k], sizeof(int) * h[j].combinations[k][0]);
                    h[j + n].combinations[h[j + n].count][h[j].combinations[k][0]] = n;
                    h[j + n].count++;
                }
            }
        }
    }

    if (h[t].combinations != NULL) {
        result.combinations = h[t].combinations;
        result.count = h[t].count;
    }

    return result;
}

int main() {
    int arr[] = {1, 2, 5, 9};
    int target = 20;
    ComboMap result;

    // clock_t start = clock();
    result = getCombos(arr, sizeof(arr) / sizeof(arr[0]), target);
    // clock_t end = clock();

    // printf("Time taken: %lf seconds\n", (double)(end - start) / CLOCKS_PER_SEC);
    printf("[");
    for (int i = 0; i < result.count; i++) {
        printf("[");
        for (int j = 0; j < result.combinations[i][0] + 1; j++) {
            printf("%d%s", result.combinations[i][j], j < result.combinations[i][0] ? "," : "");
        }
        printf("]%s", i < result.count - 1 ? "," : "");
    }
    printf("]\n");

    // Free allocated memory
    for (int i = 0; i < result.count; i++) {
        free(result.combinations[i]);
    }
    free(result.combinations);

    return 0;
}