package java_board2;

import java.util.ArrayList;
import java.util.Scanner;

import java_board.Article;


public class Board {

	static ArrayList<Article> articles = new ArrayList<Article>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String cmd = "";
		
		int id = 1;
		
		Article article1 = new Article(1, "테스트제목", "테스트내용", Util.getCurrentDate());
		
		articles.add(article1);
		
		while(true) {
			
			System.out.print("명령어를 입력해주세요 : ");
			cmd = sc.nextLine();
			
			
			if(cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}
			if(cmd.equals("help")) {
				System.out.println("add : 게시물 저장");
				System.out.println("read : 게시물 조회");
				System.out.println("update : 게시물 수정");
				System.out.println("delete : 게시물 삭제");
				System.out.println("search : 게시물 검색");
			}
			if(cmd.equals("add")) {
				
				Article article = new Article();
				article.id = id;
				id ++;
				
				System.out.print("제목을 입력해주세요 : ");
				
				String title = sc.nextLine();
				article.title = title;
				
				article.regDate = Util.getCurrentDate();
				
				articles.add(article);
				System.out.println("게시물이 등록되었습니다.");
				
	
			}
			if(cmd.equals("read")) {
				for(int i = 0; i < articles.size(); i++) {
					System.out.println("========게시물 목록========");
					System.out.println("제목 : " + articles.get(i).title);
					
					String str = articles.get(i).regDate;
					String[] arr = str.split(" ");
					System.out.println("작성일 : " + arr[0]);
				}
			}
			if(cmd.equals("update")) {
				System.out.println("어떤 게시물을 수정하시겠습니까? : ");
				int targetNo = Integer.parseInt(sc.nextLine());
				Article targetArticle =get_article_by_id(targetNo);
				
				if(targetArticle != null) {
					System.out.print("수정할 제목을 입력해주세요 : ");
					String update_title = sc.nextLine();
					targetArticle.title = update_title; 
				}else {
					System.out.println("없는 게시물 번호입니다.");
				}
				
				
			}
			if(cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호를 입력해주세요 : ");
				int targetNo = Integer.parseInt(sc.nextLine());
				Article targetArticle =get_article_by_id(targetNo);

				if(targetArticle != null) {
					articles.remove(targetArticle);
					System.out.println("게시물이 삭제되었습니다.");
				}else {
					System.out.println("없는 게시물 번호입니다.");
				}
				
			}
			if(cmd.equals("search")) {
				System.out.println("검색항목을 선택하세요 1. 제목 2. 내용");
				int serchFlag = Integer.parseInt(sc.nextLine());
				
				System.out.print("검색어를 입력하세요 : ");
				String keyword = sc.nextLine();
				
				ArrayList<Article> searchedArticles = new ArrayList<>();
				
				if(serchFlag == 1) {
					for(int i = 0; i < articles.size(); i ++) {
						if(articles.get(i).title.contains(keyword)) {
							searchedArticles.add(articles.get(i));
						}
					}
				}
				if(serchFlag == 2) {
					for(int i = 0; i < articles.size(); i ++) {
						if(articles.get(i).body.contains(keyword)) {
							searchedArticles.add(articles.get(i));
						}
					}
				}
				
				print_article(searchedArticles);
				
				
			}
		}

	}
	
	static Article get_article_by_id(int id) {
		Article article = null;
		for(int i = 0; i < articles.size(); i++) {
			
			Article target = articles.get(i);
			
			if(target.id == id) {
				article = target;
				break;
			}
		}
		return article;
	}
	
	public void print_article(Article article) {
			System.out.println("===게시물 목록===");
			System.out.println("제목 : " + article.title);
			System.out.println("내용 : " + article.body);
	}

}



class Article {
	int id;
	String title;
	String body;
	String writer;
	String regDate;
	
	Article() {
		
	}
	
	Article(int id, String title, String body, String regDate) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}
}
