
package main;


/**
 *
 * Author Melisa Speranza - https://www.linkedin.com/in/melisa-speranza/
 * Aquí está el algoritmo publicado:
 * https://www.interior.gob.es/opencms/ca/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/#:~:text=Por%20ejemplo%2C%20si%20el%20n%C3%BAmero,n%C3%BAmeros%20y%20d%C3%ADgito%20de%20control.
 * 
 * Clase que verifica que un NIE sea válido, calcula el dígito de control y lo compara con
 * el introducido.
 * 
 */
public class VerifyNIE {
    
        public VerifyNIE(String textFieldValue) {
                        
            
        }

        public static boolean validar(String NIE) {
            System.out.println("Entra");
            
                String ultimaLetraMayuscula = "";
               
                //Verifico la  longitud del String y que en la posición 8 haya un char. 
                //Para NIE en la condicion también tengo que tener una letra inicial en el index 0.
                // FORMAT VERIFICATION

                if(NIE.length() != 9 || Character.isLetter(NIE.charAt(8)) == false || Character.isLetter(NIE.charAt(0)) == false) {                   
                    return false;
                }       

                ultimaLetraMayuscula = (NIE.substring(8)).toUpperCase();

                              
                if (soloNumeros(NIE) == true && letraNIE(NIE).equals(ultimaLetraMayuscula)) {
                        return true;
                }
                else {
                        return false;
                }
        }
        
        private static String asignarPrimerNumero(String NIE){
             String numero = "";
                //Primero asignaré el primer numero segun la letra del NIE:
                //Para hacerlo primero obtengo el char en la posición 0 del string NIE:

                String primerLetra = NIE.substring(0,1);
                
                if(primerLetra.equalsIgnoreCase("x")){
                                    
                    numero = ("0" + NIE.substring(1, 8));                   
                    
                }else if (primerLetra.equalsIgnoreCase("y")){
                    
                    numero = ("1" + NIE.substring(1, 8));

                }else if (primerLetra.equalsIgnoreCase("z")){
                    
                    numero = ("2" + NIE.substring(1, 8));
                }
                return numero;
        }
        
        private static boolean soloNumeros(String NIE){
             int i, j = 0;
                String numero = asignarPrimerNumero(NIE);
                String numero2 = "";
                String NIENumeros = "";
                String[] listaNumeros = {"0","1","2","3","4","5","6","7","8","9"};


                for(i = 0; i < numero.length() ; i++) {
                        numero2 = numero.substring(i, i+1);

                        for(j = 0; j < listaNumeros.length; j++) {
                                if(numero2.equals(listaNumeros[j])) {
                                        NIENumeros += listaNumeros[j];
                                }
                        }
                }


                if (NIENumeros.length() != 8) {
                        return false;
                }
                else {
                        return true;
                }
        }
        
        private static String letraNIE(String NIE){
            int numero = Integer.parseInt(asignarPrimerNumero(NIE));
            int residuo = 0;
            String letra = "";
            String[] asignarLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
            residuo = numero % 23;
            letra = asignarLetra[residuo];
            System.out.println(letra);
            return letra;
        }
    
}
