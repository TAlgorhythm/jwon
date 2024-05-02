package jwon.programmers;
import java.util.*;
public class P_240502_가장먼노드 {
  public int solution(int n, int[][] edge) {
    int answer = 0;
    int[] distances = new int[n+1];
    List<Integer>[] arr = new List[n + 1];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = new ArrayList<>();
    }
    for(int i = 0 ; i < arr.length; i++){
      int from = edge[i][0];
      int to = edge[i][1];
      arr[from].add(to);
      arr[to].add(from);
    }
    for(int i = 0 ; i < distances.length; i++){
      distances[i] = Integer.MAX_VALUE;
    }
    PriorityQueue<Edge> pque = new PriorityQueue<>();
    pque.offer(new Edge(1,0));
    // distances[0] = 0;
    distances[1] = 0;
    int max = 0;
    while(!pque.isEmpty()){
      // System.out.println(pque.toString());
      Edge now = pque.poll();
      if(distances[now.to] < now.distance){
        continue;
      }
      for(int next : arr[now.to]){
        if(now.distance + 1 < distances[next]){
          distances[next] = now.distance + 1;
          max = Math.max(max, distances[next]);
          pque.offer(new Edge(next, distances[next]));
        }
      }
    }

    // System.out.println(Arrays.toString(distances));
    for(int i = 0 ; i < distances.length ; i++){
      if(distances[i] == max){
        answer++;
      }
    }
    return answer;
  }

  class Edge implements Comparable<Edge>{
    int to;
    int distance;
    public Edge(int to, int distance){
      this.to = to;
      this.distance = distance;
    }
    @Override
    public int compareTo(Edge edge){
      return this.distance - edge.distance;
    }

    @Override
    public String toString(){
      return "to : " + to + " distance : " + distance;
    }
  }
}
