package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public java.sql.Date StringToDate(String text){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try{
			Date parsed = format.parse("20110210");
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        return sql;
		}catch(ParseException e){
			
		}
	}
}
