package es.regueiro.nfoutils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import es.regueiro.nfoutils.interfaces.Cleanable;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArtistCredits implements Cleanable {

	private String artist;
	private String musicBrainzArtistID;
	private String joinphrase;
	private Boolean featuring;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getMusicBrainzArtistID() {
		return musicBrainzArtistID;
	}

	public void setMusicBrainzArtistID(String musicBrainzArtistID) {
		this.musicBrainzArtistID = musicBrainzArtistID;
	}

	public String getJoinphrase() {
		return joinphrase;
	}

	public void setJoinphrase(String joinphrase) {
		this.joinphrase = joinphrase;
	}

	public Boolean getFeaturing() {
		return featuring;
	}

	public void setFeaturing(Boolean featuring) {
		this.featuring = featuring;
	}

	@Override
	public void cleanEmptyTags() {
		if (artist != null && artist.isEmpty()) {
			artist = null;
		}
		if (musicBrainzArtistID != null && musicBrainzArtistID.isEmpty()) {
			musicBrainzArtistID = null;
		}
		if (joinphrase != null && joinphrase.isEmpty()) {
			joinphrase = null;
		}
	}

	@Override
	public String toString() {
		return "XbmcAlbumArtistCredits [artist=" + artist + ", musicBrainzArtistID=" + musicBrainzArtistID
				+ ", joinphrase=" + joinphrase + ", featuring=" + featuring + "]";
	}

}
