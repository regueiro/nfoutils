package es.regueiro.nfoutils.files;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.regueiro.nfoutils.jaxb.Marshaller;
import es.regueiro.nfoutils.model.Movie;
import es.regueiro.nfoutils.properties.Properties;

/**
 * A folder scanner that can search for movies in given folders
 */
public class FolderScanner {
	
	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(FolderScanner.class);

	
	
	/** The media folder collection. */
	private Collection<Path> mediaFolders;

	/** The movie collection. */
	private Collection<Movie> movies;

	/**
	 * Instantiates a new folder scanner.
	 * 
	 * @param mediaFolders
	 *            the media folder list that will be scanned
	 */
	public FolderScanner(Collection<Path> mediaFolders) {
		this.mediaFolders = mediaFolders;
		movies = new ArrayList<>();
	}

	/**
	 * Scan for movies in the given media folders recursively.
	 * 
	 * @return the collection of movies found
	 */
	public Collection<Movie> scanForMovies() {
		return scanForMovies(true);
	}

	/**
	 * Scan for movies.
	 * 
	 * @param recursive
	 *            true if we want to recursively search the subfolders or false
	 *            if we only want to scan the root folder
	 * @return the collection of movies found
	 */
	public Collection<Movie> scanForMovies(boolean recursive) {
		EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
		int maxDepth;
		MovieNfoFileVisitor visitor = new MovieNfoFileVisitor();

		movies.clear();
		if (recursive) {
			logger.debug("Scan mode: recursive");
			maxDepth = Integer.MAX_VALUE;
		} else {
			logger.debug("Scan mode: single folder");
			maxDepth = 1;
		}

		for (Path mediaFolder : mediaFolders) {
			try {
				Files.walkFileTree(mediaFolder, opts, maxDepth, visitor);
			} catch (IOException e) {
				logger.error(e.getStackTrace().toString());
			}
		}

		return getMovieCollection();
	}

	/**
	 * Gets the movie collection.
	 * 
	 * @return the movie collection
	 */
	public Collection<Movie> getMovieCollection() {
		return Collections.unmodifiableCollection(movies);
	}

	/**
	 * Parses a movie nfo file.
	 * 
	 * @param nfoFile
	 *            the nfo file
	 * @throws IOException 
	 * @throws JAXBException 
	 */
	private void parseMovieNfo(Path nfoFile) throws JAXBException, IOException {
		movies.add(Marshaller.unMarshall(nfoFile, Movie.class));
	}

	/**
	 * A FileVisitor that traverses directories in search of nfo files.
	 * 
	 */
	public class MovieNfoFileVisitor extends SimpleFileVisitor<Path> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object,
		 * java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			if (Properties.getIgnoreFolders().contains(dir.getFileName().toString())) {

				return FileVisitResult.SKIP_SUBTREE;
			} else {
				// logger.debug("Scanning folder: " + dir.toString());

				return FileVisitResult.CONTINUE;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object,
		 * java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

			if (attrs.isRegularFile() && file.getFileName().toString().endsWith(".nfo")) {
				// logger.debug("Found nfo file: " + file.toString());
				try {
					parseMovieNfo(file);
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return FileVisitResult.CONTINUE;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.nio.file.SimpleFileVisitor#visitFileFailed(java.lang.Object,
		 * java.io.IOException)
		 */
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			logger.error("IO Error when trying to access " + file.toString());

			return super.visitFileFailed(file, exc);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.nio.file.SimpleFileVisitor#postVisitDirectory(java.lang.Object,
		 * java.io.IOException)
		 */
		// @Override
		// public FileVisitResult postVisitDirectory(Path dir, IOException exc)
		// throws IOException {
		// return FileVisitResult.CONTINUE;
		// }

	}
}
