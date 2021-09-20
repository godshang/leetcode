package q355_design_twitter;

import java.util.*;

public class Twitter {

    private Map<Integer, User> userMap;
    private static int time = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));
        User user = userMap.get(userId);
        user.postTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId))
            return res;
        User user = userMap.get(userId);
        Set<Integer> followerIds = user.followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(followerIds.size(), (a, b) -> (b.time - a.time));
        for (Integer followerId : followerIds) {
            if (!userMap.containsKey(followerId))
                continue;
            User follower = userMap.get(followerId);
            if (follower.head == null)
                continue;
            ;
            pq.add(follower.head);
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10)
                return res;
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            if (tweet.next != null)
                pq.offer(tweet.next);
        }

        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId))
            userMap.put(followerId, new User(followerId));
        if (!userMap.containsKey(followeeId))
            userMap.put(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId))
            userMap.get(followerId).unfollow(followeeId);
    }

    private static class Tweet {
        public int tweetId;
        public int time;
        public Tweet next;

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private static class User {
        public int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            this.head = null;
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id)
                followed.remove(userId);
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, time++);
            tweet.next = head;
            head = tweet;
        }
    }
}
