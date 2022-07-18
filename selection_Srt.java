import java.util.Arrays;

public class selection_Srt {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionsort(int[] arr){
       for( int i = 0 ; i < arr.length;  i++){
           int lastIndex = arr.length - i - 1;

           int maxIndex = getMax(arr , 0 , lastIndex);

           swap(arr , maxIndex , lastIndex);
       }
    }

    public static void swap(int[] arr , int first , int second){
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
    }

    public static int getMax(int[] arr , int start , int end){
        int max = start;
        for(int i = start ; i <= end ; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}
