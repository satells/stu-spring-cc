package com.stu;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TestURL implements Runnable {

	public static void main(String[] args) throws IOException, InterruptedException {
		int length = 200;
		Thread[] thread = new Thread[length];
		for (int i = 0; i < length; i++) {

			thread[i] = new Thread(new TestURL());

			thread[i].start();
		}

		for (int i = 0; i < length; i++) {

			thread[i].join();
		}

//		String urlParameters = "titulo=a&descricao=b&paginas=546";
//		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
//		int postDataLength = postData.length;
//		String request = "http://192.168.0.10/stu-spring-cc/produtos";
//		URL url = new URL(request);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setDoOutput(true);
//		conn.setInstanceFollowRedirects(false);
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		conn.setRequestProperty("charset", "utf-8");
//		conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
//		conn.setUseCaches(false);
//		try (DataOutputStream writer = new DataOutputStream(conn.getOutputStream())) {
//			writer.write(postData);
//			writer.flush();
//
//			String line;
//			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//			writer.close();
//			reader.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());

			String urlParameters = "titulo=titulo" + Thread.currentThread().getName() + "&descricao=descricao" + Thread.currentThread().getName() + "&paginas=546";
			byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			String request = "http://192.168.0.10/stu-spring-cc/produtos";
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			try (DataOutputStream writer = new DataOutputStream(conn.getOutputStream())) {
				writer.write(postData);
				writer.flush();

				System.out.println(conn.getResponseCode() + " " + Thread.currentThread().getName());

//				String line;
//				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//				while ((line = reader.readLine()) != null) {
//					System.out.println(line);
//				}
//				writer.close();
//				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
