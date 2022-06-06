import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int L = 0, n = ss.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(map.containsKey(ss[i])){
                int index = map.get(ss[i]);
                ans = Math.max(ans, i - L);
                for(int j = L; j <= index; j++){
                    map.remove(ss[j]);
                }
                L = index + 1;
            }
            map.put(ss[i], i);
        }
        ans = Math.max(ans, n - L);
        return ans;
    }

}


