import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _21938_ { // 영상처리
	static int arr[][], n, m, num;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException { 
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new int[n][m*3];
		visited=new boolean[n][m*3];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<m*3; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		num=Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m*3; j+=3) {
				int sum=(arr[i][j]+arr[i][j+1]+arr[i][j+2])/3;
				if(sum>=num) {
					arr[i][j]=255;
					arr[i][j+1]=255;
					arr[i][j+2]=255;
				}else {
					arr[i][j]=0;
					arr[i][j+1]=0;
					arr[i][j+2]=0;
				}
			}
		}
		
		int result=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m*3; j++) {
				if(arr[i][j]==255 && !visited[i][j]) {
					result+=1;
					bfs(i,j);
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j]=true;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int k=0; k<4; k++) {
				int x=temp[0]+dx[k];
				int y=temp[1]+dy[k];
				if(x>=0 && x<n && y>=0 && y<m*3 && arr[x][y]==255 && !visited[x][y] ) {
					visited[x][y]=true;
					queue.add(new int[] {x,y});
				}
			}
		}
	}
}
