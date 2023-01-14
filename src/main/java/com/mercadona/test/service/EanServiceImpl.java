package com.mercadona.test.service;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.repository.EanRepository;
import com.mercadona.test.utils.EanHandler;
import com.mercadona.test.utils.exceptions.CauseException;
import com.mercadona.test.utils.exceptions.ExceptionHandler;
import org.apache.commons.logging.Log;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EanServiceImpl implements EanService {

    private final static Logger logger = Logger.getLogger("com.mercadona.test.service.EanServiceImpl");

    private EanHandler eanHandler;
    @Autowired
    private EanRepository eanRepository;

    @Override
    public EanResponse getInformation(Ean ean) {
        try {
            eanHandler = new EanHandler();
            return eanHandler.toDomain(ean);
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
            throw new CauseException("Fallo al obtener la información del EAN");
        }
    }

    @Override
    public Ean insertEan(Ean ean) {
        try {
            Ean eanPersisted = eanRepository.save(ean);
            return eanPersisted;
        } catch (DataIntegrityViolationException ex) {
            logger.severe(ex.getMessage());
            throw new CauseException("Fallo de integridad al introducir elemento en la base de datos");
        }
    }

    @Override
    public List<Ean> findAll() {
        return eanRepository.findAll();
    }

    @Override
    @Transactional
    public Ean updateEan(String updateEan, String newEan) {
        try {
            Ean eanPersisted = eanRepository.findByEanNumber(updateEan);
            eanPersisted.setEanNumber(newEan);
            return eanRepository.save(eanPersisted);
        } catch (DataIntegrityViolationException ex) {
            logger.severe(ex.getMessage());
            throw new CauseException("Fallo de integridad al actualizar el EAN.");
        }
    }

    @Override
    @Transactional
    public void deleteEan(String ean) {
        try {
            Ean eanPersisted = eanRepository.findByEanNumber(ean);
            eanRepository.delete(eanPersisted);
        } catch (DataIntegrityViolationException ex) {
            logger.severe(ex.getMessage());
            throw new CauseException("Fallo al intentar borrar EAN");
        }
    }
}
