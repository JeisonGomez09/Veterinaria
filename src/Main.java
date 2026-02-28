import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Mascota> lstmascotas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int op;

        do {
            System.out.println("\n🐶🐱 ----- MENÚ VETERINARIA ----- 🐾");
            System.out.println("1. Crear mascotas");
            System.out.println("2. Mostrar mascotas");
            System.out.println("3. Buscar mascotas");
            System.out.println("4. Finalizar");
            System.out.print("Seleccione una opcion: ");

            // Leer opción y limpiar buffer
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.nextLine();
            }
            op = sc.nextInt();
            sc.nextLine(); // ✅ Limpia el Enter pendiente

            switch (op) {

                case 1:
                    System.out.println("\n--- Crear mascota ---");

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine().trim();

                    System.out.print("Especie: ");
                    String especie = sc.nextLine().trim();

                    // Fecha válida
                    LocalDate fechaNacimiento = null;
                    while (fechaNacimiento == null) {
                        System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
                        String fechaStr = sc.nextLine().trim();
                        try {
                            fechaNacimiento = LocalDate.parse(fechaStr);
                        } catch (Exception e) {
                            System.out.println("⚠ Formato inválido. Ej: 2024-08-10");
                        }
                    }

                    // Peso válido
                    Double peso = null;
                    while (peso == null) {
                        System.out.print("Peso (Kg): ");
                        String pesoStr = sc.nextLine().trim();
                        try {
                            peso = Double.parseDouble(pesoStr);
                            if (peso <= 0) {
                                System.out.println("⚠ El peso debe ser mayor que 0.");
                                peso = null;
                            }
                        } catch (Exception e) {
                            System.out.println("⚠ Ingrese un número válido (ej: 5.2)");
                        }
                    }

                    // ✅ Crear y guardar
                    Mascota nuevaMascota = new Mascota(nombre, especie, fechaNacimiento, peso);
                    lstmascotas.add(nuevaMascota);

                    System.out.println("✅ Mascota registrada correctamente 🐾");
                    break;

                case 2:
                    System.out.println("\n--- Lista de mascotas ---");
                    if (lstmascotas.isEmpty()) {
                        System.out.println("No hay mascotas registradas.");
                    } else {
                        for (Mascota m : lstmascotas) { // ✅ FOR-EACH correcto
                            System.out.println(m);
                        }
                    }
                    break;

                case 3:
                    if (lstmascotas.isEmpty()) {
                        System.out.println("No hay mascotas registradas.");
                        break;
                    }

                    System.out.print("Ingrese el nombre de la mascota a buscar: ");
                    String nombreBuscar = sc.nextLine();

                    Mascota mascotaEncontrada = null;

                    for (Mascota m : lstmascotas) {
                        if (m.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            mascotaEncontrada = m;
                            break;
                        }
                    }

                    if (mascotaEncontrada == null) {
                        System.out.println("No se encontró la mascota.");
                        break;
                    }

                    int subOp;
                    do {
                        System.out.println("\n🐾 Mascota encontrada: " + mascotaEncontrada.getNombre());
                        System.out.println("1. Ver información");
                        System.out.println("2. Alimentar");
                        System.out.println("3. Vacunar");
                        System.out.println("4. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");

                        subOp = sc.nextInt();
                        sc.nextLine(); // limpiar buffer

                        switch (subOp) {
                            case 1:
                                mascotaEncontrada.info();
                                break;

                            case 2:
                                System.out.print("Ingrese cantidad de alimento en gramos: ");
                                double cantidad = sc.nextDouble();
                                sc.nextLine(); // limpiar buffer
                                mascotaEncontrada.alimentar(cantidad);
                                break;

                            case 3:
                                mascotaEncontrada.vacunar();
                                break;

                            case 4:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción inválida.");
                        }

                    } while (subOp != 4);

                    break;

                case 4:
                    System.out.println("\n👋 Gracias por confiar en nuestro servicio.");
                    System.out.println("🐾 ¡Hasta la próxima consulta! 🐾");
                    break;

                default:
                    System.out.println("❌ Opcion invalida.");
            }

        } while (op != 4);

        sc.close();
    }
}