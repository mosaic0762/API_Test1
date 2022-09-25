import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * @Description： //TODO
 * @Author: 陶春有
 * @Date: 2022-09-25 22:23
 **/
public class BirthUtils {

    /**
     * 根据身份证号判断当前年龄
     *
     * @param cardNo
     * @return
     */
/*    public static int getAge(String cardNo) {
        String birthday = cardNo.substring(6, 14);
        Date birthdate = null;
        try {
            birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        GregorianCalendar currentDay = new GregorianCalendar();
        currentDay.setTime(birthdate);
        int birYear = currentDay.get(Calendar.YEAR);

        // 获取年龄
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String thisYear = simpleDateFormat.format(new Date());
        int age = Integer.parseInt(thisYear) - birYear;

        return age;
    }
*/
    public static String getAge1(String cardNo) {

        int age;

        do {
            //获取出生年份
            String birthyear = cardNo.substring(6, 10);

            //获取当前年份
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String thisYear = simpleDateFormat.format(new Date());

            //获取年龄
            age = Integer.parseInt(thisYear) - Integer.parseInt(birthyear);

            //判断年龄是否符合要求
        } while (age < 20 || age > 65);

        return cardNo;
    }

    public static void main(String[] args) {
        // 1989-2022 33岁
        System.out.println(getAge1("410727199511197316"));
    }

}