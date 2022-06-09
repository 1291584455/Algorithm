import java.util.Random;

public class LeetCode497 {
    Random random = new Random();
    int sum = 0 ;
    int[][] g;
    int n;
    int[] a;
    public LeetCode497(int[][] rects) {
        n = rects.length;
        a = new int[n];
        int i = 0;
        // 将二维转换成一维情况
        for(int[] r : rects){
            a[i] = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            sum += a[i];
            i++;
        }
        g = rects;
    }

    public int[] pick() {
        int cnt = sum;
        int index = -1;
        int t = -1;
        for(int i = 0 ; i < n; i++){
            int rand = random.nextInt(cnt);
            if(rand < a[i]){
                index = i;
                t = rand;
                break;
            }else{
                cnt -= a[i];
            }
        }
        int x1 = g[index][0], y1 = g[index][1];
        int x2 = g[index][2], y2 = g[index][3];
        return new int[]{x1 + t % (x2 - x1 + 1), y1 + t / (x2 - x1 + 1)};
    }
}
