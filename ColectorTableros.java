//Se importa lo necesario
import java.util.*;
import java.io.*;
/**
 * <p>Clase que incluye un contenedor que guarda tableros l�gicos seg�n una clave, su nick, empleando un TreeMap que tiene como clave un String y como valor un TableroLogico</p>
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
     * <p>M�todo que inserta un tablero en el TreeMap</p>
     * @param n String - Clave del TreeMap
     * @param t TableroLogico - Tablero guardado en el contenedor
     */
    public void insertarTablero(String n,TableroLogico t){
        tableros.put(n,t);
    }//Fin del m�todo insertarTablero
    
    /**
     * <p>M�todo que elimina un tablero del contenedor dada su clave</p>
     * @param n String - Clave del tablero a eliminar
     */
    public void eliminarTablero(String n){
        tableros.remove(n);
    }//Fin del m�todo eliminarTablero
    
    /**
     * <p>M�todo que devuelve un tablero dada su clave en el contenedor</p>
     * @param n String - Clave del tablero a devolver
     * @return TableroLogico Tablero correspondiente a la clave introducida
     */
    public TableroLogico devolverTablero(String n){
        return tableros.get(n);
    }//Fin del m�todo devolverTablero
    
    /**
     * <p>M�todo que comprueba si existe un tablero dada su clave</p>
     * @param n String - Clave del tablero a comprobar
     * @return boolean - True si el tablero est� contenido, False si no
     */
    public boolean existirTablero(String n){
        return tableros.containsKey(n);
    }//Fin del m�todo existirTablero
    
    /**
     * <p>M�todo que almacena los tableros del contenedor en el disco duro</p>
     */
    public void almacenarTableros(){
            FileOutputStream archivo=null;
            ObjectOutputStream flujo=null;
            TableroLogico tablero=null;
            try{
                archivo=new FileOutputStream("listaTableros");
                flujo=new ObjectOutputStream(archivo);
                
            }catch(IOException e){
                System.out.println("Problema en la creaci�n del flujo");
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
    }//Fin del m�todo almacenarTableros
    
    /**
     * <p>M�todo que lee los tableros guardados en el disco duro y los almacena en el TreeMap</p>
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
            System.out.println("Creaci�n en problema de flujo y archivo");
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
    }//Fin del m�todoleerTableros
            }//Fin de la clase ColectorTableros