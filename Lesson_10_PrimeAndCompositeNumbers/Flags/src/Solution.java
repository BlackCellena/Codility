import java.util.ArrayList;

public class Solution {

    //peak:array element which is larger than its neighbors

    public int solution2(int[] A) {

        //solution based on
//https://codility.com/media/train/solution-flags.pdf
        //correctness 100%
        //performance )%
        int N = A.length;

        if (N<3) return 0; //3 elements needed to have a peak
        //find all peaks
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                peaks.add(i); //keep Index
        }

        //no peaks or one
        if (peaks.size() ==0 || peaks.size()==1)
            return peaks.size();


        int[] next = new int[N];

        next[N - 1] = -1;

        for (int i = N - 2; i >-1; i--) {
            if (peaks.contains(i))
                next[i] = i;
            else
                next[i] = next[i + 1];
        }

        int i = 1, result = 0;

        while ((i-1)*i <= N) {
            int pos = 0;
            int num = 0;
            while (pos < N && num < i) {
                pos = next[pos];
                if (pos == -1)
                    break;
                num += 1;
                pos += i;
            }
            result = Math.max(result, num);
            i++;
        }
        return result;



    }

    public int solution(int[] A){
        //correctness 100%
        //performance 28%
        int N = A.length;

        if (N<3) return 0; //3 elements needed to have a peak
        //find all peaks
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                peaks.add(i); //keep Index
        }

        //no peaks or one
        if (peaks.size() ==0 || peaks.size()==1)
            return peaks.size();

        for (int flagNum = 1;; flagNum++) {
            int count = 0;
            int lastPeak = -1;
            for (int peak : peaks) {
                if (lastPeak < 0 || peak - lastPeak >= flagNum) {
                    lastPeak = peak;
                    count++;
                }
            }
            if (count < flagNum)
                return flagNum - 1;

        }
    }
    public static void main(String[] args) {
        Solution sol =new Solution();
        int[] A =  {1,5,3,4,3,4,1,2,3,4,6,2};
        int numOfFlags = sol.solution(A);
        System.out.println(numOfFlags);
    }
}
 