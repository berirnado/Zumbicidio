/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pacotao.views;

import com.pacotao.controllers.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import javax.swing.*;
/**
 *
 * @author Bernardo Robaina
 */
public class CombateFrame extends JFrame{
    private CombateController combateController;
    private JLabel vidaJogadorLabel = new JLabel();
    private JLabel vidaZumbiLabel = new JLabel();
    private JLabel imagemJogadorLabel = new JLabel();
    private JLabel imagemZumbiLabel = new JLabel();
    
    private final int X_SIZE = 250;
    private final int Y_SIZE = 250;
    
    private final String coracaoVermelhoUrl = "src/main/java/com/pacotao/imagens/coracao_cheio.png";
    private final String coracaoPartidoUrl = "src/main/java/com/pacotao/imagens/coracao_vazio.png";
    
    public CombateFrame(CombateController combateController){
        this.combateController = combateController;
        setTitle("Combate");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(new BackgroundPanel());
        setLayout(new BorderLayout());
        
        // Painel superior com layout personalizado
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setOpaque(false);

        // Painel para o jogador (esquerda)
        JPanel jogadorPanel = new JPanel();
        jogadorPanel.setOpaque(false);
        jogadorPanel.setLayout(new BoxLayout(jogadorPanel, BoxLayout.Y_AXIS));
        vidaJogadorLabel = new JLabel();
        imagemJogadorLabel = new JLabel();
        vidaJogadorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagemJogadorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jogadorPanel.add(vidaJogadorLabel);
        jogadorPanel.add(imagemJogadorLabel);

        // Painel para o zumbi (direita)
        JPanel zumbiPanel = new JPanel();
        zumbiPanel.setOpaque(false);
        zumbiPanel.setLayout(new BoxLayout(zumbiPanel, BoxLayout.Y_AXIS));
        vidaZumbiLabel = new JLabel();
        imagemZumbiLabel = new JLabel();
        vidaZumbiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagemZumbiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        zumbiPanel.add(vidaZumbiLabel);
        zumbiPanel.add(imagemZumbiLabel);
        
        jogadorPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        zumbiPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        // Adiciona os painéis no statusPanel
        statusPanel.add(jogadorPanel, BorderLayout.WEST);
        statusPanel.add(zumbiPanel, BorderLayout.EAST);

        add(statusPanel, BorderLayout.CENTER);


        // Painel de ações
        JPanel actionPanel = new JPanel(new GridLayout(3, 1));
        actionPanel.setPreferredSize(new Dimension(600, 100));
        actionPanel.setOpaque(false);
        JButton attackButton = new JButton("Atacar");
        JButton healButton = new JButton("Curar");
        JButton fleeButton = new JButton("Fugir");

        actionPanel.add(attackButton);
        actionPanel.add(healButton);
        actionPanel.add(fleeButton);
        add(actionPanel, BorderLayout.SOUTH);

        // Listeners
        attackButton.addActionListener(e -> mostrarOpcoesDeAtaque());
        healButton.addActionListener(e -> combateController.cura());
        //fleeButton.addActionListener(e -> combateController.flee());

        carregarImagens();
        atualizarBarrasDeVida();
        setVisible(true);
        
    }
    
   public void mostrarResultadoDado(int resultado, String msg) {
    // Carregar imagem do dado com o número correspondente
    String imagemDadoUrl = "src/main/java/com/pacotao/imagens/dado" + resultado + ".png";
    ImageIcon dadoIcon = new ImageIcon(imagemDadoUrl);
    
    // Criar uma mensagem para exibir o dado e o resultado
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JLabel dadoLabel = new JLabel(dadoIcon);
    JLabel resultadoLabel = new JLabel("Resultado: " + resultado);
    JLabel msgLabel = new JLabel(msg);
    
    panel.add(dadoLabel);
    panel.add(resultadoLabel);
    panel.add(msgLabel);
    
    // Exibir a janela pop-up
    JOptionPane.showMessageDialog(this, panel, "Resultado da Rolagem", JOptionPane.INFORMATION_MESSAGE);
}
   
   public void mostrarRodadaZumbi(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel resultadoLabel = new JLabel("Vez do zumbi!");
        
         panel.add(resultadoLabel);
        // Exibir a janela pop-up
        JOptionPane.showMessageDialog(this, panel, "", JOptionPane.INFORMATION_MESSAGE);
   }
    
    
    public void atualizarBarrasDeVida() {
        vidaJogadorLabel.setIcon(gerarBarraDeVida(combateController.getVidaJogador(), 5));
        vidaZumbiLabel.setIcon(gerarBarraDeVida(combateController.getVidaZumbi(), 3));
    }
    
    public void mostrarResultado(String mensagem, String tipoResultado, boolean fimCombate) {
    // Criar a mensagem para o jogador
    String texto = "<html><h2>" + mensagem + "</h2></html>";
    
    // Mostrar a mensagem ao jogador
    JOptionPane.showMessageDialog(this, texto, tipoResultado, JOptionPane.INFORMATION_MESSAGE);
    
    if(fimCombate){
        dispose();  
    }
    
}
    
    // Carregar imagens dos personagens
    public void carregarImagens() {
        try {
            
            ImageIcon playerIcon = this.combateController.getImagem(this.combateController.getJogador());
            ImageIcon zombieIcon = this.combateController.getImagem(this.combateController.getZumbi());;

            imagemJogadorLabel.setIcon(new ImageIcon(playerIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            imagemZumbiLabel.setIcon(new ImageIcon(zombieIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagens: " + e.getMessage());
        }
    }
    // Popup para escolha de ataque
    private void mostrarOpcoesDeAtaque() {
        int option = JOptionPane.showOptionDialog(
                this,
                "Escolha seu ataque:",
                "Ataque",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Mão", "Arma"},
                "Mão"
        );

        boolean usaArma = (option == 1);
        combateController.atacarZumbi(usaArma);
    }
    
    // Método para gerar barra de vida com imagens
    public ImageIcon gerarBarraDeVida(int vidaAtual, int vidaMaxima) {
        int coracoesVermelhos = Math.max(vidaAtual, 0);
        int coracoesPretos = Math.max(vidaMaxima - vidaAtual, 0);
        
        try {
            ImageIcon coracaoVermelhoIcon = new ImageIcon(coracaoVermelhoUrl);
            ImageIcon coracaoPretoIcon = new ImageIcon(coracaoPartidoUrl);

            // Verifica se as imagens são válidas
            if (coracaoVermelhoIcon.getIconWidth() <= 0 || coracaoVermelhoIcon.getIconHeight() <= 0 ||
                coracaoPretoIcon.getIconWidth() <= 0 || coracaoPretoIcon.getIconHeight() <= 0) {
                throw new IllegalArgumentException("Erro: As imagens de coração não foram carregadas corretamente.");
            }

            Image coracaoVermelho = carregarERedimensionarImagem(coracaoVermelhoUrl, 40, 40);
            Image coracaoPreto = carregarERedimensionarImagem(coracaoPartidoUrl, 40, 40);
            
            int largura = 20 * vidaMaxima;
            int altura = 40;
            BufferedImage combinedImage = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
            Graphics g = combinedImage.getGraphics();

            for (int i = 0; i < coracoesVermelhos; i++) {
                g.drawImage(coracaoVermelho, i * 20, 0, null);
            }
            for (int i = 0; i < coracoesPretos; i++) {
                g.drawImage(coracaoPreto, (coracoesVermelhos + i) * 20, 0, null);
            }

            g.dispose();
            return new ImageIcon(combinedImage);
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagens de coração: " + e.getMessage());
            return null;
        }
    }
    
    private BufferedImage carregarERedimensionarImagem(String imageUrl, int width, int height) throws Exception {
    BufferedImage originalImage = ImageIO.read(new File(imageUrl));
    BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = resizedImage.createGraphics();
    g2d.drawImage(originalImage, 0, 0, width, height, null);
    g2d.dispose();
    return resizedImage;
}



}

// Classe interna para o painel de fundo
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {
            try {
                backgroundImage = new ImageIcon("src/main/java/com/pacotao/imagens/backgroundbattle.png").getImage();
            } catch (Exception e) {
                System.err.println("Erro ao carregar a imagem de fundo: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
