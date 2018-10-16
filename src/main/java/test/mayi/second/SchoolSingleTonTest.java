package test.mayi.second; 

import mayi.second.SchoolSingleTon;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertSame;

/** 
* SchoolSingleTon Tester. 
* 
* @author <Authors name>
* @version 1.0 
*/ 
public class SchoolSingleTonTest { 

/** 
* 
* Method: getInstance() 
* 
*/ 
@Test
public void testGetInstance() throws Exception {

    ExecutorService executorService = Executors.newFixedThreadPool(100);
    final SchoolSingleTon trueSchool=SchoolSingleTon.getInstance();//一个mian线程
    for(int i=0;i<100000;i++) {
        executorService.submit(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()+"get instance");
                SchoolSingleTon school = SchoolSingleTon.getInstance();
                assertSame(trueSchool, school);
            }
        });
    }
}


} 
