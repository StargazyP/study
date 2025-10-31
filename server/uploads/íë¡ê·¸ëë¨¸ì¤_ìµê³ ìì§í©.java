import java.util.ArrayList;
import java.util.List;

public class 프로그래머스_최고의집합 {
    public List<Integer> solution(int n, int s) {
        List<Integer> num = new ArrayList<Integer>();
        if(n > s){
            num.add(-1);
            return num;
        }
        int base = s / n;
        int remainder = s % n;
        for(int i = 0; i < n; i++){
            if(i < n - remainder){
                num.add(base);
            }else{
                num.add(base + 1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        프로그래머스_최고의집합 n = new 프로그래머스_최고의집합();
        System.out.println(n.solution(2, 9));

    }
}