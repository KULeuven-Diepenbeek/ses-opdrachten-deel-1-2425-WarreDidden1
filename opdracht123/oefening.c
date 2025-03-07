#include <stdio.h>

#define N 5

void sorteerPointer(int* pointerOut[N]) {
    for (int i = 0; i < N - 1; i++) {
        for (int j = i + 1; j < N; j++) {
            if (*pointerOut[i] > *pointerOut[j]) {
                int* temp = pointerOut[i];
                pointerOut[i] = pointerOut[j];
                pointerOut[j] = temp;
            }
        }
    }
}

int main() {
    int nums[N] = { 2, 8, 5, 4, 6 };
    int* ptrs[N];


    // Initialiseer de ptrs array
    for (int i = 0; i < N; i++) {
        ptrs[i] = &nums[i];
        printf("bij nums locatie = %p ; in de ptrs array op plaats i = %p\n", &nums[i], ptrs[i]);
    }

    sorteerPointer(ptrs); 
    printf("\n");
    for (int i = 0; i < N; i++) {
        printf("bij nums op plaats i = %p ; in de ptrs array op plaats i = %p\n", nums[i], *ptrs[i]);
    }
    return 0;
}

