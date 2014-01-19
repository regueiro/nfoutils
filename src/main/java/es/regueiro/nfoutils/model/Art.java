package es.regueiro.nfoutils.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Art {

	private String fanart;
	private String poster;
	private String banner;
	private String clearart;
	private String clearlogo;
	private String landscape;
	@XmlElement(name = "season")
	private List<SeasonArt> seasonArts;

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

	public String getClearart() {
		return clearart;
	}

	public void setClearart(String clearart) {
		this.clearart = clearart;
	}

	public String getClearlogo() {
		return clearlogo;
	}

	public void setClearlogo(String clearlogo) {
		this.clearlogo = clearlogo;
	}

	public String getLandscape() {
		return landscape;
	}

	public void setLandscape(String landscape) {
		this.landscape = landscape;
	}

	public List<SeasonArt> getSeasonArts() {
		return seasonArts;
	}

	public void setSeasonArts(List<SeasonArt> seasonArts) {
		this.seasonArts = seasonArts;
	}

	@Override
	public String toString() {
		return "Art [fanart=" + fanart + ", poster=" + poster + ", banner=" + banner + ", clearart=" + clearart
				+ ", clearlogo=" + clearlogo + ", landscape=" + landscape + ", seasonArts=" + seasonArts + "]";
	}

}
