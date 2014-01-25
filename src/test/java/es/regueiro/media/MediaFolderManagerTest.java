package es.regueiro.media;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.regueiro.nfoutils.internal.exceptions.InvalidFolderException;
import es.regueiro.nfoutils.internal.util.MediaFolderManager;

public class MediaFolderManagerTest {
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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/*
	 * Test that the manager instantiates correctly and that it contains an empty list.
	 */
	public void testMediaFolderManager() {
		System.out.println("\nTesting instantiate MediaFolderManager");
		assertNotNull(manager);

		assertNotNull(manager.getMediaFolders());
		assertTrue(manager.getMediaFolders().isEmpty());
	}

	@Test
	/*
	 * Test that we can add media folders correctly and that no duplicates appear when we try to add the same folder
	 * more than once.
	 */
	public void testCanAddMediaFolder() {
		try {
			System.out.println("\nTesting addMediaFolder");
			Path tempMediaFolder1 = Files.createTempDirectory("temporal");
			tempMediaFolder1.toFile().deleteOnExit();
			Path tempMediaFolder2 = Files.createTempDirectory("temp2");
			tempMediaFolder2.toFile().deleteOnExit();
			assertFalse(tempMediaFolder1.equals(tempMediaFolder2));

			manager.addMediaFolder(tempMediaFolder1.toString());
			assertTrue(manager.hasFolder(tempMediaFolder1.toString()));

			manager.addMediaFolder(tempMediaFolder2.toString());
			assertTrue(manager.hasFolder(tempMediaFolder2.toString()));

			Map<String, Path> folderMap = manager.getMediaFolders();
			assertEquals(2, folderMap.size());

			manager.addMediaFolder(tempMediaFolder2.toString());
			assertTrue(manager.hasFolder(tempMediaFolder2.toString()));

			Path sameTempMediaFolder2 = Paths.get(tempMediaFolder2.toString());

			assertEquals(sameTempMediaFolder2, tempMediaFolder2);

			manager.addMediaFolder(tempMediaFolder2.toString());
			assertTrue(manager.hasFolder(tempMediaFolder2));

			folderMap = manager.getMediaFolders();
			assertEquals(2, folderMap.size());

			try {
				manager.addMediaFolder("this file doesnt exist%^&£&");

				fail("InvalidFolderException expected");
			} catch (InvalidFolderException expected) {
			}

		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException creating temp directory");
		} catch (InvalidFolderException e) {
			fail("InvalidFolderException when trying to add temp directory");
		}

	}

	@Test
	/*
	 * Test that we can remove media folders correctly.
	 */
	public void testRemoveMediaFolder() {
		try {
			System.out.println("\nTesting removeMediaFolder");
			Path tempMediaFolder1 = Files.createTempDirectory("temporal");
			tempMediaFolder1.toFile().deleteOnExit();
			Path tempMediaFolder2 = Files.createTempDirectory("temp2");
			tempMediaFolder2.toFile().deleteOnExit();
			Path tempMediaFolder3 = Files.createTempDirectory("temp3");
			tempMediaFolder3.toFile().deleteOnExit();

			manager.addMediaFolder(tempMediaFolder1.toString());
			manager.addMediaFolder(tempMediaFolder2.toString());
			manager.addMediaFolder(tempMediaFolder3.toString());

			assertTrue(manager.hasFolder(tempMediaFolder1));
			assertTrue(manager.hasFolder(tempMediaFolder2));
			assertTrue(manager.hasFolder(tempMediaFolder3));

			manager.removeMediaFolder(tempMediaFolder2);
			assertTrue(manager.hasFolder(tempMediaFolder1));
			assertFalse(manager.hasFolder(tempMediaFolder2));
			assertTrue(manager.hasFolder(tempMediaFolder3));

			manager.removeMediaFolder(tempMediaFolder3.toString());
			assertTrue(manager.hasFolder(tempMediaFolder1));
			assertFalse(manager.hasFolder(tempMediaFolder2));
			assertFalse(manager.hasFolder(tempMediaFolder3));

			manager.removeMediaFolder(tempMediaFolder1);
			assertFalse(manager.hasFolder(tempMediaFolder1));
			assertFalse(manager.hasFolder(tempMediaFolder2));
			assertFalse(manager.hasFolder(tempMediaFolder3));

			Map<String, Path> folderMap = manager.getMediaFolders();
			assertEquals(0, folderMap.size());

			manager.removeMediaFolder(tempMediaFolder1);
			manager.removeMediaFolder(tempMediaFolder2.toString());
			manager.removeMediaFolder(tempMediaFolder3.toString());
			assertFalse(manager.hasFolder(tempMediaFolder1.toString()));
			assertFalse(manager.hasFolder(tempMediaFolder2));
			assertFalse(manager.hasFolder(tempMediaFolder3));

		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException creating temp directory");
		} catch (InvalidFolderException e) {
			fail("InvalidFolderException when trying to add temp directory");
		}
	}

	@Test
	/*
	 * Test that we can get the media folders and make sure that the collection is unmodifiable
	 */
	public void testGetMediaFolders() {
		System.out.println("\nTesting getMediaFolders");
		try {
			Map<String, Path> folderMap = manager.getMediaFolders();
			Collection<Path> folderCollection = manager.getMediaFoldersCollection();
			assertEquals(0, folderMap.size());
			assertEquals(0, folderCollection.size());

			Path testMediaFolder1 = Files.createTempDirectory("test1");
			testMediaFolder1.toFile().deleteOnExit();
			Path testMediaFolder2 = Files.createTempDirectory("test2");
			testMediaFolder2.toFile().deleteOnExit();
			Path testMediaFolder3 = Files.createTempDirectory("test3");
			testMediaFolder3.toFile().deleteOnExit();

			manager.addMediaFolder(testMediaFolder1.toString());
			manager.addMediaFolder(testMediaFolder2.toString());
			manager.addMediaFolder(testMediaFolder3.toString());

			assertEquals(3, folderMap.size());
			assertEquals(3, folderCollection.size());

			try {
				folderMap.put("test key", Paths.get("test path"));

				fail("UnsupportedOperationException expected");
			} catch (UnsupportedOperationException expected) {
			}

			try {
				folderCollection.add(Paths.get("test path"));

				fail("UnsupportedOperationException expected");
			} catch (UnsupportedOperationException expected) {
			}

		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException creating temp directory");
		} catch (InvalidFolderException e) {
			fail("InvalidFolderException when trying to add temp directory");
		}
	}

	@Test
	/*
	 * Test that hasFolder shows correctly that the folder is or isn't contained in the map
	 */
	public void testHasFolder() {
		System.out.println("\nTesting hasFolder");
		try {
			Path testMediaFolder1 = Files.createTempDirectory("test1");
			testMediaFolder1.toFile().deleteOnExit();
			Path testMediaFolder2 = Files.createTempDirectory("test2");
			testMediaFolder2.toFile().deleteOnExit();
			Path testMediaFolder3 = Files.createTempDirectory("test3");
			testMediaFolder3.toFile().deleteOnExit();

			manager.addMediaFolder(testMediaFolder1.toString());
			manager.addMediaFolder(testMediaFolder2.toString());

			assertTrue(manager.hasFolder(testMediaFolder1));
			assertTrue(manager.hasFolder(testMediaFolder1.toString()));
			assertTrue(manager.hasFolder(testMediaFolder2));
			assertTrue(manager.hasFolder(testMediaFolder2.toString()));
			assertFalse(manager.hasFolder(testMediaFolder3));
			assertFalse(manager.hasFolder(testMediaFolder3.toString()));

		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException creating temp directory");
		} catch (InvalidFolderException e) {
			fail("InvalidFolderException when trying to add temp directory");
		}
	}

	@Test
	/*
	 * Test that we can clear correctly the map
	 */
	public void testclear() {
		System.out.println("\nTesting clear");
		try {
			Path testMediaFolder1 = Files.createTempDirectory("test1");
			testMediaFolder1.toFile().deleteOnExit();
			Path testMediaFolder2 = Files.createTempDirectory("test2");
			testMediaFolder2.toFile().deleteOnExit();
			Path testMediaFolder3 = Files.createTempDirectory("test3");
			testMediaFolder3.toFile().deleteOnExit();

			manager.addMediaFolder(testMediaFolder1.toString());
			manager.addMediaFolder(testMediaFolder2.toString());

			Map<String, Path> folderMap = manager.getMediaFolders();
			assertEquals(2, folderMap.size());

			manager.clear();
			assertFalse(manager.hasFolder(testMediaFolder1));
			assertFalse(manager.hasFolder(testMediaFolder2));
			assertEquals(0, folderMap.size());

			assertFalse(manager.hasFolder(testMediaFolder3));
			assertFalse(manager.hasFolder(testMediaFolder3.toString()));

		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException creating temp directory");
		} catch (InvalidFolderException e) {
			fail("InvalidFolderException when trying to add temp directory");
		}
	}

}
