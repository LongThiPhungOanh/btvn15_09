package com.example.btvn_15_09.controller;
import com.example.btvn_15_09.model.Category;
import com.example.btvn_15_09.model.Product;
import com.example.btvn_15_09.service.iml.CategoryService;
import com.example.btvn_15_09.service.iml.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Value("${upload}")
    private String upload;


    @ModelAttribute("list")
    public List<Category> getListCategory() {
        return categoryService.finAll();
    }
//cũ
    @GetMapping("/list/{pageNum}/{pageSize}")
    public String showList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize, Model model) {
        //ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("listProduct", productService.getPageAll(pageNum, pageSize));
        float size = productService.finAll().size();
        float result = size / pageSize;
        model.addAttribute("result", result);
        model.addAttribute("list", categoryService.finAll());
        return "product/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product,
                         @RequestParam("category_id") Long id) {
        Category category = categoryService.finById(id);
        if (product.getImage().getSize() != 0) {
            String name = product.getImage().getOriginalFilename();
            try {
                FileCopyUtils.copy(product.getImage().getBytes(),
                        new File(upload + name));
            } catch (Exception e) {
                e.printStackTrace();
            }
            product.setPath(name);
        }
        product.setCategory(category);
        productService.create(product);
        return "redirect:/products/list/1/10";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormUpdate(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product/update");
        modelAndView.addObject("product", productService.finById(id));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Product product,
                         @PathVariable("id") Long id,
                         @RequestParam("category_id") Long c_id) {
        Category category = categoryService.finById(c_id);
        Product p = productService.finById(id);
        if (p != null) {
            if (product.getImage().getSize() != 0) {
                String name = product.getImage().getOriginalFilename();
                try {
                    FileCopyUtils.copy(product.getImage().getBytes(),
                            new File(upload + name));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                product.setPath(name);
            } else {
                product.setPath(p.getPath());
            }
            product.setCategory(category);
            productService.update(product);
        }
        return "redirect:/products/list/1/10";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/products/list/1/10";
    }
    @PostMapping("/search")
    public ModelAndView search (@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/product/search");
            List<Product> list = productService.searchByName(name);
            modelAndView.addObject("list1", list);
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public String view (Model model,@PathVariable("id") Long id){
        model.addAttribute("product", productService.finById(id));
        return "/product/view";
    }
    @PostMapping("/searchCategory")
    public String searchCategory(Model model,@RequestParam("category_id") Long idCate){
        //Category c = categoryService.finById(idCate);
            List<Product> list1 = productService.searchByCategory(idCate);
            model.addAttribute("listP", list1);
        return "/product/searchByCate";
    }
}
