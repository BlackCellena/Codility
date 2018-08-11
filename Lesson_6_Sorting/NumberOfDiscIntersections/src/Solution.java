import java.util.*;
public class Solution {
//Compute the number of intersections in a sequence of discs.

    public int solution(int[] A){
        int N = A.length;
        if (N == 1) return 0; //only 1 disc

//

        //store starting and ending points of each disc on the x axis
        long[] x1 = new long[A.length];
        long[] x2 = new long[A.length];

        for (int i=0;i<N;i++){
            x1[i] =(long) i-A[i]; // lowest (start) point on the x axis: i is the center, A[i] radius

            if (Integer.MAX_VALUE - A[i] < i)
                x2[i] = Long.MAX_VALUE;  //avoid overflow
            else
                x2[i] = (long)i + A[i]; // highest (end) point on the x axis: i is the center, A[i] radius

           // x2[i] = i+Math.abs(A[i]);
        }

        Arrays.sort(x1);
        Arrays.sort(x2);

        int startPointIndex = 0, endPointIndex = 0;
        int openDiscs = 0, intersections = 0;

        while(startPointIndex < N){

            // every time we open a disc, the disc intersects with all previously opened discs
            // and this new disc will be used for calculating future intersections
            if (x1[startPointIndex] <= x2[endPointIndex]) {
                intersections += openDiscs;

                if (intersections > 10000000)
                    return -1;

                openDiscs++;
                startPointIndex++;
            }
            // disc closes
            // this means that we have one less disc to intersect with
            else {
                openDiscs--;
                endPointIndex++;
            }

        }

        return intersections;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = new int[6];
        A[0] = 1;
        A[1] = 5;
        A[2] = 2;
        A[3] = 1;
        A[4] = 4;
        A[5] = 0;
        int numOfIntersections = sol.solution(A);
        System.out.println(numOfIntersections);
    }
}

