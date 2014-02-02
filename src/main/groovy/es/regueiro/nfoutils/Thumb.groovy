package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlValue

@ToString(includeNames = true, includeFields = true)
@XmlRootElement(name = "thumb")
class Thumb extends Cleanable {

	@XmlAttribute
	String preview
	@XmlAttribute
	String type
	@XmlAttribute
	String season
	@XmlValue
	String thumb
}
