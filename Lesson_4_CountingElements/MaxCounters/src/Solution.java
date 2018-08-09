import java.util.*;
public class Solution {

    public int[] solution(int N, int[] A){

/*The idea is to perform the specified operation as stated.
It is not required to iterate over the whole array if a new value is set for all the values.
 Just save the value and check it when an increase on that position is performed.
*/

            int counter[] = new int[N];

            //maintain the max value
            int max=-1;
      //  maintain the current_min (very important!!!)
        // so, we can move "the 2nd for-loop" outside "the 1st for-loop"
        // by maintaining "min"
            int current_min=0;

            for(int i=0;i<A.length;i++){

                if(A[i]>=1 && A[i]<= N){
                // important: check the "min" before "increasing by 1"
                    if(counter[A[i] - 1] < current_min)
                        counter[A[i] - 1] = current_min; //// update it to "min"

                    counter[A[i] - 1] = counter[A[i] - 1] + 1; // increment by one

                    if(counter[A[i] - 1] > max) //// maintain max
                        max = counter[A[i] - 1];
                }
                else if(A[i] == N+1)
                    current_min = max;  //maintain "min", so we can move the for-loop outside *
                // all the values should be bigger than "max"
                // therefore, "min = max"

            }
        // move the 2nd for-loop outside the 1st for-loop
        // update some elements who have not been updated yet
            for(int i=0;i<N;i++){

                if(counter[i] < current_min)
                    counter[i] =  current_min;
            }
            return counter;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {3,4,4,6,1,4,4};
        int N = 5;
        int[] res = sol.solution(N,A);
        for (int i=0;i<res.length;i++)
            System.out.print(res[i] + " ");


    }
}
