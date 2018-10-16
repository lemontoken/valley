package mayi.second;

/**
 * @Project:spring_boot_final
 * @PackageName:mayi.second
 * @Author: Chang
 * @DateTime:2018/9/15 17:37.
 * @Description:
 */
public class SchoolSingleTon {
    //防指令重排和内存不可见
    private volatile static SchoolSingleTon instance;
    //私有化构造器，防止外部调用
    // 还需要防止通过反射，访问到构造器
    private static boolean flag=false;
    private SchoolSingleTon(){
        synchronized (SchoolSingleTon.class){
            if(flag==false){
                flag=!flag;
            }else{
                throw new RuntimeException("singleTon attack");
            }
        }
    }
    //双重检查
    public static SchoolSingleTon getInstance(){
        if(instance==null){//提供效率
            synchronized (SchoolSingleTon.class){
                if(instance==null){
                    instance=new SchoolSingleTon();//非原子性操作
                }
            }
        }
        return instance;
    }
}
