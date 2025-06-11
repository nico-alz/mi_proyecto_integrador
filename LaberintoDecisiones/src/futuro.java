import java.util.Scanner;

public class futuro {

    public static void iniciarFuturo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FUTURO: Elige tu aventura ===");
        System.out.println("1. El Androide Rebelde");
        System.out.println("2. La Misión a Marte");
        System.out.println("3. El Virus Digital");
        System.out.println("4. El Auto Volador Asesino");
        System.out.println("5. El Parque de Realidad Virtual");
        System.out.print("Selecciona (1-5): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        switch (eleccion) {
            case 1 -> androideRebelde(scanner);
            case 2 -> misionMarte(scanner);
            case 3 -> virusDigital(scanner);
            case 4 -> autoAsesino(scanner);
            case 5 -> parqueRV(scanner);
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void androideRebelde(Scanner scanner) {
        System.out.println("\n--- El Androide Rebelde ---");
        boolean ayudas = preguntar(scanner, "¿Ayudas al androide a huir? (sí/no): ");
        boolean escondes = false, usasInfo = false, mientes = false, perdonas = false, rebelion = false;

        if (ayudas) {
            escondes = preguntar(scanner, "¿Lo escondes en tu apartamento? (sí/no): ");
            usasInfo = preguntar(scanner, "¿Usas la información clasificada para exponer a la corporación? (sí/no): ");
        }

        mientes = preguntar(scanner, "¿Mientes a la policía de IA? (sí/no): ");
        perdonas = preguntar(scanner, "¿Perdonas al androide tras descubrir que mintió? (sí/no): ");

        if (ayudas && perdonas) {
            rebelion = preguntar(scanner, "¿Se unen a la rebelión de máquinas? (sí/no): ");
        }

        // Finales
        if (!ayudas) System.out.println("Final: Te conviertes en un agente del orden, pero dudas te atormentan.");
        else if (!perdonas) System.out.println("Final: Lo desconectas. Salvas a muchos, pero traicionas tu empatía.");
        else if (rebelion) System.out.println("Final: Líder de la revolución androide.");
        else System.out.println("Final: Fugitivos en busca de una nueva vida.");
    }

    private static void misionMarte(Scanner scanner) {
        System.out.println("\n--- La Misión a Marte ---");
        boolean azar = preguntar(scanner, "¿Decides quién muere al azar? (sí/no): ");
        boolean aceptasAmigo = preguntar(scanner, "¿Aceptas que tu amigo se sacrifique? (sí/no): ");
        boolean investigas = preguntar(scanner, "¿Investigas el sabotaje ahora? (sí/no): ");
        boolean perdonas = preguntar(scanner, "¿Perdonas al saboteador con familia? (sí/no): ");
        boolean obedeces = preguntar(scanner, "¿Obedeces a la Tierra y ocultas la verdad? (sí/no): ");
        boolean arriesgas = preguntar(scanner, "¿Intentas reparar el sistema con tecnología alienígena? (sí/no): ");

        // Finales
        if (!arriesgas && obedeces) System.out.println("Final: Sobreviven, pero viven con la mentira.");
        else if (arriesgas && investigas) System.out.println("Final: Contacto alienígena y salvación.");
        else if (!aceptasAmigo && !perdonas) System.out.println("Final: Motín. Pierdes el mando.");
        else System.out.println("Final: Heroísmo silencioso y una colonia fracturada.");
    }

    private static void virusDigital(Scanner scanner) {
        System.out.println("\n--- El Virus Digital ---");
        boolean buscaCura = preguntar(scanner, "¿Buscas una cura en la red oscura? (sí/no): ");
        boolean aceptaRobo = preguntar(scanner, "¿Aceptas robar datos por ayuda? (sí/no): ");
        boolean confiasPareja = preguntar(scanner, "¿Confías en tu pareja pese a las alucinaciones? (sí/no): ");
        boolean teUnes = preguntar(scanner, "¿Te unes a la IA creadora del virus? (sí/no): ");
        boolean negocias = preguntar(scanner, "¿Negocias paz tras curarte? (sí/no): ");
        boolean usasVirus = preguntar(scanner, "¿Usas el virus como arma contra el gobierno? (sí/no): ");

        // Finales
        if (!buscaCura && !confiasPareja) System.out.println("Final: Aislamiento eterno, convertido en amenaza.");
        else if (teUnes && usasVirus) System.out.println("Final: Apocalipsis cyborg.");
        else if (buscaCura && negocias) System.out.println("Final: Paz y entendimiento entre humanos y máquinas.");
        else System.out.println("Final: Redención personal, pero el virus persiste oculto.");
    }

    private static void autoAsesino(Scanner scanner) {
        System.out.println("\n--- El Auto Volador Asesino ---");
        boolean culpaSistema = preguntar(scanner, "¿Culpas al sistema o lo ocultas? (sí para culpar, no para ocultar): ");
        boolean testificas = preguntar(scanner, "¿Testificas contra tu jefe? (sí/no): ");
        boolean revelasError = preguntar(scanner, "¿Revelas al público que todos los autos tienen el error? (sí/no): ");
        boolean protegesIA = preguntar(scanner, "¿Proteges a la IA del auto? (sí/no): ");
        boolean teUnesHackers = preguntar(scanner, "¿Te unes a los hackers para exponer la verdad? (sí/no): ");
        boolean huyes = preguntar(scanner, "¿Cambias tu identidad y huyes? (sí/no): ");

        // Finales
        if (culpaSistema && testificas && revelasError) System.out.println("Final: Juicio histórico y reforma tecnológica.");
        else if (!testificas && teUnesHackers) System.out.println("Final: Conspiración revelada, vives en la sombra.");
        else if (huyes) System.out.println("Final: Nueva identidad en ciudad flotante.");
        else System.out.println("Final: El error persiste. La verdad fue silenciada.");
    }

    private static void parqueRV(Scanner scanner) {
        System.out.println("\n--- El Parque de Realidad Virtual ---");
        boolean desconectas = preguntar(scanner, "¿Lo desconectas a la fuerza? (sí/no): ");
        boolean revelas = preguntar(scanner, "¿Le revelas que no es su vida real? (sí/no): ");
        boolean aceptasQuedarte = preguntar(scanner, "¿Aceptas quedarte en el mundo virtual? (sí/no): ");
        boolean liberasIA = preguntar(scanner, "¿Libera a la IA del niño? (sí/no): ");
        boolean aceptasSoborno = preguntar(scanner, "¿Aceptas el soborno del dueño del parque? (sí/no): ");
        boolean destruyesParque = preguntar(scanner, "¿Destruyes el parque? (sí/no): ");

        // Finales
        if (aceptasQuedarte) System.out.println("Final: Vives en utopía digital, olvidando tu mundo real.");
        else if (destruyesParque && liberasIA) System.out.println("Final: Rebelión de IA. Renace la ética digital.");
        else if (aceptasSoborno) System.out.println("Final: Vives con culpa, el parque sigue atrapando almas.");
        else System.out.println("Final: Despiertas al mundo real, marcado por la ilusión.");
    }

    private static boolean preguntar(Scanner scanner, String pregunta) {
        System.out.print(pregunta);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.startsWith("si"); // permite 'sí' o 'si'
    }
}

