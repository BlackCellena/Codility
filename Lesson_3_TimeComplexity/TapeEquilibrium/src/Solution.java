/*A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of:
|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.*/
public class Solution {

    public int solution(int[] A){

        int total = A.length - 1;
        int left = A[0];
        int right = 0;
        //1st pass P=1
        for(int i=1; i< A.length; i++){
            right += A[i];
        }
        int minDiff = Math.abs(left - right);

           // Change one position each time to the right
        //and check new difference
        for(int i=1; i < total; i++){
            left += A[i];
            right -= A[i];
            if(Math.abs(left - right) < minDiff)
                minDiff = Math.abs(left - right);
        }

        return minDiff;
    }
    public static void main(String[] args) {
        int []A  = {3 ,1 ,2,4,3};
        Solution sol = new Solution();
        int num = sol.solution(A);
        System.out.println(num);

    }
}
