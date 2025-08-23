public class string3 {
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

    public static String Rearrange(String str){

        String[] newStr = str.split("\\s+");

        StringBuilder reversed = new StringBuilder();
        for (int i = newStr.length - 1; i >= 0; i--) {
            reversed.append(newStr[i]);
            if (i > 0) {
                reversed.append(" ");
            }
    }
    return reversed.toString();
    }

    public static void main(String[] args) {
        // String str = "aaabbc";
        // System.out.println(stringCompression(str));

        String str = "I Love Coding";
        System.out.println(Rearrange(str));

    }
}
