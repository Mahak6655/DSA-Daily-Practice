import java.util.*;
public class majorityElement {

public static int majorityElementBrute(int arr[]){
        for(int i=0;i<arr.length;i++){
            int cnt =0;
            for(int j=0;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    cnt++;
                }
                if(cnt>arr.length/2) return arr[i];
            }
    }
    return -1;
}

public static int majorityElementBetter(int arr[]){
    HashMap<Integer,Integer>map = new HashMap<>();
    for(int num : arr){
        map.put(num,map.getOrDefault(num, 0)+1);
    }

    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        if(entry.getValue()>arr.length/2){
            return entry.getKey();
        }
    }
    return -1;
}

//moore's voting algo
public static int majorityElementOptimal(int arr[]){
    int cnt =0;
    int el = 0;
    for(int i=0;i<arr.length;i++){
        if(cnt==0){
            cnt=1;
            el = arr[i];
        }
        else if(arr[i] == el){
            cnt++;
        }
        else{
            cnt--;
        }
    }
    int cnt1 = 0;
    for(int i=0;i<arr.length;i++){
        if(arr[i] ==  el){
            cnt1++;
        }
        if(cnt1>arr.length/2){
            return arr[i];
        }
    }
    return -1;
}
    public static void main(String[] args) {
        int arr[] = {2,2,3,3,1,2,2};
        System.out.println(majorityElementOptimal(arr));
    }
}
