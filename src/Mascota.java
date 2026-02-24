public class Mascota {

    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private boolean vacunado=false;

    public Mascota() {
    }

    public Mascota(String nombre, String especie, int edad, double peso, boolean vacunado) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
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
        if (edad>=0){
            this.edad=edad;
        }else {
            System.out.println("La edad no puede ser negativa");
        }
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
                ", edad=" + edad +
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
        if (cantidad>0){
            setPeso(getPeso()+cantidad);
            System.out.println("La mascota fue alimentada");
        }else {
            System.out.println("No se permiten cantidades negativas");
        }
    }

    public Void cumpliraños(){
        setEdad(getEdad()+1);
        System.out.println("La mascota cumplio años");
        return null;
    }

    public Void info(){
        System.out.println("-------Informacion de la mascota-------");
        System.out.println("Nombre: "+getNombre());
        System.out.println("Especie: "+getEspecie());
        System.out.println("Edad: *"+getEdad()+"*");
        System.out.println("Peso: "+getPeso());
        System.out.println("Vacunado: "+(isVacunado()?"Si":"No"));
        return null;
    }



}
