package edu.kaua.gerador_mensagens_motivacionais_engracadas.Service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MessageService {

    //Organizar nome de output das imagens
    public static String imageOutputName(String directoryPath){
        File dir = new File(directoryPath);

        File[] files = dir.listFiles(File::isFile);
        if (files.length == 0){
            return "image_0.png";
        }else{
            return "image_" + files.length + ".png";
        }
    }
}
