public class Video {
    public int views;
    public String title;
    public Video(int views, String title) {
        this.views = views;
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int newViews) {
        views = newViews;
    }

    @Override
    public String toString() {
        return "Title: " + title + " |Views: " + views + "\n";
    }
}
