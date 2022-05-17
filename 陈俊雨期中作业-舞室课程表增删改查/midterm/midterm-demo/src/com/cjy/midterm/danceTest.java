package com.cjy.midterm;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.cjy.pojo.Course;
import org.junit.Test;

import javax.sql.DataSource;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class danceTest {
    /**
     * 查讯所有课程
     */
    @Test
    public void testSelectAll() throws Exception {

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/大二下/软工实训/作业/midterm/midterm-demo/src/com/cjy/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        //定义sql
        String sql="select * from course;";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        Course course=null;
        List<Course> courses=new ArrayList<>();
        //处理结果
        while (rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String danceType = rs.getString("dance_type");
            String song = rs.getString("song");
            String time = rs.getString("time");
            String teacher = rs.getString("teacher");

            //封装对象
            course=new Course();
            course.setId(id);
            course.setDanceType(danceType);
            course.setSong(song);
            course.setTime(time);
            course.setTeacher(teacher);

            //装载集合
            courses.add(course);
        }
        System.out.println(courses);
        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * 添加课程
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        //接受页面提交的参数
        String danceType="breaking";
        String song="break";
        String time="23:30-24:30";
        String teacher="琼琼";

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/大二下/软工实训/作业/midterm/midterm-demo/src/com/cjy/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        //定义sql
        String sql="insert into course (dance_type, song, time, teacher) values(?,?,?,?);";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,danceType);
        pstmt.setString(2,song);
        pstmt.setString(3,time);
        pstmt.setString(4,teacher);

        //执行sql
        int count = pstmt.executeUpdate();//影响的行数

        //处理结果
        System.out.println(count>0);


        //释放资源
        pstmt.close();
        conn.close();
    }

    /**
     * 修改课程
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        //接受页面提交的参数
        String danceType="waacking";
        String song="broke";
        String time="21:00-22:30";
        String teacher="颖颖";
        int id=4;

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/大二下/软工实训/作业/midterm/midterm-demo/src/com/cjy/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        //定义sql
        String sql="update course set dance_type=?,song=?,time=?,teacher=? where id=?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,danceType);
        pstmt.setString(2,song);
        pstmt.setString(3,time);
        pstmt.setString(4,teacher);
        pstmt.setInt(5,id);

        //执行sql
        int count = pstmt.executeUpdate();//影响的行数

        //处理结果
        System.out.println(count>0);


        //释放资源
        pstmt.close();
        conn.close();
    }

    /**
     * 删除课程
     * @throws Exception
     */
    @Test
    public void testDeleteById() throws Exception {
        //接受页面提交的参数
        int id=5;

        Properties prop=new Properties();
        prop.load(new FileInputStream("D:/大二下/软工实训/作业/midterm/midterm-demo/src/com/cjy/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        //定义sql
        String sql="delete from course where id=?;";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置参数
        pstmt.setInt(1,id);

        //执行sql
        int count = pstmt.executeUpdate();//影响的行数

        //处理结果
        System.out.println(count>0);


        //释放资源
        pstmt.close();
        conn.close();
    }
}
