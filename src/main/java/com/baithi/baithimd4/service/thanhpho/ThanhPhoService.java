package com.baithi.baithimd4.service.thanhpho;

import com.baithi.baithimd4.model.ThanhPho;
import com.baithi.baithimd4.repository.IThanhphoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ThanhPhoService implements IThanhphoService {
    @Autowired
    IThanhphoRepository iThanhphoRepository;
    @Override
    public Iterable<ThanhPho> findAll() {
        return iThanhphoRepository.findAll();
    }

    @Override
    public Optional<ThanhPho> findById(Long id) {
        return iThanhphoRepository.findById(id);
    }

    @Override
    public ThanhPho save(ThanhPho thanhPho) {
        return iThanhphoRepository.save(thanhPho);
    }

    @Override
    public void delete(Long id) {
iThanhphoRepository.deleteById(id);
    }
}
