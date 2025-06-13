import java.util.Stack;

public class StackQues {

    // push at the bottom of the stack 
    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // reverse the string using stack 
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int index = 0;
        while(index <str.length()){
            s.push(str.charAt(index));
            index++;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        str = result.toString();
        return str;
    }

    // Reverse the stack 
    


    public static void main(String[] args) {
        // push at the bottom of the stack 
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s , 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // reverse the string using stack 
        String str = "HelloWorld";
        System.out.println(reverseString(str));

    }
}
