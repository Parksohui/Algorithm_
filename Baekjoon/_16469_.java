import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16469_ { // 소년 점프
	static int arr[][], visited[][][], r, c;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		arr=new int[r][c];
		visited=new int[r][c][3];
		
		for(int i=0; i<r; i++) {
			String s=bf.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j]=s.charAt(j)-'0';
				for(int k=0; k<3; k++) {
					visited[i][j][k]=-1;
				}
			}
		}
		
		for(int i=0; i<3; i++) {
			st=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			bfs(x-1 ,y-1, i);
		}
		
		int result=0, min_val=Integer.MAX_VALUE;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(visited[i][j][0] !=-1 && visited[i][j][1] !=-1 && visited[i][j][2] !=-1) {
					int temp=visited[i][j][0];
					if(temp<visited[i][j][1]) temp=visited[i][j][1];
					if(temp<visited[i][j][2]) temp=visited[i][j][2];
					
					if(min_val>temp) {
						min_val=temp;
						result=1;
					}else if(min_val==temp) {
						result+=1;
					}
				}
			}
		}
		if(result==0) {
			System.out.println(-1);
		}else {
			System.out.println(min_val);
			System.out.println(result);
		}
		
	}

	private static void bfs(int x, int y, int num) {
		Queue<int[]> queue=new LinkedList<>();
		visited[x][y][num]=0;
		queue.add(new int[] {x,y,0});
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x1=temp[0]+dx[i];
				int y1=temp[1]+dy[i];
				if(x1>=0 && x1<r && y1>=0 && y1<c && arr[x1][y1]==0) {
					if(visited[x1][y1][num]==-1) {
						visited[x1][y1][num]=temp[2]+1;
						queue.add(new int[] {x1,y1, temp[2]+1});
					}
				}
			}
		}
	}
}
