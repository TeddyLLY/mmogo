package com.smart.mmogo.controller.mongo;

import com.google.gson.Gson;
import com.smart.mmogo.bean.mongo.Employee;
import com.smart.mmogo.core.constant.CommonConst;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.service.mongo.EmployeeRepositoryService;
import com.smart.mmogo.service.mongo.EmployeeTemplateService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Demo with
 *  MongoRepository && MongoTemplate
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepositoryService employeeRepositoryService;
    @Autowired
    EmployeeTemplateService employeeTemplateService;





    /*
     * init with select
     */
    @RequestMapping("/employees/get")
    @ResponseBody
    public ModelAndView initPage(@RequestParam(value = "data",required = false) String jsonParams ) throws Exception{
        Employee paramVO = getParamVo(jsonParams);
        List<Employee> list = employeeRepositoryService.get(paramVO);

        ModelAndView mav = new ModelAndView("index");
        mav.getModel().put("list", list);
        return mav;
    }

    public Employee getParamVo(String jsonParams) throws Exception{
        Employee paramVO = new Employee();
        if(StringU.isNotEmpty(jsonParams)){
            JSONObject jsonObject =  new JSONObject(URLDecoder.decode(jsonParams, "UTF-8") );
            Object selectContent = jsonObject.get("selectContent");
            String selectField = jsonObject.get("selectField").toString();
            if( StringU.isNotEmpty(selectField) && StringU.isNotEmpty(selectContent) ){
                switch (selectField){
                    case "id":
                        paramVO.setId((String) selectContent);
                        return paramVO;
                    case "firstName":
                        paramVO.setFirstName((String) selectContent);
                        return paramVO;
                    case "lastName":
                        paramVO.setLastName((String) selectContent);
                        return paramVO;
                    case "job":
                        paramVO.setJob((String) selectContent);
                        return paramVO;
                    case "salary":
                        paramVO.setSalary(Integer.parseInt(selectContent.toString().trim()));
                        return paramVO;
                    case "internship":
                        paramVO.setInternship(Boolean.valueOf(selectContent.toString()));
                        return paramVO;
                    case "regularDate":
                        Date date=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(selectContent.toString());
                        paramVO.setRegularDate(date);
                        return paramVO;
                    default:
                        return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @RequestMapping("/employees/addEmployee")
    @ResponseBody
    public ModelAndView addEmployeePage() {
        ModelAndView mav = new ModelAndView("addEmployee");
        return mav;
    }

    @PostMapping("/employees/post")
    @ResponseBody
    public Integer addEmployee(@RequestBody Employee employee) {
        employeeTemplateService.post(employee);
        return CommonConst.STATUS_ON;
    }

    @RequestMapping("/employees/updateEmployee")
    @ResponseBody
    public ModelAndView updateEmployeePage(@RequestParam("data") String employeeJson) throws Exception{
        // Decode the URL-encoded JSON string
        String decodedJson = java.net.URLDecoder.decode(employeeJson, "UTF-8");
        // Parse the JSON string into a Java object
        // Assuming you have a corresponding Employee class
        Employee paramVO = new Gson().fromJson(decodedJson, Employee.class);

        //find by id
        Employee employee = employeeTemplateService.get(paramVO);

        ModelAndView mav = new ModelAndView("updateEmployee");
        mav.getModel().put("employee", employee);
        return mav;
    }

    @RequestMapping("/employees/put")
    @ResponseBody
    public Integer updateEmployee(@RequestBody Employee employee) {
        employeeTemplateService.put(employee);
        return CommonConst.STATUS_ON;
    }

    @RequestMapping("/employees/delete")
    @ResponseBody
    public Integer deleteEmployee(@RequestBody Employee employee) throws Exception{
        //delete by id
        employeeRepositoryService.delete(employee);
        return CommonConst.STATUS_ON;
    }

}
