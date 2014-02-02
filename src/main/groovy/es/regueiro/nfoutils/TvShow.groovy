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

@XmlRootElement(name = "tvshow")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class TvShow extends Media {


	String id
	String title
	String showtitle
	String sorttitle
	String outline
	String plot
	String tagline

	@XmlElement(name = "genre")
	List<String> genres = new ArrayList<>()
	@XmlElement(name = "studio")
	List<String> studios = new ArrayList<>()
	@XmlElement(name = "actor", type = Actor.class)
	List<Actor> actors = new ArrayList<>()
	@XmlElement(name = "thumb", type = Thumb.class)
	List<Thumb> thumbs = new ArrayList<>()
	@XmlElement(name = "fanart", type = Fanart.class)
	List<Fanart> fanarts = new ArrayList<>()
	@XmlElement(name = "showlink")
	List<String> showlinks = new ArrayList<>()
	@XmlElement(name = "tag")
	List<String> tags = new ArrayList<>()

	EpisodeGuide episodeguide
	String uniqueid
	Integer displayseason
	Integer displayepisode
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

	/*
	 * ###Extra tags###
	 * 
	 * Tags used by media managers or media center software other than XBMC.
	 * 
	 * Included only for compatibility reasons
	 */

	// Media Elch Tags
	String tvdbid
	String imdbid

	// Media Companion tags
	String episodeactorsource
	String tvshowactorsource
	String sortorder
	String language
	String state

	// End extra tags

	List<Episode> episodedetails = new ArrayList<>()

	static TvShow fromFile(String file) throws JAXBException, IOException {
		Marshaller.unMarshall(TvShow, new File(file).newReader()) as TvShow
	}

	static TvShow fromXml(String xml) throws JAXBException, IOException {
		Marshaller.unMarshall(TvShow, new StringReader(xml)) as TvShow
	}

	static TvShow fromReader(Reader reader) throws JAXBException, IOException {
		Marshaller.unMarshall(TvShow, reader) as TvShow
	}
}
