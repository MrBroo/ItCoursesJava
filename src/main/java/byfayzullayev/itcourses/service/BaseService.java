package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.model.response.ApiResponse;

public interface BaseService {

    ApiResponse SUCCESS = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse SUCCESS_V2 = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse USER_EXIST = new ApiResponse("bu username allaqachon mavjud", false, -100);
    ApiResponse USER_NOT_FOUND = new ApiResponse("bu user topilmadi", false, -101);
    ApiResponse CARD_EXIST = new ApiResponse("Bunday card allaqachon mavjud", false, -101);
    ApiResponse ERROR_DELETE = new ApiResponse("o`chirishda xatolik", false, -101);

}