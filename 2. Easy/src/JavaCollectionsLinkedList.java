import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/generics-in-java/

class JavaCollectionsLinkedList {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			if(n==1) {
				String s = br.readLine().trim();
				GenericClass<String> str = new GenericClass<String>(s);
				str.showType();
			}
			else if(n==2) {
				int no = Integer.parseInt(br.readLine().trim());
				GenericClass<Integer> integer = new GenericClass<Integer>(no);
				integer.showType();
			}
		}
	}
}

class GenericClass<T> {
	
	T obj;
	public GenericClass(T obj){
		this.obj = obj;
	}
	
	void showType() {
		System.out.println(obj.getClass().getSimpleName()+"\n"+ obj);
	}
}
