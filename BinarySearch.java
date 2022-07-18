public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {3,4,6,8,10};
        int ans = binary(arr , 12);
        System.out.println(ans);
    }

    public static int binary(int[] arr , int x) {
        int n = arr.length;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
