package pe.com.cibertec.Matias_Albino_Cristopher_Backend.service;

import pe.com.cibertec.Matias_Albino_Cristopher_Backend.dto.BuscarResquestDTO;

import java.io.IOException;

public interface BuscarService {

    String[] buscarPlaca(BuscarResquestDTO buscarResquestDTO) throws IOException;
}
