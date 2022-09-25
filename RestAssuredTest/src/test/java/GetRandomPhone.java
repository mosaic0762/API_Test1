import java.util.Random;

/*
 * @Description： //TODO
 * @Author: 陶春有
 * @Date: 2022-09-25 20:56
 **/
public class GetRandomPhone {

    //随机生成一个手机号
    public static String randonmPhone() {

        //定义手机号前三位数组
        StringBuilder RandonmPhone = new StringBuilder("134");

        //生成一个11位手机号
        for (int i = 0; i < 8; i++) {

            Random random = new Random();
            int anInt = random.nextInt(9);

            RandonmPhone.append(anInt);
        }
        return RandonmPhone.toString();
    }


    public static void main(String[] args) {
        String phone = GetRandomPhone.randonmPhone();
        System.out.println(phone);

    }

}