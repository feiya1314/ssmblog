package blog.service.imp;

import blog.dto.output.Story;
import blog.mapper.StoryMapper;
import blog.service.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService implements IStoryService {
    @Autowired
    private StoryMapper storyMapper;
    @Override
    public Story getStroyById(int id) {
        return storyMapper.getStoryById(id);
    }

    @Override
    public List<Story> getStoryByDate(String date) {
        return storyMapper.getStoryByDate(date);
    }

    @Override
    public List<Story> getStoryByNum(int num) {
        return storyMapper.getStoryByNum(num);
    }

    @Override
    public int insertStories(List<blog.dao.Story> stories) {
        return storyMapper.insertStories(stories);
    }
}
