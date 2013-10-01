//Se importa lo necesario
import java.io.*;
import java.util.*;

/**
 * <p>Clase que incluye un contenedor que guarda jugadores según una clave, su nick, empleando un TreeMap que tiene como clave un String y como valor un Jugador</p>
 * @author Jose y Alberto
 */

public class ColectorJugador {

    private TreeMap<String,Jugador> jugadores;
    
    /**
     * <p>Constructor sin argumentos de ColectorJugador</p>
     */
    ColectorJugador(){
        jugadores=new TreeMap<String,Jugador>();
    }//Fin del constructor

    /**
     * <p>Método que almacena un nuevo jugador en el contenedor</p>
     * @param n String - Clave del jugador en el TreeMap
     * @param j Jugador - Jugador introducido en el TreeMap
     */
    public void nuevoJugador(String n,Jugador j){
        jugadores.put(n,j);
        this.almacenarJugadores();
    }//Fin del método nuevoJugador
    
    /**
     * <p>Método que elimina un Jugador del TreeMap</p>
     * @param n String - Clave del Jugador en el contenedor
     */
    public void eliminarJugador(String n){
        jugadores.remove(n);
    }//Fin del método eliminarJugador
    
    /**
     * <p>Método que comprueba la existencia de un jugador dada su clave</p>
     * @param n String - Clave del Jugador a comprobar
     * @return Boolean - True si el jugador esté en el contenedor, False si no lo está
     */
    public boolean existirJugador(String n){
        return jugadores.containsKey(n);
    }//Fin del método existirJugador
    
    /**
     * <p>Método que devuelve un Jugador dada su clave</p>
     * @param n String - Clave del Jugador
     * @return Jugador - Jugador que devuelve el método
     */
    public Jugador devolverJugador(String n){
        if(existirJugador(n)){
            return jugadores.get(n);
        }//Fin de la condición
        else{
            return null;
        }//Fin del else
    }//Fin del método devolverJugador

    /**
     * <p>Método que almacena los jugadores del contenedor en el disco duro</p>
     */
    public void almacenarJugadores(){
            FileOutputStream archivo=null;
            ObjectOutputStream flujo=null;
            Jugador jugador=null;
            try{
                archivo=new FileOutputStream("listaJugadores");
                flujo=new ObjectOutputStream(archivo);
                
            }catch(IOException e){
                System.out.println("Problema en la creación del flujo");
                System.exit(0);
            }//Fin del catch IOException
            Set<String> claves=jugadores.keySet();
            Iterator iterador=claves.iterator();
            
            while(iterador.hasNext()){
                try{
                    jugador=(Jugador)jugadores.get(iterador.next());
                    flujo.writeObject(jugador);
                }catch(IOException e){
                    System.out.println("Problema al escribir objeto"+jugador);
                    System.exit(0);
                }//Fin del catch IOException
            }//Fin del bucle while
            try{
                flujo.close();
            }catch(IOException e){
                System.out.println("Problema al cerrar el flujo");
                System.exit(0);
            }//Fin del catch IOException
    }//Fin del método almacenarJugadores
    
    /**
     * <p>Método que lee los jugadores del archivo del disco duro para cargarlos en el contenedor</p>
     */
    public void leerJugadores(){
        FileInputStream archivo=null;
        ObjectInputStream flujo=null;
        Jugador jugador=null;
        String n="";
        
        try{
            archivo=new FileInputStream("listaJugadores");
            flujo=new ObjectInputStream(archivo);
        }catch(IOException e){
            System.out.println("Creación en problema de flujo y archivo");
            System.exit(0);
        }//Fin del catch IOException
        jugadores=new TreeMap<String,Jugador>();
        try{
            while((jugador=(Jugador)flujo.readObject())!=null){
                n=jugador.devolverNick();
                jugadores.put(n,jugador);
            }//Fin del bucle while
                   }catch(EOFException e){
                       System.out.println("Fin de lectura de jugadores");
                   }//Fin del catch EOFException
                    catch(ClassNotFoundException e){
                        System.out.println("No se puede usar la clase Jugador");
                        System.exit(0);
                    }//Fin del catch ClassNotFoundException
                   catch(IOException e){
                       System.out.println("Excepcion tipo IOException");
                       System.exit(0);
                   }//Fin del catch IOException
    try{
        flujo.close();
    }catch(IOException e){
        System.out.println("Problema al cerrar el flujo");
        System.exit(0);
    }//Fin del catch IOException
    }//Fin del método leerJugadores
            }//Fin de la clase ColectorJugador