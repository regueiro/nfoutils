package es.regueiro.nfoutils.internal

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlTransient
import java.lang.reflect.Field

@XmlAccessorType(XmlAccessType.FIELD)
@XmlTransient
abstract class Cleanable {

	protected void cleanEmptyTags() {
		this.class.declaredFields.each {
			cleanField(it, this)
		}
	}

	protected static void cleanField(Field f, object) {
		if (f.type == String) {
			f.setAccessible true
			String field = f.get object

			if (field?.trim() == "") {
				f.set(object, null)
			}
		} else if (Collection.class.isAssignableFrom(f.type)) {
			f.setAccessible true
			Collection collection = f.get(object) as Collection

			def it = collection.iterator()
			while (it.hasNext()) {
				def field = it.next()

				if (field instanceof  String) {
					if (field.trim() == "") {
						it.remove()
					}
				} else if (field instanceof Cleanable) {
					field.cleanEmptyTags()
				}
			}
		} else if (f.type.isAssignableFrom(Cleanable)) {
			f.setAccessible true
			Cleanable field = f.get(object) as Cleanable
			field.cleanEmptyTags()
		}
	}
}