package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Media
import es.regueiro.nfoutils.internal.jaxb.Marshaller
import groovy.transform.ToString

import javax.xml.bind.JAXBException
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class MultiEpisode extends Media {

	List<Episode> episodes = new ArrayList<>()

	static MultiEpisode fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(MultiEpisode, new File(file).newReader()) as MultiEpisode
	}

	static MultiEpisode fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(MultiEpisode, new StringReader(xml)) as MultiEpisode
	}

	static MultiEpisode fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(MultiEpisode, reader) as MultiEpisode
	}
}
