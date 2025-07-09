package String;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char chars[] = {'a','a','b','b','c','c','c'};
		System.out.println("The compressed string length is : "+compress(chars));

	}
	public static int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;//write pointer
        for(int i=0;i<n;i++){//read pointer
            char ch = chars[i];
            int count = 0;
            while(i<n && chars[i] == ch){
                count++;
                i++;
            }

            if(count == 1){
                chars[idx++] = ch;
            }else{
                chars[idx++] = ch;
                String str = String.valueOf(count);
                for(char c:str.toCharArray()){
                    chars[idx++] = c;
                }
            }
            i--;
        }
        return idx;
    }
}
