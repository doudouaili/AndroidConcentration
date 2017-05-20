package com.concentration.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ali on 2017/4/25.
 */
public class TimeUtil {
    /**
     * 获取系统时间
     * <p>格式yyyy-MM-dd HH:mm:ss</>
     *
     * @return
     */
    public static String getSystemTiem() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }

}
