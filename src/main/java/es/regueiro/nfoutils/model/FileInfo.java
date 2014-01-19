package es.regueiro.nfoutils.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "fileinfo")
public class FileInfo {

	@XmlElement(name = "streamdetails")
	StreamDetails streamDetails;

	public FileInfo() {
		this.streamDetails = new StreamDetails();
	}

	@Override
	public String toString() {
		return "Fileinfo [streamDetails=" + streamDetails + "]";
	}

	static class StreamDetails {

		@XmlElement(name = "video", type = Video.class)
		private Collection<Video> videos;
		@XmlElement(name = "audio", type = Audio.class)
		private Collection<Audio> audios;
		@XmlElement(name = "subtitle", type = Subtitle.class)
		private Collection<Subtitle> subtitles;

		public StreamDetails() {
			this.videos = new ArrayList<>();
			this.audios = new ArrayList<>();
			this.subtitles = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "StreamDetails [videos=" + videos + ", audios=" + audios + ", subtitles=" + subtitles + "]";
		}

	}

	static class Audio {

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

	}

	static class Video {
		@XmlElement(name = "aspect")
		private Float aspect;
		@XmlElement(name = "codec")
		private String codec;
		@XmlElement(name = "durationinseconds")
		private Integer durationInSeconds;
		@XmlElement(name = "height")
		private Integer height;
		@XmlElement(name = "width")
		private Integer width;

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
		@XmlElement(name = "stereomode")
		private String stereomode;

		@Override
		public String toString() {
			return "Video [aspect=" + aspect + ", codec=" + codec + ", durationInSeconds=" + durationInSeconds
					+ ", height=" + height + ", width=" + width + ", bitrate=" + bitrate + ", bitrateMax=" + bitrateMax
					+ ", bitrateMode=" + bitrateMode + ", codecIdInfo=" + codecIdInfo + ", container=" + container
					+ ", duration=" + duration + ", encodedSettings=" + encodedSettings + ", format=" + format
					+ ", language=" + language + ", longlanguage=" + longlanguage + ", multiViewCount="
					+ multiViewCount + ", scanType=" + scanType + ", stereomode=" + stereomode + "]";
		}

	}

	static class Subtitle {
		@XmlElement(name = "language")
		private String language;

		// Extra tags
		@XmlElement(name = "longlanguage")
		private String longLanguage;

		@Override
		public String toString() {
			return "Subtitle [language=" + language + ", longLanguage=" + longLanguage + "]";
		}

	}
}
