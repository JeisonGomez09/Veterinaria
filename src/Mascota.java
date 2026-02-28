import java.time.LocalDate;
import java.time.Period;

public class Mascota {

    private String nombre;
    private String especie;
    private LocalDate fechaDeNacimiento;
    private double peso;       // en KG
    private boolean vacunado;

    public Mascota(String nombre, String especie, LocalDate fechaDeNacimiento, double peso, boolean vacunado) {
        this.nombre = nombre;
        this.especie = especie;
        setFechaDeNacimiento(fechaDeNacimiento); // valida
        setPeso(peso);                           // valida
        this.vacunado = vacunado;
    }

    public Mascota(String nombre, String especie, LocalDate fechaDeNacimiento, double peso) {
        this(nombre, especie, fechaDeNacimiento, peso, false);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public int getEdad() {
        if (this.fechaDeNacimiento == null) return 0;
        return Period.between(this.fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        if (fechaDeNacimiento == null) {
            System.out.println("La fecha no puede ser nula.");
            return;
        }
        if (fechaDeNacimiento.isAfter(LocalDate.now())) {
            System.out.println("La fecha no puede ser futura.");
            return;
        }
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            System.out.println("El peso debe ser mayor que 0.");
            return;
        }
        this.peso = peso;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", peso=" + String.format("%.2f", peso) + " Kg" +
                ", vacunado=" + vacunado +
                '}';
    }

    public void vacunar() {
        if (!vacunado) {
            vacunado = true;
            System.out.println("La mascota ha sido vacunada ✅");
        } else {
            System.out.println("La mascota ya está vacunada ✅");
        }
    }

    public void alimentar(double cantidadGramos) {
        if (cantidadGramos <= 0) {
            System.out.println("*Cantidad no permitida, no puede ser negativa ni cero*");
            return;
        }

        double kilosAumentar = cantidadGramos / 1000.0;

        double maxPermitidoKg = this.peso * 0.10;

        if (kilosAumentar > maxPermitidoKg) {
            System.out.println("Demasiada comida para una sola vez.");
            System.out.println("Máximo permitido: " + String.format("%.0f", maxPermitidoKg * 1000) + " gramos.");
            return;
        }

        this.peso += kilosAumentar;

        System.out.println("Mascota alimentada correctamente 🐾");
        System.out.println("Nuevo peso: " + String.format("%.2f", this.peso) + " Kg");
    }

    public void info() {
        System.out.println("------- Información de la mascota -------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Fecha de nacimiento: " + fechaDeNacimiento);
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Peso: " + String.format("%.2f", peso) + " Kg");
        System.out.println("Vacunado: " + (vacunado ? "Sí" : "No"));
    }
}