package com.lmh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmh.bean.Teacher;
import com.lmh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LMH
 * @create 2019-12-16 23:44
 */

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/getAll")
    public String getAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //使用PageHelper的startPage(当前页码,每页的数量)方法进行分页;
        //紧跟这个方法的查询就是一个分页查询,没有紧跟的就不会分页
        PageHelper.startPage(pn,10);
        List<Teacher> teachers = teacherService.getAll();
        //model.addAttribute("teachers",teachers);

        //我们还可以使用更为强大的pageInfo对象,PageInfo包含了非常全面的分页属性
        //将查询的结果作为参数传入pageInfo的构造器中构造一个pageInfo对象,就可以获取总页数,当前页,每页显示数量等参数
        //如果需要连续显示几页,可以传入第二个参数int navigatePages:表示显示的连续分页的页数
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers,10);
        System.out.println("当前页码:"+pageInfo.getPageNum());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("每页的记录数:"+pageInfo.getPageSize());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("当前页的记录数:"+pageInfo.getSize());
        System.out.println("前一页:"+pageInfo.getPrePage());
        System.out.println("查询的结果"+pageInfo.getList());

        //可以获取连续分页的页面数组,包含了连续分页的所有页码,也可以在页面中获取
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        //将pageinfo这个对象存入隐含模型(request)
        model.addAttribute("info",pageInfo);
        return "success";
    }
}
