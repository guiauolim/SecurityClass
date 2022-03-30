
public class LFSR {
        public static int deslocar(int registrador[], boolean shiftar, boolean tipo) {
                int retorno = 0;
                int xor = 0;
               
                retorno = registrador[0];
               
                if(shiftar) {
                        if (! tipo) {
                                xor = registrador[31] ^ registrador[6] ^ registrador[4] ^ registrador[2] ^ registrador[1] ^ registrador[0];
                        } else {
                                xor = registrador[31] ^ registrador[6] ^ registrador[5] ^ registrador[1];
                        }
                       
                        for(int i = 0 ; i < registrador.length - 1 ; i++) {
                                registrador[i] = registrador[i + 1];
                        }
                        registrador[31] = xor;
                }
               
                return retorno;
        }
       
        public static void main(String[] args) {
                //Declara��o de vari�veis
                int[] cabeca = new int[32];
                int[] gerador1 = new int[32];
                int[] gerador2 = new int[32];
                int operando1 = 0;
                int operando2 = 0;
                String caractere = "";
               
                //Inicializa��o dos registradores
                for (int i = 0 ; i < cabeca.length ; i++) {
                        cabeca[i] = ((int) (2 * Math.random()));
                        gerador1[i] = ((int) (2 * Math.random()));
                        gerador2[i] = ((int) (2 * Math.random()));
                }
               
                //Gera��o de n�meros
                for (int i = 0 ; i < 2000 ; i++) {
                        if (deslocar(cabeca, true, false) == 0) {
                                operando1 = deslocar(gerador1, true, false);
                                operando2 = deslocar(gerador2, false, true);
                        } else {
                                operando1 = deslocar(gerador1, false, false);
                                operando2 = deslocar(gerador2, true, true);
                        }
                       
                        caractere += (operando1 ^ operando2);
                       
                        if (( i % 8) == 7) {
                                System.out.println(caractere + "\t" + Integer.parseInt(caractere, 2) + "\t" + ((char) Integer.parseInt(caractere, 2)));
                                caractere = "";
                        }
                }
        }
}
