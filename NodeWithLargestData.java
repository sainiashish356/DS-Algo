import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class NodeWithLargestData {

       public static int largest(TreeNode<Integer> root){
           if(root == null){
               return Integer.MIN_VALUE;
           }
           int ans = root.data;
           for(int i = 0; i < root.children.size() ; i++){
               int childlargest = largest(root.children.get(i));
               if(childlargest > ans){
                   ans = childlargest;
               }
           }
           return ans;
       }

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();
        Queue<TreeNode<Integer>> pendingNodes = new ArrayDeque<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> frontNode = pendingNodes.remove();
            System.out.println("Enter num of chidren of" + frontNode.data);
            int numChild = s.nextInt();
            for(int i = 0 ; i < numChild ; i++){
                System.out.println("Enter" + (i+1) + "th child of " + frontNode.data);
                int child = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        int ans = largest(root);
        System.out.println(ans);

    }
}
