import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project:spring_boot_final
 * @PackageName:PACKAGE_NAME
 * @Author: Chang
 * @DateTime:2018/9/2 18:25.
 * @Description:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap();
        map.put("test1","testValue");

    }
}
