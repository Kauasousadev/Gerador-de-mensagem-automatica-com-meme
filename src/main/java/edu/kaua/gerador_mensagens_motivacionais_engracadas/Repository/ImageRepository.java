package edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Random;

@Repository
public interface ImageRepository extends JpaRepository {

    public static String getRandomImagePath(String directoryPath) throws Exception {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new Exception("Diretório não encontrado: " + directoryPath);
        }

        // Lista todos os arquivos do diretório
        File[] files = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
        if (files == null || files.length == 0) {
            throw new Exception("Nenhuma imagem encontrada no diretório: " + directoryPath);
        }

        // Seleciona uma imagem aleatória
        Random random = new Random();
        int index = random.nextInt(files.length);
        return files[index].getAbsolutePath();
    }
}
