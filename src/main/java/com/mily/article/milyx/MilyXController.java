package com.mily.article.milyx;

import com.mily.article.milyx.category.CategoryService;
import com.mily.article.milyx.category.entity.FirstCategory;
import com.mily.article.milyx.category.entity.SecondCategory;
import com.mily.base.rq.Rq;
import com.mily.base.rsData.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/milyx")
public class MilyXController {
    private final CategoryService categoryService;
    private final MilyXService milyXService;
    private final Rq rq;

    @PreAuthorize("isAnonymous()")
    @GetMapping("")
    public String showMilyX (Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "") String kw, @RequestParam(defaultValue = "all") String kwType) {
        return "mily/milyx/milyx_index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String create (Model model) {
        List<FirstCategory> firstCategories = categoryService.getFirstCategories();
        model.addAttribute("firstCategories", firstCategories);
        return "mily/milyx/milyx_create";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String create (@RequestParam int firstCategory, @RequestParam String secondCategory, @RequestParam String subject, @RequestParam String body) {
        FirstCategory fc = categoryService.findById(firstCategory);
        SecondCategory sc = categoryService.findScById(Integer.parseInt(secondCategory));

        RsData<MilyX> rsData = milyXService.create(rq.getMilyUser(), fc, sc, subject, body);
        return "redirect:/mily/milyx";
    }

    @GetMapping("/secondCategories")
    public ResponseEntity<List<SecondCategory>> validateId(@RequestParam(value = "firstCategoryId") int firstCategoryId) {
        List<SecondCategory> sc = categoryService.findByFirstCategoryId(firstCategoryId);

        return ResponseEntity.ok().body(sc);
    }

    @AllArgsConstructor
    @Getter
    public static class CreateForm {
        private FirstCategory firstCategory;
        private SecondCategory secondCategory;
        private String subject;
        private String body;
    }
}