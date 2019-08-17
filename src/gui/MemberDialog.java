/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import comparators.MemberIdComparator;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.IModel;
import model.Member;

/**
 *
 * @author Gitta Szabo
 */
public class MemberDialog extends javax.swing.JDialog {

    private IModel model;
    private Frame parent;
    List<Member> members;

    public MemberDialog(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        this.model = model;
        this.parent = parent;

        setTitle("Members");
        setLocationRelativeTo(parent);

        refreshList();
    }

    public void refreshList() {
        //list all members
        try {
            members = model.getAllMember();
            Collections.sort(members, new MemberIdComparator());
            members.remove(0);
            lstMembers.setListData(members.toArray());
            lstMembers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstMembers = new javax.swing.JList();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstMembers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstMembers);

        btnNew.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Search members:");

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btnAll.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnAll.setText("List All");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearch))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNew)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnDelete)
                    .addComponent(btnAll))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAll, btnClose, btnDelete, btnEdit, btnNew});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAll))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //delete selected member
        Member selected = (Member) lstMembers.getSelectedValue();

        if (selected != null) {
            int option = JOptionPane.showConfirmDialog(rootPane, "Do you really want to remove this member from the database?",
                    "Confirm deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    if (model.getAllBook(selected).isEmpty()) {
                        model.removeMember(selected);
                        members.remove(selected);
                        refreshList();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Books are currently loaned out to this "
                                + "member, thus this member cannot be removed from the database.",
                            "Member cannot be deleted", JOptionPane.ERROR_MESSAGE);
                    }                
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "<html><body><p style='width: 200px;'>" + ex + "</p></body></html>",
                            "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a member!",
                    "Nobody is selected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        //enter a new member
        MemberDataDialog mdd = new MemberDataDialog(parent, true, null);
        mdd.setVisible(true);

        if (mdd.isSave()) {
            try {
                model.addMember(mdd.getMember());
                refreshList();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        //update member data
        Member selected = (Member) lstMembers.getSelectedValue();
        if (selected != null) {
            MemberDataDialog mdd = new MemberDataDialog(parent, true, selected);
            mdd.setVisible(true);

            if (mdd.isSave()) {
                try {
                    model.updateMember(selected);                  
                    if (tfSearch.getText().trim().length()==0) {
                        refreshList();
                    }else{
                        tfSearchActionPerformed(null);
                    }
               } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a member!",
                    "Nobody is selected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        String text = tfSearch.getText().toLowerCase();
        if (text.trim().length()!=0) {
            List<Member> filteredMembers = new ArrayList<>();
            for (Member m : members) {
                if (m.toString().toLowerCase().contains(text)) {
                    filteredMembers.add(m);
                }
            }
            if (!filteredMembers.isEmpty()) {
                lstMembers.setListData(filteredMembers.toArray());
            }else{
                JOptionPane.showMessageDialog(rootPane, "No match found",
                    "No matches", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }//GEN-LAST:event_tfSearchActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        refreshList();
    }//GEN-LAST:event_btnAllActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstMembers;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}