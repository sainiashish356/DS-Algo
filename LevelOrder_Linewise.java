import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrder_Linewise {

    public static void levelOrderLineWise(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> main = new ArrayDeque<>();
        main.add(root);

        Queue<TreeNode<Integer>> child = new ArrayDeque<>();
        while(!main.isEmpty()){
            root = main.remove();
            System.out.print(root.data +  " ");

            for(TreeNode<Integer> ch : root.children){
                child.add(ch);
            }

            if(main.size() == 0){
                main = child;
                child = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

}
