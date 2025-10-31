import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 프로그래머스_데이터분석 {

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // ext와 sort_by에 해당하는 인덱스 매핑
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int extIndex = map.get(ext);
        int sortIndex = map.get(sort_by);

        // 1. 필터링: data[i][extIndex] <= val_ext
        List<int[]> filtered = new ArrayList<>();
        for (int[] row : data) {
            System.out.println("int[] row running " + Arrays.toString(row));
            if (row[extIndex] <= val_ext) {
                System.out.println("row[extIndex]'s running " + row[extIndex]);
                filtered.add(row);
            }
        }

        // 2. 정렬: sort_by 기준 오름차순
        filtered.sort(Comparator.comparingInt(o -> o[sortIndex]));

        // 3. 결과 반환 (List → int[][])
        int[][] result = new int[filtered.size()][4];
        for (int i = 0; i < filtered.size(); i++) {
            result[i] = filtered.get(i);
        }

        return result;
    }
    public static void main(String[] args){
        int[][] data = new int[][]{
            {1,20300104,100,80},
            {2,20300804, 847, 37},
            {3, 20300401, 10, 8},
        };
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        
        int[][] result = solution(data,ext,val_ext,sort_by);
        System.out.println(Arrays.deepToString(result));

    }
}
