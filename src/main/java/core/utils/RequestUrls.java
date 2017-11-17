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
	
	public static void main(String[] args) {
		System.out.println(RequestUrls.getLongComments("123456"));
		System.out.println(RequestUrls.getThemesById("123456"));
	}
	 
}
