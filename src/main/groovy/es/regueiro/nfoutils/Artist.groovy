package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Media
import es.regueiro.nfoutils.internal.jaxb.Marshaller
import groovy.transform.ToString

import javax.xml.bind.JAXBException
@javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Artist extends Media {

	String name
	String musicBrainzArtistID

	@XmlElement(name = "genre")
	List<String> genres
	@XmlElement(name = "style")
	List<String> styles
	@XmlElement(name = "mood")
	List<String> moods
	List<String> yearsactive
	List<String> instruments
	@XmlElement(name = "album", type = EmbeddedAlbum.class)
	List<EmbeddedAlbum> albums
	@XmlElement(name = "thumb", type = Thumb.class)
	List<Thumb> thumbs
	@XmlElement(name = "fanart", type = Fanart.class)
	List<Fanart> fanarts

	String born
	String formed
	String biography
	String died
	String disbanded

	String path

	static Artist fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(Artist, new File(file).newReader()) as Artist
	}

	static Artist fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(Artist, new StringReader(xml)) as Artist
	}

	static Artist fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(Artist, reader) as Artist
	}
}
