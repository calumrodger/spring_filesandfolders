package com.codeclan.example.filesandfolders.components;

import com.codeclan.example.filesandfolders.models.File;
import com.codeclan.example.filesandfolders.models.Folder;
import com.codeclan.example.filesandfolders.models.User;
import com.codeclan.example.filesandfolders.repositories.FileRespository;
import com.codeclan.example.filesandfolders.repositories.FolderRepository;
import com.codeclan.example.filesandfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRespository fileRespository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User user1 = new User("Tom");
        userRepository.save(user1);

        Folder folder1 = new Folder("documents", user1);
        folderRepository.save(folder1);

        File file1 = new File("node", "js", 20, folder1);
        fileRespository.save(file1);

        folder1.addFile(file1);
        folderRepository.save(folder1);

        user1.addFolder(folder1);
        userRepository.save(user1);


    }
}
