package es.regueiro.nfoutils.internal.jaxb.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v, formatter);
	}

	public String marshal(LocalDate v) throws Exception {
		return v.toString(formatter);
	}

}
