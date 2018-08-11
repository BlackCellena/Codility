import java.util.*;
public class Solution {

    public int solution(int[] A){
        //find distinct elements of array in time complexity O(NlogN)
        if (A.length == 0) return 0;
        if (A.length ==1) return 1;

        Arrays.sort(A); //(this or a merge sort algorithm)
        int countDistinct = 1;
        for(int i = 1; i<A.length ;i++){
            if (A[i-1]!=A[i])
                countDistinct++;
        }

        return countDistinct;
    }


    public int solution2(int[] A) {

        HashSet<Integer> Map = new HashSet<Integer>();
        for(int a: A)
            Map.add(a);

        return Map.size();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {2,1,1,2,3,1};
        int distinct = sol.solution(A);
        System.out.println(distinct);
    }
}
