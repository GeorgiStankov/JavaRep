package com.hackbulgaria.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Crawler {
	private final String USER_AGENT = "Mozilla/5.0";

	public LinkedList<String> washingMachineCrawler() throws ClientProtocolException, IOException  {
		Pattern pat = Pattern.compile("<a itemprop=\"url\" href=\"([\\S]+) class=\"product-thumb\">");
		String url = "http://www.technomarket.bg/peralni";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);

		// add request header2
		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
		//	System.out.println(line);
			result.append(line);
		}
		Matcher m = pat.matcher(result);
		LinkedList<String> machinesURL = new LinkedList<String>();
		while (m.find()) {
			machinesURL.add(m.group(1));
		}
		System.out.println(machinesURL.toString());

		return machinesURL;
	}
	
	public LinkedList<String> washingMachineNames(LinkedList<String> list){
		
		return null;
	}


}
