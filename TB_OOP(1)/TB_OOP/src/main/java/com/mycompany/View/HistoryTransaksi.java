/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.BookController;
import com.mycompany.Controller.TransactionController;
import com.mycompany.Model.Book;
import com.mycompany.Model.Transaction;
import com.mycompany.Model.User;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author asus
 */
public class HistoryTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form HistoryTransaksi
     */
    User user;
    
    TransactionController tb = new TransactionController();
    BookController conBook = new BookController();
    private DefaultTableModel model;
    public HistoryTransaksi() {
        initComponents();
        setLocationRelativeTo(null);
        
        
        
        model = new DefaultTableModel();
        tblHistory.setModel(model);

        model.addColumn("transaction_id");
        model.addColumn("book_id");
        model.addColumn("borrow_date");
        model.addColumn("return_date");
        model.addColumn("borrow_status");
        model.addColumn("return_status");

        getData();
    }
    
     public final void getData() {
        DefaultTableModel dtm = (DefaultTableModel) tblHistory.getModel();

        dtm.setRowCount(0);
        
        List<Transaction> listTrans = tb.showTransactionUser(user.getId());
        String[] data = new String[6];
        for (Transaction trans : listTrans) {
            data[0] = Integer.toString(trans.getTransaction_id());
            data[1] = trans.getBook_id();
            data[2] = trans.getBorrow_date();
            data[3] = trans.getReturn_date();
            data[4] = Integer.toString(trans.getBorrow_status());
            data[5] = Integer.toString(trans.getReturn_status());
            dtm.addRow(data);
        }
    }
     
    public HistoryTransaksi(User user) {
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        tblHistory.setModel(model);

        model.addColumn("transaction_id");
        model.addColumn("book_id");
        model.addColumn("borrow_date");
        model.addColumn("return_date");
        model.addColumn("borrow_status");
        model.addColumn("return_status");

        getData();
    }
    
    private void clearData() {
        txtBookID.setText("");
        txtTransID.setText("");
        txtBrwDate.setText("");
        txtRtnDate.setText("");
        txtBrwStatus.setText("");
        txtRtnStatus.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        txtTransID = new javax.swing.JTextField();
        txtBookID = new javax.swing.JTextField();
        txtRtnStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBrwDate = new javax.swing.JTextField();
        txtRtnDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBrwStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Book ID", "Borrow Date", "Return Date", "Borrow Status", "Return Status"
            }
        ));
        tblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistory);

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtTransID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTransIDActionPerformed(evt);
            }
        });

        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });

        txtRtnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRtnStatusActionPerformed(evt);
            }
        });

        jLabel1.setText("Transaction_ID");

        jLabel2.setText("Book_ID");

        jLabel3.setText("Borrow_Date");

        jLabel4.setText("Return_Date");

        txtBrwDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrwDateActionPerformed(evt);
            }
        });

        txtRtnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRtnDateActionPerformed(evt);
            }
        });

        jLabel5.setText("Return_Status");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setText("Borrow_Status");

        txtBrwStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrwStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTransID)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtBookID, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(txtRtnDate)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(txtBrwStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(txtRtnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3)
                    .addComponent(txtBrwDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnDelete)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTransID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrwDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRtnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRtnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrwStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
        int i = tblHistory.getSelectedRow();

        TableModel model = tblHistory.getModel();

        txtTransID.setText(model.getValueAt(i, 0).toString());
        txtBookID.setText(model.getValueAt(i, 1).toString());
        txtBrwDate.setText(model.getValueAt(i, 2).toString());
        txtRtnDate.setText(model.getValueAt(i, 3).toString());
        
        String statusBorrow = model.getValueAt(i, 4).toString();
        
        if(statusBorrow.equals("1")){
            txtBrwStatus.setText("Approved");
        }else{
            txtBrwStatus.setText("Not Approved");
        }
        
        String statusReturn = model.getValueAt(i, 5).toString();
        if(statusReturn.equals("1")){
            txtRtnStatus.setText("Approved");
        }else{
            txtRtnStatus.setText("Not Approved");
        }
        
        txtRtnStatus.setEditable(false);
        txtBrwStatus.setEditable(false);
        txtTransID.setEditable(false);
        txtBookID.setEditable(false);
        txtBrwDate.setEditable(false);
        txtRtnDate.setEditable(false);
    }//GEN-LAST:event_tblHistoryMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtTransIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTransIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTransIDActionPerformed

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void txtBrwDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrwDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrwDateActionPerformed

    private void txtRtnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRtnDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRtnDateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int brwStatus = 0;
        int rtnStatus = 0;
        int i = tblHistory.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(btnDelete, "Harap pilih salah satu data!",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (txtBrwStatus.getText().equals("Approved")){
                brwStatus = 1;
            }else if(txtBrwStatus.getText().equals("Not Approved")){
                brwStatus = 0;
            }
            
            if (txtRtnStatus.getText().equals("Approved")){
                rtnStatus = 1;
            }else if(txtRtnStatus.getText().equals("Not Approved")){
                rtnStatus = 0;
            }
           
            if (brwStatus == 1 && rtnStatus == 0) {
                JOptionPane.showMessageDialog(btnDelete, "Data ini tidak dapat dihapus",
                "Warning!", JOptionPane.WARNING_MESSAGE);
            } else if (brwStatus == 0 && rtnStatus == 0) {
                tb.deleteHistory(Integer.parseInt(txtTransID.getText()));
                conBook.updateQtt(Integer.parseInt(txtBookID.getText()));
                JOptionPane.showMessageDialog(btnDelete, "Data Berhasil Dihapus");
                getData();
                clearData();
            } else if (brwStatus == 1 && rtnStatus == 1) {
                tb.deleteHistory(Integer.parseInt(txtTransID.getText()));
                JOptionPane.showMessageDialog(btnDelete, "Data Berhasil Dihapus");
                getData();
                clearData();
            } else {
                JOptionPane.showMessageDialog(btnDelete, "Data tidak memenuhi kriteria untuk dihapus",
                "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtRtnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRtnStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRtnStatusActionPerformed

    private void txtBrwStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrwStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrwStatusActionPerformed

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
            java.util.logging.Logger.getLogger(HistoryTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistory;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBrwDate;
    private javax.swing.JTextField txtBrwStatus;
    private javax.swing.JTextField txtRtnDate;
    private javax.swing.JTextField txtRtnStatus;
    private javax.swing.JTextField txtTransID;
    // End of variables declaration//GEN-END:variables
}
