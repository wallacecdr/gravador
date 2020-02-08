package com.spring.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.GravacaoService;
import com.spring.model.GravacaoDisco;
import com.spring.model.Gravacao;

@RestController
@RequestMapping("/gravacao")
public class GravacaoController {
	
	@Autowired
	private GravacaoService gravacaoService;
	
	@PostMapping("/")
	public void upload(@RequestParam MultipartFile gravacao) {
		//disco.salvarFoto(gravacao);
		gravacaoService.storeFile(gravacao);

	}
	
	@GetMapping("/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
        Gravacao dbFile = gravacaoService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName()+"."+dbFile.getFileType().split("/")[1] + "\"")
                .body(new ByteArrayResource(dbFile.getContent()));
    }
}
