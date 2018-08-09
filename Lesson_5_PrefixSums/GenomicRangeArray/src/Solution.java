

public class Solution {
//time complexity O(n*m)
    public int[] solution2(String S, int[] P, int[] Q) {

        int[] minimalImpactFactor = new int[P.length];
        int tempMinFac = 0;

        for (int i = 0; i < P.length; i++) {
            for (int j = P[i]; j <= Q[i]; j++) {
                if (S.charAt(j) == 'A') {
                    if (tempMinFac > 1 || tempMinFac == 0)
                        tempMinFac = 1;
                } else if (S.charAt(j) == 'C') {
                    if (tempMinFac > 2 || tempMinFac == 0)
                        tempMinFac = 2;
                } else if (S.charAt(j) == 'G') {
                    if (tempMinFac > 3 || tempMinFac == 0)
                        tempMinFac = 3;
                } else {
                    if (tempMinFac == 0)
                        tempMinFac = 4;
                }
                minimalImpactFactor[i] = tempMinFac;


            }
            tempMinFac = 0;

        }
        return minimalImpactFactor;
    }


        //complexity  O(n+m)
    //keep a prefix sum of the number of occurences of each letter from the set [G,C,T,A]
        // for every position in the target string.
        // the minimal nucleotide between indices (a,b) is  the total number of occurences
        // of each of the nucleotides in O(1) time, and pick the smallest one.
        // This leads to a total running time of O(N+M).

        public int[] solution(String S, int[] P, int[] Q) {

            //used array to hold the prefix sums of each A, C and G genoms
            //we don't need to get prefix sums of T, you will see why.
            int[][] genoms = new int[3][S.length()+1];
            //
            int[] minimalImpactFactor = new int[P.length];
            //if the char is found in the index i, then we set it to be 1 else 0
            short a, c, g;
            for (int i=0; i<S.length(); i++)
            {
                a = 0; c = 0; g = 0;
                if (S.charAt(i)=='A')
                    a=1;
                if (S.charAt(i) ==  'C')
                    c=1;
                if (S.charAt(i) == 'G')
                    g=1;

                //here we calculate prefix sums.
                //each nucleotide specific vector in its own partial sum.
                // In this way we access first and last element in a given subsequence
                // if that nucleotide is there
                genoms[0][i+1] = genoms[0][i] + a;
                genoms[1][i+1] = genoms[1][i] + c;
                genoms[2][i+1] = genoms[2][i] + g;
            }



            for (int i=0; i<P.length; i++) {

                int fromIndex = P[i]+1;
                int toIndex = Q[i]+1;

                //if the substring contains nucleoid i , then genoms[i][toIndex] - genoms[i][fromIndex-1] > 0
                if (genoms[0][toIndex] - genoms[0][fromIndex-1] > 0)
                    minimalImpactFactor[i] = 1;
                else if (genoms[1][toIndex] - genoms[1][fromIndex-1] > 0)
                    minimalImpactFactor[i] = 2;
                else if (genoms[2][toIndex] - genoms[2][fromIndex-1] > 0)
                    minimalImpactFactor[i] = 3;
                else
                    minimalImpactFactor[i] = 4;

            }

            return minimalImpactFactor;
        }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String S = "CAGCCTA";
        int[] P = {2,5,0};
        int[] Q = {4,5,6};

        int[] impactFactors = sol.solution(S,P,Q);
        for (int i=0;i<impactFactors.length;i++)
            System.out.println(impactFactors[i] + " ");
    }
}
