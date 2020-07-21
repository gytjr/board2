package java_board2;

import java.util.ArrayList;
import java.util.Scanner;


public class Board {

	static ArrayList<Article> articles = new ArrayList<Article>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String cmd = "";
		
		int id = 1;
		
		
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

}



class Article {
	int id;
	String title;
	String body;
	String writer;
	String regDate;
	
	Article() {
		
	}
}
