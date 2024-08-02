package ar.com.laboratory.candidatesapi.domain;

import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class DolarResponse {
    private String moneda;
    private String casa;
    private String nombre;
    private int compra;
    private int venta;
    private ZonedDateTime fechaActualizacion;
}