package leet.Neetcode.heap;

import java.util.*;

public class DesignTwitter355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));
    }
    static class Twitter {
        HashMap<Integer, HashSet<Integer>> followMap;
        HashMap<Integer, List<int[]>> tweetMap;
        int time = 0;

        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetMap.putIfAbsent(userId, new ArrayList<int[]>());
            tweetMap.get(userId).add(new int[]{time,tweetId});
            follow(userId,userId);
            time++;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new ArrayList<>();
            HashSet<Integer> followees = followMap.get(userId);
            PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0]-a[0]);
            for (int x : followees){
                List<int[]> xtweets = tweetMap.get(x);
                if (xtweets != null) {
                    for (int[] tweet : xtweets) {
                        queue.add(tweet);
                    }
                }
            }
//            if(tweetMap.containsKey(userId)){
//                List<int[]> userTweet = tweetMap.get(userId);
//                for(int[] tweet : userTweet){
//                    queue.add(tweet);
//                }
//            }
            int count = 0;
            while(count < 10 && !queue.isEmpty()){
                result.add(queue.poll()[1]);
                count++;
            }
            return result;
        }

        public void follow(int followerId, int followeeId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
