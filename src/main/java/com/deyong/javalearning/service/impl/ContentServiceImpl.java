package com.deyong.javalearning.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.deyong.javalearning.controller.model.Content;
import com.deyong.javalearning.dao.IContentMapper;
import com.deyong.javalearning.service.IContentService;
import com.deyong.javalearning.util.DateUtil;

/**
 * 服务层
 *
 * @author dytong 童德勇 2019/3/26 18:29
 * @version 1.0
 * @since 1.0
 */
@Service("contentService")
public class ContentServiceImpl implements IContentService {

	@Resource
	private IContentMapper contentMapper;

	@Override
	public void add(Content content) {
		content.setLastModifyDate(DateUtil.getNowDateStr());
		content.setLastModifyTime(DateUtil.getNowTimeStr());
		contentMapper.add(content);
	}

	@Override
	public List<Content> selectAll() {
		List<Content> contents = contentMapper.selectAll();
		contents.forEach(content -> content.setLastModifyDate(content.getLastModifyDate()));
		return contents;
	}

	@Override
	public void deleteOne(Integer id) {
		contentMapper.deleteOne(id);
	}

	@Override
	public List<String> selectClass() {
		return contentMapper.selectClass();
	}

	@Override
	public List<Content> selectByWord(Content content) {
		List<Content> contents = contentMapper.selectByWord(content);
		contents.forEach(backData -> backData.setLastModifyDate(backData.getLastModifyDate()));
		return contents;
	}

	@Override
	public void update(Content content) {
		content.setLastModifyDate(DateUtil.getNowDateStr());
		content.setLastModifyTime(DateUtil.getNowTimeStr());
		contentMapper.update(content);
	}

}
