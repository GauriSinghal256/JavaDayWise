// Given two strings s and t , return true if t is an anagram of s , and flase otherwise .
import java.util.*;
public class ValidAnagram {
     public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap <Character,Integer> map = new HashMap<>();
        for(int i=0 ;i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        for(int i=0 ; i<t.length() ; i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

     public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        char [] sArray=s.toCharArray();
        char [] tArray=t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray,tArray);
    }
    public static void main(String[] args) {
        
    }
}
