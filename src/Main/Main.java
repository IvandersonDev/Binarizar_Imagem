package Main;

import Methods.BinarizarImagem;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedImage imagem = ImageIO.read(new File( "C:\\Users\\NOTEBOOK\\PDI\\BinarizarImagem\\src\\Image\\sombrinhas.jpg"));
        int limiar = 128;
        BinarizarImagem.binarizarImagem(imagem, limiar);
    }
}
