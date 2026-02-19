import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) {
        Video[] videos = new Video[100000];

        for (int i = 0; i < videos.length; i++) {
            videos[i] = new Video(i+100, "" + i);
        }
        System.out.println(Arrays.toString(find_top_k_viewed_videos(videos, 10)));
    }


    public static Video[] find_top_k_viewed_videos(Video[] videos, int k) {
        int biggest = 0;
        Video[] topVideos = new Video[k];
        int j = 0; //tracks number of elements in topVideos

        while (j < k) {
            biggest = find_most_viewed_video(videos);
            topVideos[j] = videos[biggest];
            videos[biggest].views *= -1 ;
            j++;
        }

        for (Video v: topVideos) {
            v.views *= -1;
        }
        return topVideos;
    }

    public static int find_most_viewed_video(Video[] videos) {
        int biggest = 0;
        for (int i = 0; i < videos.length; i++) {
            if (videos[i].views > videos[biggest].views) {biggest = i;}
        }
        return biggest;
    }
}
