public class pairSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int ans  = pairsum(arr ,10);
        System.out.println(ans);
    }

    public static int pairsum(int[] arr , int x){

        int count = 0;

        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if (arr[i] + arr[j] == x){
                    count++;
                }
            }
        }
        return count;
    }

}
