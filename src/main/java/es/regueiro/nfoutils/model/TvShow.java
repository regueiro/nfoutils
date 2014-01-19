package es.regueiro.nfoutils.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.lang.reflect.Field;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement(name = "tvshow")
@XmlAccessorType(XmlAccessType.FIELD)
public class TvShow extends NfoFile {

	private static final Logger logger = LoggerFactory.getLogger(TvShow.class);

	@XmlElement(name = "id")
	private String id;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "showtitle")
	private String showtitle;
	@XmlElement(name = "outline")
	private String outline;
	@XmlElement(name = "plot")
	private String plot;
	@XmlElement(name = "tagline")
	private String tagline;
	@XmlElement(name = "genre", type = String.class)
	private List<String> genres;
	@XmlElement(name = "studio", type = String.class)
	private List<String> studios;
	@XmlElement(name = "actor", type = Actor.class)
	private List<Actor> actors;
	@XmlElement(name = "thumb", type = Thumb.class)
	private List<Thumb> thumbs;
	@XmlElement(name = "fanart", type = Fanart.class)
	private List<Fanart> fanarts;
	@XmlElement(name = "episodeguide", type = EpisodeGuide.class)
	private EpisodeGuide episodeGuide;
	@XmlElement(name = "uniqueid")
	private String uniqueId;
	@XmlElement(name = "displayseason")
	private String displaySeason;
	@XmlElement(name = "displayepisode")
	private String displayEpisode;
	@XmlElement(name = "season")
	private String season;
	@XmlElement(name = "episode")
	private String episode;
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
	@XmlElement(name = "aired")
	private LocalDate aired;
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
	@XmlElement(name = "tag")
	private Collection<String> tags;
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

	// Media Elch Tags
	@XmlElement(name = "tvdbid")
	private String tvdbID;
	@XmlElement(name = "imdbid")
	private String imdbID;
	@XmlElement(name = "sorttitle")
	private String sortTitle;

	// Media Companion tags
	@XmlElement(name = "episodeactorsource")
	private String episodeActorSource;
	@XmlElement(name = "tvshowactorsource")
	private String tvShowActorSource;
	@XmlElement(name = "sortorder")
	private String sortOrder;
	@XmlElement(name = "language")
	private String language;
	@XmlElement(name = "state")
	private String state;

	// End extra tags

	@XmlElement(name = "episodedetails", type = EpisodeDetails.class)
	private List<EpisodeDetails> episodeDetails;

	public TvShow() {
		this.genres = new ArrayList<>();
		this.studios = new ArrayList<>();
		this.actors = new ArrayList<>();
		this.thumbs = new ArrayList<>();
		this.fanarts = new ArrayList<>();
		this.episodeDetails = new ArrayList<>();
	}

	public void cleanEmptyTags() {
		for (Field field : TvShow.class.getDeclaredFields()) {
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
					logger.error(e.getMessage(), e);
				}

			}
		}
	}

	@Override
	public String toString() {
		return "TvShow:\nnfoFile=" + getNfoFile() + "\nid=" + id + "\ntitle=" + title + "\nshowtitle=" + showtitle
				+ "\noutline=" + outline + "\nplot=" + plot + "\ntagline=" + tagline + "\ngenres=" + genres
				+ "\nstudios=" + studios + "\nactors=" + actors + "\nthumbs=" + thumbs + "\nfanarts=" + fanarts
				+ "\nepisodeGuide=" + episodeGuide + "\nuniqueId=" + uniqueId + "\ndisplaySeason=" + displaySeason
				+ "\ndisplayEpisode=" + displayEpisode + "\nseason=" + season + "\nepisode=" + episode + "\nyear="
				+ year + "\nrating=" + rating + "\nvotes=" + votes + "\ntop250=" + top250 + "\nruntime=" + runtime
				+ "\naired=" + aired + "\nplaycount=" + playcount + "\ntrailer=" + trailer + "\nmpaa=" + mpaa
				+ "\nset=" + set + "\npremiered=" + premiered + "\ntags=" + tags + "\nlastplayed=" + lastplayed
				+ "\nepbookmark=" + epbookmark + "\nfilenameandpath=" + filenameandpath + "\nfile=" + file + "\npath="
				+ path + "\nbasepath=" + basepath + "\nstatus=" + status + "\ncode=" + code + "\nresume=" + resume
				+ "\ndateadded=" + dateadded + "\nart=" + art + "\ntvdbID=" + tvdbID + "\nimdbID=" + imdbID
				+ "\nsortTitle=" + sortTitle + "\nepisodeActorSource=" + episodeActorSource + "\ntvShowActorSource="
				+ tvShowActorSource + "\nsortOrder=" + sortOrder + "\nlanguage=" + language + "\nstate=" + state;
	}

}
