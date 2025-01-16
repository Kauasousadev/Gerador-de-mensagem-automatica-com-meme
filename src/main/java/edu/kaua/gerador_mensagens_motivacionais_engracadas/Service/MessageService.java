package edu.kaua.gerador_mensagens_motivacionais_engracadas.Service;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository.MessageRepository;
import edu.kaua.gerador_mensagens_motivacionais_engracadas.model.MotivationalMessage;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MotivationalMessage randomMessage() {
        return messageRepository.findAllOrderByRandom();
    }

    public static String imageOutputName(String directoryPath){
        File dir = new File(directoryPath);
        // Lista todos os arquivos do diretório

        File[] files = dir.listFiles(File::isFile);
        if (files.length == 0){
            return "image_0.jpg";
        }else{
            return "image_" + files.length + ".jpg";
        }
    }
}
