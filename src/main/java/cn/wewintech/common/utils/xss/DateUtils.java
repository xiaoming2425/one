
package cn.wewintech.common.utils.xss;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		if(date == null){
			return "";
		}
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当天小时字符串 格式（HH）
	 */
	public static String getHour() {
		return formatDate(new Date(), "HH");
	}
	
	/**
	 * 得到当天分钟字符串 格式（mm）
	 */
	public static String getMinute() {
		return formatDate(new Date(), "mm");
	}
	
	/**
	 * 得到当天秒数字符串 格式（HH）
	 */
	public static String getSeconds() {
		return formatDate(new Date(), "ss");
	}
	
	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 获取当年的第一天
	 */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
    
    /**
	 * 获取某年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }
    
	/**
	 * 获取某年最后一天日期
	 */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
         
        return currYearLast;
    }
	
	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 判断时间是否在两个时间范围内
	 * 
	 * @param date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean isBetweenTwoDay(Date date, Date startDate,
			Date endDate) {
		if (DateUtils.isSameDay(date, startDate)) {
			return true;
		}
		if (DateUtils.isSameDay(date, endDate)) {
			return true;
		}
		if (date.after(startDate) && date.before(endDate)) {
			return true;
		}
		return false;
	}
	
	public static String addMonth(Date date,int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return formatDate(calendar.getTime());
	}
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
		// System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
//		Date date = new Date();
//		System.out.println(addMonth(date,1));
		 /*Date d2 = parseDate("2015-11-22");
		 Date d1 = parseDate("2014-11-28");
		 Date d3 = parseDate("2016-11-29");
		 List<Date> list = new ArrayList<Date>();
		 list.add(d3);
		 list.add(d1);
		 list.add(d2);
		 Collections.sort(list);
		 
		 System.out.println(formatDateTime(list.get(0)));*/
		 
		 
		 
		// System.out.println(DateUtils.getLastdayMonth(new Date(), -1));
		 
		 
		 System.out.println(getMonthSpace("2015-03-10","2019-03-15"));
		 
		 System.out.println(getMonthDate(new Date(),1));
		 
	}
	
	public static String getMaxMonthDate(String date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateFormat.format(calendar.getTime());
	}

	  public static int compare_date(Date DATE1, Date DATE2) {
	        
	        
	        try {
	            if (DATE1.getTime() > DATE2.getTime()) {
				
	                return 1;
	            } else if (DATE1.getTime() < DATE2.getTime()) {
				
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	  
	  /**
	     * 获取指定月份下个月的最后一天
	     * @param date 日期
	     * @param month 0本月 1 次月 -1 上月
	     * @return
	     */
	    public static String getLastdayMonth(Date date,int month) {
	       
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MONTH, month);
	       
	        calendar.add(Calendar.MONTH, 1);    //加一个月
	        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
	        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
	        String day_last = dateFormat.format(calendar.getTime());
	       
	        return day_last;
	    }
	    
	    public static String getMonthDate(Date date,int month) {
		       
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MONTH, month);
	       
	        String day_last = dateFormat.format(calendar.getTime());
	       
	        return day_last;
	    }
	    
	    /**
	     * 获取本月第一天
	     * @param date
	     * @return
	     */
	    public static String getFirstdayMonth(Date date) {
	        
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MONTH, 0);
	        Date theDate = calendar.getTime();

	        //上个月第一天
	        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
	        gcLast.setTime(theDate);
	        gcLast.set(Calendar.DAY_OF_MONTH, 1);
	        String day_first = dateFormat.format(gcLast.getTime());
	        
	        return day_first;
	    }
	    
	    
	    /**
	     * 获取两个时间的月数
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

	        
	        
	        result = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12 +  c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

	        int day2 = c2.get(Calendar.DAY_OF_MONTH);
	        
	        int day1 = c1.get(Calendar.DAY_OF_MONTH);
	        
	        /**
	         * 如果天数小  应该减一个月
	         */
	        if(day2 < day1){
	        	result = result -1;
	        }
	        
	        return result == 0 ? 1 : Math.abs(result);

	    }

}
