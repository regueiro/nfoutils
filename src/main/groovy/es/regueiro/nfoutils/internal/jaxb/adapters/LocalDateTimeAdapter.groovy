package es.regueiro.nfoutils.internal.jaxb.adapters

import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

import javax.xml.bind.annotation.adapters.XmlAdapter

class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	private static final formatter = DateTimeFormat.forPattern 'yyyy-MM-dd HH:mm:ss'

	LocalDateTime unmarshal(String v) {
		LocalDateTime.parse v, formatter
	}

	String marshal(LocalDateTime v) {
		v.toString formatter
	}

}
