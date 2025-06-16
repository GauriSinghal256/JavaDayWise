import java.util.*;

public class queueQues {

    // flipkart
    // first non repeating character in a stream of characters given all the characters are lower case
    // way to do is that we will make a frequency array of 26 letters each index associated with one letter and we can see what is non rpeating 
    // and we will take a queue also one by one we will keep adding the characcters to queue and continously check on the front that , the charcter which is on the front whether it is having frequency <=1 if then we can make it as first non repeating character
    // and the frequency is still greater then 1 we will remove the element from the queue as there is no benifit of storing it and then again we will check for the front one 
    
    public static void nonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0 ; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.println("-1");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
       System.out.println();
    }

    // interleave two halves of a queue  if the input is 12345678910  16273849510
    // firstly take the size of queue and then half it and half the half elements to the new queue 
    // so now we have two queue then we can pick elements one by one from both of the queue and add it to the original one only from last 
     public static void interLeave(Queue<Integer> q){
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size();

        for(int i=0 ; i<size/2 ; i++){
            firsthalf.add(q.remove());
        }
        while(!firsthalf.isEmpty()){
            q.add(firsthalf.remove());
            q.add(q.remove());
        }
     }

    //  queue reversal 
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        // String str = "aabccxb";
        // nonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        // interLeave(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }

        // reverse 
        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.remove();
        }

    }
}
