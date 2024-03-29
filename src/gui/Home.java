/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.DBmodel;
import model.IModel;

/**
 *
 * @author Gitta Szabo
 */
public class Home extends javax.swing.JFrame {

    private IModel model;
    private String connURL;
    private String user;
    private String pass;
    private boolean connected;

    public Home() {
        initComponents();

        setTitle("SwingLibraryTracker");
        setLocationRelativeTo(null);

        connected = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnMembers = new javax.swing.JButton();
        btnBooks = new javax.swing.JButton();
        btnLoan = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miExport = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miLoan = new javax.swing.JMenuItem();
        miBooks = new javax.swing.JMenuItem();
        miMembers = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miConnection = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dublin_library2.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("LibraryTracker - library management project");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnMembers.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnMembers.setText("Members");
        btnMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMembersActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 71, 6, 0);
        jPanel1.add(btnMembers, gridBagConstraints);

        btnBooks.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnBooks.setText("Books");
        btnBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBooksActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 73, 6, 0);
        jPanel1.add(btnBooks, gridBagConstraints);

        btnLoan.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnLoan.setText("Loan ");
        btnLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 0);
        jPanel1.add(btnLoan, gridBagConstraints);

        jMenuBar1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        miExport.setText("Export database to file");
        miExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExportActionPerformed(evt);
            }
        });
        jMenu1.add(miExport);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        miLoan.setText("Loan");
        miLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLoanActionPerformed(evt);
            }
        });
        jMenu2.add(miLoan);

        miBooks.setText("Books");
        miBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBooksActionPerformed(evt);
            }
        });
        jMenu2.add(miBooks);

        miMembers.setText("Members");
        miMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMembersActionPerformed(evt);
            }
        });
        jMenu2.add(miMembers);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Settings");
        jMenu3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        miConnection.setText("Connect to database");
        miConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConnectionActionPerformed(evt);
            }
        });
        jMenu3.add(miConnection);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miExitActionPerformed

    private void miExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExportActionPerformed
        if (connected) {
            JFileChooser jfc = new JFileChooser();
            int selectedOption = jfc.showSaveDialog(this);
            if (selectedOption == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                try {
                    model.exportToFile(new File(selectedFile.getAbsolutePath()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Export error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_miExportActionPerformed

    private void btnMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMembersActionPerformed
        if (connected) {
            MemberDialog md = new MemberDialog(this, true, model);
            md.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "To start, please, connect to your database in Settings > Connect to database in the main window!",
                    "Connect to database", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnMembersActionPerformed

    private void btnBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBooksActionPerformed
        if (connected) {
            BookDialog bd = new BookDialog(this, true, model);
            bd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "To start, please, connect to your database in Settings > Connect to database in the main window!",
                    "Connect to database", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBooksActionPerformed

    private void miMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMembersActionPerformed
        btnMembersActionPerformed(null);
    }//GEN-LAST:event_miMembersActionPerformed

    private void miLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLoanActionPerformed
        btnLoanActionPerformed(null);
    }//GEN-LAST:event_miLoanActionPerformed

    private void miBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBooksActionPerformed
        btnBooksActionPerformed(null);
    }//GEN-LAST:event_miBooksActionPerformed

    private void btnLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanActionPerformed
        if (connected) {
            LoanDialog ld = new LoanDialog(this, true, model);
            ld.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "To start, please, connect to your database in Settings > Connect to database in the main window!",
                    "Connect to database", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnLoanActionPerformed

    private void miConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConnectionActionPerformed
        ConnectionDialog cd = new ConnectionDialog(this, true);
        cd.setVisible(true);

        if (cd.isSave()) {
            connURL = cd.getConnURL();
            user = cd.getUser();
            pass = cd.getPass();
            try {
                Connection conn = DriverManager.getConnection(connURL, user, pass);
                model = new DBmodel(conn);
                connected = true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex + "\n\nPlease, check your database connection data in Settings > Connect to database in the main window!",
                        "Database connection error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miConnectionActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooks;
    private javax.swing.JButton btnLoan;
    private javax.swing.JButton btnMembers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem miBooks;
    private javax.swing.JMenuItem miConnection;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miExport;
    private javax.swing.JMenuItem miLoan;
    private javax.swing.JMenuItem miMembers;
    // End of variables declaration//GEN-END:variables
}
