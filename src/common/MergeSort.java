package common;

public class MergeSort {
	//first subarray is arr[l..m]
	//second subarray is arr[m+1..r]
	void merge(int arr[],int l,int m,int r){
		int n1=m-l+1;
		int n2=r-m;
		
		//create temp arrays
		int L[]=new int[n1];
		int R[]=new int[n2];
		
		//copy data to temp arrays
		int i,j;
		for(i=0;i<n1;i++)
			L[i]=arr[l+i];
		
		for(j=0;j<n2;j++)
			R[j]=arr[m+1+j];
		
		
		i=0;
		j=0;
		int k=l;
		while(i<n1 && j<n2){
			if(L[i]<=R[j]){
				arr[k]=L[i];
				i++;
			}else{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1){
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k]=R[j];
			j++;
			k++;
		}
		
		
		
		
	}
	void sort(int arr[],int l,int r){
		if(l<r){
			int middle=(l+r)/2;
			
			sort(arr,l,middle);
			sort(arr,middle+1,r);
			
			merge(arr,l,middle,r);
		}
	}
	
	 static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	 
	    // Driver method
	    public static void main(String args[])
	    {
	        int arr[] = {12, 11, 13, 5, 6, 7};
	 
	        System.out.println("Given Array");
	        printArray(arr);
	 
	        MergeSort ob = new MergeSort();
	        ob.sort(arr, 0, arr.length-1);
	 
	        System.out.println("\nSorted array");
	        printArray(arr);
	    }
}
