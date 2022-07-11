package SummerProblem;
import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
/*
给定一个 1∼N 的随机排列，要求一次只能交换相邻两个数，那么最少需要交换多少次才可以使数列按照从小到大排列呢？

请你求出一个待排序序列的最少交换次数和对应的逆序数列。

逆序数列：给定 n 个数 1,2,…,n 的一个排列 a1a2…an，令 bi 是数 i 在此排列中的逆序数，换句话说，bi 等于该排列中先于 i 又大于 i 的那些数的个数。数列 b1b2…bn 称为排列 a1a2…an 的逆序数列(inversion sequence)。

输入格式
第一行一个整数 N。

第二行一个 1∼N 的排列。

输出格式
第一行输出逆序数列，数之间用空格隔开。

第二行输出最少交换次数。

数据范围
1≤N≤1000
输入样例：
8
4 8 2 7 5 6 1 3
输出样例：
6 2 5 0 2 2 1 0
18
 */
public class Acwing3715 {
    public static void main(String args[]) throws IOException{
        Read scn=new Read();
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 0; j < n && a[j] != i; j++){
                if(a[j] > i) cnt++;
            }
            scn.print(cnt + " ");
            ans += cnt;
        }
        scn.print("\n" + ans);
        scn.bw.flush();
        scn.bw.close();
    }
}
class Read{
    BufferedReader bf;
    StringTokenizer st;
    BufferedWriter bw;
    public Read(){
        bf=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer("");
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public String nextLine() throws IOException{
        return bf.readLine();
    }
    public String next() throws IOException{
        while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    public char nextChar() throws IOException{
        return next().charAt(0);
    }
    public int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    public long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    public double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    public float nextFloat() throws IOException{
        return Float.parseFloat(next());
    }
    public byte nextByte() throws IOException{
        return Byte.parseByte(next());
    }
    public short nextShort() throws IOException{
        return Short.parseShort(next());
    }
    public BigInteger nextBigInteger() throws IOException{
        return new BigInteger(next());
    }
    public void println(int a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void print(int a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
    public void println(String a) throws IOException{
        bw.write(a);
        bw.newLine();
        return;
    }
    public void print(String a) throws IOException{
        bw.write(a);
        return;
    }
    public void println(long a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void print(long a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
    public void println(double a) throws IOException{
        bw.write(String.valueOf(a));
        bw.newLine();
        return;
    }
    public void print(double a) throws IOException{
        bw.write(String.valueOf(a));
        return;
    }
}

