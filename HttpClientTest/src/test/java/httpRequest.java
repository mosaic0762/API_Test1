import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/*
 * @Description： //TODO
 * @Author: 陶春有
 * @Date: 2022-09-25 20:17
 **/
public class httpRequest {

    /**
     * @return get请求url, 以String形式返回请求结果
     */
    public String httpGetRequest(String url) {

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClients.custom().build();

        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                System.out.println("--------------------------------------");
                System.out.println(result);
                System.out.println("--------------------------------------");
                response.close();
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
// 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    public static void main(String[] args) {

        httpRequest httpRequest = new httpRequest();
        String getRequest = httpRequest.httpGetRequest("http://httpbin.org/get");

        System.out.println(getRequest);

    }
}