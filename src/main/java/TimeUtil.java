import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 */
public class TimeUtil {
    public static void main(String[] args) throws Exception {
        //美东时间戳 => GMT时间戳
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        long t = 1587514500000L - timeZone.getRawOffset();
        TimeZone timeZone1 = TimeZone.getTimeZone("Asia/Shanghai");
        //GMT时间戳 => 北京时间戳
        long t1 = t - timeZone1.getRawOffset();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //北京时间
        Date date = new Date(t1);
        System.out.println(date.toString());
        String beiJingTime = sdf.format(date);
        System.out.println("北京时间：" + beiJingTime);
        //美东时间
        sdf.setTimeZone(timeZone);
        String format = sdf.format(date);
        Date parse = sdf.parse("2020-04-21 17:15:00");
        System.out.println(parse.toString());
        System.out.println("美东时间：" + format);
    }
}
