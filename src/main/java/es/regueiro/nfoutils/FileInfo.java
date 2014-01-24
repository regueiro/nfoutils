package es.regueiro.nfoutils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlAccessorType(XmlAccessType.FIELD)
public class FileInfo implements Cleanable {

	@XmlElement(name = "streamdetails")
	StreamDetails streamDetails;

	public FileInfo() {
		this.streamDetails = new StreamDetails();
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, FileInfo.class);
	}

	@Override
	public String toString() {
		return "Fileinfo [streamDetails=" + streamDetails + "]";
	}

	static class StreamDetails implements Cleanable {

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

		@Override
		public String toString() {
			return "StreamDetails [videos=" + videos + ", audios=" + audios + ", subtitles=" + subtitles + "]";
		}

		@Override
		public void cleanEmptyTags() {
			TagCleaner.cleanEmptyTags(this, StreamDetails.class);
		}

	}

	static class Audio implements Cleanable {

		@XmlElement(name = "channels")
		private Integer channels;
		@XmlElement(name = "codec")
		private String codec;
		@XmlElement(name = "language")
		private String language;

		// Extra tags
		@XmlElement(name = "bitrate")
		private String bitrate;
		@XmlElement(name = "longlanguage")
		private String longLanguage;

		@Override
		public String toString() {
			return "Audio [channels=" + channels + ", codec=" + codec + ", language=" + language + ", bitrate="
					+ bitrate + ", longLanguage=" + longLanguage + "]";
		}

		@Override
		public void cleanEmptyTags() {
			TagCleaner.cleanEmptyTags(this, Audio.class);
		}

	}

	static class Video implements Cleanable {
		@XmlElement(name = "aspect")
		private Double aspect;
		@XmlElement(name = "codec")
		private String codec;
		@XmlElement(name = "durationinseconds")
		private Integer durationInSeconds;
		@XmlElement(name = "height")
		private Integer height;
		@XmlElement(name = "width")
		private Integer width;
		@XmlElement(name = "stereomode")
		private String stereoMode;

		// Extra tags
		@XmlElement(name = "bitrate")
		private String bitrate;
		@XmlElement(name = "bitratemax")
		private String bitrateMax;
		@XmlElement(name = "bitratemode")
		private String bitrateMode;
		@XmlElement(name = "codecidinfo")
		private String codecIdInfo;
		@XmlElement(name = "container")
		private String container;
		@XmlElement(name = "duration")
		private String duration;
		@XmlElement(name = "encodedSettings")
		private String encodedSettings;
		@XmlElement(name = "format")
		private String format;
		@XmlElement(name = "language")
		private String language;
		@XmlElement(name = "longlanguage")
		private String longlanguage;
		@XmlElement(name = "multiView_Count")
		private String multiViewCount;
		@XmlElement(name = "scantype")
		private String scanType;

		@Override
		public String toString() {
			return "Video:\naspect=" + aspect + "\ncodec=" + codec + "\ndurationInSeconds=" + durationInSeconds
					+ "\nheight=" + height + "\nwidth=" + width + "\nstereoMode=" + stereoMode + "\nbitrate=" + bitrate
					+ "\nbitrateMax=" + bitrateMax + "\nbitrateMode=" + bitrateMode + "\ncodecIdInfo=" + codecIdInfo
					+ "\ncontainer=" + container + "\nduration=" + duration + "\nencodedSettings=" + encodedSettings
					+ "\nformat=" + format + "\nlanguage=" + language + "\nlonglanguage=" + longlanguage
					+ "\nmultiViewCount=" + multiViewCount + "\nscanType=" + scanType;
		}

		@Override
		public void cleanEmptyTags() {
			TagCleaner.cleanEmptyTags(this, Video.class);
		}

	}

	static class Subtitle implements Cleanable {
		@XmlElement(name = "language")
		private String language;

		// Extra tags
		@XmlElement(name = "longlanguage")
		private String longLanguage;

		@Override
		public String toString() {
			return "Subtitle [language=" + language + ", longLanguage=" + longLanguage + "]";
		}

		@Override
		public void cleanEmptyTags() {
			TagCleaner.cleanEmptyTags(this, Subtitle.class);
		}

	}

}
