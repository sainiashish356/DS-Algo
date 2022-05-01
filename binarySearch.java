public class binarySearch {

    public static int search(int[] arr, int start, int end , int elem){
        if(start > end){
            return -1;
        }

        int mid = (start + end)/2;
        if(arr[mid] == elem){
            return mid;
        }
        else if(elem < arr[mid]){
            return search(arr, start, mid-1, elem);
        }else{
            return search(arr, mid+1, end, elem);
        }
    }
    
}
