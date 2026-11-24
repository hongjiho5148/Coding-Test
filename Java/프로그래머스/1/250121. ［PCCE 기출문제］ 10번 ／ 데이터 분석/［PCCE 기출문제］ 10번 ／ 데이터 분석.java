import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. 이름 → 인덱스 찾기
        String[] cols = {"code", "date", "maximum", "remain"};
        int extIdx = 0, sortIdx = 0;
        for (int i = 0; i < cols.length; i++) {
            if (cols[i].equals(ext)) extIdx = i;
            if (cols[i].equals(sort_by)) sortIdx = i;
        }

        // 2. 조건에 맞는 줄만 뽑기
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] row : data) {
            if (row[extIdx] < val_ext) {
                list.add(row);
            }
        }

        // 3. sort_by 기준 오름차순 정렬
        final int s = sortIdx;
        list.sort((a, b) -> a[s] - b[s]);

        return list.toArray(new int[0][]);
    }
}