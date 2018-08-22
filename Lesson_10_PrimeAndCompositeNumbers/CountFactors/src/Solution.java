public class Solution {

    public int solution(int N){
        if (N==1) return 1;
        int i = 1, count =0;
        while (Math.pow(i,2) <N) {
            if (N % i == 0)
                count+=2 ;  //if iis a divisor of n then n/i is also one
                            // so we count its pair two
            i++;
        }
        if(Math.pow(i,2)==N)
            count++;
        return count;

    }
    public static void main(String[] args) {
        Solution sol =new Solution();
        int N = 24;
        int count = sol.solution(N);
        System.out.println(count);
    }
}
