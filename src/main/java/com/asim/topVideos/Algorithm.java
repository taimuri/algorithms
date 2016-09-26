package com.asim.topVideos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algorithm {

	/**
	 * Returns top 10 videos based on their viewing counts
	 * @param videos
	 * @return
	 */
	public Map<Integer, Long> topTenVideos(Stream<Video> videos) {

		// transform stream into Map<Integer, Long> where key represents id and value represents viewCount
		Map<Integer, Long> videoViewCountMap = videos.collect(Collectors.groupingBy(Video::getId, Collectors.counting()));

		// We need LinkedHasMap to save insertion order
		Map<Integer, Long> finalMap = new LinkedHashMap<>();

		videoViewCountMap.entrySet().stream()
			.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
			.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		return finalMap;
	}

	private static int generateRandomId() {
		int id = new Random().nextInt((10 - 1) + 1) + 1;
		return id;
	}

	public static void main(String[] args) {
		Algorithm al = new Algorithm();

		List<Video> videos = new ArrayList<>(10);

		for (int i = 0; i < 100; i++) {
			videos.add(new Video(generateRandomId()));
		}

		Map<Integer, Long> top10 = al.topTenVideos(videos.stream());

		System.out.println("VideoId = Viewing Counts\n");

		top10.entrySet().stream()
			.forEach(System.out::println);
	}
}
