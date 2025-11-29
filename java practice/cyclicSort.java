import java.util.Arrays;

public class cyclicSort{
    public static void swap(int arr[],int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,4};
        int n = arr.length;
        int i = 0,a;
        while (i<n){
            if(arr[i] != (i+1)){
                a = arr[i];
                swap(arr,i,a-1);
            }
            else
                i++;
        }
        System.out.println("The sorted array is: "+Arrays.toString(arr));
    }
}