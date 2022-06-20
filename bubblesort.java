public class bubblesort {

    public static void bubble(int[] arr){

        for(int i= 0; i < arr.length; i++){

            for(int j = 1; j < arr.length-i ; j++){

                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]= temp;
                }
            }
        }

    }


    public static int length(Node<Integer> head){
            int count = 0;
            while(head != null){
                head = head.next;
                count++;
            }
            return count;
    }

    public static Node<Integer> BUBBLESORT(Node<Integer> head){

        int n = length(head);

        for(int i =0 ; i < (n -1) ; i++){
            Node<Integer> curr = head;
            Node<Integer> prev = null;

            for(int j = 0 ; j < (n - i - 1) ; j++){
            //means both nodes are at correct position no changes
                if(curr.data <= curr.next.data){
                    prev = curr;
                    curr = curr.next;
                }else if(prev == null) {  //means we need to swap first two nodes
                    Node<Integer> fwd = curr.next;
                    head = head.next;
                    curr.next = fwd.next;
                    fwd.next = curr;
                    prev= fwd;
                }else{
                    Node<Integer> fwd = curr.next;
                    prev.next = fwd;
                    curr.next = fwd.next;
                    fwd.next = curr;
                    prev = fwd;
                }

            }
        }
    return head;
    }

}
