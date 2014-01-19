package es.regueiro.nfoutils.internal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

import es.regueiro.nfoutils.media.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class XbmcThumb implements Cleanable {

	@XmlAttribute(name = "preview")
	private String preview;
	@XmlAttribute(name = "type")
	private String type;
	@XmlAttribute(name = "season")
	private String season;
	@XmlValue
	private String thumb;

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@Override
	public void cleanEmptyTags() {
		if (preview != null && preview.isEmpty()) {
			preview = null;
		}

		if (type != null && type.isEmpty()) {
			type = null;
		}

		if (season != null && season.isEmpty()) {
			season = null;
		}

		if (thumb != null && thumb.isEmpty()) {
			thumb = null;
		}
	}

	@Override
	public String toString() {
		return "Thumb [preview=" + preview + ", type=" + type + ", season=" + season + ", thumb=" + thumb + "]";
	}

}
