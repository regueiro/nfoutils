@XmlJavaTypeAdapters({ @XmlJavaTypeAdapter(type = Double.class, value = DoubleAdapter.class),
		@XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class),
		@XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeAdapter.class) })
package es.regueiro.nfoutils.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import es.regueiro.nfoutils.jaxb.adapters.*;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

