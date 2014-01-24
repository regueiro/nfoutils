package es.regueiro.nfoutils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Fanart implements Cleanable {

	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlAttribute(name = "url")
	private String url;

	public Fanart() {
		thumbs = new ArrayList<>();
	}

	public List<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Fanart:\nurl=" + url + "\nthumbs=" + thumbs;
	}

	@Override
	public void cleanEmptyTags() {
		if (url != null && url.isEmpty()) {
			url = null;
		}
		for (Thumb thumb : thumbs) {
			thumb.cleanEmptyTags();
		}
	}

}
