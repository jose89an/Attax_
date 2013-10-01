//Se importa lo necesario
import java.util.*;
import java.io.*;
/**
 * <p>Clase que incluye un contenedor que guarda tableros lógicos según una clave, su nick, empleando un TreeMap que tiene como clave un String y como valor un TableroLogico</p>
 * @author Jose y Alberto
 */
public class ColectorTableros {
    private TreeMap<String,TableroLogico> tableros;
    
    /**
     * <p>Constructor sin argumentos de ColectorTableros</p>
     */
    public ColectorTableros(){
        tableros=new TreeMap<String,TableroLogico>();
    }//Fin del consctructor sin argumentos
    
    /**
     * <p>Método que inserta un tablero en el TreeMap</p>
     * @param n String - Clave del TreeMap
     * @param t TableroLogico - Tablero guardado en el contenedor
     */
    public void insertarTablero(String n,TableroLogico t){
        tableros.put(n,t);
    }//Fin del método insertarTablero
    
    /**
     * <p>Método que elimina un tablero del contenedor dada su clave</p>
     * @param n String - Clave del tablero a eliminar
     */
    public void eliminarTablero(String n){
        tableros.remove(n);
    }//Fin del método eliminarTablero
    
    /**
     * <p>Método que devuelve un tablero dada su clave en el contenedor</p>
     * @param n String - Clave del tablero a devolver
     * @return TableroLogico Tablero correspondiente a la clave introducida
     */
    public TableroLogico devolverTablero(String n){
        return tableros.get(n);
    }//Fin del método devolverTablero
    
    /**
     * <p>Método que comprueba si existe un tablero dada su clave</p>
     * @param n String - Clave del tablero a comprobar
     * @return boolean - True si el tablero está contenido, False si no
     */
    public boolean existirTablero(String n){
        return tableros.containsKey(n);
    }//Fin del método existirTablero
    
    /**
     * <p>Método que almacena los tableros del contenedor en el disco duro</p>
     */
    public void almacenarTableros(){
            FileOutputStream archivo=null;
            ObjectOutputStream flujo=null;
            TableroLogico tablero=null;
            try{
                archivo=new FileOutputStream("listaTableros");
                flujo=new ObjectOutputStream(archivo);
                
            }catch(IOException e){
                System.out.println("Problema en la creación del flujo");
                System.exit(0);
            }//Fin del catch IOException
            Set<String> claves=tableros.keySet();
            Iterator iterador=claves.iterator();
            while(iterador.hasNext()){
                try{
                    tablero=(TableroLogico)tableros.get(iterador.next());
                    flujo.writeObject(tablero);
                }catch(IOException e){
                    System.out.println("Problema al escribir el objeto: "+tablero);
                    System.exit(0);
                }//Fin del catch IOException
            }//Fin del bucle while
            try{
                flujo.close();
            }catch(IOException e){
                System.out.println("Problema al cerrar el flujo");
                System.exit(0);
            }//Fin del catch IOException
    }//Fin del método almacenarTableros
    
    /**
     * <p>Método que lee los tableros guardados en el disco duro y los almacena en el TreeMap</p>
     */
    public void leerTableros(){
        FileInputStream archivo=null;
        ObjectInputStream flujo=null;
        TableroLogico tablero;
        String n;
        try{
            archivo=new FileInputStream("listaTableros");
            flujo=new ObjectInputStream(archivo);
        }catch(IOException e){
            System.out.println("Creación en problema de flujo y archivo");
            System.exit(0);
        }//Fin del catch IOException
        tableros=new TreeMap<String,TableroLogico>();
        try{
            while((tablero=(TableroLogico)flujo.readObject())!=null){
                n=tablero.devolverNick();
                tableros.put(n,tablero);
            }//Fin del bucle while
                   }catch(EOFException e){
                       System.out.println("Fin de lectura de tableros");
                   }//Fin el catch EOFException
                    catch(ClassNotFoundException e){
                        System.out.println("No se puede usar la clase Jugador");
                        System.exit(0);}//Fin del catch ClassNotFoundException
        
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
    }//Fin del métodoleerTableros
            }//Fin de la clase ColectorTableros