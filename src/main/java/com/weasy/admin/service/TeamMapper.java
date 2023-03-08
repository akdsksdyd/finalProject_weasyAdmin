package com.weasy.admin.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.weasy.admin.command.TeamVO;
import com.weasy.admin.util.Criteria;

@Mapper
public interface TeamMapper {
	
	public ArrayList<TeamVO> getList(@Param("cri")Criteria cri);
	public int getTotal(@Param("cri")Criteria cri);
}
