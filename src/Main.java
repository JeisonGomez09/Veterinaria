import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Busque la forma de poner un par de emojis de forma decorativa
        System.out.println("\uD83D\uDC36\uD83D\uDC31Bienvenido a su veterinaria de confianza\uD83D\uDC3E");
        System.out.println("Ingrese nombre de su mascota: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese especie");
        String especie = sc.nextLine();
        System.out.println("Ingrese fecha de nacimiento (AAAA-MM-DD): ");
        String fecha=sc.nextLine();
        LocalDate fetchoneNascimento=LocalDate.parse(fecha);
        System.out.println("Ingrese peso (Kg)");
        double peso = Double.parseDouble(sc.nextLine());

        Mascota mascota = new Mascota(nombre, especie, fetchoneNascimento, peso);
        mascota.setNombre(nombre);
        mascota.setEspecie(especie);
        mascota.setFechaDeNacimiento(fetchoneNascimento);
        mascota.setPeso(peso);

        int op;

        do {
            System.out.println("\n-----Menu veterinaria-----");
            System.out.println("1-       Mostrar informacion");
            System.out.println("2-                 Alimentar");
            System.out.println("3-                   Vacunar");
            System.out.println("4- Mostrar informacion final");
            System.out.println("*Seleccione una opcion*");

        op =sc.nextInt();

        switch (op){
            case 1:
                mascota.info();
                break;

            case 2:
                System.out.println("Ingrese la cantidad de alimento en gramos (maximo el 10% del peso actual de la mascota): ");
                double cantidad=sc.nextDouble();
                mascota.alimentar(cantidad);
                break;

            case 3:
                mascota.vacunar();
                break;

            case 4:
                System.out.println("Informacion final:");
                mascota.info();
                System.out.println("❤\uFE0F Gracias por confiar en nuestro servicio");
                System.out.println("\uD83D\uDC3E ¡Hasta la próxima consulta! \uD83D\uDC3E");
                break;

            default:
                System.out.println("***Opcion invalida***");
        }
        }while (op!=4);
        sc.close();
    }
}