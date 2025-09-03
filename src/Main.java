import java.util.*;

public class PostManager {

    // 1. calculateEngagement
    public int calculateEngagement(int... interactions) {
        if (interactions == null || interactions.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i : interactions) {
            total += i;
        }
        return total;
    }

    // 2. getCategoryRating
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

    // 3. displayPostStats - Overloaded Methods
    public void displayPostStats(String postTitle, int engagementScore) {
        System.out.println("Post Title: " + postTitle);
        System.out.println("Engagement Score: " + engagementScore);
    }

    public void displayPostStats(String postTitle, int engagementScore, String category) {
        System.out.println("Post Title: " + postTitle);
        System.out.println("Engagement Score: " + engagementScore);
        System.out.println("Category: " + category);
    }

    // 4. manageHashtags
    public ArrayList<String> manageHashtags(String[] hashtags) {
        if (hashtags == null || hashtags.length == 0) {
            return new ArrayList<>();
        }

        Set<String> uniqueHashtags = new HashSet<>();
        int max = Math.min(hashtags.length, 5); // Fixed size of 5

        for (int i = 0; i < max; i++) {
            if (hashtags[i] != null && !hashtags[i].isBlank()) {
                uniqueHashtags.add(hashtags[i]);
            }
        }

        return new ArrayList<>(uniqueHashtags); // Convert to ArrayList
    }

    // 5. findTrendingPosts
    public LinkedList<String> findTrendingPosts(ArrayList<String> posts, HashMap<String, Integer> postEngagement) {
        LinkedList<String> trending = new LinkedList<>();
        if (posts == null || postEngagement == null) return trending;

        for (String post : posts) {
            if (postEngagement.containsKey(post) && postEngagement.get(post) > 500) {
                trending.add(post);
            }
        }
        return trending;
    }

    // 6. getUniqueAuthors
    public HashSet<String> getUniqueAuthors(String... authors) {
        HashSet<String> uniqueAuthors = new HashSet<>();
        if (authors != null) {
            for (String author : authors) {
                if (author != null && !author.isBlank()) {
                    uniqueAuthors.add(author);
                }
            }
        }
        return uniqueAuthors;
    }

    // 7. Main Method for testing
    public static void main(String[] args) {
        PostManager pm = new PostManager();

        // Post: "Java Programming Tips"
        int engagement = pm.calculateEngagement(150, 75, 25); // likes, comments, shares
        String category = pm.getCategoryRating(engagement);

        // Display both versions of overloaded methods
        System.out.println("\n--- Display Post Stats (Basic) ---");
        pm.displayPostStats("Java Programming Tips", engagement);

        System.out.println("\n--- Display Post Stats (With Category) ---");
        pm.displayPostStats("Java Programming Tips", engagement, category);

        // Hashtags
        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = pm.manageHashtags(hashtags);
        System.out.println("\n--- Unique Hashtags ---");
        for (String tag : uniqueHashtags) {
            System.out.println(tag);
        }

        // Authors
        HashSet<String> authors = pm.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");
        System.out.println("\n--- Unique Authors ---");
        for (String author : authors) {
            System.out.println(author);
        }

        // Trending Posts
        ArrayList<String> posts = new ArrayList<>(Arrays.asList("Java Programming Tips", "Beginner Java", "Fun Coding Tricks"));
        HashMap<String, Integer> postEngagement = new HashMap<>();
        postEngagement.put("Java Programming Tips", 250);
        postEngagement.put("Beginner Java", 700);
        postEngagement.put("Fun Coding Tricks", 1200);

        LinkedList<String> trendingPosts = pm.findTrendingPosts(posts, postEngagement);
        System.out.println("\n--- Trending Posts ---");
        for (String post : trendingPosts) {
            System.out.println(post);
        }
    }
}
