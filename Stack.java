

class Stacks{
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stacks(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value){
        top++;
        stackArray[top] = value;
    }
    public int pop(){
        return stackArray[top--];
    }
    public int peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top ==-1);
    }
    public boolean isFull(){
        return (top+1 == maxSize);
    }

    public void makeEmpty(){
        top = -1;
    }
}

public class Stack {

    public static void main(String args[]){


        Stacks myStack = new Stacks(6);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());








    }
}
