package edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageGenerator {

    public static void criarImagemComTexto(String caminhoImagem, String texto, String caminhoSaida) throws Exception {
        // Carregar a imagem de fundo
        BufferedImage imagemFundo = ImageIO.read(new File(caminhoImagem));

        // Configurar o gráfico
        Graphics2D graphics = imagemFundo.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Carregar a fonte customizada
        InputStream fontStream = ImageGenerator.class.getResourceAsStream("/fonts/Bouncy-Black-PERSONAL_USE_ONLY.otf");
        Font fonteCustomizada = Font.createFont(Font.TRUETYPE_FONT, fontStream);

        // Configurar cor do texto
        graphics.setColor(Color.YELLOW);

        // Tamanho inicial da fonte (baseado na largura da imagem)
        int fontSize = imagemFundo.getWidth() / 10;
        Font fonteAjustada = fonteCustomizada.deriveFont((float) fontSize);
        graphics.setFont(fonteAjustada);

        // Ajustar dinamicamente o tamanho da fonte para caber na imagem
        FontMetrics metrics = graphics.getFontMetrics(fonteAjustada);
        while (metrics.stringWidth(texto) > imagemFundo.getWidth() - 20) { // Deixe uma margem de 20px
            fontSize -= 2;
            fonteAjustada = fonteCustomizada.deriveFont((float) fontSize);
            graphics.setFont(fonteAjustada);
            metrics = graphics.getFontMetrics(fonteAjustada);
        }

        // Determinar posição do texto (centralizado)
        int x = (imagemFundo.getWidth() - metrics.stringWidth(texto)) / 2;
        int y = imagemFundo.getHeight() - metrics.getHeight();

        // Escrever o texto na imagem
        graphics.drawString(texto, x, y);
        graphics.dispose();

        // Salvar a imagem gerada
        ImageIO.write(imagemFundo, "jpg", new File(caminhoSaida));
    }
}
