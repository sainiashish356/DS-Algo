import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class totalNodes {

    public static  int numNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        int count = 1;
        for(int i = 0; i < root.children.size() ;i++){
            count += numNodes(root.children.get(i));
        }
        return count;
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
        int ans = numNodes(root);
        System.out.println(ans);

    }
}
