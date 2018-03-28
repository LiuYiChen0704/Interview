package wangyi;

import java.util.Scanner;

public class Wangyi {
	//在arr数组的low到high里选k个数
	static long solve(int[] arr, int low, int high, int k, int d, int n, long multiply) {
		if (k == 0)
			return multiply;//保存之前的乘积
		long max = Integer.MIN_VALUE;
		for (int i = low; i <= high; i++) {
			long t = multiply * arr[i];
			long r = solve(arr, i + 1, Math.min(i + d, n - 1), k - 1, d, n, t);
			if (r > max) {
				max = r;
			}
		}
		return max;

	}
	
	//动态规划
	static long solve_dp(int[] arr, int k, int d, int n) {
		//这个是为了和后面一致位置在数组中是从1到n
		int arr2[]=new int[arr.length+1];
		for(int i=1;i<=arr.length;i++)
			arr2[i]=arr[i-1];
		
		
		long dpmax[][] = new long[n + 1][k + 1];
		long dpmin[][] = new long[n + 1][k + 1];
		//初始化动态规划的表一般是下标为1
		for (int m = 1; m <= n; m++) {
			dpmax[m][1] = arr2[m];
			dpmin[m][1] = arr2[m];
		}
		/**
		 * dpmax[i][j]:第j次选位置第i上的人后所产生的最大乘积
		 * dpmin[i][j]:第j次选位置第i上的人后所产生的最小乘积
		 * 之所以要保存最大乘积和最小乘积是因为乘法负负得正，很小很小的一个数乘以一个负数将会变得很大很大
		 */
		for(int i=2;i<=n;i++){//动态规划保存的表（dp又叫查表)的第一维度从小到大，因为是从底向上
			for(int j=2;j<=k;j++){//动态规划保存的表（dp又叫查表)的第二维度从小到大，因为是从底向上
				for(int m=Math.max(0, i-d);m<=i-1;m++){//m为上一次即第j-1次选的人的位置标号
					dpmax[i][j]=Math.max(dpmax[i][j], Math.max(dpmax[m][j-1]*arr2[i], dpmin[m][j-1]*arr2[i]));
					dpmin[i][j]=Math.min(dpmin[i][j], Math.min(dpmax[m][j-1]*arr2[i], dpmin[m][j-1]*arr2[i]));
				}
			}
		}
		long result=Integer.MIN_VALUE;
		for(int i=k;i<=n;i++)
			result=Math.max(result, dpmax[i][k]);
		return result;
		
		

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		long result = solve_dp(arr, k, d, n);
		System.out.println(result);
		sc.close();
	}

}
