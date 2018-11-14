!function() {
    var citys = [{
        "CountryId": 1,
        "CountryName": "中国",
        "Province": [{
            "ProvinceId": 1,
            "ProvinceName": "北京市",
            "City": [{
                "CityId": 1,
                "CityName": "市辖区",
                "CountyList": [{
                    "CountyId": 1,
                    "CountyName": "东城区",
                    "CountyList1":[{
                        "County1":"11",
                        "County1Id":"11",
                    }]
                }]
            }]
        }]
    }];
    if (typeof define === "function") {
        define(citys)
    } else {
        window.YDUI_CITYS = citys
    }
} ();