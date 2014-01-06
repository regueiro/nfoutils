package es.regueiro.media;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.ws.util.Pool.Marshaller;

import es.regueiro.nfoutils.files.FolderScanner;
import es.regueiro.nfoutils.files.MediaFolderManager;
import es.regueiro.nfoutils.model.Movie;

public class MarshallTest {

	MediaFolderManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		manager = new MediaFolderManager();

		// manager.addMediaFolder("P:\\Peliculas");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Movie movie = es.regueiro.nfoutils.jaxb.Marshaller.unMarshall(Paths.get("P:\\Peliculas\\1080p\\2001 - A Space Odyssey (Commentary) (1968) [1080p]\\2001 - A Space Odyssey (Commentary).nfo"));
		
		
		es.regueiro.nfoutils.jaxb.Marshaller.marshall(movie);
		
	}

}
