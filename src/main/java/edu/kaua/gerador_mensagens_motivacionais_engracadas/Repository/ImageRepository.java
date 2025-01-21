package edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.Domain.ContentInfo;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Random;

@Repository
public interface ImageRepository{

    public
        String textImagesDir = "src/main/resources/static/images/texts/";
        String contentDirLeft = "src/main/resources/static/images/left";
        String contentDirMiddle = "src/main/resources/static/images/middle";
        String contentDirRight = "src/main/resources/static/images/right";

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
    //Sim, esse metodo esta feio, reconheco isso, supere
    public static ContentInfo contentSelector() throws Exception {
        File contentFile = new File(getRandomPath(getRandomPath("src/main/resources/static/images/", null), null));

        ContentInfo content = new ContentInfo(
                contentFile.getAbsolutePath(),
                "null");

        if(contentFile.getParent().equals(contentDirLeft)) {
            content.setTextPath(getRandomPath(textImagesDir,"src/main/resources/static/images/texts/left"));
            content.setContentX(0);
            content.setContentY(1024);

            if (content.getTextPath().equals("src/main/resources/static/images/texts/middle")) {
                content.setTextX();
                content.setTextY();
            }else{
                content.setTextX();
                content.setTextY();
            }
        }
        if (contentFile.getParent().equals(contentDirMiddle)) {
            content.setTextPath(getRandomPath(textImagesDir,"src/main/resources/static/images/texts/middle"));
            content.setContentX();
            content.setContentY();

            if (content.getTextPath().equals("src/main/resources/static/images/texts/middle")) {
                content.setTextX();
                content.setTextY();
            }else{
                content.setTextX();
                content.setTextY();
            }
        }
        if (contentFile.getParent().equals(contentDirRight)) {
            content.setTextPath(getRandomPath(textImagesDir,"src/main/resources/static/images/texts/right"));

            content.setContentX();
            content.setContentY();

            if (content.getTextPath().equals("src/main/resources/static/images/texts/middle")) {
                content.setTextX();
                content.setTextY();
            }else{
                content.setTextX();
                content.setTextY();
            }
        return content;
    }
}
