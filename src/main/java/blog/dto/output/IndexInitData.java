package blog.dto.output;

import java.util.List;

public class IndexInitData {
    private List<Story> stories;
    private List<TopNews> topNews;

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<TopNews> getTopNews() {
        return topNews;
    }

    public void setTopNews(List<TopNews> topNews) {
        this.topNews = topNews;
    }
}
