package es.regueiro.nfoutils.util;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TagFinder {

	public static String find(Path file) {

		String result = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(file.toFile());

//			document.getDocumentElement().normalize();

			NodeList tags = document.getElementsByTagName("*");

			Set<String> values = new TreeSet<String>();

			for (int i = 0; i < tags.getLength(); i++) {
				String tag = tags.item(i).getNodeName();

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
						tag = parentNode.getNodeName() + " * " + tag;
					} else {
						tag = parentNode.getNodeName() + " " + tag;
					}

					
					parentNode = parentNode.getParentNode();
					if (parentNode.getNodeName().equals("#document") || parentNode.getNodeName().equals("videodb")) {
						parentNode = null;
					}
				}

				values.add(tag);
			}

			for (String s : values) {
				System.out.println(s);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

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


	public static void main(String[] args) {
		find(Paths.get("D:/xbmc_videodb_2014-01-12/videodb.xml"));
	}

}
