package com.example.btvn_15_09.controller;
import com.example.btvn_15_09.model.Category;
import com.example.btvn_15_09.service.iml.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("list", categoryService.finAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category) {
        categoryService.create(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormUpdate(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("category/update");
        modelAndView.addObject("category", categoryService.finById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id,
                         @ModelAttribute Category category) {
        Category c = categoryService.finById(id);
        if (c != null) {
            category.setId(id);
            categoryService.update(category);
        }
        return "redirect:/categories";
    }
}
