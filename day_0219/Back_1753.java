package day_0219;

import java.util.*;
import java.io.*;

public class Back_1753 {
    static int[] dist;
    static HashMap<Integer, List<int[]>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine().trim());

        map = new HashMap<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(new int[] {e,w});
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (d != dist[u]) continue;

            List<int[]> nexts = map.get(u);
            if (nexts == null) continue;

            for (int[] nxt : nexts) {
                int v = nxt[0];
                int w = nxt[1];

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
    }
}

