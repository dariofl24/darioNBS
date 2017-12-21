
package renderbuffered;

import grapher3d.functions.ParaboloidS;
import grapher3d.functions.axis.*;
import grapher3d.render.RederHelper;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import topology.dimension.Vector2D;
import topology.dimension.Vector3D;
import topology.dimension.shape.Line2D;
import topology.dimension.shape.Line3D;
import topology.function.FunctionParametric3D;
import topology.function.impl.Function1;
import topology.function.impl.Surface1;
import topology.util.FunctionParametricEvaluator;
import topology.util.FunctionSurfaceEvaluator;

/**
 *
 * @author Dario
 */
public class GrapherPannel extends javax.swing.JFrame {
    
    private final double PI=3.14159;
    private double X0=0,Y0=0,lpp=0.02;
    private double radius= 30.0,focus=10.0;
    private ArrayList<Line3D> lines3D;
    
    private Graphics graf;
    
    private BufferedImage buffImage;
    private Graphics bgraf;
    
    public GrapherPannel() {
        initComponents();
        
        this.lines3D= new ArrayList<Line3D>();
        
        this.updatePhi();
        this.updateTheta();
        this.setScreenSetings(X0, Y0, lpp,radius,focus);
        
        graf = this.graphArea.getGraphics();
        System.out.println(this.graphArea.getWidth()+","+this.graphArea.getHeight());
        
        buffImage= new BufferedImage(this.graphArea.getWidth(),
                this.graphArea.getHeight(),
                BufferedImage.TYPE_3BYTE_BGR);
        
        bgraf= buffImage.getGraphics();
        
        this.initPointSets();
    }//0

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        graphArea = new javax.swing.JTextArea();
        thetaSlider = new javax.swing.JSlider();
        phiSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        thetaOut = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phiOut = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        radiusIn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        focusIn = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        phiOutPercent = new javax.swing.JTextField();
        thetaOutPercent = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        x0in = new javax.swing.JTextField();
        y0in = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lppin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        graphArea.setEditable(false);
        graphArea.setBackground(new java.awt.Color(51, 51, 51));
        graphArea.setColumns(20);
        graphArea.setForeground(new java.awt.Color(51, 51, 51));
        graphArea.setRows(20);
        graphArea.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(graphArea);

        thetaSlider.setMaximum(1000);
        thetaSlider.setValue(0);
        thetaSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thetaSliderStateChanged(evt);
            }
        });

        phiSlider.setMaximum(1000);
        phiSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        phiSlider.setValue(500);
        phiSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                phiSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Theta:");

        thetaOut.setEditable(false);

        jLabel2.setText("Phi:");

        phiOut.setEditable(false);
        phiOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phiOutActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setText("Radius:");

        jLabel4.setText("Focus:");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        phiOutPercent.setEditable(false);

        jLabel5.setText("Panel:");

        jLabel6.setText("X0=");

        jLabel7.setText("Y0=");

        x0in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x0inActionPerformed(evt);
            }
        });

        jLabel8.setText("L.P.P=");

        lppin.setToolTipText("Lenght per Pixel");

        jButton1.setText("CAP");
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
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(thetaSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(phiSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jSeparator1)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jSeparator3)
                                    .add(jPanel1Layout.createSequentialGroup()
                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(jButton1)
                                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                    .add(jLabel3)
                                                    .add(radiusIn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                    .add(jLabel4)
                                                    .add(focusIn))
                                                .add(jLabel5)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                    .add(jPanel1Layout.createSequentialGroup()
                                                        .add(jLabel7)
                                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                        .add(y0in))
                                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .add(jLabel6)
                                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                        .add(x0in, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                                .add(jPanel1Layout.createSequentialGroup()
                                                    .add(jLabel8)
                                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                    .add(lppin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                        .add(0, 24, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(phiOutPercent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .add(phiOut))
                        .add(0, 0, Short.MAX_VALUE))))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(thetaOut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(thetaOutPercent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(okButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(phiOut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(phiOutPercent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(radiusIn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jLabel4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(focusIn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel6)
                                    .add(x0in, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel7)
                                    .add(y0in, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel8)
                                    .add(lppin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jButton1)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(jSeparator2)))
                    .add(phiSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 534, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(158, 158, 158))
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 540, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(thetaSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(thetaOut, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(thetaOutPercent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(okButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 613, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phiOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phiOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phiOutActionPerformed

    private void phiSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_phiSliderStateChanged
        this.updatePhi();
        
        if(Bussy){
            System.out.println("Bussy");
            return;
        }//if
        
        try {
            this.Render();
        } catch (Exception ex) {
            System.err.println(ex);
        }//try - catch
    }//GEN-LAST:event_phiSliderStateChanged

    private void thetaSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thetaSliderStateChanged
      
       this.updateTheta();
       
       if(Bussy){
           System.out.println("Bussy");
            return;
        }//if
       
       try {
            this.Render();
        } catch (Exception ex) {
            System.err.println(ex);
        }//try - catch
    }//GEN-LAST:event_thetaSliderStateChanged

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        
        if(Bussy){
            System.out.println("Bussy");
            return;
        }//if
        
        try {
            this.Render();
        } catch (Exception ex) {
            System.err.println(ex);
        }//try - catch
    }//GEN-LAST:event_okButtonActionPerformed

    private void x0inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x0inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x0inActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        File img;
        String home= "/Users/Dario/Desktop/renders/";
        String fname;
        
        double phi,theta,radius,focus;
        
        phi= this.getPhi();
        theta= this.getTheta();
        radius= this.getScreenRadius();
        focus= this.getScreenFocus();
        
        fname= phi+"-"+theta+"-"+radius+"-"+focus+".png";
        
        img = new File(home+fname);
        
        try {
            
            ImageIO.write(this.buffImage,"png",img);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }//try - catch
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private static volatile boolean Bussy=false;
    
    private void Render() throws Exception{
        
        if(!Bussy){
            
            Bussy=true;
            
            try{
                this.doRender();
            }catch(java.lang.OutOfMemoryError ex){
                
                this.imageMap.clear();
                System.gc();
                Bussy=false;
                this.Render();
            }//try - catch
            
            Bussy=false;
        }else{
            System.out.println("Bussy render");
            return;
        }//if - else
        
    }//render
    
    private HashMap<String,BufferedImage> imageMap= new HashMap<String,BufferedImage>();
    
    private synchronized void doRender() throws Exception{
        
        double phi,theta,radius,focus,x0,y0,lpp;
        String hash="";
        
        phi= this.getPhi();
        theta= this.getTheta();
        radius= this.getScreenRadius();
        focus= this.getScreenFocus();
        
        x0= this.getScreenX0();
        y0= this.getScreenY0();
        lpp= this.getScreenLpp();
        
        hash=""+phi+theta+radius+focus+x0+y0+lpp;
        
        BufferedImage img;
        
        if(imageMap.containsKey(hash)){
            img = imageMap.get(hash);
            System.out.println(">>> Y:"+imageMap.size());
        }else{
            System.out.println(">>> N");
            img= new BufferedImage(this.graphArea.getWidth(),
                this.graphArea.getHeight(),
                BufferedImage.TYPE_3BYTE_BGR);
            
            ArrayList<Line2D> lines2render= 
                RederHelper.get2Dprojection(phi,theta,radius,focus,x0,y0,lpp,this.getPx0(),this.getPy0(),lines3D);
            
            this.setInImage(lines2render,img.getGraphics());
            this.imageMap.put(hash, img);
            
        }//if - else
        
        this.buffImage= img;
        this.graf.drawImage(img,0,0,null);
        
    }//Render
    
    private void setInImage(ArrayList<Line2D> lines2render,Graphics graf){
        
        graf.setColor(new Color(51,51,51));
        graf.fillRect(0,0,this.graphArea.getSize().width,this.graphArea.getSize().height);
        graf.setColor(Color.BLUE);
        
        Vector2D v1,v2;
        int[] plx;
        int[] ply;
        
        for(Line2D line:lines2render){
            
            if(line.size()<=1) continue;
            
            plx= new int[line.size()];
            ply= new int[line.size()];
            
            for(int i=0;i<line.size();i++){
                
                plx[i]= (int) line.get(i).getX();
                ply[i]= (int) line.get(i).getY();
            }//for
            
            graf.drawPolyline(plx, ply,plx.length);
            
        }//for
        
    }//setInImage
    
    private void setImage(ArrayList<Line2D> lines2render){
        
        this.graf.setColor(new Color(51,51,51));
        this.graf.fillRect(0,0,this.graphArea.getSize().width,this.graphArea.getSize().height);
        this.graf.setColor(Color.BLUE);
        
        this.bgraf.setColor(new Color(51,51,51));
        this.bgraf.fillRect(0,0,this.graphArea.getSize().width,this.graphArea.getSize().height);
        this.bgraf.setColor(Color.BLUE);
        
        Vector2D v1,v2;
        int[] plx;
        int[] ply;
        
        for(Line2D line:lines2render){
            
            if(line.size()<=1) continue;
            
            plx= new int[line.size()];
            ply= new int[line.size()];
            
            for(int i=0;i<line.size();i++){
                
                plx[i]= (int) line.get(i).getX();
                ply[i]= (int) line.get(i).getY();
            }//for
            
            this.graf.drawPolyline(plx, ply,plx.length);
            this.bgraf.drawPolyline(plx, ply,plx.length);
        }//for
        
    }//setImage
    
    private double getPhi(){
       double per= this.getPhiSliderValue();
       return (per*this.PI);
    }//getPhi
    
    private double getTheta(){
        double per=this.getThetaSliderValue();
        return per*(2.0d)*this.PI;
    }//getTheta
    
    private void updatePhi(){
        double per= this.getPhiSliderValue();
        String val = (per*this.PI)+""; 
        
        this.phiOut.setText((val.length()>9)?val.substring(0,9):val);
        this.phiOutPercent.setText((per)+" pi");
    }//
    
    private void updateTheta(){
        double per=this.getThetaSliderValue();
        String val = (per*(2.0d)*this.PI)+"";
        
        this.thetaOut.setText((val.length()>9)?val.substring(0,9):val);
        this.thetaOutPercent.setText((per*2.0d)+" pi");
    }//
    
    private void setScreenSetings(double x0,double y0,double lpp,double radius,double focus){
        this.x0in.setText(x0+"");
        this.y0in.setText(y0+"");
        this.lppin.setText(lpp+"");
        this.radiusIn.setText(radius+"");
        this.focusIn.setText(focus+"");
        
    }//
    
    private double getScreenX0() throws Exception{
       return new Double( this.x0in.getText() ); 
    }//getScreenX0
    
    private double getScreenY0() throws Exception{
       return new Double( this.y0in.getText() ); 
    }//getScreenY0
    
    private double getScreenLpp(){
        return new Double( this.lppin.getText() );
    }//getScreenLpp
    
    private double getScreenRadius(){
        return new Double(this.radiusIn.getText());
    }//getScreenRadius
    
    private double getScreenFocus(){
        return new Double(this.focusIn.getText());
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
            java.util.logging.Logger.getLogger(GrapherPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrapherPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrapherPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrapherPannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrapherPannel().setVisible(true);
            }
        });
    }//
    
    private double getPx0(){
       return (new Double(graphArea.getSize().width))/2.0d;
    }//getPx0
    
    private double getPy0(){
        return (new Double(graphArea.getSize().height))/2.0d;
    }//getPy0
    
    private double getPhiSliderValue(){
        
        double per= (new Double(1000-this.phiSlider.getValue()))/1000.0d;
        
        return per;
    }//
    
    private double getThetaSliderValue(){
        
        double per= ( new Double( this.thetaSlider.getValue() ) )/1000.0d;
        
        return per;
    }//
    
    private void initPointSets(){
        
        ArrayList<FunctionParametric3D> functions= new ArrayList<FunctionParametric3D>();
        double len = 60.0;
        double dl=0.1;
        
        
        functions.add(new xplusaxis());
        functions.add(new xminusaxis());
        
        functions.add(new yplusaxis());
        functions.add(new yminusaxis());
        
        functions.add(new zplusaxis());
        functions.add(new zminusaxis());
        
        FunctionParametricEvaluator eval;
        
        for(FunctionParametric3D f3d:functions){
            
            eval= new FunctionParametricEvaluator(f3d);
            
            lines3D.add(eval.getValues(0,len,dl));
            
        }//for
        
        //eval= new FunctionParametricEvaluator( new Function1() );
        //lines3D.add(eval.getValues(0,(2.0d*this.PI),0.005d));
        
        //FunctionSurfaceEvaluator evalS= new FunctionSurfaceEvaluator(new Surface1());
        //lines3D.addAll(evalS.getValues(-24,-24,24,24,0.25,0.25));
        
        FunctionSurfaceEvaluator evalS= new FunctionSurfaceEvaluator(new ParaboloidS());
        lines3D.addAll(evalS.getValues(-12,-12,12,12,0.25,0.25));
        
    }//initPointSets
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField focusIn;
    private javax.swing.JTextArea graphArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField lppin;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField phiOut;
    private javax.swing.JTextField phiOutPercent;
    private javax.swing.JSlider phiSlider;
    private javax.swing.JTextField radiusIn;
    private javax.swing.JTextField thetaOut;
    private javax.swing.JTextField thetaOutPercent;
    private javax.swing.JSlider thetaSlider;
    private javax.swing.JTextField x0in;
    private javax.swing.JTextField y0in;
    // End of variables declaration//GEN-END:variables
}
