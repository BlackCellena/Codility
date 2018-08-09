public class Solution {

    public int solution(int X, int[] A){

        if (A.length<X)
                return -1;

        boolean[] checkPath = new boolean[X];
        int counter = 0;
        for (int i=0;i<A.length;i++){
            //check only the part of the path we care
            if (A[i]<=X)
            {

            //if the boolean for location A[i] is false, set it to true and increment the counter.
            if (checkPath[A[i]-1]==false ){
                counter++;
                checkPath[A[i]-1] = true;
            }
            // for the counter to be x all positions have been filled with leaves
            if (counter == X)
                return i;
            }


        }
        //System.out.println("here");
        return -1;



    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        //
        int[] A = {5};
        //3,
        int X = 3;

        int res = sol.solution(X,A);
        System.out.println(res);

    }
}
