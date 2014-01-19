package es.regueiro.nfoutils.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "thumb")
public class Thumb {

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
	public String toString() {
		return "Thumb [preview=" + preview + ", type=" + type + ", season=" + season + ", thumb=" + thumb + "]";
	}

}
