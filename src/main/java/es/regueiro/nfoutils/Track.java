package es.regueiro.nfoutils;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.interfaces.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Track implements Cleanable {

	@XmlElement(name = "albumArtistCredits", type = ArtistCredits.class)
	private List<ArtistCredits> albumArtistCredits;
	private String musicBrainzTrackID;
	private String title;
	private String duration;
	private Integer position;

	public List<ArtistCredits> getAlbumArtistCredits() {
		return albumArtistCredits;
	}

	public void setAlbumArtistCredits(List<ArtistCredits> albumArtistCredits) {
		this.albumArtistCredits = albumArtistCredits;
	}

	public String getMusicBrainzTrackID() {
		return musicBrainzTrackID;
	}

	public void setMusicBrainzTrackID(String musicBrainzTrackID) {
		this.musicBrainzTrackID = musicBrainzTrackID;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void cleanEmptyTags() {
		if (musicBrainzTrackID != null && musicBrainzTrackID.isEmpty()) {
			musicBrainzTrackID = null;
		}
		if (duration != null && duration.isEmpty()) {
			duration = null;
		}
		if (title != null && title.isEmpty()) {
			title = null;
		}
		for (ArtistCredits credit : albumArtistCredits) {
			credit.cleanEmptyTags();
		}
	}

	@Override
	public String toString() {
		return "XbmcTrack [albumArtistCredits=" + albumArtistCredits + ", musicBrainzTrackID=" + musicBrainzTrackID
				+ ", position=" + position + ", duration=" + duration + ", title=" + title + "]";
	}

}
