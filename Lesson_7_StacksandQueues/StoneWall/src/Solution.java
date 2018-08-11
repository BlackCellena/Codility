import java.util.Stack;

public class Solution {
//Cover “Manhattan skyline” using the minimum number of rectangles.
    public int solution(int[] H) {

        if (H.length == 1) return 1;
        if (H.length == 0) return 0;
        int countBlocks = 0;
        Stack<Integer> stack = new Stack<>();

        int current, previous;
        for (int i = 0; i < H.length; i++) {
            current = H[i];


            //if previous block have higher height they cannot be extended and used
            while (!stack.isEmpty() && stack.peek() > current) {
                stack.pop();
            }


            // if previous block with lower height exist
            //it can be extended, but
            // we need another block for the "rest" of the height
            if (!stack.isEmpty() && stack.peek() < current) {
                //new block needed previous cannot be used anymore
                countBlocks++;
                stack.push(current);
            }

            //if there is no other (previous) block
            //get another block
            if (stack.isEmpty()) {
                stack.push(current);
                countBlocks++;
            }


        }
        return countBlocks;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        int numOfCubes = sol.solution(H);
        System.out.println(numOfCubes);
    }
}
