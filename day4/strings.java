public class strings {

    // check if a string is  a palindrom
    public static boolean isPalindrom(String str){
        int start = 0;
        int end = str.length()-1;
        while(start<=end){
            if(str.charAt(start)!= str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // given a route containing 4 directions NSEW find the shortest path to find the correct destination
    public static float getShortestPath(String str){
        int x=0;
        int y=0;
        for(int i=0 ; i<str.length() ; i++){
            char dir = str.charAt(i);
            if(dir == 'N'){
                y++;
            }
            else if(dir == 'S'){
                y--;
            }
            else if(dir == 'W'){
                x--;
            }else{
                x++;
            }
        }
        int x2 = x*x;
        int y2 = y*y;
        return (float)Math.sqrt(x2+y2);
        
    }

    // for a given set of string print the largest string (basically according to the lexicographic method)
    public static String largestString(String arr[]){
        String largest = arr[0];
        for(int i=0 ; i<arr.length ; i++){
            if(largest.compareTo(arr[i])<0){
                largest = arr[i];
            }
        }
        return largest;
    }

    // make your own method to uppercase the first letter of each word in a string
    // this method will only work if the first letter is not a space
    public static String toUpperCase2(String str){
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i =1; i<str.length() ; i++){
            if(str.charAt(i) == ' '){
                sb.append(' ');
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // question asked at interview of Amazon
    // String compression 
    public static String stringCompression(String str){
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for(int i=1 ; i<str.length() ; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                sb.append(str.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);
        return sb.toString();
    }



    public static void main(String agrs[]){
        // to print all the characters of a string
        String name = "Gauri Singhal";
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i)+" ");
        }
        // System.out.println(isPalindrom("abcdecba"));
        // System.out.println(getShortestPath("WNEENESENNN"));
        // this is a method to print the substring of the string 
        // System.out.println("HelloGuys".substring(0, 5));

        // System.out.println(largestString(new String[] {"apple" , "mango" , "banana" , "litchi" , "papaya"}));

        // initiation of string builder
        StringBuilder sb = new StringBuilder("");
        // if we want to convert objects to string then we can use a method .toString();


        // print all the characters from a to z
        for(char ch = 'a' ; ch<='z' ; ch++){
            sb.append(ch);
        }
        System.out.println(sb);

        // if we want to capitalize all the letters of string we have a method 
        // System.out.println("hello I am a good girl".toUpperCase());

        // now if we want to make it ourselves
        System.out.println(toUpperCase2("hello how are you?"));









        
    }
}
