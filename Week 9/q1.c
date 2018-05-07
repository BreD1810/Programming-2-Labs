#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
	//Create the memory addresses for the different integers.
	int *wholePtr;
	double *fractPtr;
	wholePtr = calloc(1, sizeof(int));
	fractPtr = calloc(1, sizeof(double));
	int sign = 0;
	if (wholePtr == NULL || fractPtr == NULL)
	{
		printf("Calloc failed\n");
		return -1;
	}

	//Get the number from the user.
	double number = 0;
	printf("Please enter a number... \n");
	int stringCheck = scanf("%lf", &number);
	if (stringCheck == 0)
	{
		printf("Input type was incorrect.\n");
		return -2;
	}
	printf("Your number was %f \n", number);

	//Get the values
	sign = analyse(wholePtr, fractPtr, number);

	//Print a response
	if (sign == 1)
	{
		printf("The value is positive, with whole part %i, and fractional part %f.\n", *wholePtr, *fractPtr);
		return 0;
	}
	else if (sign == -1)
	{
		printf("The value is negative, with whole part %i, and fractional part %f.\n", *wholePtr, *fractPtr);
		return 0;
	}
	else
	{
		printf("The function was not called.\n");
		return -3;
	}
}

int analyse(int *wholePtr, double *fractPtr, double d)
{
	//Convert to an absolute value
	double absD = fabs(d);

	//Get the whole part
	*wholePtr = floor(absD);

	//Get the fractional part
	*fractPtr = absD - *wholePtr;

	if (d > 0)
	{
		return 1;
	}
	else
	{
		return -1;
	}
}