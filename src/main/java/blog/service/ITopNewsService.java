package blog.service;

import blog.dao.TopStory;
import blog.dto.output.TopNews;

import java.util.List;

public interface ITopNewsService {
    List<TopNews> getTopNews(String date);
    List<TopNews> getTopNewsByJs();
    int insertTopStories(List<TopStory> stories);
}
