package blog.service.imp;

import blog.dto.output.StoryDetails;
import blog.mapper.StoryDetailMapper;
import blog.service.IStoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryDetailService implements IStoryDetailService {
    @Autowired
    private StoryDetailMapper storyDetailMapper;
    @Override
    public StoryDetails getStoryEntry(int id) {
        return storyDetailMapper.getStoryDetailById(id);
    }

    @Override
    public int insertStoryDetail(blog.dao.StoryDetails storyDetail) {
        return storyDetailMapper.insertStoryDetail(storyDetail);
    }

    @Override
    public int insertStoryDetails(List<blog.dao.StoryDetails> storyDetails) {
        return storyDetailMapper.insertStoryDetails(storyDetails);
    }
}
