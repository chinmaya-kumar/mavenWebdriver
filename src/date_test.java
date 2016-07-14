import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class date_test {

	public static void main(String[] args) {
		
		String dateString = "15-08-2015";
		

        // Get a Date object from the date string
        Date myDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("d-MM-yyyy");
			myDate = dateFormat.parse(dateString);
			System.out.println(myDate);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(myDate);
		    cal.add(Calendar.DATE, -16);
		    Date todate1 = cal.getTime();    
		    String fromdate = dateFormat.format(todate1);
		       
		       System.out.println(fromdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // this calculation may skip a day (Standard-to-Daylight switch)...
        //oneDayBefore = new Date(myDate.getTime() - (24 * 3600000));

        // if the Date->time xform always places the time as YYYYMMDD 00:00:00
        //   this will be safer.
        

      

	}

}
