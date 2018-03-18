package common;

public class Quicksort {
	void swap(int arr[],int i,int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	int partition(int arr[],int low,int high){
		int pivotkey=arr[low];
		while(low<high){
			while(low<high&&arr[high]>=pivotkey){
				high--;
			}
			swap(arr,low,high);
			while(low<high&&arr[low]<=pivotkey){
				low++;
			}
			swap(arr,low,high);
		}
		return low;//low与high相等时，即为枢轴位置
	}
	void sort(int arr[],int low,int high){
		if(low<high){
			int pos=partition(arr,low,high);
			sort(arr,low,pos-1);
			sort(arr,pos+1,high);
		}
	}
	
	void printArray(int arr[]){
		int i=0;
		for(;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args){
		Quicksort qs=new Quicksort();
		int arr[]={10,7,8,9,1,5};
		qs.sort(arr,0,arr.length-1);
		qs.printArray(arr);
		
	}
}
