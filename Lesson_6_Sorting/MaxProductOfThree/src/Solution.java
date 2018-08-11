import  java.util.*;
public class Solution {


    public int solution(int[] A){
        int N = A.length;
        if (N == 3) return A[0]*A[1]*A[2];
        Arrays.sort(A); //this or merge sort algorithm
        //array sorted :
        //  if all positive last 3 elements give the highest product
        // if negative elements exist then by multiplying the two largest negatives with the largest positive
        //might give a bigger product
        int productPos = A[N-1] * A[N-2]*A[N-3];
        int productNeg = A[0]*A[1]*A[N-1];

        return Math.max(productPos,productNeg);




    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {-5, 5, -5, 4};

        int maxProduct = sol.solution(A);
        System.out.println(maxProduct);

    }
}
