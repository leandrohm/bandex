package bandex;
/**
 * @author Leandro Henrique Mendes
 */
public class Bandex {

	public static void main(String args[]){
		ParserCardapio spe = new ParserCardapio(args[0]);
		try {
			spe.parseDocument(Robot.getXML("http://www.pcasc.usp.br/restaurante.xml"));
		}
		catch(Exception e){
			System.out.println("\nSem Conexao!!!\n");
		}
	}
}
