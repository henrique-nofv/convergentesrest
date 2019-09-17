//package edu.up.bsi.conv.jwt;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Classe para testes de Usuários e papéis para teste de JWT.
// * 
// * @author Andre Pimenta
// *
// */
//public class JWTTokenUserFake {
//
//	private static Map<String, String> credenciais = new HashMap<>();
//
//	private static Map<String, String[]> papeis = new HashMap<>();
//
//	static {
//		credenciais.put("joao", "joao");
//		credenciais.put("maria", "maria");
//		credenciais.put("roberto", "roberto");
//
//		papeis.put("joao", new String[] { "REST-API", "ADMIN" });
//		papeis.put("maria", new String[] { "REST-API", "USER" });
//		papeis.put("roberto", new String[] { "REST-API", "GUEST" });
//
//	}
//
//	/**
//	 * Verifica usuário e senah e retorna os papeis do usuário.
//	 * 
//	 * @param username
//	 * @param password
//	 * @return
//	 * @throws Exception
//	 */
//	public static String[] recuperaPapeis(String username, String password) throws Exception {
//		String check = credenciais.get(username);
//		if (check != null && check.equalsIgnoreCase(password)) {
//			return papeis.get(username);
//		} else {
//			throw new Exception("Credenciais inválidas!");
//		}
//	}
//
//}
