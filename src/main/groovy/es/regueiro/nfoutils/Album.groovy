package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Media
import es.regueiro.nfoutils.internal.jaxb.Marshaller
import groovy.transform.ToString

import javax.xml.bind.JAXBException
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@ToString(includeNames = true, includeFields = true)
class Album extends Media {

	String title
	String musicBrainzAlbumID
	@XmlElement(name = "artist")
	List<String> artists
	@XmlElement(name = "genre")
	List<String> genres
	@XmlElement(name = "style")
	List<String> styles
	@XmlElement(name = "mood")
	List<String> moods
	@XmlElement(name = "theme")
	List<String> themes
	@XmlElement(name = "thumb")
	List<Thumb> thumbs
	List<ArtistCredits> albumArtistCredits
	@XmlElement(name = "track")
	List<ArtistCredits> tracks

	Boolean compilation
	String review
	String releasedate
	String label
	String type
	Integer year
	Double rating

	static Album fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(Album, new File(file).newReader()) as Album
	}

	static Album fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(Album, new StringReader(xml)) as Album
	}

	static Album fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(Album, reader) as Album
	}
}
