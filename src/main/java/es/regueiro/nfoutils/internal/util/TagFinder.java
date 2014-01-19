package es.regueiro.nfoutils.internal.util;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.regueiro.nfoutils.internal.model.XbmcMovie;
import es.regueiro.nfoutils.internal.properties.Properties;

public class TagFinder {

	static Set<String> values = new TreeSet<>();

	public static Set<String> find(Path file) {

		String result = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(file.toFile());

			// document.getDocumentElement().normalize();

			NodeList tags = document.getElementsByTagName("*");

			for (int i = 0; i < tags.getLength(); i++) {
				String tag = tags.item(i).getNodeName() + getAttributes(tags.item(i));

				// if (tag.equals("uniqueid") && !tags.item(i).getTextContent().equals("")) {
				// System.out.println("###code: "+tags.item(i).getTextContent());
				// }
				// if (tag.equals("epbookmark")) {
				// System.out.println("###epbookmark: "+tags.item(i).getTextContent());
				// }
				// if (tag.equals("certification")) {
				// System.out.println("###certification: "+tags.item(i).getTextContent());
				// }
				// if (tag.equals("premiered")) {
				// System.out.println("###premiered: "+tags.item(i).getTextContent());
				// }
				// if (tag.equals("releasedate")) {
				// System.out.println("###releasedate: "+tags.item(i).getTextContent());
				// }
				// if (tag.equals("status") && !tags.item(i).getTextContent().equals("")) {
				// System.out.println("###status: "+tags.item(i).getTextContent());
				// }
				// if (tag.equals("imdbId")) {
				// System.out.println("===imdbId: "+tags.item(i).getTextContent() + "\t"+ file.toString());
				// }
//				 if (tag.equals("bitratemax")) {
//				 System.out.println("###bitratemax: "+tags.item(i).getTextContent() + "\t"+ file.toString());
//				 }
//				 if (tag.equals("bitratemode")) {
//				 System.out.println("###bitratemode: "+tags.item(i).getTextContent() + "\t"+ file.toString());
//				 }
//				 if (tag.equals("codecidinfo")) {
//				 System.out.println("###codecidinfo: "+tags.item(i).getTextContent() + "\t"+ file.toString());
//				 }
				// if (tag.equals("thumb")) {
				// if (tags.item(i).getParentNode().getNodeName().equals("tvshow"))
				// System.out.println("+++thumb: " + tags.item(i).getTextContent() + "\t" + file.toString());
				// }

				Node prev = getPreviousSiblingElement(tags.item(i));
				Node next = getNextSiblingElement(tags.item(i));
				if ((prev != null && prev.getNodeName().equals(tag))
						|| (next != null && next.getNodeName().equals(tag))) {
					tag = tag + " *";
				}

				Node parentNode = tags.item(i).getParentNode();

				// System.out.println("First "+ parentNode.getNodeName());
				if (parentNode.getNodeName().equals("#document") || parentNode.getNodeName().equals("videodb")) {
					parentNode = null;
				}
				while (parentNode != null) {
					// System.out.println(i + " " + parentNode.getNodeName());

					prev = getPreviousSiblingElement(tags.item(i));
					next = getNextSiblingElement(tags.item(i));
					if ((prev != null && prev.getNodeName().equals(tags.item(i).getNodeName()))
							|| (next != null && next.getNodeName().equals(tags.item(i).getNodeName()))) {
						tag = parentNode.getNodeName() + getAttributes(parentNode) + " * " + tag;
					} else {
						tag = parentNode.getNodeName() + getAttributes(parentNode) + " " + tag;
					}

					parentNode = parentNode.getParentNode();
					if (parentNode.getNodeName().equals("#document") || parentNode.getNodeName().equals("videodb")) {
						parentNode = null;
					}
				}

				values.add(tag);
			}

			// for (String s : values) {
			// System.out.println(s);
			// }

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return values;

	}

	private static String getAttributes(Node node) {
		NamedNodeMap attributes = node.getAttributes();

		StringBuilder builder = new StringBuilder();

		if (attributes.getLength() > 0) {
			builder.append("(");
			for (int x = 0; x < attributes.getLength(); x++) {
				builder.append(attributes.item(x).getNodeName());
				if (x + 1 < attributes.getLength()) {
					builder.append(", ");
				}
			}

			builder.append(")");
		}

		return builder.toString();
	}

	public static Element getPreviousSiblingElement(Node node) {
		Node prevSibling = node.getPreviousSibling();
		while (prevSibling != null) {
			if (prevSibling.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) prevSibling;
			}
			prevSibling = prevSibling.getPreviousSibling();
		}

		return null;
	}

	public static Element getNextSiblingElement(Node node) {
		Node nextSibling = node.getNextSibling();
		while (nextSibling != null) {
			if (nextSibling.getNodeType() == Node.ELEMENT_NODE) {
				return (Element) nextSibling;
			}
			nextSibling = nextSibling.getNextSibling();
		}

		return null;
	}

	public static void main(String[] args) throws IOException {
		// find(Paths.get("D:/xbmc_videodb_2014-01-12/videodb.xml"));

		NfoFileVisitor visitor = new NfoFileVisitor();
		 Files.walkFileTree(Paths.get("P:/Peliculas"), EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
		 visitor);
		 Files.walkFileTree(Paths.get("T:/Peliculas"), EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
		 visitor);
		 Files.walkFileTree(Paths.get("H:/Peliculas"), EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
		 visitor);
//		Files.walkFileTree(Paths.get("T:/Series"), EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, visitor);
//		Files.walkFileTree(Paths.get("T:/SeriesOrg"), EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
//				visitor);

		for (String s : TagFinder.values) {
			System.out.println(s);
		}
	}

	private static class NfoFileVisitor extends SimpleFileVisitor<Path> {
		private static final Logger logger = LoggerFactory.getLogger(NfoFileVisitor.class);

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.nio.file.SimpleFileVisitor#preVisitDirectory(java.lang.Object,
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
		 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
		 */
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

			if (attrs.isRegularFile() && file.getFileName().toString().endsWith(".nfo")) {
				// logger.debug("Found nfo file: " + file.toString());
				find(file);
				// Movie movie = es.regueiro.nfoutils.jaxb.Marshaller.unMarshall(file, Movie.class);
			}
			return FileVisitResult.CONTINUE;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.nio.file.SimpleFileVisitor#visitFileFailed(java.lang.Object, java.io.IOException)
		 */
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			// logger.error("IO Error when trying to access " + file.toString());

			return super.visitFileFailed(file, exc);
		}

	}

}
