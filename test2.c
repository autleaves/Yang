#include <stdio.h>
#include <stdlib.h>

// Define a structure for a linked list node to store a combination
typedef struct Node {
    int *combination;
    int size;
    struct Node *next;
} Node;

// Function to create a new node
Node* createNode(int *combination, int size) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->combination = (int*)malloc(size * sizeof(int));
    for (int i = 0; i < size; i++) {
        newNode->combination[i] = combination[i];
    }
    newNode->size = size;
    newNode->next = NULL;
    return newNode;
}

// Function to add a new combination to the linked list
void addCombination(Node **list, int *combination, int size) {
    Node *newNode = createNode(combination, size);
    newNode->next = *list;
    *list = newNode;
}

// Function to find all combinations that sum up to the target
Node** combinationSum(int target, int *numbers, int numbersSize) {
    // Allocate memory for DP array, which is an array of linked lists
    Node** dp = (Node**)malloc((target + 1) * sizeof(Node*));
    for (int i = 0; i <= target; i++) {
        dp[i] = NULL;
    }

    // Initialize base case: empty combination for target 0
    int empty[] = {};
    addCombination(&dp[0], empty, 0);

    // Build up the DP table
    for (int i = 0; i < numbersSize; i++) {
        int num = numbers[i];
        for (int currentSum = target; currentSum >= num; currentSum--) {
            Node *temp = dp[currentSum - num];
            while (temp) {
                int newSize = temp->size + 1;
                int *newCombo = (int*)malloc(newSize * sizeof(int));
                for (int j = 0; j < temp->size; j++) {
                    newCombo[j] = temp->combination[j];
                }
                newCombo[temp->size] = num;
                addCombination(&dp[currentSum], newCombo, newSize);
                free(newCombo);
                temp = temp->next;
            }
        }
    }
    return dp;
}

// Function to print all combinations
void printCombinations(Node *list) {
    while (list) {
        printf("[");
        for (int i = 0; i < list->size; i++) {
            printf("%d", list->combination[i]);
            if (i < list->size - 1) printf(", ");
        }
        printf("]\n");
        list = list->next;
    }
}

// Function to free all nodes in a linked list
void freeList(Node *list) {
    while (list) {
        Node *temp = list;
        list = list->next;
        free(temp->combination);
        free(temp);
    }
}

int main() {
    int target = 20;
    int numbers[20];
    for (int i = 0; i < 20; i++) {
        numbers[i] = i + 1;  // Fill numbers from 1 to 20
    }

    // Find combinations
    Node** result = combinationSum(target, numbers, 20);
    
    // Print and free the result
    printf("Combinations that sum up to %d:\n", target);
    printCombinations(result[target]);

    // Free all allocated memory
    for (int i = 0; i <= target; i++) {
        freeList(result[i]);
    }
    free(result);

    return 0;
}
