
class Queues{
    private int maxSize;
    private int[] qArray;
    private int front;
    private int rear;
    private int nItems;


    public Queues(int size){
        maxSize = size;
        qArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean insert(int x){
        if(isFull()){
            return false;
        }
        if(rear == maxSize-1){
            rear = -1;
        }
        rear++;
        qArray[rear] = x;
        nItems++;
        return true;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        int temp = qArray[front];
        front++;
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    public int peekFront(){
        return qArray[front];
    }
    public int peekRear(){
        return qArray[rear];
    }
    public boolean isEmpty(){
        return(nItems ==0);
    }
    public boolean isFull(){
        return(nItems == maxSize);
    }
    public int getSize(){
        return nItems;
    }

}


public class Queue {

    public static void main(String args[]){
        
        Queues myQueue = new Queues(5);
        myQueue.insert(6);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(1);
        myQueue.insert(9);

        System.out.println(myQueue.peekFront());

        myQueue.remove();

        System.out.println(myQueue.peekFront());




    }


}
