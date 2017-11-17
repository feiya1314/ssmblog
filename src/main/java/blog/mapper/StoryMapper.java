package blog.mapper;

import blog.dto.output.Story;

import java.util.List;

public interface StoryMapper {
    Story getStoryById(int id);
    List<Story> getStoryByDate(String date);
    List<Story> getStoryByNum(int num);
    int insertStories(List<blog.dao.Story> stories);
}
