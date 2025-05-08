import java.util.*;
public class Main {

    public static void MergeSort(int arr[] , int start , int end){

        if(start < end){

            int mid = (start + end) / 2; // int mid = start + (end - start) / 2;

            MergeSort(arr,start, mid);
            MergeSort(arr,mid + 1, end);

            Conquer(arr, start, mid , end);
        }
    }

    public static void Conquer(int arr[] , int start , int mid , int end){

        int []merged = new int[end - start + 1];  // 2 TA VALUE HOLE SIZE 2 HOBE
        int idx1 = start;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= end){

            if(arr[idx1] > arr[idx2]){
                merged[x++] = arr[idx2++];
            }
            else {

                merged[x++] = arr[idx1++];
            }
        }

        while(idx1 <= mid){
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= end){
            merged[x++] = arr[idx2++];
        }

        for(int i = 0 , j = start ; i < merged.length; i++ , j++){

            arr[j] = merged[i];
        }
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int size;
      System.out.print("Please enter the size of array : ");
      size = sc.nextInt();
      int []arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }

        MergeSort(arr,0,size - 1);

        System.out.print("Sorted Array : ");
        for(int i = 0 ; i < size ; i++)
        System.out.print(""+arr[i]+" ");
    }
}