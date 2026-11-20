import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> list = new ArrayList<>();
        int len = todo_list.length;
        for(int i=0; i<len; i++){
            if(!finished[i]){
                list.add(todo_list[i]);
            }
        }
        return list.toArray(new String[0]);
    }
}