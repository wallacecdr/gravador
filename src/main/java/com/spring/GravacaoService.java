package com.spring;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.Gravacao;
import com.spring.model.GravacaoRepository;

@Service
public class GravacaoService {

	
	@Autowired
	private GravacaoRepository gravacaoRepository;

	public Gravacao storeFile(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				System.out.println("Formato inválido");
			}

			Gravacao gravacao = new Gravacao(fileName, file.getContentType(), file.getBytes());
			
			return gravacaoRepository.save(gravacao);

		} catch (IOException ex) {
			System.out.println("Erro ao gravar o arquivo");
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public Gravacao getFile(Long fileId) {
		return gravacaoRepository.findById(fileId).get();
	}
}
