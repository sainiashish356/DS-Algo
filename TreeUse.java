import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

    public static void printLevel(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<TreeNode<Integer>> q = new ArrayDeque<>();
        TreeNode<Integer> nullNode = new TreeNode<>(Integer.MIN_VALUE);
        q.add(root);
        q.add(nullNode);
        System.out.println(root.data);

        while(q.size() != 1){
            TreeNode<Integer> temp = null;
            temp = q.remove();

            if(temp == nullNode){
                q.add(nullNode);
                System.out.println();
                continue;
            }
            for(int i = 0; i < temp.children.size() ;i++){
                System.out.print(temp.children.get(i).data + " ");
                q.add(temp.children.get(i));
            }
        }

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

    public static void printLevelWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.remove();
            if(frontNode == null){
                if(queue.isEmpty()){
                    break;
                }
                System.out.println();
                queue.add(null);
            }else{
                System.out.print(frontNode.data + " ");
                for(int i = 0; i < frontNode.children.size() ; i++){
                    queue.add(frontNode.children.get(i));
                }
            }
        }
    }
    public static TreeNode<Integer> takeInput(Scanner s){
        int n;

        System.out.println("Enter root data");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter Number of Children for" + n);
        int childCount = s.nextInt();
        for(int i = 0; i < childCount ; i++){
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        String s = root.data + ":";
        for(int i = 0; i < root.children.size();i++){
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i = 0; i < root.children.size();i++){
            print(root.children.get(i));
        }

    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        TreeNode<Integer> root = takeInput(s);
//        print(root);
            TreeNode<Integer> root = takeInputLevelWise();
            printLevel(root);
    }
}
