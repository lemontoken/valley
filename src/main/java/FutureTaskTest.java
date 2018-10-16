import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Project:spring_boot_final
 * @PackageName:PACKAGE_NAME
 * @Author: Chang
 * @DateTime:2018/9/3 20:48.
 * @Description:
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new Task());
        new Thread(futureTask).start();
       // if(futureTask.isDone()){

            try {

                Thread.sleep(2000);
                //能够获取子线程的返回值
                Object o = futureTask.get();
                System.out.println("sub thread get result:"+o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
      //  }

    }

    static class Task implements Callable<Integer>{
        public Integer call() throws Exception {
            System.out.println("calling");
            return 1;
        }
    }
}
