/*A non-empty array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.*/

public class Solution {

    public int solution(int[] A){

        int[] temp=A;
        java.util.Arrays.sort(temp);
        for (int i=0;i<A.length;i++){
            if (temp[i]!=i+1)
                return 0;
        }
        return 1;
    }
    public static void main(String[] args) {

        Solution sol =new Solution();
       int[]  A = {1, 4, 1};
       int res = sol.solution(A);
       System.out.println(res);
    }
}
