package es.regueiro.nfoutils;

import java.io.IOException;
import java.nio.file.Path;
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

import es.regueiro.nfoutils.interfaces.Media;
import es.regueiro.nfoutils.internal.jaxb.Marshaller;
import es.regueiro.nfoutils.internal.util.TagCleaner;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie extends NfoFile implements Media {

	private static final Logger logger = LoggerFactory.getLogger(Movie.class);

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
	@XmlElement(name = "actor", type = Actor.class)
	private List<Actor> actors;
	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlElement(name = "fanart", type = Fanart.class)
	private List<Fanart> fanarts;
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
	private Resume resume;
	@XmlElement(name = "dateadded")
	private LocalDateTime dateadded;
	@XmlElement(name = "art")
	private Art art;

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
	@XmlElement(name = "fileinfo", type = FileInfo.class)
	private List<FileInfo> fileinfos;

	public static Movie fromFile(Path file) throws JAXBException, IOException {
		return Marshaller.unMarshall(file, Movie.class);
	}

	public Movie() {
		this.directors = new ArrayList<>();
		this.credits = new ArrayList<>();
		this.genres = new ArrayList<>();
		this.countries = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.actors = new ArrayList<>();
		this.thumbs = new ArrayList<>();
		this.fanarts = new ArrayList<>();
		this.tags = new ArrayList<>();
		this.fileinfos = new ArrayList<>();
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getSortTitle() {
		return sortTitle;
	}

	public void setSortTitle(String sortTitle) {
		this.sortTitle = sortTitle;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getCredits() {
		return credits;
	}

	public void setCredits(List<String> credits) {
		this.credits = credits;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<String> getStudios() {
		return studios;
	}

	public void setStudios(List<String> studios) {
		this.studios = studios;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Thumb> getThumbs() {
		return thumbs;
	}

	public void setThumbs(List<Thumb> thumbs) {
		this.thumbs = thumbs;
	}

	public List<Fanart> getFanarts() {
		return fanarts;
	}

	public void setFanarts(List<Fanart> fanarts) {
		this.fanarts = fanarts;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	public Integer getTop250() {
		return top250;
	}

	public void setTop250(Integer top250) {
		this.top250 = top250;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public Integer getPlaycount() {
		return playcount;
	}

	public void setPlaycount(Integer playcount) {
		this.playcount = playcount;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getMpaa() {
		return mpaa;
	}

	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public LocalDate getPremiered() {
		return premiered;
	}

	public void setPremiered(LocalDate premiered) {
		this.premiered = premiered;
	}

	public LocalDate getLastplayed() {
		return lastplayed;
	}

	public void setLastplayed(LocalDate lastplayed) {
		this.lastplayed = lastplayed;
	}

	public Double getEpbookmark() {
		return epbookmark;
	}

	public void setEpbookmark(Double epbookmark) {
		this.epbookmark = epbookmark;
	}

	public String getFilenameandpath() {
		return filenameandpath;
	}

	public void setFilenameandpath(String filenameandpath) {
		this.filenameandpath = filenameandpath;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getAired() {
		return aired;
	}

	public void setAired(LocalDate aired) {
		this.aired = aired;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public LocalDateTime getDateadded() {
		return dateadded;
	}

	public void setDateadded(LocalDateTime dateadded) {
		this.dateadded = dateadded;
	}

	public Art getArt() {
		return art;
	}

	public void setArt(Art art) {
		this.art = art;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTmdbId() {
		return tmdbId;
	}

	public void setTmdbId(String tmdbId) {
		this.tmdbId = tmdbId;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Boolean getWatched() {
		return watched;
	}

	public void setWatched(Boolean watched) {
		this.watched = watched;
	}

	public List<FileInfo> getFileinfos() {
		return fileinfos;
	}

	public void setFileinfos(List<FileInfo> fileinfos) {
		this.fileinfos = fileinfos;
	}

	@Override
	public void save() throws IOException, JAXBException {
		long start = 0;
		if (logger.isTraceEnabled()) {
			start = System.nanoTime();
		}
		cleanEmptyTags();
		Marshaller.marshall(this, Movie.class);
		if (logger.isTraceEnabled()) {
			long end = System.nanoTime();
			logger.trace("Marshalling took {} nanoseconds ({} seconds)", (end - start), (end - start) / 10e9);
		}
	}

	@Override
	public void cleanEmptyTags() {
		TagCleaner.cleanEmptyTags(this, Movie.class);
	}

	@Override
	public String toString() {
		return "Movie:\nnfoFile=" + getNfoFile() + "\nimdbID=" + imdbID + "\ntitle=" + title + "\noriginalTitle="
				+ originalTitle + "\nsortTitle=" + sortTitle + "\noutline=" + outline + "\nplot=" + plot + "\ntagline="
				+ tagline + "\ndirectors=" + directors + "\ncredits=" + credits + "\ngenres=" + genres + "\ncountries="
				+ countries + "\nstudios=" + studios + "\nactors=" + actors + "\nthumbs=" + thumbs + "\nfanarts="
				+ fanarts + "\ntags=" + tags + "\nyear=" + year + "\nrating=" + rating + "\nvotes=" + votes
				+ "\ntop250=" + top250 + "\nruntime=" + runtime + "\nplaycount=" + playcount + "\ntrailer=" + trailer
				+ "\nmpaa=" + mpaa + "\nset=" + set + "\npremiered=" + premiered + "\nlastplayed=" + lastplayed
				+ "\nepbookmark=" + epbookmark + "\nfilenameandpath=" + filenameandpath + "\nfile=" + file + "\npath="
				+ path + "\nbasepath=" + basepath + "\nstatus=" + status + "\ncode=" + code + "\naired=" + aired
				+ "\nresume=" + resume + "\ndateadded=" + dateadded + "\nart=" + art + "\ncertification="
				+ certification + "\nreleaseDate=" + releaseDate + "\ntmdbId=" + tmdbId + "\nimdbId=" + imdbId
				+ "\nwatched=" + watched + "\nfileinfos=" + fileinfos;
	}

}
