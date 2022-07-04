package SummerProblem;

import java.util.*;

/**
 * 有三个杯子，容量分别为 A,B,C。
 *
 * 初始时，C 杯装满了水，而 A,B 杯都是空的。
 *
 * 现在在保证不会有漏水的情况下进行若干次如下操作：
 *
 * 将一个杯子 x 中的水倒到另一个杯子 y 中，当 x 空了或者 y 满了时就停止（满足其中一个条件才停下）。
 *
 * 请问，在操作全部结束后，C 中的水量有多少种可能性。
 *
 * 输入格式
 * 输入包含多组测试数据。
 *
 * 每组数据占一行，包含三个整数 A,B,C。
 *
 * 输出格式
 * 每组数据输出一个结果，占一行。
 *
 * 数据范围
 * 0≤A,B,C≤4000,
 * 每个输入最多包含 100 组数据。
 *
 * 输入样例：
 * 0 5 5
 * 2 2 4
 * 输出样例：
 * 2
 * 3
 */
public class Acw3511 {

    static int[] g = new int[3];
    static long A = 10000;
    static Set<Long> set = new HashSet<>();
    static Set<Integer> cs = new HashSet<>();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(scn.hasNext()){
            for(int i = 0; i < 3; i++){
                g[i] = scn.nextInt();
            }
            set.clear();
            cs.clear();
            int[] f = {0, 0, g[2]};
            dfs(f);
            System.out.println(cs.size());
        }
    }

    public static void dfs(int[] f){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i != j){
                    int[] temp = f.clone();
                    cs.add(f[2]);
                    pour(f, i, j);
                    if(!set.contains(change(f))){
                        set.add(change(f));
                        dfs(f);
                    }
                    f = temp;

                }
            }
        }
    }

    private static void pour(int[] temp, int i, int j) {
        int min = Math.min(temp[i], g[j] - temp[j]);
        temp[i] -= min;
        temp[j] += min;
     }

    private static Long change(int[] temp) {
        return temp[0] * A * A + temp[1] * A + temp[3];
    }
}
