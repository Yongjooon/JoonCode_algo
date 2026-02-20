package day_0220;
import java.util.*;
import java.io.*;
public class Back_20167 {
    static int sum;
    static int N;
    static int K;
    static int []list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;

        move(0,0);
        System.out.println(sum);
    }
    public static void move(int now, int s){
        if(now == N){
            sum = Math.max(sum,s);
            return;
        }
        move(now+1,s);
        int temp = 0;
        while(temp<K && now<N){
            temp += list[now];
            now++;
        }
        if(temp>=K) s+=(temp-K);
        move(now,s);
    }
}
