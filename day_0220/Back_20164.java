package day_0220;
import java.util.*;
import java.io.*;

public class Back_20164 {
    static int max;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String start = st.nextToken();
        char[] list = start.toCharArray();
        max = 0;
        min = Integer.MAX_VALUE;
        
        change(Integer.parseInt(start),check(list));
        System.out.println(min + " " + max);
    }
    public static void change(int now, int count){
       // System.out.println(now);
        if(now <10){
            max = Math.max(max,count);
            min = Math.min(min, count);
            return;
        }
        if(now <100){
            int temp = now/10 + now %10;
            char [] ll = Integer.toString(temp).toCharArray();
            change(temp, count+check(ll));
        }
        else{
            char[] l = Integer.toString(now).toCharArray();
            for(int i=1;i<=l.length-2;i++){
                for(int j=1;j<=l.length-i-1;j++){
                    int p = 0;
                    int a = 0;
                    int b = 0;
                    int c = 0;
                    for(int k=i-1;k>=0;k--){
                        a +=(l[p]-'0') * Math.pow(10, k);
                        p++;
                    }
                    for(int k=j-1;k>=0;k--){
                        b +=(l[p]-'0') * Math.pow(10, k);
                        p++;
                    }
                    for(int k=(l.length-i-j)-1;k>=0;k--){
                        c +=(l[p]-'0') * Math.pow(10, k);
                        p++;
                    }
                    //System.out.println(a+" "+b+" "+c);
                    int temp = a+b+c;
                    //System.out.println(temp);
                    char [] ll = Integer.toString(temp).toCharArray();
                    change(temp, count+check(ll));
                }
            }
        }
    }
    public static int check(char[] list){
        int cnt = 0;
        for(char l : list){
            if((l-'0') % 2 == 1){
                cnt++;
            }
        }
        return cnt;
    }
}
