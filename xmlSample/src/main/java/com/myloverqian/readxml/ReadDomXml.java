package com.myloverqian.readxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by dzw on 2015/12/23.
 */
public class ReadDomXml {

    private static String path = "xmlSample/src/main/resources/dom.xml";

    private static Element ReadXml() {
        Element root = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            root = document.getDocumentElement();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static void main(String[] args) {
        Element root = ReadXml();
        System.out.println("books:" + root.getAttribute("books"));
        NodeList list = root.getElementsByTagName("book");
        for (int i = 0; i < list.getLength(); i++) {
            Element bookName = (Element) list.item(i);
            System.out.println("\t" + "book=" + bookName.getAttribute("id"));
            NodeList childNodes = bookName.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                if (item instanceof Element) {
                    System.out.println("\t\t" + item.getNodeName() + "=" + item.getTextContent());
                }
            }
        }
    }
}
