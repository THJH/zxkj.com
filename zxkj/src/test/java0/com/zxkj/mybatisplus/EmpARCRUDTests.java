package com.zxkj.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxkj.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpARCRUDTests {

    @Test
    public void insert() {
        Emp emp = new Emp(1230, "zhangsan", "CLERK", 7788, LocalDate.of(1999, 9, 21), new BigDecimal(1200), new BigDecimal(300), 20);
        boolean insertRes = emp.insert();
        System.out.println(insertRes);
        System.out.println(emp.getEmpno());//直接获取插入数据返回的自增主键值
    }

    @Test
    public void update() {
        Emp emp = new Emp(1230, "张三", "SALES", 7521, LocalDate.of(2018, 9, 21), new BigDecimal(1400), new BigDecimal(400), 10);
        boolean updateRes = emp.updateById();
        System.out.println(updateRes);
    }

    @Test
    public void delete() {
        Emp emp = new Emp();
        boolean deleteRes1 = emp.deleteById(1230);
        System.out.println(deleteRes1);
        emp.setEmpno(1231);
        boolean deleteRes2 = emp.deleteById();
        System.out.println(deleteRes2);
    }

    @Test
    public void selectById() {
        Emp emp = new Emp();
        Emp emp1 = emp.selectById(7788);
        System.out.println(emp1);
        emp.setEmpno(7788);
        Emp emp2 = emp.selectById();
        System.out.println(emp2);
    }

    @Test
    public void select2() {
        Emp emp = new Emp();
        List<Emp> empList = emp.selectAll();
        for (Emp item : empList) {
            System.out.println(item);
        }
    }

    @Test
    public void select3() {
        QueryWrapper<Emp> queryWrapper = new QueryWrapper<Emp>().like("ename", "%ar%");
        List<Emp> empList = new Emp().selectList(queryWrapper);
        for (Emp item : empList) {
            System.out.println(item);
        }
    }

    @Test
    public void select4() {
        Wrapper<Emp> queryWrapper = new QueryWrapper<Emp>().lt("sal", 1500);
        IPage<Emp> empPage = new Emp().selectPage(new Page<>(2, 2), queryWrapper);
        for (Emp emp : empPage.getRecords()) {
            System.out.println(emp);
        }
        System.out.println(empPage.getTotal());
        System.out.println(empPage.getCurrent());
        System.out.println(empPage.getPages());
        System.out.println(empPage.getSize());
        System.out.println(empPage.offset());
    }

}
