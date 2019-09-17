//package edu.up.bsi.conv.jwt;
//
///**
// * Tipos de Claims (Reinvidicações de acesso) padrões reservados para uso.
// * 
// * @author Andre Pimenta
// *
// */
//public enum ClaimType {
//
//	ISSUER("iss", "Entidade geradora do TOKEN."),
//	SUBJECT("sub", "Identificação de quem está recebendo o TOKEN para acesso."),
//	AUDIENCE("aud", "Identificação do público que está apto a receber o TOKEN para o serviço."),
//	EXPIRATION_TIME("exp", "Data e hora de expiração do TOKEN."),
//	NOT_BEFORE("nbf", "Data e hora de início para aceitar o TOKEN, não aceitar antes dessa data."),
//	ISSUED_AT("iat", "Date e hora de criação do TOKEN."),
//	JWT_ID("jti", "Identificação única do TOKEN JWT para situações de necessidade de uso único, ou algo semelhante.");
//
//	private String shortName;
//	private String description;
//
//	private ClaimType(String shortName, String description) {
//		this.shortName = shortName;
//		this.description = description;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public String shortName() {
//		return shortName;
//	}
//
//}
