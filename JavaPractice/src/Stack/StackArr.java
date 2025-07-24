package Stack;

public class StackArr {

	int size = 10;
	int arr[] = new int[size];
	int idx = -1;
	public void push(int val) {
		if(idx == size)
			System.out.println("Overflow");
		else
			arr[++idx] = val;
	}
	
	public int top() {
		return arr[idx];
	}
	
	public void pop() {
		arr[idx] = 0;
		idx--;
	}
	
	public boolean empty() {
		return idx == -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArr s = new StackArr();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.push(90);
		s.push(100);
		while(!s.empty()) {
			System.out.print(s.top()+" ");
			s.pop();
		}System.out.println();
	}

}
