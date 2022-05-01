public class bubblesort {


    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5,88};
        int n = arr.length;
        bubblesearch(arr, 0, n);
    }
    
public static void bubblesearch(int[] arr, int start , int n){
    //n is the length of array
    if(n == 0){
        return;
    }

    if(start < n){
        if(arr[start] > arr[start+1]){
            //swap
            int temp = arr[start];
            arr[start] = arr[start+1];
            arr[start+1] = temp;

        }
        bubblesearch(arr, start +1, n);
    }else{
        bubblesearch(arr, 0, n-1 );
    }

}


}
