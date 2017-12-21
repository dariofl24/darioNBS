/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualplayer;

import java.awt.Color;
import virtualplayer.nodes.Node;

/**
 *
 * @author Dario
 */
public class GameTab extends javax.swing.JFrame {

    private javax.swing.JButton[] tab;
    private int nMaxw=0;
    private int nMinw=0;
    private Vplayer vplayer= new Vplayer();

    public GameTab() {
        initComponents();
        
        javax.swing.JButton[] tab= {B1_1,B1_2,B1_3,
                                    B2_1,B2_2,B2_3,
                                    B3_1,B3_2,B3_3};
        this.tab= tab;
        
    }//0


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        B1_1 = new javax.swing.JButton();
        B1_2 = new javax.swing.JButton();
        B3_1 = new javax.swing.JButton();
        B1_3 = new javax.swing.JButton();
        B2_2 = new javax.swing.JButton();
        B2_1 = new javax.swing.JButton();
        B3_3 = new javax.swing.JButton();
        B3_2 = new javax.swing.JButton();
        B2_3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        B1_1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1_1ActionPerformed(evt);
            }
        });

        B1_2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1_2ActionPerformed(evt);
            }
        });

        B3_1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3_1ActionPerformed(evt);
            }
        });

        B1_3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1_3ActionPerformed(evt);
            }
        });

        B2_2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2_2ActionPerformed(evt);
            }
        });

        B2_1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2_1ActionPerformed(evt);
            }
        });

        B3_3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3_3ActionPerformed(evt);
            }
        });

        B3_2.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3_2ActionPerformed(evt);
            }
        });

        B2_3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        B2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2_3ActionPerformed(evt);
            }
        });

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(B3_1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(B3_2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(B3_3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(B2_1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(B2_2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(B2_3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(B1_1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(B1_2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(B1_3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(B1_2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(B1_1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(B1_3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(B2_1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(B2_2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(B2_3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(B3_1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(B3_2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(B3_3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 65, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(102, 102, 102))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1_1ActionPerformed
        
        this.doMove(0,0);
    }//GEN-LAST:event_B1_1ActionPerformed

    private void B1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1_2ActionPerformed
        
        this.doMove(0,1);
    }//GEN-LAST:event_B1_2ActionPerformed

    private void B1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1_3ActionPerformed
        
        this.doMove(0,2);
    }//GEN-LAST:event_B1_3ActionPerformed

    private void B2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2_1ActionPerformed
        this.doMove(1,0);
    }//GEN-LAST:event_B2_1ActionPerformed

    private void B2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2_2ActionPerformed
        
        this.doMove(1,1);
    }//GEN-LAST:event_B2_2ActionPerformed

    private void B2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2_3ActionPerformed
        
        this.doMove(1,2);
    }//GEN-LAST:event_B2_3ActionPerformed

    private void B3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3_1ActionPerformed
        
        this.doMove(2,0);
    }//GEN-LAST:event_B3_1ActionPerformed

    private void B3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3_2ActionPerformed
        
        this.doMove(2,1);
    }//GEN-LAST:event_B3_2ActionPerformed

    private void B3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3_3ActionPerformed
        
        this.doMove(2,2);
    }//GEN-LAST:event_B3_3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.resetStatate();
    }//GEN-LAST:event_jButton1ActionPerformed

    int movements=0;
    
    private void doMove(int i,int j){
       
        this.updateState(i, j,this.Min_b);
        
        this.movements+=1;
        
        if(this.movements==5){ System.out.println("Max moves");
            this.disableTab();
            return;
        }//
        
        Node move;
        move = this.vplayer.getNextMove(state,this.Min_b);
        
        System.out.println(move);
        
        int diff=0;
        
        for(int ii=0;ii<3;ii++){
            
            for(int jj=0;jj<3;jj++){
                
                if(move.getState()[ii][jj]!=this.state[ii][jj]){ 
                    
                    diff+=1;
                    
                    if(move.isWins()){
                        this.disableTab();
                        this.updateState(ii,jj, Max_b);
                        ii=100;
                        break;
                    }else{
                        this.updateState(ii,jj, Max_b);
                        ii=100;
                        break;
                    }//if - else
                    
                }//if
                
            }//for
            
        }//for
        
        if(diff==0) this.disableTab();
        
    }//getNextMove

    private final String Max_s="O";
    private final String Min_s="X";
    private final int Max = VplayerUtil.Max;
    private final int Min = VplayerUtil.Min;
    private final boolean Max_b= VplayerUtil.Max_b;
    private final boolean Min_b= VplayerUtil.Min_b;
    private int[][] state= new int[3][3];
    
    
    private void updateState(int i,int j,boolean turn){
        
        if(turn){
            state[i][j]=1;
        }else{
            state[i][j]=-1;
        }//if - else
        
        this.tab[(3*i)+j].setText( (turn)?Max_s:Min_s );
        
    }//updateState
    
    private void resetStatate(){
       this.state = new int[3][3];
       
       for(javax.swing.JButton but:this.tab){
           but.setText("");
           but.setEnabled(true);
           but.setForeground(Color.BLACK);
       }//for
       
       vplayer= new Vplayer();
       this.movements=0;
    }//resetStatate
    
    private void disableTab(){
        
        String s;
        
       for(javax.swing.JButton but:this.tab){
           but.setEnabled(false);
           but.setForeground(Color.RED);
           s=but.getText();
           but.setText(s);
       }//for
       
    }//
    
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
            java.util.logging.Logger.getLogger(GameTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameTab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameTab().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1_1;
    private javax.swing.JButton B1_2;
    private javax.swing.JButton B1_3;
    private javax.swing.JButton B2_1;
    private javax.swing.JButton B2_2;
    private javax.swing.JButton B2_3;
    private javax.swing.JButton B3_1;
    private javax.swing.JButton B3_2;
    private javax.swing.JButton B3_3;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
