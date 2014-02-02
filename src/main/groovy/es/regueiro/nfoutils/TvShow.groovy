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
	@XmlElement(name = "showtitle")
	String showTitle
	@XmlElement(name = "sorttitle")
	String sortTitle
	String outline
	String plot
	String tagline

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
	@XmlElement(name = "showlink")
	List<String> showlinks
	@XmlElement(name = "tag")
	List<String> tags

	@XmlElement(name = "episodeguide", type = EpisodeGuide.class)
	EpisodeGuide episodeGuide
	@XmlElement(name = "uniqueid")
	String uniqueId
	@XmlElement(name = "displayseason")
	Integer displaySeason
	@XmlElement(name = "displayepisode")
	Integer displayEpisode
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
	@XmlElement(name = "tvdbid")
	String tvdbID
	@XmlElement(name = "imdbid")
	String imdbID

	// Media Companion tags
	@XmlElement(name = "episodeactorsource")
	String episodeActorSource
	@XmlElement(name = "tvshowactorsource")
	String tvShowActorSource
	@XmlElement(name = "sortorder")
	String sortOrder
	String language
	String state

	// End extra tags

	@XmlElement(name = "episodedetails", type = Episode.class)
	List<Episode> episodeDetails

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
