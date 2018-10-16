package mayi.three;/**
 * @Project:httpLearn
 * @PackageName:mayi
 * @Author: Sprite
 * @DateTime:2018/9/14 17:08.
 * @Description:
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/**
 * sprite.shen
 * 消费者
 **/
public class Consumer {
    private ConcurrentMap<Long,DataBean> resultMap=new ConcurrentHashMap();

    public void consumQueue(){
        final ConcurrentLinkedQueue<DataBean> queue = DataQuequeSingleton.getInstance().getQueue();
        new Thread(new Runnable() {
            public void run() {
                while (!queue.isEmpty()) {
                DataBean dataBean = queue.poll();
                processOne(dataBean);}
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // System.out.println("resultMap:"+resultMap);
        Set<Long> longs = resultMap.keySet();
        //可以自己写快排序
        Set<Long> treeSet = new TreeSet<Long>(new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return (int)(o1-o2);
            }
        });
        for(long l:longs){
            treeSet.add(l);
        }
        //输出
        Iterator<Long> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(resultMap.get(iterator.next()).toString());
        }
    }

    /**
     * 处理一个Data数据
     */
    private void processOne(DataBean bean){
        if(resultMap.containsKey(bean.getGroupId())){
            //已经有key，取出数据对面，如果新数据的quota比老数据quota小，则替换，否则不做任何处理
            DataBean old = resultMap.get(bean.getGroupId());
            if(old.getQuota()>bean.getQuota()){
                resultMap.put(bean.getGroupId(),bean);
            }
        }else {
            resultMap.put(bean.getGroupId(), bean);
        }
    }
}