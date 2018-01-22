package com.twittr;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

/**
 * Service layer that will generate a never ending Twittr Feeds.
 * 
 * @author Shyam Baitmangalkar
 *
 */
public class TweetService {

	public Flux<TweetFeedEvent> getTweetFeeds(User user) {
		/*
		 * Flux that is created every second
		 */
		Flux<Long> longIntervalFlux = Flux.interval(Duration.ofSeconds(1));
		
		/*
		 * Flux that contains the tweet feed event.
		 */
		Flux<TweetFeedEvent> feedFlux = Flux.fromStream(
				Stream.generate(() -> new TweetFeedEvent(UUID.randomUUID().toString(), user, randomTweetContent(), new Date())));

		/*
		 * zip method combines two Fluxx and a Tuple2 object is returned.
		 * Tuple2 is found in reactor.util.function package which represents
		 * an object with 2 values.
		 */
		return Flux.zip(longIntervalFlux, feedFlux).map(x -> x.getT2());

	}

	/**
	 * Returns a random tweet string each time it is called.
	 * 
	 * @return Random Tweet
	 */
	private String randomTweetContent() {
		String[] allTweets = "@Sachin_rt Is god of cricket!!, @realDonaldTrump is 45th President of USA?, Spotted @SrBachchan today at Mumbai airport!!, @rogerfedrer moves to the top spot after US open!!"
				.split(",");
		return allTweets[new Random().nextInt(allTweets.length)];
	}
}
