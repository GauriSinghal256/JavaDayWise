
import java.util.*;
public class resStrings {
    // make a function using recursion which removes the a from the given string 
    public static void skip(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p , up.substring(1));
        }else{
            skip(p+ch , up.substring(1));
        }
    }

    // 2nd way to do this as when we dont want to add the up in the argument so how can we do it 
    public static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip(up.substring(1));
        }else{
            return ch + skip(up.substring(1));
        }
    }

    // if we want to skip the whole word apple 
    public static String skipApple(String up) {
    if (up.isEmpty()) {
        return "";
    }
    if (up.startsWith("apple")) {
        return skipApple(up.substring(5));  
    } else {
        return up.charAt(0) + skipApple(up.substring(1));
    }
}

    // if we want to skip app not apple 
    public static String skipAppNotApple(String up){
        if (up.isEmpty()) {
        return "";
    }
    if (up.startsWith("app") && !up.startsWith("apple")) {
        return skipAppNotApple(up.substring(3));  
    } else {
        return up.charAt(0) + skipAppNotApple(up.substring(1));
    }
    }

    // Subsets Question 
    static void subString(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subString(p+ch, up.substring(1));
        subString(p, up.substring(1));
    }
    
    // if we want to return the arraylist containing all these 
     static ArrayList subString2(String p , String up ){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left =  subString2(p+ch, up.substring(1));
        ArrayList<String> right =  subString2(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    



    public static void main(String[] args) {
        skip("" , "helloSamaa");
        System.out.println(skip("haaaungry"));
        System.out.println(skipApple("Blackapple"));
        System.out.println(skipAppNotApple("appnaapple"));
        subString("", "abc");
        System.out.println(subString2("","abc"));

    }
}
