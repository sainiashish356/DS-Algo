public class targetSumSubset {

    public static void main(String[] args) {
        int[] arr = {10,20,30};
        int target = 30;
        printTargetSumSubsets(arr,0,"", 0, target);
    }

    private static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int target) {

            if(idx == arr.length){
                if(sos == target){
                    System.out.println(set + ".");
                }
                return;
            }

        printTargetSumSubsets(arr, idx+1, set + arr[idx] , sos + arr[idx] , target);
        printTargetSumSubsets(arr,idx +1 , set , sos , target);
    }
}
