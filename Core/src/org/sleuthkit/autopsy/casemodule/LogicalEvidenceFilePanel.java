/*
 * Autopsy Forensic Browser
 *
 * Copyright 2018 Basis Technology Corp.
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
package org.sleuthkit.autopsy.casemodule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataSourceProcessor;
import org.sleuthkit.autopsy.coreutils.MessageNotifyUtil;
import java.util.logging.Level;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.openide.util.NbBundle.Messages;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.coreutils.PathValidator;

/**
 * A panel which allows the user to select a Logical Evidence File (L01)
 */
@SuppressWarnings("PMD.SingularField") // UI widgets cause lots of false positives
final class LogicalEvidenceFilePanel extends javax.swing.JPanel implements DocumentListener {

    private static final long serialVersionUID = 1L;

    private final Set<File> currentFiles = new TreeSet<>(); //keep currents in a set to disallow duplicates per add
    private static final Logger logger = Logger.getLogger(LocalFilesPanel.class.getName());
    private String displayName = "";

    /**
     * Creates new form LogicalEvidenceFilePanel
     */
    private LogicalEvidenceFilePanel() {
        initComponents();
        logicalEvidenceFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        logicalEvidenceFileChooser.setAcceptAllFileFilterUsed(false);
        logicalEvidenceFileChooser.setMultiSelectionEnabled(false);
        logicalEvidenceFileChooser.setFileFilter(LocalFilesDSProcessor.getLogicalEvidenceFilter());
    }

    /**
     * Create a new LogicalEvidencePanel.
     *
     * @return
     */
    static LogicalEvidenceFilePanel createInstance() {
        synchronized (LogicalEvidenceFilePanel.class) {
            final LogicalEvidenceFilePanel instance = new LogicalEvidenceFilePanel();
            // post-constructor initialization of listener support without leaking references of uninitialized objects
            instance.logicalEvidencePathField.getDocument().addDocumentListener(instance);
            return instance;
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

        logicalEvidenceFileChooser = new javax.swing.JFileChooser();
        selectButton = new javax.swing.JButton();
        logicalEvidencePathField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        logicalEvidenceFileChooser.setApproveButtonText(org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.logicalEvidenceFileChooser.approveButtonText")); // NOI18N
        logicalEvidenceFileChooser.setApproveButtonToolTipText(org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.logicalEvidenceFileChooser.approveButtonToolTipText")); // NOI18N
        logicalEvidenceFileChooser.setDialogTitle(org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.logicalEvidenceFileChooser.dialogTitle")); // NOI18N
        logicalEvidenceFileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        org.openide.awt.Mnemonics.setLocalizedText(selectButton, org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.selectButton.text")); // NOI18N
        selectButton.setToolTipText(org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.selectButton.toolTipText")); // NOI18N
        selectButton.setActionCommand(org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.selectButton.actionCommand")); // NOI18N
        selectButton.setMaximumSize(new java.awt.Dimension(70, 23));
        selectButton.setMinimumSize(new java.awt.Dimension(70, 23));
        selectButton.setPreferredSize(new java.awt.Dimension(70, 23));
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        logicalEvidencePathField.setText(org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.logicalEvidencePathField.text")); // NOI18N
        logicalEvidencePathField.setPreferredSize(new java.awt.Dimension(379, 20));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(errorLabel, org.openide.util.NbBundle.getMessage(LogicalEvidenceFilePanel.class, "LogicalEvidenceFilePanel.errorLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logicalEvidencePathField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logicalEvidencePathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorLabel)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        final int returnVal = logicalEvidenceFileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            final File file = logicalEvidenceFileChooser.getSelectedFile();
            final StringBuilder allPaths = new StringBuilder();
            currentFiles.add(file);
            allPaths.append(file.getAbsolutePath());
            logicalEvidencePathField.setText(allPaths.toString());
            logicalEvidencePathField.setToolTipText(allPaths.toString());
        }
        fireChange();
    }//GEN-LAST:event_selectButtonActionPerformed

    /*
     * Clear previously selected items on the panel.
     */
    void reset() {
        currentFiles.clear();
        logicalEvidencePathField.setText("");
        logicalEvidencePathField.setToolTipText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JFileChooser logicalEvidenceFileChooser;
    private javax.swing.JTextField logicalEvidencePathField;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Check if the current selection exists and is a logical evidence file and
     * therefore the panel is valid.
     *
     * @return true for a valid selection, false for an invalid or empty
     *         selection
     */
    @Messages({
        "LogicalEvidenceFilePanel.validatePanel.nonL01Error.text=Only files with the .l01 file extension are supported here.",
        "LogicalEvidenceFilePanel.pathValidation.dataSourceOnCDriveError=Warning: Path to multi-user data source is on \"C:\" drive",
        "LogicalEvidenceFilePanel.pathValidation.getOpenCase.Error=Warning: Exception while getting open case."
    })
    boolean validatePanel() {
        errorLabel.setVisible(false);
        // display warning if there is one (but don't disable "next" button)
        final String path = logicalEvidencePathField.getText();
        if (StringUtils.isBlank(path)) {
            return false;
        }
        // display warning if there is one (but don't disable "next" button)
        try {
            if (!PathValidator.isValidForMultiUserCase(path, Case.getCurrentCaseThrows().getCaseType())) {
                errorLabel.setVisible(true);
                errorLabel.setText(Bundle.LogicalEvidenceFilePanel_pathValidation_dataSourceOnCDriveError());
                return false;
            }
        } catch (NoCurrentCaseException ex) {
            errorLabel.setVisible(true);
            errorLabel.setText(Bundle.LogicalEvidenceFilePanel_pathValidation_getOpenCase_Error());
            return false;
        }
        //check the extension incase the path was manually entered
        if (!LocalFilesDSProcessor.getLogicalEvidenceFilter().accept(new File(path))) {
            errorLabel.setVisible(true);
            errorLabel.setText(Bundle.LogicalEvidenceFilePanel_validatePanel_nonL01Error_text());
            return false;
        }

        displayName = FilenameUtils.getName(path);
        return new File(path).isFile();
    }

    /**
     * Get the path(s) which have been selected on this panel
     *
     * @return a List of Strings representing the path(s) for the selected files
     */
    List<String> getContentPaths() {
        final List<String> pathsList = new ArrayList<>();
        if (currentFiles == null) {
            return pathsList;
        }
        for (final File f : currentFiles) {
            pathsList.add(f.getAbsolutePath());
        }
        return pathsList;
    }

    /**
     * Get the name of the logical evidence file which was selected.
     *
     * @return the name of the logical evidence file
     */
    String getFileSetName() {
        return displayName;
    }

    @Override
    public void insertUpdate(final DocumentEvent docEvent) {
        fireChange();
    }

    @Override
    public void removeUpdate(final DocumentEvent docEvent) {
        fireChange();
    }

    @Override
    public void changedUpdate(final DocumentEvent docEvent) {
        fireChange();
    }

    @Messages({
        "LogicalEvidenceFilePanel.moduleErr.name=Module Error",
        "LogicalEvidenceFilePanel.moduleErr.msg=A module caused an error listening to LogicalEvidenceFilePanel updates. See log to determine which module. Some data could be incomplete."
    })
    private void fireChange() {
        try {
            firePropertyChange(DataSourceProcessor.DSP_PANEL_EVENT.UPDATE_UI.toString(), false, true);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "LogicalEvidenceFilePanel listener threw exception", e); //NON-NLS
            MessageNotifyUtil.Notify.show(NbBundle.getMessage(this.getClass(), "LogicalEvidenceFilePanel.moduleErr"),
                    NbBundle.getMessage(this.getClass(), "LogicalEvidenceFilePanel.moduleErr.msg"),
                    MessageNotifyUtil.MessageType.ERROR);
        }
    }
}
