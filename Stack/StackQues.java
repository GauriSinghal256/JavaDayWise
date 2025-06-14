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
    // first way to solve it is that we can make one more stack and push the elements one by one to that so staack will be reversed but an extra space is used so we can solve it by another method
    // we will solve it in O(n) time but constant space
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    // Stock span problem 
    // max no. of consecutive days for which price<= today's price
    public static void stockSpan(int stocks[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1 ; i<stocks.length ; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }


    // Valid Parenthesis 
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            // opening
            if(ch =='(' || ch=='{' || ch=='['){
                s.push(ch);
            }else{ //closing 
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch==')') || (s.peek() == '{' && ch=='}') || (s.peek() == '[' && ch==']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
         if(s.isEmpty()){
                return true;
            }else{
                return false;
            }
        }

        // Duplicate Parenthesis 
        public static boolean isDuplicate(String str){
            Stack<Character> s = new Stack<>();

            for(int i=0 ; i<str.length() ; i++){
                char ch = str.charAt(i);

                // closing 
                if(ch==')'){
                    int count = 0;
                    while(s.peek()!='('){
                        s.pop();
                        count++;
                    }
                    if(count<1){
                        return true;
                    }else{
                        s.pop();
                    }
                }else{
                    //opening
                    s.push(ch);
                }
            }
            return false;
        }



    


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
        // String str = "HelloWorld";
        // System.out.println(reverseString(str));

        // reverse a stack 
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // // printStack(s);
        // reverseStack(s);
        // printStack(s);

        // Stock span problem 
        // int stocks[] = {100 , 80 , 60 , 70 , 60 , 85 , 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks , span);
        
        // for(int i=0 ; i<span.length ; i++){
        //     System.out.println(span[i]);
        // }

        // valid parenthesis 
        // String str = "({{[{]}})";
        // System.out.println(isValid(str));

        // Duplicate Parenthesis 
        // String str = "((a+b)*(c+d))";
        // System.out.println(isDuplicate(str));

    }
}
