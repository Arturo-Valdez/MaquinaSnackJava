package maquina_snack;
import java.io.Serializable;

//Uso de javabeans, componentes reutilizables en Java que se
//utilizan para encapsular datos y comportamientos en aplicaciones
public class Snack implements Serializable {
    //Atributos
    private static int contadorSnacks =0;
    private int idSnack;
    private String nombre;
    private double precio;

    public Snack(){
        this.idSnack = ++Snack.contadorSnacks;
    }

    public Snack(String nombre, double precio){
        this();//manda a llamar constructor vacio
        this.nombre = nombre;
        this.precio = precio;
    }
}
