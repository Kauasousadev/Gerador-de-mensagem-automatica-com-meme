package edu.kaua.gerador_mensagens_motivacionais_engracadas;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain.ContentInfo;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain.ImageGenerator;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository.ImageRepository;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Service.MessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeradorMensagensMotivacionaisEngracadasApplication {

	public static void main(String[] args) {
		try {
			// Escolher conteúdo aleatório com validações de posição
			ContentInfo content = ImageRepository.contentSelector();

			// Diretório com as imagens
			String backgroundDir = "src/main/resources/static/images/background/";
            assert content != null;
			String imagePath = content.getContentPath();
			String textoImagem = content.getTextPath();
			String outputPath = "src/main/resources/static/images_output/";

			// Escolher fundo aleatório
			String caminhoBackground = ImageRepository.getRandomPath(backgroundDir, null);

			// Juntar background com imagem aleatória
			ImageGenerator.sobreporImagem(
					caminhoBackground,
					imagePath,
					outputPath + MessageService.imageOutputName(outputPath),
						);

			System.out.println("Imagem gerada com sucesso em: " + outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
