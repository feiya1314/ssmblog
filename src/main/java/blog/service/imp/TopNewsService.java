package blog.service.imp;

import blog.dao.TopStory;
import blog.dto.output.TopNews;
import blog.mapper.TopNewsMapper;
import blog.service.ITopNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopNewsService implements ITopNewsService {

    @Autowired
    private TopNewsMapper topNewsMapper;

    @Override
    public List<TopNews> getTopNews(String date) {
        return topNewsMapper.getTopNewsByDate(date);
    }

    @Override
    public List<TopNews> getTopNewsByJs() {
        return topNewsMapper.getTopNewsByJs();
    }

    @Override
    public int insertTopStories(List<TopStory> stories) {
        return topNewsMapper.insertTopStories(stories);
    }

    public static void main(String[] args) {
        /*TopNewsService topNewsService=new TopNewsService();
        topNewsService.getTopNews("20170604");*/
    }
}
