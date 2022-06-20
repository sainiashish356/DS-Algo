import java.util.Scanner;

public class MergeTwoSortedList {

    public static void main(String[] args) {


    Node<Integer> head1 = takeIp();
    Node<Integer> head2 = takeIp();

    Node<Integer> head3 = mergetwoList(head1, head2);

    print(head3);


}




    public static Node<Integer> mergetwoList(Node<Integer> head1 , Node<Integer> head2){

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        Node<Integer> t1 = head1 , t2 = head2 , head3 = null , tail3 = null;

        //Initially we got our head
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
            }else {
                tail3.next = t2;
                tail3 = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null){
            tail3.next = t1;
        }else{
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

