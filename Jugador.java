//Se importa lo necesario
import java.io.Serializable;

/**
 * <p>Clase que representa un jugador de Minimax, con su nick, password y datos personales. Implementa la interfaz Serializable</p>
 */
public class Jugador implements Serializable{

    private String nick;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private int nvictorias;
    private int nderrotas;
    private String tipo;
    private int puntuacion;
    
    
    /**
     * <p>Constructor sin argumentos de Jugador</p>
     */
    public Jugador()
    {
        nick="";
        password="";
        nombre="";
        apellidos="";
        dni="";
        email="";
        nvictorias=0;
        nderrotas=0;
        tipo="";
        puntuacion=0;
    }//Fin del constructor sin argumentos
    
    /**
     * <p>Constructor que recibe argumentos de Jugador</p>
     * @param k String - Nick
     * @param p String - Password
     * @param n String - Nombre
     * @param a String - Apellidos
     * @param d String - DNI
     * @param e String - e-mail
     */
    public Jugador(String k,String p,String n,String a,String d,String e)
    {
        nick=k;
        password=p;
        nombre=n;
        apellidos=a;
        dni=d;
        email=e;
        nvictorias=0;
        nderrotas=0;
        tipo="";
        puntuacion=0;
    }//Fin del constructor con argumentos
    
    /**
     * <p>Método que cambia el nombre de un jugador</p>
     * @param nombre String - Nombre nuevo del jugador
     */
    public void cambiarNombre(String nombre)
    {
        this.nombre=nombre;
    }//Fin del método cambiarNombre
    
    /**
     * <p>Método que cambia los apellidos de un jugador</p>
     * @param apellidos String - Apellidos nuevos del jugador
     */
    public void cambiarApellidos(String apellidos)
    {
        this.apellidos=apellidos;      
    }//Fin del método cambiarApellidos
    
    /**
     * <p>Método que cambia el DNI de un jugador</p>
     * @param dni String - DNI nuevo del jugador
     */
    public void cambiarDni(String dni)
    {
        this.dni=dni;
    }//Fin del método cambiarDni
    
    /**
     * <p>Método que cambia el e-amil de un jugador</p>
     * @param email String - e-mail nuevo del jugador
     */
    public void cambiarEmail(String email)
    {
        this.email=email;
    }//Fin del método cambiarEmail
    
    /**
     * <p>Método que cambia el número de victorias de un jugador</p>
     * @param nvictorias int - Número de victorias nuevas
     */
    public void cambiarNvictorias(int nvictorias)
    {
        this.nvictorias=nvictorias;
    }//Fin del método cambiarNvictorias
    
    /**
     * <p>Método que cambia el número de derrotas de un jugador</p>
     * @param nderrotas int - Número de derrotas nuevas
     */
    public void cambiarNderrotas(int nderrotas)
    {
        this.nderrotas=nderrotas;
    }//Fin del método cambiarNderrotas
    
    /**
     * <p>Método que cambia el tipo de un jugador</p>
     * @param tipo String - Tipo de jugador nuevo
     */
    public void cambiarTipo(String tipo)
    {
        this.tipo=tipo;
    }//Fin del método cambiarTipo
    
    /**
     * <p>Método que cambia la puntuación del jugador</p>
     * @param puntuacion int - Puntuación nueva
     */
    public void cambiarPuntuacion(int puntuacion)
    {
        this.puntuacion=puntuacion;
    }//Fin del método cambiarPuntuacion
    
    /**
     * <p>Método que devuelve el nick del jugador</p>
     * @return String Nick
     */
    public String devolverNick(){
        return nick;
    }//Fin del método devolverNick
    
    /**
     * <p>Método que devuelve la password del jugador</p>
     * @return String password
     */
    public String devolverPassword(){
        return password;
    }//Fin del método devolverPassword
    
    /**
     * <p>Método que devuelve el nombre del jugador</p>
     * @return String nombre
     */
    public String devolverNombre()
    {
        return nombre;
    }//Fin del método devolverNombre
    
    /**
     * <p>Método que devuelve los apellidos del jugador</p>
     * @return String apellidos
     */
    public String devolverApellidos()
    {
        return apellidos;
    }//Fin del método devolverApellidos
    
    /**
     * <p>Método que devuelve el DNI del jugador</p>
     * @return String DNI
     */
    public String devolverDni()
    {
        return dni;
    }//Fin del método devolverDni
    
    /**
     * <p>Método que devuelve el e-mail del jugador</p>
     * @return String e-mail
     */
    public String devolverEmail()
    {
        return email;
    }//Fin del método devolverEmail
    
    /**
     * <p>Método que devuelve el número de victorias del jugador</p>
     * @return int Nº victorias
     */
    public int devolverNvictorias()
    {
        return nvictorias;
    }//Fin del método devolverNvictorias
    
    /**
     * <p>Método que devuelve el número de derrotas del jugador</p>
     * @return int Nº derrotas
     */
    public int devolverNderrotas()
    {
        return nderrotas;
    }//Fin del método devolverNderrotas
    
    /**
     * <p>Método que devuelve el tipo de jugador</p>
     * @return String Tipo del jugador
     */
    public String devolverTipo()
    {
        return tipo;
    }//Fin del método devolverTipo
    
    /**
     * <p>Método que devuelve la puntuación del jugador</p>
     * @return int Puntuación del jugador
     */
    public int devolverPuntuacion()
    {
        return puntuacion;
    }//Fin del método devolverPuntuacion
    
    /**
     * <p>Método que calcula la Puntuación de un jugador y la modifica</p>
     * @param a int - Nº fichas del jugador
     * @param b int - Nº fichas del rival
     * @param h int - Nº huecos
     */
    public void calcularPuntuacion(int a,int b,int h){
        if(a==0){
            puntuacion=puntuacion-600;
        }//Fin del caso de 0 fichas del jugador
        if(a<=b){
          puntuacion=puntuacion+((a-b)*10);  
        }//Fin del caso del jugador con menos fichas que el rival
        if(b==0){
            puntuacion=puntuacion+600;
        }//Fin del caso de 0 fichas del rival
        if(a>=b){
            puntuacion=puntuacion+((a-b)*10);
        }//Fin del caso del jugador con más fichas que el rival
    }//Fin del método calcularPuntuacion
    
    /**
     * <p>Método que asocia un tipo de jugador según su puntuación</p>
     */
    String calcularTipo()
    {
        if(nvictorias>nderrotas){
            if(puntuacion<0){
                tipo="Esclavo";}
                else{
                if(puntuacion<=3000){
                    tipo="Campesino";
                }
                else if(puntuacion>3000 && puntuacion<=7000){
                        tipo="Mozo de cuadras";
                    }
                    else{
                        if(puntuacion>7000 && puntuacion<=15000){
                            tipo="Caballero";}
                        else{
                            tipo="Señor Feudal";
                        }
                    }
                }
            }//Fin del caso de más victorias que derrotas
        else{
            if(puntuacion>0){
                tipo="Campesino";
            }
            else{
                if(puntuacion>=-2000){
                    tipo="Esclavo";
                }
                else{
                    if(puntuacion>=-6000){
                        tipo="Preso";
                    }
                    else{
                        tipo="Estás destinado a morir en la horca";
                    }
                    }
                }
            }//Fin del caso de más derrotas que victorias
        return tipo;
        }//Fin del método calcularTipo
    
    /**
     * <p>Método que reinicia las estadísticas a 0</p>
     */
    public void reiniciarEstadistica()
    {
        nvictorias=0;
        nderrotas=0;
        tipo="";
        puntuacion=0;
    }//Fin del método reiniciarEstadistica
    
    /**
     * <p>Método que añade una victoria al jugador</p>
     */
    public void victoria(){
       nvictorias++;
    }//Fin del método victoria
    
    /**
     * <p>Método que añade una derrota al jugador</p>
     */
     public void derrota(){
        nderrotas++;
     }//Fin del método derrota
}//Fin de la clase Jugador