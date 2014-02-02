package es.regueiro.nfoutils

import es.regueiro.nfoutils.internal.Cleanable
import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true)
class EmbeddedAlbum extends Cleanable {

	String title
	String year

}
