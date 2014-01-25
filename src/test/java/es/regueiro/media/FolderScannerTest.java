//package es.regueiro.media;
//
//import static org.junit.Assert.*;
//
//import java.util.Collection;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import es.regueiro.nfoutils.internal.files.FolderScanner;
//import es.regueiro.nfoutils.internal.files.MediaFolderManager;
//import es.regueiro.nfoutils.internal.model.XbmcMovie;
//
//
//public class FolderScannerTest {
//
//	MediaFolderManager manager;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		manager = new MediaFolderManager();
//		
////		manager.addMediaFolder("P:\\Peliculas");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		//TODO: Create a proper test with temp folders and mocked movie nfos.
//		FolderScanner scanner = new FolderScanner(manager.getMediaFoldersCollection());
//		
//		Collection<XbmcMovie> movies = scanner.scanForMovies();
//
//		for (XbmcMovie movie:movies) {
//			System.out.println(movie);
//		}
//	}
//
// }
