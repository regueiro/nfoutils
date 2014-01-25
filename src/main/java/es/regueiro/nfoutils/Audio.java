package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlAccessorType(XmlAccessType.FIELD)
class Audio implements Cleanable {

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

	public Integer getChannels() {
		return channels;
	}

	public void setChannels(Integer channels) {
		this.channels = channels;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBitrate() {
		return bitrate;
	}

	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}

	public String getLongLanguage() {
		return longLanguage;
	}

	public void setLongLanguage(String longLanguage) {
		this.longLanguage = longLanguage;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Audio.class);
	}

	@Override
	public String toString() {
		return "Audio [channels=" + channels + ", codec=" + codec + ", language=" + language + ", bitrate=" + bitrate
				+ ", longLanguage=" + longLanguage + "]";
	}

}