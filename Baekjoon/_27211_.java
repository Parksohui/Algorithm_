import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _27211_ { // 도넛 행성
	static int arr[][], result, n, m;
	static boolean visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n][m];
		visited=new boolean[n][m];
		result=0;
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) visited[i][j]=true;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					visited[i][j]=true;
					result+=1;
					search(i,j);
				}
			}
		}
		System.out.println(result);
	}

	private static void search(int i, int j) {
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int k=0; k<4; k++) {
				int x=temp[0]+dx[k];
				int y=temp[1]+dy[k];
				if(x==-1) x= n-1;
				if(y==-1) y= m-1;
				if(x==n) x=0;
				if(y==m) y=0;
				if(x>=0 && x<n && y>=0 && y<m && !visited[x][y]) {
					visited[x][y]=true;
					queue.add(new int[] {x,y});
				}
			}
		}
	}
}
