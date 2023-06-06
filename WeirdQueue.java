import java.util.EmptyStackException;
import java.util.Stack;

public class WeirdQueue {
    private Stack<Object> primary;
    private Stack<Object> second;
    private int manyItems; 
    // constructor with no arguments that initializes the two stacks and the number of items in 
    // the queue
    public WeirdQueue() {
        primary = new Stack<Object>();
        second = new Stack<Object>();
        manyItems = 0; 
    }
    // Adds an item to the queue. Constant time, O(1) just inserts item to the back of the queue
    public void enqueue(Object item) {
        primary.push(item); 
        manyItems++; 
    }
    // removes items from queue in order of FIFO
    public Object dequeue(){
        // An error would occur if the queue is empty since we cannot pop from an empty stack
        if(manyItems == 0){throw new EmptyStackException();}
        Object temp = null; 

        // this empties the first stack onto the second stack, so that the first inserted item ends up at the 
        // top of the second stack. This takes O(n)
        for(int i = 0; i < manyItems; i++){
            second.push(primary.pop()); 
        }
        // this is where the error would occur if the stack was empty 
        temp = second.pop(); 
        manyItems--;
        // return all the values to the primary stack, this also take O(n)
        for(int i = 0; i < manyItems; i++){
            primary.push(second.pop()); 
        }
        return temp; 
    }
}