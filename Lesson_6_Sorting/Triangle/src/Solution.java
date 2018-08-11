import java.util.*;
public class Solution {
    public int solution(int[] A){
        int N =  A.length;
        if (N<=2) return 0;
        if (N==3){
            //cast to long due to possible overflow since each element of array A
            // is an integer within the range [−2,147,483,648..2,147,483,647].
            if ((long)A[0]+ (long)A[1]> (long)A[2] && (long)A[1]+ (long)A[2]> (long)A[0] && (long)A[2]+ (long)A[0]> (long)A[1])
                return 1;
            return 0;
        }
        Arrays.sort(A);// A[R]+A[P] > A[Q] and A[Q]+A[R] > A[P] ( R is always the biggest)
        int P,Q,R;
        for(int i=0;i<A.length -2;i++){
            P = i;
            Q = i+1;
            R = i+2;

            if ( ((long)A[P] + (long)A[Q])> (long)A[R])
                return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = new int[6];
        A[0] = 10;
        A[1] = 2;    A[2] = 5;
        A[3] = 1;     A[4] = 8;    A[5] = 20;
        int isTriangular = sol.solution(A);
        System.out.println(isTriangular);
    }
}
