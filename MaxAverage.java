//A Java program to find the the path with maximum value in a N*N matrix from [0][0] to [n-1][n-1] using Dynamic Programming
//Dynamic Programming using Memorization(Top-down) approach.
import java.util.*;
class MaxAverage
{
    void initialize(int arr[][], int n, int dp[][])
    {
        dp[0][0]=arr[0][0];
        for(int i=1;i<n;i++)
        {
            dp[0][i] = arr[0][i] + dp[0][i-1];
            dp[i][0] = arr[i][0] + dp[i-1][0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
    }
    int max_sum(int arr[][], int i, int j, int dp[][])
    {
        if(dp[i][j]==-1)
        {
            dp[i][j]=arr[i][j]+Math.max(max_sum(arr,i,j-1,dp),max_sum(arr,i-1,j,dp));
        }
        return dp[i][j];
    }
    void main()
    {
        MaxAverage avg=new MaxAverage();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix:");
        int n=sc.nextInt();
        int matrix[][]=new int[n][n];
        int dp[][]=new int[n][n];
        System.out.println("Enter the values of the matrix");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        avg.initialize(matrix,n,dp);
        int sum=avg.max_sum(matrix,n-1,n-1,dp);
        System.out.println("The maximum sum is: "+sum);
        double denom=(2*n)-1;
        double average=sum/denom;
        System.out.println("The maximum average is: "+average);
    }
}  