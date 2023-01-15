import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1240_ { // 노드사이의 거리
	static int n, arr[][], result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		arr=new int[n+1][n+1];
		for(int i=0; i<n-1; i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			arr[a][b]=d;
			arr[b][a]=d;
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			result=0;
			search(a,b);
			System.out.println(result);
		}
	}

	private static void search(int a, int b) {
		boolean[] visited=new boolean[n+1];
		visited[a]=true;
		
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {a,0});
		
		while(!queue.isEmpty()) {
			int start[]=queue.poll();
			for(int i=0; i<n+1; i++) {
				if(i!=start[0] && !visited[i] && arr[start[0]][i]>0) {
					visited[i]=true;
					if(i==b) {
						result=start[1]+arr[start[0]][i];
						break;
					}
					queue.add(new int[] {i, start[1]+arr[start[0]][i]});
				}
			}
			if(result>0) break;
		}
	}
}
