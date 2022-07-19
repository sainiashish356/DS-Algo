import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrder_ZigZag {

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        levelOrderzigzag(root);
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


    public static void levelOrderzigzag(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> main = new Stack<>();
        main.push(root);

        Stack<TreeNode<Integer>> child = new Stack<>();
        int level = 1;

        while(!main.isEmpty()){
            root = main.pop();
            System.out.print(root.data + " ");

            if(level % 2 == 1){
                for(int i = 0; i < root.children.size() ; i++){
                    TreeNode<Integer> ch = root.children.get(i);
                    child.push(ch);
                }
            }else{
                for(int i = root.children.size() -1 ; i >= 0 ; i--){
                    TreeNode<Integer> ch = root.children.get(i);
                    child.push(ch);
                }
            }
            if(main.isEmpty()){
                main = child;
                child = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
}
