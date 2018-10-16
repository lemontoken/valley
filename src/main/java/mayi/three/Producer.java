package mayi.three;/**
 * @Project:httpLearn
 * @PackageName:mayi
 * @Author: Sprite
 * @DateTime:2018/9/15 10:08.
 * @Description:
 */
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Sprite
 **/
public class Producer {
    private List<String> fileNames;
    public Producer(List<String> fileNames){
        this.fileNames=fileNames;
    }
    public  void sendDataToQueue() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ProduceDataThread thread=new ProduceDataThread(fileNames,new ProduceData(fileNames));
        for(int i=0;i<10;i++){
            executorService.submit(thread);
        }
//        debug
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ConcurrentLinkedQueue queue = DataQuequeSingleton.getInstance().getQueue();
//        System.out.println("queue:"+queue);
    }
}

/**
 * 生产者线程
 */
class ProduceDataThread implements Runnable{
    private List<String> fileNames;
    private ProduceData produceData;
    public ProduceDataThread(List<String> fileNames,ProduceData produceData){
        this.fileNames=fileNames;
        this.produceData=produceData;
    }
    public void run() {
        try {
            produceData.process();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者线程操作对象
 */
class ProduceData {
    private List<String> fileNames;
    //抢到了第几个文件
    private volatile Integer index = -1;
    ReentrantLock lock = new ReentrantLock();
    //public ProduceData() {}
    public ProduceData(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public void process() throws FileNotFoundException {
        while (index < fileNames.size()) {
            lock.lock();
            try {
                if (index >= fileNames.size()) {
                    return;
                }
                index++;
            } finally {
                lock.unlock();
            }
            //开始操作文件,取数据放入队列中
            String fileName = fileNames.get(index);
            System.out.println(Thread.currentThread().getName()+",process fileName:"+fileName);
            FileReader fileReader = new FileReader(fileName);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
            try {
                String lineContent = "";
                while ((lineContent = lineNumberReader.readLine()) != null) {
                    DataBean dataBean = new DataBean(lineContent);
                    DataQuequeSingleton.getInstance().getQueue().offer(dataBean);
                }
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                if(lineNumberReader!=null){
                    try {
                        lineNumberReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fileReader!=null){
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}