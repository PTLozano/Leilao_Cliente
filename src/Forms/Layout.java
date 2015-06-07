package Forms;
import Modelo.Produto;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Layout
{  
   static JPanel MyPanel;
   public static void main(String[] args)
   {  
      JFrame f = new JFrame("Hello");

      MyPanel = new JPanel();

      MyPanel.setLayout( new FlowLayout() );    // Demo flow layout
      
      for (int i = 0; i < 10; i++) {
            Produto p = new Produto();
            p.setNome("Opa! - " + (i + 1));
            p.setIdProduto(i);
            p.setDataHoraInicio(new Date());
            p.setDataHoraTermino(new Date());
            p.setImagem("/home/ptlozano/Imagens/UseCase.png");
            p.setLance(1000);
            GeraItens(p);
        }
      
      
      f.getContentPane().add(MyPanel, "Center");  // Paste MyPanel in center
                                                  // of contentPane

      f.setSize(600, 450);
      f.setVisible(true);
   }
   
   private static void GeraItens(Produto prod) {
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
        }

        JButton btnLance = new JButton("Lance");
        btnLance.setBounds(40, 270, 150, 29);
        btnLance.setName("btnLance_" + prod.getIdProduto());
        btnLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // ABRE A NOVA FRAME ENVIANDO O ID DO PRODUTO QUE ESTÁ NO NAME DO BOTÃO
            }
        });

        JLabel lblLanceInicial = new JLabel("Lance inicial: " + String.valueOf(prod.getLance()));
        lblLanceInicial.setBounds(10, 310, 210, 25);
        lblLanceInicial.setFont(new java.awt.Font("Ubuntu", 1, 16));
        lblLanceInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        JLabel lblTerminoLance = new JLabel(sd.format(prod.getDataHoraTermino()));
        lblTerminoLance.setBounds(10, 350, 210, 25);
        lblTerminoLance.setFont(new java.awt.Font("Ubuntu", 1, 16));
        lblTerminoLance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
        
        MyPanel.add(pnl);
    }
}
