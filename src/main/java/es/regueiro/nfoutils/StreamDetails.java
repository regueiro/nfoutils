package es.regueiro.nfoutils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlAccessorType(XmlAccessType.FIELD)
class StreamDetails implements Cleanable {

	@XmlElement(name = "video", type = Video.class)
	private List<Video> videos;
	@XmlElement(name = "audio", type = Audio.class)
	private List<Audio> audios;
	@XmlElement(name = "subtitle", type = Subtitle.class)
	private List<Subtitle> subtitles;

	public StreamDetails() {
		this.videos = new ArrayList<>();
		this.audios = new ArrayList<>();
		this.subtitles = new ArrayList<>();
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Audio> getAudios() {
		return audios;
	}

	public void setAudios(List<Audio> audios) {
		this.audios = audios;
	}

	public List<Subtitle> getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(List<Subtitle> subtitles) {
		this.subtitles = subtitles;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, StreamDetails.class);
	}

	@Override
	public String toString() {
		return "StreamDetails [videos=" + videos + ", audios=" + audios + ", subtitles=" + subtitles + "]";
	}

}