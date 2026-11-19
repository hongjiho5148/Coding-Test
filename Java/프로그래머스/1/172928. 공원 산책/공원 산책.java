class Solution {
    public int[] solution(String[] park, String[] routes) {
        int l1 = park.length;
        int l2 = park[0].length();
        char[][] map = new char[l1][l2];

        for (int i = 0; i < l1; i++) {
            map[i] = park[i].toCharArray();
        }

        // 1단계: S 위치 찾기
        int[] answer = new int[2];      // [행, 열]
        for (int j = 0; j < l1; j++) {
            for (int k = 0; k < l2; k++) {
                if (map[j][k] == 'S') {
                    answer[0] = j;
                    answer[1] = k;
                }
            }
        }

        // 2단계: 명령 하나씩 처리
        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int num = Integer.parseInt(parts[1]);

            // 방향별로 한 칸에 움직이는 양
            int dr = 0, dc = 0;
            if (dir == 'E') dc = 1;
            else if (dir == 'W') dc = -1;
            else if (dir == 'S') dr = 1;
            else if (dir == 'N') dr = -1;

            // 임시 위치로 한 칸씩 가 보기
            int r = answer[0];
            int c = answer[1];
            boolean canMove = true;

            for (int step = 0; step < num; step++) {
                r += dr;
                c += dc;
                // 맵 밖이거나 장애물이면 실패
                if (r < 0 || r >= l1 || c < 0 || c >= l2 || map[r][c] == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 끝까지 갔으면 진짜로 이동
            if (canMove) {
                answer[0] = r;
                answer[1] = c;
            }
        }

        return answer;
    }
}