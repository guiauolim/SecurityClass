import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class Sha256 {

	public static void main(String[] args) {
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		
		
		String texto = "";
		String resumo = "";
		
		
		try {
			// Entrada de dados
			System.out.print("Digite o texto: ");
			texto = leitor.readLine();
			
			// Processamento
			resumo = calcularHash(texto);
			
			// Sa?da de dados
			System.out.println(resumo);
		} catch (Exception erro) {
			System.out.println(erro);
		}

	}
	
	private static String calcularHash(String texto) throws Exception {
		String retorno = "";
		
		MessageDigest objHash = MessageDigest.getInstance("SHA-256");
		objHash.reset();
		objHash.update(texto.getBytes("utf-8"));
		byte[] vetorDeBytes = objHash.digest();
		
		for (int letra : vetorDeBytes ) {
			String caractere = Integer.toHexString(0xFF & letra);
			caractere = (caractere.length() == 2 ? "": "0") + caractere;
			retorno += caractere;
		}
		return retorno;
	}

}
