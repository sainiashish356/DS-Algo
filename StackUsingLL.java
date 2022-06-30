public class StackUsingLL<T> {


        private Node<T> head;
        private int size;

        public StackUsingLL(){
            head = null;
            size = 0;
        }

        int size(){
        return size;
        }

        T top() throws StackEmptyException {
            if(head == null || size() == 0 ){
                StackEmptyException e = new StackEmptyException();
                throw e;
            }
            return head.data;

        }

        boolean isEmpty(){
        if(size() == 0){
            return true;
        }else{
            return false;
            }
        }

        public void push(T element){

            Node<T> newNode = new Node<T>(element);
            newNode.next = head;
            head = newNode;
            size++;

        }

        public T pop() throws StackEmptyException {
        if(size() == 0){
            throw new StackEmptyException();
        }
        T tempdata = head.data;
        head = head.next;
        size--;
        return tempdata;


        }




}
