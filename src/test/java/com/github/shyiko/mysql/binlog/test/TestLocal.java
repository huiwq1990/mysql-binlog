package com.github.shyiko.mysql.binlog.test;



import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.EventHeader;

public class TestLocal {

	public static void main(String[] args) throws Exception {


		
		
		

	        BinaryLogFileReader reader = new BinaryLogFileReader(
	                new FileInputStream("C:/ProgramData/MySQL/MySQL Server 5.6/Data/mysql-bin.000001"));
	        
	       
	        try {
	            int numberOfEvents = 0;
	            for (Event event; (event = reader.readEvent()) != null; ) {
	            	EventHeader header = event.getHeader();
	            	System.out.println(header);
//	            	EventData data = tmp.getData();
//	            	System.out.println(data);
	                numberOfEvents++;
	            }
//	            assertEquals(numberOfEvents, 1462);
	        } finally {
	            reader.close();
	        }
	    }

}
