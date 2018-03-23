package common;
//The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
public class SelectionSort {
	static void selectsort(int[] arr){
		int i,j,temp;
		int min_idx;
		int n=arr.length;
		for(i=0;i<n-1;i++){
			min_idx=i;
			for(j=i+1;j<n;j++)
				if(arr[j]<arr[min_idx])
					min_idx=j;	
			if(min_idx!=i){
				temp=arr[min_idx];
				arr[min_idx]=arr[i];
				arr[i]=temp;
			}//not stable because swap
		}
	}
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	public static void main(String[] args) {
		int arr[] = {64,25,12,22,11};
		selectsort(arr);
		printArray(arr);
	}

}
