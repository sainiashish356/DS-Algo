import java.util.Scanner;

public class InsertNode {

    public static void main(String[] args) {
        Node<Integer> head = takeIp();
//        Node<Integer> Ans = insert(head , 40 , 2);
        Node<Integer> Ans = deleteNode(head , 2);
        print(Ans);
    }

        public static  Node<Integer> deleteNode(Node<Integer> head , int pos){

            if(pos == 0){
                head = head.next;
                return head;
            }

            int count = 0;
            Node<Integer> temp = head;
            while(count < pos - 1){
                  temp = temp.next;
                  count++;
            }
            temp.next = temp.next.next;
            return head;
        }
        public static Node<Integer> insert(Node<Integer> head ,int data , int pos){

                if(pos == 0){
                    Node<Integer> newNode = new Node<>(data);
                    newNode.next = head;
                    return newNode;
                }

            Node<Integer> newNode = new Node<>(data);
            int i = 0;
            Node<Integer> temp = head;
            while(i < pos - 1){
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;

            return head;
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
