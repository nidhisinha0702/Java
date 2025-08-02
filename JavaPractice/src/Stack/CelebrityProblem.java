package Stack;
import java.util.Stack;
public class CelebrityProblem {

	public static void main(String[] args) {
		int arr[][] = {{0,1,0},{0,0,0},{0,1,0}};
		System.out.println(celebrity(arr));

	}
	//O(n) O(n)
	private static int celebrity(int arr[][]) {
		Stack<Integer> s = new Stack<>();
		
		int n = arr.length;
		//push all the index in stack and start popping in pair
		for(int i=0;i<n;i++) {
			s.push(i);
		}
		
		while(s.size() > 1) {
		  int i = s.pop();
		  int j = s.pop();
		  //here for i -> j (0) means i don't know j so, j can never be the celebrity and we can eliminate j
		  if(arr[i][j] == 0) {
			  s.push(i);
		  }else {
			  s.push(j);
		  }
		}
		
		// we will verify is the element in the stack is celebrity or not
		int celeb = s.peek();
		for(int i=0;i<n;i++) {
			//everyone should know celebrity and celebrity should no one
			if(i != celeb && (arr[i][celeb] == 0 || arr[celeb][i] == 1))
				return -1;
		}
		
		return celeb;
	}
}
