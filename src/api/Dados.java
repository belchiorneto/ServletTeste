package api;

import org.json.JSONException;
import org.json.JSONObject;

public class Dados {
	public JSONObject getDados (){
		JSONObject jsonObject = new JSONObject();
		try {
			// funcionarios
			jsonObject.append("funcionarios", new JSONObject("{nome: Belchior, salario: 200, matricula: 1}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: Thiago, salario: 300, matricula: 2}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: Guilherme, salario: 400, matricula: 3}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: joão, salario: 300, matricula: 5}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: maria, salario: 500, matricula: 6}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: Gabriel, salario: 200, matricula: 7}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: José, salario: 100, matricula: 8}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: Bento, salario: 40, matricula: 9}"));
			jsonObject.append("funcionarios", new JSONObject("{nome: antonio, salario: 4, matricula: 10}"));
			// cliente
			jsonObject.append("clientes", new JSONObject("{nome: Bernardo, credito: 500, id: 1}"));
			jsonObject.append("clientes", new JSONObject("{nome: Miranda, credito: 2500, id: 2}"));
			jsonObject.append("clientes", new JSONObject("{nome: Hugo, credito: 300, id: 3}"));
			jsonObject.append("clientes", new JSONObject("{nome: Antonio, credito: 2000, id: 4}"));
			jsonObject.append("clientes", new JSONObject("{nome: Marieta, credito: 3200, id: 5}"));
			jsonObject.append("clientes", new JSONObject("{nome: Carlos, credito: 1000, id: 6}"));
			jsonObject.append("clientes", new JSONObject("{nome: Araujo, credito: 1500, id: 7}"));
			jsonObject.append("clientes", new JSONObject("{nome: Guilherme, credito: 2300, id: 8}"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
