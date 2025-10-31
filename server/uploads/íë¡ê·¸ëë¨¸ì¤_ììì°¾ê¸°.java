class 프로그래머스_상자찾기 {
    public static int solution(int n, int w, int num) {
        // int n = 22 w = 6 num = 8
        int[][] box = new int[101][101];
        int current = 1;
        int floors = 0;
        while(current <= n){
            if(floors % 2 == 0){
                for(int i = 0; i < w && current <= n; i++)
                {
                    box[floors][i] = current++;
                }
            }else{
                for(int  j = 0; j < w && current <= n; j++){
                    box[floors][j] = current++;
                }
            }
            floors++;
        }

        int targetFloor = 0, targetCol = 0;
        for(int i = 0; i < floors; i++){
            for(int j = 0; j < w; j++)
            {
                if(box[i][j] == num){
                    targetFloor = i;
                    targetCol = j;
                }
            }
        }

        int count = 0;
        for(int i = targetFloor; i < floors; i++){
            if(box[i][targetCol] != 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("결과: " + solution(22, 6, 8)); // 3
        System.out.println("결과: " + solution(13, 3, 6)); // 4
    }
}
