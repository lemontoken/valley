package mayi.three;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Project:spring_boot_final
 * @PackageName:mayi
 * @Author: Sprite
 * @DateTime:2018/9/15 10:04.
 * @Description:单例模式的队列
 */
public class DataQuequeSingleton {
    //volatile 内存可见，防指令重排
    private volatile static DataQuequeSingleton dataQuequ;
    private ConcurrentLinkedQueue<DataBean> queue;

    private DataQuequeSingleton(){
        this.queue=new ConcurrentLinkedQueue<DataBean>();
    }
    public static DataQuequeSingleton getInstance(){
        if(dataQuequ==null) {
            synchronized (DataQuequeSingleton.class) {
                if(dataQuequ==null){
                    dataQuequ=new DataQuequeSingleton();
                }
            }
        }
        return dataQuequ;
    }

    public ConcurrentLinkedQueue<DataBean> getQueue() {
        return queue;
    }
}
