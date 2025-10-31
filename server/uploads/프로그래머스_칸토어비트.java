import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 프로그래머스_칸토어비트 {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1);
        // for(int i = 0; i < num.size(); i++){
        // System.out.println(num.get(i));
        // }
        int n = 2;
        long l = 4;
        long r = 17;
        int count = 0;
        List<Integer> sliced = new ArrayList<>();
        for (int i = (int)l - 1; i <= r - 1; i++) {
            if(num.get(i) == 1){
                count++;

            }
        }
        System.out.println(count);
    }
}
