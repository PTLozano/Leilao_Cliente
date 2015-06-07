package Forms;

import Modelo.Participante;
import Modelo.Produto;
import java.text.SimpleDateFormat;


public class Frm_Lance extends javax.swing.JDialog {

    private Participante part;
    private Produto prod;
    public Frm_Lance(java.awt.Frame parent, boolean modal, Participante part, Produto prod) {
        super(parent, modal);
        this.part = part;
        this.prod = prod;
        initComponents();
        setTitle("Andamento do leilão do produto: " + prod.getNome());
        lbl_NomeProduto.setText(prod.getNome());
        lbl_ValorLanceInicial.setText(String.valueOf(prod.getLance()) + " lance(s)");
        
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formataData = sd.format(prod.getDataHoraInicio());
        lbl_ValorDataHoraInicio.setText(formataData.split(" ")[0] + " às " + formataData.split(" ")[1]);
        formataData = sd.format(prod.getDataHoraTermino());
        lbl_ValorDataHoraTermino.setText(formataData.split(" ")[0] + " às " + formataData.split(" ")[1]);
        if (!prod.getImagem().equals("")) {
            lbl_Imagem.setIcon(new javax.swing.ImageIcon(prod.getImagem()));
        } else {
            lbl_Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/semimagem.jpg")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_DataHoraTermino = new javax.swing.JLabel();
        lbl_LanceAtual = new javax.swing.JLabel();
        lbl_ValorDataHoraTermino = new javax.swing.JLabel();
        lbl_ValorDataHoraInicio = new javax.swing.JLabel();
        lbl_Imagem = new javax.swing.JLabel();
        lbl_ValorLanceInicial = new javax.swing.JLabel();
        lbl_NomeProduto = new javax.swing.JLabel();
        lbl_ValorLanceAtual = new javax.swing.JLabel();
        lbl_LanceInicial = new javax.swing.JLabel();
        lbl_DataHoraInicio = new javax.swing.JLabel();
        pnl_DadosPessoais = new javax.swing.JPanel();
        btn_EfetuarLance = new javax.swing.JButton();
        txt_QdeLances = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(955, 511));
        setResizable(false);

        lbl_DataHoraTermino.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lbl_DataHoraTermino.setText("Data e Hora do Término:");

        lbl_LanceAtual.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        lbl_LanceAtual.setText("Valor atual do lance:");

        lbl_ValorDataHoraTermino.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lbl_ValorDataHoraTermino.setText("Data e Hora do Término");

        lbl_ValorDataHoraInicio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lbl_ValorDataHoraInicio.setText("Data e Hora de Início");

        lbl_Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/semimagem.jpg"))); // NOI18N
        lbl_Imagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_ValorLanceInicial.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lbl_ValorLanceInicial.setText("Lance Inicial");

        lbl_NomeProduto.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbl_NomeProduto.setText("NOME DO PRODUTO");

        lbl_ValorLanceAtual.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbl_ValorLanceAtual.setForeground(new java.awt.Color(25, 32, 204));
        lbl_ValorLanceAtual.setText("Valor atual do lance");

        lbl_LanceInicial.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lbl_LanceInicial.setText("Lance Inicial:");

        lbl_DataHoraInicio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lbl_DataHoraInicio.setText("Data e Hora de Início:");

        pnl_DadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Suas informações"));

        btn_EfetuarLance.setText("Efetuar Lance");

        javax.swing.GroupLayout pnl_DadosPessoaisLayout = new javax.swing.GroupLayout(pnl_DadosPessoais);
        pnl_DadosPessoais.setLayout(pnl_DadosPessoaisLayout);
        pnl_DadosPessoaisLayout.setHorizontalGroup(
            pnl_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DadosPessoaisLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_QdeLances, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_EfetuarLance, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_DadosPessoaisLayout.setVerticalGroup(
            pnl_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DadosPessoaisLayout.createSequentialGroup()
                .addGap(0, 217, Short.MAX_VALUE)
                .addGroup(pnl_DadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_EfetuarLance)
                    .addComponent(txt_QdeLances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_DadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_NomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_LanceInicial)
                                    .addComponent(lbl_DataHoraInicio)
                                    .addComponent(lbl_DataHoraTermino)
                                    .addComponent(lbl_LanceAtual))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ValorLanceAtual)
                                    .addComponent(lbl_ValorDataHoraInicio)
                                    .addComponent(lbl_ValorDataHoraTermino)
                                    .addComponent(lbl_ValorLanceInicial))
                                .addGap(0, 225, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_NomeProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_LanceAtual)
                                    .addComponent(lbl_ValorLanceAtual))
                                .addGap(18, 18, 18)
                                .addComponent(lbl_LanceInicial)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_DataHoraInicio)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_DataHoraTermino))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lbl_ValorLanceInicial)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_ValorDataHoraInicio)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_ValorDataHoraTermino))))
                    .addComponent(lbl_Imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnl_DadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void EventosJDialog() {
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
            java.util.logging.Logger.getLogger(Frm_Lance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Lance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Lance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Lance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Frm_Lance dialog = new Frm_Lance(new javax.swing.JFrame(), true, part, prod);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_EfetuarLance;
    private javax.swing.JLabel lbl_DataHoraInicio;
    private javax.swing.JLabel lbl_DataHoraTermino;
    private javax.swing.JLabel lbl_Imagem;
    private javax.swing.JLabel lbl_LanceAtual;
    private javax.swing.JLabel lbl_LanceInicial;
    private javax.swing.JLabel lbl_NomeProduto;
    private javax.swing.JLabel lbl_ValorDataHoraInicio;
    private javax.swing.JLabel lbl_ValorDataHoraTermino;
    private javax.swing.JLabel lbl_ValorLanceAtual;
    private javax.swing.JLabel lbl_ValorLanceInicial;
    private javax.swing.JPanel pnl_DadosPessoais;
    private javax.swing.JTextField txt_QdeLances;
    // End of variables declaration//GEN-END:variables
}
