package edu.kaua.gerador_mensagens_motivacionais_engracadas;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain.ContentInfo;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Service.ImageGenerator;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository.ImageRepository;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Service.MessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeradorMensagensMotivacionaisEngracadasApplication {

	public static void main(String[] args) {
		try {
			//Chamando função que seleciona conteúdo
			ContentInfo content = ImageRepository.contentSelector();

			//Diretório com as imagens de fundo
			String backgroundDir = "src/main/resources/static/images/background/";

			//Diretório de saída
			String outputPath = "src/main/resources/static/images_output/";

			//Escolher imagem de fundo aleatória
			String caminhoBackground = ImageRepository.getRandomPath(backgroundDir, null);

			//Função que gera a imagem
			ImageGenerator.sobreporImagem(
					caminhoBackground,
					content.getContentPath(),
					content.getTextPath(),
					content.getTitlePath(),
					outputPath + MessageService.imageOutputName(outputPath),
					content.getContentX(),
					content.getContentY(),
					content.getTextX(),
					content.getTextY(),
					content.getTitleX(),
					content.getTitleY());

			System.out.println("Imagem gerada com sucesso em: " + outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
