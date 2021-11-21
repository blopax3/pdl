package com.example.stateMachine;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadJflap {

    private String FILENAME;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document doc;

    //

    private List<Integer> states;
    private List<Integer> finalStates;
    private HashMap<Integer, HashMap<Character, Integer>> matrix;

    public ReadJflap(String name) {

        // Nombre del archivo a leer
        this.FILENAME = "jflapMatrix/" + name + ".jff";

        dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            doc = db.parse(new File(FILENAME));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        //

        this.states = new ArrayList<Integer>();
        this.finalStates = new ArrayList<Integer>();
        this.matrix = new HashMap<Integer, HashMap<Character, Integer>>();
    }

    public void generateData() {

        NodeList states = doc.getElementsByTagName("state");

        // En el bucle se recorren todos los estados y se genera la lista de estados
        // A su vez, se comprueba si los estados son finales, añadiéndolos a la lista de estados finales si es el caso
        // También se empieza a generar el HashMap que hace como matriz de transición de estados
        for (int temp = 0; temp < states.getLength(); temp++) {
            Node node = states.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Integer state = Integer.valueOf(element.getAttribute("id"));
                this.states.add(state); // Generar lista de estados
                matrix.put(state, new HashMap<Character, Integer>()); // Inicializar matriz
                NodeList fin = element.getElementsByTagName("final");
                if (fin.getLength() > 0) {
                    finalStates.add(state); // Generar lista estados finales
                }
            }
        }

        NodeList transition = doc.getElementsByTagName("transition");

        // El bucle recorre todas las transiciones entre estados terminando de crear la matriz de transición de estados
        for (int temp = 0; temp < transition.getLength(); temp++) {
            Node node = transition.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Integer from = Integer.valueOf(element.getElementsByTagName("from").item(0).getTextContent());
                Integer to = Integer.valueOf(element.getElementsByTagName("to").item(0).getTextContent());
                Character read = element.getElementsByTagName("read").item(0).getTextContent().charAt(0);

                this.matrix.get(from).put(read, to); // Terminar de generar la matriz

            }
        }
    }

    // Getters de las estructuras de datos creadas
    public List<Integer> getStates() {
        return states;
    }

    public List<Integer> getFinalStates() {
        return finalStates;
    }

    public HashMap<Integer, HashMap<Character, Integer>> getMatrix() {
        return matrix;
    }
}