public class Dijkstra {
    public static int INF = Integer.MAX_VALUE;

    public static class Graph{
        int[][] G;

        public Graph(int n){
            G = new int[n+1][n+1];     //n이 아니라 n+1인 이유 : 노드번호에 맞게 가중치를 넣기 위함
        }
        public void add(int a, int b, int w){
            G[a][b]=G[b][a]=w;         //예를 들어 1번과 3번 노드의 간선 가중치를 저장할 때, 1->3 값 뿐만 아니라 3->1 값도 저장하는 역할
        }
    }
    public static int[] Shortest(int[][] G, int s){  //최단 거리를 구하는 곳
        int[] D = new int[G.length];
        boolean[] T = new boolean[G.length];

        for(int i=1; i<G.length; i++){
            D[i]=INF;
        }
        D[s]=0;
        T[s]=true;    //배열 D 초기화, 출발점 s 방문한 노드 집합에 포함.

        for(int v=1; v<G.length; v++){
            if(!T[v] && G[s][v]!=0){
                D[v]=G[s][v];
            }
        }     //s와 인접한 노드들의 최단거리 갱신
        
        for(int i=0; i<G.length-2; i++){  //s로부터 최단거리가 확정되지 않은 점이 있으면 = 점이 n개 있다면 n-1번만 수행하면 됨
            int vmin = s;
            int min=INF;

            for(int v=1; v<G.length; v++) {
                if (!T[v] && D[v]!=INF){
                    if(D[v]<min){
                        min = D[v];
                        vmin=v;
                    }
                }
            }         //거리가 확정되지 않은 점들 중에서 D[v]가 최소인 vmin찾기
            T[vmin]=true;    //vmin을 방문한 노드 집합에 포함.

            for(int v=1; v<G.length; v++){
                if(!T[v] && G[vmin][v]!=0){
                    if(D[vmin]+G[vmin][v]<D[v]){
                        D[v] = D[vmin]+G[vmin][v];
                    }
                }
            }   //vmin과 인접한 점들 중에서 vmin을 거쳐갈때 최소인 점들 최단거리 값 갱신
        }

        return D;
    }
    public static void main(String[] arg){
        Graph g = new Graph(10);
        g.add(1, 2, 12);
        g.add(1, 3, 15);
        g.add(3, 4, 21);
        g.add(2, 5, 4);
        g.add(2, 6, 10);
        g.add(3, 8, 7);
        g.add(5, 6, 3);
        g.add(5, 7, 13);
        g.add(6, 8, 10);
        g.add(4, 10, 25);
        g.add(7, 9, 15);
        g.add(8, 9, 9);
        g.add(8, 10, 19);
        g.add(9, 10, 5);       //예시의 그래프의 노드와 간선의 길이를 넣어주는 코드
        int[] D = Shortest(g.G,1);
        for(int i=1; i<D.length; i++){
            System.out.printf("%d ", D[i]);
        }
    }
}
