/*An array A consisting of N different integers is given.
 The array contains integers in the range [1..(N + 1)],
 which means that exactly one element is missing.
  */

       // Your goal is to find that missing element.
public class Solution {


    public int solution(int[] A){

        //sum of the series if all elements existed
        //a1= 1, aN = N+1, sum = (n(a1+aN))/2

        long n = A.length+1;    //(using int instead of long causes errors probably due to overflow??)
        long complete = ((n)*(1+n))/2;

        //sum of the array we were given
        long sum= 0;
        for (int i =0;i<A.length;i++)
            sum += A[i];
        //element missing
      //  System.out.println( sum +" "+sum2);

            return (int)(complete-sum);
    }
    public static void main(String[] args) {
    Solution sol = new Solution();

    int[] A = {2,3,1,5};
    int res = sol.solution(A);
    System.out.println(res);
    }
}
