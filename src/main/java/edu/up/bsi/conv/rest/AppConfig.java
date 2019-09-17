package edu.up.bsi.conv.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configura o mapeamento de URL inicial para a API REST
 * 
 * @author Andre Pimenta
 *
 */
@ApplicationPath(value = "/rest")
public class AppConfig extends Application {

}
