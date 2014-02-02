@XmlJavaTypeAdapters([@XmlJavaTypeAdapter(type = Double.class, value = DoubleAdapter.class),
@XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class),
@XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeAdapter.class)])
package es.regueiro.nfoutils



import es.regueiro.nfoutils.internal.jaxb.adapters.DoubleAdapter
import es.regueiro.nfoutils.internal.jaxb.adapters.LocalDateAdapter
import es.regueiro.nfoutils.internal.jaxb.adapters.LocalDateTimeAdapter
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters