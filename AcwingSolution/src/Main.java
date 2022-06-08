import java.util.*;
public class Main{

    static int n, m;
    static int M = 10010;
    static int N = 2*M;
    static int[] h = new int[M];
    static int[] e = new int[N], ne = new int[N];
    static boolean[] st = new boolean[N];
    static int[] co = new int[N];
    static int idx;


    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }


    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();
        while(m-- > 0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            add(a, b);
            add(b, a);
        }
        if(deye()) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean deye(){
        LinkedList<Integer> list = new LinkedList<>();
        boolean f = true;
        st[1] = true;
        co[1] = 1;
        list.add(1);
        while(!list.isEmpty()){
            int size = list.size();
            for(int i = 0 ; i < size; i++){
                int p = list.poll();
                for(int j = h[p]; j >= 0; j = ne[j]){
                    int t = e[j];
                    if(!st[t]){
                        co[t] = f ? 2 : 1;
                        st[t] = true;
                        list.add(t);
                    }else{
                        if(f && co[t] == 1) return false;
                        if(!f && co[t] == 2) return false;
                    }
                }
            }
            f = !f;
        }
        return true;
    }

}