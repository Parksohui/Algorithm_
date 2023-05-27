import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _14217_ { // 그래프 탐색
	static ArrayList<ArrayList<Integer>> arr;
	static boolean visited[];
	static int result[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		// init
		arr=new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) { // 양방향
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		int q=Integer.parseInt(bf.readLine());
		for(int k=0; k<q; k++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int i=Integer.parseInt(st.nextToken())-1;
			int j=Integer.parseInt(st.nextToken())-1;
			
			if(a==1) { // 도로 생성
				arr.get(i).add(j);
				arr.get(j).add(i);
			}else { // 도로 제거
				arr.get(i).remove(Integer.valueOf(j));
				arr.get(j).remove(Integer.valueOf(i));
			}
			
			visited=new boolean[n];
			result=new int[n];
			bfs(0,0);
			for(int l=0; l<n; l++) {
				if(!visited[l]) bw.write("-1 ");
				else bw.write(result[l]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void bfs(int start, int depth) {
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {start, depth});
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int num[]=queue.poll();
			for(int i=0; i<arr.get(num[0]).size(); i++) {
				int temp=arr.get(num[0]).get(i);
				if(!visited[temp]) {
					visited[temp]=true;
					result[temp]=num[1]+1;
					queue.add(new int[] {temp, num[1]+1});
				}
			}
		}
	}
}
