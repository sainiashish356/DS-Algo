public class QueueUsingLL<T> {

    Node<T> front;
    Node<T> rear;
    int size;

    QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size() == 0;
    }

    T front() throws QueueEmptyException {
        if(size() == 0){
            throw new QueueEmptyException();
        }

        return front.data;
    }

    void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if(size() == 0){
            throw new QueueEmptyException();
        }
        if(size == 1){
            rear = null;
        }

        T temp = front.data;
        front = front.next;
        size--;
        return temp;
    }

}
