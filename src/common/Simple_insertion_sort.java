package common;
//stable ,bad:o(n*2) good:o(n) avg:o(n*2)   auxiliary space:o(1)

//不好写！！
public class Simple_insertion_sort {
	static void simple_insertion_sort(int[] arr){
		int n=arr.length;
		for(int i=1;i<n;i++){
			int key=arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>key){//比他大的移到后面去
				arr[j+1]=arr[j];
				j--;
			}
			//当遇到比它小或者和他相等的数的时候，后面的位置就是目标的位置
			arr[j+1]=key;
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
		int arr[] = {12, 11, 13, 5, 6};
		simple_insertion_sort(arr);
		printArray(arr);
	}

}
