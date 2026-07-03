import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        TreeSet<Integer> costs = new TreeSet<>();
        for (int[] edge : edges) {
            int u = edge[0];
               int v = edge[1];
              int w = edge[2];
    
             graph[u].add(new int[]{v, w});
              indegree[v]++;
            costs.add(w);
        }    
     
           if (costs.isEmpty()) {
            return -1;
        }

          int[] topo = new int[n];
           Queue<Integer> queue = new LinkedList<>();
    
           for (int i = 0; i < n; i++) {
              if (indegree[i] == 0) {
                      queue.offer(i);
                }
        }

        int idx = 0;
          while (!queue.isEmpty()) {
            
            
                int node = queue.poll();
              topo[idx++] = node;
  
               for (int[] next : graph[node]) {
                  indegree[next[0]]--;
             
             
               
                
                         if (indegree[next[0]] == 0) {
                    queue.offer(next[0]);
                  }
            }
        }

           int[] values = new int[costs.size()];
          idx = 0;
             for (int x : costs) {
            values[idx++] = x;
         }

           int left = 0;
           
            
             int right = values.length - 1;
        int answer = -1;

          while (left <= right) {

            int mid = left + (right - left) / 2;

               if (canReach(values[mid], graph, topo, online, k, n)) {
                  answer = values[mid];
                     left = mid + 1;
            } else {
             
                    right = mid - 1;
            }
        }

          return answer;
    }

             private boolean canReach(int limit,
                                List<int[]>[] graph,
                              int[] topo,
         
          
           
                                  boolean[] online,
                             long k,
                               int n) {
 
        long INF = Long.MAX_VALUE / 4;

           long[] dist = new long[n];
            Arrays.fill(dist, INF);
           
             dist[0] = 0;

        for (int u : topo) {

          
               if (dist[u] == INF) {
                continue;
                 }

          
                 if (u != 0 && u != n - 1 && !online[u]) {
                continue;
     }

            for (int[] edge : graph[u]) {

                int v = edge[0];
         
                  int w = edge[1];
      
                  if (w < limit) {
                     continue;
            }

                   if (v != n - 1 && !online[v]) {
                    continue;
      }
  
                     if (dist[u] + w < dist[v]) {
                                          dist[v] = dist[u] + w;
         }
  }
 }
        return dist[n - 1] <= k;
    }}