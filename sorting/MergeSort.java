import java.util.Arrays;

public class MergeSort {

    public static int[] ms(int arr[]) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int left[] = ms(Arrays.copyOfRange(arr, 0, mid));
        int right[] = ms(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int left[], int right[]) {
        int i = 0, j = 0, k = 0;
        int newarr[] = new int[left.length + right.length];

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                newarr[k++] = left[i++];
            } else {
                newarr[k++] = right[j++];
            }
    }


        while (i < left.length) {
            newarr[k++] = left[i++];
        }

        while (j < right.length) {
            newarr[k++] = right[j++];
        }

        return newarr;
    }

    public static void main(String args[]) {
        int arr[] = {5, 3, 8, 12, 6, 9};
        int sorted[] = ms(arr);

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
