/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.IModel;
import model.Book;
import model.Member;

/**
 *
 * @author Gitta Szabo
 */
public class BookDialog extends javax.swing.JDialog implements TableModelListener {

    private java.awt.Frame parent;
    private IModel model;
    private List<Book> books;
    private Map<Integer, Book> bookMap;
    private Member selectedMember;
    private Book selectedBook;

    public BookDialog(java.awt.Frame parent, boolean modal, IModel model) {
        super(parent, modal);
        initComponents();

        this.parent = parent;
        this.model = model;

        setTitle("Books");
        setLocationRelativeTo(parent);

        try {
            bookMap = model.bookMap();
            books = model.getAllBook();
            refreshTable();
            tblBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parent, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel dtm = (DefaultTableModel) tblBooks.getModel();
        dtm.addTableModelListener(this);
        tfSearch.setToolTipText("Search");
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
        tblBooks = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Author", "Title", "No. of pages"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooks.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblBooks.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblBooks.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblBooks.getColumnModel().getColumn(2).setPreferredWidth(300);
        tblBooks.getColumnModel().getColumn(3).setPreferredWidth(85);
        tblBooks.setAutoCreateRowSorter(true);
        tblBooks.getRowSorter().toggleSortOrder(1);
        jScrollPane1.setViewportView(tblBooks);

        btnNew.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel1.setText("Book data can be modified in the table below");

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Search books:");

        btnAll.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnAll.setText("List all");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnDelete)
                        .addComponent(btnNew)
                        .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAll, btnClose, btnDelete, btnNew});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAll)
                        .addGap(32, 32, 32)
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        //add a new book to the database
        BookDataDialog bdd = new BookDataDialog(parent, true);
        bdd.setVisible(true);

        if (bdd.isSave()) {
            Book newBook = bdd.getBook();
            try {
                model.addBook(newBook);
                books = model.getAllBook();
                newBook = books.get(books.size() - 1);
                bookMap.put(newBook.getId(), newBook);
                refreshTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(parent, ex, "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //delete a book from the database
        int row = tblBooks.getSelectedRow();
        if (row >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane, "Do you really want to remove this book from the database?", "Confirm deletion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                int selectedBookId = (int) tblBooks.getValueAt(tblBooks.getSelectedRow(), 0);
                selectedBook = bookMap.get(selectedBookId);
                try {
                    model.removeBook(selectedBook);
                    bookMap.remove(selectedBookId);
                    if (selectedMember != null) {
                        books = model.getAllBook(selectedMember);
                    } else {
                        books = model.getAllBook();
                    }
                    refreshTable();
                    if (row > 0) {
                        tblBooks.setRowSelectionInterval(row - 1, row - 1);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Database error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Select a book!",
                    "Nothing is selected", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        String text = tfSearch.getText();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblBooks.getModel());
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
        tblBooks.setRowSorter(rowSorter);
    }//GEN-LAST:event_tfSearchActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        //list all books
        tblBooks.setAutoCreateRowSorter(true);
        try {
            books = model.getAllBook();
            refreshTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parent, ex, "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAllActionPerformed

    public void refreshTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblBooks.getModel();
        dtm.getDataVector().clear();
        dtm.fireTableDataChanged();

        for (Book b : books) {
            Vector row = new Vector();
            row.add(b.getId());
            row.add(b.getAuthor());
            row.add(b.getTitle());
            row.add(b.getPages());
            dtm.addRow(row);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) tblBooks.getModel();
        int row = e.getFirstRow();
        int column = e.getColumn();

        if (e.getType() == TableModelEvent.UPDATE && row >= 0 && column >= 0) {
            Book b = books.get(row);
            Object newValue = dtm.getValueAt(row, column);
            switch (column) {
                case 1:
                    b.setAuthor((String) newValue);
                    break;
                case 2:
                    b.setTitle((String) newValue);
                    break;
                case 3:
                    b.setPages((int) newValue);
                    break;
            }
            try {
                model.updateBook(b);
                bookMap.replace(b.getId(), b);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(parent, ex, "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

}
