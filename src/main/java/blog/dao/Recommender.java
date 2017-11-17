package blog.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Recommender {
	private String avatar="";
	private Integer uid;
	private Integer idx;
	private StoryDetails sDetails;
	
	

	
	public StoryDetails getsDetails() {
		return sDetails;
	}

	public void setsDetails(StoryDetails sDetails) {
		this.sDetails = sDetails;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
