package api;

import org.json.JSONException;
import org.json.JSONObject;

public class Dados {
	public JSONObject getDados (){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.append("funcionarios", new JSONObject("{nome: Belchior, salario: 200, matricula: 1}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: Thiago, salario: 300, matricula: 2}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: Guilherme, salario: 400, matricula: 3}"));
			// cliente
			jsonObject.append("clientes", new JSONObject("{nome: Bernardo, credito: 500, id: 1}"));
			jsonObject.append("clientes", new JSONObject("{nome: Miranda, salario: 1000, id: 2}"));
			jsonObject.append("clientes", new JSONObject("{nome: Matheus, salario: 30000, id: 3}"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
