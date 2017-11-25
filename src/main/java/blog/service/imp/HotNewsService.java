package blog.service.imp;

import blog.dao.HotNews;
import blog.dto.output.Story;
import blog.mapper.HotNewsMapper;
import blog.service.IHotNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotNewsService implements IHotNewsService {
    @Autowired
    HotNewsMapper hotNewsMapper;
    @Override
    public int insertHotNews(HotNews[] hotNews) {
        return hotNewsMapper.insertHotNews(hotNews);
    }

    @Override
    public List<Story> getHotStoryByNum(int num) {
        return hotNewsMapper.getHotStoryByNum(num);
    }

    @Override
    public Story getHotStoryById(int id) {
        return hotNewsMapper.getHotStoryById(id);
    }

    @Override
    public List<Story> getHotStory() {
        return hotNewsMapper.getHotStory();
    }
}
