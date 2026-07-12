package Graph;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //to look up in constant time if the word exist
        HashSet<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> vis = new HashSet<>();
        vis.add(beginWord);

        if(!set.contains(endWord))
            return 0;
        int changes = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord)) return changes;
                for(int j=0;j<word.length();j++){
                    for(char k='a';k<='z';k++){
                        char arr[] = word.toCharArray();
                        arr[j] = k;
                        String str = new String(arr);
                        if(set.contains(str) && !vis.contains(str)){
                            q.add(str);
                            vis.add(str);
                        }
                    }
                }
            }++changes;
        }return 0;

    }
}
