public class ListadoPrimos {
    private static int dim;
    private static boolean esPrimo[];
    private static int primos[];

    public static int[] generarPrimos (int max) {
        if (max < 2) {                       // Los primos empiezan en el 2
            return new int[0];               // Vector vacío
        } else {
            empezarCriba(max);
            cribar();
            rellenarPrimos();
            return primos;
        }
    }

    public static void empezarCriba (int max) {
        int i;
        dim = max + 1;                      // Tamaño del array
        esPrimo = new boolean[dim];
        for (i = 0; i < dim; i++)           // Inicializar el array
            esPrimo[i] = true;
        esPrimo[0] = esPrimo[1] = false;    // Eliminamos el 0 y el 1, que no son primos
    }

    public static void cribar () {          // Criba
        int i, j;
        for (i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                                            // Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    public static void rellenarPrimos () {
        int i, j;
        int cuenta = 0;                     // ¿Cuántos primos hay?
        for (i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
                                            // Rellenar el vector de numeros primos
        primos = new int[cuenta];
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }
}
