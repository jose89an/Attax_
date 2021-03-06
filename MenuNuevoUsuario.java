//Se importa lo necesario
import java.awt.*;
import javax.swing.*;
/**
 * <p>Clase derivada de JPanel que gestiona el men� de registro de los usuarios</p>
 * @author  Jose y Alberto
 */
public class MenuNuevoUsuario extends javax.swing.JPanel {
    
    private String nick;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private TableroGrafico tableroasociado;
    
    /** Creates new form MenuNuevoUsuario */
    public MenuNuevoUsuario(TableroGrafico tableroasociado) {
        this.tableroasociado=tableroasociado;
        initComponents();
    }
    
    public String devolvernick(){
        return nick;
    }
    
    public String devolverpassword(){
        return password;
    }
    
    public String devolvernombre(){
        return nombre;
    }
    
    public String devolverapellidos(){
        return apellidos;
    }
    
    public String devolverdni(){
        return dni;
    }
    
    public String devolveremail(){
        return email;
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabelNick = new javax.swing.JLabel();
        jLabelNick1 = new javax.swing.JLabel();
        jLabelNick2 = new javax.swing.JLabel();
        jLabelNick3 = new javax.swing.JLabel();
        jLabelNick4 = new javax.swing.JLabel();
        jLabelNick5 = new javax.swing.JLabel();
        jnick = new javax.swing.JTextField();
        jnombre = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        japellidos = new javax.swing.JTextField();
        jdni = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 0, 0));
        jLabelNick.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelNick.setForeground(new java.awt.Color(255, 153, 0));
        jLabelNick.setText("Apellidos:");

        jLabelNick1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelNick1.setForeground(new java.awt.Color(255, 153, 0));
        jLabelNick1.setText("e-mail:");

        jLabelNick2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelNick2.setForeground(new java.awt.Color(255, 153, 0));
        jLabelNick2.setText("DNI:");

        jLabelNick3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelNick3.setForeground(new java.awt.Color(255, 153, 0));
        jLabelNick3.setText("Nombre:");

        jLabelNick4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelNick4.setForeground(new java.awt.Color(255, 153, 0));
        jLabelNick4.setText("Nick:");

        jLabelNick5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelNick5.setForeground(new java.awt.Color(255, 153, 0));
        jLabelNick5.setText("Contrase\u00f1a:");

        jButton1.setText("Crear Jugador");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 30));
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Crear Jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNick5)
                            .addComponent(jLabelNick4)
                            .addComponent(jLabelNick3)
                            .addComponent(jLabelNick)
                            .addComponent(jLabelNick2)
                            .addComponent(jLabelNick1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(japellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(jdni, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(jemail, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jnick, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpassword))))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick4))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick5))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick3))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(japellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNick2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNick1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        nick=jnick.getText();
        password=new String(jpassword.getPassword());
        dni=jdni.getText();
        email=jemail.getText();
        nombre=jnombre.getText();
        apellidos=japellidos.getText();
        if(nick.length()==0 || password.length()==0 || dni.length()==0 || email.length()==0 || nombre.length()==0 || apellidos.length()==0){
            JOptionPane.showMessageDialog(tableroasociado, "Te falta alg�n dato por rellenar");
        }
        else if(tableroasociado.devolverColectorjugador().existirJugador(nick)){
            JOptionPane.showMessageDialog(tableroasociado,"Debe elegir otro nick. Ya existe un usuario al que le pertenece");
        }
        else{
            tableroasociado.devolverColectorjugador().nuevoJugador(nick,new Jugador(nick,password,nombre,apellidos,dni,email));
            tableroasociado.getContentPane().removeAll();
            tableroasociado.getContentPane().add(tableroasociado.devolverMenup());
            tableroasociado.pack();
            tableroasociado.devolverMenup().updateUI();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNick;
    private javax.swing.JLabel jLabelNick1;
    private javax.swing.JLabel jLabelNick2;
    private javax.swing.JLabel jLabelNick3;
    private javax.swing.JLabel jLabelNick4;
    private javax.swing.JLabel jLabelNick5;
    private javax.swing.JTextField japellidos;
    private javax.swing.JTextField jdni;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jnick;
    private javax.swing.JTextField jnombre;
    private javax.swing.JPasswordField jpassword;
    // End of variables declaration//GEN-END:variables
    
}
