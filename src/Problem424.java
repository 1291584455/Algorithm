public class Problem424 {


//    Solution1:
//    public int characterReplacement(String s, int k) {
//        char[] ss = s.toCharArray();
//        int ans = 0;
//        for(int i = 0; i < 26; i++){
//            ans = Math.max(ans, getMax(ss, (char)( 'A' + i), k));
//        }
//        return ans;
//    }
//    public int getMax(char[] ss, char c, int k){
//        int ans = 0;
//        int L = 0 ,n = ss.length;
//        for(int i = 0; i < n; i++){
//            if(ss[i] != c){
//                k--;
//            }
//            while(k == -1){
//                ans = Math.max(ans, i - L);
//                if(ss[L++] != c){
//                    k++;
//                }
//            }
//        }
//        return Math.max(ans, n - L);
//    }


}
