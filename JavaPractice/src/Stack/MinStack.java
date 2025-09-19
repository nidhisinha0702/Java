package Stack;
import java.util.Stack;
public class MinStack {

    long minVal = Long.MAX_VALUE;
    Stack<Long> s;
    
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(s.isEmpty()){
            s.push(val);
            minVal = val;
        }else{
            if(val < minVal){
            s.push(2 * val - minVal);
            minVal = val;
            }else{
            s.push(val);
            }
        }
        
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        Long x = s.pop();
        if(x < minVal){
            minVal = (2 * minVal - x);
        }
    }
    
    public int top() {
        Long x = s.peek();
        if(x < minVal)
            return (int)minVal;
        return x.intValue();
    }
    
    public int getMin() {
     return (int)minVal;   
    }
}
