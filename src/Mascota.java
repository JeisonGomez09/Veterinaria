import java.time.LocalDate;
import java.time.Period;

public class Mascota {

    private String nombre;
    private String especie;
    private LocalDate fechaDeNacimiento;
    private double peso;
    private boolean vacunado=false;

    public Mascota(String nombre, String especie, LocalDate edad, double peso) {
    }

    public Mascota(String nombre, String especie, LocalDate fechaDeNacimiento, double peso, boolean vacunado) {
        this.nombre = nombre;
        this.especie = especie;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.peso = peso;
        this.vacunado = vacunado;
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

    public int getEdad() {
        return Period.between(this.fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        if (fechaDeNacimiento.isAfter(LocalDate.now())){
            System.out.println("La fecha no puede ser futura");
            return;
        }
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public double getPeso() {
        if (peso>0){
            this.peso=peso;
            return peso;
        }else {
            System.out.println("");
        }
        return peso;
    }

    public void setPeso(double peso) {
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
                ", peso=" + peso +
                ", vacunado=" + vacunado +
                '}';
    }

    public Void vacunar(){
        if (!isVacunado()){
            setVacunado(true);
            System.out.println("La mascota ha sido vacunada");
        }else {
            System.out.println("La mascota ya esta vacunada");
        }
        return null;
    }

    public void alimentar(double cantidad){
        if (cantidad<=0){
            System.out.println("*Cantidad no permitida, no puede ser negativa ni cero*");
            return;
        }

        double kilos=cantidad/1000;

        double cantidadmax=this.peso*0.10;

        if (kilos>cantidadmax){
            System.out.println("Demasiada comida para una sola vez.");
            System.out.println("Maximo de comida permitida: "+(cantidadmax*1000)+"gramos.");
            return;
        }

        this.peso += kilos;

        System.out.println("Mascota alimentada correctamente \uD83D\uDC3E");
        System.out.println("Nuevo peso: "+String.format("%.2f",this.peso)+" Kg");
    }

    public Void info(){
        System.out.println("-------Informacion de la mascota-------");
        System.out.println("Nombre: "+getNombre());
        System.out.println("Especie: "+getEspecie());
        System.out.println("Fecha de nacimiento: "+this.fechaDeNacimiento);
        System.out.println("Edad: *"+getEdad()+"* Años");
        System.out.println("Peso: "+getPeso()+"Kg");
        System.out.println("Vacunado: "+(isVacunado()?"Si":"No"));
        return null;
    }



}
