import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11060_ { // 점프 점프
	static int arr[], visited[], n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(bf.readLine());
		
		arr=new int[n];
		visited=new int[n];
		st=new StringTokenizer(bf.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			visited[i]=-1;
		}
		
		visited[0]=0;
		bfs(0);
		
		System.out.println(visited[n-1]);
	}
	private static void bfs(int num) {
		Queue<Integer>queue=new LinkedList<>();
		queue.add(num);
		
		while(!queue.isEmpty()) {
			int idx=queue.poll();
			int temp=arr[idx];
			for(int i=1; i<=temp; i++) {
				if(idx+i<n && (visited[idx+i]==-1 || visited[idx+i]>visited[idx]+1)) {
					visited[idx+i]=visited[idx]+1;
					queue.add(idx+i);
				}
			}
		}
	}
}
