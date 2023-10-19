package Cadena;

public class cadena {

    public static void main(String[] args) {
        String input = "Programación Orientada a Objetos ";
        
        // 1. Obtener la longitud del String.
        int length = input.length();
        System.out.println("Longitud del String: " + length);
        
        // 2. Eliminar espacios en blanco.
        String withoutSpaces = input.replace(" ", "");
        System.out.println("String sin espacios: " + withoutSpaces);
        
        // 3. Pasar a mayúsculas.
        String uppercase = withoutSpaces.toUpperCase();
        System.out.println("String en mayúsculas: " + uppercase);
        
        // 4. Concatenar "12345".
        String concatenated = uppercase.concat("12345");
        System.out.println("String concatenado: " + concatenated);
        
        // 5. Extraer substring desde posición 10 al 15.
        String substring = concatenated.substring(10, 15);
        System.out.println("Substring desde la posición 10 al 15: " + substring);
        
        // 6. Reemplazar "o" por "O".
        String replaced = concatenated.replace("o", "O");
        System.out.println("String con reemplazo de 'o' por 'O': " + replaced);
        
        // 7. Comparar con "Programación".
        String comparison = "Programación";
        if (replaced.equals(comparison)) {
            System.out.println("El String coincide con 'Programación'.");
        } else {
            System.out.println("El String no coincide con 'Programación'.");
        }
        
        // Llamando a métodos de la clase StringManipulationHelper.
        StringManipulationHelper helper = new StringManipulationHelper();
        helper.countUppercaseLetters(replaced);
        helper.countOccurrences(replaced, 'o');
        helper.removeSpacesAndPrint(replaced);
        helper.reverseAndPrint(replaced);
    }
}

class StringManipulationHelper {

    public void countUppercaseLetters(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                count++;
            }
        }
        System.out.println("Cantidad de letras mayúsculas: " + count);
    }

    public void countOccurrences(String input, char character) {
        int count = 0;
        char lowercaseChar = Character.toLowerCase(character);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = Character.toLowerCase(input.charAt(i));
            if (currentChar == lowercaseChar) {
                count++;
            }
        }
        System.out.println("Cantidad de veces que '" + character + "' aparece en el String (mayúscula/minúscula): " + count);
    }

    public void removeSpacesAndPrint(String input) {
        String withoutSpaces = input.replace(" ", "");
        System.out.println("String sin espacios usando un método: " + withoutSpaces);
    }

    public void reverseAndPrint(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        System.out.println("String al revés usando un método: " + reversed);
    }
}
