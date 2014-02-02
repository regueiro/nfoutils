package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
@ToString(includeNames = true, includeFields = true)
class Fanart extends Cleanable {

	@XmlElement(name = "thumb", type = Thumb.class)
	List<Thumb> thumbs = new ArrayList<>()
	String url

}
