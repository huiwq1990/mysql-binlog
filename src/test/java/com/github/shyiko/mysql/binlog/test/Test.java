package com.github.shyiko.mysql.binlog.test;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.EventHeader;

public class Test {

	public static void main(String[] args) throws Exception {


	        BinaryLogFileReader reader = new BinaryLogFileReader(new GZIPInputStream(
	                new FileInputStream("src/test/resources/mysql-bin.sakila.gz")));
	        
	       
	        try {
	            int numberOfEvents = 0;
	            Event tmp = null;
				while ((tmp  = reader.readEvent()) != null) {
	            	EventHeader header = tmp.getHeader();
	            	System.out.println(header);
	            	EventData data = tmp.getData();
	            	System.out.println(data);
	                numberOfEvents++;
	            }
	            assertEquals(numberOfEvents, 1462);
	        } finally {
	            reader.close();
	        }
	    }

}
