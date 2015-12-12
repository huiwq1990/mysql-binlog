package com.github.shyiko.mysql.binlog.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.CapturingEventListener;
import com.github.shyiko.mysql.binlog.CountDownEventListener;
import com.github.shyiko.mysql.binlog.TraceEventListener;

public class sssssss {

	public static void main(String[] args) throws InterruptedException {
		  BinaryLogClient binaryLogClient = new BinaryLogClient("localhost", 3306, "root", "mysql");
	        assertTrue(binaryLogClient.getEventListeners().isEmpty());
	        TraceEventListener traceEventListener = new TraceEventListener();
	        binaryLogClient.registerEventListener(traceEventListener);
	        binaryLogClient.registerEventListener(new CountDownEventListener());
	        binaryLogClient.registerEventListener(new CapturingEventListener());
	        assertEquals(binaryLogClient.getEventListeners().size(), 3);
	        binaryLogClient.unregisterEventListener(traceEventListener);
	        assertEquals(binaryLogClient.getEventListeners().size(), 2);
	        binaryLogClient.unregisterEventListener(CountDownEventListener.class);
	        assertEquals(binaryLogClient.getEventListeners().size(), 1);
	        
	        
	        Thread.sleep(100000);
	}

}
