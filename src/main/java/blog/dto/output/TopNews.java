package blog.dto.output;

public class TopNews {
    private int id;
    private String image;
    private String title;
    private String topdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopdate() {
        return topdate;
    }

    public void setTopdate(String topdate) {
        this.topdate = topdate;
    }
}
