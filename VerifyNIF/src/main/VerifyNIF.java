package main;
 
 /**
 *
 * @author Melisa Speranza - https://www.linkedin.com/in/melisa-speranza/
 * Clase que verifica que un NIF sea válido, calcula el dígito de control y lo compara con
 * el introducido.
 * * Aquí está el algoritmo publicado:
 * https://www.interior.gob.es/opencms/ca/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/#:~:text=Por%20ejemplo%2C%20si%20el%20n%C3%BAmero,n%C3%BAmeros%20y%20d%C3%ADgito%20de%20control.
 * 
 * 
 */
    public class VerifyNIF  {

        public VerifyNIF(String textFieldValue) {
                        
            
        }

        public static boolean validar(String NIF) {

                String lletraMajuscula = "";

                if(NIF.length() != 9 || Character.isLetter(NIF.charAt(8)) == false ) {                   
                    return false;
                }

                lletraMajuscula = (NIF.substring(8)).toUpperCase();

                if(nomesNumeros(NIF) == true && lletraNIF(NIF).equals(lletraMajuscula)) {
                        return true;
                }
                else {
                        return false;
                }
        }

        private static boolean nomesNumeros(String NIF) {

                int i, j = 0;
                String numero = "";
                String NIFNumeros = "";
                String[] llistaNumeros = {"0","1","2","3","4","5","6","7","8","9"};

                for(i = 0; i < NIF.length() - 1; i++) {
                        numero = NIF.substring(i, i+1);

                        for(j = 0; j < llistaNumeros.length; j++) {
                                if(numero.equals(llistaNumeros[j])) {
                                        NIFNumeros += llistaNumeros[j];
                                }
                        }
                }

                if(NIFNumeros.length() != 8) {
                        return false;
                }
                else {
                        return true;
                }
        }

        private static String lletraNIF(String NIF) {

                int NIFNumeros = Integer.parseInt(NIF.substring(0,8));
                int residu = 0;
                String lletra = "";
                String[] assignarLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
                residu = NIFNumeros % 23;
                lletra = assignarLetra[residu];
                return lletra;
        }



}

