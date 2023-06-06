import java.util.Stack;
public class StackSorting{

    public Stack<Integer> sort(Stack<Integer> s){
        //implement this function.
        // stack is empty, so return the stack
        if(s.empty()){return s;}
        if(s.size() == 1) // only 1 item so it is sorted
        {
            return s; 
        }

        Stack<Integer> sorted = new Stack<Integer>(); 
        // will empty out the inputed stack and populate the sorted array
        while(!s.empty())
        {
            sorted.push(min(s));
        }
        s = sorted;

        return s; 
    }
    
    private Integer min(Stack<Integer> orig)
    {
        // no need to check if the stack is empty since the condition is already checked in the main
        Stack<Integer> temp = new Stack<>();
        Integer minVal = orig.pop(); 
        Integer temp3 = null;
        // if the original stack only had 1 item, then it is stored in minVal and original stack is empty
        // so the while loop whould be skippped
        while(!orig.empty()){
            // compare the values with the min value from the stack. Eventually the min value will be returned
            // all other values are stored in a temporary stack 
            temp3 = orig.pop();
            if(temp3 < minVal)
            {
                temp.push(minVal);
                minVal = temp3; 
            }
            else{
                temp.push(temp3);
            }

        }
        // the contents of the temporary stack are returned to the original stack
        while(!temp.empty()){
            orig.push(temp.pop());
        }
        //return the minimum value left in the original stack. This value will be pushed to the sorted 
        // stack
        return minVal;
    } 
}