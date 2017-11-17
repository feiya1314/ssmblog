package blog.mapper;

import blog.dto.output.StoryDetails;

import java.util.List;

public interface StoryDetailMapper {
    StoryDetails getStoryDetailById(int id);
    int insertStoryDetail(blog.dao.StoryDetails storyDetail);
    int insertStoryDetails(List<blog.dao.StoryDetails> storyDetails);
}
