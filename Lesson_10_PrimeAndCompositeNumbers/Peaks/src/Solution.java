import java.util.ArrayList;
public class Solution {

    //peak:array element which is larger than its neighbors

    public int solution(int[] A) {
        int N = A.length;

        if (N < 3) return 0; //3 elements needed to have a peak
        //find all peaks
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                peaks.add(i); //keep Index
        }

        if (peaks.size() == 0)
            return 0;
        //brute force
        //check every group of size [1,...,size(peaks] if there is a peak
        //    and check if all the groups have at least one peak
        // from the "biggest possible number" to smaller number

        int blockSize,hasPeaks;
        for (int blocks = peaks.size(); blocks >0; blocks--) {
            if (N % blocks == 0) {  // it is divisible
                 blockSize = N / blocks;
                 hasPeaks = 0; //the number of blocks having peak(s)

                for (int peaksIndex : peaks) {
                    if (peaksIndex / blockSize == hasPeaks) { // peak in the ith block
                        hasPeaks++; // check next block
                    }
                }
                // if all the blocks have peak(s)
                // then, return the number of blocks

                if (hasPeaks == blocks) {
                    return blocks;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int[] A = {1, 2, 3, 4, 3, 4, 1,  2, 3, 4, 6, 2};
        int count = sol.solution(A);
        System.out.println(count);
    }
}
 