import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13565_ { // 침투
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static Queue<int[]>queue;
	static boolean flag, visited[][];
	static int m,n, map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		map=new int[m][n];
		visited=new boolean[m][n];
		
		queue=new LinkedList<>();
		flag=false;
		
		for(int i=0; i<m; i++) {
			String line=bf.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]=line.charAt(j)-'0';
				if(i==0 && map[i][j]==0) {
					queue.add(new int[] {i,j});
					visited[i][j]=true;
				}
			}
		}
		search();
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void search() {
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<m && y>=0 && y<n) {
					if(map[x][y]==0 && !visited[x][y]) { // 전류 통함
						if(x==m-1) {
							flag=true;
							break;
						}
						visited[x][y]=true;
						queue.add(new int[] {x,y});
					}
				}
			}
			if(flag) break;
		}
	}
}
