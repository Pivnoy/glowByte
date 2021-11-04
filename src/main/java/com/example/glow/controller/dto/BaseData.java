package com.example.glow.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class BaseData {

    private String custFio;
    private Long custId;
<<<<<<< HEAD
    private Date custBirth;
=======
    private Long custBirth;
>>>>>>> d89e0f175f4666bd0df5121d7a988e3b016e233f
    private String custInn;

}
