import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _7662_ { // 이중 우선순위 큐 
	static ArrayList<String> arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t=Integer.parseInt(bf.readLine());
		
		for(int i=0; i<t; i++) {
			TreeMap<Integer, Integer> map=new TreeMap<>();
			int k=Integer.parseInt(bf.readLine());
			for(int j=0; j<k; j++) {
				st=new StringTokenizer(bf.readLine());
				char cmd=st.nextToken().charAt(0);
				int num=Integer.parseInt(st.nextToken());
				
				if(cmd=='I') {
					if(map.containsKey(num)) {
						map.put(num, map.get(num)+1);
					}else {
						map.put(num, 1);
					}
					
				}else if(cmd=='D' && map.size()>0) {
					if(num==1) {
						if(map.lastEntry().getValue()==1) {
							map.remove(map.lastKey());
						}else {
							map.put(map.lastKey(), map.lastEntry().getValue()-1);
						}
					}else {
						if(map.firstEntry().getValue()==1) {
							map.remove(map.firstKey());
						}else {
							map.put(map.firstKey(), map.firstEntry().getValue()-1);
						}
					}
				}
			}
			if(map.size()==0) {
				bw.write("EMPTY\n");
			}else {
				bw.write(map.lastKey()+" "+map.firstKey()+"\n");
			}
		}
		bw.flush();
	}
}
