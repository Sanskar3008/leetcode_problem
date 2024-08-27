class Solution {

    class Edge{

        int s;int d;double val;

        public Edge(int s,int d,double val){

            this.s = s;

            this.d = d; 

            this.val = val;

        }
    }
    class Pair {

        int s;double dis;

        public Pair(int s,double d){

            this.s = s; this.dis = d;

        }
    }

    public double maxProbability(int n, int[][] edges, double[] val, int st, int en) {
        //create graph

        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){

            graph[i] = new ArrayList<>();

        }

        int idx = 0;

        for(int arr[]:edges){

            int s = arr[0];

            int d = arr[1];

            double dis = val[idx];

            graph[s].add(new Edge(s,d,dis));

            graph[d].add(new Edge(d,s,dis));

            idx++;

        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Double.compare(b.dis,a.dis));

        double dist[] = new double [n];

        dist[st] = 1.00;

        pq.add(new Pair(st,1.00));

        while(!pq.isEmpty()){

            Pair p = pq.remove();

            if(p.s == en) return p.dis;

            for(int i = 0 ; i < graph[p.s].size(); i++){

                Edge e = graph[p.s].get(i);

                 if(dist[e.d] < p.dis * e.val){

                    pq.add(new Pair(e.d,p.dis * e.val));

                    dist[e.d] = p.dis * e.val;

                }

            }
        }

        return 0.0;
    }
    
}