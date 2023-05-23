import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2665_ { // 미로만들기
	static boolean arr[][];
	static int result[][], n;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n=Integer.parseInt(bf.readLine());
		arr=new boolean[n][n];
		result=new int[n][n];
		
		for(int i=0; i<n; i++) {
			String s=bf.readLine();
			for(int j=0; j<n; j++) {
				if(s.charAt(j)=='0') arr[i][j]=false; // 검은 방
				else arr[i][j]=true; // 흰 방
				result[i][j]=-1;
			}
		}
		search(0,0);
		System.out.println(result[n-1][n-1]);
	}

	private static void search(int i, int j) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {i,j});
		result[i][j]=0;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int k=0; k<4; k++) {
				int x=temp[0]+dx[k];
				int y=temp[1]+dy[k];
				if(x>=0 && x<n && y>=0 && y<n) {
					if(arr[x][y]) { // 흰 방
						if(result[x][y]==-1 || result[x][y]>result[temp[0]][temp[1]]) {
							result[x][y]=result[temp[0]][temp[1]];
							queue.add(new int[] {x,y});
						}
					}else { // 검은 방
						if(result[x][y]==-1 || result[x][y]>result[temp[0]][temp[1]]+1) {
							result[x][y]=result[temp[0]][temp[1]]+1;
							queue.add(new int[] {x,y});
						}
					}
				}
			}
		}
	}
}
