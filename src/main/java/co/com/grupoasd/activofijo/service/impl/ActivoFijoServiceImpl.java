/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grupoasd.activofijo.service.impl;

import co.com.grupoasd.activofijo.entity.ActivoFijo;
import co.com.grupoasd.activofijo.entity.TipoActivo;
import co.com.grupoasd.activofijo.model.ActivoFijoRs;
import co.com.grupoasd.activofijo.model.PutActivoFijoRq;
import co.com.grupoasd.activofijo.model.PutActivoFijoRs;
import co.com.grupoasd.activofijo.repository.ActivoFijoRepository;
import co.com.grupoasd.activofijo.repository.TipoActivoRepository;
import co.com.grupoasd.activofijo.service.ActivoFijoService;
import co.com.grupoasd.activofijo.util.TipoRespuesta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de ActivoFijoService.
 *
 * @author adrian G
 */
@Service
@Transactional
public class ActivoFijoServiceImpl implements ActivoFijoService {

    /**
     * Repositorio activoFijoRepository
     */
    private final ActivoFijoRepository activoFijoRepository;
    /**
     * Repositorio tipoActivoRepository.
     */
    private final TipoActivoRepository tipoActivoRepository;

    /**
     * Constructor.
     *
     * @param activoFijoRepository repositorio activo fijo
     * @param tipoActivoRepository repositorio tipoActivoRepository
     */
    public ActivoFijoServiceImpl(ActivoFijoRepository activoFijoRepository,
            TipoActivoRepository tipoActivoRepository) {
        this.activoFijoRepository = activoFijoRepository;
        this.tipoActivoRepository = tipoActivoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ActivoFijoRs getActivoFijo() {
        ActivoFijoRs activoFijoRs = new ActivoFijoRs();
        List<ActivoFijo> activoFijos = activoFijoRepository.findAll();
        if (!activoFijos.isEmpty()) {
            activoFijoRs.setActivoFijos(activoFijos);
            activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_OK);

            return activoFijoRs;
        }
        activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_NOT_FOUND);
        return activoFijoRs;
    }

    @Override
    @Transactional(readOnly = true)
    public ActivoFijoRs getSearchActivoFijo(String tipoId, String fechaCompra, String serial) {
        ActivoFijoRs activoFijoRs = new ActivoFijoRs();
        Date date1 = null;
        Optional<TipoActivo> tipoActivo = null;
        try {
            //Se valida si todos los campos vienen vacios
            if ((tipoId == null || "".equals(tipoId))
                    && (fechaCompra == null || "".equals(fechaCompra))
                    && (serial == null || "".equals(serial))) {
                activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_BAD_REQUEST);
                return activoFijoRs;
            }

            //Si tipoId es correcto se valida si es un numero y si existe en la BD
            if (tipoId != null && !"".equals(tipoId)) {
                int id = Integer.parseInt(tipoId);
                tipoActivo = tipoActivoRepository.findById(id);
                if (tipoActivo.isEmpty()) {
                    activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_TIPO_ACTIVO_NOT_FOUND);
                    return activoFijoRs;
                }
            }

            //Se realiza tratamiento de fecha si es correcta
            if (fechaCompra != null && !"".equals(fechaCompra)) {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaCompra);
            }

            List<ActivoFijo> activoFijos = activoFijoRepository.findByTipoIdOrFechaCompraOrSerial(tipoActivo, date1, serial);
            if (!activoFijos.isEmpty()) {
                activoFijoRs.setActivoFijos(activoFijos);
                activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_OK);

                return activoFijoRs;
            }
            activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_NOT_FOUND);

        } catch (ParseException ex) {
            Logger.getLogger(ActivoFijoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_FECHA_BAD_REQUEST);
            return activoFijoRs;
        } catch (NumberFormatException ex) {
            Logger.getLogger(ActivoFijoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            activoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_TIPO_ID_BAD_REQUEST);
            return activoFijoRs;
        } catch (Exception ex) {
            Logger.getLogger(ActivoFijoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activoFijoRs;
    }

    @Override
    @Transactional(readOnly = false)
    public PutActivoFijoRs putActivoFijo(Integer id, PutActivoFijoRq putActivoFijoRq) {
        PutActivoFijoRs putActivoFijoRs = new PutActivoFijoRs();
        Date date1 = null;
        try {
            ActivoFijo activoFijo = activoFijoRepository.findByActivoId(id);
            if (activoFijo == null) {
                putActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_PUT_NOT_FOUND + id);
                return putActivoFijoRs;
            }

            //Se valida si todos los campos vienen vacios
            if ((putActivoFijoRq.getFechaBaja() == null || "".equals(putActivoFijoRq.getFechaBaja()))
                    && (putActivoFijoRq.getSerial() == null || "".equals(putActivoFijoRq.getSerial()))) {
                putActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_BAD_REQUEST);
                return putActivoFijoRs;
            }

            if (putActivoFijoRq.getSerial() != null && !"".equals(putActivoFijoRq.getSerial())) {
                activoFijo.setSerial(putActivoFijoRq.getSerial());
            }

            if (putActivoFijoRq.getFechaBaja() != null && !"".equals(putActivoFijoRq.getFechaBaja())) {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(putActivoFijoRq.getFechaBaja());
                if (date1.compareTo(activoFijo.getFechaCompra()) > 0 ) {
                    putActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_FECHA_BAJA_BAD_REQUEST);
                    return putActivoFijoRs;
                }
                activoFijo.setFechaBaja(date1);
            }

            activoFijoRepository.save(activoFijo);

            putActivoFijoRs.setNombreActivoFijo(activoFijo.getNombre());
            putActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_NO_CONTENT);

        } catch (ParseException ex) {
            Logger.getLogger(ActivoFijoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            putActivoFijoRs.setDescripcion(TipoRespuesta.MESSAGE_FECHA_BAD_REQUEST);
            return putActivoFijoRs;
        }
        return putActivoFijoRs;
    }

}
