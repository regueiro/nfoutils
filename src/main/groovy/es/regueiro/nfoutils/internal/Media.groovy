package es.regueiro.nfoutils.internal

import es.regueiro.nfoutils.internal.jaxb.Marshaller
import groovy.util.logging.Slf4j

import javax.xml.bind.JAXBException
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

@Slf4j
@XmlAccessorType(XmlAccessType.FIELD)
abstract class Media extends Cleanable {

	def toFile(String file) throws IOException, JAXBException {
		def start = 0
		if (log.isTraceEnabled()) {
			start = System.nanoTime()
		}

		cleanEmptyTags()
		Marshaller.marshall(this, this.class, new File(file).newWriter())

		if (log.isTraceEnabled()) {
			def end = System.nanoTime()
			log.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9)
		}
	}

	def String toXml() throws IOException, JAXBException {
		def start = 0
		if (log.isTraceEnabled()) {
			start = System.nanoTime()
		}

		cleanEmptyTags()
		def output = new StringWriter()
		Marshaller.marshall(this, this.class, output)

		if (log.isTraceEnabled()) {
			def end = System.nanoTime()
			log.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9)
		}

		output.toString()
	}
}
