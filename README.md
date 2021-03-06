# IgroupGreedy
# 컴퓨터 알고리즘 2번째 과제

## 1.그리디 알고리즘에 대하여

**Greedy Algorithm**(탐욕법, 탐욕 알고리즘)은 문제를 해결하는 과정에서 그 **순간순간마다 최적**이라고 생각되는 결정을 하는 방식으로 진행하여 최종 해답에 도달하는 문제 해결 방식이다.

[![image](https://besjournals.onlinelibrary.wiley.com/cms/asset/04f4c29c-c548-46d3-8e43-2d6d3ef38db9/jane12963-toc-0001-m.png)](https://besjournals.onlinelibrary.wiley.com/cms/asset/eec59c85-4c34-47b0-b1b4-345eadbc8606/jane12963-toc-0001-m.jpg)

위 그림을 보면 A graph를 Greedy 방법으로는 가장 숫자가 큰 요소를 찾는 데 있어서 해당 분기점마다 보다 큰 수를 찾는 방식으로 최종 해답을 찾아가고 있다. 하지만, optimal(최적) 방법에서 볼 수 있듯이 실제 전체 숫자 중에서  가장 큰 수는 100이다. 이처럼 Greedy 방법을 이용하는 것은 전체 문제해결에서의 최적의 해답을 찾지는 못한다.

순간순간마다 최적인 해결책이 전체 문제에서 최적의 해결책이 되지는 않는다. 하지만, 이러한 단점들을 극복하는 Greedy의 가장 큰 장점은 바로 **계산 속도**이다. 그래서 Greedy 방법이 통하는 몇몇의 문제에서는 최적의 해를 빠르게 찾아낼 수 있다.

그리디 알고리즘은

- 탐욕 선택 속성(greedy choice property)
  - 당장의 상황에서 목표를 위해 가장 도움이 되는 것이라고 할만한 것을 고를 수 있는가?
- 최적 부분 구조(optimal substructure)
  - 부분 문제를 만들 수 있으며 부분 문제의 최적화된 값이 전체 결과까지 최적화된 값을 주는가?

의 특성을 가지는 문제들을 해결하는 데 강점을 가진다. 즉, 한번의 선택이 다음 선택에는 전혀 무관한 값이여야 하며 매 순간의 최적해가 문제에 대한 최적해여야 한다.

사용되는 예시

- 거스름돈 문제
- 최소 신장 트리 (Minimum spanning tree)
- **다익스트라 알고리즘**
- 크러스컬 알고리즘


## 2. 다익스트라 알고리즘이란?

![Dijkstra_Animation](https://user-images.githubusercontent.com/80510945/113838074-685bcf00-97c9-11eb-9ada-8ef0dcc2d6dd.gif)

​	주어진 가중치 그래프에서 어느 한 출발점에서 또 다른 도착점까지의 최단 경로를 찾는 문제를 **최단 경로(Shortest Path) 문제**라고 한다. 최단 경로를 찾는 여러 알고리즘이 있는데 이 중 **다익스트라(Dijkstra) 알고리즘**이 가장 대표적인 알고리즘이라 할 수 있다.

​	다익스트라 알고리즘은 출발점이 주어지고 그 출발점으로부터 최단 거리가 확정되지 않은 점들 중에서 출발점으로부터 가장 가까운 점을 추가하고, 그 점의 최단 거리를 확정하는 알고리즘이다. 단, 이때 간선들의 가중치는 음수가 아니여야 한다. 간선의 가중치가 음수인 것이 존재하면, 다익스트라 알고리즘은 Greedy 알고리즘 기반이기 때문에 문제가 생긴다.

<center><img src="https://lh3.googleusercontent.com/proxy/Du75qi_6SUOuCexjKH5aSTWdpj93x08a3gy39aqWeDh3waf0QUHk7-tbSeYwHBNybYuCPAtZ7TTizKLtqQX3oRDt-frJH2w0okIFm-VeoFaJ5JxD-7v1hEX87xPWUUu9V81WLqNKCYK0CSzxZdXhAXqw6M1kDPZS2Zpnyvuv0Bj2O75LLhLH8sKCd9mKeLqOhvjEFjBm5PZ8Wtil2u3B7kqAgo3L5mZxArex6lGfWPeChs-b-h49pmUpp42eNSOv1_I941gsBW1hx0SAZC7ur1IMDWSZUng20jOSWFm3nFcPvyRTCsyy" width="300" height="300"></center>

​ 노드 A에서 D로 가는 최단 경로를 구한다고 가정할 때, 다익스트라 알고리즘은 근시안적 관점을 유지하기 때문에 가중치가 감소하는 것을 고려하지 못한다. 따라서 위와 같이 음수 가중치가 존재하면 실제 최단 경로인 A->B->C->D를 구할 수 없다. 즉, 음수 가중치가 존재하지 않는 가정 안에서만 greedy 알고리즘의 관점으로 최단 경로를 구할 수 있는 것이다.

## 3. 설계과정, 수도 코드

**다익스트라(Dijkstra) 알고리즘**을 간단히 설명해보면 아래와 같다.

- 입력 : 가중치 그래프 G, 출발점 s
- 출력 : 출발점 s로부터 (n-1)개의 점까지 각각 최단 거리를 저장한 배열 D

 1. 배열 D[v!=s]=infinite, D[s]=0 으로 초기화시킨다. 

 2. s와 인접한 노드들의 D[v] 값을 갱신한다. (s와 v 간선의 가중치 값으로)

 3. while(s로부터 최단거리가 확정되지 않은 점이 있으면) *: 점이 n개 있다면 n-1번만 수행하면 된다.* {

    현재 s로부터 최단거리가 확정되지 않은 점 v에 대해 최소의 D[v] 값을 가진 점 vmin을 선택하고, 출발점 s로부터 점 vmin까지의 최단거리 D[vmin]을 확정한다.  *(확정한다는 것은 'D[vmin]이 확정된 후에는 다시 변하지 않음'과 '점 vmin이 최단거리 확정 집합에 속함'을 의미한다.)*

 4. s로부터 최단거리가 확정되지 않은 점 중에 vmin을 경유함으로써 s로부터의 거리가 현재보다 더 짧아지는 점 v가 있으면 그 점의 D[v]를 갱신한다.
    }
   
 5. return 배열 D




## 4. 알고리즘의 성능 평가

__<알고리즘 성능 평가>__

+ 알고리즘 성능을 나타내는 척도 (Comlpexity)	
   + 시간복잡도: 특정한 크기의 입력에 대하여 알고리즘의 수행 시간 분석
   + 공간복잡도: 특정한 크기의 입력에 대하여 알고리즘의 메모리 사용량 분석
+ 복잡도가 낮을 수록 좋은 알고리즘
  + 시간 복잡도 낮다= 빠르게 실행
  + 공간 복잡도 낮다 = 적은 메모리 사용
+ 빅오 표기법
  + 가장 빠르게 증가하는 항만을 고려하는 표기법
  + 차수가 가장 큰 항만 남김

![빅오 표기법](https://user-images.githubusercontent.com/80510945/113696976-9ed41400-970d-11eb-8f31-b80ea392ef30.png)

다익스트라 고안한 알고리즘으로 처음 고안한 알고리즘은 O(V^2)의 시간복잡도를 가졌다. 이후 *우선순위 큐(=heap tree)* 이용한 더욱 개선된 알고리즘이 나오며, O((V+E)logV) (V는 정점의 개수, E는 한 정점의 주변 노드~~미방문 노드 중 출발점으로부터 현재까지 계산된 최단거리를 가지는 노드를 찾는데 O(VlogV)의 시간이 필요하고, 각 노드마다 이웃한 노드의 최단 거리를 갱신할 때 O(ElogV)의 시간이 필요하기 때문이다.~~)의 시간복잡도를 가지게 되었다. 

5번에서 작성할 코드는 수업시간에 배운 알고리즘을 토대로 빅오표기법으로 O(n^2)의 시간 복잡도를 가지는 코드를 작성할 것이다. while 문에서 n-1번 반복할 때, 배열에서 최소값을 찾는 시간 O(n), 점 n-1 개를 갱신하는 데 걸리는 시간O(n) 즉, 시간 복잡도는 (n-1){O(n)+O(n)}= **O(n^2)** 이다.


## 5. 자바 코드
```java
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
```

## 6. 코드 결과

<center><img src="https://user-images.githubusercontent.com/80517298/113838777-149db580-97ca-11eb-87ff-2f4d9493125d.jpg" width="400" height="300"></center>

 위 그림과 같은 그래프를 이용해 출발점을 서울(1)로 설정해 다익스트라 알고리즘을 돌려보았다.
 
 <center><img src="https://user-images.githubusercontent.com/80517298/113840392-97734000-97cb-11eb-81eb-16236fd1514e.jpg" width="600" height="130"></center>
 
 이와 같이 1~10번 노드까지 가는 최단거리 값이 올바르게 나오는 것을 확인할 수 있다.
