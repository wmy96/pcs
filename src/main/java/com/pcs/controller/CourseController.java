package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.Course;
import com.pcs.pojo.PersonCourse;
import com.pcs.service.ICourseService;
import com.pcs.service.IPersonCourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Resource
	private ICourseService courseService;
	@Resource
	private IPersonCourseService personCourseService;

	/**
	 * 获取单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/selectByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Course selectByPrimaryKey(@RequestBody Course course) {
		return this.courseService.selectByPrimaryKey(course.getcId());
	}

	/**
	 * 删除单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/deleteByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody Course course) {
		// 删除cId删除personCourse
		this.personCourseService.deleteBycId(course.getcId());
		return this.courseService.deleteByPrimaryKey(course.getcId());
	}

	/**
	 * 修改单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/updateByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody Course course) {
		return this.courseService.updateByPrimaryKeySelective(course);
	}

	/**
	 * 添加单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/insert.do", method = { RequestMethod.POST })
	public @ResponseBody Course insertSelective(@RequestBody Course course) {

		Integer res = this.courseService.insertSelective(course);
		if (res > 0) {
			Course course1 = this.courseService.selectBycNumber(course.getcNumber());
			Integer cId = course1.getcId();
			Integer peId = course.getPeId();
			// 向personCourse插入一条记录
			PersonCourse pc = new PersonCourse();
			pc.setPeId(peId);
			pc.setcId(cId);
			pc.setcId(cId);
			pc.setValue(0);
			pc.setStatus(1);
			Integer pc_res = this.personCourseService.insertSelective(pc);
			if (pc_res > 0) {
				return course1;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 查找全部课程信息
	 */
	@RequestMapping("/findAll.do")
	public @ResponseBody List<Course> findAll() {
		return this.courseService.findAll();
	}
}