
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaDES {
        public static void main(String[] args) throws Exception {
                // Declaração de variáveis
                BufferedReader leitor = new BufferedReader(
                                                                new InputStreamReader(
                                                                System.in));
               
                String texto = "";
                String senha = "";
                String criptograma = "";
               
                // Entrada de dados
                System.out.print("Digite o texto: ");
                texto = leitor.readLine();
               
                System.out.print("Digite a senha: ");
                senha = leitor.readLine();
               
                // Processamento
                SecretKey chave = new SecretKeySpec(senha.getBytes("utf-8"), "Desede");
                Cipher cifra = Cipher.getInstance("Desede");
               
                cifra.init(Cipher.ENCRYPT_MODE, chave);
                byte[] vetorCriptograma = cifra.doFinal(texto.getBytes("utf-8"));
                criptograma = Base64.getEncoder().encodeToString(vetorCriptograma);
               
                // Saída de dados
                System.out.println(criptograma);
               
                // Volta !
                System.out.print("Digite o criptograma: ");
                criptograma = leitor.readLine();
               
                cifra.init(Cipher.DECRYPT_MODE, chave);
                byte[] vetorTexto = cifra.doFinal(Base64.getDecoder().decode(criptograma));
                texto = new String(vetorTexto, "utf-8");
               
                System.out.println(texto);
        }
}
