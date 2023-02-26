import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18126_ { // 너구리 구구
	static int arr[][], N;
	static long visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		arr=new int[N][N];
		visited=new long[N];
		
		for(int i=0; i<N-1; i++) {
			st=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			arr[x-1][y-1]=value;
			arr[y-1][x-1]=value;
		}
		search(0);
		
		long result=0;
		for(int i=0; i<N; i++) {
			if(result<visited[i]) result=visited[i];
		}
		System.out.println(result);
	}

	private static void search(int i) {
		Queue<Integer>queue=new LinkedList<>();
		queue.add(i);
		
		while(!queue.isEmpty()) {
			int num=queue.poll();
			for(int k=0; k<N; k++) {
				if(arr[num][k]>0) {
					if(visited[k]==0 || visited[num]+arr[num][k]>visited[k]) {
						visited[k]=visited[num]+arr[num][k];
						queue.add(k);
						arr[num][k]=0;
						arr[k][num]=0;
					}
				}
			}
		}
	}
}
		
