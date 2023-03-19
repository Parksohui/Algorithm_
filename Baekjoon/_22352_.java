import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _22352_ { // 항체 인식
	static int arr[][], diff[][], n , m;
	static boolean visited[][], flag;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken()); // 세로
		m=Integer.parseInt(st.nextToken()); // 가로
		
		arr=new int[n][m];
		diff=new int[n][m];
		visited=new boolean[n][m];
		flag= false;
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int start_x=-1, start_y=-1;
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<m; j++) {
				int num=Integer.parseInt(st.nextToken());
				if( arr[i][j] != num) {
					diff[i][j]=num;
					if(start_x==-1 && start_y==-1) {
						start_x=i;
						start_y=j;
					}
				}
			}
		}
		if(start_x!= -1 && start_y != -1) search(start_x, start_y);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(diff[i][j]>0) {
					flag=true;
					break;
				}
			}
		}
		
		if(flag) System.out.println("NO");
		else System.out.println("YES");
	}
	private static void search(int start_x, int start_y) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {start_x, start_y});
		visited[start_x][start_y]=true;
		int num=diff[start_x][start_y];
		diff[start_x][start_y]=0;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && arr[temp[0]][temp[1]]==arr[x][y]) {
					if(diff[x][y]==num || (diff[x][y]==0 && arr[x][y]==num)) {
						visited[x][y]=true;
						diff[x][y]=0;
						queue.add(new int[] {x,y});
					}else {
						flag=true;
						break;
					}
				}
			}
			if(flag) break;
		}
	}
}
