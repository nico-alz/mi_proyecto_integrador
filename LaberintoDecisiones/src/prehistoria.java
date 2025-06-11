import java.util.Scanner;
public class prehistoria {

    public static void iniciarPrehistoria() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PREHISTORIA: Elige tu aventura ===");
        System.out.println("1. El Chamán Perdido");
        System.out.println("2. El Secreto del Fuego");
        System.out.println("3. La Caza Maldita");
        System.out.println("4. La Cueva Prohibida");
        System.out.println("5. La Última Tribu");
        System.out.print("Selecciona (1-5): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (eleccion) {
            case 1 -> chamanPerdido(scanner);
            case 2 -> secretoFuego(scanner);
            case 3 -> cazaMaldita(scanner);
            case 4 -> cuevaProhibida(scanner);
            case 5 -> ultimaTribu(scanner);
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void chamanPerdido(Scanner scanner) {
        System.out.println("\n--- El Chamán Perdido ---");

        boolean buscar = preguntar(scanner, "¿Buscas al chamán desaparecido? (sí/no): ");
        boolean entrasCueva = preguntar(scanner, "Encuentras una cueva con símbolos extraños. ¿Entras? (sí/no): ");
        boolean escuchasVoces = preguntar(scanner, "Oyes voces dentro. ¿Las sigues? (sí/no): ");
        boolean ofrecesAyuda = preguntar(scanner, "Ves al chamán delirando. ¿Le ofreces ayuda? (sí/no): ");
        boolean llevasTribu = preguntar(scanner, "¿Lo llevas de regreso a la tribu? (sí/no): ");
        boolean respetasSecretos = preguntar(scanner, "Te cuenta secretos de curación. ¿Los mantienes en secreto? (sí/no): ");

        if (!buscar) {
            System.out.println("Final: El chamán muere solo. La tribu cae enferma sin sus conocimientos.");
        } else if (!entrasCueva) {
            System.out.println("Final: El chamán sigue perdido. El miedo domina tu corazón.");
        } else if (!escuchasVoces) {
            System.out.println("Final: Escapas de la cueva, pero siempre dudas qué hubiera pasado.");
        } else if (!ofrecesAyuda) {
            System.out.println("Final: El chamán te maldice por tu egoísmo.");
        } else if (!llevasTribu) {
            System.out.println("Final: Él muere en tus brazos, revelándote un saber ancestral.");
        } else if (respetasSecretos) {
            System.out.println("Final: Te conviertes en el nuevo sabio. La tribu prospera.");
        } else {
            System.out.println("Final: Compartes el saber. Curación masiva, pero los dioses castigan la soberbia.");
        }
    }

    private static void secretoFuego(Scanner scanner) {
        System.out.println("\n--- El Secreto del Fuego ---");

        boolean compartesFuego = preguntar(scanner, "¿Compartes el secreto del fuego con otros clanes? (sí/no): ");
        boolean enseñasJóvenes = preguntar(scanner, "¿Enseñas a los jóvenes a usarlo con respeto? (sí/no): ");
        boolean cazaMasiva = preguntar(scanner, "¿Lo usas para cazar en exceso? (sí/no): ");
        boolean tribuTeme = preguntar(scanner, "¿Tu tribu empieza a temer tu poder? (sí/no): ");
        boolean abandonas = preguntar(scanner, "¿Abandonas el fuego cuando ves sus consecuencias? (sí/no): ");
        boolean escondesSecreto = preguntar(scanner, "¿Escondes el secreto en una cueva sagrada? (sí/no): ");

        if (!compartesFuego && !enseñasJóvenes) {
            System.out.println("Final: Muere contigo el fuego. El mundo regresa a la oscuridad.");
        } else if (cazaMasiva) {
            System.out.println("Final: El ecosistema colapsa. El fuego trae ruina.");
        } else if (tribuTeme && !abandonas) {
            System.out.println("Final: Te exilian por miedo. Vagas como un fantasma ardiente.");
        } else if (escondesSecreto) {
            System.out.println("Final: El fuego se preserva. Siglos después, volverá a cambiar el mundo.");
        } else {
            System.out.println("Final: El fuego guía a tu tribu hacia una nueva era.");
        }
    }

    private static void cazaMaldita(Scanner scanner) {
        System.out.println("\n--- La Caza Maldita ---");

        boolean ignorasAdvertencia = preguntar(scanner, "Una anciana te advierte que no caces al ciervo blanco. ¿La ignoras? (sí/no): ");
        boolean liderasCaza = preguntar(scanner, "¿Lideras la expedición de caza? (sí/no): ");
        boolean hieresAnimal = preguntar(scanner, "¿Hierves al ciervo en lugar de matarlo? (sí/no): ");
        boolean loCuras = preguntar(scanner, "¿Decides curarlo al ver su sufrimiento? (sí/no): ");
        boolean regresasTribu = preguntar(scanner, "¿Regresas a la tribu sin trofeo? (sí/no): ");
        boolean admitesError = preguntar(scanner, "¿Admites tu error públicamente? (sí/no): ");

        if (!ignorasAdvertencia) {
            System.out.println("Final: Respetas el equilibrio natural. El bosque florece.");
        } else if (!loCuras) {
            System.out.println("Final: Maldición cae sobre ti. Todos los nacimientos terminan en muerte.");
        } else if (!regresasTribu) {
            System.out.println("Final: Te conviertes en protector del ciervo y vives entre las sombras.");
        } else if (admitesError) {
            System.out.println("Final: La tribu aprende humildad. El bosque perdona.");
        } else {
            System.out.println("Final: Vives en culpa. El espíritu del ciervo te sigue en sueños.");
        }
    }

    private static void cuevaProhibida(Scanner scanner) {
        System.out.println("\n--- La Cueva Prohibida ---");

        boolean exploras = preguntar(scanner, "La cueva sagrada está prohibida. ¿La exploras igual? (sí/no): ");
        boolean tocasPinturas = preguntar(scanner, "¿Tocas las pinturas rupestres? (sí/no): ");
        boolean siguesEco = preguntar(scanner, "Oyes un eco extraño. ¿Lo sigues? (sí/no): ");
        boolean tomasObjeto = preguntar(scanner, "Encuentras un objeto brillante. ¿Lo tomas? (sí/no): ");
        boolean muestrasTribu = preguntar(scanner, "¿Muestras el objeto a tu tribu? (sí/no): ");
        boolean teSacrificas = preguntar(scanner, "Una plaga comienza. ¿Te sacrificas para apaciguar a los dioses? (sí/no): ");

        if (!exploras) {
            System.out.println("Final: Vives en paz, pero siempre con curiosidad.");
        } else if (tomasObjeto && !teSacrificas) {
            System.out.println("Final: La plaga arrasa. El objeto se pierde para siempre.");
        } else if (!tomasObjeto && teSacrificas) {
            System.out.println("Final: Te conviertes en leyenda. El equilibrio se restablece.");
        } else {
            System.out.println("Final: El misterio permanece. Algunos dicen que despertaste algo antiguo.");
        }
    }

    private static void ultimaTribu(Scanner scanner) {
        System.out.println("\n--- La Última Tribu ---");

        boolean aceptasAlianza = preguntar(scanner, "Otra tribu llega hambrienta. ¿Aceptas una alianza? (sí/no): ");
        boolean compartesComida = preguntar(scanner, "¿Compartes tus reservas de comida? (sí/no): ");
        boolean organizasCeremonia = preguntar(scanner, "¿Organizas una ceremonia de unión? (sí/no): ");
        boolean descubresTraición = preguntar(scanner, "Descubres que planean tomar tu territorio. ¿Actúas primero? (sí/no): ");
        boolean proponesPaz = preguntar(scanner, "¿Intentas negociar la paz igual? (sí/no): ");
        boolean huyes = preguntar(scanner, "¿Huyes con los tuyos a las montañas? (sí/no): ");

        if (!aceptasAlianza) {
            System.out.println("Final: Sobrevives por un tiempo, pero el invierno diezma tu gente.");
        } else if (descubresTraición && !proponesPaz) {
            System.out.println("Final: Guerra tribal. Muchos mueren, pocos ganan.");
        } else if (huyes) {
            System.out.println("Final: Encuentras tierras nuevas. Comienzas de cero.");
        } else if (organizasCeremonia && proponesPaz) {
            System.out.println("Final: Unificación histórica. Nace una gran civilización.");
        } else {
            System.out.println("Final: La historia te olvidará, pero tu gente recordará tu compasión.");
        }
    }

    private static boolean preguntar(Scanner scanner, String pregunta) {
        System.out.print(pregunta);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.startsWith("si"); // permite 'sí' o 'si'
    }
}
