package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.model.response.ApiResponse;

public interface BaseService {

    ApiResponse SUCCESS = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse SUCCESS_V2 = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse CARD_EXIST = new ApiResponse("bu card mavjud", false, -100);
    ApiResponse ERROR_DELETE = new ApiResponse("o`chirishda xatolik", false, -101);
}



