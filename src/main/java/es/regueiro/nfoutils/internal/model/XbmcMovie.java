package es.regueiro.nfoutils.internal.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.util.TagCleaner;
import es.regueiro.nfoutils.media.Movie;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class XbmcMovie extends XbmcNfoFile implements Movie {

	private static final Logger logger = LoggerFactory.getLogger(XbmcMovie.class);

	@XmlElement(name = "id")
	private String imdbID;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "originaltitle")
	private String originalTitle;
	@XmlElement(name = "sorttitle")
	private String sortTitle;
	@XmlElement(name = "outline")
	private String outline;
	@XmlElement(name = "plot")
	private String plot;
	@XmlElement(name = "tagline")
	private String tagline;

	@XmlElement(name = "director", type = String.class)
	private List<String> directors;
	@XmlElement(name = "credits", type = String.class)
	private List<String> credits;
	@XmlElement(name = "genre", type = String.class)
	private List<String> genres;
	@XmlElement(name = "country", type = String.class)
	private List<String> countries;
	@XmlElement(name = "studio", type = String.class)
	private List<String> studios;
	@XmlElement(name = "actor", type = XbmcActor.class)
	private List<XbmcActor> actors;
	@XmlElement(name = "thumb", type = XbmcThumb.class)
	private List<XbmcThumb> thumbs;
	@XmlElement(name = "fanart", type = XbmcFanart.class)
	private List<XbmcFanart> fanarts;
	@XmlElement(name = "tag", type = String.class)
	private List<String> tags;

	@XmlElement(name = "year")
	private Integer year;
	@XmlElement(name = "rating")
	private Double rating;
	@XmlElement(name = "votes")
	private String votes;
	@XmlElement(name = "top250")
	private Integer top250;
	@XmlElement(name = "runtime")
	private Integer runtime;
	@XmlElement(name = "playcount")
	private Integer playcount;
	@XmlElement(name = "trailer")
	private String trailer;
	@XmlElement(name = "mpaa")
	private String mpaa;
	@XmlElement(name = "set")
	private String set;
	@XmlElement(name = "premiered")
	private LocalDate premiered;

	@XmlElement(name = "lastplayed")
	private LocalDate lastplayed;
	@XmlElement(name = "epbookmark")
	private Double epbookmark;
	@XmlElement(name = "filenameandpath")
	private String filenameandpath;
	@XmlElement(name = "file")
	private String file;
	@XmlElement(name = "path")
	private String path;
	@XmlElement(name = "basepath")
	private String basepath;
	@XmlElement(name = "status")
	private String status;
	@XmlElement(name = "code")
	private String code;
	@XmlElement(name = "aired")
	private LocalDate aired;
	@XmlElement(name = "resume")
	private XbmcResume resume;
	@XmlElement(name = "dateadded")
	private LocalDateTime dateadded;
	@XmlElement(name = "art")
	private XbmcArt art;

	/*
	 * ###Extra tags###
	 * 
	 * Tags used by media managers or media center software other than XBMC.
	 * 
	 * Included only for compatibility reasons
	 */

	@XmlElement(name = "certification")
	private String certification;
	@XmlElement(name = "releasedate")
	private LocalDate releaseDate;
	@XmlElement(name = "tmdbid")
	private String tmdbId;
	@XmlElement(name = "imdbid")
	private String imdbId;
	@XmlElement(name = "watched")
	private Boolean watched;

	// End extra tags
	@XmlElement(name = "fileinfo", type = XbmcFileInfo.class)
	private List<XbmcFileInfo> fileinfos;

	public XbmcMovie() {
		this.directors = new ArrayList<>();
		this.credits = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.countries = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.actors = new ArrayList<>();
		this.fanarts = new ArrayList<>();
		this.tags = new ArrayList<>();
		this.fileinfos = new ArrayList<>();
	}

	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, XbmcMovie.class);
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, XbmcMovie.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

}
