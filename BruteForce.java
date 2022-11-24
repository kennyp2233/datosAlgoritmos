public class BruteForce {
    public static void main(String[] args) {
        String text = "TTATAGATCTCGTATTCTTTTATAGATCTCCTATTCTT";
        String pattern = "TCCTATTCTT";
        System.out.println("El texto usado es: " + text + "\nEl patrón usado es: " + pattern);
        long timeIni = System.nanoTime();
        bruteForce(text, pattern);
        long timeFin = System.nanoTime();

        System.out.println("El tiempo usado de ejecución fue: " + (timeFin - timeIni) + "ns");
    }

    public static void bruteForce(String text, String pattern) {
        String[] textA = text.split("");
        String[] patternA = pattern.split("");
        int failed = 0;
        int compared = 0;
        int displacements = 0;

        for (int i = 0; i <= textA.length - patternA.length; i++) {
            for (int j = 0; j < patternA.length; j++) {
                // System.out.println("i:" + i + " j:" + j + "|" + textA[i + j] + "|" +
                // patternA[j]);
                compared++;
                if (j + 1 == patternA.length) {
                    System.out.println("Se encontró el patron el la posicion: " + i);
                    break;
                }
                if (!textA[i + j].equals(patternA[j])) {
                    failed++;
                    break;
                }
            }
            displacements++;
        }
        System.out.println("Numero comparaciones: " + compared);
        System.out.println("Numero desplazamientos: " + displacements);
        System.out.println("Numero fallos: " + failed);

    }

    public static String obtenerArray(String[] array) {
        String retorno = "";
        for (String string : array) {
            retorno += string + " ";
        }
        return retorno;
    }
}
