class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int n = str1.length();
        for(int i = 0 ; i < n; i++){
            char s1 = str1.charAt(i);
            char s2 = str2.charAt(i);
            answer+=s1;
            answer+=s2;
        }
        return answer;
    }
}