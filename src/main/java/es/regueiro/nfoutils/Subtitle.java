package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

class Subtitle implements Cleanable {
	@XmlElement(name = "language")
	private String language;

	// Extra tags
	@XmlElement(name = "longlanguage")
	private String longLanguage;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLongLanguage() {
		return longLanguage;
	}

	public void setLongLanguage(String longLanguage) {
		this.longLanguage = longLanguage;
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Subtitle.class);
	}

	@Override
	public String toString() {
		return "Subtitle [language=" + language + ", longLanguage=" + longLanguage + "]";
	}

}