import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22252_ { // 정보 상인 호석

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int q = Integer.parseInt(bf.readLine());

		HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
		
		long result=0;

		for (int i = 0; i < q; i++) {
			st=new StringTokenizer(bf.readLine());
			
			int cmd=Integer.parseInt(st.nextToken());
			String name=st.nextToken();
			int num=Integer.parseInt(st.nextToken());
			
			if(cmd==1) {
				if(!map.containsKey(name)) {
					PriorityQueue<Integer>queue=new PriorityQueue<>(Collections.reverseOrder());
					for(int j=0; j<num; j++) {
						queue.add(Integer.parseInt(st.nextToken()));
					}
					map.put(name, queue);
					
				}else {
					for(int j=0; j<num; j++) {
						map.get(name).add(Integer.parseInt(st.nextToken()));
					}
				}
			}else {
				if(map.containsKey(name)) {
					PriorityQueue<Integer>temp=map.get(name);
					int l= num>temp.size() ? temp.size() : num;
					for(int j=0; j<l; j++) {
						result+=temp.poll();
					}
				}
			}
		}
		System.out.println(result);
	}

}
