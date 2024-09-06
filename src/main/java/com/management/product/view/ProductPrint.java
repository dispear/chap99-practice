package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> productList) {
        System.out.println("====== All Product List ======");
        productList.forEach(System.out::println);
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {
        System.out.println("====== Option Product List ======");
        System.out.println("Option : " + searchCondition.getOption());
        productList.forEach(System.out::println);
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("===== Success ========");
        String successMessage = "";
        switch (successCode) {
            case "insert":
                successMessage = "신규 메뉴 등록이 완료되었습니다.";
                break;
            case "update":
                successMessage = "메뉴 수정이 완료되었습니다.";
                break;
            case "delete":
                successMessage = "메뉴 삭제가 완료되었습니다.";
                break;
        }

        System.out.println(successMessage);
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("======== Error ========");
        String errorMessage = "";
        switch (errorCode) {
            case "selectAllProductList":
                errorMessage = "selectAllProductList 조회 결과가 없습니다!!!";
                break;
            case "selectProductByCondition":
                errorMessage = "selectProductByCondition 조회 결과가 없습니다!!! ";
                break;
            case "insert":
                errorMessage = "신규 메뉴 등록에 실패했습니다.";
                break;
            case "update":
                errorMessage = "메뉴 수정을 실패했습니다.";
                break;
            case "delete":
                errorMessage = "메뉴 삭제를 실패했습니다.";
                break;
        }

        System.out.println(errorMessage);
    }

}
