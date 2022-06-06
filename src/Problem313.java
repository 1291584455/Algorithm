import java.util.PriorityQueue;

public class Problem313 {
    public static void main(String[] args) {
        int[] nums = {3,5,7,11,19,23,29,41,43,47};
        nthSuperUglyNumber(15, nums);
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int m = primes.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 0; i < m; i++){
            pq.add(new int[]{primes[i], i, 0});
        }
        for(int i = 1; i < n; ){
            int[] nums = pq.poll();
            int value = nums[0], k = nums[1], index = nums[2];
            if(value != ans[i - 1]){
                ans[i++] = value;
                value = ans[++index] * primes[k];
                pq.add(new int[]{value, k, index});
            }
        }
        return ans[n - 1];
    }
}
