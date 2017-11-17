package blog.mapper;

import blog.dao.TopStory;
import blog.dto.output.TopNews;

import java.util.List;

public interface TopNewsMapper {
    List<TopNews> getTopNewsByDate(String date);
    List<TopNews> getTopNewsByJs();
    int insertTopStories(List<TopStory> stories);
}
