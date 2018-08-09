/*A small frog wants to get to the other side of the road.
 The frog is currently located at position X and wants to get to a position greater than or equal to Y.
  The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.*/

public class Solution {

    public int solution(int X, int Y, int D){
       // to integer-divide positive num by positive divisor and round up is (num+(divisor-1))/divisor
        return ((Y - X) + (D - 1)) / D;
    }

    public static void main(String[] args) {
       int  X = 3, Y = 999111321, D = 7;

       Solution sol = new Solution();
       int res = sol.solution(X,Y,D);
       System.out.println(res);
    }
}
