/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.mwm.twitter.gui;

import es.us.mwm.twitter.client.TwitterClient;
import es.us.mwm.twitter.client.TwitterConfiguracion;

/**
 *
 * @author fperez
 */
public class Configuracion extends javax.swing.JFrame {

    private TwitterConfiguracion configuracion;
    /**
     * Creates new form Configuracion
     */
    public Configuracion() {
        initComponents();
    }
    
    public Configuracion(TwitterClient client){
        this();
        configuracion = client.getConfiguracion();
        
        //Configuracion de num de tweets
        jSlderNumTweets.setValue(configuracion.getNum_tweets());
        jLblNumTweetsValue.setText(String.valueOf(jSlderNumTweets.getValue()));
        
        //Configuracion del timer
        this.jSlderTimer.setValue((int) configuracion.getPeriod_mmsec()/1000);        
        this.jLblTimerValue.setText(String.valueOf(jSlderTimer.getValue()*1000));
    }
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblNumTweets = new javax.swing.JLabel();
        jSlderNumTweets = new javax.swing.JSlider();
        jLblTiimerScheduled = new javax.swing.JLabel();
        jSlderTimer = new javax.swing.JSlider();
        jLblTimerValue = new javax.swing.JLabel();
        jLblNumTweetsValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");
        setResizable(false);

        jLblNumTweets.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblNumTweets.setText("Número de Tweets");

        jSlderNumTweets.setMaximum(20);
        jSlderNumTweets.setMinimum(5);
        jSlderNumTweets.setMinorTickSpacing(5);
        jSlderNumTweets.setPaintLabels(true);
        jSlderNumTweets.setPaintTicks(true);
        jSlderNumTweets.setSnapToTicks(true);
        jSlderNumTweets.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlderNumTweetsStateChanged(evt);
            }
        });

        jLblTiimerScheduled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblTiimerScheduled.setText("Timer");

        jSlderTimer.setMaximum(200);
        jSlderTimer.setMinimum(100);
        jSlderTimer.setMinorTickSpacing(50);
        jSlderTimer.setPaintLabels(true);
        jSlderTimer.setPaintTicks(true);
        jSlderTimer.setSnapToTicks(true);
        jSlderTimer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlderTimerStateChanged(evt);
            }
        });

        jLblTimerValue.setText("jLblTimerValue");

        jLblNumTweetsValue.setText("jLblNumTweetsValue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLblTiimerScheduled, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblNumTweets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlderNumTweets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblNumTweetsValue))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlderTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblTimerValue)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlderNumTweets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblNumTweets)
                    .addComponent(jLblNumTweetsValue))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblTiimerScheduled)
                    .addComponent(jSlderTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblTimerValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSlderTimerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlderTimerStateChanged
        // TODO add your handling code here:
        int periodo_mmsec = this.jSlderTimer.getValue()*1000;
        this.jLblTimerValue.setText(String.valueOf(periodo_mmsec));
        configuracion.setPeriod_mmsec(periodo_mmsec);
    }//GEN-LAST:event_jSlderTimerStateChanged

    private void jSlderNumTweetsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlderNumTweetsStateChanged
        int numTweets = this.jSlderNumTweets.getValue();
        this.jLblNumTweetsValue.setText(String.valueOf(numTweets));
        configuracion.setNum_tweets(numTweets);
    }//GEN-LAST:event_jSlderNumTweetsStateChanged

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblNumTweets;
    private javax.swing.JLabel jLblNumTweetsValue;
    private javax.swing.JLabel jLblTiimerScheduled;
    private javax.swing.JLabel jLblTimerValue;
    private javax.swing.JSlider jSlderNumTweets;
    private javax.swing.JSlider jSlderTimer;
    // End of variables declaration//GEN-END:variables
}
