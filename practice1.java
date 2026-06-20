public class practice1 {
    //second largest
   public static int secondLargestElement(int[] arr) {
    int largest = 0;
    int secondlargest  = -1;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>largest){
            secondlargest = largest;
            largest = arr[i];     
        }
        if(arr[i]!=largest && arr[i]>secondlargest){
            secondlargest = arr[i];
        }
    }
    return secondlargest;
    }
    public static void main(String[] args) {
        int arr[] = {8, 8, 7, 6, 5};
        System.out.println(secondLargestElement(arr));
    }
}
