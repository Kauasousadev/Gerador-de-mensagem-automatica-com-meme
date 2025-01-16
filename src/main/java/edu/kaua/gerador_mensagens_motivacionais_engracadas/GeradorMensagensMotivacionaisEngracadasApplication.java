package edu.kaua.gerador_mensagens_motivacionais_engracadas;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain.ImageGenerator;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository.ImageRepository;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.Service.MessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeradorMensagensMotivacionaisEngracadasApplication {

	public static void main(String[] args) {
		try {
			// Diretório com as imagens
			String imageDir = "src/main/resources/static/images/background/";

			String textoImagem = "src/main/resources/static/images/texts/boa_noite_amarelo.png";

			// Obter uma imagem aleatória
			String caminhoImagemAleatoria = ImageRepository.getRandomImagePath(imageDir);

			// Mensagem motivacional
			String texto = "Bom dia!";

			// Caminho para salvar a imagem gerada
			String outputPath = "src/main/resources/static/images_output/";

			// Gerar a imagem com texto
			ImageGenerator.sobreporImagem(caminhoImagemAleatoria, textoImagem, outputPath + MessageService.imageOutputName(outputPath));

			System.out.println("Imagem gerada com sucesso em: " + outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
