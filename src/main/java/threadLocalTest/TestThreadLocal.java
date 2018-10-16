package threadLocalTest;


/**
 * @Project:spring_boot_final
 * @PackageName:threadLocalTest
 * @Author: Chang
 * @DateTime:2018/10/11 4:21.
 * @Description:
 */
public class TestThreadLocal {

    private static ThreadLocal<Book> bookLocal=new ThreadLocal<Book>();

    public static void main(String[] args) {

        final Book  firstStart = new Book("init");
        new Thread(){
            @Override
            public void run() {
                firstStart.name="first name";
                bookLocal.set(firstStart);
                System.out.println(Thread.currentThread().getName()+":"+bookLocal.get().name);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                bookLocal.set(firstStart);
                System.out.println(Thread.currentThread().getName()+":"+bookLocal.get().name);
            }
        }.start();

    }
}
