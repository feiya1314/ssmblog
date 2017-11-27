package blog.mapper;

import blog.dao.StoryThemes;
import blog.dto.output.Story;

import java.util.List;

public interface StoryThemeMapper {
    int insertSportsTheme(StoryThemes[] storyThemes);
    int insertPsychologyTheme(StoryThemes[] storyThemes);
    int insertRecommendTheme(StoryThemes[] storyThemes);
    List<Story> getSportsThemeByNum(int num);
    List<Story> getPsychologyThemeByNum(int num);
    List<Story> getRecommendThemeByNum(int num);
}
