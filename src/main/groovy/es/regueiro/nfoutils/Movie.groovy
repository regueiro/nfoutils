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
class Movie extends Media {

	String id
	String title
	String originaltitle
	String sorttitle
	String outline
	String plot
	String tagline

	@XmlElement(name = "director")
	List<String> directors
	@XmlElement(name = "credits")
	List<String> credits
	@XmlElement(name = "genre")
	List<String> genres
	@XmlElement(name = "country")
	List<String> countries
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

	Integer year
	Double rating
	String votes
	Integer top250
	Integer runtime
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
	LocalDate aired
	Resume resume
	LocalDateTime dateadded
	Art art

	/*
	 * Extra tags
	 * ==========
	 *
	 * Tags used by media managers or media center software other than XBMC.
	 *
	 * Included only for compatibility reasons
	 */

	String certification
	LocalDate releasedate
	String tmdbid
	String imdbid
	Boolean watched

	// End extra tags
	@XmlElement(name = "fileinfo", type = FileInfo.class)
	List<FileInfo> fileinfos


	static Movie fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(Movie, new File(file).newReader()) as Movie
	}

	static Movie fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(Movie, new StringReader(xml)) as Movie
	}

	static Movie fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(Movie, reader) as Movie
	}

}
