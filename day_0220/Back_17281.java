package day_0220;

import java.util.*;
import java.io.*;
public class Back_17281{
    static int score;
    static int [][] result;
    static int[] line;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        result = new int[N][9];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        score = 0;
        line = new int[9];
        line[3] = 0;
        visited = new boolean[8];
        setLine(0);
        System.out.println(score);
    }
    public static void setLine(int now){
        if(now == 9) {
            calcu();
            return;
        }

        for(int i=1;i<9;i++){
            if(!visited[i-1]){
                visited[i-1] = true;
                line[now] = i;
                if(now+1 == 3)setLine(now+2);
                else setLine(now+1);
                visited[i-1] = false;
            }
        }
    }
    public static void calcu(){
        int out = 0;
        int s = 0;
        int i = -1;
        for(int k=0;k<N;k++){
            int [] ground = new int[4];
            out = 0;
            while(out<3){
                i = (i+1)%9;
                int now = line[i];
                if(result[k][now] == 0) out++;
                else if(result[k][now] == 1){
                    ground[3]+=ground[2];
                    ground[2] = ground[1];
                    ground[1] = ground[0];
                    ground[0] = 1;
                }
                else if(result[k][now] == 2){
                    ground[3] += (ground[2]+ground[1]);
                    ground[2] = ground[0];
                    ground[1] = 1;
                    ground[0] = 0;
                }
                else if(result[k][now] == 3){
                    ground[3] += (ground[0]+ground[1]+ground[2]);
                    ground[2] = 1;
                    ground[1] = 0;
                    ground[0] = 0;
                }
                else{
                    ground[3] += (ground[0]+ground[1]+ground[2]+1);
                    ground[2] = 0;
                    ground[1] = 0;
                    ground[0] = 0;
                }
            }
            s +=ground[3];
        }

        if(score < s) {
            score = s;
        }
    }
}