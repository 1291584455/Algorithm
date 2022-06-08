public class LeetCode363 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9;
        while(l < r){
            int mid = l + r >> 1;
            if(check(piles, mid, h)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] piles, int s , int h){
        long ans = 0;
        for(int n : piles){
            ans +=  (n + s - 1) / s;
        }
        return ans <= h;
    }
}
