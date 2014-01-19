package es.regueiro.nfoutils.internal.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "episodeguide")
public class XbmcEpisodeGuide {

	@XmlElement
	private String url;
	@XmlAttribute
	private String cache;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	@Override
	public String toString() {
		return "EpisodeGuide:\nurl=" + url + "\ncache=" + cache;
	}

}
