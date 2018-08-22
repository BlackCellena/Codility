public class Solution {

    //find the smallest perimeter of a rectangular with area N.
    public int solution(int N){

        //find the divisors of N and check the perimeter

        int i = 1, minPer = Integer.MAX_VALUE;
        while (Math.pow(i,2) <N) {
            if (N % i == 0) {
                minPer = Math.min(minPer, 2*(N/i + i));
            }
            // so we count its pair two
            i++;
        }
        if(Math.pow(i,2)==N)
            minPer = Math.min(minPer, 2*(N/i + i));
        return minPer;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int N = 30;
        int perimeter = sol.solution(N);
        System.out.println(perimeter);

    }
}
