import java.net.SocketOption;

public class Solution {

    public int[] solution(int[] A, int K){ //k : index showing how many times to rotate right

        int[] temp = A;
        for (int i=0;i<K;i++)
            temp = shiftRight(temp);

        return temp;

    }
    public static int[] shiftRight(int[] arr){
        int[] tArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(i > 0)
                tArray[i] = arr[i -1];
            else
                tArray[i] = arr[arr.length-1];
        }
        return tArray;
    }




    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {1, 2, 3, 4};
        int K = 4;
        int[] s ;
        s = sol.solution(A,  K);
        for (int i=0;i<A.length;i++)
            System.out.print(s[i]+" ");
    }
}
