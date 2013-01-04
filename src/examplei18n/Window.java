/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examplei18n;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author !gaso
 * @date 03-ene-2012
 */
public class Window extends javax.swing.JFrame {

    //Variable global que determinara properties a Cargar
    private String idioma;

    public Window() {
        initComponents();
        idioma = configLanguage();
        setLanguage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton = new javax.swing.JButton();
        lBienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton.setText("Dame Clic!");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        lBienvenida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lBienvenida.setText("¡Bienvenido!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lBienvenida)
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBienvenida)
                .addGap(33, 33, 33)
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        //empleo de un mensaje por medio de un properties
        JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("infoExtra"));
    }//GEN-LAST:event_botonActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JLabel lBienvenida;
    // End of variables declaration//GEN-END:variables

    /**
     * Configuracion Lenguaje <br> Leer el Archivo de Configuracion de
     * Aplicacion y de acuerdo a su contenido en la clave
     * <strong>language</strong> escoger Idioma para lanzar App.
     *
     * @return properties Retorna el Nombre del Properties que debe de usar de
     * acuerdo al Idioma
     */
    private String configLanguage() {
        ResourceBundle config;
        String properties = "DemoBudle_es"; //Cargar por defecto la aplicacion en Lenguaje Español
        try {
            //Carga del Properties de Configuracion (Solo se agrega el nombre , no es necesario la extension)
            config = ResourceBundle.getBundle("config"); 
            if ("es".equals(config.getString("language"))) { //Idioma Español
                properties = "DemoBudle_es";
            } else if ("en".equals(config.getString("language"))) { //Idioma Ingles
                properties = "DemoBudle_en";
            }
        } catch (ExceptionInInitializerError e) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, "No se pudo encontrar Archivo de Propiedades", e);
        } catch (Exception e) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, "Exception General", e);
        }

        return properties;

    }

    /**
     *  Asignacion de Textos de Acuerdo al Idioma Seleccionado
     */
    private void setLanguage() {
        try {
            this.setTitle(ResourceBundle.getBundle(idioma).getString("tituloVentana"));
            boton.setText(ResourceBundle.getBundle(idioma).getString("textButton"));
            lBienvenida.setText(ResourceBundle.getBundle(idioma).getString("msjBienvenida"));
        } catch (ExceptionInInitializerError e) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, "No se pudo encontrar Archivo de Propiedades de Idioma Seleccionado " + idioma, e);
        } catch (Exception e) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, "Exception General", e);
        }

    }
}
