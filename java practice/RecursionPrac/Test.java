public class Test {
    public int LinearSearch1(int arr[], int i, int a){ //Linear Search Single Occurence
        if (i == arr.length) {
            return -1;
        }
        else if (arr[i] == a) {
            return i;
        }
        else {
            return LinearSearch1(arr, i+1, a);
        }
    }
    public void LinearSearch2 (int[] arr, int i, int a){ //Linear Search multiple occurwncws
        if (i == arr.length) {
            System.out.println("Not Found");
            return;
        } 
        if (arr[i] == a) {
            System.out.println("Found at index: "+ i);
        }
        LinearSearch2(arr, i + 1, a);
    }
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        int[] arr = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5 };
        Test ob = new Test();
        //System.out.println(ob.LinearSearch1(arr, 0, 3));
        ob.LinearSearch2(arr, 0, 3);
    }
}
