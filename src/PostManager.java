import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;

public class PostManager {

    // Calculates the total engagement score using varargs
    public int calculateEngagement(int... interactions) {
        int total = 0;
        for (int interaction : interactions) {
            total += interaction;
        }
        return total;
    }

    // Determines the category rating based on engagement score
    public String getCategoryRating(int engagementScore) {
        if (engagementScore >= 1000) {
            return "Viral";
        } else if (engagementScore >= 500) {
            return "Popular";
        } else if (engagementScore >= 100) {
            return "Good";
        } else if (engagementScore >= 50) {
            return "Low";
        } else {
            return "Poor";
        }
    }

    // Displays post title and engagement score
    public void displayPostStats(String postTitle, int engagementScore) {
        System.out.println("Post: " + postTitle);
        System.out.println("Engagement Score: " + engagementScore);
    }

    // Overloaded method to display post title, engagement score, and category
    public void displayPostStats(String postTitle, int engagementScore, String category) {
        displayPostStats(postTitle, engagementScore);
        System.out.println("Category: " + category);
    }

    // Returns a list of unique hashtags
    public ArrayList<String> manageHashtags(String[] hashtags) {
        HashSet<String> uniqueHashtags = new HashSet<>();
        for (String hashtag : hashtags) {
            uniqueHashtags.add(hashtag);
        }
        return new ArrayList<>(uniqueHashtags);
    }

    // Finds trending posts with engagement > 500
    public LinkedList<String> findTrendingPosts(ArrayList<String> posts, HashMap<String, Integer> postEngagement) {
        LinkedList<String> trendingPosts = new LinkedList<>();
        for (String post : posts) {
            if (postEngagement.getOrDefault(post, 0) > 500) {
                trendingPosts.add(post);
            }
        }
        return trendingPosts;
    }

    // Returns a set of unique authors
    public HashSet<String> getUniqueAuthors(String... authors) {
        HashSet<String> uniqueAuthors = new HashSet<>();
        for (String author : authors) {
            uniqueAuthors.add(author);
        }
        return uniqueAuthors;
    }
}