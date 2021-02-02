/*
* Archivo: TipoRespuesta
* Fecha: 31/01/2021
* Todos los derechos de propiedad intelectual e industrial sobre esta
* aplicacion son de propiedad exclusiva del GRUPO ASD S.A.S.
* Su uso, alteracion, reproduccion o modificacion sin el debido
* consentimiento por escrito de GRUPO ASD S.A.S. quedan totalmente prohibidos.
* 
* Este programa se encuentra protegido por las disposiciones de la
* Ley 23 de 1982 y demas normas concordantes sobre derechos de autor y
* propiedad intelectual. Su uso no autorizado dara lugar a las sanciones
* previstas en la Ley.
 */
package co.com.grupoasd.activofijo.util;

/**
 * Clase para manejo de mensajes de los resultados.
 *
 * @author adrian G
 */
public class TipoRespuesta {

    public static final String MESSAGE_NOT_FOUND = "No se encontraron resultados para la búsqueda";
    public static final String MESSAGE_NO_CONTENT = "Se actualizo el activo exitosamente";
    public static final String MESSAGE_TIPO_ACTIVO_NOT_FOUND = "El tipo de activo no existe";
    public static final String MESSAGE_ACTIVO_FIJO_NOT_FOUND = "El activo no existe";
    public static final String MESSAGE_ACTIVO_FIJO_ASIGNADO_NOT_FOUND = "El activo ya esta asignado";
    public static final String MESSAGE_AREA_NOT_FOUND = "El área no existe";
    public static final String MESSAGE_PERSONA_NOT_FOUND = "La persona no existe";
    public static final String MESSAGE_ESTADO_NOT_FOUND = "El estado del activo no existe";
    public static final String MESSAGE_OK = "Se encontraron resultados exitosamente para la petición";
    public static final String MESSAGE_ACTIVO_OK = "El activo fue asignado correctamente";
    public static final String MESSAGE_CREATE_OK = "El activo fue creado exitosamente";
    public static final String MESSAGE_INTERNAL_SERVER_ERROR = "Se ha presentado un error con el servicio, por favor consulte con su administrador ";
    public static final String MESSAGE_BAD_REQUEST = "Faltan datos para la petición, por favor valide de nuevo ";
    public static final String MESSAGE_FECHA_BAD_REQUEST = "Error en la fecha, por favor verifíquela. formato de la fecha (yyyy-MM-dd)";
    public static final String MESSAGE_FECHA_BAJA_BAD_REQUEST = "La fecha de baja no debe ser superior a una fecha de compra";
    public static final String MESSAGE_TIPO_ID_BAD_REQUEST = "El tipo activo es numérico, por favor ingrese un dato valido";
    public static final String MESSAGE_PUT_NOT_FOUND = "Incapaz de actualizar. No se encontró el usuario con id: ";
    public static final String MESSAGE_SERIAL_BAD_REQUEST = "El serial ya existe, por favor ingrese uno nuevo";
}
