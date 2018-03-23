package common;

public class BubbleSort {
	
	static void bubblesort(int[] arr){
		int i,j,temp;
		int n=arr.length;
		boolean swapped;
		for(i=0;i<n-1;i++){
			swapped=false;
			for(j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					swapped=true;
				}
			}
			if(!swapped) break;
		}
	}
	static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		bubblesort(arr);
		printArray(arr);
	}

}
