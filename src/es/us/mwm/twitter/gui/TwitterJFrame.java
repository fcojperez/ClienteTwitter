/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.mwm.twitter.gui;

import es.us.mwm.twitter.client.TwitterClient;
import es.us.mwm.twitter.entities.trends.Trend;
import es.us.mwm.twitter.entities.trends.TrendsSearch;
import es.us.mwm.twitter.entities.tweets.Tweet;
import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


/**
 *
 * @author fcojperez
 */
public class TwitterJFrame extends javax.swing.JFrame {

    private TwitterClient client;
    private DefaultListModel statusesListModel = new DefaultListModel();
    
    
    /**
     * Creates new form TwitterJFrame
     */
    public TwitterJFrame() {
        client = new TwitterClient();
        initComponents();
        try{
            initUserInfo();
            Timer timerTwitter = new Timer("TwitterTimer", false);
            timerTwitter.scheduleAtFixedRate(new TimerTask(){


                @Override
                public void run() {
                    try{
                        System.out.println("Timer Task se está ejecutando");

                        Response response = client.getFriendsTimeline();

                        statusesListModel.clear();


                        List<Tweet> statuses = response.readEntity(new GenericType<List<Tweet>>(){});

                        for(final Tweet st: statuses){
                            SwingUtilities.invokeLater(new Runnable(){

                                @Override
                                public void run() {
                                    statusesListModel.addElement(st);
                                }
                            });
                        }

                        //Obtener de Tweets descargados.
                        jLblTweetsDownloaded.setText("Tweets Descargados: " + String.valueOf(statuses.size()));

                        //Fecha de Recarga

                    }catch(RuntimeException ex){
                        System.err.println("Excepcion llamando a getFriendsTimeLine. Detalles: " + ex.getMessage());
                    }

                }
            }, 500, 100000);
        }catch(IOException ex){
            Logger.getLogger(TwitterJFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error con la conexión de Twitter");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jBttnTweet = new javax.swing.JButton();
        jLblAvatar = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstTweet = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLblNumChar = new javax.swing.JLabel();
        jLblTweetsDownloaded = new javax.swing.JLabel();
        jMnuBarClienteTwitter = new javax.swing.JMenuBar();
        jMnuArchivo = new javax.swing.JMenu();
        jMnuTrending = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setTitle("MWM Cliente Twitter");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jBttnTweet.setText("Tweet");
        jBttnTweet.setMaximumSize(new java.awt.Dimension(40, 29));
        jBttnTweet.setMinimumSize(new java.awt.Dimension(40, 29));
        jBttnTweet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBttnTweetMouseClicked(evt);
            }
        });
        jBttnTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnTweetActionPerformed(evt);
            }
        });

        jLblAvatar.setLabelFor(jTxtEstado);
        jLblAvatar.setMaximumSize(new java.awt.Dimension(48, 48));
        jLblAvatar.setMinimumSize(new java.awt.Dimension(48, 48));
        jLblAvatar.setPreferredSize(new java.awt.Dimension(48, 48));

        jTxtEstado.setDocument(new JTextFieldLimit(144));
        jTxtEstado.setText("Estado");
        jTxtEstado.setToolTipText("");
        jTxtEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtEstadoMouseClicked(evt);
            }
        });
        jTxtEstado.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTxtEstadoInputMethodTextChanged(evt);
            }
        });
        jTxtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtEstadoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtEstadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtEstadoKeyReleased(evt);
            }
        });

        jLstTweet.setModel(statusesListModel);
        jLstTweet.setCellRenderer(new es.us.mwm.twitter.gui.Elemento());
        jScrollPane1.setViewportView(jLstTweet);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLblNumChar.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N

        jLblTweetsDownloaded.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLblTweetsDownloaded.setText("Tweets Descargados: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTweetsDownloaded, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblNumChar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblNumChar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTweetsDownloaded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMnuArchivo.setText("Archivo");

        jMnuTrending.setText("Trending Topics");
        jMnuArchivo.add(jMnuTrending);

        jMnuBarClienteTwitter.add(jMnuArchivo);

        jMenu2.setText("Edit");
        jMnuBarClienteTwitter.add(jMenu2);

        setJMenuBar(jMnuBarClienteTwitter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBttnTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBttnTweet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void jTxtEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtEstadoMouseClicked

        jTxtEstado.setText("");
        jTxtEstado.setForeground(Color.BLACK);
        jLblNumChar.setText("");
    }//GEN-LAST:event_jTxtEstadoMouseClicked

    private void jBttnTweetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBttnTweetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBttnTweetMouseClicked

    private void jTxtEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtEstadoKeyPressed


    }//GEN-LAST:event_jTxtEstadoKeyPressed

    private void jTxtEstadoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTxtEstadoInputMethodTextChanged

        updateContadorCaracteres();
    }//GEN-LAST:event_jTxtEstadoInputMethodTextChanged

    private void jTxtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtEstadoKeyTyped
        
        updateContadorCaracteres();
    }//GEN-LAST:event_jTxtEstadoKeyTyped

    private void jTxtEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtEstadoKeyReleased
        

    }//GEN-LAST:event_jTxtEstadoKeyReleased

    private void jBttnTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBttnTweetActionPerformed
        if(!jTxtEstado.getText().isEmpty() || (jTxtEstado.getText().length()>1)){
           client.updateStatus(jTxtEstado.getText().replace(" ", "%20"));
           jTxtEstado.setText("");
           jLblNumChar.setText("");
        }
    }//GEN-LAST:event_jBttnTweetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwitterJFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBttnTweet;
    private javax.swing.JLabel jLblAvatar;
    private javax.swing.JLabel jLblNumChar;
    private javax.swing.JLabel jLblTweetsDownloaded;
    private javax.swing.JList jLstTweet;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMnuArchivo;
    private javax.swing.JMenuBar jMnuBarClienteTwitter;
    private javax.swing.JMenu jMnuTrending;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtEstado;
    // End of variables declaration//GEN-END:variables

    
    private void initUserInfo() throws MalformedURLException{
        try{
            Response responseUserTimeline = client.getUserTimeline();

            List<Tweet> tweets = responseUserTimeline.readEntity(new GenericType<List<Tweet>>(){
            });

            if(!tweets.isEmpty()){
                Tweet ultimoTweet = tweets.get(0);
                //jTxtEstado.setText(ultimoTweet.getText());
                jTxtEstado.setText("¿Que quieres Twittear?");
                jTxtEstado.setForeground(Color.GRAY);
                String iconSrc = ultimoTweet.getUser().getProfile_image_url();
                URL iconUrl = new URL(iconSrc);
                ImageIcon icon = new ImageIcon(iconUrl,ultimoTweet.getUser().getName());
                jLblAvatar.setIcon(icon);
            }
        }catch(Exception ex){
            System.err.println("Error en la conexión con Twitter");
            JOptionPane.showMessageDialog(new JFrame(), "Error en la conexión con Twitter" , "Dialog",
        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //TODO:7 metodo imprimirTrendingTopics()
    private void imprimirTrendingTopics(){
        Response responseTrends = client.getTrends("1");
        System.out.println("Respuesta completa: " + responseTrends.toString());
        
        List<TrendsSearch> trendsSearches = responseTrends.readEntity(new GenericType<List<TrendsSearch>>(){
        });
        
        if(trendsSearches.isEmpty()){
            for(TrendsSearch trendSearch: trendsSearches){
                System.out.println("Trendings topics metada: " + trendSearch.getCreated_at() + " - " + trendSearch.getLocations().get(0) );
                for(Trend trend: trendSearch.getTrends()){
                    System.out.println(trend.getName());
                }
            }
        }
    }
    
    private void updateContadorCaracteres(){
        if(jLblNumChar.getText().isEmpty() || (jTxtEstado.getText().length() < 1)){
            jLblNumChar.setText("1");
        }else{
            Integer numChar = jTxtEstado.getText().length();
            ++numChar;
            jLblNumChar.setText(String.valueOf(numChar));
        }
    }
}
