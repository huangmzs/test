package com.java155.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OtherSservice {

	@Test
	public void testA(){
		try {
			URL url=new URL("http://localhost:8080/item/item.list?keyword=1");//创建URL
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();//打开链接
			//发送请求
			//urlConnection.setRequestProperty();设置请求头部
			//urlConnection.setRequestProperty();
			//urlConnection.getOutputStream().write();设置请求body
			//响应结果
			InputStream inputStream = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			StringBuffer buffer=new StringBuffer();
			while ((line=bufferedReader.readLine())!=null){
					buffer.append(line);
			}

			System.out.println(buffer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
