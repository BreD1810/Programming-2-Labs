#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef int* TRIARR;

TRIARR triNew(int N)
{
    //Work out the number of ints needed.
    int needed = 0;
    int i = 0;
    for(i = 0; i <= N; ++i)
    {
        needed+=i;
    }

    //Create the data
    TRIARR data;
    data = calloc(needed, sizeof(int));
    if(data == NULL)
    {
        printf("Calloc failed.\n");
    }
    else
    {
        return data;
    }
}


int triStore(TRIARR as, int N, int row, int col, int val)
{
    //Check the input is valid.
    if(row > N || col > N || col < row)
    {
        return -1;
    }
    
    //Find the place to put the value
    int elementNumber = 0;
    int i;
    for(i = 0; i <= row; ++i)
    {
        elementNumber+=i;
    }
    elementNumber+=col;

    //Set the value
    *(as+elementNumber) = val;
    return 0;
}

int triFetch(TRIARR as, int N, int row, int col)
{
    //Check the input is valid.
    if(row > N || col > N || col < row)
    {
        return -1;
    }

    //Find the place to get the element
    int elementNumber = 0;
    int i;
    for(i = 0; i <= row; ++i)
    {
        elementNumber+=i;
    }
    elementNumber+=col;

    //Return the element in that location
    return *(as+elementNumber);
}

int main()
{
    //Get the input size from the user.
    int number = 0;
    printf("What size would you like the array?\n");
    int result = scanf("%i", &number);
    if(result == 0)
    {
        printf("Incorrect type.\n");
        return -1;
    }

    //Create the array
    TRIARR test = triNew(number);

    // //Give the array some values.
    triStore(test, number, 0, 0, 1);
    triStore(test, number, number, number, 2);
    triStore(test, number, 1, 2, 3);

    //Get the arrays values.
    printf("1: %i\n", triFetch(test, number, 0, 0));
    printf("2: %i\n", triFetch(test, number, number, number));
    printf("3: %i\n", triFetch(test, number, 1, 2));
    printf("Fetch error: %i\n", triFetch(test, number, number+1, number+1));
    printf("Write error: %i\n", triStore(test, number, 400, 400, 4));
    printf("Column is less than row: %i\n", triFetch(test, number, 2, 1));
    return 0;
}