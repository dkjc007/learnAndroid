import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TestHttpPost {

	public static void main(String[] args) {
		new HttpPost().start();
	}

}

class HttpPost extends Thread{
	@Override
	public void run() {
		try {
			URL url = new URL("http://fanyi.youdao.com/openapi.do");
			HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("encoding", "UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("keyfrom=masterjiangchao&key=868462100&type=data&doctype=json&version=1.1&q=fuck");
			bw.flush();
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null){
				sb.append(line);
			}
			br.close();
			isr.close();
			is.close();
			bw.close();
			osw.close();
			os.close();
			System.out.println(sb);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
