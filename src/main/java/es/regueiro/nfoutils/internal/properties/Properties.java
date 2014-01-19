package es.regueiro.nfoutils.internal.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Properties {
	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(Properties.class);

	private static final String DEFAULT_IGNORE_FOLDERS = ".actors,extrafanart,extrathumbs";

	/** The folder names to ignore when walking the media folder list. */
	private static final Collection<String> IGNORE_FOLDERS = new ArrayList<>();

	static {
		java.util.Properties properties = new java.util.Properties();
		try {
			properties.load(Properties.class.getResourceAsStream("/cfg.properties"));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		String ignoreFoldersProp = properties.getProperty("ignoreFolders", DEFAULT_IGNORE_FOLDERS);

		String[] ignoreExplStrings = ignoreFoldersProp.split(",");

		for (int i = 0; i < ignoreExplStrings.length; i++) {
			IGNORE_FOLDERS.add(ignoreExplStrings[i]);
		}

	}

	public static Collection<String> getIgnoreFolders() {
		return IGNORE_FOLDERS;
	}

}
