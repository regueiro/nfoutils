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

@XmlRootElement(name = "episodedetails")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Episode extends Media {


	String id
	String title
	String showtitle
	String outline
	String plot
	String tagline
	@XmlElement(name = "studio")
	List<String> studios = new ArrayList<>()
	@XmlElement(name = "director")
	List<String> directors = new ArrayList<>()
	@XmlElement(name = "credits")
	List<String> credits = new ArrayList<>()
	@XmlElement(name = "actor", type = Actor.class)
	List<Actor> actors = new ArrayList<>()
	@XmlElement(name = "thumb", type = Thumb.class)
	List<Thumb> thumbs = new ArrayList<>()
	@XmlElement(name = "uniqueid")
	String uniqueid
	Integer displayseason
	Integer displayepisode
	Integer displayafterseason
	Integer season
	Integer episode
	Integer year
	Double rating
	String votes
	Integer top250
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

	@XmlElement(name = "fileinfo", type = FileInfo.class)
	List<FileInfo> fileinfos = new ArrayList<>()

	/*
	 * ###Extra tags###
	 * 
	 * Tags used by media managers or media center software other than XBMC.
	 * 
	 * Included only for compatibility reasons
	 */

	// Unknown Tags
	String showid


	static Episode fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(Episode, new File(file).newReader()) as Episode
	}

	static Episode fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(Episode, new StringReader(xml)) as Episode
	}

	static Episode fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(Episode, reader) as Episode
	}
}
