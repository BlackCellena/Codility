public class Solution {

  //find maximum sum of any double slice.
  public int solution(int[] A) {

      int[] maxLeft = new int[A.length];
      int[] maxRight = new int[A.length];
      int max = 0;

     // keep track of two slice arrays. The optimal double slice is at an index
      // that has the maximal sum of those two arrays.

      // maxLeft[i] is the maximum sum continuous subsequences ending at index i

      for (int i = 1; i < A.length; i++) {
          maxLeft[i] = Math.max(0, maxLeft[i-1] + A[i]);
      }
      // maxRight[i] is the maximum sum continuous subsequence starting at index i
      for (int i = A.length - 2; i >= 0; i--) {
          maxRight[i] = Math.max(0, maxRight[i+1] + A[i]);
      }

      //find the maximum of "maxLeft + maxRight"
      for (int i = 1; i < A.length - 1; i++) {
          max = Math.max(max, maxLeft[i-1] + maxRight[i+1]);
      }
      return max;
  }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        int sum = sol.solution(A);
        System.out.print(sum);
    }
}
