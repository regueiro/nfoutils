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
	// movie fileinfo streamdetails
	// movie fileinfo streamdetails audio
	// movie fileinfo streamdetails audio channels
	// movie fileinfo streamdetails audio codec
	// movie fileinfo streamdetails audio language
	// movie fileinfo streamdetails subtitle
	// movie fileinfo streamdetails subtitle language
	// movie fileinfo streamdetails video
	// movie fileinfo streamdetails video aspect
	// movie fileinfo streamdetails video codec
	// movie fileinfo streamdetails video durationinseconds
	// movie fileinfo streamdetails video height
	// movie fileinfo streamdetails video width

	/*
	 * inner class holding file informations
	 */
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

		@Override
		public String toString() {
			return "Audio [channels=" + channels + ", codec=" + codec + ", language=" + language + "]";
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

		@Override
		public String toString() {
			return "Video [codec=" + codec + ", aspect=" + aspect + ", width=" + width + ", height=" + height
					+ ", durationinseconds=" + durationinseconds + "]";
		}

	}

	static class Subtitle {
		@XmlElement(name = "language")
		private String language;

		@Override
		public String toString() {
			return "Subtitle [language=" + language + "]";
		}
	}
}
