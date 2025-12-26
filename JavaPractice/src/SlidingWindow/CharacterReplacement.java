package SlidingWindow;

public class CharacterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ABAB";
		int k = 2;
		System.out.println("Length of max substring after k character replacement : "+characterReplacement(s, k));

	}
	public static int characterReplacement(String s, int k) {
        int low = 0, high = 0, n = s.length();
        int freq[] = new int[26];//calculate freq of char
        int maxLen = Integer.MIN_VALUE;
        while(high < n){
            freq[s.charAt(high) - 'A']++;
            int len = high - low + 1;
            int maxCnt = find(freq);
            int diff = len - maxCnt;//totlen - max = min cnt to change
             
            while(diff > k){
                freq[s.charAt(low)-'A']--;
                low++;
                maxCnt = find(freq);
                len = high - low + 1;
                diff = len - maxCnt;
            }
            len = high - low + 1;
            maxLen = Math.max(maxLen, len);
            high++;
        }
        return maxLen;
    }

    static int find(int[] arr){
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > cnt){
                cnt = arr[i];
            }
        }return cnt;
    }
}
