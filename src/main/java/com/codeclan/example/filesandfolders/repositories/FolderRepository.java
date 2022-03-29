package com.codeclan.example.filesandfolders.repositories;

import com.codeclan.example.filesandfolders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository <Folder, Long> {
}
