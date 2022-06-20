import java.util.Scanner;

public class mergeSort {

    public static void main(String[] args) {

        Node<Integer> head = takeIp();
        head = mergesort(head);
        print(head);
    }

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

    public static Node<Integer> mergesort(Node<Integer> head){

        if(head == null && head.next == null){
            return head;
        }

        Node<Integer> mid = midNode(head);
        Node<Integer> cHead = head;
        Node<Integer> nHead = mid.next;

        mid.next = null;

        cHead = mergesort(cHead);
        nHead = mergesort(nHead);
        Node<Integer> finalHead = mergeLL(cHead , nHead);

        return finalHead;
    }

    private static Node<Integer> mergeLL(Node<Integer> list1, Node<Integer> list2) {

        Node<Integer> t1 = list1 , t2 = list2 , head3 = null , tail3 = null;

        if(t1.data <= t2.data){
            head3 = t1;
            tail3 = t1;
            t1 = t1.next;
        }else{
            head3 = t2;
            tail3 = t2;
            t2 = t2.next;
        }
        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                tail3.next = t1;
                tail3 = t1;
                t1 = t1.next;
            }else{
                tail3.next = t2;
                tail3 = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null){
            tail3.next = t1;
        }
        if(t2 != null){
            tail3.next = t2;
        }

        return head3;

    }


    public static Node<Integer> takeIp(){
        Node<Integer> head = null , tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while(data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
//                Node<Integer> temp = head;
//                while(temp.next != null){
//                    temp = temp.next;
//                }
//                temp.next = newNode;
                tail.next = newNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
