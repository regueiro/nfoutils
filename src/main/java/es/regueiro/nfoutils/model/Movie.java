package es.regueiro.nfoutils.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
// @XmlType (propOrder={"id","title","originaltititle", "sorttitle", "rating", "votes", "top250"})
public class Movie {

	private static final Logger logger = LoggerFactory.getLogger(Movie.class);

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
	private Collection<String> writers;
	@XmlElement(name = "genre", type = String.class)
	private Collection<String> genres;
	@XmlElement(name = "country", type = String.class)
	private Collection<String> countries;
	@XmlElement(name = "studio", type = String.class)
	private Collection<String> studios;
	@XmlElement(name = "actor", type = Actor.class)
	private Collection<Actor> actors;
	@XmlElement(name = "thumb", type = Thumb.class)
	private Collection<Thumb> thumbs;
	@XmlElement(name = "fanart", type = Fanart.class)
	private Collection<Fanart> fanarts;

	@XmlElement(name = "year")
	private int year;
	@XmlElement(name = "releasedate")
	private String date;
	@XmlElement(name = "rating")
	private String rating;
	@XmlElement(name = "votes")
	private String votes;
	@XmlElement(name = "top250")
	private String top250;
	@XmlElement(name = "runtime")
	private String runtime;
	@XmlElement(name = "playcount")
	private int playcount;
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
	@XmlElement(name = "fanart")
	private String fanart;

	// New tags from tinymediamanager
	@XmlElement(name = "set")
	private String set;
	@XmlElement(name = "watched")
	private boolean watched = false;
	@XmlElement(name = "tmdbid")
	private String tmdbId;
	// @XmlElement(name = "fileinfo", type=FileInfo.class)
	// private FileInfo fileinfo;
	@XmlElement(name = "premiered")
	private String premiered;
	@XmlElement(name = "tag")
	private Collection<String> tags;

	/** not supported tags, but used to retrain in NFO. */
	@XmlElement
	private String epbookmark;
	@XmlElement
	private String lastplayed;
	@XmlElement
	private String status;
	@XmlElement
	private String code;
	@XmlElement
	private String aired;
	@XmlElement
	private Object resume;
	@XmlElement
	private String dateadded;
	@XmlElement
	private Object keywords;
	@XmlElement
	private Object url;

	public Movie() {
		this.directors = new ArrayList<>();
		this.writers = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.countries = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.actors = new ArrayList<>();
		this.fanarts = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Movie [folder=" + folder + "\nnfo=" + nfo + "\nimdbID=" + imdbID + "\ntitle=" + title
				+ "\noriginalTitle=" + originalTitle + "\nsortTitle=" + sortTitle + "\noutline=" + outline + "\nplot="
				+ plot + "\ntagline=" + tagline + "\ndirectors=" + directors + "\nwriters=" + writers + "\ngenres="
				+ genres + "\ncountries=" + countries + "\nstudios=" + studios + "\nactors=" + actors + "\nthumbs="
				+ thumbs + "\nfanarts=" + fanarts + "\nyear=" + year + "\ndate=" + date + "\nrating=" + rating
				+ "\nvotes=" + votes + "\ntop250=" + top250 + "\nruntime=" + runtime + "\nplaycount=" + playcount
				+ "\ntrailer=" + trailer + "\ncertification=" + certification + "\nmpaa=" + mpaa + "\nposter=" + poster
				+ "\nbanner=" + banner + "\nfanart=" + fanart + "]";
	}

}
