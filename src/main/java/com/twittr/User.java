package com.twittr;

/**
 * POJO representing Twittr user.
 * 
 * @author Shyam Baitmangalkar
 *
 */
public class User {
	private String userId;
	private String userName;

	public User(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
}
