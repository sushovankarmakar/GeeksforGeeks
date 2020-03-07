import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

class JavaDateAndDay {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		Calendar c = Calendar.getInstance();
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int date = Integer.parseInt(ip[0]), month = Integer.parseInt(ip[1]), year = Integer.parseInt(ip[2]);
			c.set(year,month-1,date);
			// approach : 1
			/*String op[] = c.getTime().toString().trim().split("\\s+");
			if(op[0].equals("Mon")) 	 System.out.println("MONDAY");
			else if(op[0].equals("Mon")) System.out.println("MONDAY");
			else if(op[0].equals("Tue")) System.out.println("TUESDAY");
			else if(op[0].equals("Wed")) System.out.println("WEDNESDAY");
			else if(op[0].equals("Thu")) System.out.println("THURSDAY");
			else if(op[0].equals("Fri")) System.out.println("FRIDAY");
			else if(op[0].equals("Sat")) System.out.println("SATURDAY");
			else if(op[0].equals("Sun")) System.out.println("SUNDAY");
			*/
			
			// approach : 2
			int day = c.get(Calendar.DAY_OF_WEEK);
			switch(day)
			{
			case 1: System.out.println("SUNDAY"); break;
			case 2: System.out.println("MONDAY"); break;
			case 3: System.out.println("TUESDAY"); break;
			case 4: System.out.println("WEDNESDAY"); break;
			case 5: System.out.println("THURSDAY"); break;
			case 6: System.out.println("FRIDAY"); break;
			case 7: System.out.println("SATURDAY"); break;
			}
		}
	}
}
