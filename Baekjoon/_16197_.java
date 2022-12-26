import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16197_ { // 두 동전
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static char[][] map;
	static Queue<int[]>queue;
	static int n,m;
	static int result=-1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map=new char[n][m];
		queue=new LinkedList<>();
		for(int i=0; i<n; i++) {
			String s=bf.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='o')queue.add(new int[] {i,j,0}); // 동전 위치 저장
			}
		}
		search();
		System.out.println(result);
	}

	private static void search() {
		while(!queue.isEmpty()) {
			int []coin1=queue.poll();
			int []coin2=queue.poll();
			
			if(coin1[2]+1>10) continue;
			for(int i=0; i<4; i++) {
				int count=0;
				int x1=coin1[0]+dx[i];
				int y1=coin1[1]+dy[i];
				
				int x2=coin2[0]+dx[i];
				int y2=coin2[1]+dy[i];
				
				if(x1>=0 && x1<n && y1>=0 && y1<m && map[x1][y1]=='#') { // 이동하려는 칸이 벽이면 이동 x
					x1=coin1[0];
					y1=coin1[1];
				}else if(x1<0 || x1>=n || y1<0 || y1>=m) { // 바깥
					count+=1;
				}
				
				if(x2>=0 && x2<n && y2>=0 && y2<m && map[x2][y2]=='#') {
					x2=coin2[0];
					y2=coin2[1];
				}else if(x2<0 || x2>=n || y2<0 || y2>=m) {
					count+=1;
				}
				
				if(count==0 && !(x1==coin1[0] && y1==coin1[1] && x2==coin2[0] && y2==coin2[1])) { 
					queue.add(new int[] {x1,y1,coin1[2]+1});
					queue.add(new int[] {x2,y2,coin1[2]+1});
				}else if(count==1) { // 하나만 떨어짐
					result=coin1[2]+1;
					break;
				}
			}
			if(result>0) break;
		}	
	}
}
