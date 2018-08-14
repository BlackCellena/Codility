public class Solution {

    //Given a log of stock prices compute the maximum possible earning.

    //For each position, we compute the largest profit at that
    //position.
    public int solution(int[] A){
        if(A.length <= 1) return 0;

        int maxProfit = 0,minPrice = A[0];
         for (int i=0;i<A.length;i++) {
             maxProfit = Math.max(maxProfit, A[i] - minPrice);
             minPrice = Math.min(minPrice, A[i]);
         }
        return maxProfit;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {23171,21011,21123,21366,21013,21367};
         int maxProfit     =sol.solution(A);
         System.out.print(maxProfit);
    }
}
