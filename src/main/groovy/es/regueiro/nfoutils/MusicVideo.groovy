package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Media
import es.regueiro.nfoutils.internal.jaxb.Marshaller
import groovy.transform.ToString
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime

import javax.xml.bind.JAXBException
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@ToString(includeNames = true, includeFields = true)
class MusicVideo extends Media {

	String id
	String title
	String album
	String track
	String outline
	String plot
	String tagline
	@XmlElement(name = "artist")
	List<String> artists
	@XmlElement(name = "genre")
	List<String> genres
	@XmlElement(name = "studio")
	List<String> studios
	@XmlElement(name = "actor", type = Actor.class)
	List<Actor> actors
	@XmlElement(name = "thumb", type = Thumb.class)
	List<Thumb> thumbs
	@XmlElement(name = "fanart", type = Fanart.class)
	List<Fanart> fanarts
	@XmlElement(name = "tag")
	List<String> tags
	EpisodeGuide episodeguide
	String uniqueid
	Integer year
	Double rating
	String votes
	Integer runtime
	LocalDate aired
	Integer playcount
	String trailer
	String mpaa
	String set
	LocalDate premiered
	LocalDate lastplayed
	Double epbookmark
	String filenameandpath
	String file
	String path
	String basepath
	String status
	String code
	Resume resume
	LocalDateTime dateadded
	Art art

	static MusicVideo fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(MusicVideo, new File(file).newReader()) as MusicVideo
	}

	static MusicVideo fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(MusicVideo, new StringReader(xml)) as MusicVideo
	}

	static MusicVideo fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(MusicVideo, reader) as MusicVideo
	}
}
