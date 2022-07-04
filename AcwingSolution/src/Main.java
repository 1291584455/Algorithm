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

import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
public class Main{
    public static void main(String args[]) throws IOException{
        Read scn=new Read();



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