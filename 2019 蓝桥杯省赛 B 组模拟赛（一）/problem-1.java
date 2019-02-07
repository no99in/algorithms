import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		SimpleDateFormat dft = new SimpleDateFormat("HH:mm:ss");

		try {
			Date date_1 = dft.parse("06:24:26");
			Date date_2 = dft.parse("22:28:45");
			Date date_3 = dft.parse("24:00:00");
			long res = date_3.getTime() - date_2.getTime() + date_1.getTime();
			Date date_res = new Date(res);
			System.out.println(dft.format(date_res));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
