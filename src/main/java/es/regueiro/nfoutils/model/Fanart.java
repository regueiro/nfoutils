package es.regueiro.nfoutils.model;

import java.util.Arrays;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "fanart")
public class Fanart {

	@XmlElement(name = "thumb", type = Thumb.class)
	private Collection<Thumb> thumbs;

	public Collection<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(Collection<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	@Override
	public String toString() {
		return "Fanart [thumbs=" + Arrays.toString(thumbs.toArray()) + "]";
	}

}
