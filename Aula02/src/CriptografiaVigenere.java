import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CriptografiaVigenere {

	public static void main(String[] args) throws Exception {
		
		// DECLARAÇÃO DE VARIAVÉIS
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		
		String entrada = "";
		String chave = "";
		String opcao = "";
		String saida = "";
		
		
		// ENTRADA DE DADOS
		System.out.println("Digite o Login: ");
		entrada = leitor.readLine();
		
		System.out.println("Digite o Chave: ");
		chave = leitor.readLine();
		
		System.out.println("Digite <E> para Encriptar ou <D> para Decriptar: ");
		opcao = leitor.readLine();
		
		// PROCESSAMENTO
		if (opcao.equalsIgnoreCase("E")) {
			saida = encriptar(entrada, chave);
		} else {
			saida = decriptar(entrada, chave);
		}
		
		// SAIDA DE DADOS
		
		System.out.println(saida);
		
		
	}

	
	private static String encriptar(String texto, String chave) {
		String retorno = "";
		
			for (int i = 0; i < texto.length(); i++ ) {
				int letraDoTexto = texto.charAt(i);
				int letraDaChave = chave.charAt(i % chave.length());
				int letraDoXor = (letraDoTexto ^ letraDaChave);
				String caractere = Integer.toHexString(letraDoXor);
				
				retorno += ((caractere.length() == 2 ? "" : "0") + caractere);
			}
		
		return retorno;
	}
	
	
	
	private static String decriptar(String texto, String chave) {
		String retorno = "";
		
		for (int i = 0 ; i < texto.length() - 1 ; i+=2) {
			String letraDoTexto = texto.substring(i, i + 2);
			int letraDaChave = chave.charAt(i/2 % chave.length());
			char letraDoXoR = (char) (Integer.parseInt(letraDoTexto, 16) ^ letraDaChave);
			
			retorno += letraDoXoR;
		
		}
		return retorno;
	}

	
	

}
	