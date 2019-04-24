package com.zxkj.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxkj.dao.EmpDao;
import com.zxkj.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpInterfaceBasedCRUDTests {

    @Autowired
    private EmpDao empDao;

    @Test
    public void contextLoads() {
        System.out.println(empDao);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void insert(){
        Emp emp = new Emp(1237,"zhangsan","CLERK",7788, LocalDate.of(1999,9,21),
                new BigDecimal(1200),new BigDecimal(300),20);
        int insertRes = empDao.insert(emp);
        System.out.println(insertRes);
        System.out.println(emp.getEmpno());//直接获取插入数据返回的自增主键值
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void update(){
        Emp emp = new Emp(1237,"张三","SALES",7698, LocalDate.of(2018,9,21),
                new BigDecimal(1300),new BigDecimal(400),20);
        int updateRes = empDao.updateById(emp);
        System.out.println(updateRes);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void deleteById() {
        int deleteRes = empDao.deleteById(1234);
        System.out.println(deleteRes);
    }

    @Test
    public void delete() {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ename", "张三");
        int deleteRes = empDao.delete(queryWrapper);
        System.out.println(deleteRes);
    }

    @Test
    public void delete3() {
        int deleteRes = empDao.deleteBatchIds(Arrays.asList(1236, 1237));
        System.out.println(deleteRes);
    }

    @Test
    public void delete4() {
        Map<String, Object> map = new HashMap<>();
        map.put("ename", "张三");
        int deleteRes = empDao.deleteByMap(map);
        System.out.println(deleteRes);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void selectById() {
        Emp emp = empDao.selectById(7788);
        System.out.println(emp);
    }

    @Test
    public void selectOne() {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ename", "scott");
        queryWrapper.eq("deptno", "20");
        Emp emp = empDao.selectOne(queryWrapper);
        System.out.println(emp);
    }


    @Test
    public void selectList() {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("ename", "%AR%");
        List<Emp> emps = empDao.selectList(queryWrapper);
        emps.forEach(System.out::println);
    }

    @Test
    public void selectBatchIds() {
        List<Emp> empList = empDao.selectBatchIds(Arrays.asList(7369, 7782, 7844));
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("ename", "zhangsan");
        map.put("job", "clerk");
        List<Emp> empList = empDao.selectByMap(map);
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void selectPage1() {
        IPage<Emp> empPage = empDao.selectPage(new Page<>(2, 2), null);
        for (Emp emp : empPage.getRecords()) {
            System.out.println(emp);
        }
    }

    @Test
    public void selectPage2() {
        Wrapper<Emp> queryWrapper = new QueryWrapper<Emp>()
                .between("sal", 1500, 3500)
                .like("ename", "%A%");
        IPage<Emp> empPage = empDao.selectPage(new Page<>(1, 3), queryWrapper);
        for (Emp emp : empPage.getRecords()) {
            System.out.println(emp);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////
}
