package com.stupid.service;

import com.stupid.dao.ApplicationDao;
import com.stupid.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Peng, Dingguo e092201
 * @email: Dingguo.Peng@mastercard.com
 * @date: 6/26/2019 6:45 PM
 */
@Service
public class ApplicationServise {
    @Autowired
    private ApplicationDao applicationDao;
    public R findAll() {
        List<Map> list = applicationDao.findAll();
        return R.ok().put("list",list);
    }
}