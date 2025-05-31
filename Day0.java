
public class Day0 {

    // half triangle 
    public static void NHTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Square pattern
    public static void Square(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //inverted Half Triangle
    public static void IHTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Numbering half triangle 
    public static void NumHTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Character Half pattern
    public static void ChTriangle(int n) {
        char Alpha = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(Alpha);
                Alpha++;
            }
            System.out.println();
        }
    }

    // HollowRectangle 
    public static void HollowRectangle(int r, int c) {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i == 1 || j == 1 || i == r || j == c) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //  Inverted Rotated Triangle 
    public static void IRTriangle(int n){
       for(int i=1 ; i<=n ; i++){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=i ; k++){
            System.out.print("*");
        }
        System.out.println();
       }
    }

    // Inverted half pyramid with numbers
    public static void IHNTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // Floyd Triangle 
    public static void FloydTriangle(int n) {
        int Num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(Num+" ");
                Num++;
            }
            System.out.println();
        }
    }

    // 0-1 triangle 
    public static void ZOTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if((i+j) % 2 == 0 ){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    // ButterFly Pattern
    public static void BPattern(int n){
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=i ; j++){
                System.out.print("*");
            }
            for(int k=1 ; k<=2*(n-i) ; k++){
                System.out.print(" ");
            }
            for(int l=1 ; l<=i ; l++){
                System.out.print("*");
            }
             System.out.println();
        }
        for(int i=n ; i>=1; i--){
            for(int j=1 ; j<=i ; j++){
                System.out.print("*");
            }
            for(int k=1 ; k<=2*(n-i) ; k++){
                System.out.print(" ");
            }
            for(int l=1 ; l<=i ; l++){
                System.out.print("*");
            }
             System.out.println();
        }
    }

    // Solid Rhombus
    public static void SolidR(int n){
       for(int i=1 ; i<=n ; i++){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=n ; k++){
            System.out.print("*");
        }
        System.out.println();
       }
    }

    // Hollow Rhombus
    // Solid Rhombus
    public static void HollowR(int n){
       for(int i=1 ; i<=n ; i++){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=n ; k++){
            if(i==1||k==1||i==n || k==n)
            System.out.print("*");
            else{
            System.out.print(" ");
            }
        }
        System.out.println();
       }
    }

    // Diamond 
    public static void Diamond(int n){
       for(int i=1 ; i<=n ; i++){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=(2*i-1) ; k++){
            System.out.print("*");
        }
        System.out.println();
       }
       for(int i=n ; i>=1 ; i--){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=(2*i-1) ; k++){
            System.out.print("*");
        }
        System.out.println();
       }
    }

    // Hollow Daimond 
     public static void HDiamond(int n){
       for(int i=1 ; i<=n ; i++){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=(2*i-1) ; k++){
            System.out.print("*");
        }
        System.out.println();
       }
       for(int i=n ; i>=1 ; i--){
        for(int j=1 ; j<=n-i ; j++){
            System.out.print(" ");
        }
        for(int k=1 ; k<=(2*i-1) ; k++){
            System.out.print("*");
        }
        System.out.println();
       }
    }



    public static void main(String[] args) {
        // NHTriangle(5);
        // Square(4);
        // IHTriangle(6);
        // NumHTriangle(7);
        // ChTriangle(3);
        // HollowRectangle(5, 6);
        // IRTriangle(5);
        // IHNTriangle(7);
        // FloydTriangle(7);
        // ZOTriangle(5);
        // BPattern(4);
        // SolidR(5);
        // HollowR(5);
        // Diamond(5);


    }
}
