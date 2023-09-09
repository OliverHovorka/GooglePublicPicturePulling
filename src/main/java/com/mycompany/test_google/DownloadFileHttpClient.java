/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_google;

/**
 *
 * @author oliverhovorka
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class DownloadFileHttpClient {

    public static void main(String[] args) throws Exception {
	DownloadFileHttpClient client = new DownloadFileHttpClient();
	client.download();
    }

    public void download() {
	try {
	    CloseableHttpClient client = HttpClientBuilder.create().build();
	    HttpGet request;
	    HttpResponse response;
	    HttpEntity entity;
	    int responseCode;
	    String filePath = "./Garbage/file";
	    String prefix = "https://lh3.googleusercontent.com/-";
	    String suffix = "/s0-d/IMG.JPG";
	    String pre1;
	    String pre2;
	    String pre3;
	    String suf;
	    int i = 0;
	    InputStream is;
	    int inByte;
	    Random r = new Random();
	    while (i < 5) {
		client = HttpClientBuilder.create().build();
		pre1 = ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "";
		System.out.println(pre1);
		pre2 = ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "";
		System.out.println(pre2);

		pre3 = ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "";
		System.out.println(pre3);

		suf = ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65)) + "" +((char) (r.nextInt(26)+65))
			+ ((char) (r.nextInt(26)+65)) + "";
		System.out.println(suf);

		request = new HttpGet(prefix + "" +pre1 + "/" +pre2 + "/" +pre3 + "/" +suf + "" +suffix);

		response = client.execute(request);
		entity = response.getEntity();

		responseCode = response.getStatusLine().getStatusCode();

		System.out.println("Request Url: " + "" +request.getURI());
		System.out.println("Response Code: " + "" +responseCode);
		if (responseCode == 200) {
		    is = entity.getContent();

		    FileOutputStream fos = new FileOutputStream(new File(filePath + "" +i + "" +".jpg"));
		    i++;
		    while ((inByte = is.read()) != -1) {
			fos.write(inByte);
		    }

		    is.close();
		    fos.close();
		}
		client.close();
	    }
	    
	} catch (ClientProtocolException e) {
	    e.printStackTrace();
	} catch (UnsupportedOperationException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
