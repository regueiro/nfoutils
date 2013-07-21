package es.regueiro.nfoutils.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.exceptions.InvalidFolderException;

/**
 * A manager for the media folders.
 */
public class MediaFolderManager {

	/** The logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(MediaFolderManager.class);

	/** The media folder map. */
	private Map<String, Path> mediaFolders;

	/**
	 * Instantiates a new media folder manager.
	 */
	public MediaFolderManager() {
		mediaFolders = new HashMap<String, Path>();
	}

	/**
	 * Adds a new media folder to the map from a string.
	 * <p>
	 * If the folder already exists in the map, the map is not modified.
	 * </p>
	 *
	 * @param uri the uri of the folder to add
	 * @throws InvalidFolderException if the folder doesn't exist
	 */
	public void addMediaFolder(String uri) throws InvalidFolderException {
		Path newFolder = Paths.get(uri).toAbsolutePath();

		String folderKey = newFolder.toString();

		if (!mediaFolders.containsKey(folderKey)
				&& !mediaFolders.containsValue(newFolder)) {
			
			if (Files.exists(newFolder)) {
				mediaFolders.put(folderKey, newFolder);

				logger.info("New media folder added: " + uri);

			} else {
				logger.debug("Invalid folder: " + uri);
				throw new InvalidFolderException(uri + " is not a valid folder");
			}
		} else {
			logger.debug("Folder already exists: " + uri);
		}
	}

	/**
	 * Removes a media folder from a string.
	 *
	 * @param uri the uri of the folder to remove
	 */
	public void removeMediaFolder(String uri) {
		Path folder = Paths.get(uri).toAbsolutePath();

		removeMediaFolder(folder);
	}

	/**
	 * Removes a media folder from a path.
	 *
	 * @param path the path of the folder
	 */
	public void removeMediaFolder(Path path) {
		if (mediaFolders.remove(path.toString()) != null) {
			logger.info("Media folder removed: " + path.toString());
		} else {
			logger.debug("Tried to remove media folder not in collection: "
					+ path.toString());
		}
	}
	
	/**
	 * Removes all media folders from the map
	 *
	 */
	public void clear() {
		mediaFolders.clear();
	}

	/**
	 * Gets the media folder map as an unmodifiable map.
	 *
	 * @return the media folder map
	 */
	public Map<String, Path> getMediaFolders() {
		return Collections.unmodifiableMap(mediaFolders);
	}
	
	/**
	 * Gets the media folder map as an unmodifiable collection.
	 *
	 * @return the media folder collection
	 */
	public Collection<Path> getMediaFoldersCollection() {
		return Collections.unmodifiableCollection(mediaFolders.values());
	}


	/**
	 * Checks if the folder denoted by the string exists in the map.
	 *
	 * @param uri the uri of the folder
	 * @return true, if the folder exists, false otherwise
	 */
	public boolean hasFolder(String uri) {
		Path folder = Paths.get(uri).toAbsolutePath();

		return hasFolder(folder);
	}
	
	/**
	 * Checks if the folder denoted by the path exists in the map.
	 *
	 * @param path the java path of the folder
	 * @return true, if the folder exists, false otherwise
	 */
	public boolean hasFolder(Path path) {
		return mediaFolders.containsValue(path);
	}

}
