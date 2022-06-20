public class foldLL {


    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(10);
        Node<Integer> node2 = new Node<Integer>(20);
        Node<Integer> node3 = new Node<Integer>(30);
        Node<Integer> node4 = new Node<Integer>(40);
        Node<Integer> node5 = new Node<Integer>(50);
        Node<Integer> node6 = new Node<Integer>(60);
        Node<Integer> node7 = new Node<Integer>(70);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node<Integer> head = node1;

        foldLinkedList(head);
        
    }

    public static void foldLinkedList(Node<Integer> head){
        if(head == null || head.next == null ){
            return;
        }

        Node<Integer> midNode = mid(head);
        Node<Integer> nHead = midNode.next;
        midNode.next = null;

        //now we reverse the second half list
        Node<Integer> rHead = reverse(nHead);

        //now we initialize 4 pointers to fold the list
        Node<Integer> curr1 = head , curr2 = rHead , fwd1 = null , fwd2 = null;

        while(curr1 != null && curr2 != null){
            //backup
            fwd1 = curr1.next;
            fwd2 = curr2.next;

            //link
            curr1.next = curr2;
            curr2.next = fwd1;

            //move pointer ahead
            curr1 = fwd1;
            curr2 = fwd2;

        }

    }

    public static Node<Integer> mid(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;
        while(fast != null || fast.next != null){
            slow = head.next;
            fast = head.next.next;
        }
        return slow;
    }

    public static Node<Integer> reverse(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }

        Node<Integer> fwd;
        Node<Integer> curr = head , prev = null;
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
