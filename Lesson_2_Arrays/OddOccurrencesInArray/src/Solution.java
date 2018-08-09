
public class Solution {

    public int solution(int[] A){

        int result = 0;
        for (int x : A) result ^= x;
        return result;



    }
    public static void main(String[] args) {

        Solution sol =new Solution();
        int[]A = {1,1,1};
        int num = sol.solution(A);
        System.out.println(num);
    }
}
