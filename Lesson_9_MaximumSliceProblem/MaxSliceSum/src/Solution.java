public class Solution {

    //Given a log of stock prices compute the maximum possible earning.

   //For each position, we compute the largest sum that
   //ends in that position. If we assume that the maximum sum of a slice ending in position i equals
   //max_ending, then the maximum slice ending in position i+1 equals max(A[i+1], max_ending A[i+1]).
    public int solution(int[] A){
        if (A.length == 1) return A[0];

        int max_ending=A[0],max_slice = A[0];
        for (int i=1;i<A.length;i++) {
            max_ending = Math.max(A[i], max_ending + A[i]);
            max_slice = Math.max(max_slice, max_ending);
        }
         return max_slice;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {3, 2, -6, 4, 0};
        int maxProfit     =sol.solution(A);
        System.out.print(maxProfit);
    }
}
