import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static int[] sorted = new int [1000000];
	
	public static void mergeSort(int[] arr, int left, int right) {
		
		if(left>=right) return;
		int mid = (left + right)/2;
		
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		merge(arr, left,mid,right);
		
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		
		int l = left;
		int r = mid+1;
		int idx = left;
		
		while(l<=mid && r<=right) {
			
			if(arr[l] < arr[r]) sorted[idx++] = arr[l++];
			else sorted[idx++] = arr[r++];
			
			if(l>mid) {
				while (r<=right) {
					sorted[idx++] = arr[r++];
				}
			}
			
			else if (r>right) {
				while(l<=mid) {
					sorted[idx++] = arr[l++];
				}
			}
			
		}
		
		for(int i=left; i<=right; i++) {
			arr[i] = sorted[i];
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int [1000000];
		for(int i=0; i<1000000; i++) {
			arr[i] = scanner.nextInt();
		}
		
		mergeSort(arr,0,999999);
		
		System.out.println(arr[500000]);
		
	}
	
}