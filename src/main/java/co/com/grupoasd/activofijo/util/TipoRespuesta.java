/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.util;

/**
 * Clase para manejo de mensajes de los resultados.
 *
 * @author adrian G
 */
public class TipoRespuesta {

    public static final String MESSAGE_NOT_FOUND = "No se encontraron resultados para la buesqueda";
    public static final String MESSAGE_NO_CONTENT = "Se actualizo el activo exitosamente";
    public static final String MESSAGE_TIPO_ACTIVO_NOT_FOUND = "El tipo de activo no existe";
    public static final String MESSAGE_OK = "Se encontraron resultados exitosamente para la petición";
    public static final String MESSAGE_INTERNAL_SERVER_ERROR = "Se ha presentado un error con el servicio, por favor consulte con su administrador ";
    public static final String MESSAGE_BAD_REQUEST = "Faltan datos para la petición, por favor valide de nuevo ";
    public static final String MESSAGE_FECHA_BAD_REQUEST = "Error en la fecha, por favor verifiquela. formato de la fecha (yyyy-MM-dd)";
    public static final String MESSAGE_FECHA_BAJA_BAD_REQUEST = "La fecha de baja no debe ser superior a una fecha de compra";
    public static final String MESSAGE_TIPO_ID_BAD_REQUEST = "El tipo activo es numerico, por favor ingrese un dato valido";
    public static final String MESSAGE_PUT_NOT_FOUND = "Incapaz de actualizar. No se encontró el usuario con id: ";
}
