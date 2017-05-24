package com.twittr;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class TweetService {

	public Flux<TweetFeedEvent> getTweetFeeds(User user) {
		Flux<Long> longIntervalFlux = Flux.interval(Duration.ofSeconds(1));

		Flux<TweetFeedEvent> feedFlux = Flux.fromStream(
				Stream.generate(() -> new TweetFeedEvent(UUID.randomUUID().toString(), user, randomTweetContent(), new Date())));

		return Flux.zip(longIntervalFlux, feedFlux).map(x -> x.getT2());

	}

	private String randomTweetContent() {
		String[] allTweets = "@Sachin_rt Is god of cricket!!, @realDonaldTrump is 45th President of USA?, Spotted @SrBachchan today at Mumbai airport!!, @rogerfedrer moves to the top spot after US open!!"
				.split(",");
		return allTweets[new Random().nextInt(allTweets.length)];
	}
}
