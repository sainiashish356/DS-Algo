import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HeightofTree {



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

    public static int height(TreeNode<Integer> root){
        int ht = 0;

        for(TreeNode<Integer> child : root.children){
            int ch = height(child);
            ht = Math.max(ch , ht);
        }
        ht += 1;
        return ht;
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        int ans = height(root);
        System.out.println(ans);
    }
}
