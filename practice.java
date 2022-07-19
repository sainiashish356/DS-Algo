import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class practice {

    public static void printLevel(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode<Integer> frontNode = queue.remove();
            if(frontNode == null){

            }else{
                System.out.print(frontNode.data + " " );
                for(int i = 0; i < frontNode.children.size() ;i++){
                    queue.add(frontNode.children.get(i));
                }
            }
        }
    }

    public static TreeNode<Integer> takeIpLevel(){
        Scanner s  = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootdata = s.nextInt();

        Queue<TreeNode<Integer>> pendingNodes = new ArrayDeque<>();
        TreeNode<Integer> root = new TreeNode<>(rootdata);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> frontNode = pendingNodes.remove();
            System.out.println("Enter Number of children of" + frontNode.data);
            int childcount = s.nextInt();
            for(int i = 0; i < childcount ;i++){
                System.out.println("enter" + (i+1) + "th" + "child of " + frontNode.data);
                int child = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
//        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter childrens of " + n);
        int childCount = s.nextInt();
        for(int i = 0 ; i < childCount ; i++){
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;
    }

    public static void printTree(TreeNode<Integer> root){
        String s = root.data + ":";
        for(int i = 0; i < root.children.size();i++){
            s += root.children.get(i).data + ',';
        }
        System.out.println(s);
        for(int i = 0; i < root.children.size();i++){
            printTree(root.children.get(i));
        }
    }
}
