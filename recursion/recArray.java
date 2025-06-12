import java.util.ArrayList;

public class recArray {

    // find if the array is sorted or not using recursion 
    public static boolean issorted(int arr[] , int index){
        if(index>=arr.length){
            return true;
        }
        if(arr[index] < arr[index+1]){
          return issorted(arr, index+1);
        }else{
            return false;
        }
    }

    // 2nd way to do this 
    static boolean sorted2(int arr[] , int index){
        if(index == arr.length){
            return true;
        }
        return arr[index] < arr[index + 1] && sorted2(arr , index+1);
    }

    // Linear search using recursion 
    static int search ( int arr[], int target , int index){
          if(index == arr.length){
            return -1;
          }
          if(arr[index] == target){
            return index;
          }else{
            return search(arr , target , index+1);
          } 
    }

    // check if an element is present in the array or not
    static boolean find( int arr[], int target , int index){
          if(index == arr.length){
            return false;
          }
          return arr[index] == target || find(arr , target , index+1);
    }

    // if we want to find the index from last 
    static int findFromLast ( int arr[], int target , int index){
          if(index == -1){
            return -1;
          }
          if(arr[index] == target){
            return index;
          }else{
            return search(arr , target , index-1);
          } 
    }

    // if we want to find all the index 
    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int arr[] , int target , int index){
        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            list.add(index);
        }
            findAllIndex(arr, target, index+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,2,6};
        //System.out.println(issorted(arr, 0));
        // System.out.println(search(arr, 6, 0));
        // System.out.println(find(arr, 6, 0));
        findAllIndex(arr, 2, 0);
        System.out.println(list);

        
    }
    
}
