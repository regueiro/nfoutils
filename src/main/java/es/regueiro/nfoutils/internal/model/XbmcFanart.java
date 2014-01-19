package es.regueiro.nfoutils.internal.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import es.regueiro.nfoutils.media.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class XbmcFanart implements Cleanable {

	@XmlElement(name = "thumb", type = XbmcThumb.class)
	private List<XbmcThumb> thumbs;
	@XmlAttribute(name = "url")
	private String url;

	public XbmcFanart() {
		thumbs = new ArrayList<>();
	}

	public List<XbmcThumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<XbmcThumb> thumbs) {
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
		for (XbmcThumb thumb : thumbs) {
			thumb.cleanEmptyTags();
		}
	}

}
