package com.shawn.girl.controller;

import com.shawn.girl.Exception.GirlException;
import com.shawn.girl.domain.Girl;
import com.shawn.girl.domain.Result;
import com.shawn.girl.responsitory.GirlRespository;
import com.shawn.girl.service.GirlService;
import com.shawn.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRespository girlRespository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("方法执行了");
        return girlRespository.findAll();
    }

    /**
     * 添加一个女生
     */
    /*@PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cup, @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cup);
        Girl save = girlRespository.save(girl);
        return save;
    }*/
    @PostMapping(value = "/girls")
   public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
       girl.setAge(girl.getAge());
       girl.setCupSize(girl.getCupSize());
       return ResultUtil.success(girlRespository.save(girl));
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        Girl result = girlRespository.findOne(id);
        return result;
    }
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam(value = "cupSize") String cupSize ,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        Girl result = girlRespository.save(girl);
        return result;
    }
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGilr(@PathVariable("id") Integer id){
        girlRespository.delete(id);
    }

    @GetMapping("/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    @GetMapping("/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
