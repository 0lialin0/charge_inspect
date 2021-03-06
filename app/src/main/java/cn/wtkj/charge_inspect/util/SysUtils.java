package cn.wtkj.charge_inspect.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ghj on 2016/10/22.
 */
public class SysUtils {

    /**
     * 复制单个文件
     * @param oldPath String 原文件路径 如：c:/fqf.txt
     * @param newPath String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static Boolean copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            File newfile = new File(newPath);

            if (newfile.exists()){
                return true;
            }

            if (oldfile.exists()) { //文件存在时
                //目标目录
                File targetDir = new File(newPath);
                //创建目录
                if(!targetDir.exists())
                {
                    targetDir.getParentFile().mkdirs();
                    targetDir.createNewFile();
                }

                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1024];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();

                return true;
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错:"+e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 加载本地图片
     * http://bbs.3gstdy.com
     * @param url
     * @return
     */
    public static Bitmap getLocalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatStrDate(String strDate){
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dataFormat2 = new SimpleDateFormat("MMddHHmm");

        String checkDate = "";

        try {
            Date date = dataFormat.parse(strDate);
            checkDate = dataFormat2.format(date);
        } catch (ParseException e) {
            Date date = new Date(System.currentTimeMillis());
            checkDate = dataFormat2.format(date);
            e.printStackTrace();
        }

        return checkDate;
    }
}
