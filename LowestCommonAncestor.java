import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode<Integer> root = takeIpLevel();
        int ans = lca(root , 70 , 110);
        System.out.println(ans);
    }

    public static int lca(TreeNode<Integer> root , int d1 , int d2){
        ArrayList<Integer> p1 = nodetoRoot(root , d1);
        ArrayList<Integer> p2 = nodetoRoot(root , d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1 ;
        while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return p1.get(i);

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
    public static ArrayList<Integer> nodetoRoot(TreeNode<Integer> root , int data){
        if(root.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }

        for(TreeNode<Integer> child : root.children){
            ArrayList<Integer> path = nodetoRoot(child , data);
            if(path.size() > 0){
                path.add(root.data);
                return path;
            }
        }
        return new ArrayList<>();
    }

}
