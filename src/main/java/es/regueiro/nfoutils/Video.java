package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

class Video implements Cleanable {
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

	public Double getAspect() {
		return aspect;
	}

	public void setAspect(Double aspect) {
		this.aspect = aspect;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public Integer getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(Integer durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getStereoMode() {
		return stereoMode;
	}

	public void setStereoMode(String stereoMode) {
		this.stereoMode = stereoMode;
	}

	public String getBitrate() {
		return bitrate;
	}

	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}

	public String getBitrateMax() {
		return bitrateMax;
	}

	public void setBitrateMax(String bitrateMax) {
		this.bitrateMax = bitrateMax;
	}

	public String getBitrateMode() {
		return bitrateMode;
	}

	public void setBitrateMode(String bitrateMode) {
		this.bitrateMode = bitrateMode;
	}

	public String getCodecIdInfo() {
		return codecIdInfo;
	}

	public void setCodecIdInfo(String codecIdInfo) {
		this.codecIdInfo = codecIdInfo;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEncodedSettings() {
		return encodedSettings;
	}

	public void setEncodedSettings(String encodedSettings) {
		this.encodedSettings = encodedSettings;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLonglanguage() {
		return longlanguage;
	}

	public void setLonglanguage(String longlanguage) {
		this.longlanguage = longlanguage;
	}

	public String getMultiViewCount() {
		return multiViewCount;
	}

	public void setMultiViewCount(String multiViewCount) {
		this.multiViewCount = multiViewCount;
	}

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Video.class);
	}

	@Override
	public String toString() {
		return "Video [aspect=" + aspect + ", codec=" + codec + ", durationInSeconds=" + durationInSeconds
				+ ", height=" + height + ", width=" + width + ", stereoMode=" + stereoMode + ", bitrate=" + bitrate
				+ ", bitrateMax=" + bitrateMax + ", bitrateMode=" + bitrateMode + ", codecIdInfo=" + codecIdInfo
				+ ", container=" + container + ", duration=" + duration + ", encodedSettings=" + encodedSettings
				+ ", format=" + format + ", language=" + language + ", longlanguage=" + longlanguage
				+ ", multiViewCount=" + multiViewCount + ", scanType=" + scanType + "]";
	}

}