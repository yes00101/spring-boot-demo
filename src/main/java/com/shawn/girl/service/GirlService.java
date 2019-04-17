package com.shawn.girl.service;

import com.shawn.girl.Exception.GirlException;
import com.shawn.girl.ResultEnum.ResultEnum;
import com.shawn.girl.domain.Result;
import com.shawn.girl.responsitory.GirlRespository;
import com.shawn.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(15);
        girlRespository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(12);
        girlB.setCupSize("C");
        girlRespository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl= girlRespository.findOne(id);
        Integer age = girl.getAge();
        if (age <10){
            //返回"你还在上小学" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16){
            //返回"你可能还在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        // 如果>16岁，加钱
        //...
    }

    /**
     * 通过id 查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRespository.findOne(id);
    }
}
