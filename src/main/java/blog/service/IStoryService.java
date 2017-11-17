package blog.service;

import blog.dto.output.Story;

import java.util.List;

public interface IStoryService {
    Story getStroyById(int id);
    List<Story> getStoryByDate(String date);
    List<Story> getStoryByNum(int num);
    int insertStories(List<blog.dao.Story> stories);
}
