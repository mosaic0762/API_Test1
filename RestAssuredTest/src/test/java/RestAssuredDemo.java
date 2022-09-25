import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

/*
 * @Description： //TODO
 * @Author: 陶春有
 * @Date: 2022-09-25 20:52
 **/
public class RestAssuredDemo {

    @Test
    public void getDemo1(){

        String phone = GetRandomPhone.randonmPhone();
        given().
                queryParam("mobilephone",phone).
                queryParam("pwd","lemo666").
        when().
                 get("http://httpbin.org/get").
        then().
                log().all();
    }

    @Test
    public void postDemo1(){

        given().
                formParam("mobilephone","phone").
                formParam("pwd","lemo666").
                contentType("application/x-www-form-urlencoded").
        when().
                post("http://httpbin.org/post").
        then().
                log().all();
    }

    @Test
    public void postDemo2(){

        String JsonData = "{\"mobilephone\": \"13415231155\",\"pwd\": \"lemo666\"}";

        given().
                body(JsonData).
                contentType("application/x-www-form-urlencoded").
        when().
                post("http://httpbin.org/post").
        then().
                log().all();
    }

    @Test
    public void getResponseJson2(){

        //RestAssured里面如果返回json小数，那么其类型是float
        //声明restassured返回json小数的类型是BigDecimal
        RestAssured.config=RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL));

        //获取随机手机号
        String phone = GetRandomPhone.randonmPhone();

        //json字符串
        String json = "{\"mobile_phone\":"+phone+",\"pwd\":\"lemon666\"}";

        Response response =
                given().
                        header("Content-Type","application/json").
                        header("X-Lemonban-Media-Type","lemonban.v1").
                        body(json).
                when().
                        post("http://api.lemonban.com/futureloan/member/register").
                then().
                        log().all().extract().response();


        //Response response1 =
        //        given().
        //                header("Content-Type","application/json").
        //                header("X-Lemonban-Media-Type","lemonban.v1").
        //                body(json).
        //        when().
        //                post("http://api.lemonban.com/futureloan/member/login").
        //        then().
        //                log().all().extract().response();

        //获取响应结果为Object类型
        Object object = response.jsonPath().get();
        Object mobile_phone = response.jsonPath().get("data.mobile_phone");
        System.out.println(mobile_phone);
        System.out.println();

        //Object转为String类型
        String jsonString = JSON.toJSONString(object);
        System.out.println(jsonString);
        System.out.println();

        //String转为Object类型
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject);
        System.out.println();

        //String转为Map类型
        Map<String,Object> objectMap = JSON.parseObject(jsonString);
        System.out.println(objectMap);
        System.out.println();

        //Map转为String类型
        String jsonString2 = JSON.toJSONString(objectMap);
        System.out.println(jsonString2);
        System.out.println();


    }

    //Object类型==>String类型==>Object类型
    //Object类型==>String类型==>Map类型==>String类型

}