package Stack;
import java.util.Stack;
public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()){{}}[]";
		System.out.println(isValid(s));

	}
	public static boolean isValid(String str) {
        //last opening => first closing
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            //opening
            if(ch == '(' || ch == '{' || ch == '[')
            st.push(ch);
            else{//closing
                //if opening  > closing and vice versa
                if(st.size() == 0)
                    return false;
                if((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') || (st.peek() == '[' && ch == ']'))
                    st.pop();
                else
                    return false;
            }
        }
        return st.size() == 0;
    }
}
