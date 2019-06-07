package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import api.Dados;

@WebServlet("/Funcionario")
public class Funcionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Funcionario() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	JSONObject jsonObject = new Dados().getDados();  
		    PrintWriter out = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    out.print(jsonObject);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// armazena a operacao a ser efetuada
		String operacao = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonString = "";
        if(br != null){
        	jsonString = br.readLine();
        }
        JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(jsonString);
			operacao = jsonObj.get("operacao").toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if(operacao.equals("updateTable")) {
			// Se é uma operação de atualização, chama rotina de atualização
			String tabela = null;
			try {
				tabela = jsonObj.get("tabela").toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JSONObject valores = null;
			try {
				valores = (JSONObject) jsonObj.get("valores");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				update(tabela, valores);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
       
	}
	JSONObject update(String tableName, JSONObject valores) throws JSONException{
		JSONObject jsonObject = new Dados().getDados();
		JSONArray jsonTabela = (JSONArray) jsonObject.get(tableName);
		
		
		for(int i = 0; i < jsonTabela.length(); i++) {
			JSONObject tupla = (JSONObject) jsonTabela.get(i);
			//System.out.print(tupla.get("matricula") + "/" +valores.get("matricula") + "/");
			if(tupla.get("matricula").equals(valores.get("matricula"))) {
				System.out.print(tupla.get("matricula") + "/" +valores.get("matricula") + "/");
				tupla.put("nome", valores.get("nome"));
				tupla.put("salario", valores.get("salario"));
			}
		}
		
		return jsonObject;
	}
}
