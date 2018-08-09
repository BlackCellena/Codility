public class Solution {

    //(There must be some slices, with length of two or three,
    // having the minimal average value among all the slices.
    //larger slices with minimal average are built up
    // with these 2-element/ 3-element small slices.
    public int solution( int[] A ) {
        int N = A.length;
        int[] prefixSums = new int[N + 1];
        if (N==2) return 0;

        //compute prefix sums
        for (int i = 0; i < N; i++)
            prefixSums[i + 1] = prefixSums[i] + A[i];

        float minAvg = Float.MAX_VALUE, average;
        int index = 0, P, Q;

        for (int i = 0; i < N - 1; i++)
        {
            //check 2 element slice
             P = i;
             Q = i + 1;
             average = (prefixSums[Q + 1] - prefixSums[P]) / 2.0f;

            if (average < minAvg) {
                minAvg = average;
                index = i;
            }

            //check 3 element slices
            if (i < N - 2)
            {
                Q = i + 2;
                average = (prefixSums[Q + 1] - prefixSums[P]) / 3.0f;

                if (average < minAvg)
                {
                    minAvg = average;
                    index = i;
                }
            }
        }

        return index;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {4,2,2,5,1,5,8};

        int index = sol.solution(A);

            System.out.println(index+ " ");
    }
}
