package pe.com.cibertec.Matias_Albino_Cristopher_Backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.com.cibertec.Matias_Albino_Cristopher_Backend.dto.BuscarResquestDTO;
import pe.com.cibertec.Matias_Albino_Cristopher_Backend.service.BuscarService;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BuscarServiceImpl implements BuscarService{

    @Autowired
    ResourceLoader resourceLoader;
   @Override
    public String[] buscarPlaca(BuscarResquestDTO buscarResquestDTO) throws IOException {

        String[] datoPlaca = null;
        Resource resource = resourceLoader.getResource("classpath:placa.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

            //ocurre algo aqui
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] datos = linea.split(";");
                if(buscarResquestDTO.nroPlaca().equals(datos[0])){
                    datoPlaca = new String[]{datos[0], datos[1], datos[2], datos[3], datos[4]};
                    break;
                }
            }

        }catch (IOException e){

            datoPlaca = null;
            throw  new IOException(e);
        }

        return datoPlaca;
    }
}
