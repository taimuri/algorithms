package com.asim.topVideos;

import java.sql.Timestamp;

public class Video {

	private Integer id;
	private Timestamp duration;

	public Video(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDuration() {
		return duration;
	}

	public void setDuration(Timestamp duration) {
		this.duration = duration;
	}

}
