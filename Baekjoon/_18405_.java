import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _18405_ { // 경쟁적 전염
	static int[] dx= {-1,1,0,0}; // 상하좌우
	static int[] dy= {0,0,-1,1};
	static PriorityQueue<int[]>queue;
	static int n, map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		queue=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		map=new int[n][n];
		boolean[][]depth=new boolean[n][n];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) { // 바이러스 번호와 위치 저장
					queue.add(new int[] {map[i][j],i,j});
					depth[i][j]=true;
				}
			}
		}
		
		st=new StringTokenizer(bf.readLine());
		int s=Integer.parseInt(st.nextToken()); // 초
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		
		if(s!=0) {
			search(); 
			for(int i=0; i<s-1; i++) {
				for(int j=0; j<n; j++) {
					for(int l=0; l<n; l++) {
						if(depth[j][l]==false && map[j][l]>0) {
							depth[j][l]=true;
							queue.add(new int[] {map[j][l], j, l});
						}
					}
				}
				search(); 
				if(map[x-1][y-1]>0) break;
			}
		}
		System.out.println(map[x-1][y-1]);
	}

	private static void search() {
		while(!queue.isEmpty()) {
			int[] temp=queue.poll();
			for(int i=0; i<4; i++) {
				int a=temp[1]+dx[i];
				int b=temp[2]+dy[i];
				if(a>=0 && a<n && b>=0 && b<n && map[a][b]==0) {
					map[a][b]=temp[0];
				}
			}
		}
	}
}
