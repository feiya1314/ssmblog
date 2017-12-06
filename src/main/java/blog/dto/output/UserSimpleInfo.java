package blog.dto.output;

public class UserSimpleInfo {
    private String username="";
    private int id;
    private int role;
    private boolean isFreezen;
    private String headUrl="";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isFreezen() {
        return isFreezen;
    }

    public void setFreezen(boolean freezen) {
        isFreezen = freezen;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
