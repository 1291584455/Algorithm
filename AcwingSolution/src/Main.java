import java.util.*;
public class Main{
    static int N = 100010;
    static int n,m,idx;
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int[] d = new int[N];
    static boolean[] st = new boolean[N];
    static int INF = (int)1e9;
    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int spfa(){
        d[1] = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        while(!list.isEmpty()){
            int p = list.poll();
            st[p] = false;
            for(int i = h[p]; i >= 0; i = ne[i]){
                int to = e[i];
                if(d[p] + w[i] < d[to]){
                    d[to] = d[p] + w[i];
                    if(!st[to]){
                        list.add(to);
                        st[to] = true;
                    }
                }

            }
        }
        return d[n];

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        Arrays.fill(d, INF);
        Arrays.fill(w, INF);
        n = scn.nextInt();
        m = scn.nextInt();
        while(m-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            add(a, b, c);
        }
        int ans = spfa();
        if(ans >= INF) System.out.println("impossible");
        else System.out.println(ans);

    }

}