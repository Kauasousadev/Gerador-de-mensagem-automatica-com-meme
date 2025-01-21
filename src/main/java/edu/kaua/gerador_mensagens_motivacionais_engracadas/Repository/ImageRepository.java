package edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain.ContentInfo;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Random;

@Repository
public interface ImageRepository {

    public
    String textImagesDir = "src/main/resources/static/images/texts";
    String contentDirLeft = "src/main/resources/static/images/content/left";
    String contentDirMiddle = "src/main/resources/static/images/content/middle";
    String contentDirRight = "src/main/resources/static/images/content/right";

    public static String getRandomPath(String directoryPath, String dirExclusion) throws Exception {
        // Valida se o diretório existe e é realmente um diretório
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new Exception("Diretório não encontrado ou inválido: " + directoryPath);
        }

        // Lista todos os arquivos do diretório
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            throw new Exception("O diretório está vazio ou não pode ser lido: " + directoryPath);
        }

        // Busca o índice do arquivo a ser excluído (se existir)
        int indexExclusion = -1;
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(dirExclusion)) {
                indexExclusion = i;
                break;
            }
        }

        // Seleciona um arquivo aleatório, evitando o arquivo de exclusão
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(files.length);
        } while (index == indexExclusion);

        return files[index].getAbsolutePath();
    }

    public static ContentInfo contentSelector() throws Exception {
        File contentFile = new File(
                getRandomPath(
                        getRandomPath("src/main/resources/static/images/content", null), null));

        File textFile = new File(
                getRandomPath(
                        getRandomPath("src/main/resources/static/images/texts", null), null));

        String parentDirName = new File(contentFile.getParent()).getName();
        String parentDirNametext = new File(textFile.getParent()).getName();

        ContentInfo content = new ContentInfo(
                contentFile.getAbsolutePath(),
                textFile.getAbsolutePath());

        switch (parentDirName) {
            case "left":
                content.setContentX(0);
                content.setContentY(1024 - 512);
                if (parentDirNametext.equals("middle-top")) {
                    content.setTextX(512);
                    content.setTextY(128);
                } else {
                    content.setTextX(640);
                    content.setTextY(512);
                }
                break;
            case "middle":
                content.setContentX((1024 - 512) / 2);
                content.setContentY(1024 - 512);
                if (parentDirNametext.equals("left")) {
                    content.setTextX(128);
                    content.setTextY(512);
                } else if (parentDirNametext.equals("middle-top")) {
                    content.setTextX(512);
                    content.setTextY(128);
                } else {
                    content.setTextX(640);
                    content.setTextY(512);
                }
                break;
            case "right":
                content.setContentX(1024 - 512);
                content.setContentY(1024 - 512);
                if (parentDirNametext.equals("middle-top")) {
                    content.setTextX(512);
                    content.setTextY(128);
                } else {
                    content.setTextX(128);
                    content.setTextY(512);
                }
                break;
            default:
                throw new Exception("Diretório desconhecido: " + parentDirName);
        }
        return content;
    }
}