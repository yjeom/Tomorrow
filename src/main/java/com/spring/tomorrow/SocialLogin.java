package com.spring.tomorrow;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class SocialLogin {

	public String getHttpConnection(String url) {
		StringBuffer buffer = new StringBuffer();
		try {
		URL obj = new URL(url);
		System.out.println(obj.toString());
		HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();
		if(responseCode==200) {
			InputStream is=conn.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String line=null;
			while((line=br.readLine())!=null) {
				buffer.append(line);
				buffer.append("\n");
			}
			br.close();
			is.close();
		}
		else {
			System.out.println(responseCode+"오류");
		}
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}


	public String getHttpConnection(String apiUrl, String param) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(apiUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write(param);
			bw.flush();
			
			bw.close();
			os.close();
			if (conn.getResponseCode() == 200) {
				String line = null;
				InputStream is = conn.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) {
					buffer.append(line);
					buffer.append('\r');
				}
				br.close();
				is.close();
			} else {
				System.out.println(conn.getResponseCode() + "오류");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
