import java.util.Scanner;

public class findNode {
    public static void main(String[] args) {
        Node<Integer> head = takeIp();
        int ans = findRec(head , 20);
        System.out.println(ans);

    }
    public static int findRec(Node<Integer> head , int n){

        if(head == null){
            return -1;
        }
        if(head.data.equals(n)){
            return 0;
        }
        int smallAns = findNode(head.next , n);
        if(smallAns == -1){
            return -1;
        }

        return smallAns+1;

    }

    //n denotes for nodes data
    public static int findNode(Node<Integer> head, int n) {

        int pos = 0;

        while (head != null) {
            if (head.data.equals(n)) {
                return pos;
            }
            head = head.next;
            pos++;
        }
        return -1;
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
}
