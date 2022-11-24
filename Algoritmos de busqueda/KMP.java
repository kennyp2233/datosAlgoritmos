public class KMP {
    public static void main(String[] args) {
        String text = "TTATAGATCTCGTATTCTTTTATAGATCTCCTATTCTT";
        String pattern = "TCCTATTCTT";
        System.out.println("Texto: " + text + "\nPatron: " + pattern);
        long timeIni = System.nanoTime();
        KMP(text, pattern);
        long timeFin = System.nanoTime();
        System.out.println("El tiempo usado de ejecución fue: " + (timeFin - timeIni) + "ns");
    }

    // Función para implementar el algoritmo KMP
    public static void KMP(String text, String pattern) {
        // caso base 1: el patrón es nulo o está vacío
        if (pattern == null || pattern.length() == 0) {
            System.out.println("El patron se lo encuentra en la posicion 0");
            return;
        }

        // caso base 2: el texto es NULL, o la longitud del texto es menor que la del
        // patrón
        if (text == null || pattern.length() > text.length()) {
            System.out.println("No se encontro el patron en el texto");
            return;
        }

        char[] chars = pattern.toCharArray();

        // next[i] almacena el índice de la siguiente mejor coincidencia parcial
        int[] next = new int[pattern.length() + 1];
        for (int i = 1; i < pattern.length(); i++) {
            int j = next[i + 1];

            while (j > 0 && chars[j] != chars[i]) {
                j = next[j];
            }

            if (j > 0 || chars[j] == chars[i]) {
                next[i + 1] = j + 1;
            }
        }

        for (int i = 0, j = 0; i < text.length(); i++) {
            if (j < pattern.length() && text.charAt(i) == pattern.charAt(j)) {
                if (++j == pattern.length()) {
                    System.out.println("El patron se lo encuentra en la posicion " + (i - j + 1));
                }
            } else if (j > 0) {
                j = next[j];
                i--;
            }
        }
    }

}
