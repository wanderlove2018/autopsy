/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2013-2018 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.modules.stix;

import java.io.File;
import javax.swing.JFileChooser;
import org.sleuthkit.autopsy.coreutils.ModuleSettings;

/**
 *
 */
public class STIXReportModuleConfigPanel extends javax.swing.JPanel {

    String stixFile = null;
    boolean showAllResults;

    /**
     * Creates new form STIXReportModuleConfigPanel
     */
    public STIXReportModuleConfigPanel() {
        initComponents();

        // Set the default path to the last one used
        if ((ModuleSettings.getConfigSetting("STIX", "defaultPath") != null) //NON-NLS
                && (!ModuleSettings.getConfigSetting("STIX", "defaultPath").isEmpty())) { //NON-NLS
            jTextField1.setText(ModuleSettings.getConfigSetting("STIX", "defaultPath")); //NON-NLS
            stixFile = ModuleSettings.getConfigSetting("STIX", "defaultPath"); //NON-NLS
        }

        // Set the results checkbox to the last one used
        if ((ModuleSettings.getConfigSetting("STIX", "showAllResults") != null) //NON-NLS
                && (!ModuleSettings.getConfigSetting("STIX", "showAllResults").isEmpty())) { //NON-NLS

            if (ModuleSettings.getConfigSetting("STIX", "showAllResults").equals("true")) { //NON-NLS
                jCheckBox1.setSelected(true);
                showAllResults = true;
            } else {
                jCheckBox1.setSelected(false);
                showAllResults = false;
            }
        } else {
            showAllResults = false;
        }
    }

    public String getStixFile() {
        return stixFile;
    }

    public boolean getShowAllResults() {
        return showAllResults;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        jLabel2.setText(org.openide.util.NbBundle.getMessage(STIXReportModuleConfigPanel.class, "STIXReportModuleConfigPanel.jLabel2.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(STIXReportModuleConfigPanel.class, "STIXReportModuleConfigPanel.jTextField1.text")); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText(org.openide.util.NbBundle.getMessage(STIXReportModuleConfigPanel.class, "STIXReportModuleConfigPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText(org.openide.util.NbBundle.getMessage(STIXReportModuleConfigPanel.class, "STIXReportModuleConfigPanel.jCheckBox1.text")); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jCheckBox1))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File currentSelection = new File(jTextField1.getText());
        if (currentSelection.exists()) {
            fileChooser.setCurrentDirectory(currentSelection);
        }

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            stixFile = fileChooser.getSelectedFile().getAbsolutePath();
            jTextField1.setText(stixFile);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        stixFile = jTextField1.getText();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        showAllResults = jCheckBox1.isSelected();
        if (showAllResults) {
            ModuleSettings.setConfigSetting("STIX", "showAllResults", "true"); //NON-NLS
        } else {
            ModuleSettings.setConfigSetting("STIX", "showAllResults", "false"); //NON-NLS
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
