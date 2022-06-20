public class kReverse {

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

        Node<Integer> ans = krev(head  , 3);
        print(ans);
    }


    public static Node<Integer> krev(Node<Integer> head, int k) {

        if (k == 0 || k == 1) {
            return head;
        }

        Node<Integer> curr = head;
        Node<Integer> fwd = null, prev = null;

        int count = 0;

        while (count < k && curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            count++;
        }

        if (fwd != null) {
            head.next = krev(fwd, k);
        }

        return prev;
    }


    public static void print(Node<Integer> head) {
        Node<Integer> temp = head; //we made temp to execute both loops
        while (head != null) {
            System.out.print(head.data + " ");
            //to point the head next
            head = head.next;
        }

    }
}
