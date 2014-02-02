package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Art extends Cleanable {

	String fanart
	String poster
	String banner
	String clearart
	String clearlogo
	String landscape
	@XmlElement(name = "season")
	List<SeasonArt> seasonArts = new ArrayList<>()

}
