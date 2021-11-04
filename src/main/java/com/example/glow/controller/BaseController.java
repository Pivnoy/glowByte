package com.example.glow.controller;

import com.example.glow.controller.dto.BaseData;
import com.example.glow.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

<<<<<<< HEAD
/**
 * @author Lagus Maksim, Makarev Evgenij
 * @version 1.0
 * Main controller for MongoDB database encapsulating all
 * get methods from multiple CRUD repositories and connecting
 * backend and local host server via mapping
 */
=======
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
@RestController
public class BaseController {

    private BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/base")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<BaseData> getBaseData(@RequestParam(name = "fio") String fio) {
        String customPredicate = fio.toLowerCase().trim();
        List<BaseData> res = baseService.getData().stream().filter(val -> val.getCustFio().toLowerCase().trim().equals(customPredicate)).collect(Collectors.toList());
        if (res.size() > 0) {
            return ResponseEntity.ok(res.get(0));
        }
        return ResponseEntity.ok(null);
    }
}
