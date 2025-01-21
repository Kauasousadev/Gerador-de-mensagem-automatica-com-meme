package edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageGenerator {

    public static void sobreporImagem(String caminhoFundo, String caminhoPng, String caminhoText, String caminhoSaida, int imageX, int imageY, int textX, int textY) throws IOException {
        // Carrega as imagens
        BufferedImage imagemFundo = ImageIO.read(new File(caminhoFundo));
        BufferedImage imagemPng = ImageIO.read(new File(caminhoPng));
        BufferedImage textoPng = ImageIO.read(new File(caminhoText));

        // Obtém o contexto gráfico da imagem de fundo
        Graphics2D g2d = imagemFundo.createGraphics();

        // Sobrepõe o PNG na imagem de fundo
        g2d.drawImage(imagemPng, imageX, imageY, null);

        // Sobrepõe o PNG na imagem de fundo
        g2d.drawImage(textoPng, textX, textY, null);

        // Libera o contexto gráfico
        g2d.dispose();

        // Salva a imagem resultante
        ImageIO.write(imagemFundo, "png", new File(caminhoSaida));

        System.out.println("Imagem combinada salva em: " + caminhoSaida);
    }
}
