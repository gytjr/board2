package java_board2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	static String getCurrentDate() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String time1 = format1.format(time);
		return time1;
	}

}
