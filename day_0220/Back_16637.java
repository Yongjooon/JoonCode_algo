package day_0220;
import java.util.*;
import java.io.*;

public class Back_16637 {
    static int result;
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String [] list = new String[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list[i] = st.nextToken();
        }
        Queue<String> q = new ArrayDeque<>();
        if(N == 3){
            for(String l : list){
                q.add(l);
                //calcu();
            }
        }

        for(int i=0;i<N/4;i++){
            
        }
    }
}
