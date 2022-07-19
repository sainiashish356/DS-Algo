public class NodeWithMaxSubTree {


    static int maxSumNode = 0;
    static int maxSum = Integer.MIN_VALUE;
    public static int calculate(TreeNode<Integer> root){
        int sum = 0;

        for(TreeNode<Integer> child : root.children){
            int csum = calculate(child);
            sum += csum;
        }
    sum += root.data;
        if(sum > maxSum){
            maxSumNode = root.data;
            maxSum = sum;
        }
        return sum;
    }
}
