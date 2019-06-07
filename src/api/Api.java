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



@WebServlet("/Api")
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Representação de nosso banco de dados
	JSONObject bandoDeDados = new Dados().getDados(); 
  
    public Api() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    out.print(bandoDeDados);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			gerenciaPost(request, response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void gerenciaPost(HttpServletRequest request, HttpServletResponse response) throws JSONException, ServletException, IOException {
		// armazena a operacao a ser efetuada
		String operacao = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonString = "";
        if(br != null){
        	jsonString = br.readLine();
        }
        JSONObject jsonObj = new JSONObject(jsonString);
        operacao = jsonObj.get("operacao").toString();
        JSONObject valores = (JSONObject) jsonObj.get("valores");
        String tabela = valores.get("table").toString();
        
        
		
		if(operacao.equals("updateTable")) {
			// Se é uma operação de atualização, chama rotina de atualização
			update(tabela, valores);
		}else if(operacao.equals("addTable")) {
			// se a operação é de criação de tabela, adiciona a tabela ao nosso objeto
			JSONArray campos = (JSONArray) valores.get("campos");
	        JSONObject camposObj = new JSONObject();
	        for(int i = 0; i < campos.length(); i++) {
	        	camposObj.put(campos.getString(i), "");
	        }
			bandoDeDados.append(tabela, camposObj);
			
		}else if(operacao.equals("inserirDados")) {
			// se a operação é de inclusao de dados, adiciona uma nova tupla na tabela
			JSONArray jsonTabela = (JSONArray) bandoDeDados.get(tabela);
			JSONArray campos = (JSONArray) valores.get("campos");
		    JSONObject camposObj = new JSONObject();
	        
	        for(int i = 0; i < campos.length(); i++) {
	        	JSONArray keysValues =  (JSONArray) campos.get(i);
	        	String key = keysValues.get(0).toString();
	        	String val = keysValues.get(1).toString();
	        	camposObj.put(key, val);
	        }
	        jsonTabela.put(camposObj);
	       
			
		}
		
        PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    out.print(bandoDeDados);
	}
	public JSONObject update(String tableName, JSONObject valores) throws JSONException{
		JSONObject jsonObject = bandoDeDados;
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
