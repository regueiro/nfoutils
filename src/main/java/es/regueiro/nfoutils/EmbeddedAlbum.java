package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import es.regueiro.nfoutils.interfaces.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class EmbeddedAlbum implements Cleanable {

	private String title;
	private String year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public void cleanEmptyTags() {
		if (title != null && title.isEmpty()) {
			title = null;
		}
		if (year != null && year.isEmpty()) {
			year = null;
		}
	}

	@Override
	public String toString() {
		return "XbmcEmbeddedAlbum [title=" + title + ", year=" + year + "]";
	}

}
