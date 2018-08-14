import java.util.Arrays;
public class Solution {

    //Find  index such that its value occurs at more than half of indices in the array (dominator).
    public int solution(int[] A){
        if (A.length ==1) return 0;

        int N = A.length;
        int size = 0;
        int value =0, candidate=-1, leader = -1,count =0, index =0;
        for (int k=0;k< N;k++){

            if (size == 0) {
                size ++;
                value = A[k];
                index =k;
            }
            else {
                if (value != A[k])
                    size --;
                else
                    size ++;
            }
        }

        if (size == 0)
                return -1;
        if (size > 0)
            candidate = value;

        for (int k=0;k< N;k++) {
            if (A[k] == candidate) {
                count++;
                index = k;
            }
        }
        if (count > N/ 2)
            return index;

        return -1;


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[]A = {3,4,3,2,3,-1,3,3};

        int index  = sol.solution(A);
        System.out.println(index);
    }
}
