class Traversal{
    public static void main(String args[]){
        int arr[][] = { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9} };
        
        // printing all the elements of 2D array
        
        for(int i=0 ; i<arr.length; i++){
            for(int j=0; j<arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
        }

        // using modified for loop or we can say for-each loop
        System.out.println();

        for(int[] a: arr){
            for(int elem : a){
                System.out.print(elem + " ");
            }
        }

        // printing all the elements of the array column wise 
        System.out.println();
        for(int i=0 ; i<arr[0].length; i++){
            for(int j=0; j<arr.length ; j++){
                System.out.print(arr[j][i] + " ");
            }
        }

        // sum of all the elements of 2D array
        System.out.println();
        int sum=0;
        for(int[] a: arr){
            for(int elem : a){
                sum += elem;
            }
        }
        System.out.println("Sum of all the elements: " + sum);


        // find the largest element in 2D array
        int max = Integer.MIN_VALUE;
         for(int[] a: arr){
            for(int elem : a){
                max = Math.max(max, elem);
            }
        }
        System.out.println("Largest element is: " + max);

        // find the row with the largest sum
        int maxRowSum = Integer.MIN_VALUE;
        int rowSum = 0;

        for(int i=0 ; i<arr.length; i++){
            rowSum = 0;
            for(int j=0; j<arr[i].length ; j++){
                rowSum += arr[i][j];
            }
            maxRowSum = Math.max(rowSum , maxRowSum);
        }

        System.out.println("Maximum row sum is: " + maxRowSum);

        // find the column with the largest sum
        int maxColSum = Integer.MIN_VALUE;
        int colSum = 0; 
        for(int i=0 ; i<arr[0].length; i++){
            colSum = 0;
            for(int j=0; j<arr.length ; j++){
                colSum += arr[j][i];
            }
            maxColSum = Math.max(colSum , maxColSum);
        }
        System.out.println("Maximum column sum is: " + maxColSum);
        
        // Find the minimum element out of all the maximum elements of each row
        int minOfRowMax = Integer.MAX_VALUE;
        int MaxROwElem = Integer.MIN_VALUE;

        for(int i=0 ; i<arr.length; i++){
            MaxROwElem = Integer.MIN_VALUE;
            for(int j=0 ; j<arr[i].length ; j++){
                MaxROwElem = Math.max(MaxROwElem , arr[i][j]);
            }
            minOfRowMax = Math.min(minOfRowMax , MaxROwElem);
        }

        System.out.println("Minimum of all row maximums is: " + minOfRowMax);


        // print matrix in snake pattern
        System.out.println("Matrix in snake pattern: ");

        for(int i=0 ; i<arr.length; i++){
            for(int j=0; j<arr[i].length ; j++){
                if(i%2==0){
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print(arr[i][arr[i].length - 1 - j] + " ");
                }
            }
        }






















































    } 
}