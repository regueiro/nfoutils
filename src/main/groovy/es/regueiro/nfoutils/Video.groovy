package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Video extends Cleanable {

	Double aspect
	String codec
	@XmlElement(name = "durationinseconds")
	Integer durationInSeconds
	Integer height
	Integer width
	@XmlElement(name = "stereomode")
	String stereoMode

	// Extra tags
	String bitrate
	@XmlElement(name = "bitratemax")
	String bitrateMax
	@XmlElement(name = "bitratemode")
	String bitrateMode
	@XmlElement(name = "codecidinfo")
	String codecIdInfo
	String container
	String duration
	@XmlElement(name = "encodedSettings")
	String encodedSettings
	String format
	String language
	@XmlElement(name = "longlanguage")
	String longLanguage
	@XmlElement(name = "multiView_Count")
	String multiViewCount
	@XmlElement(name = "scantype")
	String scanType

}
