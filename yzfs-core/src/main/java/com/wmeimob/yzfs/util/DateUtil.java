package com.wmeimob.yzfs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class DateUtil {

	private static final String dateFormat="yyyy-MM-dd HH:mm:ss";
	private static final String shortDateFormat="yyyy-MM-dd";
	
	/**
	 * 接收页面传来的时间参数 字符串或时间戳 转换成Date
	 * @return
	 * @date 2017年5月30日 下午5:46:27
	 */
	@Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
            	 if (StringUtils.isEmpty(source)) {
                     return null;
                 }
                 source = source.trim();
                 try {
                     if (source.contains("-")) {
                         SimpleDateFormat formatter;
                         if (source.contains(":")) {
							formatter = new SimpleDateFormat(dateFormat);
                         } else {
							formatter = new SimpleDateFormat(shortDateFormat);
                         }
                         Date dtDate = formatter.parse(source);
                         return dtDate;
                     } else if (source.matches("^\\d+$")) {
                         Long lDate = new Long(source);
                         return new Date(lDate);
                     }
                 } catch (Exception e) {
                     throw new RuntimeException(String.format("parser %s to Date fail", source));
                 }
                 throw new RuntimeException(String.format("parser %s to Date fail", source));
            }

			@Override
			public JavaType getInputType(TypeFactory typeFactory) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public JavaType getOutputType(TypeFactory typeFactory) {
				// TODO Auto-generated method stub
				return null;
			}
        };
    }
	
	
	
	 /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
//        System.out.println(DateUtil.getMonthSpace("2010-10-8", "2012-12-12"));
    	getMonthSpace(-2);
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
//    	Date monthDate = getMonthDate(2,new Date());
    	 System.out.println(sdf.format(getMonthSpace(-2)));
    }

     /**
     * 获取两个日期间相差的月数
     * @param date1 <String>
     * @param date2 <String>
     * @return int
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result; /*== 0 ? 1 : Math.abs(result);*/

    }
    
    
    /**
     * 获取当前日期前的日期
     * @param num <int>
     * @return int
     * @throws ParseException
     */
    public static Date getMonthSpace(int num)
            throws ParseException {

    	Date dNow = new Date();   //当前时间
    	Date dBefore = new Date();
    	Calendar calendar = Calendar.getInstance(); //得到日历
    	calendar.setTime(dNow);//把当前时间赋给日历
    	calendar.add(Calendar.MONTH, num);  //设置为前3月
    	dBefore = calendar.getTime();   //得到前3月的时间
//    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
//    	String defaultStartDate = sdf.format(dBefore);    //格式化前3月的时间
//    	String defaultEndDate = sdf.format(dNow); //格式化当前时间
//    	System.out.println("前"+num+"个月的时间是：" + defaultStartDate);
//    	System.out.println("生成的时间是：" + defaultEndDate);
    	return dBefore;
    }
    
    
    /**
     * 获取几个月后的日期
     * @param num <int>
     * @return int
     * @throws ParseException
     */
    public static Date getMonthDate(int num,Date date)
            throws ParseException {

    	Calendar calendar = Calendar.getInstance(); //得到日历
    	calendar.setTime(date);//把当前时间赋给日历
    	calendar.add(Calendar.MONTH, num);  //设置为前3月
    	return calendar.getTime();
    }
    
    
    
}
