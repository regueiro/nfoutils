package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import es.regueiro.nfoutils.interfaces.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class SeasonArt implements Cleanable {
	@XmlAttribute(name = "num")
	private Integer num;

	private String fanart;
	private String poster;
	private String banner;

	public String getFanart() {
		return fanart;
	}

	public void setFanart(String fanart) {
		this.fanart = fanart;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	@Override
	public void cleanEmptyTags() {
		if (fanart != null && fanart.isEmpty()) {
			fanart = null;
		}
		if (poster != null && poster.isEmpty()) {
			poster = null;
		}
		if (banner != null && banner.isEmpty()) {
			banner = null;
		}
	}

	@Override
	public String toString() {
		return "SeasonArt [fanart=" + fanart + ", poster=" + poster + ", banner=" + banner + "]";
	}

}
