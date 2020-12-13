/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.g1.vista;

import ec.edu.ups.appdis.g1.modelo.Administrativo;
import ec.edu.ups.appdis.g1.negocio.AdministrativoONRemoto;
import ec.edu.ups.appdis.g1.negocio.CorreoONRemoto;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JOptionPane;

/**
 *
 * @author aloja
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private AdministrativoONRemoto on;
    private CorreoONRemoto co;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        try {
            initComponents();
            this.referenciarONAdministrativo();
        } catch (Exception ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        Jlogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        MLogin = new javax.swing.JMenu();
        MAdministrador = new javax.swing.JMenu();
        Acrear = new javax.swing.JMenuItem();
        Apoliza = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        MCajero = new javax.swing.JMenu();
        CCrear = new javax.swing.JMenuItem();
        CTransacciones = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        MAsistente = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        MCliente = new javax.swing.JMenu();
        CResumen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cedula:");

        jLabel2.setText("Contrase�a:");

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JloginLayout = new javax.swing.GroupLayout(Jlogin);
        Jlogin.setLayout(JloginLayout);
        JloginLayout.setHorizontalGroup(
            JloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JloginLayout.createSequentialGroup()
                .addGroup(JloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JloginLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(JloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JloginLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword))
                            .addGroup(JloginLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JloginLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnAceptar)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        JloginLayout.setVerticalGroup(
            JloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JloginLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(JloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addGap(19, 19, 19))
        );

        desktopPane.add(Jlogin);
        Jlogin.setBounds(90, 50, 340, 260);

        MLogin.setText("Cerrar Sesi�n");
        MLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MLoginMouseClicked(evt);
            }
        });
        menuBar.add(MLogin);

        MAdministrador.setMnemonic('f');
        MAdministrador.setText("Administrador");

        Acrear.setMnemonic('o');
        Acrear.setText("Crear Nuevos");
        Acrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcrearActionPerformed(evt);
            }
        });
        MAdministrador.add(Acrear);

        Apoliza.setMnemonic('s');
        Apoliza.setText("Parametroz Poliza");
        Apoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApolizaActionPerformed(evt);
            }
        });
        MAdministrador.add(Apoliza);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        MAdministrador.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        MAdministrador.add(exitMenuItem);

        menuBar.add(MAdministrador);

        MCajero.setMnemonic('e');
        MCajero.setText("Cajero");

        CCrear.setMnemonic('t');
        CCrear.setText("Crear Usuario");
        CCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCrearActionPerformed(evt);
            }
        });
        MCajero.add(CCrear);

        CTransacciones.setMnemonic('y');
        CTransacciones.setText("Transacciones");
        CTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTransaccionesActionPerformed(evt);
            }
        });
        MCajero.add(CTransacciones);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        MCajero.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        MCajero.add(deleteMenuItem);

        menuBar.add(MCajero);

        MAsistente.setMnemonic('h');
        MAsistente.setText("Asistente");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        MAsistente.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        MAsistente.add(aboutMenuItem);

        menuBar.add(MAsistente);

        MCliente.setText("Cliente");

        CResumen.setText("Resumen");
        CResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CResumenActionPerformed(evt);
            }
        });
        MCliente.add(CResumen);

        menuBar.add(MCliente);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void AcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcrearActionPerformed
        VentanaAdministrativo va=new   VentanaAdministrativo();
        desktopPane.add(va);
    }//GEN-LAST:event_AcrearActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        java.util.Date fecha = new Date();
        List<Administrativo> a = on.buscarCliente(txtCedula.getText());
        for (int i = 0; i < a.size(); i++) {
            try {
                String email = a.get(i).getEmail();
                String password = a.get(i).getPassword();
                String password2 = txtPassword.getText();
                this.referenciarONACorreo();
                co.sendAsHtml(email, "Intento de Ingreso Cuenta Bancaria", "Hora de intento: " + fecha);
                if (password.equals(password2)) {
                    Jlogin.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "La contrase�a no es correcto");
                }
            } catch (Exception ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error boton aceptar");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void MLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MLoginMouseClicked
        Jlogin.setVisible(true);
        MAdministrador.setVisible(false);
        MCajero.setVisible(false);
        MAsistente.setVisible(false);
    }//GEN-LAST:event_MLoginMouseClicked

    private void ApolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApolizaActionPerformed
        VentanaAdministrarPoliza vap = new VentanaAdministrarPoliza();
        desktopPane.add(vap);
    }//GEN-LAST:event_ApolizaActionPerformed

    private void CCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCrearActionPerformed
        VentanaCrearCliente vc = new VentanaCrearCliente();
        desktopPane.add(vc);
    }//GEN-LAST:event_CCrearActionPerformed

    private void CResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CResumenActionPerformed
        VentanaResumenCuenta vrc = new VentanaResumenCuenta();
        desktopPane.add(vrc);
    }//GEN-LAST:event_CResumenActionPerformed

    private void CTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTransaccionesActionPerformed
        VentanaCajero vc=new VentanaCajero();
        desktopPane.add(vc);
    }//GEN-LAST:event_CTransaccionesActionPerformed
    public void referenciarONACorreo() throws Exception {
        try {
            final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "pepe");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "pepe");

            final Context context = new InitialContext(jndiProperties);

            final String lookupName = "ejb:/banco/CorreoON!ec.edu.ups.appdis.g1.negocio.CorreoONRemoto";

            this.co = (CorreoONRemoto) context.lookup(lookupName);

        } catch (Exception ex) {
            System.out.println("Error ventana principal");
            ex.printStackTrace();
        }
    }

    public void referenciarONAdministrativo() throws Exception {
        try {
            final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "pepe");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "pepe");

            final Context context = new InitialContext(jndiProperties);

            final String lookupName = "ejb:/banco/AdministrativoON!ec.edu.ups.appdis.g1.negocio.AdministrativoONRemoto";

            this.on = (AdministrativoONRemoto) context.lookup(lookupName);

        } catch (Exception ex) {
            System.out.println("hola");
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Acrear;
    private javax.swing.JMenuItem Apoliza;
    private javax.swing.JMenuItem CCrear;
    private javax.swing.JMenuItem CResumen;
    private javax.swing.JMenuItem CTransacciones;
    private javax.swing.JPanel Jlogin;
    private javax.swing.JMenu MAdministrador;
    private javax.swing.JMenu MAsistente;
    private javax.swing.JMenu MCajero;
    private javax.swing.JMenu MCliente;
    private javax.swing.JMenu MLogin;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables

}