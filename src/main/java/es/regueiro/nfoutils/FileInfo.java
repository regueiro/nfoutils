package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlAccessorType(XmlAccessType.FIELD)
public class FileInfo implements Cleanable {

	@XmlElement(name = "streamdetails")
	StreamDetails streamDetails;

	public FileInfo() {
		this.streamDetails = new StreamDetails();
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, FileInfo.class);
	}

	@Override
	public String toString() {
		return "Fileinfo [streamDetails=" + streamDetails + "]";
	}

}
