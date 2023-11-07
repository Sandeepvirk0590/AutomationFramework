package com.naveenautomation.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampTest{
	
	public void test1() {
		System.out.println(new Date());

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println(timeStamp);
	}

}