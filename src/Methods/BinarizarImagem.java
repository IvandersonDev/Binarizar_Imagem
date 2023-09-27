package Methods;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BinarizarImagem {

    static final String CAMINHO_PADRAO = "C:\\Users\\NOTEBOOK\\PDI\\BinarizarImagem\\src\\Image\\";

    public static void binarizarImagem(BufferedImage imagem, int limiar) throws IOException {

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemBinarizada = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_BINARY);

        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {

                int pixel = imagem.getRGB(linha, coluna);
                Color cor = new Color(pixel);

                int intensidade = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;

                if (intensidade < limiar) {
                    imagemBinarizada.setRGB(linha, coluna, Color.BLACK.getRGB());
                } else {
                    imagemBinarizada.setRGB(linha, coluna, Color.WHITE.getRGB());
                }

            }
        }

        String caminho = CAMINHO_PADRAO + "Binarizada.png";

        ImageIO.write(imagemBinarizada, "png", new File(caminho));
        JFrame janela = new JFrame();
        ImageIcon icon = new ImageIcon(imagemBinarizada);
        JLabel label = new JLabel(icon);
        janela.add(label);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
