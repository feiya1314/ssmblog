package blog.mapper;

import blog.dao.HotNews;
import blog.dto.output.Story;

import java.util.List;

public interface HotNewsMapper {
    int insertHotNews(HotNews[] hotNews);
    List<Story> getHotStoryByNum(int num);
    Story getHotStoryById(int id);
    List<Story> getHotStory();
}
