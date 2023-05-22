import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3613_ { // Java vs C++

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		
		String result="";
		
		// flag : false = C++, true = JAVA
		boolean flag=false;
		for(int i=0; i<str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) { // JAVA
				flag=true;
				break;
			}
		}
		
		if(flag) { // 대문자o, '_' o -> Error
			if(str.contains("_")) {
				result="Error!";
			}
		}else { // 소문자만 있는 경우 -> 둘 다
			if(!str.contains("_")) {
				flag=true;
			}
		}
		
		if(Character.isUpperCase(str.charAt(0)) || str.charAt(0)=='_' || str.charAt(str.length()-1)=='_' || str.contains("__")) { // Error
			result="Error!";
		}
		
		if(result.equals("")) {
			if(flag) { // JAVA
				for(int i=0; i<str.length(); i++) {
					if(Character.isUpperCase(str.charAt(i))) {
						result+="_"+Character.toLowerCase(str.charAt(i));
					}else {
						result+=str.charAt(i);
					}
				}
				
			}else { // C++
				boolean check=false;
				for(int i=0; i<str.length(); i++){
					if(check) {
						check=false;
						result+=Character.toUpperCase(str.charAt(i));
					}else {
						if(str.charAt(i)=='_') check=true;
						else result+=str.charAt(i);
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
