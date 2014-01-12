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

		@XmlElement(name = "video")
		private Video video;
		@XmlElement(name = "audio", type = Audio.class)
		private Collection<Audio> audios;
		@XmlElement(name = "subtitle", type = Subtitle.class)
		private Collection<Subtitle> subtitles;

		public StreamDetails() {
			this.video = new Video();
			this.audios = new ArrayList<>();
			this.subtitles = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "StreamDetails [video=" + video + ", audios=" + audios + ", subtitles=" + subtitles + "]";
		}

	}

	static class Audio {

		@XmlElement(name = "channels")
		private String channels;
		@XmlElement(name = "codec")
		private String codec;
		@XmlElement(name = "language")
		private String language;
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
		private String aspect;
		@XmlElement(name = "codec")
		private String codec;
		@XmlElement(name = "durationinseconds")
		private int durationinseconds;
		@XmlElement(name = "height")
		private int height;
		@XmlElement(name = "width")
		private int width;
		@XmlElement(name = "bitrate")
		private String bitrate;
		@XmlElement(name = "encodedSettings")
		private String encodedSettings;
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
			return "Video [aspect=" + aspect + ", codec=" + codec + ", durationinseconds=" + durationinseconds
					+ ", height=" + height + ", width=" + width + ", bitrate=" + bitrate + ", encodedSettings="
					+ encodedSettings + ", language=" + language + ", longlanguage=" + longlanguage
					+ ", multiViewCount=" + multiViewCount + ", scanType=" + scanType + "]";
		}

	}

	static class Subtitle {
		@XmlElement(name = "language")
		private String language;
		@XmlElement(name = "longlanguage")
		private String longLanguage;

		@Override
		public String toString() {
			return "Subtitle [language=" + language + ", longLanguage=" + longLanguage + "]";
		}

	}
}
