public class Iterations {

    public static int solution(int N){
        int gap=0, temp=0;
        String intToBin = Integer.toBinaryString(N);
        for(int k=0;k<intToBin.length();k++)
        {

            if (intToBin.charAt(k) == '0')
                temp++;
            else{
                if (gap<temp)
                    gap = temp;
                temp = 0;

            }
        }
        return gap;
    }

    public static void main(String[] args) {
       int gap =  solution(32);
       System.out.println("gap: "+ gap);
    }

}

