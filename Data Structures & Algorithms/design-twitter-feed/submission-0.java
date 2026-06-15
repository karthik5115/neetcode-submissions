class Twitter {
    int g_index;
    class Tweet{
        int tweetId;
        int index;
        Tweet(int tweetId,int index){
            this.tweetId=tweetId;
            this.index=index;
        }
    }
    HashMap<Integer,HashSet<Integer>> following;
    HashMap<Integer,ArrayList<Tweet>> userTweets;
    public Twitter() {
        this.following = new HashMap<>();
        this.userTweets=new HashMap<>();
        this.g_index=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        ArrayList<Tweet> userPosts=userTweets.getOrDefault(userId,new ArrayList<>());
        Tweet post = new Tweet(tweetId,g_index++);
        userPosts.add(post);
        userTweets.put(userId,userPosts);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> feed = new PriorityQueue<>((a,b)->Integer.compare(a.index,b.index));
        HashSet<Integer> user_followings = following.getOrDefault(userId,new HashSet<>());
        user_followings.add(userId);
        for(Integer friend:user_followings){
            for(Tweet post:userTweets.getOrDefault(friend,new ArrayList<>())){
                if(feed.size()<10){
                    feed.offer(post);
                }
                else if(feed.peek().index<post.index){
                    feed.poll();
                    feed.offer(post);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!feed.isEmpty()){
            ans.add(feed.poll().tweetId);
        }
        Collections.reverse(ans);
        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> x = following.getOrDefault(followerId,new HashSet<>());
        x.add(followeeId);
        following.put(followerId,x);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> x = following.getOrDefault(followerId,new HashSet<>());
        x.remove(followeeId);
        following.put(followerId,x);
    }
}
