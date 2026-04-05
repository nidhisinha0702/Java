package Recursion;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println("Letter Combination : "+letterCombinations(digits));
    }

    static Map<Character,String> letters = new HashMap<>(){{put('2',"abc"); put('3',"def"); put('4', "ghi"); put('5', "jkl");
        put('6',"mno"); put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");}};

    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        StringBuilder diary = new StringBuilder();
        fun(0, n, digits, diary, res);
        return res;

    }

    public static void fun(int idx, int n, String digits, StringBuilder diary, List<String> res){
        if(idx == n){
            res.add(diary.toString());
            return;
        }
        String choice = letters.get(digits.charAt(idx));
        for(int j=0;j<choice.length();j++){
            diary.append(choice.charAt(j));
            fun(idx+1, n, digits, diary, res);
            diary.deleteCharAt(diary.length() - 1);
        }

    }
}
