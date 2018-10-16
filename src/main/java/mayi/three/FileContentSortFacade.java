package mayi.three;

import java.util.List;

/**
 * 入口
 * 生产者开10个线程去读取数据，将数据放到队列中，消费者从队列中获取数据，不断比较，并输出最终结果
 */
public class FileContentSortFacade {
    public static void main(String[] args) {
        //todo 需要修改文件路径
        List<String> filesName = FileUtil.getFilesName("F:\\mayi\\test");
        new Producer(filesName).sendDataToQueue();
    	new Consumer().consumQueue();
    }
}
