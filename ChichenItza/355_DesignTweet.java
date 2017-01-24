public class Twitter {
    /**
     * Idea -> 1. In global, maintain a timestamp and a Map storing userId/User pair.
     *         2. Then create two classes for Tweet and User, each tweet has a timestamp.
     *            Each user maintains a list of tweets which are posted by himself/herself.
     *            Each user also has a followed Set storing all following users' ids, including himself/herself.
     *         3. The tricky part is in getNewsFeed(), we use a PriorityQueue<Tweet>, 
     *            starting with every target user's tweet head, then retrieve tweets among each user's tweet list.
     */

    private int timestamp;
    private Map<Integer, User> userMap;

    private class Tweet{
        int tweetId;
        int time;
        Tweet next;
        
        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            time = timestamp++;
            next = null;
        }
    }

    private class User{
        int userId;
        Set<Integer> followed;
        Tweet head;
        
        public User(int userId) {
            this.userId = userId;
            followed = new HashSet<Integer>();
            /* first add himself/herself into the followed set */
            followed.add(userId);
            head = null;
        }
        
        public void post(int tweetId) {
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = head;
            head = newTweet;
        }
        
        public void follow(int followId) {
            followed.add(followId);
        }
        
        public void unfollow(int followId) {
            /* cannot remove himself/herself */
            if (followId == userId) return;
            followed.remove(followId);
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        timestamp = 0;
        userMap = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        if (!userMap.containsKey(userId)) return res;
        
        /* user PriorityQueue to compare each tweet's timestamp, use maxHeap */
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a, b) -> (b.time - a.time));
        
        Set<Integer> userSet = userMap.get(userId).followed;
        /* add every user's tweet head into the PriorityQueue */
        for (int id : userSet) {
            Tweet tweetHead = userMap.get(id).head;
            /* in case some users haven't posted any tweet */
            if (tweetHead != null) pq.offer(tweetHead);
        }
        
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            count++;
            res.add(tweet.tweetId);
            if (tweet.next != null) pq.offer(tweet.next);
        }
        
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        /* if there is not followerId or followeeId existing in userMap, add first. */
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        /* if there is not user with followerId or followerId is the same as followeeId, ignore it. */
        if (!userMap.containsKey(followerId) || followerId == followeeId) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
