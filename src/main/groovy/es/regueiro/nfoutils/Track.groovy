package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Track extends Cleanable {
	@XmlElement(name = "albumArtistCredits", type = ArtistCredits.class)
	ArtistCredits albumArtistCredits
	String musicBrainzTrackID
	String title
	String duration
	Integer position

}
