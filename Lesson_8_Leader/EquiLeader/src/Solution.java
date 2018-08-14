import java.util.Arrays;
public class Solution {

    //Find the index S such that the leaders of the sequences4
    //A[0], A[1], …, A[S] and A[S + 1], A[S + 2], …, A[N – 1] are the same
    public int solution(int[] A){

        int N = A.length;
        int size = 0, value =0, candidate=-1, leader = -1,count =0, index =0;
        //find leader of the sequence
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
            return 0;
        if (size > 0)
            candidate = value;

        for (int k=0;k< N;k++) {
            if (A[k] == candidate) {
                count++;
                index = k;
            }
        }
        if (count > N/ 2)
            leader = A[index];
        else
            return 0; //only the leader of the whole sequence can be equi leader



        int countOccurrences =0, countEquiLeaders =0;
        //total occurrence of the leader
        for (int k=0;k<N; k++){
            if (A[k]==leader)
                countOccurrences++;
        }

        int countLeft =0, countRight =0;
        //check at every position if both sides have enough leader occurrences
        for (int k=0;k<N;k++){
            if (A[k] == leader)
                countLeft++;
            countRight = (countOccurrences - countLeft);
            if(countLeft>(k+1)/2 && countRight>(N-k-1)/2)
                countEquiLeaders++;

        }



        return countEquiLeaders;


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[]A = {4,3,4,4,4,2};

        int equiLeaders  = sol.solution(A);
        System.out.println(equiLeaders);
    }
}
