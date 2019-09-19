package br.edu.up.conv.cancela.tarifa;

/**
 * Interface para recuperar o valor da tarifa de uma Categoria de Veículo para o
 * Pedágio.
 * 
 * @author Andre Pimenta
 *
 */
public interface Tarifa {

	/**
	 * Busca o valor em R$ do preço da tarifa para uma Categoria e Tipo de Praça.
	 * 
	 * @param tipoPraca
	 * @param categoria
	 * @return
	 */
	public Double buscarTarifa(String tipoPraca, String categoria);

}
