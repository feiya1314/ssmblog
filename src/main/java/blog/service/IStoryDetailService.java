package blog.service;

import blog.dto.output.StoryDetails;

import java.util.List;

public interface IStoryDetailService {
    StoryDetails getStoryEntry(int id);
    int insertStoryDetail(blog.dao.StoryDetails storyDetail);
    int insertStoryDetails(List<blog.dao.StoryDetails> storyDetails);
}
