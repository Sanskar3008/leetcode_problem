class Solution {

    private void updateEdge(ArrayList<int[]> g[], int u, int v){
        for(int edge[] : g[u]){
            if(edge[1] == v){
                edge[2] = 1;
                break;
            }
        }

        for(int edge[] : g[v]){
            if(edge[1] == u){
                edge[2] = 1;
                break;
            }
        }
    }


    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        ArrayList<int[]> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int edge[] : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u].add(new int[]{u, v, wt});
            graph[v].add(new int[]{v, u, wt});
        }
        int shortestDist = dijkstrasAlgorithm(graph, source, destination, target);

        if(shortestDist < target) return new int[0][0];
        if(shortestDist == target){
            for(int edge[] : edges){
                if(edge[2] == -1){
                    edge[2] = 2000000000;
                }
            }
            return edges;
        }
        boolean ok = false;
        for(int i=0; i<edges.length; i++){
            int edge[] = edges[i];

            if(edge[2] == -1 && ok){
                edge[2] = 2000000000;
                continue;
            }
            if(edge[2] == -1){
                
                edge[2] = 1;
                int u = edge[0], v = edge[1];
                updateEdge(graph, u, v);
                shortestDist = dijkstrasAlgorithm(graph, source, destination, target);

                if(shortestDist <= target){
                    int need = target - shortestDist;
                    edge[2] += need;
                    ok = true;
                }
            }
        }
        if(!ok) return new int[0][0];
        return edges;
    }
    private int dijkstrasAlgorithm(ArrayList<int[]> g[], int s, int d, int t){
        int dist[] = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean vis[] = new boolean[g.length];
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{s, 0});
        while(!pq.isEmpty()){
            int p[] = pq.poll();
            if(!vis[p[0]]){
                vis[p[0]] = true;
                for(int e[] : g[p[0]]){
                    if(e[2] == -1){
                        continue;
                    }else{
                        if(p[1] + e[2] < dist[e[1]]){
                            dist[e[1]] = p[1] + e[2];
                            pq.add(new int[]{e[1], dist[e[1]]});
                        }
                    }
                }
            }
        }
        return dist[d];
    }
}