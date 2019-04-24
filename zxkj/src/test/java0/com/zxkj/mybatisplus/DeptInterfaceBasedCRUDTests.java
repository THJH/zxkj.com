package com.zxkj.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxkj.dao.DeptDao;
import com.zxkj.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptInterfaceBasedCRUDTests {

    @Autowired
    private DeptDao deptDao;

    @Test
    public void contextLoads() {
        System.out.println(deptDao);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void insert(){
        Dept dept = new Dept(123,"123","123");
        int insertRes = deptDao.insert(dept);
        System.out.println(insertRes);
        //TODO 如何返回值为主键？？？？？？
    }

    ////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void update(){
        Dept dept = new Dept(123,"abc","abc");
        int updateRes = deptDao.updateById(dept);
        System.out.println(updateRes);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void deleteById() {
        int deleteRes = deptDao.deleteById(123);
        System.out.println(deleteRes);
    }
    @Test
    public void delete() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dname", "aa");
        int deleteRes = deptDao.delete(queryWrapper);
        System.out.println(deleteRes);
    }
    @Test
    public void delete3() {
        int deleteRes = deptDao.deleteBatchIds(Arrays.asList(1,2,3));
        System.out.println(deleteRes);
    }

    @Test
    public void delete4() {
        Map<String, Object> map = new HashMap<>();
        map.put("dname", "aa");
        int deleteRes = deptDao.deleteByMap(map);
        System.out.println(deleteRes);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void selectById() {
        Dept dept = deptDao.selectById(10);
        System.out.println(dept);
    }

    @Test
    public void selectOne() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dname", "aa");
        queryWrapper.eq("loc", "23");
        Dept dept = deptDao.selectOne(queryWrapper);
        System.out.println(dept);
    }


    @Test
    public void selectList() {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("dname", "%a%");
        List<Dept> deptList = deptDao.selectList(queryWrapper);
        deptList.forEach(System.out::println);
    }

    @Test
    public void selectBatchIds() {
        List<Dept> deptList = deptDao.selectBatchIds(Arrays.asList(10,30,40));
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("dname", "aa");
        map.put("loc", "23");
        List<Dept> deptList = deptDao.selectByMap(map);
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectPage1() {
        IPage<Dept> deptPage = deptDao.selectPage(new Page<>(2, 3), null);
        for (Dept dept : deptPage.getRecords()) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectPage2() {
        Wrapper<Dept> queryWrapper = new QueryWrapper<Dept>()
                .between("deptno", 20, 40)
                .like("dname", "%a%");
        IPage<Dept> empPage = deptDao.selectPage(new Page<>(1, 3), queryWrapper);
        for (Dept dept : empPage.getRecords()) {
            System.out.println(dept);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////
}
