import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese especie");
        String especie = sc.nextLine();
        System.out.println("Ingrese edad");
        int edad = sc.nextInt();
        System.out.println("Ingrese peso");
        double peso = sc.nextDouble();

        Mascota mascota = new Mascota();

        int op;

        do {
            System.out.println("\n-----Menu veterinaria-----");
            System.out.println("1-       Mostrar informacion");
            System.out.println("2-                 Alimentar");
            System.out.println("3-                   Vacunar");
            System.out.println("4-              Cumplir años");
            System.out.println("5- Mostrar informacion final");
            System.out.println("*Seleccione una opcion*");
        }

    }
}