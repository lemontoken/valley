package mayi.three; /**
 * @Project:httpLearn
 * @PackageName:PACKAGE_NAME
 * @Author: Sprite
 * @DateTime:2018/9/14 12:08.
 * @Description:
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Sprite
 **/
public class FileUtil {
    /**
     * 获取指定文件路径下的
     * @return
     */
    public static List<String> getFilesName(String path){
        List<String> fileNames=new ArrayList<String>();
        File file = new File(path);
        File[] array = file.listFiles();
        for(int i=0;i<array.length;i++){
            File f = array[i];
            if(f.isFile()){
                fileNames.add(f.getAbsoluteFile()+"");
            }
        }
        return fileNames;
    }
}
