import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class TestHttpGet {

	public static void main(String[] args) {
		new HttpGet().start();
	}

}
class HttpGet extends Thread{
	@Override
	public void run() {
		try {
			URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=masterjiangchao&key=868462100&type=data&doctype=xml&version=1.1&q=master");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuffer sb = new StringBuffer();
			while((line = br.readLine())!=null){
				sb.append(line);
			}
			br.close();
			isr.close();
			is.close();
			System.out.println(sb);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
