package q355_design_twitter;

public class Solution {

    public static void main(String[] args) {
//        Twitter twitter = new Twitter();
//        twitter.postTweet(1, 5);
//        System.out.println(twitter.getNewsFeed(1));
//        
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        System.out.println(twitter.getNewsFeed(1));
//        
//        twitter.unfollow(1, 2);
//        System.out.println(twitter.getNewsFeed(1));

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}

