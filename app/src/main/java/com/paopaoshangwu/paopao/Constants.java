package com.paopaoshangwu.paopao;

import android.Manifest;

/**
 * Created by zhaijie on 2017/2/7.
 */

public class Constants {
    public static final String CONVENIENT_STORE_URL = "/app/customer/shop/easyShop/nearby";
    //public static final String BASE_URL = "http://192.168.0.200:8080";
    public static final String BASE_URL = "http://124.165.205.15:8080";
    public static final String TAKEOUT_BANNER_URL = "/app/customer/home/slide";
    public static final String GOODS_URL = "/app/customer/shop/category";
    public static final String EVALUATED_URL = "/app/customer/shop/comment";
    public static final String TAKEOUT_URL = "/app/customer/shop/nearShop";
    public static final String SHOP_COLLECT_URL = "/app/customer/shop/collection/switch";
    public static final String IS_COLLECTION_URL = "/app/customer/shop/collection/isCollected";
    public static final String SORT_URL = "/app/customer/shop/shopCatory";
    public static final String ORDER_COMMIT_URL = "/app/customer/order/orderAdd";
    public static final String ALL_ADDRESS = "/app/customer/address/allAddress";
    public static final String ADD_ADDRESS = "/app/customer/address/addressAdd";
    public static final String DEL_ADDRESS = "/app/customer/address/delAddress";
    public static final String UPDATE_ADDRESS = "/app/customer/address/updateAddress";
    public static final String UPDATE_DEFAULT = "/app/customer/address/updateDefault";

    public static final String LOGIN = "/app/customer/login";
    public static final String REGISTER = "/app/customer/register";
    public static final String SELECTMEMBER = "/app/customer/member/selectMember";
    public static final String MEMBERINFO = "/app/customer/member/memberInfo";

    public static final String MY_COMMENT = "/app/customer/shop/comment/myComment";
    public static final String UPDATE_PW = "/app/customer/member/updatePwd";
    public static final String FORGET_WD = "/app/customer/member/forgetPwd";
    public static final String UPDATE_NAME = "/app/customer/member/updateName";
    public static final String ADD_COMPLAIN = "/app/customer/member/addComplain";
    public static final String MY_VOUCHER = "/app/customer/member/myVoucher";
    public static final String UPDATE_ICON = "/app/customer/member/updateIcon";

    public static final String COLLECTION = "/app/customer/shop/collection";
    public static final String ALL_ORDER = "/app/customer/order/allOrderDetails";
    public static final String ORDER_DETAILS = "/app/customer/order/orderDetails";

    public static final String DISCOUNT_URL = "/BackStage/mpactivity/discount";
    public static final String FULL_CUT_URL = "/BackStage/mpactivity/fullcut";
    public static final String HALF_PRICE_URL = "/BackStage/mpactivity/halfPrice";
    public static final String NEW_SPIKLE_URL = "/BackStage/mpactivity/newspike";
    public static final String WAY_WARD_EAT_URL = "/BackStage/mpactivity/waywardEat";


    public static final String[] NEED_PERMISSIONS = {

            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,

            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,

            Manifest.permission.READ_CONTACTS,

            Manifest.permission.READ_PHONE_STATE,

            Manifest.permission.CAMERA};//所需权限

}
