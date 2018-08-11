import java.util.Stack;

public class Solution {

    public int solution(int[] A, int[] B) {
        if (A.length == 1) return 1; //only one fish exists so it stays alive
        Stack<Fish> stack = new Stack<>();

        boolean currentFishAlive;

        for(int i = 0; i < A.length; i++) {
            Fish currentFish = new Fish(A[i],B[i]);

            if (stack.isEmpty()) //no fish
                stack.push(currentFish);
            else if (currentFish.direction ==0){
                //check first alive fish on stack if the go on different directions
                Fish previousFish = stack.peek();
                currentFishAlive = true;
                //if the current fish meets previous fishes with different direction
                while (!stack.isEmpty() && currentFishAlive && (previousFish.direction ==1)) {

                    if (previousFish.size < currentFish.size) //previous fish smaller -- gets eaten
                        stack.pop();
                    else  //current fish gets eaten
                        currentFishAlive = false;
                    if (!stack.isEmpty())
                        previousFish = stack.peek();
                    else break;

                }
                if (currentFishAlive)
                        stack.push(currentFish);

            }
            else if (currentFish.direction ==1)
                stack.push(currentFish);


        }
        return stack.size();
    }
    private static class Fish {
        public int direction;
        public int size;
        public Fish(int size, int direction) {
            this.size = size;
            this.direction = direction;
        }
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        int fishAlive = sol.solution(A, B);
        System.out.println(fishAlive);
    }
}
