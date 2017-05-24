package com.twittr;

import java.util.Date;

public class TweetFeedEvent {
	private String tweetId;
	private User user;
	private String content;
	private Date tweetDate;
	
	public TweetFeedEvent(String tweetId, User user, String content, Date tweetDate) {
		super();
		this.tweetId = tweetId;
		this.user = user;
		this.content = content;
		this.tweetDate = tweetDate;
	}

	@Override
	public String toString() {
		return "TweetFeed [tweetId=" + tweetId + ", user=" + user + ", content=" + content + ", tweetDate=" + tweetDate
				+ "]";
	}
	
	
	
}
