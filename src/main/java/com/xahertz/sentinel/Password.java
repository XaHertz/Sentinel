package com.xahertz.sentinel;

/**
 *
 * @author XaHertz
 */
public class Password extends javax.swing.JFrame {

    /**
     * Creates new form Password
     */
    public Password() {
        initComponents();
        Digits_Toggled = Digits_ToggleButton.isSelected();
        UpperCase_Toggled = UpperCase_ToggleButton.isSelected();
        LowerCase_Toggled = LowerCase_ToggleButton.isSelected();
        SpecialCharA_Toggled = SpecialCharA_ToggleButton.isSelected();
        SpecialCharB_Toggled = SpecialCharB_ToggleButton.isSelected();
        Password_Field.setText(com.xahertz.internal.Functions.generatePassword((int) Password_Length_Spinner.getValue(),
                UpperCase_Toggled, LowerCase_Toggled, Digits_Toggled, SpecialCharA_Toggled, SpecialCharB_Toggled));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Password_Field = new javax.swing.JPasswordField();
        Password_Field_ToggleButton = new javax.swing.JToggleButton();
        Generate_Password_Button = new javax.swing.JButton();
        Copy_Password_Button = new javax.swing.JButton();
        Character_Panel = new javax.swing.JPanel();
        UpperCase_ToggleButton = new javax.swing.JToggleButton();
        LowerCase_ToggleButton = new javax.swing.JToggleButton();
        Digits_ToggleButton = new javax.swing.JToggleButton();
        SpecialCharA_ToggleButton = new javax.swing.JToggleButton();
        SpecialCharB_ToggleButton = new javax.swing.JToggleButton();
        Password_Length_Label = new javax.swing.JLabel();
        Password_Length_Spinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Password");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/app-icon.png")).getImage());
        setResizable(false);

        Password_Field.setEchoChar((char) 0);
        Password_Field.putClientProperty("JPasswordField.cutCopyAllowed", true);

        Password_Field_ToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye.png"))); // NOI18N
        Password_Field_ToggleButton.setSelected(true);
        Password_Field_ToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Password_Field_ToggleButtonItemStateChanged(evt);
            }
        });

        Generate_Password_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload.png"))); // NOI18N
        Generate_Password_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Generate_Password_ButtonActionPerformed(evt);
            }
        });

        Copy_Password_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard.png"))); // NOI18N
        Copy_Password_Button.setToolTipText("Copy Password to Clipboard");
        Copy_Password_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Copy_Password_ButtonActionPerformed(evt);
            }
        });

        Character_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        UpperCase_ToggleButton.setSelected(true);
        UpperCase_ToggleButton.setText("A-Z");
        UpperCase_ToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UpperCase_ToggleButtonItemStateChanged(evt);
            }
        });

        LowerCase_ToggleButton.setSelected(true);
        LowerCase_ToggleButton.setText("a-z");
        LowerCase_ToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LowerCase_ToggleButtonItemStateChanged(evt);
            }
        });

        Digits_ToggleButton.setSelected(true);
        Digits_ToggleButton.setText("0-9");
        Digits_ToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Digits_ToggleButtonItemStateChanged(evt);
            }
        });

        SpecialCharA_ToggleButton.setText("*$!@#&");
        SpecialCharA_ToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SpecialCharA_ToggleButtonItemStateChanged(evt);
            }
        });

        SpecialCharB_ToggleButton.setText("%?+^/-");
        SpecialCharB_ToggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SpecialCharB_ToggleButtonItemStateChanged(evt);
            }
        });

        Password_Length_Label.setText("Length:");

        Password_Length_Spinner.setModel(new javax.swing.SpinnerNumberModel(12, 8, 999, 1));

        javax.swing.GroupLayout Character_PanelLayout = new javax.swing.GroupLayout(Character_Panel);
        Character_Panel.setLayout(Character_PanelLayout);
        Character_PanelLayout.setHorizontalGroup(
            Character_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Character_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpperCase_ToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LowerCase_ToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Digits_ToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpecialCharA_ToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpecialCharB_ToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password_Length_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password_Length_Spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Character_PanelLayout.setVerticalGroup(
            Character_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Character_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Character_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpecialCharB_ToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Digits_ToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SpecialCharA_ToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Character_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Password_Length_Label)
                        .addComponent(UpperCase_ToggleButton)
                        .addComponent(LowerCase_ToggleButton)
                        .addComponent(Password_Length_Spinner)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Password_Field_ToggleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Generate_Password_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Copy_Password_Button))
                    .addComponent(Character_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password_Field_ToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generate_Password_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Copy_Password_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Character_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Password_Field_ToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Password_Field_ToggleButtonItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
            Password_Field.setEchoChar((char) 0);
        else
            Password_Field.setEchoChar('\u2022');
    }//GEN-LAST:event_Password_Field_ToggleButtonItemStateChanged

    private void Generate_Password_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Generate_Password_ButtonActionPerformed
        Password_Field.setText(com.xahertz.internal.Functions.generatePassword((int) Password_Length_Spinner.getValue(),
                UpperCase_Toggled, LowerCase_Toggled, Digits_Toggled, SpecialCharA_Toggled, SpecialCharB_Toggled));
    }//GEN-LAST:event_Generate_Password_ButtonActionPerformed

    private void Copy_Password_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Copy_Password_ButtonActionPerformed
        java.awt.datatransfer.Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new java.awt.datatransfer.StringSelection(new String(Password_Field.getPassword())), null);
    }//GEN-LAST:event_Copy_Password_ButtonActionPerformed

    private void UpperCase_ToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UpperCase_ToggleButtonItemStateChanged
        UpperCase_Toggled = evt.getStateChange() == java.awt.event.ItemEvent.SELECTED;
        Generate_Password_State();
    }//GEN-LAST:event_UpperCase_ToggleButtonItemStateChanged

    private void LowerCase_ToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LowerCase_ToggleButtonItemStateChanged
        LowerCase_Toggled = evt.getStateChange() == java.awt.event.ItemEvent.SELECTED;
        Generate_Password_State();
    }//GEN-LAST:event_LowerCase_ToggleButtonItemStateChanged

    private void Digits_ToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Digits_ToggleButtonItemStateChanged
        Digits_Toggled = evt.getStateChange() == java.awt.event.ItemEvent.SELECTED;
        Generate_Password_State();
    }//GEN-LAST:event_Digits_ToggleButtonItemStateChanged

    private void SpecialCharA_ToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SpecialCharA_ToggleButtonItemStateChanged
        SpecialCharA_Toggled = evt.getStateChange() == java.awt.event.ItemEvent.SELECTED;
        Generate_Password_State();
    }//GEN-LAST:event_SpecialCharA_ToggleButtonItemStateChanged

    private void SpecialCharB_ToggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SpecialCharB_ToggleButtonItemStateChanged
        SpecialCharB_Toggled = evt.getStateChange() == java.awt.event.ItemEvent.SELECTED;
        Generate_Password_State();
    }//GEN-LAST:event_SpecialCharB_ToggleButtonItemStateChanged

    private void Generate_Password_State() {
        if (UpperCase_Toggled || LowerCase_Toggled || Digits_Toggled || SpecialCharA_Toggled || SpecialCharB_Toggled) {
            Generate_Password_Button.setEnabled(true);
            Password_Field.setText(com.xahertz.internal.Functions.generatePassword((int) Password_Length_Spinner.getValue(),
                UpperCase_Toggled, LowerCase_Toggled, Digits_Toggled, SpecialCharA_Toggled, SpecialCharB_Toggled));
        }
        else
            Generate_Password_Button.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatLightLaf look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If FlatLightLaf is not available, stay with the default look and feel. */
        com.formdev.flatlaf.FlatLightLaf.setup();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLightLaf".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        javax.swing.UIManager.put("ScrollBar.thumbArc", 999);
        javax.swing.UIManager.put("ScrollBar.thumbInsets", new java.awt.Insets(2, 2, 2, 2));
        javax.swing.UIManager.put("TextField.inactiveBackground", new javax.swing.plaf.ColorUIResource(java.awt.Color.WHITE));
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Password().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Character_Panel;
    private javax.swing.JButton Copy_Password_Button;
    private javax.swing.JToggleButton Digits_ToggleButton;
    private javax.swing.JButton Generate_Password_Button;
    private javax.swing.JToggleButton LowerCase_ToggleButton;
    private javax.swing.JPasswordField Password_Field;
    private javax.swing.JToggleButton Password_Field_ToggleButton;
    private javax.swing.JLabel Password_Length_Label;
    private javax.swing.JSpinner Password_Length_Spinner;
    private javax.swing.JToggleButton SpecialCharA_ToggleButton;
    private javax.swing.JToggleButton SpecialCharB_ToggleButton;
    private javax.swing.JToggleButton UpperCase_ToggleButton;
    // End of variables declaration//GEN-END:variables
    private boolean SpecialCharA_Toggled;
    private boolean SpecialCharB_Toggled;
    private boolean UpperCase_Toggled;
    private boolean LowerCase_Toggled;
    private boolean Digits_Toggled;
}
