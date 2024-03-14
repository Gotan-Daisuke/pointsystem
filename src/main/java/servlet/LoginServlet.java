package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.LoginEntity;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // ユーザーから送信されたユーザーIDとパスワードを取得する。
	    String userId = request.getParameter("user_id");
	    String password = request.getParameter("password");
	    
	    LoginService service = new LoginService();
	    HttpSession session = request.getSession();


	    // ログイン認証後に遷移する先を格納する
	    String path = "";

	            // SQLの実行
	            List<LoginEntity> list = service.findbylogin(userId, password);
	            
	            if(list.size() == 1) {
	            	session.setAttribute("user_id", list.get(0).getUserid());
	            	session.setAttribute("user_name", list.get(0).getUsername());

	                // ログイン成功画面に遷移する
	                path = "success.jsp";
	            	
	            } else if(list.size() > 1){
	                // ログイン失敗の文言を追加する
	                request.setAttribute("loginFailure", "ユーザーが重複してます。管理者に問い合わせてください");

	                // ログインに失敗したときはもう一度ログイン画面を表示する
	                path = "login.jsp";
	            } else {
	                request.setAttribute("loginFailure", "ログインに失敗しました。ユーザーIDとパスワードを確認してください");

	                // ログインに失敗したときはもう一度ログイン画面を表示する
	                path = "login.jsp";
	            }
	            
	    RequestDispatcher rd = request.getRequestDispatcher(path);
	    rd.forward(request, response);
	}
}
