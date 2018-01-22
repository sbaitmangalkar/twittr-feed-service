package com.twittr;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Shyam Baitmangalkar
 *
 */
public class TweetApp {
	public static void main(String[] args) {
		List<User> twitterUsers = Stream.of("@sbaitmangalkar,@jonsnow,@tryon,@kjain,@jjha".split(","))
				.map(u -> new User(String.valueOf(new Random().nextInt(5)), u))
				.collect(Collectors.toList());
		
		User randomUser = twitterUsers.get(new Random().nextInt(twitterUsers.size()));
		TweetService service = new TweetService();
		service.getTweetFeeds(randomUser).toStream().forEach(System.out::println);
	}
}
