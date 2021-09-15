package com.baithi.baithimd4.service.quocgia;

import com.baithi.baithimd4.repository.IQuocGiaropository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuocGiaService implements IQuocGiaService {
    @Autowired
    IQuocGiaropository iQuocGiaropository;
    @Override
    public Iterable findByQuocGia() {
        return iQuocGiaropository.findAll();
    }
}
