import java.util.*;
public class Solution {


    public int solution(int[] A){

        int smallestMissingInteger = 1;
        if (A.length == 0) {
            return smallestMissingInteger;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        while (set.contains(smallestMissingInteger)) {
            smallestMissingInteger++;
        }
        return smallestMissingInteger;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1,2,3};
        int res = sol.solution(A);
        System.out.println(res);

    }
}
