//package com.mypet.web.brd;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//@Component
//public class ArticelInit implements ApplicationRunner{
//	private ArticleRepository articleRepository;
//	@Autowired
//	public ArticelInit(ArticleRepository articleRepository) {
//		this.articleRepository = articleRepository;
//	}
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		long count = articleRepository.count();
//		if(count == 1) {
//			Article article = null;
//			String[][] datas = {{"a","b","c","d","e","f","g","h"},
//								{"q","w","e","r","t","y","u","i"}};
//			for(String [] arr : datas) {
//				article = new Article();
//				article.setUserid(arr[0]);
//				article.setImage(arr[1]);
//				article.setComments(arr[2]);
//				article.setMsg(arr[3]);
//				article.setRating(arr[4]);
//				article.setCategory(arr[5]);
//				article.setHasgtag(arr[6]);
//				article.setContent(arr[7]);
//				articleRepository.save(article);
//			}
//		}
//		
//	}
//
//}
