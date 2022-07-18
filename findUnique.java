public class findUnique {

    public static void main(String[] args) {
        int[] arr = {2,4,7,2,7};
        int ans = unique(arr);
        System.out.println(ans);
    }

    public static int unique(int[] arr){

        int n = arr.length;

        for(int i = 0; i < n ; i++){
                int j;
            for( j = 0 ; j < n;  j++){
                if(i != j){
                    if(arr[i] == arr[j]){
                        break;
                    }
                }
            }
            if( j == n){
                return arr[i];
            }
        }
        return Integer.MAX_VALUE;

    }

}
