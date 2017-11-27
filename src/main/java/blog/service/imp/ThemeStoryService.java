package blog.service.imp;

import blog.dao.StoryThemes;
import blog.dto.output.Story;
import blog.mapper.StoryThemeMapper;
import blog.service.IThemeStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThemeStoryService implements IThemeStoryService {
    @Autowired
    private StoryThemeMapper storyThemeMapper;
    @Override
    public int insertSportsTheme(StoryThemes[] storyThemes) {
        return storyThemeMapper.insertSportsTheme(storyThemes);
    }

    @Override
    public int insertPsychologyTheme(StoryThemes[] storyThemes) {
        return storyThemeMapper.insertPsychologyTheme(storyThemes);
    }

    @Override
    public int insertRecommendTheme(StoryThemes[] storyThemes) {
        return storyThemeMapper.insertRecommendTheme(storyThemes);
    }

    @Override
    public List<Story> getSportsThemeByNum(int num) {
        return storyThemeMapper.getSportsThemeByNum(num);
    }

    @Override
    public List<Story> getPsychologyThemeByNum(int num) {
        return storyThemeMapper.getPsychologyThemeByNum(num);
    }

    @Override
    public List<Story> getRecommendThemeByNum(int num) {
        return storyThemeMapper.getRecommendThemeByNum(num);
    }
}
