public class missingAndRepating{

    //Approach :- FrequencyCount
    
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int frequency[] = new int[n*n+1];

        for(int[] row : grid){
            for(int nums : row){
                frequency[nums]++;
            }
        }
        int repeat = -1;
        int missing = -1;
        for(int i=1;i<=n*n;i++){
            if(frequency[i]> 1) repeat = i;
            if(frequency[i] == 0) missing =  i;
        }
        return  new int[]{repeat,missing};
    }
    public static void main(String[] args) {
        int[][] grid = {
        {1, 2},
        {1, 4}
    };
    }
}