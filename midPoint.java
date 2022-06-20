public class midPoint {

    public static Node<Integer> midNode(Node<Integer> head){

        if(head == null || head.next == null){
                return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head.next;

        while(fast != null && fast.next != null){
            slow = head.next;
            fast = head.next.next;
        }
        return slow;
    }
}
