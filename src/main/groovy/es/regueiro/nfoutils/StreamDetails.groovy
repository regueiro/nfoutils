package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class StreamDetails extends Cleanable {

	@XmlElement(name = "video")
	List<Video> videos = new ArrayList<>()
	@XmlElement(name = "audio")
	List<Audio> audios = new ArrayList<>()
	@XmlElement(name = "subtitle")
	List<Subtitle> subtitles = new ArrayList<>()

}
