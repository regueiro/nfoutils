package es.regueiro.nfoutils.internal.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import es.regueiro.nfoutils.media.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class XbmcTrack implements Cleanable {

	@XmlElement(name = "albumArtistCredits", type = XbmcArtistCredits.class)
	private List<XbmcArtistCredits> albumArtistCredits;
	private String musicBrainzTrackID;
	private String title;
	private String duration;
	private Integer position;

	public List<XbmcArtistCredits> getAlbumArtistCredits() {
		return albumArtistCredits;
	}

	public void setAlbumArtistCredits(List<XbmcArtistCredits> albumArtistCredits) {
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
		for (XbmcArtistCredits credit : albumArtistCredits) {
			credit.cleanEmptyTags();
		}
	}

	@Override
	public String toString() {
		return "XbmcTrack [albumArtistCredits=" + albumArtistCredits + ", musicBrainzTrackID=" + musicBrainzTrackID
				+ ", position=" + position + ", duration=" + duration + ", title=" + title + "]";
	}

}
