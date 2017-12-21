

package bodysim;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileWriter;

/**
 *
 * @author  DarioF
 */
public class NewJFrame extends javax.swing.JFrame {
    
    float mb1,mb2,mb3;
    float b1x,b2x,b3x;
    float b1y,b2y,b3y;
    Graphics graf;
    boolean setp=false,start=false;
    int bturn;
    javax.swing.JTextField[] xi= new javax.swing.JTextField[3];
    javax.swing.JTextField[] yi= new javax.swing.JTextField[3];
    float b1vx,b2vx,b3vx;
    float b1vy,b2vy,b3vy;
    float mtime,dt;
    float[] dts={1,(float).1,(float).01,(float).001,(float).0001};
    int nsim=0,o1,o2,o3;
    
    public NewJFrame() {
        initComponents();
        graf= TextA.getGraphics();
        jFrame1.setVisible(true);
        jFrame1.setSize(686,250);
        jFrame1.setTitle("Sim. Data");this.setTitle("3 Body sim.");
        xi[0]= b1xi; xi[1]= b2xi; xi[2]= b3xi;
        yi[0]= b1yi; yi[1]= b2yi; yi[2]= b3yi;
    }//
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Mb1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b1vix = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b1viy = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        b1xi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        b1yi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        b1set = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Mb2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        b2vix = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        b2viy = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        b2xi = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        b2yi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        b1set1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Mb3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        b3vix = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        b3viy = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        b3xi = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        b3yi = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        b3set = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbdt = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        startB = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        Mtime = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextA = new javax.swing.JTextArea();

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("B1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Mass:");

        Mb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mb1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Kg");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Vix:");

        b1vix.setText("0");
        b1vix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1vixActionPerformed(evt);
            }
        });

        jLabel5.setText("m/s");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Viy:");

        b1viy.setText("0");
        b1viy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1viyActionPerformed(evt);
            }
        });

        jLabel6.setText("m/s");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Xi:");

        b1xi.setBackground(new java.awt.Color(102, 102, 102));
        b1xi.setEditable(false);
        b1xi.setFont(new java.awt.Font("Tahoma", 1, 14));
        b1xi.setForeground(new java.awt.Color(51, 255, 51));

        jLabel9.setText("m");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Yi:");

        b1yi.setBackground(new java.awt.Color(102, 102, 102));
        b1yi.setEditable(false);
        b1yi.setFont(new java.awt.Font("Tahoma", 1, 14));
        b1yi.setForeground(new java.awt.Color(51, 255, 51));

        jLabel10.setText("m");

        b1set.setText("set");
        b1set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1setActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("B2");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel13.setText("Mass:");

        Mb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mb2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Kg");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel15.setText("Vix:");

        b2vix.setText("0");
        b2vix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2vixActionPerformed(evt);
            }
        });

        jLabel16.setText("m/s");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel17.setText("Viy:");

        b2viy.setText("0");
        b2viy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2viyActionPerformed(evt);
            }
        });

        jLabel18.setText("m/s");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel19.setText("Xi:");

        b2xi.setBackground(new java.awt.Color(102, 102, 102));
        b2xi.setEditable(false);
        b2xi.setFont(new java.awt.Font("Tahoma", 1, 14));
        b2xi.setForeground(new java.awt.Color(51, 255, 51));

        jLabel20.setText("m");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel21.setText("Yi:");

        b2yi.setBackground(new java.awt.Color(102, 102, 102));
        b2yi.setEditable(false);
        b2yi.setFont(new java.awt.Font("Tahoma", 1, 14));
        b2yi.setForeground(new java.awt.Color(51, 255, 51));

        jLabel22.setText("m");

        b1set1.setText("set");
        b1set1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1set1ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel23.setForeground(new java.awt.Color(153, 0, 153));
        jLabel23.setText("B3");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel24.setText("Mass:");

        Mb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mb3ActionPerformed(evt);
            }
        });

        jLabel25.setText("Kg");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel26.setText("Vix:");

        b3vix.setText("0");
        b3vix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3vixActionPerformed(evt);
            }
        });

        jLabel27.setText("m/s");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel28.setText("Viy:");

        b3viy.setText("0");
        b3viy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3viyActionPerformed(evt);
            }
        });

        jLabel29.setText("m/s");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel30.setText("Xi:");

        b3xi.setBackground(new java.awt.Color(102, 102, 102));
        b3xi.setEditable(false);
        b3xi.setFont(new java.awt.Font("Tahoma", 1, 14));
        b3xi.setForeground(new java.awt.Color(51, 255, 51));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel31.setText("Yi:");

        b3yi.setBackground(new java.awt.Color(102, 102, 102));
        b3yi.setEditable(false);
        b3yi.setFont(new java.awt.Font("Tahoma", 1, 14));
        b3yi.setForeground(new java.awt.Color(51, 255, 51));

        jLabel32.setText("m");

        jLabel33.setText("m");

        b3set.setText("set");
        b3set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3setActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel34.setText("Simulation");

        jLabel35.setText("M.t :");

        jLabel36.setText("seg.");

        jLabel37.setText("dt:");

        cbdt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", ".1", ".01", ".001", ".0001" }));
        cbdt.setSelectedIndex(3);

        jLabel38.setText("seg.");

        startB.setText("Start");
        startB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Tahoma", 0, 14));
        clear.setForeground(new java.awt.Color(255, 0, 0));
        clear.setText("clear S");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        Mtime.setText("4200");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "caos", "caos.2", "trian", "restr.", "rest.2" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b1viy, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(Mb1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2))
                            .addComponent(b1vix, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(b1xi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(13, 13, 13))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b1set)
                            .addComponent(b1yi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(Mb2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(37, 37, 37))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(129, 129, 129))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b2vix, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(b2viy, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18))
                                .addGap(10, 10, 10))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(b2xi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(b1set1)
                                    .addComponent(b2yi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(4, 4, 4)
                        .addComponent(Mb3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(37, 37, 37))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(129, 129, 129))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b3viy, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(b3vix, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel29)))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(b3xi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32))
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(b3set)
                                    .addComponent(b3yi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel34)
                        .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jFrame1Layout.createSequentialGroup()
                            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel37)
                                .addComponent(jLabel35))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                                    .addComponent(Mtime, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel36))
                                .addGroup(jFrame1Layout.createSequentialGroup()
                                    .addComponent(cbdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel38)))))
                    .addComponent(startB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(Mb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(b3vix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(b3viy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(b3xi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(b3yi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b3set))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(Mb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(b2vix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(b2viy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(b2xi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b2yi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22))
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b1set1))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(Mb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(b1vix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(b1viy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(b1xi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(b1yi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b1set))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(Mtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(cbdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startB)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(clear)
                        .addGap(26, 26, 26))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextA.setBackground(new java.awt.Color(51, 51, 51));
        TextA.setColumns(20);
        TextA.setEditable(false);
        TextA.setFont(new java.awt.Font("Tahoma", 0, 12));
        TextA.setForeground(new java.awt.Color(51, 255, 51));
        TextA.setRows(5);
        TextA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextAMouseClicked(evt);
            }
        });
        TextA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TextAMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(TextA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Mb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mb1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_Mb1ActionPerformed

    private void b1viyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1viyActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_b1viyActionPerformed

    private void b1vixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1vixActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_b1vixActionPerformed

    private void Mb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mb2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_Mb2ActionPerformed

    private void b2vixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2vixActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_b2vixActionPerformed

    private void b2viyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2viyActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_b2viyActionPerformed

    private void Mb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mb3ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_Mb3ActionPerformed

    private void b3vixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3vixActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_b3vixActionPerformed

    private void b3viyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3viyActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_b3viyActionPerformed

    private void b1setActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1setActionPerformed
        if(setp && bturn==0 ){xi[0].setText(""); yi[0].setText("");}
        setp=!setp;
        bturn=0;
    }//GEN-LAST:event_b1setActionPerformed

    private void b1set1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1set1ActionPerformed
        if(setp && bturn==1 ){xi[1].setText(""); yi[1].setText("");}
        setp=!setp;
        bturn=1;
    }//GEN-LAST:event_b1set1ActionPerformed

    private void b3setActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3setActionPerformed
        if(setp && bturn==2 ){xi[2].setText(""); yi[2].setText("");}
        setp=!setp;
        bturn=2;
    }//GEN-LAST:event_b3setActionPerformed

    private void TextAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextAMouseMoved
        if(!setp) return;
        int x,y;
        
        x= TextA.getMousePosition().x;
        y= TextA.getMousePosition().y;
        
        x= (x-(TextA.getSize().width/2))*10;
        y= ((TextA.getSize().height/2)-y)*10;
        
        xi[bturn].setText(x+"");
        yi[bturn].setText(y+"");
        
}//GEN-LAST:event_TextAMouseMoved

    private void TextAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextAMouseClicked
        
        if(setp){
            if(bturn==0){graf.setColor(new Color(0,51,255));}//if
            if(bturn==1){graf.setColor(new Color(255,51,51));}//if
            if(bturn==2){graf.setColor(new Color(153,0,153));}//if
            graf.drawOval(TextA.getMousePosition().x,TextA.getMousePosition().y,5,5);
            
            setp=false; return;
        }//if
        
        if(start){
            simulation();
        }//if
        
}//GEN-LAST:event_TextAMouseClicked

    private void startBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBActionPerformed
        
        try{
            
            mtime= Float.parseFloat(Mtime.getText().trim());
            dt= dts[cbdt.getSelectedIndex()];
            
            mb1= Float.parseFloat(Mb1.getText().trim());
            mb2= Float.parseFloat(Mb2.getText().trim());
            mb3= Float.parseFloat(Mb3.getText().trim());
            
            b1vx= Float.parseFloat( b1vix.getText().trim() );
            b2vx= Float.parseFloat( b2vix.getText().trim() );
            b3vx= Float.parseFloat( b3vix.getText().trim() );
            
            b1vy= Float.parseFloat( b1viy.getText().trim() );
            b2vy= Float.parseFloat( b2viy.getText().trim() );
            b3vy= Float.parseFloat( b3viy.getText().trim() );
            
            b1x= Float.parseFloat(b1xi.getText().trim());
            b2x= Float.parseFloat(b2xi.getText().trim());
            b3x= Float.parseFloat(b3xi.getText().trim());
            
            b1y= Float.parseFloat(b1yi.getText().trim());
            b2y= Float.parseFloat(b2yi.getText().trim());
            b3y= Float.parseFloat(b3yi.getText().trim());
            
            start= true;
            o1=0; o2=0; o3=0;
        }catch(NumberFormatException op){
            
        }//try - catch 
        
}//GEN-LAST:event_startBActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        
        graf.setColor(new Color(51,51,51));
        graf.fillRect(0,0,TextA.getSize().width,TextA.getSize().height);
    }//GEN-LAST:event_clearActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        int s= jComboBox1.getSelectedIndex();
        
        float[][] data={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4200},
            {5500,0,0,-4960,450,4500,0,0,280,2340,7000,0,0,3870,-1410,15500},
            {5000,1,0,-3630,2350,5000,1,0,-3500,-980,4000,1,0,-550,690,2500},
        {250,-1,0,0,1500,250,(float).5,(float).866,860,0,250,(float).5,(float)-.866,-860,0,7500}
        ,{(float).04,0,0,4600,2450,5500,0,(float)-2.23,1900,0,5500,0,(float)2.23,-1900,0,15900}
        ,{(float).04,(float)1.1,0,0,2100,5500,0,(float)-2.23,1900,0,5500,0,(float)2.23,-1900,0,19500}};
        
        Mb1.setText(data[s][0]+""); 
        b1vix.setText(data[s][1]+"");
        b1viy.setText(data[s][2]+"") ;
        b1xi.setText(data[s][3]+"") ;
        b1yi.setText(data[s][4]+"") ;
        
        Mb2.setText(data[s][5]+""); 
        b2vix.setText(data[s][6]+"");
        b2viy.setText(data[s][7]+"") ;
        b2xi.setText(data[s][8]+"") ;
        b2yi.setText(data[s][9]+"") ;
        
        Mb3.setText(data[s][10]+""); 
        b3vix.setText(data[s][11]+"");
        b3viy.setText(data[s][12]+"") ;
        b3xi.setText(data[s][13]+"") ;
        b3yi.setText(data[s][14]+"") ;
        Mtime.setText(data[s][15]+"");
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private void simulation(){
        float t=0,G=(float) 6.6742;
        int it=0;
        
        float d12,d31,d23;
        float d12s,d31s,d23s;
        float f1x,f2x,f3x,f1y,f2y,f3y;
        float x1,x2,x3,y1,y2,y3;
        
            
        
        while(t<=mtime){
            
            d12s= ((b1x-b2x)*(b1x-b2x)) + ((b1y-b2y)*(b1y-b2y));
            d31s= ((b1x-b3x)*(b1x-b3x)) + ((b1y-b3y)*(b1y-b3y));
            d23s= ((b2x-b3x)*(b2x-b3x)) + ((b2y-b3y)*(b2y-b3y));
            
            d12=(float)Math.sqrt(d12s);
            d31=(float)Math.sqrt(d31s); 
            d23=(float)Math.sqrt(d23s); 
            
            f1x= ((G*mb1*mb2)/d12s)*( (b2x-b1x)/d12 );
            f1x= ((G*mb1*mb3)/d31s)*( (b3x-b1x)/d31 )+f1x;
            
            f1y= ((G*mb1*mb2)/d12s)*( (b2y-b1y)/d12 );
            f1y= ((G*mb1*mb3)/d31s)*( (b3y-b1y)/d31 )+f1y;
            
            f2x= ((G*mb1*mb2)/d12s)*( (b1x-b2x)/d12 );
            f2x= ((G*mb2*mb3)/d23s)*( (b3x-b2x)/d23 )+f2x;
            
            f2y= ((G*mb1*mb2)/d12s)*( (b1y-b2y)/d12 );
            f2y= ((G*mb2*mb3)/d23s)*( (b3y-b2y)/d23 )+f2y;
            
            f3x= ((G*mb3*mb2)/d23s)*( (b2x-b3x)/d23 );
            f3x= ((G*mb1*mb3)/d31s)*( (b1x-b3x)/d31 )+f3x;
            
            f3y= ((G*mb3*mb2)/d23s)*( (b2y-b3y)/d23 );
            f3y= ((G*mb1*mb3)/d31s)*( (b1y-b3y)/d31 )+f3y;
            
            x1= ((f1x*dt*dt)/(2*mb1))+(b1vx*dt)+b1x;
            y1= ((f1y*dt*dt)/(2*mb1))+(b1vy*dt)+b1y;
            
            x2= ((f2x*dt*dt)/(2*mb2))+(b2vx*dt)+b2x;
            y2= ((f2y*dt*dt)/(2*mb2))+(b2vy*dt)+b2y;
            
            x3= ((f3x*dt*dt)/(2*mb3))+(b3vx*dt)+b3x;
            y3= ((f3y*dt*dt)/(2*mb3))+(b3vy*dt)+b3y;
            
            b1vx= ((f1x/mb1)*dt)+b1vx;
            b1vy= ((f1y/mb1)*dt)+b1vy;
            
            b2vx= ((f2x/mb2)*dt)+b2vx;
            b2vy= ((f2y/mb2)*dt)+b2vy;
            
            b3vx= ((f3x/mb3)*dt)+b3vx;
            b3vy= ((f3y/mb3)*dt)+b3vy;
            
            Draw(b1x,b1y,x1,y1,1);
            Draw(b2x,b2y,x2,y2,2);
            Draw(b3x,b3y,x3,y3,3);
            
            b1x=x1; b1y=y1;
            b2x=x2; b2y=y2;
            b3x=x3; b3y=y3;
            
            
            t+=dt; it+=1;
        }//while
        
        start= false; nsim+=1;
        TextA.setText("sim:" +nsim);
    }//simulation
    
    private void Draw(float x1,float y1,float x2,float y2,int turn){
        
        int xa1,ya1,xa2,ya2;
        
        if(turn==1){graf.setColor(new Color(0,51,255));}//if
        if(turn==2){graf.setColor(new Color(255,51,51));}//if
        if(turn==3){graf.setColor(new Color(153,0,153));}//if
        
        xa1=(int)((x1 / 10) + (TextA.getSize().width / 2));
        ya1=(int)((TextA.getSize().height / 2) - (y1 / 10));
        
        xa2= (int) ((x2 / 10) + (TextA.getSize().width / 2));
        ya2=(int)((TextA.getSize().height/2)-(y2/10));
        
        if((xa1==xa2) && (ya1==ya2)) return; 
        
        graf.drawLine(xa1,ya1,xa2,ya2); o1+=1;
        if(o1==30){ graf.drawOval(xa2, ya2,5,5); o1=0; }
        
    }//Draw
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mb1;
    private javax.swing.JTextField Mb2;
    private javax.swing.JTextField Mb3;
    private javax.swing.JTextField Mtime;
    private javax.swing.JTextArea TextA;
    private javax.swing.JButton b1set;
    private javax.swing.JButton b1set1;
    private javax.swing.JTextField b1vix;
    private javax.swing.JTextField b1viy;
    private javax.swing.JTextField b1xi;
    private javax.swing.JTextField b1yi;
    private javax.swing.JTextField b2vix;
    private javax.swing.JTextField b2viy;
    private javax.swing.JTextField b2xi;
    private javax.swing.JTextField b2yi;
    private javax.swing.JButton b3set;
    private javax.swing.JTextField b3vix;
    private javax.swing.JTextField b3viy;
    private javax.swing.JTextField b3xi;
    private javax.swing.JTextField b3yi;
    private javax.swing.JComboBox cbdt;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton startB;
    // End of variables declaration//GEN-END:variables
    
}
