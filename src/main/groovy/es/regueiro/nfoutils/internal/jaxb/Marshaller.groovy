package es.regueiro.nfoutils.internal.jaxb

import es.regueiro.nfoutils.Episode
import es.regueiro.nfoutils.Movie
import es.regueiro.nfoutils.MultiEpisode
import es.regueiro.nfoutils.TvShow
import groovy.util.logging.Slf4j
import org.xml.sax.SAXException

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException

@Slf4j
class Marshaller {

	def static final String LINE_SEPARATOR = System.getProperty("line.separator")
	def static final String ENCODING = "UTF-8"


	private static createMarshaller(Class type) throws JAXBException {
		def jaxbMarshaller = JAXBContext.newInstance(type).createMarshaller()

		jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true)
		jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, ENCODING)
		jaxbMarshaller
	}

	static marshall(object, Class type, Writer output) throws JAXBException, IOException {
		if (type == MultiEpisode) {
			def marshaller = createMarshaller Episode
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true)
			output.write('<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>')

			(object as MultiEpisode).episodes.each {
				marshaller.marshal(it, output)
				output.write LINE_SEPARATOR
			}
		} else {
			createMarshaller(type).marshal(object, output)
		}

		output
	}

	private static createUnmarshaller(Class type) throws JAXBException {
		JAXBContext.newInstance(type).createUnmarshaller()
	}

	static unMarshall(Class type, Reader input) throws JAXBException, IOException {
		def object

		if (type == MultiEpisode) {
			def unmarshaller = createUnmarshaller Episode
			def episodes = input.text.split('</episodedetails>')

			object = new MultiEpisode()

			episodes.each {
				if (it.contains('<episodedetails>')) {
					def reader = new StringReader(it + '</episodedetails>')
					object.episodes.add unmarshaller.unmarshal(reader)
				}
			}
		} else {
			object = createUnmarshaller(type).unmarshal input
		}

		object
	}


	static Class detectFileType(Reader input) throws JAXBException, IOException {
		try {
			def document = new XmlSlurper().parse input

			switch (document.name()) {
				case "movie":
					return Movie
				case "tvshow":
					return TvShow
				case "episodedetails":
					return Episode
				default:
					return null;
			}

		} catch (SAXException e) {
			try {
				unMarshall(MultiEpisode, input)
				MultiEpisode
			} catch (JAXBException e1) {
				log.error(e.message, e)
				log.error(e1.message, e1)
				return null
			}
		}
	}
}