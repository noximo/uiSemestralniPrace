/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * main.java
 *
 * Created on 15.1.2011, 15:23:27
 */

package ui.aplikace;

/**
 *
 * @author notebook
 */
public class Main extends javax.swing.JFrame {

    /** Creates new form main */
    public Main() {
        initComponents();
        panelHra.setDefault();
        setVisibleBody(false);
    }
    
    private void setVisibleBody(boolean visible){
        panelHraKroky.setVisible(visible);
        jPanelOvladani.setVisible(visible);
        jLabelNebyloVypocitano.setVisible(!visible);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButtonVypocitej = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panelHraKroky = new ui.gui.komponenty.PanelHra();
        jPanelOvladani = new javax.swing.JPanel();
        jButtonDalsiKrok = new javax.swing.JButton();
        jButtonPredchoziKrok = new javax.swing.JButton();
        jLabelAktKrok = new javax.swing.JLabel();
        jLabelCelkemKroku = new javax.swing.JLabel();
        jTextFieldAktKrok = new javax.swing.JTextField();
        jTextFieldCelkemKroku = new javax.swing.JTextField();
        jLabelNebyloVypocitano = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelHra = new ui.gui.komponenty.PanelHra();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rota majora Ticháčka");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButtonVypocitej.setText("Vypočítej");
        jButtonVypocitej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVypocitejActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(jButtonVypocitej, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vypočítaná posloupnost kroků"));
        jPanel1.setPreferredSize(new java.awt.Dimension(349, 430));

        jPanelOvladani.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ovládání"));

        jButtonDalsiKrok.setText("Další krok");

        jButtonPredchoziKrok.setText("Předchozí krok");

        jLabelAktKrok.setText("Aktuální krok");

        jLabelCelkemKroku.setText("Celkem kroků");

        jTextFieldAktKrok.setEditable(false);
        jTextFieldAktKrok.setText("0");

        jTextFieldCelkemKroku.setEditable(false);
        jTextFieldCelkemKroku.setText("0");

        javax.swing.GroupLayout jPanelOvladaniLayout = new javax.swing.GroupLayout(jPanelOvladani);
        jPanelOvladani.setLayout(jPanelOvladaniLayout);
        jPanelOvladaniLayout.setHorizontalGroup(
            jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOvladaniLayout.createSequentialGroup()
                .addGroup(jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDalsiKrok)
                    .addComponent(jLabelAktKrok)
                    .addComponent(jLabelCelkemKroku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonPredchoziKrok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCelkemKroku, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldAktKrok, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanelOvladaniLayout.setVerticalGroup(
            jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOvladaniLayout.createSequentialGroup()
                .addGroup(jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDalsiKrok)
                    .addComponent(jButtonPredchoziKrok))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAktKrok)
                    .addComponent(jTextFieldAktKrok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOvladaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCelkemKroku)
                    .addComponent(jTextFieldCelkemKroku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabelNebyloVypocitano.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNebyloVypocitano.setForeground(new java.awt.Color(251, 0, 0));
        jLabelNebyloVypocitano.setText("Řešení ještě nebylo vypočítáno!!!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNebyloVypocitano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(272, 272, 272))
                    .addComponent(jPanelOvladani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHraKroky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelNebyloVypocitano)
                .addGap(1, 1, 1)
                .addComponent(panelHraKroky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelOvladani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Původní stav"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelHra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelHra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVypocitejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVypocitejActionPerformed
        // TODO add your handling code here:
        
        setVisibleBody(true);
    }//GEN-LAST:event_jButtonVypocitejActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDalsiKrok;
    private javax.swing.JButton jButtonPredchoziKrok;
    private javax.swing.JButton jButtonVypocitej;
    private javax.swing.JLabel jLabelAktKrok;
    private javax.swing.JLabel jLabelCelkemKroku;
    private javax.swing.JLabel jLabelNebyloVypocitano;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelOvladani;
    private javax.swing.JTextField jTextFieldAktKrok;
    private javax.swing.JTextField jTextFieldCelkemKroku;
    private ui.gui.komponenty.PanelHra panelHra;
    private ui.gui.komponenty.PanelHra panelHraKroky;
    // End of variables declaration//GEN-END:variables

}
