package Leetcode_355_Design_Twitter;

import java.util.*;
import java.util.stream.Collectors;

class Twitter {

    int time = 1;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[2] - a[2]);

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new HashSet<>());
        map.get(userId).add(userId);
        heap.offer(new int[]{userId, tweetId, time++});
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> following = map.getOrDefault(userId, new HashSet<>());
        System.out.println(following);
        if(following.size() == 0) return res;
        res = heap.stream().sorted((a, b) -> b[2] - a[2]).filter(a -> following.contains(a[0])).map(a -> a[1]).collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        int n = 10;
        for(int twitterId : res){
            if(n-- <= 0) break;
            ans.add(twitterId);
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new HashSet<>());
        map.get(followerId).add(followerId);
        map.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followeeId) || !map.containsKey(followerId)) return;
        if(!map.get(followerId).contains(followeeId)) return;
        if(followerId == followeeId) return;
        map.get(followerId).remove(followeeId);
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