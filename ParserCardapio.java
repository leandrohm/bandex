/**
 *
 * @author Leandro Henrique Mendes
 */

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ParserCardapio extends DefaultHandler {
	private StringBuffer buffer;
	private String data = null;
	private boolean var;

	public String getData(){ return this.data; }
	public void setData(String data){ this.data = data; }

	public ParserCardapio(String data) {
		this.data = data;
	}

	public void parseDocument(InputStream filename) {
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			//parse the file and also register this class for call backs
			sp.parse(filename, this);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void startDocument() {
		this.buffer = new StringBuffer();
		var = false;
	}

	public void endDocument() {}

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals(getData())){
			var = true;
		}

		if ( var && ( qName.equals("almoco") || qName.equals("jantar")) ){
			System.out.println("\n<"+qName+">");
		}

		buffer.setLength(0);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if (var) {
			int k=0;
			for (int i = start; i < start + length; i++) {
				k++;
				if (ch[i] != '\n') {
					buffer.append(ch, i, length-k+1);
					break;
				}
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(var){
			if (qName.equals("salada") || qName.equals("principal")
					|| qName.equals("acompanhamento") || qName.equals("sobremesa")) {
				System.out.println(qName + ": "+buffer);
			}
		}

		if (qName.equals(getData())) {
			System.out.println(""); //So para ter um \n no final
			System.exit(0);
		}
	}
}
