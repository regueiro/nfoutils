package es.regueiro.nfoutils.internal.jaxb.adapters

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

import javax.xml.bind.annotation.adapters.XmlAdapter

class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	private static final formatter = DateTimeFormat.forPattern 'yyyy-MM-dd'

	LocalDate unmarshal(String v) {
		LocalDate.parse v, formatter
	}

	String marshal(LocalDate v) {
		v.toString formatter
	}

}
