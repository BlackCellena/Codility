/*A non-empty array A consisting of N integers is given.
The consecutive elements of array A represent consecutive cars on a road.
Array A contains only 0s and/or 1s:

        0 represents a car traveling east,
        1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N,
is passing when P is traveling to the east and Q is traveling to the west.

        For example, consider array A such that:

        A[0] = 0
        A[1] = 1
        A[2] = 0
        A[3] = 1
        A[4] = 1
        We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

        Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.

Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).*/
public class Solution {

    public int solution(int[] A){
        if (A.length == 1) return 0;

        int countEastCars= 0, passingCarCount = 0;

        for(int i = 0 ; i < A.length ; i++)
        {
            if(A[i] == 0)
                countEastCars++;

            else {
                if(countEastCars > 0 && passingCarCount <= 1000000000)
                    passingCarCount +=  countEastCars;
                else if(passingCarCount > 1000000000)
                    return -1;

            }

        }
        return passingCarCount;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A={0,1,0,1,1};

        int res = sol.solution(A);
        System.out.println(res);

    }
}
