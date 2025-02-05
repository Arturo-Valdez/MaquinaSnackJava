package maquina_snack;
import java.io.Serializable;
import java.util.Objects;

//Uso de javabeans, componentes reutilizables en Java que se
//utilizan para encapsular datos y comportamientos en aplicaciones
public class Snack implements Serializable {
    //Atributos
    private static int contadorSnacks =0;
    private int idSnack;
    private String nombre;
    private double precio;

    //Constructor vacio por JavaBeans
    public Snack(){
        this.idSnack = ++Snack.contadorSnacks;
    }

    public Snack(String nombre, double precio){
        this();//manda a llamar constructor vacio
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnack=" + idSnack +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(precio, snack.precio) == 0 && Objects.equals(nombre, snack.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }
}
