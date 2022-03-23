package com.example.basic.controller;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.basic.model.FileAtch;
import com.example.basic.repository.FileAtchRepository;

@Controller
public class UploadController {
	
	@Autowired
	FileAtchRepository fileAtchRepository;
	
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}
	
	
	@PostMapping("/upload1")
	@ResponseBody
	// MultipartHttpServletRequest 를 통해 file 등 많은 자료를 다 받는다.
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		
		String result = "";
		// mFile 이라는 MultipartFile 타입의 변수로 mRequest 에서 file 만 받아온다
		MultipartFile mFile = mRequest.getFile("file");
		String oName = mFile.getOriginalFilename();
		result += oName + "\n";
		long size = mFile.getSize();
		// 파일 중복검사. 해당 파일이 있는지 동일한 이름으로.
		File f =new File("c:/download/"+oName);
		
		String sName="";
		if(f.isFile()) {
			String fileName= oName.substring(0, oName.lastIndexOf("."));
			String fileExt= oName.substring(oName.lastIndexOf("."));
			sName=fileName + System.currentTimeMillis()+fileExt;
		}	else {
			sName = oName;
		}
		try {
			// new FIle 의 파라미터는 경로이다,.
			mFile.transferTo(new File("c:/download/"+sName));
			FileAtch fileAtch = new FileAtch();
			fileAtch.setOriginalName(sName);
			fileAtchRepository.save(fileAtch);
			
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return result+size;
	}

	
	@GetMapping("/upload2")
	public String upload2() {
		return "upload2";
	}
	
	
	@PostMapping("/upload2")
	@ResponseBody
	// input 의 name 아무거나 , 첨부파일 여러개.
	public String upload2Post(MultipartHttpServletRequest mRequest) {
		
		String result = "";
		Iterator<String> iter = mRequest.getFileNames();
		// iter 안엔 file abc efg 가 있다.
		
		// iterator 는 hasNext 를 사용해서 다음이 있는지 확인하는 while 을 주로 사용함.
		while(iter.hasNext()) {
			String  inputName =iter.next();
			List<MultipartFile> mFiles = mRequest.getFiles(inputName);
			for(MultipartFile mFile : mFiles) {

				String oName= mFile.getOriginalFilename();
				if(oName==null||oName.equals("")) {
					break;
				}
				try {
					mFile.transferTo(new File("c:/download/"+oName));
					FileAtch fileAtch = new FileAtch();
					fileAtch.setOriginalName(oName);
					fileAtchRepository.save(fileAtch);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
		return result;
	}

}