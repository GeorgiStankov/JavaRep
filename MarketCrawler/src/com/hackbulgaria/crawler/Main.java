package com.hackbulgaria.crawler;

import java.io.IOException;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Crawler crawler = new Crawler();
		try {
			LinkedList<String> links = crawler.washingMachineCrawler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
