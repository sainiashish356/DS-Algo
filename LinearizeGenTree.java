public class LinearizeGenTree {

    public static TreeNode<Integer> linearize2(TreeNode<Integer> root){
        TreeNode<Integer> LastKiTail = linearize2(root.children.get(root.children.size() - 1));

        while(root.children.size() > 1){
            //removing our last child of root
            TreeNode<Integer> last = root.children.remove(root.children.size() - 1);
            TreeNode<Integer> secondLast = root.children.get(root.children.size() - 1);
            TreeNode<Integer> secondLastKiTail = linearize2(secondLast);
            secondLastKiTail.children.add(last);
        }
        return LastKiTail;
    }

    public static void linearize(TreeNode<Integer> root){
        for(TreeNode<Integer> child : root.children){
            linearize(child);
        }
        while(root.children.size() == 1){
            TreeNode<Integer> lastchild = root.children.remove(root.children.size()-1);
            TreeNode<Integer> secondlastchild = root.children.get(root.children.size() - 1);
            TreeNode<Integer> secondLastchild = getTail(root);
            secondLastchild.children.add(lastchild);
        }
    }

    private static TreeNode<Integer> getTail(TreeNode<Integer> root) {
        while(root.children.size() == 1){
            root = root.children.get(0);
        }
        return root;
    }
}
