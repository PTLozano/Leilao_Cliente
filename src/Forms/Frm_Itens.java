package Forms;

import Modelo.Participante;
import Modelo.Produto;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import rmi.Log;

public class Frm_Itens extends javax.swing.JFrame {

    final private String msgErroServidor = "Não foi possível estabelecer uma conexão com o servidor.\nPor favor tente mais tarde.";
    private Log log;
    private Participante p;
    private ArrayList<Produto> lista;
    private int countProduto = 0;

    public Frm_Itens() {
        initComponents();
        pnl_logoff.setVisible(false);
        CarregaProdutos();
        pnl_Produtos.setLayout(new FlowLayout());
    }

    private void CarregaProdutos() {
        try {
            log = (Log) Naming.lookup("logserver");
            lista = log.BuscaProdutos();
            for (Produto prod : lista) {
                GeraItens(prod);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, msgErroServidor);
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_login = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        pnl_logoff = new javax.swing.JPanel();
        btnLogoff = new javax.swing.JButton();
        lblBemVindo = new javax.swing.JLabel();
        lblLancesDisponiveis = new javax.swing.JLabel();
        pnl_Produtos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leilão Muito Legal");

        pnl_login.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_login.setLayout(null);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnl_login.add(btnLogin);
        btnLogin.setBounds(140, 140, 80, 29);
        pnl_login.add(txtUsuario);
        txtUsuario.setBounds(10, 30, 210, 27);

        lblUsuario.setText("Usuário (e-mail):");
        pnl_login.add(lblUsuario);
        lblUsuario.setBounds(10, 10, 210, 17);

        lblSenha.setText("Senha:");
        pnl_login.add(lblSenha);
        lblSenha.setBounds(10, 80, 210, 17);
        pnl_login.add(txtSenha);
        txtSenha.setBounds(10, 100, 210, 27);

        pnl_logoff.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_logoff.setLayout(null);

        btnLogoff.setText("Logoff");
        btnLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffActionPerformed(evt);
            }
        });
        pnl_logoff.add(btnLogoff);
        btnLogoff.setBounds(140, 140, 80, 29);

        lblBemVindo.setText("Olá");
        pnl_logoff.add(lblBemVindo);
        lblBemVindo.setBounds(10, 10, 210, 17);

        lblLancesDisponiveis.setText("Lances disponíveis:");
        pnl_logoff.add(lblLancesDisponiveis);
        lblLancesDisponiveis.setBounds(10, 80, 210, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_logoff, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_logoff, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_login, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnl_Produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            //Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            log = (Log) Naming.lookup("logserver");
            p = new Participante();
            p.setEmail(txtUsuario.getText());
            p.setSenha(txtSenha.getPassword());
            p = log.ValidaUsuario(p);
            if (p != null) {
                pnl_login.setVisible(false);
                pnl_logoff.setVisible(true);
                lblBemVindo.setText("Olá " + p.getNome());
                lblLancesDisponiveis.setText("Lances disponíveis: " + p.getLances());
                JOptionPane.showMessageDialog(null, "Olá, seja bem vindo " + p.getNome());
                txtUsuario.setText("");
                txtSenha.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, msgErroServidor);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffActionPerformed
        p = null;
        pnl_login.setVisible(true);
        pnl_logoff.setVisible(false);
        lblBemVindo.setText("Olá ");
        lblLancesDisponiveis.setText("Lances disponíveis: ");
    }//GEN-LAST:event_btnLogoffActionPerformed

    private void GeraItens(Produto prod) {
        JPanel pnl = new JPanel();
        pnl.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl.setPreferredSize(new Dimension(230, 390));

        JLabel lblNomeProd = new JLabel(prod.getNome());
        lblNomeProd.setBounds(10, 10, 210, 30);
        lblNomeProd.setFont(new java.awt.Font("Ubuntu", 1, 18));
        lblNomeProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLabel lblImagem = new JLabel();
        lblImagem.setBounds(15, 50, 200, 200);
        lblImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        if (!prod.getImagem().equals("")) {
            lblImagem.setIcon(new javax.swing.ImageIcon(prod.getImagem()));
        } else {
            lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/semimagem.jpg")));
        }

        JButton btnLance = new JButton("Lance");
        btnLance.setBounds(40, 270, 150, 29);
        btnLance.setName("btnLance_" + countProduto++);
        btnLance.addActionListener((java.awt.event.ActionEvent evt) -> {
            // ABRE A NOVA FRAME ENVIANDO O ID DO PRODUTO QUE ESTÁ NO NAME DO BOTÃO
            JButton btnTmp = ((JButton) evt.getSource());
            int indiceProduto = Integer.parseInt(btnTmp.getName().split("_")[1]);
            Produto prodTmp = lista.get(indiceProduto);

            Frm_Lance ops = new Frm_Lance(this, true, p, prodTmp);
            ops.setVisible(true);
        });

        JLabel lblLanceInicial = new JLabel("Lance inicial: " + String.valueOf(prod.getLance()));
        lblLanceInicial.setBounds(10, 310, 210, 25);
        lblLanceInicial.setFont(new java.awt.Font("Ubuntu", 1, 16));
        lblLanceInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formataData = sd.format(prod.getDataHoraTermino());
        JLabel lblTerminoLance = new JLabel("Encerra em: " + formataData.split(" ")[0] + " às " + formataData.split(" ")[1]);
        lblTerminoLance.setBounds(10, 310, 210, 25);
        lblTerminoLance.setFont(new java.awt.Font("Ubuntu", 1, 16));
        lblTerminoLance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        /* 
         * Pega o dia atual e compara para ver se a data de vencimento do produto é menor de 7 dias
         * se for, irá alterar a cor para vermelho
         */
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 7);
        if (prod.getDataHoraTermino().before(c.getTime())) {
            lblTerminoLance.setForeground(Color.red);
        }

        pnl.add(lblNomeProd);
        pnl.add(lblImagem);
        pnl.add(btnLance);
        pnl.add(lblLanceInicial);
        pnl.add(lblTerminoLance);

        javax.swing.GroupLayout pnl_Layout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnl_Layout);
        pnl_Layout.setHorizontalGroup(
                pnl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblImagem))
                .addGroup(pnl_Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnLance, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblLanceInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblTerminoLance))
        );
        pnl_Layout.setVerticalGroup(
                pnl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblImagem)
                        .addGap(20, 20, 20)
                        .addComponent(btnLance)
                        .addGap(11, 11, 11)
                        .addComponent(lblLanceInicial)
                        .addGap(13, 13, 13)
                        .addComponent(lblTerminoLance))
        );

        pnl_Produtos.add(pnl);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogoff;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblLancesDisponiveis;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnl_Produtos;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JPanel pnl_logoff;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
