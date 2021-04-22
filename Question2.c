// Write a C program that does a large number of references to elements of two-dimensioned arrays, 
// using only subscripting. Write a second program that does the same operations but uses pointers and 
// pointer arithmetic for the storage-mapping function to do the array references. Compare the time efficiency 
// of the two programs. Which of the two programs is likely to be more reliable? Why?

// Compare the time efficiency of the two programs. Which of the two programs is likely to be more reliable? Why?
// Subscripting took more time than using pointer arithmetic but pointer arithmetic is less reliable because you can
// add and subtract from a pointer. This could result in the pointer becoming an address outside of memort alloted for
// the array you made that pointer to point to. This can result in accessing parts of the memory you shouldn't
// be accessing and/or aren't trying to access. Also the time for the pointer varied from run to run while the time
// for subscripting remained almost exactly the same each time.
#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <time.h>

int main(void) {
    const int size = 10;
    int two[size][size];

printf("Subscripting: \n");
clock_t before1 = clock();
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            two[i][j] = 1;
            printf("%d", two[i][j]);
        }
        printf("\n");
    }
clock_t time1 = clock() - before1;
printf("time1: %lu\n", time1);
printf("Pointer: \n");

clock_t before2 = clock();
   int *point = &two[0][0];
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            *(point + j) = 1;
            printf("%d", *(point + j));
        }
        printf("\n");
    }
clock_t time2 = clock() - before2;
printf("time1: %lu\n", time2);


    //*(point + 1) = two[20][1];
    return 0;
}

