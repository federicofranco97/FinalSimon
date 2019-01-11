


import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class JuegoFacilV2 extends javax.swing.JFrame {

  
    public JuegoFacilV2() {
        initComponents();
        setLocationRelativeTo(null);
        nameButtons();
        fillButtons();
        
        fillColorsArray();
        
    }

  
    
    Color[] colors = new Color[4];
    ArrayList<JButton> arrayBotones= new ArrayList<JButton>();
    ArrayList<Color> arrayColores= new ArrayList<Color>();
    ArrayList<Integer> arraySecuencia= new ArrayList<Integer>();
    static int toques=0;
    ArrayList<String> secuencia= new ArrayList<String>();
    ArrayList<Integer> toquesUser= new ArrayList<Integer>();
    static int topScore=0;
    static String topPlayer="";
    
  
    
    public void nameButtons(){
        btn0.setName("0");
        btn1.setName("1");
        btn2.setName("2");
        btn3.setName("3");
    }
    
    public void fillButtons(){
      arrayBotones.add(btn0);
      arrayBotones.add(btn1);
      arrayBotones.add(btn2);
      arrayBotones.add(btn3);
    }
    
    public void fillColors(){  
        colors[0]=Color.RED;
        colors[1]=Color.BLUE;
        colors[2]=Color.GREEN;
        colors[3]=Color.YELLOW;
    }
    
    public void bloquearBotones(){
        for(int i=0;i<arrayBotones.size();i++){
            arrayBotones.get(i).setEnabled(false);
        }
    }
    
    public void desbloquearBotones(){
        for(int i=0;i<arrayBotones.size();i++){
            arrayBotones.get(i).setEnabled(true);
        }
    }
    
    public void secuenciaTouch(){
        
    }
    
    public void fillColorsArray(){
        
        arrayColores.add(Color.RED);
        arrayColores.add(Color.yellow);
        arrayColores.add(Color.blue);
        arrayColores.add(Color.RED);
        arrayColores.add(Color.green);
        arrayColores.add(Color.blue);
        arrayColores.add(Color.yellow);
    }

    public void generarSiguiente(){
        int numRandom= (int) (Math.random()*4);
        arraySecuencia.add(numRandom);
    }
    
    public void verificarResultado(){
        Timer t1= new Timer(1000,null);
        t1.addActionListener((e)->{
            
            bloquearBotones();
            //mejorar si quiero los toques analizados individualmente
            if(toquesUser.equals(arraySecuencia)){
                lblMensaje.setText("Correcto!");
                generarSiguiente();
                repetirSecuencia();
                desbloquearBotones();
                toquesUser.clear();
                toques=0;
            }else{
                pifio();
                
            }
            t1.stop();
        });
        if(toques==arraySecuencia.size()){
            t1.start();
        }
    }
    
     public void pifio(){
        JOptionPane.showMessageDialog(null, "Incorrecto!\n"
                + "Empiezas desde cero\n"
                + "Tu puntaje fue: "+(arraySecuencia.size()-1));
        if((arraySecuencia.size()-1)>topScore){
            topPlayer=JOptionPane.showInputDialog("Marcaste el puntaje mas alto registrado!\n"
                    + " Ingresa tu nombre ");
            topScore=(arraySecuencia.size()-1);
        }
        
        JuegoFacilV2 juego = new JuegoFacilV2();
        juego.topPlayer=topPlayer;
        juego.topScore=topScore;
        juego.setVisible(true);
        this.setVisible(false);
    }
    public void toqueBoton(String butName){
        toques++;
        toquesUser.add(Integer.parseInt(butName));
        //Todo lo de abajo es para mostrar el color del boton que toque el usuario
        Timer timer = new Timer(100, null);
        Timer t2 = new Timer(400,null);
        t2.addActionListener((a3->{
            switch(Integer.parseInt(butName)){
                case 0: btn0.setBackground(Color.white);break;
                case 1: btn1.setBackground(Color.white);break;
                case 2: btn2.setBackground(Color.white);break;
                case 3: btn3.setBackground(Color.white);break;
            } 
            timer.stop();   
            
            t2.stop();
        }));
        timer.addActionListener((e) -> {
            
            switch(Integer.parseInt(butName)){
                case 0: btn0.setBackground(Color.RED);break;
                case 1: btn1.setBackground(Color.BLUE);break;
                case 2: btn2.setBackground(Color.GREEN);break;
                case 3: btn3.setBackground(Color.YELLOW);break;
            }
            t2.start();           
            
        });
        timer.start();
        

        
    }


    
    public void repetirSecuencia(){
     
        final AtomicInteger frame= new AtomicInteger(0); 
        Timer timer = new Timer(600, null);
        Timer t2 = new Timer(700,null);
        t2.addActionListener((a3->{
            switch(arraySecuencia.get(frame.get())){
                case 0: btn0.setBackground(Color.white);break;
                case 1: btn1.setBackground(Color.white);break;
                case 2: btn2.setBackground(Color.white);break;
                case 3: btn3.setBackground(Color.white);break;
            } 
            frame.incrementAndGet();
            if (frame.get() >= arraySecuencia.size()) {
                timer.stop();   
            }
            t2.stop();
        }));
        timer.addActionListener((e) -> {
            lblMensaje.setText("");
            switch(arraySecuencia.get(frame.get())){
                case 0: btn0.setBackground(Color.RED);break;
                case 1: btn1.setBackground(Color.BLUE);break;
                case 2: btn2.setBackground(Color.GREEN);break;
                case 3: btn3.setBackground(Color.YELLOW);break;
            }
            t2.start();           
            
        });
        timer.start();
    }
    
    
    

    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensaje = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 438));
        setSize(new java.awt.Dimension(760, 438));
        getContentPane().setLayout(null);

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(0, 0, 0));
        lblMensaje.setOpaque(true);
        lblMensaje.setVisible(true);
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(310, 250, 175, 50);

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1);
        btn1.setBounds(380, 130, 166, 52);

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3);
        btn3.setBounds(380, 190, 166, 52);

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2);
        btn2.setBounds(200, 190, 166, 52);

        btn0.setBackground(new java.awt.Color(255, 255, 255));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn0);
        btn0.setBounds(200, 130, 166, 52);

        btnStart.setBackground(new java.awt.Color(0, 0, 0));
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart);
        btnStart.setBounds(240, 320, 110, 32);

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Simon Says");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 50, 200, 49);

        btnAyuda.setBackground(new java.awt.Color(0, 0, 0));
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setText("?");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAyuda);
        btnAyuda.setBounds(640, 50, 40, 32);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Top Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(70, 40, 78, 32);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 320, 110, 32);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 760, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(topPlayer != ""){
            JOptionPane.showMessageDialog(null, "La mejor jugada registrada fue por:\n"
                +topPlayer+"\n"
                + "Con un puntaje de:\n"
                + topScore);
        }else{
            JOptionPane.showMessageDialog(null, "No hay jugadas registradas");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        String msj="INSTRUCCIONES DE JUEGO\n"
        +"-------------------------IMPORTANTE:----------------------------------\n"
        + "No te apures a clickear, espera a que desaparezca el color para evitar fallos.\n"
        +"-------------------------IMPORTANTE:----------------------------------\n"
        + "1-Selecciona empezar.\n"
        + "2-Memoriza la secuencia de colores que van apareciendo.\n"
        + "3-Los colores no se repiten, debes acordartelos para mas dificultad.\n"
        + "4-Cuando termina la secuencia, se habilitan los botones.\n"
        +"5-Selecciona los colores que crees que fueron apareciendo\n"
        + "6-Clickea Verificar para ver si acertaste a la secuencia!\n"
        + "7-Si aciertas, click en proxima etapa, sino al empezar de nuevo!.\n"
        ;
        JOptionPane.showMessageDialog(null, msj);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        generarSiguiente();
        repetirSecuencia();
        desbloquearBotones();
        btnStart.setEnabled(false);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        toqueBoton("0");
        verificarResultado();
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        toqueBoton("2");
        verificarResultado();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        toqueBoton("3");
        verificarResultado();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        toqueBoton("1");
        verificarResultado();
    }//GEN-LAST:event_btn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JuegoFacilV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoFacilV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoFacilV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoFacilV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoFacilV2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables
}


//      _FUNCION DE PINTAR LABEL USANDO LISTA    
//              (PARA USAR AGREGAR FILL COLORS A INICIO)
//    public void pintarLabel(){
//        Timer t2 = new Timer(800,null);
//        t2.addActionListener((a3->{
//            label1.setBackground(Color.BLACK);
//            t2.stop();
//        }));
//        
//        final AtomicInteger frame= new AtomicInteger(0); 
//        Timer timer = new Timer(1000, null);
//        timer.addActionListener((e) -> {
//            label1.setBackground(colors[frame.getAndIncrement()]);
//            if (frame.get() >= colors.length) {
//                timer.stop();
//                t2.start();
//            }
//        });
//        timer.start();
//    }