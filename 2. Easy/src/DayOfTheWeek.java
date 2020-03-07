import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class DayOfTheWeek {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int date = Integer.parseInt(ip[0]), month = Integer.parseInt(ip[1]), year = Integer.parseInt(ip[2]);
			
			String daysOfWeek[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
			int doomsdayByCenturyArray[] = {3,2,0,5};  // 1900 -> 3, 2000 -> 2, 2100 -> 0, 2200 -> 5
			
			int doomsdayByMonthArray[] = {3,28,14,4,9,6,11,8,5,10,7,12}; 
			if(year%4==0 || year%400==0 ) {	doomsdayByMonthArray[0] = 4; doomsdayByMonthArray[1] = 29; }  // checking for leap year
			
			int a = doomsdayByCenturyArray[ (year/100) - 19];
			int b = (year%100)/12;
			int c = (year%100)%12;
			int d = c/4;
			int e = a+b+c+d;
			int doomsday = e%7;
			int doomsdayByMonth = doomsdayByMonthArray[month-1];
			
			if( (doomsdayByMonth%7) == (date%7) ) {
				System.out.println(daysOfWeek[doomsday]);
			}
			else if(doomsdayByMonth < date ) {
				
				//while(doomsdayByMonth+7 < date ) {		doomsdayByMonth += 7;	}
				
				System.out.println(daysOfWeek[ (doomsday+ (date-doomsdayByMonth)%7)%7] );
			}
			else {
				//while(doomsdayByMonth-7 > date) {		doomsdayByMonth -= 7;	}
				int op = (doomsday- (doomsdayByMonth-date)%7)%7;
				if(op < 0) op += 7;
				
				System.out.println(daysOfWeek[op] );
			}
			
			System.out.println(e);
			System.out.println(doomsday);
		}
	}
}
