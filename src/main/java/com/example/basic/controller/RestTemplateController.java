package com.example.basic.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	// 크롤링으로 해당 페이지에서 받은 정보를
	// json 으로 출력함
	@GetMapping("/getString")
	public String getString() {
		RestTemplate rt = new RestTemplate();
		String result = rt.getForObject("http://ggoreb.com/http/json1.jsp", String.class);
		return result;
	}
	
	@GetMapping("/getMap")
	 public Map<String, Object> getMap() {
	 RestTemplate rt = new RestTemplate();
	 												// 가져오는 데이터를 ,뒤에 원하는 형식으로 받을수  있게 정의 가능.
	 Map<String, Object> map = rt.getForObject("http://ggoreb.com/http/json1.jsp", Map.class);
	 return map;
	 }
	
	@GetMapping("/getListMap")
	 public List<Map<String, Object>> getListMap() {
	 RestTemplate rt = new RestTemplate();
	 											// 요청 값에 대한 타입을 정확히 구분해야 오류 없이 받을수 있음.
	 List<Map<String, Object>> list = rt.getForObject("http://ggoreb.com/http/json2.jsp", List.class);
	 return list;
	 }

	@GetMapping("/getKakao")
	public ResponseEntity<Map> getKakao(@RequestParam("address") String address) {
		RestTemplate rt = new RestTemplate();
		RequestEntity requestEntity = null;
		try {
			
			
			// get (주소).headers(헤더값).build()
			requestEntity = RequestEntity.get(
					// RequestEntity 의 .get 은 .build() 로
					// request entity 로 변환한다.
					new URI("https://dapi.kakao.com/v2/local/search/address.json?query=" + 
							URLEncoder.encode(address, "utf-8")))
					.header("Authorization", "KakaoAK 4b03ad9c10dd53cb36c6bfdf8e968bf6")
					.build();
			// 이런식으로 build 를 마지막으로 중간에 필요 값을 넣는걸 builder 패턴이라고 한다.
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// exchange = HTTP 헤더를 지정하여 요청 및 응답 처리.
		// RestTemplate 에 requestENtity 와 반환받을 객체를 지정하여 실행.
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
	
	@GetMapping("/getNaver")
	public ResponseEntity<Map> getNaver(@RequestParam("text") String text) {
		RestTemplate rt = new RestTemplate();
		RequestEntity<Map<String, String>> requestEntity = null;
		try {
			Map<String, String> body = new HashMap<>();
			body.put("source", "ko");
			body.put("target", "en");
			body.put("text", text);
			requestEntity = RequestEntity.post(
					// RequestEntity 를 build 할때는 
					// URI (요청 주소)를 설정하고
					// 해당 값에서 .header 로 헤더에 값을 심을수 있고 (map식)
					// post 의 경우 body로 값이 전송되기에 body에 map 을 심어서 값을 넘긴다. 
					// post 는 body를 넣으면 build 끝.
					new URI("https://openapi.naver.com/v1/papago/n2mt"))
					.header("X-Naver-Client-Id", "ok2peDTn_fBvfUUVnMxp")// 뒤에 들어오는 header 와 body build RequestEntity의 하위 메소드
					.header("X-Naver-Client-Secret", "RkWZO7rOjF")// 서버-서버 통신간에 header는 보편적 인증 , 흔적남기기 등으로 사용됨.
					.body(body);
			/**body 가 Map<String,String> 이여서 RequestEntitiy 가 <Map<String,String>> 인거임? 맞음?**/
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
	
	@GetMapping("/getRoma")
	public Map getRoma(String query) {
		
		RestTemplate rt = new RestTemplate();
		RequestEntity<Void> requestEntity = null;
		// RequestEntity 의 기본 타입은 void 이고 body를 넣을 경우
		//		MAP 형식으로 작성되기에 <Map> 이 된다.
		
		try {
			requestEntity = RequestEntity.get(
					new URI("https://openapi.naver.com/v1/krdict/romanization?query="+
		URLEncoder.encode(query,"utf-8")))// 인코딩을 하는 이유는 api 레퍼런스를 보면 encoding 된걸 요청한다.
		//	URLEncoder 를 사용하여 입력하려는 String이 한글인 경우에도 전송할수 있도록 변경한다.
		//	URLEncoder 는 오류를 발생할수있기에 try-catch를 한다 ( 파라미터 2번에 입력한 값이 없는 규격일수도 있기에. )
					.header("X-Naver-Client-Id", "EhvIFNeuTheYWHcppYqx")
					.header("X-Naver-Client-Secret", "2w1MYBzlpK")
					.build();
					
					
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity= rt.exchange(requestEntity, Map.class);
		return entity.getBody();
		
	}
	
	
	
	@GetMapping("/getTran")
	public ResponseEntity<Map> getTran(@RequestParam("query") String query) {
		RestTemplate rt = new RestTemplate();
		RequestEntity requestEntity = null;
	
		try {			requestEntity = RequestEntity.get(
					new URI("https://dapi.kakao.com/v2/translation/translate?src_lang=kr&target_lang=en&query="+
							URLEncoder.encode(query,"utf-8")))
					.header("Authorization", "KakaoAK 4b03ad9c10dd53cb36c6bfdf8e968bf6")
					.build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
		return entity;
	}
}