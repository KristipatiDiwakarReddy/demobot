package com.example;

import java.util.Scanner;

public class splitter
{
	// Number of persons (or vertices in the graph)
	int spent, paid; int netamount;	int amount[];
    String name;
    static String Name[];
	// A utility function that returns
	// index of minimum value in arr[]
	static int getMin(int arr[], int N)
	{
		int minInd = 0;
		for (int i = 1; i < N; i++)
			if (arr[i] < arr[minInd])
				minInd = i;
		return minInd;
	}
	
	// A utility function that returns
	// index of maximum value in arr[]
	static int getMax(int arr[], int N)
	{
		int maxInd = 0;
		for (int i = 1; i < N; i++)
			if (arr[i] > arr[maxInd])
				maxInd = i;
		return maxInd;
	}
	
	// A utility function to return minimum of 2 values
	static int minOf2(int x, int y)
	{
		return (x < y) ? x: y;
	}
	
	// amount[p] indicates the net amount
	// to be credited/debited to/from person 'p'
	// If amount[p] is positive, then
	// i'th person will amount[i]
	// If amount[p] is negative, then
	// i'th person will give -amount[i]
	static public void minCashFlowRec(int amount[], int N,splitter p[])
	{
		// Find the indexes of minimum and
		// maximum values in amount[]
		// amount[mxCredit] indicates the maximum amount
		// to be given (or credited) to any person .
		// And amount[mxDebit] indicates the maximum amount
		// to be taken(or debited) from any person.
		// So if there is a positive value in amount[],
		// then there must be a negative value
		int mxCredit = getMax(amount, N), mxDebit = getMin(amount, N);
	
		// If both amounts are 0, then
		// all amounts are settled
		if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
			return;
	
		// Find the minimum of two amounts
		int min = minOf2(-amount[mxDebit], amount[mxCredit]);
		amount[mxCredit] -= min;
		amount[mxDebit] += min;
	
		// If minimum is the maximum amount to be
		System.out.println(p[mxDebit].name + " pays " + min
								+ " to " + p[mxCredit].name);
	
		// Recur for the amount array.
		// Note that it is guaranteed that
		// the recursion would terminate
		// as either amount[mxCredit] or
		// amount[mxDebit] becomes 0
		minCashFlowRec(amount, N,p);
	}
	
	// Given a set of persons as graph[]
	// where graph[i][j] indicates
	// the amount that person i needs to
	// pay person j, this function
	// finds and prints the minimum
	// cash flow to settle all debts.

	
	// Driver code
	
	    public static void main (String[] args)
	{
	        Scanner scanner = new Scanner (System.in);
            System.out.println("Enter the total number of persons");
            int N = scanner.nextInt();
            int[] amount = new int[N];

            int sumspent = 0;
            int sumpaid = 0;

            splitter p[]=new splitter[N];
            
            for(int i=0;i<N;i++){
                p[i] = new splitter();
                System.out.println("Enter the name");
                p[i].name=scanner.next();
                System.out.println("Enter the spent amount");
                p[i].spent=scanner.nextInt();
                System.out.println("Enter the amount he has to paid");
                p[i].paid=scanner.nextInt();
                p[i].netamount=p[i].paid-p[i].spent;
            }
            
            for(int i=0;i<N;i++)
            {
                sumpaid=sumpaid+p[i].paid;
                sumspent=sumspent+p[i].spent;
            }
            
            if(sumspent!=sumpaid)
            {
                System.out.println("Wrong Input-Sum of Spent amount must be equal to Paid amount");
                System.exit(0);
            }

            for(int i=0;i<N;i++)
            {
                amount[i]=p[i].netamount;
            }

            for(int i=0;i<N;i++)
            {
                System.out.println(amount[i]);
            }
            scanner.close();
            minCashFlowRec(amount,N,p);
        }
}
