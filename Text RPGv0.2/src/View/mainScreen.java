
package View;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import Controller.mainController;
import Model.Database;
import Model.Room;
import java.awt.Color;

public class mainScreen extends javax.swing.JApplet{
    
    public Database db;
    
    
    /**
     * Initializes the applet mainScreen
     */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        controller = new mainController();
        
        
        db = new Database();
        
        db.connect();
        db.getRooms();
        Room.currRoom = Room.roomList.get(0);
        setSize(880,500);
        getContentPane().setBackground(new Color(255, 191, 128));
        TFinput.addActionListener(action);
        controller.updateImage(Limage, Database.getImageById(Room.currRoom.getRoomId()));
        
        
        welcomeMessage();

    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TFinput = new javax.swing.JTextField();
        Limage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAoutput = new javax.swing.JTextArea();
        Ltime = new javax.swing.JLabel();
        hpBox = new javax.swing.JPanel();
        hpText = new javax.swing.JLabel();
        hpCurrent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hpMax = new javax.swing.JLabel();
        mpBox = new javax.swing.JPanel();
        mpText = new javax.swing.JLabel();
        mpCurr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mpMax = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TFinput.setBackground(new java.awt.Color(229, 162, 97));
        TFinput.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        TFinput.setForeground(new java.awt.Color(51, 51, 51));
        TFinput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        TFinput.setName(""); // NOI18N

        Limage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Limage.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        TAoutput.setBackground(new java.awt.Color(229, 162, 97));
        TAoutput.setColumns(20);
        TAoutput.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        TAoutput.setForeground(new java.awt.Color(51, 51, 51));
        TAoutput.setLineWrap(true);
        TAoutput.setRows(5);
        TAoutput.setBorder(null);
        TAoutput.setSelectionColor(new java.awt.Color(229, 162, 97));
        jScrollPane1.setViewportView(TAoutput);

        Ltime.setBackground(new java.awt.Color(153, 153, 153));
        Ltime.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Ltime.setForeground(new java.awt.Color(182, 98, 7));
        Ltime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ltime.setText("06:00 AM");
        Ltime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        hpBox.setBackground(new java.awt.Color(0, 194, 6));
        hpBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        hpText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        hpText.setText("HP : ");

        hpCurrent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        hpCurrent.setText("20");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("/");

        hpMax.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        hpMax.setText("20");

        javax.swing.GroupLayout hpBoxLayout = new javax.swing.GroupLayout(hpBox);
        hpBox.setLayout(hpBoxLayout);
        hpBoxLayout.setHorizontalGroup(
            hpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hpBoxLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(hpText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hpCurrent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hpMax)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hpBoxLayout.setVerticalGroup(
            hpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hpBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hpText)
                    .addComponent(hpCurrent)
                    .addComponent(jLabel1)
                    .addComponent(hpMax))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mpBox.setBackground(new java.awt.Color(0, 255, 255));
        mpBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        mpText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mpText.setText("MP :");

        mpCurr.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mpCurr.setText("20");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("/");

        mpMax.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mpMax.setText("20");

        javax.swing.GroupLayout mpBoxLayout = new javax.swing.GroupLayout(mpBox);
        mpBox.setLayout(mpBoxLayout);
        mpBoxLayout.setHorizontalGroup(
            mpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpBoxLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(mpText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpCurr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpMax)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        mpBoxLayout.setVerticalGroup(
            mpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mpBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mpText)
                    .addComponent(mpCurr)
                    .addComponent(jLabel2)
                    .addComponent(mpMax))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addComponent(TFinput))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Limage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Ltime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hpBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mpBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFinput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ltime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Limage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(hpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(161, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Limage;
    private javax.swing.JLabel Ltime;
    private javax.swing.JTextArea TAoutput;
    private javax.swing.JTextField TFinput;
    private javax.swing.JPanel hpBox;
    private javax.swing.JLabel hpCurrent;
    private javax.swing.JLabel hpMax;
    private javax.swing.JLabel hpText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mpBox;
    private javax.swing.JLabel mpCurr;
    private javax.swing.JLabel mpMax;
    private javax.swing.JLabel mpText;
    // End of variables declaration//GEN-END:variables
    
    mainController controller;
    
    public void start() {
        
    }
    
    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = TFinput.getText();
            
            TAoutput.append("\n" + input + "\n");
            TFinput.setText("");
            controller.proccessInput(input);
            
            String output = controller.getTAoutput();
            controller.updateTextArea(TAoutput, output);
            TAoutput.setCaretPosition(TAoutput.getDocument().getLength());
            controller.updateImage(Limage, Database.getImageById(Room.currRoom.getRoomId()));
        }
    };
    
    public void welcomeMessage() {
        TAoutput.append("Type \"help\" to view all the commands of the game.\n\n\n");
        TAoutput.append("You wake up inside a spooky dungeon...Darkness surrounds you and you can barely see anything.\n");
        TAoutput.append("You feel numb as you try to get on your feet. Weakness through your body.\n");
        TAoutput.append("You can't tell for how long have you been knocked out.A mysterious sound comes from the south..\n");
    }
    
    
    
    
}
