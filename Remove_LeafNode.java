import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Remove_LeafNode {

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        TreeNode<Integer> ans = removeLeaf(root);
        printLevel(ans);
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

    public static void printLevel(TreeNode<Integer> root){
        if(root == null){
            return ;
        }

        System.out.print(root.data + " ");
        for(int i = 0; i < root.children.size() ;i++){
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();

        for(int i = 0; i < root.children.size() ;i++){
           printLevel(root.children.get(i));
        }
    }

    public static TreeNode<Integer> removeLeaf(TreeNode<Integer> root){
      if(root == null){
          return null;
      }
      if(root.children.size() == 0){
          return null;
      }
      for(int i = 0 ; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);

            //if its a leaf
          if(child.children.size() == 0){
              // shifting the vector to left
              // after the point i
              for (int j = i; j < root.children.size() - 1; j++) {
                  root.children.set(j, root.children.get(j + 1));
              }
              // delete the last element
              root.children.remove(root.children.size()-1);

              i--;
          }
      }
        // Remove all leaf node
        // of children of root
        for (int i = 0;
             i < root.children.size();
             i++) {

            // call function for root.children
            root.children.set(i,removeLeaf(root.children.get(i)));
        }
        return root;
          }
        }


