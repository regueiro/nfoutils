package es.regueiro.nfoutils.internal.util;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.interfaces.Cleanable;

public class TagCleaner {
	private static final Logger logger = LoggerFactory.getLogger(TagCleaner.class);

	public static <T extends Cleanable> void cleanEmptyTags(T object, Class<T> type) {
		for (Field field : type.getDeclaredFields()) {
			try {
				if (field.getType().equals(String.class)) {
					field.setAccessible(true);
					Object tempField;

					tempField = field.get(object);
					if (tempField != null) {
						String value = (String) tempField;

						if (value.equals("")) {
							field.set(object, null);
							logger.trace("Field {} set to null", field.getName());
						}
					}

				} else if (field.getType().isAssignableFrom(Cleanable.class)) {
					field.setAccessible(true);
					Cleanable tempField = (Cleanable) field.get(object);
					tempField.cleanEmptyTags();
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
}
