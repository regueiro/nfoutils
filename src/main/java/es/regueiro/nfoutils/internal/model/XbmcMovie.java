package es.regueiro.nfoutils.internal.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.media.Movie;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
// @XmlType (propOrder={"id","title","originaltititle", "sorttitle", "rating", "votes", "top250"})
public class XbmcMovie extends XbmcNfoFile implements Movie {

	private static final Logger logger = LoggerFactory.getLogger(XbmcMovie.class);

	// private MediaFolder mediaFolder;
	@XmlTransient
	private String folder;
	@XmlTransient
	private String nfo;
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
	private Collection<String> directors;
	@XmlElement(name = "credits", type = String.class)
	private Collection<String> credits;
	@XmlElement(name = "genre", type = String.class)
	private Collection<String> genres;
	@XmlElement(name = "country", type = String.class)
	private Collection<String> countries;
	@XmlElement(name = "studio", type = String.class)
	private Collection<String> studios;
	@XmlElement(name = "actor", type = XbmcActor.class)
	private Collection<XbmcActor> actors;
	@XmlElement(name = "thumb", type = XbmcThumb.class)
	private Collection<XbmcThumb> thumbs;
	@XmlElement(name = "fanart", type = XbmcFanart.class)
	private Collection<XbmcFanart> fanarts;

	@XmlElement(name = "year")
	private Integer year;
	@XmlElement(name = "releasedate")
	private String date;
	@XmlElement(name = "rating")
	private Float rating;
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
	@XmlElement(name = "certification")
	private String certification;
	@XmlElement(name = "mpaa")
	private String mpaa;
	@XmlElement(name = "poster")
	private String poster;
	@XmlElement(name = "banner")
	private String banner;
	@XmlElement(name = "set")
	private String set;
	@XmlElement(name = "watched")
	private Boolean watched;
	@XmlElement(name = "tmdbid")
	private String tmdbId;
	@XmlElement(name = "premiered")
	private LocalDate premiered;
	@XmlElement(name = "tag")
	private Collection<String> tags;

	@XmlElement(name = "lastplayed")
	private LocalDate lastplayed;
	@XmlElement(name = "epbookmark")
	private Float epbookmark;
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

	@XmlElement(name = "fileinfo", type = XbmcFileInfo.class)
	private Collection<XbmcFileInfo> fileinfos;

	// Extra tags from tinymediamanager
	@XmlElement
	private Object keywords;
	@XmlElement
	private Object url;

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
		for (Field field : XbmcMovie.class.getDeclaredFields()) {
			if (field.getType().equals(String.class)) {
				field.setAccessible(true);
				Object tempField;
				try {
					tempField = field.get(this);
					if (tempField != null) {
						String value = (String) tempField;

						if (value.equals("")) {
							field.set(this, null);
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Movie [folder=" + folder + "\n nfo=" + nfo + "\n imdbID=" + imdbID + "\n title=" + title
				+ "\n originalTitle=" + originalTitle + "\n sortTitle=" + sortTitle + "\n outline=" + outline
				+ "\n plot=" + plot + "\n tagline=" + tagline + "\n directors=" + directors + "\n writers=" + credits
				+ "\n genres=" + genres + "\n countries=" + countries + "\n studios=" + studios + "\n actors=" + actors
				+ "\n thumbs=" + thumbs + "\n fanarts=" + fanarts + "\n year=" + year + "\n date=" + date
				+ "\n rating=" + rating + "\n votes=" + votes + "\n top250=" + top250 + "\n runtime=" + runtime
				+ "\n playcount=" + playcount + "\n trailer=" + trailer + "\n certification=" + certification
				+ "\n mpaa=" + mpaa + "\n poster=" + poster + "\n banner=" + banner + "\n set=" + set + "\n watched="
				+ watched + "\n tmdbId=" + tmdbId + "\n premiered=" + premiered + "\n tags=" + tags + "\n lastplayed="
				+ lastplayed + "\n epbookmark=" + epbookmark + "\n filenameandpath=" + filenameandpath + "\n file="
				+ file + "\n path=" + path + "\n basepath=" + basepath + "\n status=" + status + "\n code=" + code
				+ "\n aired=" + aired + "\n resume=" + resume + "\n dateadded=" + dateadded + "\n art=" + art
				+ "\n fileinfos=" + fileinfos + "\n keywords=" + keywords + "\n url=" + url + "]";
	}

	@Override
	public void save() throws IOException, JAXBException {
		Marshaller.marshall(this, XbmcMovie.class);
	}

}