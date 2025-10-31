import java.util.Arrays;
public class 프로그래머스_돗자리 {
    public int solution(int[] mats, String[][] park){
        Arrays.sort(mats);
        for(int i = mats.length - 1; i >= 0; i--){
            int size =  mats[i];
            if(canPlace(size, park)){
                return size;
            }
        }
        return -1;
    
    }
    private boolean canPlace(int size, String[][] park){
        int row = park.length;
        int cols = park[0].length;
        for(int i = 0 ; i < row - size; i++){
            for(int j = 0 ; j  < cols - size; j++){
                if(isEmptySquare(i,j,size,park)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isEmptySquare(int r , int c , int size , String[][] park){
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j ++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        프로그래머스_돗자리 test = new 프로그래머스_돗자리();

        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        System.out.println(test.solution(mats, park));  // 👉 출력: 3
    }
}
// }
// ["A", "A", "-1", "B", "B", "B", "B", "-1"],
// ["A", "A", "-1", "B", "B", "B", "B", "-1"], 
// ["-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"],
// ["D", "D", "-1", "-1", "-1", "-1", "E", "-1"], 
// ["D", "D", "-1", "-1", "-1", "-1", "-1", "F"],
// ["D", "D", "-1", "-1", "-1", "-1", "E", "-1"]