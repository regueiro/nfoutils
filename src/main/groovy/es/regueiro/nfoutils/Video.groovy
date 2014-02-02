package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Video extends Cleanable {

	Double aspect
	String codec
	Integer durationinseconds
	Integer height
	Integer width
	String stereomode

	// Extra tags
	String bitrate
	String bitratemax
	String bitratemode
	String codecidinfo
	String container
	String duration
	String encodedSettings
	String format
	String language
	String longlanguage
	String multiView_Count
	String scantype

}
