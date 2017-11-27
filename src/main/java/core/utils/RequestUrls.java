package core.utils;

public class RequestUrls {
	private static String latestNews="http://news-at.zhihu.com/api/4/news/latest";
	private static String storyDetails="http://news-at.zhihu.com/api/4/news/";
	private static String pastNew="http://news-at.zhihu.com/api/4/news/before/";
	private static String storyExtra="http://news-at.zhihu.com/api/4/story-extra/";
	private static String longComments="http://news-at.zhihu.com/api/4/story/";
	private static String shortComments="http://news-at.zhihu.com/api/4/story/";
	private static String storyThemes="http://news-at.zhihu.com/api/4/themes";
	private static String themesById="http://news-at.zhihu.com/api/4/theme/";
	private static String hotNews="http://news-at.zhihu.com/api/3/news/hot";
	private static String dailyPsychology="http://http://news-at.zhihu.com/api/4/theme/13";
	private static String dailySports="http://http://news-at.zhihu.com/api/4/theme/8";
	private static String peopleRecommend="http://http://news-at.zhihu.com/api/4/theme/12";

	public static String getLatestNews() {
		return latestNews;
	}
	public static String getStoryDetails(String id) {
		return storyDetails+id;
	}
	public static String getPastNew(String date) {
		return pastNew+date;
	}
	public static String getStoryExtra(String id) {
		return storyExtra+id;
	}
	public static String getLongComments(String id) {
		return longComments+id+"/long-comments";
	}
	public static String getShortComments(String id) {
		return shortComments+id+"/short-comments";
	}
	public static String getStoryThemes() {
		return storyThemes;
	}
	public static String getThemesById(String id) {
		return themesById+id;
	}
	public static String getHotNews(){return hotNews;}

	public static String getDailyPsychology() {
		return dailyPsychology;
	}

	public static String getDailySports() {
		return dailySports;
	}

	public static String getPeopleRecommend() {
		return peopleRecommend;
	}

	public static void main(String[] args) {
		System.out.println(RequestUrls.getLongComments("123456"));
		System.out.println(RequestUrls.getThemesById("123456"));
	}
	 
}
