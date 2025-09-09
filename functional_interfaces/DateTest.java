import java.text.SimpleDateFormat;
import java.util.Date;

interface DateUtils {
    static String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }
}

public class DateTest {
    public static void main(String[] args) {
        System.out.println(DateUtils.formatDate(new Date(), "dd/MM/yyyy"));
        System.out.println(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }
}