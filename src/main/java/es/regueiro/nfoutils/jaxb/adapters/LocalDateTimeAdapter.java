package es.regueiro.nfoutils.jaxb.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
	private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	public LocalDateTime unmarshal(String v) throws Exception {

		return LocalDateTime.parse(v, formatter);
	}

	public String marshal(LocalDateTime v) throws Exception {
		return v.toString(formatter);
	}

}
