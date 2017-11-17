package blog.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LatestNews {
	private String date="";
	private List<Story> stories=null;
	private List<TopStory> top_stories=null;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Story> getStories() {
		return stories;
	}
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	public List<TopStory> getTop_stories() {
		return top_stories;
	}
	public void setTop_stories(List<TopStory> top_stories) {
		this.top_stories = top_stories;
	}
	
	
	
	
}
