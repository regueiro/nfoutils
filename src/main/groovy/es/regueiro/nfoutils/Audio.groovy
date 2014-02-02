package es.regueiro.nfoutils

import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Audio {

	String codec
	Integer channels
	String language

	// Extra tags
	String bitrate
	String longLanguage

}
