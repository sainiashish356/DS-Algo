public class Linear_search {

    public static int findElem(int[] arr , int x){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int ans = findElem(arr , 7);
        System.out.println(ans);
    }
}
