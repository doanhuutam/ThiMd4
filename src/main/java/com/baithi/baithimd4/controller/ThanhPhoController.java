package com.baithi.baithimd4.controller;

import com.baithi.baithimd4.model.QuocGia;
import com.baithi.baithimd4.model.ThanhPho;
import com.baithi.baithimd4.service.quocgia.IQuocGiaService;
import com.baithi.baithimd4.service.thanhpho.IThanhphoService;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ThanhPhoController {
    @Autowired
    IThanhphoService iThanhphoService;

    @Autowired
    IQuocGiaService iQuocGiaService;

    @ModelAttribute("datnuoc")
    public Iterable<QuocGia> list() {
        return iQuocGiaService.findByQuocGia();
    }

    @GetMapping("/home")
    public ModelAndView listCity() {
        Iterable<ThanhPho> cities = iThanhphoService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/home");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new ThanhPho());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("city") ThanhPho thanhPho) {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        iThanhphoService.save(thanhPho);
        modelAndView.addObject("message", "New City created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<ThanhPho> city = iThanhphoService.findById(id);
        if (city.isPresent()) { // kiểm tra xem dữ liệu có null không
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("city") ThanhPho thanhPho) {
        iThanhphoService.save(thanhPho);
        return new ModelAndView("redirect:home");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<ThanhPho> city = iThanhphoService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public ModelAndView deleteCity(@ModelAttribute("city") ThanhPho city) {
        iThanhphoService.delete(city.getId());
        return new ModelAndView("redirect:home");
    }
    @GetMapping("/view/{id}")
    public ModelAndView showFormView(@PathVariable Long id) {
        Optional<ThanhPho> city = iThanhphoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/views");
        modelAndView.addObject("city",city.get());
        return modelAndView;
    }




}
