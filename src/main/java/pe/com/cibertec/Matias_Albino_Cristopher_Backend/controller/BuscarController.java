package pe.com.cibertec.Matias_Albino_Cristopher_Backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.Matias_Albino_Cristopher_Backend.dto.BuscarResponseDTO;
import pe.com.cibertec.Matias_Albino_Cristopher_Backend.dto.BuscarResquestDTO;
import pe.com.cibertec.Matias_Albino_Cristopher_Backend.service.BuscarService;

import java.io.IOException;


@RestController
@RequestMapping("/busqueda")

public class BuscarController {

    @Autowired
    BuscarService buscarService;

    @PostMapping("/buscar")
    public BuscarResponseDTO buscar(@RequestBody BuscarResquestDTO buscarResquestDTO){

        try {
            String[] datosPlaca = buscarService.buscarPlaca(buscarResquestDTO);
            System.out.println("Resultado :");
            if(datosPlaca == null){
                return new BuscarResponseDTO("01","Error:Placa no Existe","","","","","");
            }

            return  new BuscarResponseDTO("00","",datosPlaca[0],datosPlaca[1],datosPlaca[2],datosPlaca[3],datosPlaca[4]);

        } catch (IOException e) {
            return new BuscarResponseDTO("99","Ocurrio un Problema","","","","","");
        }

    }
}
